package org.example;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import logic.LMedico;
import logic.LPaciente;
import org.bson.Document;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
            MongoClient mongoClient = MongoClients.create(connectionString);
            MongoDatabase database = mongoClient.getDatabase("verehospital");
            MongoCollection<Document> collectionMedico = database.getCollection("medico");
//
//            LMedico a = new LMedico();
////          a.addMedico(collectionMedico);   //OK
////               a.deleterMedico(collectionMedico,"1");  //OK
////            a.verTodosLosMedicos(collectionMedico); //OK
//                //a.findMedico(collectionMedico,"1");
//             System.out.println("Introduce los nuevos datos:");
//            System.out.println("Número de colegiado:");
//            String nuevoNumeroColegiado = sc.next();
//            System.out.println("Nombre:");
//            String nuevoNombre = sc.next();
//            System.out.println("Especialidad:");
//            String nuevaEspecialidad = sc.next();
//            a.updateDoctor(collectionMedico,"1",nuevaEspecialidad,nuevoNombre,nuevoNumeroColegiado); //OK

                MongoCollection<Document> collectionPaciente= database.getCollection("paciente");

            LPaciente paciente = new LPaciente();
                    paciente.addPaciente(collectionPaciente); //ok
              //paciente.borrarPaciente(collectionPaciente,"1");
              paciente.verPacientePorId(collectionPaciente,"1");
            //  paciente.actualizarPaciente(collectionMedico,1,"1123123",3,"advvd");


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}


