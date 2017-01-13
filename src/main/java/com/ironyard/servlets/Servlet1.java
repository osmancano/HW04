package com.ironyard.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

/**
 * Created by osmanidris on 1/12/17.
 */
@WebServlet(name = "Servlet1",urlPatterns = "/graduate")
public class Servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("Helo osmab");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LocalDate todayDate = LocalDate.now();
        LocalDate graduationDate = LocalDate.of(2017, Month.MARCH, 31);

        float daysToGraduate = Duration.between(todayDate.atTime(0,0),graduationDate.atTime(0,0)).toDays();
        request.setAttribute("noOfDays", daysToGraduate);
        // forward to display JSP
        String nextJSP = "/daysLeft.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request,response);
    }
}
