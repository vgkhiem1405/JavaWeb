package com.khiemvu.employeewebapp.controllers;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vgkhiem
 */
public class ConnectDB {
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
}
