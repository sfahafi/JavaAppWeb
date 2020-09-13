package ar.org.centro8.curso.java.aplicaciones.jpa;
import ar.org.centro8.curso.java.aplicaciones.entities.Factura;
import ar.org.centro8.curso.java.aplicaciones.interfaces.I_FacturaRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class FacturaRepository implements I_FacturaRepository{
    
    private EntityManagerFactory emf;

    public FacturaRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }
       

    @Override
    public void save(Factura factura) {
        if(factura==null) return;
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(factura);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void remove(Factura factura) {
        if(factura==null) return;
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(factura));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Factura factura) {
        if(factura==null) return;
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(factura);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Factura> getAll() {
        List<Factura> list = new ArrayList();
        EntityManager em=emf.createEntityManager();
        list=(List<Factura>)em.createNamedQuery("Factura.findAll").getResultList();
        em.close();
        return list;
    }
    
}
