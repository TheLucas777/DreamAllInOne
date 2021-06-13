package at.lucas.dream.commands;

import at.lucas.dream.challenges.DeathSwap;
import at.lucas.dream.extras.Timer;
import at.lucas.dream.utils.getTexts;
import at.lucas.dream.utils.setGame;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class StopCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String lable, @NotNull String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("dream.*")||p.hasPermission("dream.stop")||p.hasPermission("dream")||p.isOp()){
                DeathSwap.cancleDeathswap();
                Timer.cancleTimer();
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(" "));
                Bukkit.broadcastMessage(getTexts.getPrefix()+"§c"+p.getName()+" has stopped the Challenge");
            }
        }
        return false;
    }
}
