package net.bhpachulski.tddcriteriaserver.service.impl;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import net.bhpachulski.tddcriteriaserver.TddCriteriaDAO;
import net.bhpachulski.tddcriteriaserver.model.Student;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 *
 * @author bhpachulski
 */
@Path("/tddCriteriaService")
public class TDDCriteriaService {
    
    private TddCriteriaDAO dao;

    public TDDCriteriaService() throws SQLException {
        dao = new TddCriteriaDAO();
        dao.init();
    }
    
    @POST
    @Path("/addStudent")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Student> insertAluno(Student student) throws SQLException {

        dao.insertStudent(student);
         
        return dao.getAllStudents();
    }

    @POST
    @Path("/addStudentFile")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response test(
            @FormDataParam("studentId") int studentId,
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail) throws SQLException {

        dao.insertFile(studentId, uploadedInputStream);

        return Response.status(200).build();
    }

}
