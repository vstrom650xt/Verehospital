package org.example;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import logic.LDoctor;
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
            MongoCollection<Document> collectionMedico = database.getCollection("medico");
            MongoCollection<Document> collectionPaciente= database.getCollection("paciente");

            LDoctor a = new LDoctor();
            LPaciente paciente = new LPaciente();
         //   paciente.addPaciente(collectionPaciente);
            paciente.borrarPaciente(collectionPaciente,"65c2691e8ecac36f81b5f000");
            paciente.actualizarPaciente(collectionMedico,1,"1123123",3,"advvd");
//            a.addMedico(collectionMedico);
   //         a.deleteMedico(collectionMedico,"1");
            //a.verTodosLosMedicos(collectionMedico);
            //a.verMedicoPorId(collectionMedico,"1");

        }catch (Exception e){
            e.printStackTrace();
        }








    }
}
