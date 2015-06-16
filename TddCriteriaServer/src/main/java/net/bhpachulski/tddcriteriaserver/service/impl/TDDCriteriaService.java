package net.bhpachulski.tddcriteriaserver.service.impl;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 *
 * @author bhpachulski
 */
@Path("/tddCriteriaService")
public class TDDCriteriaService {

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() throws SQLException {
        
        DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        
        String dbURL = "jdbc:derby:codejava/webdb;create=true";
        Connection conn = DriverManager.getConnection(dbURL);

        if (conn != null) {
            System.out.println("Connected to database");
        }
        
        return "Connected to database";
    }

    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response test(@FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail) {

        String uploadedFileLocation = "d://uploaded/" + fileDetail.getFileName();

        // save it
//        writeToFile(uploadedInputStream, uploadedFileLocation);

        String output = "File uploaded to : " + uploadedFileLocation;

        return Response.status(200).entity(output).build();
    }

}
