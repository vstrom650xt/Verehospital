package org.example;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import logic.LMedico;
import logic.LPaciente;
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
            MongoCollection<Document> collectionMedico = database.getCollection("medic o");
//
            LMedico a = new LMedico();
      //    a.addMedico(collectionMedico);


           // a.deleterMedico(collectionMedico,"pp");
//a.verTodosLosMedicos(collectionMedico);
         // a.verMedicoPorId(collectionMedico,"1");
      //      a.deleteMedico(collectionMedico,"pp");



                 MongoCollection<Document> collectionPaciente= database.getCollection("paciente");

            LPaciente paciente = new LPaciente();
   //        paciente.addPaciente(collectionPaciente);
            paciente.borrarPaciente(collectionPaciente,"2");
          //  paciente.actualizarPaciente(collectionMedico,1,"1123123",3,"advvd");


        }catch (Exception e){
            e.printStackTrace();
        }








    }
}
