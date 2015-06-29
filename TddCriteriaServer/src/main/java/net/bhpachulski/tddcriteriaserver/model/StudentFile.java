package net.bhpachulski.tddcriteriaserver.model;

import java.io.InputStream;
import java.sql.Blob;
import java.util.Date;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bhpachulski
 */
public class StudentFile {
    
    private int id;
    private int studentId;    
    private Date sentIn;
    private String fileName;
    
    @XmlTransient
    private InputStream fileIs;
    
    @XmlTransient
    private Blob file;
    
    private FileType type;

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

    public FileType getType() {
        return type;
    }

    public void setType(FileType type) {
        this.type = type;
    }

    public InputStream getFileIs() {
        return fileIs;
    }

    public void setFileIs(InputStream fileIs) {
        this.fileIs = fileIs;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
