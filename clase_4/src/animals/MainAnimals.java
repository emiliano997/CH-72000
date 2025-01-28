package animals;

public class MainAnimals {

  public static void main(String[] args) {
    // Instanciación de una clase
    Dog firulais = new Dog();

    firulais.setName("Firulais");
    firulais.setBreed("Golden Retriever");
    firulais.setSize(1.5);

    System.out.println();

    System.out.println("Nombre: " + firulais.getName());
    System.out.println("Raza: " + firulais.getBreed());
    System.out.println("Tamaño: " + firulais.getSize() + " metros");

    firulais.bark();
    firulais.eat();

    firulais.sleep(5);

    firulais.play("soccer", 2, "gold medal");

    // Metodo estático
    Dog.callDogs();
  }
}
