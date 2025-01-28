package animals;

// Clase -> Molde
public class Dog {
  // Atributos
  double size;
  String name;
  String breed;

  // Métodos
  protected void bark() {
    System.out.println("Woof!");
  }

  public void play(String game, int hours, String prize) {
    System.out.println("Playing " + game + " for " + hours + " hours...");
    System.out.println("And winning " + prize + "...");
  }

  // Los metodos se llaman igual, pero la firma es diferente
  // Firma -> nombre del metodo + parámetros que recibe
  public void eat() {
    System.out.println("Eating food...");
  }

  public void eat(String food) { // -> food: Es un parámetro
    System.out.println("Eating " + food + "...");
  }

  public static void callDogs() {
    System.out.println("Calling dogs...");
  }

  public void sleep(int hours) {
    int totalHours = calculateSleepTime(hours);
    System.out.println("Sleeping for " + totalHours + " hours...");
  }

  private int calculateSleepTime(int hours) {
    return hours * 2;
  }

  // Getters y setters
  public double getSize() {
    return size;
  }

  public void setSize(double size) {
    this.size = size;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBreed() {
    return breed;
  }

  public void setBreed(String breed) {
    this.breed = breed;
  }
}
