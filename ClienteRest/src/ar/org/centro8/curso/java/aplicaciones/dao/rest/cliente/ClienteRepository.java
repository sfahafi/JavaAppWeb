package ar.org.centro8.curso.java.aplicaciones.dao.rest.cliente;
import ar.org.centro8.curso.java.aplicaciones.dao.interfaces.I_ClienteRepository;
import ar.org.centro8.curso.java.aplicaciones.entities.Cliente;
import java.util.List;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class ClienteRepository implements I_ClienteRepository{
    private String uri;

    public ClienteRepository(String uri) {
        this.uri = uri;
    }
        
    @Override
    public void save(Cliente cliente) {
        
        try {
        
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri+"alta?nombre="+cliente.getNombre()
                            +"&apellido="+cliente.getApellido()
                            +"&tipoDocumento="+cliente.getTipoDocumento()
                            +"&numeroDocumento="+cliente.getNumeroDocumento()
                            +"&direccion="+cliente.getDireccion()
                            +"&comentarios"+cliente.getComentarios()
                    ))
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());

        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void remove(Cliente cliente) {
        
    }

    @Override
    public void update(Cliente cliente) {
        
    }

    @Override
    public List<Cliente> getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
        
    }
    
}
