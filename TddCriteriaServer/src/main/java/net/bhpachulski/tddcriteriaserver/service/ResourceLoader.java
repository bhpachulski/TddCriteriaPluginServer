package net.bhpachulski.tddcriteriaserver.service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;
import net.bhpachulski.tddcriteriaserver.service.impl.TDDCriteriaService;

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
        return classes;
    }
}