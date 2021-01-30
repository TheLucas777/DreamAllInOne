package at.lucas.dream.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SettingsCommand implements CommandExecutor, Listener {
    File file = new File("plugins/DreamAllInOne/settings.yml");
    YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
    Inventory inv = Bukkit.createInventory(null, 27, "§2Settings");
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
        exists();
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("dream.*")||p.hasPermission("dream.settings")||p.hasPermission("dream")||p.isOp()){
                openSettings();

                p.openInventory(inv);
            }
        }



        return false;
    }
    public void openSettings(){

        //ITEMS
        //EMPTY
        ItemStack none = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta noneMeta = none.getItemMeta();
        noneMeta.setDisplayName(" ");
        none.setItemMeta(noneMeta);
        //TIMER
        ItemStack timer = new ItemStack(Material.CLOCK);
        ItemMeta timerMeta = timer.getItemMeta();
        for (int i = 0; i < 27; i++){
            inv.setItem(i,none);
        }
        if(config.getBoolean("Timer")){
            timerMeta.setDisplayName("§9§lTimer §f§l[§2§lActivated§f§l]");
            List<String> timerLore = new ArrayList<>();
            timerLore.add("§fThe Timer is curently §2ACTIVE");
            timerLore.add(" ");
            timerLore.add("§fClick to open Settings");
            timerMeta.setLore(timerLore);
            timer.setItemMeta(timerMeta);
        }else{
            timerMeta.setDisplayName("§9§lTimer §f§l[§c§lDEACTIVATED§f§l]");
            List<String> timerLore = new ArrayList<>();
            timerLore.add("§fThe Timer is curently §cDEACTIVATED");
            timerLore.add(" ");
            timerLore.add("§fClick to open Settings");
            timerMeta.setLore(timerLore);
            timer.setItemMeta(timerMeta);
        }



        inv.setItem(10,timer);
    }
    public void exists(){
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            config.set("Timer",true);
            try {
                config.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void
}