package ar.org.centro8.curso.java.aplicaciones.dao.rest.cliente;
import ar.org.centro8.curso.java.aplicaciones.dao.interfaces.I_FacturaRepository;
import ar.org.centro8.curso.java.aplicaciones.entities.Factura;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class FacturaRepository implements I_FacturaRepository{
    private String uri;

    public FacturaRepository(String uri) {
        this.uri = uri;
    }
        

    @Override
    public void save(Factura factura) {
        try {
        
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri+"alta?letra="+factura.getLetra()
                            +"&numero="+factura.getNumero()
                            +"&fecha="+factura.getFecha()
                            +"&monto="+factura.getMonto()
                            +"&idCliente="+factura.getIdCliente()                            
                    ))
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            
            factura.setId(Integer.parseInt(response.body()));
            
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void remove(Factura factura) {
        try {
        
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri+"baja?id="+factura.getId())).build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
                                   
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void update(Factura factura) {
    }

    @Override
    public List<Factura> getAll() {
        List<Factura> list = new ArrayList();
 
        try {            
        
        HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri+"all")).build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            
            String resp = response.body();           
            System.out.println(resp);
            
//            String[] lines = resp.split("Factura");
//            for(String l:lines){
//                int longitud = l.length();
//                if(longitud > 0){
//                    l = l.substring(1, longitud-2);
//                    //System.out.println(l);
//                    String[] campos = l.split(", ");
////                    for(String c: campos){
////                        System.out.println(c);
////                    }
//                    list.add(new Factura(
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
