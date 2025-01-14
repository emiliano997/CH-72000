import java.util.Random;

public class Main {
  public static void main(String[] args) {
    // Condicionales
    // If
//    int random = (int) (Math.random() * 10) + 1; // Genera un número aleatorio
//
//    System.out.println("El número aleatorio es: " + random);
//
//    if (random > 5) {
//      System.out.println("El número es mayor que 5");
//    } else {
//      System.out.println("El número es menor que 5");
//    }

    // Obtener el mes actual
//    int month = (int) (Math.random() * 12) + 1;
//
//    if (month == 1) {
//      System.out.println("Enero");
//    } else if (month == 2) {
//      System.out.println("Febrero");
//    } else if (month == 3) {
//      System.out.println("Marzo");
//    } else if (month == 4) {
//      System.out.println("Abril");
//    } else if (month == 5) {
//      System.out.println("Mayo");
//    } else if (month == 6) {
//      System.out.println("Junio");
//    } else if (month == 7) {
//      System.out.println("Julio");
//    } else if (month == 8) {
//      System.out.println("Agosto");
//    } else if (month == 9) {
//      System.out.println("Septiembre");
//    } else if (month == 10) {
//      System.out.println("Octubre");
//    } else if (month == 11) {
//      System.out.println("Noviembre");
//    } else if (month == 12) {
//      System.out.println("Diciembre");
//    } else {
//      System.out.println("Error");
//    }

    // Switch
    int day = (int) (Math.random() * 7) + 1;

    // Switch nuevo
    String dayName = switch (day) {
      case 1 -> "Lunes";
      case 2 -> "Martes";
      case 3 -> "Miércoles";
      case 4 -> "Jueves";
      case 5 -> "Viernes";
      case 6 -> "Sábado";
      case 7 -> "Domingo";
      default -> "Error";
    };

    // Switch viejo
    //    switch (day) {
//      case 1:
//        dayName = "Lunes";
//        break;
//
//      case 2:
//        dayName = "Martes";
//        break;
//
//      case 3:
//        dayName = "Miércoles";
//        break;
//
//      case 4:
//        dayName = "Jueves";
//        break;
//
//      case 5:
//        dayName = "Viernes";
//        break;
//
//      case 6:
//        dayName = "Sábado";
//        break;
//
//      case 7:
//        dayName = "Domingo";
//        break;
//
//      default:
//        dayName = "Error";
//        break;
//    }

    // Operador Ternario
    String username = "admin";
    String password = "123456";

    String message = username == "admin" ? "Bienvenido" : "Acceso Denegado";

//    System.out.println(message);

    // Random
    double random = (int) (Math.random() * 5) + 1;
    System.out.println(random);

  }
}
