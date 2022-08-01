package com.github.mattattack9.PlayerExchange;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Date;


public class CommandPE implements CommandExecutor {
    private DatabaseHandler dbHandler;
    // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            switch (args[0]){
                case "sell": createSellOffer(player, args[1], Integer.parseInt(args[2]), Double.parseDouble(args[3]));
                             break;
                case "buy": break;
                case "list": break;
                case "cancel": break;

            }
        } else {
            return false;
        }
        return true;
    }
    public boolean createSellOffer(Player player, String item, int amount, double price){
        double fnprice = (double)Math.round(price * 100d) / 100d;
        SellOffer sellOffer = new SellOffer();
        sellOffer.setPrice(fnprice);
        sellOffer.setAmount(amount);
        sellOffer.setPrice(price);
        Date currentTime = new Date();
        sellOffer.setTime(currentTime);
        sellOffer.setItem(Material.valueOf(item.toUpperCase()));
        sellOffer.setPlayerUUID(player.getUniqueId().toString());
        sellOffer.setUsername(player.getName());
        dbHandler.sellOfferDAO.saveSellOffer(sellOffer);

        return true;

    }
    public CommandPE(DatabaseHandler db){
        dbHandler = db;
    }
}
