package ar.org.centro8.curso.java.aplicaciones.jpa;
import ar.org.centro8.curso.java.aplicaciones.entities.Articulo;
import ar.org.centro8.curso.java.aplicaciones.interfaces.I_ArticuloRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ArticuloRepository implements I_ArticuloRepository{
    
    private EntityManagerFactory emf;

    public ArticuloRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }    

    @Override
    public void save(Articulo articulo) {
        if(articulo==null) return;
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(articulo);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void remove(Articulo articulo) {
        if(articulo==null) return;
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(articulo);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Articulo articulo) {
        if(articulo==null) return;
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(articulo);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Articulo> getAll() {
        List<Articulo> list = new ArrayList();
        EntityManager em=emf.createEntityManager();
        list=(List<Articulo>)em.createNamedQuery("Articulo.findAll").getResultList();
        em.close();
        return list;
    }
    
}
