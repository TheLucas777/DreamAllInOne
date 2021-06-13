package at.lucas.dream.main;

import at.lucas.dream.commands.SettingsCommand;
import at.lucas.dream.commands.StartCommand;
import at.lucas.dream.commands.StopCommand;
import at.lucas.dream.listeners.DeathListener;
import at.lucas.dream.utils.LicenseCheck;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Main extends JavaPlugin {
    private static Main instance;
    public Plugin plugin;
    File configtxt = new File("plugins/DreamAllInOne/Texts.yml");
    YamlConfiguration confittxtyml = YamlConfiguration.loadConfiguration(configtxt);

    @Override
    public void onEnable() {
        instance = this;
        PluginManager pluginManager;
        PluginManager pm = Bukkit.getPluginManager();
        onConfig();
        System.out.println("[DreamAllInOne] Plugin started");

        //Commands
        getCommand("settings").setExecutor(new SettingsCommand());
        getCommand("dstart").setExecutor(new StartCommand());
        getCommand("dstop").setExecutor(new StopCommand());

        //Listeners
        pm.registerEvents(new SettingsCommand(), this);
        pm.registerEvents(new DeathListener(), this);

        //Files
        LicenseCheck.createLicense();
        if(!LicenseCheck.checkLicense()){
            Bukkit.shutdown();
        }
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
            confittxtyml.set("PREFIX","&6[&3DreamAllInOne&6]&r ");
            try {
                confittxtyml.save(configtxt);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else return;
    }

    public static Main getPlugin() {
        return instance;
    }
}
