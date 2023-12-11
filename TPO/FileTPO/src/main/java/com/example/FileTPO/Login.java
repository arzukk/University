package com.example.FileTPO;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uname= request.getParameter("uname");
        String pass= request.getParameter("pass");

        Scanner scan = new Scanner(new File("/Users/arzukilic/IdeaProjects/FileTPO/src/main/java/com/example/FileTPO/Files/passwords.txt"));
        if (scan.hasNextLine()) {
            // First line skip
            scan.nextLine();
        }
        while (scan.hasNextLine())
        {
            String s = scan.nextLine();
            String[] sArray = s.split(",");

            System.out.println(sArray[0]); //check if file is being read
            System.out.println(sArray[1]);


            if (uname.equals(sArray[0]) && pass.equals(sArray[1]))
            {
                HttpSession session = request.getSession();
                session.setAttribute("username", uname);
                response.sendRedirect("formDisplay.jsp");
            }
            else
            {

//                response.sendRedirect("login.jsp");
            }
        }

        scan.close();

    }
}
