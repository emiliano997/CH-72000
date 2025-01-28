import java.util.Scanner;

public class GetMonth {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Ingrese el nombre del mes: ");

    String month = sc.nextLine();

    int monthNumber = switch (month.toLowerCase()) {
      case "enero" -> 1;
      case "febrero" -> 2;
      case "marzo" -> 3;
      case "abril" -> 4;
      case "mayo" -> 5;
      case "junio" -> 6;
      case "julio" -> 7;
      case "agosto" -> 8;
      case "septiembre" -> 9;
      case "octubre" -> 10;
      case "noviembre" -> 11;
      case "diciembre" -> 12;
      default -> 0;
    };

    System.out.println("El mes " + month.toLowerCase() + " tiene el número " + monthNumber);
  }
}
