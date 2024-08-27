package model;

public class TypeBook {
    private String name;
    private String codeType;
    public TypeBook(String name, String codeType) {
        this.name = name;
        this.codeType = codeType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getCodeType() {
        return codeType;
    }
    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    @Override
    public String toString() {
        return "TypeBook { " +
                "Type Name = '" + name + '\'' +
                ", Type Code = '" + codeType + '\'' +
                '}';
    }
}
