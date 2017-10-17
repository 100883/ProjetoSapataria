/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Marrone.ctrl;

import br.com.Marrone.dao.ClienteDao;
import br.com.Marrone.dao.PedidoDao;
import br.com.Marrone.model.Cliente;
import br.com.Marrone.model.Pedido;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ManaimTI
 */
public class PedidoCTRL extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String FORMULARIO = "/Pedido.jsp";
    private static final String LISTA_CLIENTE = "/listaCliente.jsp";
    private ClienteDao cliDao;
    private PedidoDao pedDao;

    public PedidoCTRL() {
        super();
        pedDao = new PedidoDao();
        cliDao = new ClienteDao();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet PedidoCTRL</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet PedidoCTRL at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
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
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("remover")) {
            int numero = Integer.parseInt(request.getParameter("numero"));
            pedDao.Remover(numero);
        }
        if (action.equalsIgnoreCase("alterar")) {
            int numero = Integer.parseInt(request.getParameter("numero"));
            Pedido pedido = pedDao.ConsultarPorId(numero);

            request.setAttribute("pedido", pedido);
            
        } else if (action.equalsIgnoreCase("listaCliente")) {
            forward = LISTA_CLIENTE;
            request.setAttribute("clientes", cliDao.Listar(action));
        }

        RequestDispatcher view = request.getRequestDispatcher(FORMULARIO);
        request.setAttribute("pedidos", pedDao.ConsultarTodos());
        request.setAttribute("clientes", cliDao.Listar(action));
        view.forward(request, response);
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
        Pedido pedido = new Pedido();
        pedido.setCliente(new Cliente());

        try {
            Date data = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("data"));
            pedido.setData(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        pedido.getCliente().setId(Integer.parseInt(request.getParameter("codcliente")));

        String numero = request.getParameter("numero");

        if (numero == null || numero.isEmpty()) {
            pedDao.Inserir(pedido);
        } else {
            pedido.setNumero(Integer.parseInt(numero));
            pedDao.Alterar(pedido);
        }
        RequestDispatcher view = request.getRequestDispatcher(FORMULARIO);
        request.setAttribute("pedidos", pedDao.ConsultarTodos());
        view.forward(request, response);
    }
}

/**
 * Returns a short description of the servlet.
 *
 * @return a String containing servlet description
 */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>

