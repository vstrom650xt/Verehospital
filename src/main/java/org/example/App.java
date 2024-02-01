package org.example;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import logic.LDoctor;
import model.Doctor;
import org.bson.Document;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App{
    public static void main( String[] args ){
        int id;
        int numeroColegiado;
        String nombre;
        String especialidad;

        Scanner sc = new Scanner(System.in);
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
        MongoClient mongoClient = MongoClients.create(connectionString);

        MongoDatabase database = mongoClient.getDatabase("verehospital");
        //MongoCollection<Document> collection = database.getCollection("");
        System.out.println("id");
        id = sc.nextInt();
        System.out.println("numeroColegiado");
        numeroColegiado= sc.nextInt();
        System.out.println("nombre");
        nombre= sc.nextLine();
        System.out.println("especialidad");
        especialidad = sc.nextLine();
        Doctor doctor = new Doctor(id,numeroColegiado,nombre,especialidad);





    }
}
