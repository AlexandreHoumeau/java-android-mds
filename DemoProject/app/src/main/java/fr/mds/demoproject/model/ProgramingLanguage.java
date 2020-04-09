package fr.mds.demoproject.model;

public class ProgramingLanguage {

    private String name;
    private String detail;

    public ProgramingLanguage() {
    }

    public ProgramingLanguage(String name, String detail) {
        this.name = name;
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public String getDetail() {
        return detail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return name;
    }
}
