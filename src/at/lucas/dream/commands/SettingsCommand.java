package at.lucas.dream.commands;

import at.lucas.dream.utils.getTexts;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class SettingsCommand implements CommandExecutor, Listener {
    File file = new File("plugins/DreamAllInOne/settings.yml");
    YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
    Inventory settings = Bukkit.createInventory(null, 27, "§2Settings");
    Inventory timer = Bukkit.createInventory(null, 27, "§2Settings§8>>§2Timer");
    Inventory challegnges1 = Bukkit.createInventory(null, 54, "§2Settings§8>>§2Challenges");
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
        exists();
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("dream.*")||p.hasPermission("dream.settings")||p.hasPermission("dream")||p.isOp()){
                openSettings();
                p.openInventory(settings);
            }else p.sendMessage(getTexts.getPrefix()+"No Permission");
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

        //Challenges
        ItemStack challenges = new ItemStack(Material.CHEST);
        ItemMeta challengesItemMeta = challenges.getItemMeta();
        challengesItemMeta.setDisplayName("§6§lChallenges");
        List<String> challengesLore = new ArrayList<>();
        challengesLore.add("§fSelect your Challenge");
        challengesItemMeta.setLore(challengesLore);
        challenges.setItemMeta(challengesItemMeta);
        for (int i = 0; i < 27; i++){
            settings.setItem(i,none);
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


        settings.setItem(16,challenges);
        settings.setItem(10,timer);
    }
    public void openTimer(){

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
            settings.setItem(i,none);
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



        settings.setItem(10,timer);
    }
    public void openChallenges(){

        //ITEMS
        //EMPTY
        ItemStack none = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta noneMeta = none.getItemMeta();
        noneMeta.setDisplayName(" ");
        none.setItemMeta(noneMeta);

        //DeathSwap
        ItemStack deathSwap = new ItemStack(Material.TNT);
        ItemMeta deathSwapMeta = deathSwap.getItemMeta();


        for (int i = 0; i < 54; i++){
            challegnges1.setItem(i,none);
        }
        if(config.getBoolean("DeathSwap")){
            deathSwapMeta.setDisplayName("§f§lDeathSwap [§a§lACTIVATED§f§l]");
            List<String> deathSwapLore = new ArrayList<>();
            deathSwapLore.add("§fSwaps §l2 §fPlayers every 5 minutes");
            deathSwapLore.add(" ");
            deathSwapLore.add("§fOnly works with §l2 §fPlayers");
            deathSwapMeta.setLore(deathSwapLore);
            deathSwap.setItemMeta(deathSwapMeta);
        }else{
            deathSwapMeta.setDisplayName("§f§lDeathSwap [§c§lDEACTIVATED§f§l]");
            List<String> deathSwapLore = new ArrayList<>();
            deathSwapLore.add("§fSwaps §l2 §fPlayers every 5 minutes");
            deathSwapLore.add(" ");
            deathSwapLore.add("§fOnly works with §l2 §fPlayers");
            deathSwapMeta.setLore(deathSwapLore);
            deathSwap.setItemMeta(deathSwapMeta);
        }
        challegnges1.setItem(10,deathSwap);
    }
    public void exists(){
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            config.set("Timer",false);
            config.set("DeathSwap",false);
            try {
                config.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        ItemStack current = e.getCurrentItem();
       if(current.getType() == Material.CLOCK && current.getItemMeta().getDisplayName().equals("§9§lTimer §f§l[§2§lActivated§f§l]")){
           config.set("Timer",false);
           try {
               config.save(file);
           } catch (IOException exception) {
               exception.printStackTrace();
           }
           openSettings();
           p.openInventory(settings);
       }else if(current.getType() == Material.CLOCK && current.getItemMeta().getDisplayName().equals("§9§lTimer §f§l[§c§lDEACTIVATED§f§l]")){
           config.set("Timer",true);
           try {
               config.save(file);
           } catch (IOException exception) {
               exception.printStackTrace();
           }
           openSettings();
           p.openInventory(settings);
       }

        if(current.getType() == Material.CHEST && current.getItemMeta().getDisplayName().equals("§6§lChallenges")){
            openChallenges();
            p.openInventory(challegnges1);
        }
        if(current.getType() == Material.TNT && current.getItemMeta().getDisplayName().equals("§f§lDeathSwap [§a§lACTIVATED§f§l]")){
            
            config.set("DeathSwap",false);
            try {
                config.save(file);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            openChallenges();
            p.openInventory(challegnges1);
        }else if(current.getType() == Material.TNT && current.getItemMeta().getDisplayName().equals("§f§lDeathSwap [§c§lDEACTIVATED§f§l]")){
            config.set("DeathSwap",true);
            try {
                config.save(file);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            openChallenges();
            p.openInventory(challegnges1);
        }
    }
}