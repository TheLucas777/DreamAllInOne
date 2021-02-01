package at.lucas.dream.listeners;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.io.File;

public class DeathListener implements Listener {
    public void onDeath(PlayerDeathEvent e){
        File file = new File("plugins/DreamAllInOne/settings.yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        if(config.getBoolean("DeathSwap")){
            Player p = e.getEntity();
            Bukkit.broadcastMessage("§6§l"+p.getName()+" lost. Good Game!");
            config.set("DeathSwap", false);
        }

    }
}
