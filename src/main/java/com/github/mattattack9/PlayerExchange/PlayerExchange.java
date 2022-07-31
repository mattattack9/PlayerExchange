package com.github.mattattack9.PlayerExchange;
import java.util.logging.Logger;


import com.mongodb.MongoClient;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;


import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class PlayerExchange extends JavaPlugin implements Listener {
    private static final Logger log = Logger.getLogger("Minecraft");
    private static Economy econ = null;
    private static Permission perms = null;
    private static Chat chat = null;
    FileConfiguration config = getConfig();
    private MongoClient mc;
    private Morphia morphia;
    private Datastore datastore;
    private SellOfferDAO sellOfferDAO;
    private BuyOfferDAO buyOfferDAO;

    public void DatabaseHandler(int i) {
        mc = new MongoClient();
        morphia = new Morphia();
        morphia.map(SellOffer.class);
        morphia.map(BuyOffer.class);

        datastore = morphia.createDatastore(mc,"dbName");
        datastore.ensureIndexes();

        sellOfferDAO = new SellOfferDAO(SellOffer.class, datastore);
        buyOfferDAO = new BuyOfferDAO(BuyOffer.class, datastore);
    }

    @Override
    public void onEnable(){
        if (!setupEconomy() ) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        config.addDefault("transactionLogging", true);
        config.options().copyDefaults(true);
        saveConfig();

        setupPermissions();
        setupChat();

        getServer().getPluginManager().registerEvents(this, this);
    }
    // This method checks for incoming players and sends them a message
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        //TODO: Check for Player's Collectable Items/Money and Inform
    }
    @Override
    public void onDisable(){
        log.info(String.format("[%s] Disabled Version %s", getDescription().getName(), getDescription().getVersion()));
    }
    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }

    public static Economy getEconomy() {
        return econ;
    }

    public static Permission getPermissions() {
        return perms;
    }

    public static Chat getChat() {
        return chat;
    }
}
