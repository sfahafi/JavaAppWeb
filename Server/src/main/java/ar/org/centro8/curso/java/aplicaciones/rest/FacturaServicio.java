package ar.org.centro8.curso.java.aplicaciones.rest;
import ar.org.centro8.curso.java.aplicaciones.connectors.Connector;
import ar.org.centro8.curso.java.aplicaciones.dao.jdbc.FacturaRepository;
import ar.org.centro8.curso.java.aplicaciones.entities.Factura;
import ar.org.centro8.curso.java.aplicaciones.enumerados.Letra;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("facturas/v1")
public class FacturaServicio {
    @GET
    public String info(){
        return "Servicio de facturas activo";
    }
    
    @GET
    @Path("alta")
    public String alta(
            @QueryParam("letra") String letra,
            @QueryParam("numero") String numero,
            @QueryParam("fecha") String fecha,
            @QueryParam("monto") String monto,
            @QueryParam("idCliente") String idCliente
    ){
        try {
            FacturaRepository fr = new FacturaRepository(Connector.getConnection());
            Factura factura = new Factura(
                    Letra.valueOf(letra),
                    Integer.parseInt(numero),
                    fecha,
                    Double.parseDouble(monto),
                    Integer.parseInt(idCliente)
            );
            fr.save(factura);            
            return "true";
        } catch (Exception e) {
            return "false";
        }
    }
    
    @GET
    @Path("baja")
    public String baja(@QueryParam("id") String id){
        try {
            FacturaRepository fr = new FacturaRepository(Connector.getConnection());
            fr.remove(fr.getById(Integer.parseInt(id)));
            return "true";
        } catch (Exception e) {
            return "false";
        }
    }
    
    @GET
    @Path("all")
    public String all(){
        String text = "";
        FacturaRepository fr = new FacturaRepository(Connector.getConnection());
        for(Factura f: fr.getAll()) text += f +"\n";
        return text;
    }
    
//    @GET
//    @Path("getLikeCliente")
//    public String getLikeCliente(@QueryParam("id") String id){
//        String text="";
//        FacturaRepository fr = new FacturaRepository(Connector.getConnection());
//        for(Factura f: fr.getByIdCliente(String.valueOf(id)) text += f +"\n";
//        return text;
//    }
    
    
}
