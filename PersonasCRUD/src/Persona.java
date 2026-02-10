public class Persona {
    private int id;
    private String name;
    private boolean ACTIVAS;
    public Persona() {
    }
    public Persona(int id, String name) {
        this.id = id;
        this.name = name;
        this.ACTIVAS = true;
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
    public boolean ACTIVAS() {
        return ACTIVAS;
    }
    public void setActive(boolean ACTIVAS) {
        this.ACTIVAS = ACTIVAS;
    }
    @Override
    public String toString() {
        return "Persona{id=" + id + ", nombre=" + name + ", ACTIVAS=" + ACTIVAS + "}";
    }
}