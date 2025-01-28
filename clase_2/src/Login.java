import java.util.Scanner;

public class Login {

  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      System.out.println("Ingrese el nombre de usuario: ");
      String username = sc.nextLine();

      System.out.println("Ingrese la contraseña: ");
      String password = sc.nextLine();

      boolean isLoggedIn = switch (username) {
        case "admin" -> password.equals("123456");
        case "emipe" -> password.equals("123456");
        case "victoria" -> password.equals("123456");
        case "alexis" -> password.equals("123456");
        default -> false;
      };

      if (!isLoggedIn) {
        System.out.println("Acceso Denegado");
      } else {
        System.out.println("Bienvenido");
      }
  }
}
