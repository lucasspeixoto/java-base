package concepts.entities;

public class Department {

    private String name;

    private Department() {

    }

    private Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
