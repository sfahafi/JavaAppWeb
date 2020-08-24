package ar.org.centro8.curso.java.aplicaciones.test;

import ar.org.centro8.curso.java.aplicaciones.entities.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
        EntityManager em = emf.createEntityManager();
        
        Cliente cliente = new Cliente("Carlos", "Rios", "DNI", "12121212", "tal", "tal");
        
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        
        System.out.println(cliente);
        
        em.close();
        emf.close();
    }
}
