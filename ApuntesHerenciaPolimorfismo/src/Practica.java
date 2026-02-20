//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Practica {
    public static void main(String[] args) {

        Gato botas= new Gato("Botas");
        Perro bruno= new Perro("Bruno");

//Herencia
        botas.comer();
        botas.hacerSonido();
        System.out.println("-------------------");
        bruno.comer();
        bruno.hacerSonido();

        Animal[] animales= new Animal[3];
        animales[0]=new Perro("Rufus");
        animales[1] = new Gato("Honey");
        animales[2] = new Perro("Solovino");
//Poliformismo
        for(Animal animal: animales){
            System.out.println("-------");
            animal.comer();
            animal.hacerSonido();
        }

//Cast, solo para hacer uso de los metodos de perro, a pesar de que anmal1 es un objeto de Animal
        Animal animal1= new Perro("nicky");
        Perro perr1 = (Perro)animal1;
        perr1.marcarTerritorio();


    }
}