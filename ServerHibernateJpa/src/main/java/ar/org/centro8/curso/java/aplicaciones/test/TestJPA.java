package ar.org.centro8.curso.java.aplicaciones.test;

import ar.org.centro8.curso.java.aplicaciones.entities.Cliente;
import ar.org.centro8.curso.java.aplicaciones.enumerados.TipoDocumento;
import ar.org.centro8.curso.java.aplicaciones.interfaces.I_ClienteRepository;
import ar.org.centro8.curso.java.aplicaciones.jpa.ClienteRepository;
import java.time.LocalTime;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
        System.out.println("***************************************");
        System.out.println(LocalTime.now());
        EntityManager em = emf.createEntityManager();
        I_ClienteRepository cr = new ClienteRepository(emf);
        
//        Cliente cliente = new Cliente("Carlos", "Rios", "DNI", "12121212", "tal", "tal");
//        
//        em.getTransaction().begin();
//        em.persist(cliente);
//        em.getTransaction().commit();
//        
//        System.out.println(cliente);

        cr.getAll().forEach(System.out::println);
                
        em.close();
        emf.close();
    }
}
