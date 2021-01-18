package ar.org.centro8.curso.java.aplicaciones.test;
import ar.org.centro8.curso.java.aplicaciones.entities.Cliente;
import ar.org.centro8.curso.java.aplicaciones.enumerados.TipoDocumento;
import ar.org.centro8.curso.java.aplicaciones.interfaces.I_ClienteRepository;
import ar.org.centro8.curso.java.aplicaciones.jpa.ClienteRepository;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestRepositorioCliente {
    public static void main(String[] args) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPAPU");
        I_ClienteRepository cr=new ClienteRepository(emf);
        
        Cliente cliente=new Cliente("Luis", "Guerra", TipoDocumento.PASS, "15333666", "Av Rivadavia", "Segundo Cliente");
        cr.save(cliente);
        System.out.println(cliente);
        
        cr.getAll().forEach(System.out::println);
        
        emf.close();
    }
}
