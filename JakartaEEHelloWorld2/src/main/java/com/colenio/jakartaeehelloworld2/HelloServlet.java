package com.colenio.jakartaeehelloworld2;

import java.io.*;

import jakarta.ejb.EJB;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    @EJB
    MessageBean messageBean;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + messageBean.getMessage() + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}