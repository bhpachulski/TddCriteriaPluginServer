package net.bhpachulski.tddcriteriaserver;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import net.bhpachulski.tddcriteriaserver.model.Student;
import net.bhpachulski.tddcriteriaserver.model.StudentFile;

import net.bhpachulski.tddcriteriaserver.util.Util;

/**
 *
 * @author bhpachulski
 */
public class TddCriteriaDAO {
    //        jdbc:derby:;shutdown=true
    private String dbURL = "jdbc:derby:tddCriteriaDB/db;create=true";
    private Properties sqlProperties;
    private List<String> REQUIRED_TABLES;
    
    private Connection conn;

    public TddCriteriaDAO() throws SQLException {
        if (conn == null)
            conn = DriverManager.getConnection(this.dbURL);
        
        sqlProperties = new Util().loadProperties("SQL.properties");
        REQUIRED_TABLES = Arrays.asList(sqlProperties.getProperty("SQL_TABLES").split(";"));
    }
    
    public void init () throws SQLException {
        String SQL_CREATE_FILES = sqlProperties.getProperty("SQL_CREATE_FILES");
        String SQL_CREATE_STUDENTS = sqlProperties.getProperty("SQL_CREATE_STUDENTS");
        
        if (!getAllTables ().containsAll(REQUIRED_TABLES)) {
            conn.prepareStatement(SQL_CREATE_STUDENTS).execute();
            conn.prepareStatement(SQL_CREATE_FILES).execute();
        }
        
    }
    
    public List<String> getAllTables () throws SQLException {
        List<String> tables = new ArrayList<String>();
        DatabaseMetaData dbmd = conn.getMetaData();
        
        ResultSet rs = dbmd.getTables("tddCriteriaDB", null, null, null);
        while (rs.next()) {
            tables.add(rs.getString(3));
        }
    
        return tables;
    }
    
    public void insertFile (int idStudent, InputStream file) throws SQLException {        
        PreparedStatement ps = conn.prepareStatement("INSERT INTO FILES (idStudent, file) VALUES (?, ?)");
        ps.setInt(1, idStudent);
        ps.setBinaryStream(2, file);
        ps.execute();
    }
    
    public void insertStudent (Student student) throws SQLException {        
        PreparedStatement ps = conn.prepareStatement("INSERT INTO STUDENTS (name) VALUES (?)");
        ps.setString(1, student.getName());
        ps.execute();
    }
    
    public List<Student> getAllStudents () throws SQLException {
        
        List<Student> students = new ArrayList<Student>();
        
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM STUDENTS");
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            
            students.add(student);
        }
        
        return students;
    }
    
    public List<StudentFile> getAllFiles () throws SQLException {
        
        List<StudentFile> studentFiles = new ArrayList<StudentFile>();
        
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM FILES");
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            StudentFile studentFile = new StudentFile();
            studentFile.setId(rs.getInt("id"));
            studentFile.setStudentId(rs.getInt("idStudent"));
//            studentFile.setFile(rs.getBlob("file"));
            
            studentFiles.add(studentFile);
        }
        
        return studentFiles;
    }
    
    public void close () throws SQLException {
        conn.close();
    }
    
}
