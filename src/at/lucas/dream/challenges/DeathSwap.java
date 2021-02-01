package at.lucas.dream.challenges;

import at.lucas.dream.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Collection;

public class DeathSwap {
    File file = new File("plugins/DreamAllInOne/settings.yml");
    YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
    public void onDeathSwap(){
        if(config.getBoolean("DeathSwap")){
            Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new Runnable()
            {
                int time = 10; //or any other number you want to start countdown from

                @Override
                public void run()
                {
                    if (this.time == 0)
                    {
                       Object[] online = Bukkit.getOnlinePlayers().toArray();
                        Location p1location = ((Player) online[0]).getLocation();
                        Location p2location = ((Player) online[1]).getLocation();
                        ((Player) online[0]).teleport(p2location);
                        ((Player) online[1]).teleport(p1location);
                        onDeathSwap();
                        return;
                    }
                    if(time <= 10){
                        Bukkit.broadcastMessage("§c§lSwap in "+time+" seconds!!");
                    }


                    this.time--;
                }
            }, 0L, 20L);
        }else return;


    }
}
