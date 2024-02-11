package logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import model.Medico;
import org.bson.Document;
import org.bson.conversions.Bson;
import util.IdTool;

import java.util.Scanner;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

public class LMedico {
    Scanner sc = new Scanner(System.in);

    public void addMedico(MongoCollection<Document> collection, int numeroColegiado , String nombre , String especialidad) {


        Medico doctor = new Medico(IdTool.getCodigoMedico(collection), numeroColegiado, nombre, especialidad);
        Document doctorDocument;
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(doctor);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        doctorDocument = Document.parse(json);
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


    public void findMedico(MongoCollection<Document> collection, String id) {
        MongoCursor<Document> cursor = collection.find(eq("_idDoctor", id)).iterator();
        while (cursor.hasNext()) {
            Document document = cursor.next();
            System.out.println(document.toJson());
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
    public void updateDoctor(MongoCollection<Document> collection,String _idDoctor ,String especialidad,String nombre,String numeroColegiado ) {
        Document filter = new Document("_idDoctor", _idDoctor);
        Document update = new Document("$set", new Document()
                .append("especialidad",especialidad)
                .append("nombre",nombre)
                .append("numeroColegiado",numeroColegiado));

                collection.updateOne(filter, update);

    }

}
