package com.github.mattattack9.PlayerExchange;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

import java.util.List;

public class SellOfferDAO extends BasicDAO<SellOffer, String> {
    public List<SellOffer> getAllSellOffers() {
        return this.find().asList();
    }
    public SellOfferDAO(Class<SellOffer> entityClass, Datastore ds){
        super(entityClass, ds);
    }
}
