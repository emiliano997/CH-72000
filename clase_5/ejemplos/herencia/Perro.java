package clase_5.ejemplos.herencia;

import java.util.Objects;

public class Perro extends Animal {

  public Perro() {

  }

  public Perro(String name, int age) {
    this.name = name;
    this.age = age;
    this.legs = 4;
  }

  public void makeSound() {
    System.out.println("Guau");
  };

  public void eat() {
    System.out.println("The dog is eating");
  };

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;

    if (o == null || getClass() != o.getClass())
      return false;

    Perro perro = (Perro) o;
    return age == perro.age && legs == perro.legs && Objects.equals(name, perro.name);

  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age, legs);
  }

  @Override
  public Perro clone() {
    return new Perro(this.name, this.age);
  }

}
