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

    public Material item;

    public int amount;

    public float price;

    public Date time;

    public SellOffer(){

    }
}
