package ar.org.centro8.curso.java.aplicaciones.test;
import ar.org.centro8.curso.java.aplicaciones.entities.Factura;
import ar.org.centro8.curso.java.aplicaciones.enumerados.Letra;
import ar.org.centro8.curso.java.aplicaciones.interfaces.I_FacturaRepository;
import ar.org.centro8.curso.java.aplicaciones.jpa.FacturaRepository;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestRepositorioFactura {
    public static void main(String[] args) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPAPU");
        I_FacturaRepository fr=new FacturaRepository(emf);
        
        System.out.println("******************************************************************************************");
        
        Factura factura=new Factura(Letra.B, 28, "21/01/2021", 35671.09, 3);
        fr.save(factura);
        System.out.println(factura);
        
        System.out.println("******************************************************************************************");
        
        fr.remove(fr.getById(28));
        
        System.out.println("******************************************************************************************");
        
        factura=fr.getById(4);
        if(factura != null){
            factura.setFecha("20/01/2021");
            fr.update(factura);
        }
        
        System.out.println("******************************************************************************************");

        fr.getAll().forEach(System.out::println);
        
        System.out.println("******************************************************************************************");
        
        fr.getByIdCliente(2).forEach(System.out::println);
                
        System.out.println("******************************************************************************************");
        
        emf.close();
    }
}
