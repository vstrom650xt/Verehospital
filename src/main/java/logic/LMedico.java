package logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.result.DeleteResult;
import model.Medico;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Scanner;

import static com.mongodb.client.model.Filters.eq;

public class LMedico {
    Scanner sc = new Scanner(System.in);

    public void addMedico(MongoCollection<Document> collection)  {
        String id;
        int numeroColegiado;
        String nombre;
        String especialidad;
        System.out.println("id");
        id = sc.next();
        System.out.println("numeroColegiado");
        numeroColegiado= sc.nextInt();
        System.out.println("nombre");
        nombre= sc.next();
        System.out.println("especialidad");
        especialidad = sc.next();

        Medico doctor = new Medico(id,numeroColegiado,nombre,especialidad);
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

    public void deleterMedico(MongoCollection<Document> collection, String id) {
        Bson query = eq("_idDoctor", id);

        try {
            DeleteResult result = collection.deleteOne(query);
            System.out.println("Deleted document count: " + result.getDeletedCount());
        } catch (MongoException me) {
            System.err.println("Unable to delete due to an error: " + me);
        }

    }

    public void updateDoctor() {

    }

    public void deleteMedico(MongoCollection<Document> collection, String idDoctor) {
        MongoCursor<Document> cursor = collection.find(eq("_idDoctor", idDoctor)).iterator();
        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                System.out.println("Deleting document: " + document.toJson());

                // Elimina el documento basado en el campo _idDoctor
                collection.deleteOne(eq("_idDoctor", idDoctor));
            }
        } finally {
            cursor.close();
        }
    }



    public void findMedico(MongoCollection<Document> collection, int id) {
        MongoCursor<Document> cursor = collection.find(eq("_idDoctor", id)).iterator();
        while (cursor.hasNext()) {
            Document document = cursor.next();
            System.out.println("Deleting document: " + document.toJson());
        }

        cursor.close();
    }

    public void verTodosLosMedicos(MongoCollection<Document> collection) {
        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                Document medico = cursor.next();
                System.out.println("Médico: " + medico.toJson());
            }
        } finally {
            cursor.close();
        }
    }

    public void verMedicoPorId(MongoCollection<Document> collection, String idDoctor) {
        Document medico = collection.find(new Document("nombre","pp")).first();
        if (medico != null) {
            System.out.println("Médico encontrado: " + medico.toJson());
        } else {
            System.out.println("No se encontró ningún médico con el ID: " + idDoctor);
        }
    }

}
