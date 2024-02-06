package logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import model.Dolencia;
import model.Paciente;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.mongodb.client.model.Filters.eq;

public class LPaciente {
    Scanner sc = new Scanner(System.in);

    public void addPaciente(MongoCollection<Document> collection){

        List<Dolencia> dolenciaList = new ArrayList<>();
        int _idPaciente = 1;
        String nombre = "pp";
        int edad = 30;
        int idDoctor = 1;
        String direccion = "Calle amargura 123";

        Paciente paciente = new Paciente(_idPaciente,nombre,edad,direccion,idDoctor,dolenciaList);
        Document pacienteDocument = new Document();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(paciente);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        pacienteDocument.append("paciente",json);
        collection.insertOne(pacienteDocument);




    }

    public void borrarPaciente(MongoCollection<Document> collection, String idPaciente) {
        collection.deleteOne(eq("_idPaciente", idPaciente));
        System.out.println("Paciente con ID " + idPaciente + " eliminado correctamente.");
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

    public void verPacientePorId(MongoCollection<Document> collection, int idPaciente) {
        Document paciente = collection.find(eq("_idPaciente", idPaciente)).first();
        if (paciente != null) {
            System.out.println("Paciente encontrado: " + paciente.toJson());
        } else {
            System.out.println("No se encontró ningún paciente con el ID: " + idPaciente);
        }
    }

    public void actualizarPaciente(MongoCollection<Document> collection, int idPaciente, String nuevoNombre, int nuevaEdad, String nuevaDireccion) {
        // Crea un filtro para encontrar el paciente por su ID
        Document filtro = new Document("_idPaciente", idPaciente);

        // Crea una actualización con los nuevos datos
        Document actualizacion = new Document("$set", new Document()
                .append("nombre", nuevoNombre)
                .append("edad", nuevaEdad)
                .append("direccion", nuevaDireccion));

        // Actualiza el paciente en la colección
        collection.updateOne(filtro, actualizacion);

        System.out.println("Paciente con ID " + idPaciente + " actualizado correctamente.");
    }

}
