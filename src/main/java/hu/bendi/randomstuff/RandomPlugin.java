package hu.bendi.randomstuff;

import hu.bendi.randomstuff.commands.TntCommand;
import hu.bendi.randomstuff.listener.MutiblockListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public class RandomPlugin extends JavaPlugin {

    public static RandomPlugin INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        System.out.println("[Random] Started. "+ new Random().nextInt());
        Bukkit.getPluginCommand("tnt").setExecutor(new TntCommand());
        Bukkit.getPluginManager().registerEvents(new TntCommand(),this);
        Bukkit.getPluginManager().registerEvents(new MutiblockListener(),this);
    }



    @Override
    public void onDisable() {
        System.out.println("[Random] Stopped. "+ new Random().nextInt());
    }
}
