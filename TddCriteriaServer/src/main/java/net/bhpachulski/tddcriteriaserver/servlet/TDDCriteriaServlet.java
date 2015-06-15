package net.bhpachulski.tddcriteriaserver.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bhpachulski
 */

@WebServlet(
        name = "MyServlet",
        urlPatterns = {"/init"}
    )   
public class TDDCriteriaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        out.write("hello init".getBytes());
        out.flush();
        out.close();
    }

}