package at.lucas.dream.main;

import at.lucas.dream.commands.SettingsCommand;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Main extends JavaPlugin {
    File configtxt = new File("plugins/DreamAllInOne/Texts.yml");
    YamlConfiguration confittxtyml = YamlConfiguration.loadConfiguration(configtxt);

    @Override
    public void onEnable() {
        onConfig();
        System.out.println("[DreamAllInOne] Plugin started");

        //Commands
        getCommand("settings").setExecutor(new SettingsCommand());
    }

    @Override
    public void onDisable() {
        System.out.println("[DreamAllInOne] Plugin stopped");
    }
    public void onConfig(){
        if(!(configtxt.exists())){
            try {
                configtxt.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            confittxtyml.set("PREFIX","§6[§3DreamAllInOne§6]§r ");
        }else return;
    }
}
