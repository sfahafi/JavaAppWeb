package ar.org.centro8.curso.java.aplicaciones.clase01;
import java.util.ArrayList;
import java.util.List;
public class Clase01 {
    public static void main(String[] args) {
        /*
        
        Software: JDK 11 - Apache Tomee 8.X
        
        */
        
        List<String>lista=new ArrayList();
        lista.add("Lunes");
        lista.forEach(System.out::println);
    }
}
