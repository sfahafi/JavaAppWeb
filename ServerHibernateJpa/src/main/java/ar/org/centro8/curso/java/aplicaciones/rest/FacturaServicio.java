package ar.org.centro8.curso.java.aplicaciones.rest;
import ar.org.centro8.curso.java.aplicaciones.entities.Factura;
import ar.org.centro8.curso.java.aplicaciones.enumerados.Letra;
import ar.org.centro8.curso.java.aplicaciones.interfaces.I_FacturaRepository;
import ar.org.centro8.curso.java.aplicaciones.jpa.FacturaRepository;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("facturas/v1")
public class FacturaServicio {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
    I_FacturaRepository fr = new FacturaRepository(emf);
    
    @GET
    public String info(){
        return "Servicio de facturas activo";
    }
    
    @GET
    @Path("alta")
    public String alta(
            @QueryParam("letra") char letra,
            @QueryParam("numero") String numero,
            @QueryParam("fecha") String fecha,
            @QueryParam("monto") String monto,
            @QueryParam("idCliente") String idCliente
    ){
        try {
            Factura factura = new Factura(
                    letra,
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
            @QueryParam("letra") char letra,
            @QueryParam("numero") String numero
    ){
        try {
            fr.remove(fr.getByLetraNumero(letra, Integer.parseInt(numero)));
            return "true";
        } catch (Exception e) {
            return "false";
        }
    }
    
    @GET
    @Path("all")
    public String getAll(){
        String text = "";
        for(Factura f: fr.getAll()) text += f +"\n";
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
