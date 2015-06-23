package net.bhpachulski.tddcriteriaserver.model;

import java.sql.Blob;
import java.util.Date;

/**
 *
 * @author bhpachulski
 */
public class StudentFile {
    
    private int id;
    private int studentId;
    private Blob file;
    private Date sentIn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Blob getFile() {
        return file;
    }

    public void setFile(Blob file) {
        this.file = file;
    }

    /**
     * @return the sentIn
     */
    public Date getSentIn() {
        return sentIn;
    }

    /**
     * @param sentIn the sentIn to set
     */
    public void setSentIn(Date sentIn) {
        this.sentIn = sentIn;
    }
    
    
            
}
