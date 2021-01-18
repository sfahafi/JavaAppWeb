package ar.org.centro8.curso.java.aplicaciones.test;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestRepositorioFactura {
    public static void main(String[] args) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPAPU");
        
        emf.close();
    }
}
