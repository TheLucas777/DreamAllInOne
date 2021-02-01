package at.lucas.dream.commands;

import at.lucas.dream.challenges.DeathSwap;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StartCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
        DeathSwap deathSwap = new DeathSwap();
        deathSwap.onDeathSwap();

        return false;
    }
}
