package net.bhpachulski.tddcriteriaserver.service.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author bhpachulski
 */

@Path("/tddCriteriaService")
public class TDDCriteriaService {
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello World from Tomcat Embedded with Jersey!";
    }
    
}
