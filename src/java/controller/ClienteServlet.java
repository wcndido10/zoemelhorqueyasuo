package controller;

import dao.ClienteDao;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;

@WebServlet(name = "ClienteServlet", urlPatterns = {"/cliente"})
public class ClienteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            Cliente cliente = new Cliente();
            cliente.setNome(request.getParameter("nome"));
            cliente.setEmail(request.getParameter("email"));
            cliente.setPws(request.getParameter("pws"));

            //Converter String para Calendar
            if(!request.getParameter("dataNasc").equals("")){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Calendar dt = Calendar.getInstance();
                dt.setTime(sdf.parse(request.getParameter("dataNasc")));
                cliente.setDataNasc(dt);
            }
            
            String erros = cliente.validar(request.getParameter("confpws"));
            
            if (erros.equals("")){
                //System.out.println("Cadastrado");
                request.setAttribute("avisos", "Cadastrado");
                ClienteDao clienteDao = new ClienteDao();
                clienteDao.cadastrar(cliente);
            } else {
                //System.out.println("Erros: " + erros);
                request.setAttribute("erros", erros.replace("\n", "<br>"));
            }
            
        } catch (Exception e) {
            System.err.println("Erros: " + e.toString());
            request.setAttribute("alertas", "Problemas internos. Contate o suporte");
        }
        request.getRequestDispatcher("index.jsp").forward(request, response); 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
