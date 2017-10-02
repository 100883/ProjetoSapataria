/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Marrone.ctrl;

import br.com.Marrone.dao.ClienteDao;
import br.com.Marrone.model.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gui Freitas
 */
public class ClienteCTRL extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String INSERT_OR_EDIT = "/cliente.jsp";
    private static final String LISTA_CLIENTE = "/listaCliente.jsp";
    private final ClienteDao dao;

    public ClienteCTRL() {
        super();
        dao = new ClienteDao();
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
//            out.println("<title>Servlet ClienteCTRL</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ClienteCTRL at " + request.getContextPath() + "</h1>");
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

        if (action.equalsIgnoreCase("deletar")) {
            int Id = Integer.parseInt(request.getParameter("id"));
            dao.Excluir(Id);
            forward = LISTA_CLIENTE;
            request.setAttribute("clientes", dao.Listar(action));
        } else if (action.equalsIgnoreCase("alterar")) {
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            Cliente cli = dao.ListarPorId(id);
            request.setAttribute("cli", cli);
        } else if (action.equalsIgnoreCase("listaCliente")) {
            forward = LISTA_CLIENTE;
            request.setAttribute("clientes", dao.Listar(action));
        } else {
            forward = INSERT_OR_EDIT;
        }
        request.setAttribute("valorSexo", "M");
        request.setAttribute("valorStatus", "true");
        RequestDispatcher view = request.getRequestDispatcher(forward);
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
        Cliente cli = new Cliente();
        cli.setNome(request.getParameter("nome"));
        cli.setCpf(request.getParameter("cpf"));
        cli.setEndereco(request.getParameter("endereco"));
        cli.setEmail(request.getParameter("email"));
        cli.setCelular(request.getParameter("celular"));
        cli.setSexo(request.getParameter("sexo"));
        cli.setStatus(Boolean.valueOf(request.getParameter("status")));

//        Date hoje = new Date(System.currentTimeMillis());
//        cli.setDataCad(hoje);
        String clienteId = request.getParameter("id");
        if (clienteId == null || clienteId.isEmpty()) {
            dao.Adicionar(cli);
        } else {
            cli.setId(Integer.parseInt(clienteId));
            dao.Alterar(cli);
        }
        RequestDispatcher view = request.getRequestDispatcher(LISTA_CLIENTE);
        request.setAttribute("valorSexo", "M");
        request.setAttribute("valorStatus", "true");
        request.setAttribute("clientes", dao.Listar(LISTA_CLIENTE));
        view.forward(request, response);
    }

}

/**
 * Returns a short description of the servlet.
 *
 * @return a String containing servlet description
 */
//@Override
//        public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//

