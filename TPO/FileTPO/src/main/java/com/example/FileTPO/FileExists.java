package com.example.FileTPO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;

@WebServlet(name = "FileExists", value = "/FileExists")
public class FileExists extends HttpServlet {
    boolean bool = false;
    public Ffile ffile;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get the user's text from the request parameters
        String fileExists = request.getParameter("fileExists");

        java.io.File file = new File("/Users/arzukilic/IdeaProjects/FileTPO/src/main/java/com/example/FileTPO/Files/" + fileExists + ".txt");

        bool = file.exists();
        if(bool) {
            response.sendRedirect("fileExists.jsp");
        }
        else {
            Ffile ffile = new Ffile();
            file.createNewFile();
            BasicFileAttributes attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            ffile.setDate(new Date(attr.creationTime().toMillis()));
            ffile.setName(fileExists);
            HttpSession session = request.getSession();
            ffile.setCreator(session.getAttribute("username"));
            session.setAttribute("createFileName", fileExists);
            System.out.printf("File %s created successfully by %s " , ffile.getName(), ffile.getCreator() + " " + ffile.getDate());
            response.sendRedirect("formDisplay.jsp");
        }


    }
}
