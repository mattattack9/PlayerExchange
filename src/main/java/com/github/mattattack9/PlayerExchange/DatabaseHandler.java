package com.github.mattattack9.PlayerExchange;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class DatabaseHandler {
    private MongoClient mc;
    private Morphia morphia;
    private Datastore datastore;
    public SellOfferDAO sellOfferDAO;
    public BuyOfferDAO buyOfferDAO;

    public void InitializeDatabase() {
        mc = new MongoClient();
        morphia = new Morphia();
        morphia.map(SellOffer.class);
        morphia.map(BuyOffer.class);

        datastore = morphia.createDatastore(mc,"dbName");
        datastore.ensureIndexes();

        sellOfferDAO = new SellOfferDAO(SellOffer.class, datastore);
        buyOfferDAO = new BuyOfferDAO(BuyOffer.class, datastore);
    }
    public DatabaseHandler(){
    }
}
