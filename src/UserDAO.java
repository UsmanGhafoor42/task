import java.sql.*;

public class UserDAO  {
    public void createUser(String name, String email) {
        String query = "INSERT INTO users (name, email) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void createOrder(int id, int orderid, int ordernumber) {
        // Use backticks around `order` since it's a reserved keyword in SQL
        String query = "INSERT INTO orders (id, orderid, ordernumber) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Set the values for the placeholders
            stmt.setInt(1, id);
            stmt.setInt(2, orderid);
            stmt.setInt(3, ordernumber);

            // Execute the update
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void readUsers() {
        String query = "SELECT * FROM users";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Email: " + rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }public void readall(int id) {
        String query = "SELECT orders.orderid, users.name, users.email, orders.ordernumber, users.id\n" +
                "FROM Orders\n" +
                "INNER JOIN users ON orders.id = users.id " +
                "WHERE users.id = ?";

//        try (Connection conn = DatabaseConnection.getConnection();
//             Statement stmt = conn.createStatement();
//
//             ResultSet rs = stmt.executeQuery(query)) {
//
//            while (rs.next()) {
//                System.out.println("ID: " + rs.getInt("id"));
//                System.out.println("Name: " + rs.getString("name"));
//                System.out.println("Email: " + rs.getString("email"));
//                System.out.println("OrderId: " + rs.getString("orderid"));
//                System.out.println("OrderNumber: " + rs.getString("ordernumber"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Set the id parameter in the query
            stmt.setInt(1, id);

            // Execute the query
            ResultSet rs = stmt.executeQuery();

            // Process the ResultSet
            if (rs.next()) {
                // Retrieve data from the result set
                int orderid = rs.getInt("orderid");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int ordernumber = rs.getInt("ordernumber");
                int userId = rs.getInt("id");

                // Process or print the retrieved data
                System.out.println("Order ID: " + orderid);
                System.out.println("User Name: " + name);
                System.out.println("User Email: " + email);
                System.out.println("Order Number: " + ordernumber);
                System.out.println("User ID: " + userId);
            } else {
                System.out.println("No data found for ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(int id, String name, String email) {
        String query = "UPDATE users SET name = ?, email = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setInt(3, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateUsername(int id, String name) {
        String query = "UPDATE users SET name = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        String query = "DELETE FROM users WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
