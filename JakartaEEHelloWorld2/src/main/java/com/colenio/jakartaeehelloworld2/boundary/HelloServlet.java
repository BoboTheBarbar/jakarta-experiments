package com.colenio.jakartaeehelloworld2.boundary;

import com.colenio.jakartaeehelloworld2.control.MessageBean;
import com.colenio.jakartaeehelloworld2.entity.Message;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    final MessageBean messageBean;
    final Message message;

    @Inject
    public HelloServlet(Message message, MessageBean messageBean) {
        this.message = message;
        this.messageBean = messageBean;
    }

    @Override
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

    @Override
    public void destroy() {
    }
}
