package ar.org.centro8.curso.java.aplicaciones.rest;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("rest")
public class RestApplication extends Application{
    @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> classes = new HashSet<>();
        classes.add(ClienteServicio.class);
        classes.add(FacturaServicio.class);
        classes.add(ArticuloServicio.class);
        return classes;
    }
    
}
