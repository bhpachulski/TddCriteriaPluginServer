package net.bhpachulski.tddcriteria.model;

public class Student {
	 
    private int id;
    private String name;
    
    private boolean excluido = false;
    
    private ExperimentalGroup experimentalType;
    
    public Student() {}
    
    public Student(String name) {
    	this.setName(name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExperimentalGroup getExperimentalType() {
        return experimentalType;
    }

    public void setExperimentalType(ExperimentalGroup experimentalType) {
        this.experimentalType = experimentalType;
    }

    public boolean isExcluido() {
        return excluido;
    }

    public void setExcluido(boolean excluido) {
        this.excluido = excluido;
    }
}