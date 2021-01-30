package at.lucas.dream.main;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin {
    File configtxt = new File("plugins/DreamAllInOne/Texts.yml");
    YamlConfiguration confittxtyml = YamlConfiguration.loadConfiguration(configtxt);

    @Override
    public void onEnable() {
        onConfig();
        System.out.println("[DreamAllInOne] Plugin started");
    }

    @Override
    public void onDisable() {

    }
    public void onConfig(){
        if(!(configtxt.exists())){
            configtxt.mkdirs();
            confittxtyml.set("PREFIX","§6[§3DreamAllInOne§6]§r ");
        }else return;
    }
}
