package com.hoffmann.web;

import com.hoffmann.entity.AutoEntity;
import com.hoffmann.service.AutoService;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AutoServlet extends HttpServlet {
    private AutoService autoService;

    @Override
    public void init() {
        this.autoService = new AutoService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<form action='/autoservlet' method='post'>");
        response.getWriter().println("M�rka: <input type='text' name='marka'><br>");
        response.getWriter().println("Modell: <input type='text' name='modell'><br>");
        response.getWriter().println("�vj�rat: <input type='number' name='evjarat'><br>");
        response.getWriter().println("Kilom�ter�ra: <input type='number' name='kilometerora'><br>");
        response.getWriter().println("�r: <input type='number' name='ar'><br>");
        response.getWriter().println("St�tusz: <input type='text' name='statusz'><br>");
        response.getWriter().println("<input type='submit' value='Hozz�ad'></form>");
        response.getWriter().println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String marka = request.getParameter("marka");
            String modell = request.getParameter("modell");
            int evjarat = Integer.parseInt(request.getParameter("evjarat"));
            int kilometerora = Integer.parseInt(request.getParameter("kilometerora"));
            double ar = Double.parseDouble(request.getParameter("ar"));
            String statusz = request.getParameter("statusz");

            AutoEntity auto = new AutoEntity(0, marka, modell, evjarat, kilometerora, ar, statusz);
            autoService.addAuto(auto);

            // Itt h�vjuk meg a doGet met�dust, hogy �jra lefusson
            doGet(request, response);
        } catch (Exception e) {
            throw new ServletException("Adatb�zis hiba az aut� hozz�ad�sakor", e);
        }
    }
}
