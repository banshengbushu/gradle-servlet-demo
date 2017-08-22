package com.mind.server;

import sun.reflect.generics.scope.Scope;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.sun.tools.doclets.formats.html.markup.HtmlStyle.title;

public class SubmitServlet extends HttpServlet {
    public String name;
    public Integer age;

    public SubmitServlet(String value) {
        this.name = name;
        this.age = age;
    }

    public void init() throws ServletException {
        name = "Dan";
        age = 20;
        System.out.println("init");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "This is your name and age";

        String docType = "<!DOCTYPE html> \n";

        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>" +
                "  <li><b>name</b>"
                + "\t" + request.getParameter("name") + "\n" +
                "  <li><b>age</b>"
                + "\t" + request.getParameter("age") + "\n" +
                "</ul>" +
                "</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post");
        doGet(request, response);
    }

    public void destroy() {
    }

}
