package com.colenio.jakartaeehelloworld2.boundary;

import java.io.*;

import com.colenio.jakartaeehelloworld2.control.MessageBean;
import com.colenio.jakartaeehelloworld2.entity.Message;
import jakarta.inject.Inject;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    @Inject
    MessageBean messageBean;

    @Inject
    Message message;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Some Title...</h1>");
        out.println("<h1>" + messageBean.getMessage() + "</h1>");
        out.println("<h1>" + message.getMessage() + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}