package com.ironyard.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/**
 * Created by osmanidris on 1/12/17.
 */
@WebServlet(name = "Servlet3",urlPatterns = "/daysAge")
public class Servlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH);
        LocalDate ldtBirthDate = LocalDate.parse(request.getParameter("dob"), dtf);
        LocalDate ldtCurrDate = LocalDate.now();

        long lDaysDiff = ChronoUnit.DAYS.between(ldtBirthDate, ldtCurrDate);
        response.getWriter().write("Your age is "+lDaysDiff+" days");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
