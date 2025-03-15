package fr.dam.main.listeners;

import fr.dam.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.UUID;

public class mainListener implements Listener {
    private Main main;

    public mainListener(Main main) {
        this.main = main;
    }
    @EventHandler
    public void onClick(PlayerInteractEntityEvent e){
        Player p = e.getPlayer();
        Player targetPlayer = (Player) e.getRightClicked();
        Item it = (Item) p.getItemInHand();
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player p = e.getPlayer();
        UUID pUUID = p.getUniqueId();
        if(main.getFrozePlayers().contains(pUUID)){
            e.setCancelled(true);
            p.sendMessage(ChatColor.RED + "You have been frozen by a staff member");
        }
    }
}
