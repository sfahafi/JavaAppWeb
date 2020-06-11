package ar.org.centro8.curso.java.aplicaciones.dao.rest.cliente;
import ar.org.centro8.curso.java.aplicaciones.dao.interfaces.I_ClienteRepository;
import ar.org.centro8.curso.java.aplicaciones.entities.Cliente;
import java.util.List;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
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
            
            cliente.setId(Integer.parseInt(response.body()));
            
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
        List<Cliente> list = new ArrayList();
 
        try {            
        
        HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri+"all")).build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            
            String resp = response.body();           
            System.out.println(resp);
            
            String[] lines = resp.split("Cliente");
            for(String l:lines){
                System.out.println(l);
            }
            
        } catch (Exception e) { e.printStackTrace(); }   
        return list;
    }
    
}