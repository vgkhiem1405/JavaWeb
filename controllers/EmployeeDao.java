import java.sql.*;
import java.util.*;

import models.Employee;

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

  public static Employee getEmployeeById(int id) {
    Employee employee = new Employee();

    try {
      Connection con = EmployeeDao.getConnection();
      PreparedStatement ps = con
          .prepareStatement("SELECT * FROM employees WHERE employees.id = " + String.valueOf(id) + "limit 1");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        employee.setId(rs.getInt(1));
        employee.setName(rs.getString(2));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return employee;
  }

  public static int save(Employee e) {
    int status = 0;

    try {
      Connection con = EmployeeDao.getConnection();
      PreparedStatement ps = con.prepareStatement("insert into employees (name) values ('" + e.getName() + "')");

      status = ps.executeUpdate();

      con.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return status;
  }

  public static int update(Employee e) {
    int status = 0;
    try {
      Connection con = EmployeeDao.getConnection();
      PreparedStatement ps = con
          .prepareStatement(
              "update employees set name = '" + e.getName() + "' where id = " + String.valueOf(e.getId()));

      status = ps.executeUpdate();

      con.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return status;
  }

  public static int delete(int id) {
    int status = 0;
    try {
      Connection con = EmployeeDao.getConnection();
      PreparedStatement ps = con.prepareStatement("delete from employees where id = " + String.valueOf(id));
      status = ps.executeUpdate();

      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return status;
  }

  public static void main(String[] args) {
    // List<Employee> list = getAllEmployees();

    Employee employee = getEmployeeById(2);
    employee.setName("alo123");

    System.out.println(delete(4));
  }
}
