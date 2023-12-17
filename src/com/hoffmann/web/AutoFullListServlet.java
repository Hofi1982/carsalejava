package com.hoffmann.web;

import com.hoffmann.entity.AutoEntity;
import com.hoffmann.service.AutoService;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class AutoFullListServlet extends HttpServlet {
    private AutoService autoService;

    @Override
    public void init() {
        this.autoService = new AutoService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Elad� aut�k teljes list�ja</h1>");
        response.getWriter().println("<table border='1'><tr><th>M�rka</th><th>Modell</th><th>�vj�rat</th><th>Kilom�ter�ra</th><th>�r</th><th>St�tusz</th></tr>");

        try {
            List<AutoEntity> autos = autoService.getAllAutos();
            for (AutoEntity auto : autos) {
                response.getWriter().println(String.format(
                    "<tr><td>%s</td><td>%s</td><td>%d</td><td>%d</td><td>%.2f</td><td>%s</td></tr>",
                    auto.getMarka(), auto.getModell(), auto.getEvjarat(), auto.getKilometerora(), auto.getAr(), auto.getStatusz()
                ));
            }
        } catch (Exception e) {
            response.getWriter().println("<tr><td colspan='6'>Hiba az adatok lek�rdez�se sor�n</td></tr>");
        }

        response.getWriter().println("</table>");
        response.getWriter().println("</body></html>");
    }
}
