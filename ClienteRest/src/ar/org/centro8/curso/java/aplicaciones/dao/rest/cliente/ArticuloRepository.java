package ar.org.centro8.curso.java.aplicaciones.dao.rest.cliente;
import ar.org.centro8.curso.java.aplicaciones.dao.interfaces.I_ArticuloRepository;
import ar.org.centro8.curso.java.aplicaciones.entities.Articulo;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ArticuloRepository implements I_ArticuloRepository{
    
    private String uri;

    public ArticuloRepository(String uri) {
        this.uri = uri;
    }    

    @Override
    public void save(Articulo articulo) {
        try {
        
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri+"alta?descripcion="+articulo.getDescripcion()
                            +"&costo="+articulo.getCosto()
                            +"&precio="+articulo.getPrecio()
                            +"&stock="+articulo.getStock()
                            +"&stockMin="+articulo.getStockMin()
                            +"&stockMax="+articulo.getStockMax()
                    ))
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            
            articulo.setId(Integer.parseInt(response.body()));
            
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void remove(Articulo articulo) {
        try {
        
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri+"baja?id="+articulo.getId())).build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
                                   
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void update(Articulo articulo) {
        
    }

    @Override
    public List<Articulo> getAll() {
        List<Articulo> list = new ArrayList();
 
        try {            
        
        HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri+"all")).build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            
            String resp = response.body();           
            System.out.println(resp);
            
//            String[] lines = resp.split("Articulo");
//            for(String l:lines){
//                int longitud = l.length();
//                if(longitud > 0){
//                    l = l.substring(1, longitud-2);
//                    //System.out.println(l);
//                    String[] campos = l.split(", ");
////                    for(String c: campos){
////                        System.out.println(c);
////                    }
//                    list.add(new Articulo(
//                            Integer.parseInt(campos[0].substring(3)),
//                            campos[1].substring(7),
//                            campos[2].substring(9),
//                            TipoDocumento.valueOf(campos[3].substring(14)),
//                            Integer.parseInt(campos[4].substring(16)),
//                            campos[5].substring(10),
//                            campos[6].substring(12)
//                    ));
//                }
//                
//            }
            
        } catch (Exception e) { e.printStackTrace(); }   
        return list;
    }
    
}
