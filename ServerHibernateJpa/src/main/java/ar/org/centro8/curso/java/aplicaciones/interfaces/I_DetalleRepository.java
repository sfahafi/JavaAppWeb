package ar.org.centro8.curso.java.aplicaciones.interfaces;
import ar.org.centro8.curso.java.aplicaciones.entities.Detalle;
import java.util.List;
public interface I_DetalleRepository {
    void save(Detalle detalle);
    void remove(Detalle detalle);
    void update(Detalle detalle);
    List<Detalle>getAll();
    

//    default Detalle getByIdDetalle(int idFactura , int idArticulo){
//        return getAll()
//                .stream()
//                .filter(d -> d.getIdFactura() == idFactura && d.getIdArticulo() == idArticulo)
//                .findFirst()
//                .orElse(new Detalle());
//    }
//    
//    default Detalle getByIdFactura(int id){
//        return getAll()
//                .stream()
//                .filter(d -> d.getIdFactura() == id)
//                .findFirst()
//                .orElse(new Detalle());
//    }
//    
//    default Detalle getByIdArticulo(int id){
//        return getAll()
//                .stream()
//                .filter(d -> d.getIdArticulo() == id)
//                .findFirst()
//                .orElse(new Detalle());
//    }
    
    default Detalle getLikePrecio(float precio){
        return getAll()
                .stream()
                .filter(d -> d.getPrecio() == precio)
                .findFirst()
                .orElse(new Detalle());
    }
    
    default Detalle getLikeCantidad(int cantidad){
        return getAll()
                .stream()
                .filter(d -> d.getCantidad() == cantidad)
                .findFirst()
                .orElse(new Detalle());
    }
    
}
