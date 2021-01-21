package ar.org.centro8.curso.java.aplicaciones.test;

import ar.org.centro8.curso.java.aplicaciones.entities.Articulo;
import ar.org.centro8.curso.java.aplicaciones.interfaces.I_ArticuloRepository;
import ar.org.centro8.curso.java.aplicaciones.jpa.ArticuloRepository;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestRepositorioArticulo {
    public static void main(String[] args) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPAPU");
        I_ArticuloRepository ar=new ArticuloRepository(emf);
        
        System.out.println("******************************************************************************************");
        
        Articulo articulo=new Articulo("Medias 3", 450.20f, 630.50f, 23, 10, 50);
        ar.save(articulo);
        System.out.println(articulo);
        
        System.out.println("******************************************************************************************");
        
        ar.remove(ar.getById(7));
        
        System.out.println("******************************************************************************************");
        
        articulo=ar.getById(4);
        if(articulo!=null){
        articulo.setDescripcion("Medias Deportivas");
        ar.update(articulo);
        }
        
        System.out.println("******************************************************************************************");
        
        ar.getAll().forEach(System.out::println);
        
        System.out.println("******************************************************************************************");
        
        ar.getLikeDescripcion("me").forEach(System.out::println);
        
        System.out.println("******************************************************************************************");
        
        emf.close();
    }
}
