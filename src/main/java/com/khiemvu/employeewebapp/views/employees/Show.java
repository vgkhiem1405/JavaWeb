/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.khiemvu.employeewebapp.views.employees;

import com.khiemvu.employeewebapp.controllers.EmployeeDao;
import com.khiemvu.employeewebapp.models.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vgkhiem
 */
@WebServlet(name = "Show", urlPatterns = {"/show"})
public class Show extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        int id = Integer.valueOf(request.getParameter("id"));

        Employee emp = EmployeeDao.getEmployeeById(id);
        request.setAttribute("emp", emp);
        request.getRequestDispatcher("jsps/show.jsp").forward(request, response);
    }

}
