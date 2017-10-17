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

        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>                        
                    </button>
                    <a class="navbar-brand" href="#">Marrone's</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="index.jsp">Home</a></li>
                        <li><a href="cliente.jsp">Cliente</a></li>
                        <li><a href="fornecedor.jsp">Fornecedor</a></li>
                        <li><a href="produto.jsp">Produto</a></li>
                        <li><a href="PedidoCTRL?action=listaCliente">Pedido</a></li>
                        <li><a href="PedidoItemCTRL?action=consultar">Pedido/ Produto</a></li>
                        <li><a href="relatorios.jsp">Relatórios</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container-fluid text-center">    
            <div class="row content">
                <div class="col-sm-2 sidenav">

                </div>

                <div class="col-sm-8 text-left"> 
                    <form method="POST" action='PedidoItemCTRL' name="frmDadosPI">
                        <table>
                            <tbody>
                                <tr>
                            <input type="hidden" name="objeto" value="<%= request.getAttribute("pi")%>">
                            <td>Numero:</td>
                            <td> <input type="text" class="campo" name="numero" value="<c:out value="${pi.pedido.numero}" />" /> </td> 
                            <td>Data:</td>
                            <td> <input type="text" class="campo" name="data" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${pi.pedido.data}" />" /> </td> 
                            </tr>
                            <tr>
                                <td>Cliente:</td>
                                <td colspan="2"> 
                                    <select name ="codcliente" class="campo">
                                        <c:forEach items="${clientes}" var="cliente">
                                            <option value="<c:out value="${cliente.id}"/>" 
                                                    ${cliente.id ==  pi.pedido.cliente.id ? 'selected' : ''}>
                                                <c:out value="${cliente.nome}"/>
                                            </option >
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>Produto:</td>
                                <td colspan = "2"> 
                                    <select name ="coditem" class="campo">
                                        <c:forEach items="${itens}" var="item">
                                            <option value="<c:out value="${item.id}"/>" 
                                                    ${item.id ==  pi.item.id ? 'selected' : ''}>
                                                <c:out value="${item.desc}"/>
                                            </option >
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>Quantidade:</td>
                                <td> <input type="text" name="quantidade" class="campo" value="<c:out value="${pi.quantidade}" />" /> </td> 
                                <td>Valor Unitário:</td>
                                <td> <input type="text" name="valor" class="campo" value="<c:out value="${pi.valorunitario}" />" /> </td> 
                            </tr>
                            </tbody>
                        </table>
                        <br>
                        <input type="submit" value="Novo" name="botao" class="btn"/>
                        <input type="submit" value="Salvar" name="botao" class="btn"/>
                        <input type="submit" value="Pesquisar" name="botao" class="btn"/>
                        <br>
                        <br>
                    </form>
                    <form method="GET" action='PedidoItemCTRL' name="frmTabelaPI">
                        <table border=1>
                            <thead>
                                <tr>
                                    <th>Nr. Pedido</th>
                                    <th>Código Produto</th>
                                    <th>Descrição do Produto</th>
                                    <th>Quantidade</th>
                                    <th>Valor Unitário</th>
                                    <th>Ação</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${pis}" var="pi">
                                    <tr>
                                        <td><c:out value="${pi.pedido.numero}" /></td>
                                        <td><c:out value="${pi.item.id}" /></td>
                                        <td><c:out value="${pi.item.desc}" /> </td>
                                        <td><c:out value="${pi.quantidade}" /> </td>
                                        <td><c:out value="${pi.valorunitario}" /></td>
                                        <td><a href="PedidoItemCTRL?action=remover&codpedido=<c:out value="${pi.pedido.numero}"/>&coditem=<c:out value="${pi.item.id}"/>">Remover</a></td>
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
