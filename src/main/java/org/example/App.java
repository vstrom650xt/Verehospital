package org.example;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import logic.LDoctor;
import org.bson.Document;

/**
 * Hello world!
 *
 */
public class App{
    public static void main( String[] args ){

        try {
            ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
            MongoClient mongoClient = MongoClients.create(connectionString);
            MongoDatabase database = mongoClient.getDatabase("verehospital");
            MongoCollection<Document> collection = database.getCollection("medico");
            LDoctor a = new LDoctor();
//
//            a.addMedico(collection);
            a.deleteMedico(collection,1);

        }catch (Exception e){
            e.printStackTrace();
        }








    }
}
