package ar.org.centro8.curso.java.aplicaciones.test;

import ar.org.centro8.curso.java.aplicaciones.connectors.Connector;
import ar.org.centro8.curso.java.aplicaciones.dao.interfaces.I_DetalleRepository;
import ar.org.centro8.curso.java.aplicaciones.dao.jdbc.DetalleRepository;
import ar.org.centro8.curso.java.aplicaciones.entities.Detalle;
import java.sql.Connection;

public class TestDetalleRepository {
    public static void main(String[] args) {
        
        try (Connection conn = Connector.getConnection()){
            
            I_DetalleRepository dr = new DetalleRepository(conn);
            
            System.out.println("\n" + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
            
            dr.remove(dr.getByIdDetalle(5, 1));
            System.out.println("Detalle Factura 5 - Articulo 1, eliminado !!!");
            
            System.out.println("\n" + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
            
            Detalle detalle = new Detalle(5, 1, 567, 30);
            Detalle detalle2 = new Detalle(6, 2, 1255.45f, 50);
            Detalle detalle3 = new Detalle(7, 3, 580.34f, 100);
            Detalle detalle4 = new Detalle(8, 4, 1324, 150);
            Detalle detalle5 = new Detalle(8, 5, 239.99f, 200);
            Detalle detalle6 = new Detalle(8, 5, 239.99f, 200);
            Detalle detalle7 = new Detalle(8, 5, 239.99f, 200);
            dr.save(detalle);
            dr.save(detalle2);
            dr.save(detalle3);
            dr.save(detalle4);
            dr.save(detalle5);
            dr.save(detalle6);
            dr.save(detalle7);
            System.out.println(detalle + "\nAgregado a la base");
            
            System.out.println("\n" + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
            
            detalle = dr.getLikeCantidad(50); 
            System.out.println("detalle = " + detalle);
            detalle.setPrecio(5000);
            dr.update(detalle);
            System.out.println("detalle = " + detalle);            
            
            System.out.println("\n" + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
                       
            dr.getAll().forEach(System.out::println);
            
            System.out.println("\n" + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
            
            detalle = dr.getLikeCantidad(200);
            System.out.println(detalle);
            
            System.out.println("\n" + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
            
            
            
        } catch (Exception e) { e.printStackTrace(); }
    }
}
