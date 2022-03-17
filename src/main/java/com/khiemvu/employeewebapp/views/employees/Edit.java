package com.khiemvu.employeewebapp.views.employees;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
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
@WebServlet(urlPatterns = {"/edit"})
public class Edit extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        int id = Integer.parseInt(request.getParameter("id"));
        Employee emp = EmployeeDao.getEmployeeById(id);
        request.setAttribute("emp", emp);
        request.getRequestDispatcher("jsps/new.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String name = request.getParameter("name");
        int id = Integer.valueOf(request.getParameter("id"));

        Employee emp = new Employee(id,name);
       
        int status = EmployeeDao.update(emp);
        request.setAttribute("status", status);
        request.getRequestDispatcher("jsps/new.jsp").forward(request, response);
    }

}
