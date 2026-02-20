public class Perro extends Animal{

    public Perro(String nombre) {
        super(nombre);
    }
    @Override
    public void hacerSonido(){
        System.out.println(getNombre()+ " Esta ladrando");
    }

    public void marcarTerritorio(){
        System.out.println(getNombre() + " Esta alzando la patita");
    }
}
