package com.xir.NHUtilities.config;

import static com.xir.NHUtilities.config.Config.ConfigLog;
import static com.xir.NHUtilities.config.Config.cfgDirPath;
import static com.xir.NHUtilities.config.Config.minecraftHome;
import static com.xir.NHUtilities.main.ReferencedInfo.isDevEnvironment;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import org.jetbrains.annotations.NotNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;

public class ResetLangManager {

    private static final Path mcPath = minecraftHome().toPath();
    private static final File Lang_Backup = mcPath.resolve("Lang_Backup")
        .toFile();
    private static final File LangManagerFile = cfgDirPath.resolve("LangManagerFile.json")
        .toFile();

    private static final File sourceLang_CN = mcPath.resolve("Lang_Backup")
        .resolve("GregTech_zh_CN.lang")
        .toFile();
    private static final File sourceLang_US = mcPath.resolve("Lang_Backup")
        .resolve("GregTech.lang")
        .toFile();
    private static final File targetLang_CN = mcPath.resolve("GregTech_zh_CN.lang")
        .toFile();
    private static final File targetLang_US = mcPath.resolve("GregTech.lang")
        .toFile();

    static {
        if (!Lang_Backup.exists()) {
            boolean created = Lang_Backup.mkdirs();
            if (created) {
                ConfigLog.info("Lang_Backup created: {}", Lang_Backup.getAbsolutePath());
            } else {
                ConfigLog.warn("An error occurred on creating Lang_Backup dir: {}", Lang_Backup.getAbsolutePath());
            }
        }
    }

    public static void checkInit(String[] listeningMods) throws IOException {

        if (!sourceLang_CN.exists()) {
            ConfigLog.warn("lang files not found");
            return;
        }

        LinkedHashMap<String, String> loadedMods = getLoadedMods(listeningMods);
        // generate file
        if (!LangManagerFile.exists()) {
            ConfigLog.info("Need to create a manager file");
            toResetLang(loadedMods);
            return;
        }

        // in dev environment always to reset lang files
        if (isDevEnvironment) {
            ConfigLog.info("Current in dev env, always to reset lang files.");
            toResetLang(loadedMods);
            return;
        }

        // check mod whether in managed or version updated
        LinkedHashMap<String, String> managerFileMods = getFileFromJson(LangManagerFile);
        for (String mod : listeningMods) {
            boolean key = loadedMods.containsKey(mod) && !managerFileMods.containsKey(mod);
            boolean value = !Objects.equals(loadedMods.get(mod), managerFileMods.get(mod));
            if (key || value) {
                ConfigLog.info("Need to reset lang file");
                toResetLang(loadedMods);
            }
        }

    }

    private static void toResetLang(LinkedHashMap<String, String> loadedMods) throws IOException {
        try {
            Files.copy(sourceLang_CN.toPath(), targetLang_CN.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(sourceLang_US.toPath(), targetLang_US.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            ConfigLog.warn("An error occurred while replacing the language file.");
        }
        saveFileToJson(LangManagerFile, loadedMods);
    }

    private static @NotNull LinkedHashMap<String, String> getLoadedMods(String @NotNull [] list) {
        Map<String, ModContainer> loaderModList = Loader.instance()
            .getIndexedModList();
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        for (String mod : list) {
            if (loaderModList.containsKey(mod)) {
                map.put(
                    mod,
                    loaderModList.get(mod)
                        .getVersion());
            }
        }
        return map;
    }

    @SuppressWarnings("SameParameterValue")
    private static void saveFileToJson(File file, LinkedHashMap<String, String> map) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting()
            .create();
        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(map, writer);
        }
    }

    @SuppressWarnings("SameParameterValue")
    private static LinkedHashMap<String, String> getFileFromJson(File file) throws IOException {
        Gson gson = new GsonBuilder().create();
        try (FileReader reader = new FileReader(file)) {
            return gson.fromJson(reader, new TypeToken<LinkedHashMap<String, String>>() {}.getType());
        }
    }

}
