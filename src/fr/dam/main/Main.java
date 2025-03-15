package fr.dam.main;

import fr.dam.main.listeners.mainListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.UUID;

public class Main extends JavaPlugin {

    private ArrayList<UUID> frozePlayers = new ArrayList<>();

    @Override
    public void onEnable() {
        getCommand("freeze").setExecutor(new CommandFreeze(this));
        getServer().getPluginManager().registerEvents(new mainListener(this), this);
    }

    @Override
    public void onDisable() {

    }

    public ArrayList<UUID> getFrozePlayers() {
        return frozePlayers;
    }
}
