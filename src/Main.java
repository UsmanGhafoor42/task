import java.util.Scanner;

public class Main  {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        // Create a new user
//        Scanner myObj = new Scanner(System.in);
//        System.out.println("Enter Your Name");

//        String Name = myObj.nextLine();

//        userDAO.createUser("Shah k", "shah@example.com");
//       userDAO.createOrder(1,4,23132);

        // Read users
//        userDAO.readUsers();
       userDAO.readall(2);

        // Update a user
//        userDAO.updateUser(1, "Jane wick", "john@example.com");


//        userDAO.updateUsername(4, Name);

        // Delete a user
//        userDAO.deleteUser(1);

        // Read users again to see the changes
//        userDAO.readUsers();
    }
}
