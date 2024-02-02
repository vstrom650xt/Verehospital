package logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import model.Doctor;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Scanner;

public class LDoctor {
    Scanner sc = new Scanner(System.in);

    public void addMedico(MongoCollection<Document> collection)  {
        int id;
        int numeroColegiado;
        String nombre;
        String especialidad;
        System.out.println("id");
        id = sc.nextInt();
        System.out.println("numeroColegiado");
        numeroColegiado= sc.nextInt();
        System.out.println("nombre");
        nombre= sc.next();
        System.out.println("especialidad");
        especialidad = sc.next();

        Doctor doctor = new Doctor(id,numeroColegiado,nombre,especialidad);
        Document doctorDocument = new Document();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(doctor);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        doctorDocument.append("medico",json);
//        doctorDocument.append("_idDoctor",id);
//        doctorDocument.append("numeroColegiado",numeroColegiado);
//        doctorDocument.append("nombre",nombre);
//        doctorDocument.append("especialidad",especialidad);
        collection.insertOne(doctorDocument);
        System.out.println("doctor insertado");
    }

    public void deleterMedico(MongoCollection<Document> collection, int id) {

        MongoCursor <Document> cursor = collection.find(Filters.eq("idDoctor",id)).iterator();
        while (cursor.hasNext()){
            Document document = cursor.next();
            System.out.println(document.toJson());
        }
        cursor.close();
    }



    public void deleteMedico(MongoCollection<Document> collection, int id) {
//        MongoCursor<Document> cursor = collection.find(Filters.eq("_idDoctor", id)).iterator();
//        while (cursor.hasNext()) {
//            Document document = cursor.next();
//            System.out.println("Deleting document: " + document.toJson());
//
//            collection.deleteOne(Filters.eq("_idDoctor", document.getObjectId(id)));
//        }
//
//        cursor.close();

        Bson filter = Filters.eq("_idDoctor",id);
        FindIterable<Document> elementosEncon = collection.find(filter);
        elementosEncon.forEach(document -> System.out.println(document));
        System.out.println(elementosEncon.toString());


    }


    public void findMedico(MongoCollection<Document> collection, int id) {
        MongoCursor<Document> cursor = collection.find(Filters.eq("_idDoctor", id)).iterator();
        while (cursor.hasNext()) {
            Document document = cursor.next();
            System.out.println("Deleting document: " + document.toJson());
        }

        cursor.close();
    }


}
