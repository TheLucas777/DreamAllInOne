package at.lucas.dream.extras;

import at.lucas.dream.main.Main;
import at.lucas.dream.utils.getGame;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Timer {
    public static int timerid;
    public static Integer timeins;

    public static void onTimer() {
        timeins = 0;
        if(getGame.Timer().equals(true)){
            timerid = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), () -> {
                timeins = timeins + 1;


                TimeZone tz = TimeZone.getTimeZone("CEST");
                SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
                df.setTimeZone(tz);
                String time = df.format(new Date(timeins * 1000));
                for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§6§l" + time));
                }


            }, 20, 20).getTaskId();
        }

    }

    public static void cancleTimer() {
        Bukkit.getScheduler().cancelTask(timerid);

    }
}

