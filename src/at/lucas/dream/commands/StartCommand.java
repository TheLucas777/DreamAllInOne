package at.lucas.dream.commands;

import at.lucas.dream.challenges.DeathSwap;
import at.lucas.dream.extras.Timer;
import at.lucas.dream.utils.getTexts;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StartCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("dream.*")||p.hasPermission("dream.start")||p.hasPermission("dream")||p.isOp()){
                DeathSwap deathSwap = new DeathSwap();
                deathSwap.onDeathSwap();
                Timer.onTimer();
                Bukkit.broadcastMessage(getTexts.getPrefix()+"§a"+p.getName()+" has started the Challenge");
            }
        }


        return false;
    }
}
