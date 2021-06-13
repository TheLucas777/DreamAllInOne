package at.lucas.dream.utils;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class setGame {
    private static File file = new File("plugins/DreamAllInOne/settings.yml");
    private static YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

    public static void setDeathswap(Boolean onoff) {
        config.set("DeathSwap", onoff);
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
