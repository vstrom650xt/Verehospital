package logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.result.DeleteResult;
import model.Dolencia;
import model.Paciente;
import model.Prueba;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.mongodb.client.model.Filters.eq;

public class LPaciente {
    Scanner sc = new Scanner(System.in);

    public void addPaciente(MongoCollection<Document> collection){

        List<Dolencia> dolenciaList = new ArrayList<>();
        List<Prueba> pruebaList = new ArrayList<>();
        String _idPaciente = "1";
        String nombre = "pp";
        int edad = 30;
        String direccion = "Calle amargura 123";
        pruebaList.add(new Prueba("una placa","100"));
        dolenciaList.add(new Dolencia("1", "dolor", pruebaList));

        Paciente paciente = new Paciente(_idPaciente,nombre,edad,direccion,dolenciaList);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(paciente);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        Document   pacienteDocument = Document.parse(json); /////////// GUARDAR DOCUMENTO NO STRING
        collection.insertOne(pacienteDocument);




    }

    public void borrarPaciente(MongoCollection<Document> collection, String _idPaciente) {
        Bson query = eq("_idPaciente", _idPaciente);

        try {
            DeleteResult result = collection.deleteOne(query);
            System.out.println("Deleted document count: " + result.getDeletedCount());
        } catch (MongoException me) {
            System.err.println("Unable to delete due to an error: " + me);
        }
    }
    public void verTodosLosPacientes(MongoCollection<Document> collection) {
        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                Document paciente = cursor.next();
                System.out.println("Paciente: " + paciente.toJson());
            }
        } finally {
            cursor.close();
        }
    }

    public void verPacientePorId(MongoCollection<Document> collection, String idPaciente) {
        Document paciente = collection.find(eq("_idPaciente", idPaciente)).first();
        if (paciente != null) {
            System.out.println("Paciente encontrado: " + paciente.toJson());
        } else {
            System.out.println("No se encontró ningún paciente con el ID: " + idPaciente);
        }
    }

    public void actualizarPaciente(MongoCollection<Document> collection, int idPaciente, String nuevoNombre, int nuevaEdad, String nuevaDireccion) {
        Document filtro = new Document("_idPaciente", idPaciente);

        Document actualizacion = new Document("$set", new Document()
                .append("nombre", nuevoNombre)
                .append("edad", nuevaEdad)
                .append("direccion", nuevaDireccion));

        collection.updateOne(filtro, actualizacion);

    }

}
