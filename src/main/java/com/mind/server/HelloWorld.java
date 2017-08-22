package com.mind.server;

import sun.plugin2.message.Message;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorld extends HttpServlet {
    public String message;
    public String clickMessage;

    public HelloWorld(String message) {
        this.message = message;
    }

    public void init() throws ServletException {
        message = "Hello world";
        clickMessage = "Click Me";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter printOut = response.getWriter();
        printOut.write("<input placeHolder = please input>" + message + "</input>" + "</br></br>");
        printOut.write("<button>" + clickMessage + "</button>");
    }

    public void destroy() {

    }
}
