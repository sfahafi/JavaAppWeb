package ar.org.centro8.curso.java.aplicaciones.test;
import ar.org.centro8.curso.java.aplicaciones.dao.interfaces.I_ArticuloRepository;
import ar.org.centro8.curso.java.aplicaciones.dao.rest.cliente.ArticuloRepository;
import ar.org.centro8.curso.java.aplicaciones.entities.Articulo;
public class TestArticuloRepository {
    public static void main(String[] args) {
        
        try {
            
            I_ArticuloRepository ar = new ArticuloRepository("http://localhost:8080/Server/articulos/v1/");
            
            System.out.println("\n" + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
            
            ar.remove(ar.getById(10));
            
            System.out.println("\n" + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
            
            Articulo articulo = new Articulo("Zapatos", 1200, 1500, 100, 5, 200);
            Articulo articulo2 = new Articulo("Remeras", 600, 800, 150, 10, 300);
            Articulo articulo3 = new Articulo("Pantalones", 1000, 1200, 80, 15, 400);
            ar.save(articulo);
            ar.save(articulo2);
            ar.save(articulo3);
            System.out.println("Articulos agregados a la base");
            
            System.out.println("\n" + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
            
            ar.getAll().forEach(System.out::println);
            
            System.out.println("\n" + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
            
//            ar.remove(ar.getById(10));
//            
//            System.out.println("\n" + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
            
           
            
        } catch (Exception e) { e.printStackTrace(); }
    }
}
