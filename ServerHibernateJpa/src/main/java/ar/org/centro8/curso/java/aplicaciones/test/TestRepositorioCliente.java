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
        
        System.out.println("******************************************************************************************");
        
        Cliente cliente=new Cliente("Luis", "Guerra", TipoDocumento.DNI, "33333666", "Av Rivadavia", "Segundo Cliente");
        cr.save(cliente);
        System.out.println(cliente);
        
        System.out.println("******************************************************************************************");
        
        cr.remove(cr.getById(7));
        
        System.out.println("******************************************************************************************");
        
        cliente=cr.getById(8);
        if(cliente != null){
            cliente.setNombre("Julian");
            cliente.setApellido("Fuentes");
            cr.update(cliente);
        }
        
        System.out.println("******************************************************************************************");

        cr.getAll().forEach(System.out::println);
        
        System.out.println("******************************************************************************************");
        
        cr.getLikeApellido("ca").forEach(System.out::println);
                
        System.out.println("******************************************************************************************");
        
        emf.close();
    }
}
