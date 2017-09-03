package com.mind.server;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import sun.plugin2.message.Message;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorld extends HttpServlet {
    @SerializedName("message")
    public String message;

    @SerializedName("click")
    public String clickMessage;

    public HelloWorld(){
        this.message = message;
        this.clickMessage = clickMessage;
    }


    public HelloWorld(String message,String clickMessage) {
        this.message = message;
        this.clickMessage = clickMessage;
    }

    public void init() throws ServletException {
        message = "Hello world";
        clickMessage = "Click Me";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Gson gson = new Gson();
        HelloWorld helloWorld = new HelloWorld("hello me","click me");
        String helloWorldStr = gson.toJson(helloWorld);

        HelloWorld newHelloWorld = gson.fromJson(helloWorldStr, HelloWorld.class);

        System.out.println(helloWorldStr);
        System.out.println(newHelloWorld);
        System.out.println(helloWorld);



        PrintWriter printOut = response.getWriter();
        printOut.write("<input placeHolder = please input>" + message + "</input>" + "</br></br>");
        printOut.write("<button>" + clickMessage + "</button>");
    }

    public void destroy() {

    }
}
