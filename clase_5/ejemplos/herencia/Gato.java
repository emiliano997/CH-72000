package clase_5.ejemplos.herencia;

import java.util.Objects;

public class Gato extends Animal {

  public Gato() {

  }

  public Gato(String name, int age) {
    this.name = name;
    this.age = age;
    this.legs = 4;
  }

  public void makeSound() {
    System.out.println("Miau");
  };

  public void eat() {
    System.out.println("The cat is eating");
  };

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;

    if (o == null || getClass() != o.getClass())
      return false;

    Gato gato = (Gato) o;
    return age == gato.age && legs == gato.legs && Objects.equals(name, gato.name);

  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age, legs);
  }
}
