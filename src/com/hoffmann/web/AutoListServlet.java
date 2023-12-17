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
        response.getWriter().println("Márka: <input type='text' name='marka'><br>");
        response.getWriter().println("Modell: <input type='text' name='modell'><br>");
        response.getWriter().println("Évjárat: <input type='number' name='evjarat'><br>");
        response.getWriter().println("Kilométeróra: <input type='number' name='kilometerora'><br>");
        response.getWriter().println("Ár: <input type='number' name='ar'><br>");
        response.getWriter().println("Státusz: <input type='text' name='statusz'><br>");
        response.getWriter().println("<input type='submit' value='Keresés'></form>");

        // Keresési paraméterek fogadása
        String marka = request.getParameter("marka");
        String modell = request.getParameter("modell");
        Integer evjarat = tryParseInt(request.getParameter("evjarat"));
        Integer kilometerora = tryParseInt(request.getParameter("kilometerora"));
        Double ar = tryParseDouble(request.getParameter("ar"));
        String statusz = request.getParameter("statusz");

        // Az autók lekérdezése
        try {
            List<AutoEntity> autos = autoService.findAutos(marka, modell, evjarat, kilometerora, ar, statusz);
            // Táblázat feltöltése az autók adataival
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
            response.getWriter().println("Hiba történt az autók lekérdezése során: " + e.getMessage());
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
