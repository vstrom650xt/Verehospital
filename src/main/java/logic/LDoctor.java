package logic;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class LDoctor {
    public void addDoctor(MongoCollection<Document> collection,int id ,int numeroColegiado, String nombre , String especialidad){

        Document doctorDocument = new Document();
        doctorDocument.append("_idDoctor",id);
        doctorDocument.append("numeroColegiado",numeroColegiado);
        doctorDocument.append("nombre",nombre);
        doctorDocument.append("especialidad",especialidad);
        collection.insertOne(doctorDocument);
        System.out.println("doctor insertado");




    }
}
