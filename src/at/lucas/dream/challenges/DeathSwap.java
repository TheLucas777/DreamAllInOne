package at.lucas.dream.challenges;

import at.lucas.dream.main.Main;
import at.lucas.dream.utils.getGame;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class DeathSwap {
    File file = new File("plugins/DreamAllInOne/settings.yml");
    YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
    public static Integer deathswapid;
    public void onDeathSwap(){
        Object[] online = Bukkit.getOnlinePlayers().toArray();
        if(getGame.Deathswap().equals(true)){
            if(!(online.length == 2)){
                Bukkit.broadcastMessage("df");
            }
            deathswapid = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new Runnable()
            {
                int time = 20; //or any other number you want to start countdown from

                @Override
                public void run()
                {
                    if (this.time == 0)
                    {
                       if(getGame.Deathswap().equals(true)) {
                            Object[] online = Bukkit.getOnlinePlayers().toArray();
                            Location p1location = ((Player) online[0]).getLocation();
                            Location p2location = ((Player) online[1]).getLocation();
                            ((Player) online[0]).teleport(p2location);
                            ((Player) online[1]).teleport(p1location);

                            if (getGame.Deathswap().equals(true)) {
                                this.time = 20;
                            } else return;

                            return;
                        }return;
                    }
                    if(time <= 10){
                        if(getGame.Deathswap().equals(true)) {
                            Bukkit.broadcastMessage("§c§lSwaping in "+time+" seconds!!");
                        }
                    }


                    this.time--;
                }
            }, 0L, 20L).getTaskId();

        }else return;

    }
    public static void cancleDeathswap(){
        if(deathswapid == null){
            return;
        }
        Bukkit.getScheduler().cancelTask(deathswapid);
    }
}
