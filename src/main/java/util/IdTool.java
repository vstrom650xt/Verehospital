package util;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class IdTool {

    public static String getCodigoPaciente(MongoCollection<Document> collection) {
        FindIterable<Document> pacientes = collection.find();
        int maxCodigo = 0;
        for (Document paciente : pacientes) {
            int codigo = Integer.parseInt(paciente.getString("_idPaciente"));
            if (codigo > maxCodigo) {
                maxCodigo = codigo;
            }
        }
        maxCodigo++;
        return Integer.toString(maxCodigo);
    }

    public static String getCodigoMedico(MongoCollection<Document> collection) {
        FindIterable<Document> pacientes = collection.find();
        int maxCodigo = 0;
        for (Document paciente : pacientes) {
            int codigo = Integer.parseInt(paciente.getString("_idDoctor"));
            if (codigo > maxCodigo) {
                maxCodigo = codigo;
            }
        }
        maxCodigo++;
        return Integer.toString(maxCodigo);
    }
}
