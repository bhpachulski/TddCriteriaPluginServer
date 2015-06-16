package net.bhpachulski.tddcriteriaserver.service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;
import net.bhpachulski.tddcriteriaserver.service.impl.TDDCriteriaService;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

/**
 *
 * @author bhpachulski
 */
public class ResourceLoader extends Application{
 
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        
        // register root resource
        classes.add(TDDCriteriaService.class);
        classes.add(MultiPartFeature.class);
        
        return classes;
    }
}