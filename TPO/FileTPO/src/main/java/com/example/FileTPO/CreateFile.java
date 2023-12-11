package com.example.FileTPO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@WebServlet(name = "CreateFile", value = "/CreateFile")
public class CreateFile extends HttpServlet {
    boolean bool = false;
    public Ffile ffile;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get the user's text from the request parameters
        String cfile = request.getParameter("cfile");

        File file = new File("/Users/arzukilic/IdeaProjects/FileTPO/src/main/java/com/example/FileTPO/Files/" + cfile + ".txt");

        bool = file.exists();
        if(bool) {
            response.sendRedirect("fileExists.jsp");
        }
        else {
            Ffile ffile = new Ffile();
            file.createNewFile();
            BasicFileAttributes attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            Date date = new Date(attr.creationTime().toMillis());
            HttpSession session = request.getSession();
            String creator = request.getParameter("creator");
            session.setAttribute("creator", creator);
            ffile.setDate(date);
            ffile.setName(cfile);
            ffile.setCreator(creator);
            session.setAttribute("ffile", ffile);
            System.out.printf("File %s created successfully by %s " , ffile.getName(), ffile.getCreator() + " " +  ffile.getDate());
            //creator operation


            StringBuilder sb = new StringBuilder();

            sb.append(creator);
            sb.append(System.lineSeparator());

            try (FileWriter writer = new FileWriter(file)) {
                    writer.write(sb.toString());
                } catch (IOException e) {
                    System.out.println("Error while writing to file: " + e.getMessage());
                }
            //
            response.sendRedirect("formDisplay.jsp");
        }
    }
}
