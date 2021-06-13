package at.lucas.dream.utils;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class getGame {
    private static File file = new File("plugins/DreamAllInOne/settings.yml");
    private static YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

    public static Object Deathswap(){
        return config.get("DeathSwap");
    }
    public static Object Timer() {return config.get("Timer");}

}
