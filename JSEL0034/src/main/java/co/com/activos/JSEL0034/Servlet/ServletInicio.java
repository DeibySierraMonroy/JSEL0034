/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.activos.JSEL0034.Servlet;

import co.com.activos.JSEL0034.Interfaces.DelegatedTSelNucleoFamiliarDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author anvega
 */
public class ServletInicio extends HttpServlet {

    /**
     * Atributo que contiene el valor de parametro
     */
    private String parametro = "";

    /**
     * Atributo que contiene el valor de parametros
     */
    private HashMap parametros;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String paginaRedireccionar = "";
        try {
            parametro = request.getParameter("PARAMETRO");
            desEncriptyon(parametro);

            // Ponemos el Bean en la session para que cuando entre a la pagina home ya se encuentre autenticado
            HttpSession session = request.getSession();
            session.setAttribute("USS_ID_SESSION", parametros.get("USS_ID_SESSION"));
            session.setAttribute("TDC_TD_EPL", parametros.get("tipoidentificacion"));
            session.setAttribute("EPL_ND", parametros.get("identificacion"));
            session.setAttribute("BUTTON", parametros.get("botones"));
            session.setAttribute("DEA_CODIGO", parametros.get("DEA_CODIGO"));
            session.setAttribute("AZCODIGO_CLI", parametros.get("AZCODIGO_CLI"));

            paginaRedireccionar = "pre-entrevista-familiar.xhtml";
            response.sendRedirect("faces/" + paginaRedireccionar);

        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head><title>:. Error Iniciando Sesion .:</title></head>");
            out.println("<body>");
            out.println("<p>No se puedo cargar la session causado por " + e + "</p>");
            out.println("</body></html>");
            out.close();
        }
    }

    /**
     * Metodo encargado de desencriptar la informacion recibida por url
     *
     * @param parametro
     * @throws Exception
     */
    private void desEncriptyon(String parametro) throws Exception {
        String desEncriptar = parametro.substring(50);
        desEncriptar = DelegatedTSelNucleoFamiliarDAO.desEncriptarParametrosServlet(desEncriptar);
        desEncriptar = DelegatedTSelNucleoFamiliarDAO.desEncriptarParametrosServlet(desEncriptar);
        if (desEncriptar != null && !desEncriptar.trim().equals("")) {
            parametros = new HashMap<>();
            String[] keyValue = desEncriptar.split("&");
            String[] entrySesion = keyValue[0].split("=");
            parametros.put(entrySesion[0].trim(), entrySesion[1].trim());
            String[] entryDeaCodigo = keyValue[2].split("=");
            parametros.put(entryDeaCodigo[0].trim(), entryDeaCodigo[1].trim());
            String[] entryAzCodigoCli = keyValue[3].split("=");
            parametros.put(entryAzCodigoCli[0].trim(), entryAzCodigoCli[1].trim());
            String value = keyValue[1].substring(5, keyValue[1].length() - 1);
            String[] keyValuePairs = value.split(",");
            for (String pair : keyValuePairs) {
                String[] entry = pair.split("=");
                parametros.put(entry[0].trim(), entry[1].trim());
            }
        }
    }
}
