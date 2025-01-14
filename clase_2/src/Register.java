import java.util.Scanner;

public class Register {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String[] users = new String[2];

    System.out.println("Ingrese el nombre del usuario 1: ");
    users[0] = sc.nextLine();

    System.out.println("Ingrese el nombre del usuario 2: ");
    users[1] = sc.nextLine();

    System.out.println("Usuario 1: " + users[0]);
    System.out.println("Usuario 2: " + users[1]);
  }

}
