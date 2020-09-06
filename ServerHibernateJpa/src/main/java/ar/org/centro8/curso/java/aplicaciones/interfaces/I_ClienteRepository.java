package ar.org.centro8.curso.java.aplicaciones.interfaces;
import ar.org.centro8.curso.java.aplicaciones.entities.Cliente;
//import ar.org.centro8.curso.java.aplicaciones.enumerados.TipoDocumento;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public interface I_ClienteRepository {
    void save(Cliente cliente);
    void remove(Cliente cliente);
    void update(Cliente cliente);
    List<Cliente>getAll();
    
    default Cliente getById(int id){
        return getAll()
                .stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(new Cliente());
    }
    
    default Cliente getByTipoNumero(String tipo, String numero){
        return getAll()
                .stream()
                .filter(c -> c.getTipoDocumento()== tipo
                        && c.getNumeroDocumento() == numero)
                .findFirst()
                .orElse(new Cliente());
    }
    
    default List<Cliente>getLikeApellido(String apellido){
        if (apellido == null) return new ArrayList<Cliente>();
        return getAll()
                .stream()
                .filter(c -> c.getApellido().toLowerCase().contains(apellido.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    default List<Cliente>getLikeNombreApellido(String nombre, String apellido){
        if (apellido == null || nombre == null) return new ArrayList<Cliente>();
        return getAll()
                .stream()
                .filter(c -> c.getNombre().toLowerCase().contains(nombre.toLowerCase())
                        && c.getApellido().toLowerCase().contains(apellido.toLowerCase()))
                .collect(Collectors.toList());
    }
}
