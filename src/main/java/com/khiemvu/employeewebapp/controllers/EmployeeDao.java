/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.khiemvu.employeewebapp.controllers;

import com.khiemvu.employeewebapp.models.Employee;
import java.sql.*;
import java.util.*;

/**
 *
 * @author vgkhiem
 */
public class EmployeeDao {

    public static List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();

        try {
            Connection con = ConnectDB.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "SELECT emp.id, emp.name, emp.age, emp.image, emp.salary, dep.id, dep.name, pos.id, pos.name\n"
                    + "FROM employees as emp "
                    + "	join departments as dep on emp.department_id = dep.id"
                    + "	join positions as pos on emp.position_id = pos.id "
                    + "ORDER BY emp.id DESC "
            );
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setAge(rs.getInt(3));
                e.setImage(rs.getString(4));
                e.setSalary(rs.getInt(5));
                e.setDepartmentId(rs.getInt(6));
                e.setDepartmentName(rs.getString(7));
                e.setPositionId(rs.getInt(8));
                e.setPositionName(rs.getString(9));
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
            Connection con = ConnectDB.getConnection();
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
            Connection con = ConnectDB.getConnection();
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
            Connection con = ConnectDB.getConnection();
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
            Connection con = ConnectDB.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from employees where id = " + String.valueOf(id));
            status = ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public static void main(String[] args) {
        List<Employee> list = getAllEmployees();

//    Employee employee = getEmployeeById(2);
//    employee.setName("alo123");
        System.out.println(list);
    }
}
