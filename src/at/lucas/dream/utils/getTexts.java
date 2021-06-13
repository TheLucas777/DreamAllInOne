package at.lucas.dream.utils;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class getTexts {
    private static File configtxt = new File("plugins/DreamAllInOne/Texts.yml");
    private static YamlConfiguration confittxtyml = YamlConfiguration.loadConfiguration(configtxt);
    public static String getPrefix(){
        String prefix = confittxtyml.getString("PREFIX");
        return ChatColor.translateAlternateColorCodes('&', prefix);
    }

    public static void save(){
        try {
            confittxtyml.save(configtxt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
