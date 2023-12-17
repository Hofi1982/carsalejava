package com.hoffmann.web;

import com.hoffmann.entity.AutoEntity;
import com.hoffmann.service.AutoService;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class AutoListServlet extends HttpServlet {
    private AutoService autoService;

    @Override
    public void init() {
        this.autoService = new AutoService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<form action='/autolist' method='get'>");
        response.getWriter().println("M�rka: <input type='text' name='marka'><br>");
        response.getWriter().println("Modell: <input type='text' name='modell'><br>");
        response.getWriter().println("�vj�rat: <input type='number' name='evjarat'><br>");
        response.getWriter().println("Kilom�ter�ra: <input type='number' name='kilometerora'><br>");
        response.getWriter().println("�r: <input type='number' name='ar'><br>");
        response.getWriter().println("St�tusz: <input type='text' name='statusz'><br>");
        response.getWriter().println("<input type='submit' value='Keres�s'></form>");

        // Keres�si param�terek fogad�sa
        String marka = request.getParameter("marka");
        String modell = request.getParameter("modell");
        Integer evjarat = tryParseInt(request.getParameter("evjarat"));
        Integer kilometerora = tryParseInt(request.getParameter("kilometerora"));
        Double ar = tryParseDouble(request.getParameter("ar"));
        String statusz = request.getParameter("statusz");

        // Az aut�k lek�rdez�se
        try {
            List<AutoEntity> autos = autoService.findAutos(marka, modell, evjarat, kilometerora, ar, statusz);
            // T�bl�zat felt�lt�se az aut�k adataival
            response.getWriter().println("<table border='1'>...");
            for (AutoEntity auto : autos) {
                response.getWriter().println("<tr><td>" + auto.getMarka() +
                    "</td><td>" + auto.getModell() +
                    "</td><td>" + auto.getEvjarat() +
                    "</td><td>" + auto.getKilometerora() +
                    "</td><td>" + auto.getAr() +
                    "</td><td>" + auto.getStatusz() +
                    "</td></tr>");
            }
            response.getWriter().println("</table>");
        } catch (Exception e) {
            response.getWriter().println("Hiba t�rt�nt az aut�k lek�rdez�se sor�n: " + e.getMessage());
        }
        
        response.getWriter().println("</body></html>");
    }

    private Integer tryParseInt(String value) {
        try {
            return value != null ? Integer.parseInt(value) : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private Double tryParseDouble(String value) {
        try {
            return value != null ? Double.parseDouble(value) : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
