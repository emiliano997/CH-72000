package users;

import java.util.ArrayList;

public class MainUsers {

  public static void main(String[] args) {
    User facu = new User();

    User.userCounter();

    facu.setUsername("Facu");
    facu.setPassword("123456");
    facu.setEmail("facu@gmail.com");

    User anderson = new User();

    User.userCounter();

    anderson.setUsername("Anderson");
    anderson.setPassword("123456");
    anderson.setEmail("anderson@gmail.com");

    ArrayList<User> users = new ArrayList<User>();
    users.add(facu);
    users.add(anderson);

    facu.addUser(users); // Se pasa la referencia de users

    System.out.println("Users");
    for (User u : users) {
      System.out.println(u.getUsername());
    }

    System.out.println("Users count: " + User.userCount);

    User pablo = new User("Pablo", "123456", "pablo@gmail.com");

    System.out.println(pablo.getUsername());
  }
}
