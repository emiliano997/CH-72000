import animals.Dog;
import users.User;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("¿Queres crear un animal o un usuario?");
    System.out.println("1. Animal");
    System.out.println("2. Usuario");

    int option = sc.nextInt();

    if (option == 1) {
      Dog dog = new Dog();
      dog.setName("Firulais");
      dog.setBreed("Golden Retriever");
      dog.setSize(1.5);

      System.out.println("Mascota creada");
    } else if (option == 2) {
      User user = new User();
      user.setUsername("Facu");
      user.setPassword("123456");
      user.setEmail("facu@gmail.com");

      System.out.println("Usuario creado");
    }


  }
}