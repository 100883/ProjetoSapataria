/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Marrone.ctrl;

import br.com.Marrone.dao.ProdutoDao;
import br.com.Marrone.model.Cliente;
import br.com.Marrone.model.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gui Freitas
 */
public class ProdutoCTRL extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String INSERT_OR_EDIT = "/produto.jsp";
    private static final String LISTA_PRODUTO = "/listaProduto.jsp";
    private final ProdutoDao dao;

    public ProdutoCTRL() {
        super();
        dao = new ProdutoDao();
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
//            out.println("<title>Servlet ProdutoCTRL</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ProdutoCTRL at " + request.getContextPath() + "</h1>");
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
            forward = LISTA_PRODUTO;
            request.setAttribute("produtos", dao.Listar(action));
        } else if (action.equalsIgnoreCase("alterar")) {
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            Produto prod = dao.ListarPorId(id);
            request.setAttribute("prod", prod);
        } else if (action.equalsIgnoreCase("listaProduto")) {
            forward = LISTA_PRODUTO;
            request.setAttribute("produtos", dao.Listar(action));
        } else {
            forward = INSERT_OR_EDIT;
        }

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
        Produto prod = new Produto();
        prod.setDescProd(request.getParameter("desc"));
        prod.setTipoProd(request.getParameter("tipo"));
        prod.setTamanho(Integer.parseInt(request.getParameter("tamanho")));
        prod.setMarca(request.getParameter("marca"));
        prod.setFabricante(request.getParameter("fabricante"));
        prod.setVidaUtil(request.getParameter("vidaUtil"));
        

//        Date hoje = new Date(System.currentTimeMillis());
//        cli.setDataCad(hoje);
        String clienteId = request.getParameter("id");
        if (clienteId == null || clienteId.isEmpty()) {
            dao.Adicionar(prod);
        } else {
            prod.setId(Integer.parseInt(clienteId));
            dao.Alterar(prod);
        }
        RequestDispatcher view = request.getRequestDispatcher(LISTA_PRODUTO);
        request.setAttribute("produtos", dao.Listar(LISTA_PRODUTO));
        view.forward(request, response);
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
}
