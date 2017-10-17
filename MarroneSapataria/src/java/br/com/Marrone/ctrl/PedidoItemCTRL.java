/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Marrone.ctrl;

import br.com.Marrone.dao.ClienteDao;
import br.com.Marrone.dao.PedidoDao;
import br.com.Marrone.dao.PedidoItemDao;
import br.com.Marrone.dao.ProdutoDao;
import br.com.Marrone.model.Cliente;
import br.com.Marrone.model.Pedido;
import br.com.Marrone.model.PedidoItem;
import br.com.Marrone.model.Produto;
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
 * @author Gui Freitas
 */
public class PedidoItemCTRL extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String FORMULARIO = "/PedidoItem.jsp";
    private PedidoItemDao dal;
    private ClienteDao dalc;
    private PedidoDao dalp;
    private ProdutoDao dali;

    public PedidoItemCTRL() {
        super();
        dal = new PedidoItemDao();
        dalp = new PedidoDao();
        dalc = new ClienteDao();
        dali = new ProdutoDao();
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
//            out.println("<title>Servlet PedidoItemCTRL</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet PedidoItemCTRL at " + request.getContextPath() + "</h1>");
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
        String action = request.getParameter("action");
        String numero = request.getParameter("codpedido");

        if (action.equalsIgnoreCase("remover")) {
            int nrpedido = Integer.parseInt(numero);
            int coditem = Integer.parseInt(request.getParameter("coditem"));
            dal.Remover(nrpedido, coditem);
            Pedido p = dalp.ConsultarPorId(nrpedido);
            PedidoItem pi = new PedidoItem();
            pi.setPedido(p);
            request.setAttribute("pi", pi);
        }
        if (!(numero == null || numero.isEmpty())) {
            request.setAttribute("pis", dal.ConsultarTodosPorPedido(Integer.parseInt(numero)));
        }
        RequestDispatcher view = request.getRequestDispatcher(FORMULARIO);
        request.setAttribute("clientes", dalc.Listar(action));
        request.setAttribute("itens", dali.Listar(numero));
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
        Object attribute = request.getAttribute("objeto");
        if (request.getParameter("botao").equalsIgnoreCase("Novo")) {
            RequestDispatcher view = request.getRequestDispatcher(FORMULARIO);
            request.setAttribute("clientes", dalc.Listar(""));
            request.setAttribute("itens", dali.Listar(""));
            view.forward(request, response);
        }
        if (request.getParameter("botao").equalsIgnoreCase("Salvar")) {
            Pedido pedido = new Pedido();
            Pedido p = new Pedido();
            pedido.setCliente(new Cliente());

            try {
                Date data = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("data"));
                pedido.setData(data);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            pedido.getCliente().setId(Integer.parseInt(request.getParameter("codcliente")));

            String numero = request.getParameter("numero");

            if (numero == null || numero.isEmpty()) {
                p = dalp.Inserir(pedido);
            } else {
                p = dalp.ConsultarPorId(Integer.parseInt(numero));
            }

            PedidoItem pi = new PedidoItem();
            pi.setPedido(p);
            pi.setItem(new Produto());

            pi.getPedido().setNumero(p.getNumero());
            pi.getItem().setId(Integer.parseInt(request.getParameter("coditem")));
            pi.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
            pi.setValorunitario(Double.parseDouble(request.getParameter("valor")));

            dal.Inserir(pi);

            pi.setQuantidade(0);
            pi.setValorunitario(0);

            RequestDispatcher view = request.getRequestDispatcher(FORMULARIO);
            request.setAttribute("pi", pi);
            request.setAttribute("pis", dal.ConsultarTodosPorPedido(pi.getPedido().getNumero()));
            request.setAttribute("clientes", dalc.Listar(""));
            request.setAttribute("itens", dali.Listar(""));
            view.forward(request, response);
        }
        if (request.getParameter("botao").equalsIgnoreCase("Pesquisar")) {
            String numero = request.getParameter("numero");

            if (!(numero == null || numero.isEmpty())) {
                RequestDispatcher view = request.getRequestDispatcher(FORMULARIO);
                request.setAttribute("pis", dal.ConsultarTodosPorPedido(Integer.parseInt(numero)));
                request.setAttribute("clientes", dalc.Listar(""));
                request.setAttribute("itens", dali.Listar(""));
                view.forward(request, response);
            }
        }
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

