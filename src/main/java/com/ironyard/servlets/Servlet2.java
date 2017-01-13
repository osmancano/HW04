package com.ironyard.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InterruptedIOException;

/**
 * Created by osmanidris on 1/12/17.
 */
@WebServlet(name = "Servlet2",urlPatterns = "/leap")
public class Servlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int leapYear = Integer.parseInt(request.getParameter("year"));
        String msg;
        if(isLeapYear(leapYear)){
            msg = String.format("%d is a leap year", leapYear);
        }else{
            msg = String.format("%d is not a leap year", leapYear);
        }
        response.getWriter().write(msg);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public boolean isLeapYear(int year){
        boolean isLeapYear = false;
        if(year%100 == 0){
            if(year%400==0){
                isLeapYear = true;
            }
        }else if(year%4 == 0){
            isLeapYear = true;
        }
        return isLeapYear;
    }
}
