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
        response.getWriter().println("Márka: <input type='text' name='marka'><br>");
        response.getWriter().println("Modell: <input type='text' name='modell'><br>");
        response.getWriter().println("Évjárat: <input type='number' name='evjarat'><br>");
        response.getWriter().println("Kilométeróra: <input type='number' name='kilometerora'><br>");
        response.getWriter().println("Ár: <input type='number' name='ar'><br>");
        response.getWriter().println("Státusz: <input type='text' name='statusz'><br>");
        response.getWriter().println("<input type='submit' value='Hozzáad'></form>");
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

            // Itt hívjuk meg a doGet metódust, hogy újra lefusson
            doGet(request, response);
        } catch (Exception e) {
            throw new ServletException("Adatbázis hiba az autó hozzáadásakor", e);
        }
    }
}
