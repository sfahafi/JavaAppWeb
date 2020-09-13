package ar.org.centro8.curso.java.aplicaciones.interfaces;
import ar.org.centro8.curso.java.aplicaciones.entities.Factura;
import ar.org.centro8.curso.java.aplicaciones.enumerados.Letra;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public interface I_FacturaRepository {
    void save(Factura factura);
    void remove(Factura factura);
    void update(Factura factura);
    List<Factura>getAll();
    
    default Factura getById(int id){
        return getAll()
                .stream()
                .filter(f -> f.getId() == id)
                .findFirst()
                .orElse(new Factura());
    }
    
    default Factura getByLetraNumero(Letra letra, int numero){
        return getAll()
                .stream()
                .filter(f -> f.getLetra() == letra && f.getNumero() == numero)
                .findFirst()
                .orElse(new Factura());
    }
    
    default List<Factura> getLikeFecha(String fecha){
        if (fecha == null) return new ArrayList<Factura>();
        return getAll()
                .stream()
                .filter(f -> f.getFecha().toLowerCase().contains(fecha.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    default Factura getLikeMonto(double monto){
        return getAll()
                .stream()
                .filter(f -> f.getMonto() == monto)
                .findFirst()
                .orElse(new Factura());
    }
    
    default List<Factura> getByIdCliente(int id){
        return getAll()
                .stream()
                .filter(f -> f.getIdCliente() == id)
                .collect(Collectors.toList());
                
    }
     
}
