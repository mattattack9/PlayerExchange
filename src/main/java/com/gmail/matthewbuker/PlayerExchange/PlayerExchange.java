package com.gmail.matthewbuker.PlayerExchange;

import org.bukkit.plugin.java.JavaPlugin;

public class PlayerExchange extends JavaPlugin {
    @Override
    public void onEnable(){
        getLogger().info("onEnable is called!");
    }
    @Override
    public void onDisable(){
        getLogger().info("onDisable is called!");
    }
}
