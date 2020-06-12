package ar.org.centro8.curso.java.aplicaciones.dao.rest.cliente;
import ar.org.centro8.curso.java.aplicaciones.dao.interfaces.I_ClienteRepository;
import ar.org.centro8.curso.java.aplicaciones.entities.Cliente;
import ar.org.centro8.curso.java.aplicaciones.enumerados.TipoDocumento;
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
        try {
        
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri+"baja?id="+cliente.getId())).build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
                                   
        } catch (Exception e) { e.printStackTrace(); }
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
            //System.out.println(resp);
            
            String[] lines = resp.split("Cliente");
            for(String l:lines){
                int longitud = l.length();
                if(longitud > 0){
                    l = l.substring(1, longitud-2);
                    //System.out.println(l);
                    String[] campos = l.split(", ");
//                    for(String c: campos){
//                        System.out.println(c);
//                    }
                    list.add(new Cliente(
                            Integer.parseInt(campos[0].substring(3)),
                            campos[1].substring(7),
                            campos[2].substring(9),
                            TipoDocumento.valueOf(campos[3].substring(14)),
                            Integer.parseInt(campos[4].substring(16)),
                            campos[5].substring(10),
                            campos[6].substring(12)
                    ));
                }
                
            }
            
        } catch (Exception e) { e.printStackTrace(); }   
        return list;
    }
    
}