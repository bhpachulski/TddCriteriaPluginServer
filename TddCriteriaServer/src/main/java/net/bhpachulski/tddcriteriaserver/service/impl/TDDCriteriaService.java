package net.bhpachulski.tddcriteriaserver.service.impl;

import java.io.InputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import net.bhpachulski.tddcriteriaserver.dao.TddCriteriaDAO;
import net.bhpachulski.tddcriteriaserver.model.FileType;
import net.bhpachulski.tddcriteriaserver.model.Student;
import net.bhpachulski.tddcriteriaserver.model.StudentFile;
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
    public Student insertAluno(Student student) throws SQLException {
        return dao.insertStudent(student);
    }
    
    @POST
    @Path("/addStudentFile")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public StudentFile test(
            @FormDataParam("studentId") int studentId,
            @FormDataParam("fileType") int fileType,
            @FormDataParam("fileName") String fileName,
            @FormDataParam("file") InputStream uploadedInputStream) throws SQLException {

        StudentFile sf = new StudentFile();
        sf.setStudentId(studentId);
        sf.setFileIs(uploadedInputStream);
        sf.setType(FileType.getFileType(fileType));
        sf.setFileName(fileName);
        
        return dao.insertStudentFile(sf);
    }
    
    @GET
    @Path("/allFiles")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StudentFile> getAllFiles () throws SQLException, ParseException {
        return dao.getAllFiles();
    }
}