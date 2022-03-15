import java.sql.*;
import java.util.*;

public class EmployeeDao {
  public static Connection getConnection() {
    Connection con = null;
    try {
      Class.forName("org.postgresql.Driver");
      con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee_java_api", "postgres", "camvoyeu1");
    } catch (Exception e) {
      System.out.println(e);
    }
    return con;
  }

  public static List<Employee> getAllEmployees() {
    List<Employee> list = new ArrayList<Employee>();

    try {
      Connection con = EmployeeDao.getConnection();
      PreparedStatement ps = con.prepareStatement("SELECT * FROM employees");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        Employee e = new Employee();
        e.setId(rs.getInt(1));
        e.setName(rs.getString(2));
        list.add(e);
      }
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return list;
  }

  public static void main(String[] args) {
    List<Employee> list = getAllEmployees();

    System.out.println(list);
  }
}
