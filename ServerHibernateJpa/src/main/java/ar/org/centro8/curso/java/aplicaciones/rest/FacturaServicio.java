package ar.org.centro8.curso.java.aplicaciones.rest;
import ar.org.centro8.curso.java.aplicaciones.entities.Factura;
import ar.org.centro8.curso.java.aplicaciones.enumerados.Letra;
import ar.org.centro8.curso.java.aplicaciones.interfaces.I_FacturaRepository;
import ar.org.centro8.curso.java.aplicaciones.jpa.FacturaRepository;
import com.google.gson.Gson;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("facturas/v1")
public class FacturaServicio {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
    I_FacturaRepository fr = new FacturaRepository(emf);
    
    @GET
    public String info(){
        return "Servicio de facturas activo";
    }
    
    /*
    http://localhost:8080/Server/facturas/v1/alta?letra=&numero=&fecha=&monto=&idCliente=
    */
    
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
    public String baja(
            @QueryParam("letra") String letra,
            @QueryParam("numero") String numero
    ){
        try {
            fr.remove(fr.getByLetraNumero(Letra.valueOf(letra), Integer.parseInt(numero)));
            return "true";
        } catch (Exception e) { 
            return "false";
        }
    }
    
    @GET
    @Path("allJson")
    @Produces(MediaType.APPLICATION_JSON)
    public String listJson(){
        return new Gson().toJson(fr.getAll());
    }
    
    @GET
    @Path("all")
    public String getAll(){
        String text="";
        for(Factura f:fr.getAll()) text+=f+"\n";
        return text;
    }
    
    @GET
    @Path("getLikeCliente")
    public String getLikeCliente(@QueryParam("id") String id){
        String text="";
        for(Factura f: fr.getByIdCliente(Integer.parseInt(id))) text += f +"\n";
        return text;
    }
    
    
}
