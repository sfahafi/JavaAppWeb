package ar.org.centro8.curso.java.aplicaciones.test;
import ar.org.centro8.curso.java.aplicaciones.dao.interfaces.I_ClienteRepository;
import ar.org.centro8.curso.java.aplicaciones.dao.rest.cliente.ClienteRepository;
import ar.org.centro8.curso.java.aplicaciones.entities.Cliente;
import ar.org.centro8.curso.java.aplicaciones.enumerados.TipoDocumento;
public class TestClienteRepository {
    public static void main(String[] args) {
                
        try {
            
            I_ClienteRepository cr = new ClienteRepository("http://localhost:8080/Server/clientes/v1/");
            
//            System.out.println("\n" + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
//            
            cr.remove(cr.getById(49));
//            System.out.println("Cliente con DNI: 16777888, eliminado !!!");
            
            System.out.println("\n" + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
            
            Cliente cliente = new Cliente("Juan","Sosa",TipoDocumento.DNI,16127880,"Av._Tal","Hola");
            cr.save(cliente);
            System.out.println(cliente + "\nAgregado a la base");
            
//            System.out.println("\n" + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
//            
//            cliente = (Cliente)cr.getLikeNombreApellido("juan", "sosa"); 
//            System.out.println("cliente = " + cliente);
//            cliente.setNombre("Pedro");
//            cliente.setApellido("Suarez");
//            cr.update(cliente);
//            System.out.println("cliente = " + cliente);            
//            
            System.out.println("\n" + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
                       
            cr.getAll().forEach(System.out::println);
            
            System.out.println("\n" + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
            
//            cr.getLikeApellido("sot").forEach(System.out::println);
//            
//            System.out.println("\n" + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
//            
//            cr.getLikeNombreApellido("lu", "gu").forEach(System.out::println);
            
        } catch (Exception e) { e.printStackTrace(); }
                
    }
}
