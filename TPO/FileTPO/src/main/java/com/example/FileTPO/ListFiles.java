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
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "ListFiles", value = "/ListFiles")
public class ListFiles extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        File directory = new File("/Users/arzukilic/IdeaProjects/FileTPO/src/main/java/com/example/FileTPO/Files");
        File[] files = directory.listFiles();
        ArrayList<Ffile> txtFiles = new ArrayList<>();
//try
//        request.setAttribute("files", files);
//try
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String filename = file.getName();
                    BasicFileAttributes attributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                    Date creationDate = new Date(attributes.creationTime().toMillis());
                    HttpSession session = request.getSession();
                    Object creator = session.getAttribute("username");

                    Ffile ffile = new Ffile(filename, creator, creationDate);
                    txtFiles.add(ffile);
//try
//                    request.setAttribute("creationDate", creationDate);
//                    request.setAttribute("creator", creator);
//try

                }
            }
        }
        request.setAttribute("txtFiles", txtFiles);

        try {
            request.getRequestDispatcher("listFiles.jsp").forward(request, response);}
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
