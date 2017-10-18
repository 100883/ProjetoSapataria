<%-- 
    Document   : Pedido
    Created on : 17/10/2017, 19:43:28
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Relatórios</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/png" href="image/relatorio.png">
        <link rel="stylesheet" href="css/estilo.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script>
            $(function () {
                $('input[name=data]').datepicker();
            });
        </script>
    </head>
    <body>

         <%@include file="menu.jsp" %>

        <div class="container-fluid text-center">    
            <div class="row content">
                <div class="col-sm-2 sidenav">

                </div>

                <div class="col-sm-8 text-left"> 
                    <form method="POST" action='PedidoCTRL' name="frmDadosPedido">
                        <table>
                            <tbody>
                                <tr>
                                    <td>Numero:</td>
                                    <td> <input type="text" readonly="readonly" class="campo" name="numero" value="<c:out value="${pedido.numero}" />" /> </td> 
                                </tr>
                                <tr>
                                    <td>Data:</td>
                                    <td> <input type="text" class="campo" name="data" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${pedido.data}" />" /> </td> 
                                </tr>
                                <tr>
                                    <td>Cliente:</td>
                                    <td> 
                                        <select name ="codcliente" class="campo">
                                            <c:forEach items="${clientes}" var="cliente">
                                                <option value="<c:out value="${cliente.id}"/>" 
                                                        ${cliente.id ==  pedido.cliente.id ? 'selected' : ''}>
                                                    <c:out value="${cliente.nome}"/>
                                                </option >
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <br>
                        <input type="submit" value="Gravar" class="btn"/>
                        <br>
                        <br>
                    </form>
                    <form method="GET" action='PedidoCTRL' name="frmTabelaPedido">
                        <table border=1>
                            <thead>
                                <tr>
                                    <th>Número do Pedido</th>
                                    <th>Data do Pedido</th>
                                    <th>Cliente</th>
                                    <th colspan=2>Ação</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${pedidos}" var="pedido">
                                    <tr>
                                        <td><c:out value="${pedido.numero}" /></td>
                                        <td><c:out value="${pedido.data}" /> </td>
                                        <td><c:out value="${pedido.cliente.nome}" /> </td>
                                        <td><a href="PedidoCTRL?action=alterar&numero=<c:out value="${pedido.numero}"/>">Alterar</a></td>
                                        <td><a href="PedidoCTRL?action=remover&numero=<c:out value="${pedido.numero}"/>">Remover</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </form>
                </div>

                <div class="col-sm-2 sidenav">

                </div>
            </div>
        </div>

        <footer class="container-fluid text-center">
            <p></p>
        </footer>

    </body>
</html>
