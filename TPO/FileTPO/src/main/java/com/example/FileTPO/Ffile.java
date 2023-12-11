package com.example.FileTPO;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@WebServlet(name = "Ffile", value = "/Ffile")
public class Ffile extends HttpServlet {
    public String name;
    public Object creator;
    public Date date;

}
