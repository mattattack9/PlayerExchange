package com.github.mattattack9.PlayerExchange;


import java.util.Date;


import org.bukkit.Material;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.IndexOptions;
import org.mongodb.morphia.annotations.Indexed;
@Entity(value = "SellOffers", noClassnameStored = true)
public class SellOffer {

    @Id
    public int id;

    @Indexed(options = @IndexOptions(unique = true))
    public String uuid;

    @Indexed
    public String username;

    @Indexed
    public String playerUUID;

    public Material item;

    public int amount;

    public double price;

    public Date time;

    public SellOffer(){

    }
    public void setUsername(String name){
        username = name;
    }

    public void setItem(Material newitem){
        item = newitem;
    }

    public void setAmount(int damount){
        amount = damount;
    }

    public void setPrice(double dprice){
        price = dprice;
    }

    public void setTime(Date dtime){
        time = dtime;
    }
    public void setPlayerUUID(String puuid){
        playerUUID = puuid;
    }
}
