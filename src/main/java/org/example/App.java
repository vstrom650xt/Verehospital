package org.example;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import logic.LMedico;
import logic.LPaciente;
import model.Dolencia;
import model.Paciente;
import model.Prueba;
import org.bson.Document;
import util.IdTool;

import java.util.ArrayList;
import java.util.List;
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
//            int numeroColegiado;
//            String nombre;
//            String especialidad;
//
//            System.out.println("numeroColegiado");
//            numeroColegiado = sc.nextInt();
//            System.out.println("nombre");
//            nombre = sc.next();
//            System.out.println("especialidad");
//            especialidad = sc.next();

//
            LMedico a = new LMedico();
       //     a.addMedico(collectionMedico, numeroColegiado, nombre, especialidad);   //OK
////               a.deleterMedico(collectionMedico,"1");  //OK
////            a.verTodosLosMedicos(collectionMedico); //OK
                a.findMedico(collectionMedico,"1");
//             System.out.println("Introduce los nuevos datos:");
//            System.out.println("Número de colegiado:");
//            String nuevoNumeroColegiado = sc.next();
//            System.out.println("Nombre:");
//            String nuevoNombre = sc.next();
//            System.out.println("Especialidad:");
//            String nuevaEspecialidad = sc.next();
//            a.updateDoctor(collectionMedico,"1",nuevaEspecialidad,nuevoNombre,nuevoNumeroColegiado); //OK

            MongoCollection<Document> collectionPaciente = database.getCollection("paciente");
//
//            LPaciente lPaciente = new LPaciente();
//            System.out.println("nombre");
//            String nombrePaciente = sc.next();
//            System.out.println("edad");
//            int edad = sc.nextInt();
//            System.out.println("direccion");
//            String direccion = sc.next();
//
//
//            System.out.println(" tiene dolencia");
//            String respuesta = sc.next();
//            if (respuesta.equals("si")) {
//                List<Dolencia> dolenciaList = new ArrayList<>();
//
//                a.verTodosLosMedicos(collectionMedico);
//                System.out.println("Pon el id de alguno de los doctores");
//                String idDoc = sc.next();
//                System.out.println("nombre dolenia");
//                String nomDole = sc.next();
//                Dolencia dolencia = new Dolencia(idDoc, nomDole, new ArrayList<>());
//                dolenciaList.add(dolencia);
//
//                System.out.println("tiene alguna prueba para la dolen");
//                String respuesta2 = sc.next();
//                if (respuesta2.equals("si")) {
//                    List<Prueba> pruebaList = new ArrayList<>();
//                    System.out.println("Pon tipo");
//                    String tipo = sc.next();
//                    System.out.println("Pon precio");
//                    String precio = sc.next();
//                    Prueba prueba = new Prueba(tipo, precio);
//                    pruebaList.add(prueba);
//                    dolencia.setPruebaList(pruebaList);
//
//                    //dolencia y prueba
//                    Paciente paciente1 = new Paciente(IdTool.getCodigoPaciente(collectionPaciente), nombrePaciente, edad, direccion, dolenciaList);
//                        lPaciente.addPaciente(collectionPaciente,paciente1);
//
//                } else {
//                    //con dolencia sin prueba
//                    Paciente paciente1 = new Paciente(IdTool.getCodigoPaciente(collectionPaciente), nombrePaciente, edad, direccion, dolenciaList);
//
//                    lPaciente.addPaciente(collectionPaciente,paciente1);
//
//                }
//
//
//            } else {
//                //paciente sin dolencias ni pruebas
//                Paciente paciente1 = new Paciente(IdTool.getCodigoPaciente(collectionPaciente), nombrePaciente, edad, direccion);
//                lPaciente.addPaciente(collectionPaciente,paciente1);
//
//            }
//
//


            //paciente.borrarPaciente(collectionPaciente,"1");
            //  paciente.verPacientePorId(collectionPaciente,"1");
            //  paciente.actualizarPaciente(collectionMedico,1,"1123123",3,"advvd");


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}


