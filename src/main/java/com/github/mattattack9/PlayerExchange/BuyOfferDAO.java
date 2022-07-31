package com.github.mattattack9.PlayerExchange;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

public class BuyOfferDAO extends BasicDAO<BuyOffer, String> {

    public BuyOfferDAO(Class<BuyOffer> entityClass, Datastore ds){
        super(entityClass, ds);
    }
}
