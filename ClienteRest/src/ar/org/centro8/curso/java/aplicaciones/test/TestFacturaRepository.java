package ar.org.centro8.curso.java.aplicaciones.test;
import ar.org.centro8.curso.java.aplicaciones.dao.interfaces.I_FacturaRepository;
import ar.org.centro8.curso.java.aplicaciones.dao.rest.cliente.FacturaRepository;
import ar.org.centro8.curso.java.aplicaciones.entities.Factura;
import ar.org.centro8.curso.java.aplicaciones.enumerados.Letra;
public class TestFacturaRepository {
    public static void main(String[] args) {
        try {
            
            I_FacturaRepository fr = new FacturaRepository("http://localhost:8080/Server/facturas/v1/");
            
            System.out.println("\n" + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
            
            fr.remove(fr.getByLetraNumero(Letra.B, 25));
            System.out.println("Factura eliminada !!!");
                        
            System.out.println("\n" + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
            
            Factura factura = new Factura(Letra.A, 27, "05/05/2018", 1400, 2);
            fr.save(factura);
            System.out.println(factura + "\nAgregada a la base");
            
            System.out.println("\n" + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
            
//            factura = fr.getByLetraNumero(Letra.A, 1);
//            System.out.println("factura = " + factura);
//            factura.setFecha("06/07/2019");
//            factura.setMonto(2556.30);
//            fr.update(factura);
//            System.out.println("factura = " + factura);
            
            System.out.println("\n" + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
            
            fr.getAll().forEach(System.out::println);
            
            
        } catch (Exception e) { e.printStackTrace(); }
    }
}
