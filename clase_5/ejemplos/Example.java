package clase_5.ejemplos;

import clase_5.ejemplos.herencia.*;

public class Example {

  public static void main(String[] args) {
    Perro perro = new Perro();
    perro.setAge(90);
    perro.setName("Rufus");

    System.out.println("El perro se llama " + perro.getName());

    Gato gato = new Gato();
    gato.setAge(20);
    gato.setName("Suertudo");

    System.out.println("El gato se llama " + gato.getName());

    Perro perro_2 = perro.clone();
    perro_2.setName("Rufus 2");

    System.out.println("El perro se llama " + perro_2.getName());
    System.out.println("El perro se llama " + perro.getName());

    Perro perro_3 = perro;
    perro_3.setName("Rufus 3");

    System.out.println("El perro 3 se llama " + perro_3.getName());
    System.out.println("El perro 1 se llama " + perro.getName());
    System.out.println("El perro 2 se llama " + perro_2.getName());

  }

}
