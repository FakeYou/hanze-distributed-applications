package nl.hanze.web.gba;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import nl.hanze.web.gba.domain.*;

@WebServlet("/natuurlijkpersoon")
public class GBA extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = readAction(request);
        String bsn = request.getParameter("bsn");

        if ("get".equals(action) && bsn != null) {
            NatuurlijkPersoonDAOImpl impl = new NatuurlijkPersoonDAOImpl();
            NatuurlijkPersoon np = impl.getNatuurlijkPersoonByBSN(Long.parseLong(bsn));

            // return json format
            request.setAttribute("np", np);
            RequestDispatcher view=request.getRequestDispatcher("get.jsp");
            view.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    private String readAction(HttpServletRequest request) {
        return request.getParameter("action");
    }
}
