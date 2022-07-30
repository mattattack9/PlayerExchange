package com.github.mattattack9.PlayerExchange;
import java.util.logging.Logger;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
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
