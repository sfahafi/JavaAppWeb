package ar.org.centro8.curso.java.aplicaciones.rest;
import ar.org.centro8.curso.java.aplicaciones.entities.Cliente;
import ar.org.centro8.curso.java.aplicaciones.enumerados.TipoDocumento;
import ar.org.centro8.curso.java.aplicaciones.interfaces.I_ClienteRepository;
import ar.org.centro8.curso.java.aplicaciones.jpa.ClienteRepository;
import com.google.gson.Gson;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("clientes/v1")
public class ClienteServicio {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
    I_ClienteRepository cr = new ClienteRepository(emf);
                
    @GET
    public String info(){
        return "Servicio de clientes activo";
    }
    /*
    http://localhost:8080/Server/clientes/v1/alta?nombre=Juan&apellido=perez&tipoDocumento=DNI&numeroDocumento=90909091&direcion=medrano162&comentarios=null
    */
    @GET
    @Path("alta")
    public String alta(@QueryParam("nombre")String nombre,
            @QueryParam("apellido")String apellido,
            @QueryParam("tipoDocumento")String tipoDocumento,
            @QueryParam("numeroDocumento")String numeroDocumento,
            @QueryParam("direccion")String direccion,
            @QueryParam("comentarios")String comentarios
    ){
        Cliente cliente=new Cliente(
                nombre,
                apellido,
                TipoDocumento.valueOf(tipoDocumento),
                numeroDocumento,
                direccion,
                comentarios
        );        
        cr.save(cliente);
        return cliente.getId()+"";        
    }
        
    
    @GET
    @Path("baja")
    public String baja(@QueryParam("id")String id){
        try {
            cr.remove(cr.getById(Integer.parseInt(id)));
            return "true";
        } catch (Exception e) {
            return "false";
        }
    }
    
        
//    @GET
//    @Path("all")
//    public String getAll(){
//        String text="";
//        for(Cliente c:cr.getAll()) text+=c+"\n";
//        return text;
//    }
    
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String listJson(){        
        return new Gson().toJson(cr.getAll());
    }
    
    @GET
    @Path("actualizar")
    public String update(@QueryParam("nombre")String nombre,
            @QueryParam("apellido")String apellido,
            @QueryParam("tipoDocumento")String tipoDocumento,
            @QueryParam("numeroDocumento")String numeroDocumento,
            @QueryParam("direccion")String direccion,
            @QueryParam("comentarios")String comentarios
    ){
        Cliente cliente=new Cliente(
                nombre,
                apellido,
                TipoDocumento.valueOf(tipoDocumento),
                numeroDocumento,
                direccion,
                comentarios
        );        
        cr.update(cliente);
        return cliente.toString();        
    }
        
    
    @GET
    @Path("likeApellido")
    public String getLikeApellido(@QueryParam("apellido") String apellido){
        String text="";
        for(Cliente c: cr.getLikeApellido(apellido)) text+=c+"\n";
        return text;
    }
    
    
   
}
