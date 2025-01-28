package users;

import java.util.ArrayList;

public class User {
  String username;
  String password;
  String email;
  static int userCount = 0;
  static final int MAX_USERS = 10;

  // Contructor
  public User() {}

  public User(String username, String password, String email) {
    this.username = username;
    this.password = password;
    this.email = email;
  }

  public static void userCounter() {
    userCount++;
  }

  public void grettings(String message) {
    message = message + ", welcome to the world!";
    System.out.println(message);
  }

  public void addUser(ArrayList<User> users) {
    User user = new User();
    user.setUsername("Victoria");
    user.setPassword("123456");
    user.setEmail("victoria@gmail.com");
    users.add(user);

    for (User u : users) {
      System.out.println(u.getUsername());
    }
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    if (password.length() < 6) {
      System.out.println("Password must be at least 6 characters long");
      return; // Cortar la función
    }
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
