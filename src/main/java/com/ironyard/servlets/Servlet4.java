package com.ironyard.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by osmanidris on 1/12/17.
 */
@WebServlet(name = "Servlet4",urlPatterns = "/allLeapYears")
public class Servlet4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String responseMsg ="Leap years between 0 and 3000 are: <br/><table border=\"1\">";
        for (int i=0; i<3001;i++){
            if(isLeapYear(i)){
                responseMsg = responseMsg+"<tr><td>"+i+"</td></tr>";
            }
        }
        responseMsg = responseMsg + "</table>";
        response.getWriter().write(responseMsg);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public boolean isLeapYear(int year){
        boolean isLeapYear = false;
        if(year%100 == 0 && year%400==0){
            isLeapYear = true;
        }else if(year%4 == 0){
            isLeapYear = true;
        }
        return isLeapYear;
    }
}
