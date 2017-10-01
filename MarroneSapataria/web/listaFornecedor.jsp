<%-- 
    Document   : index
    Created on : 24/09/2017, 18:12:06
    Author     : Guilherme Freitas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><html lang="en">
    <head>
        <title>Consulta de Fornecedores</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/png" href="image/fornecedor.png">
        <link rel="stylesheet" href="css/estilo.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

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
                <li><a href="ClienteCTRL?action=listaCliente">Clientes</a></li>
                <li><a href="#">Fornecedores</a></li>
                <li><a href="ProdutoCTRL?action=listaProduto">Produtos</a></li>
            </div>

            <div class="col-sm-8 text-left"> 
                <h1>Consulta de Fornecedores</h1>
                <hr><br><br>
                <table border=1>
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Razão Social</th>
                            <th>CNPJ</th>
                            <th>Endereço</th>
                            <th>Telefone</th>
                            <th>Celular</th>
                            <th>Email</th>
                            <th>Contato</th>
                            <th>Tipo de Produto</th>
                            
                            <th colspan=2>Opção</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${fornecedores}" var="forn">
                            <tr>
                                <td><c:out value="${forn.id}" /></td>
                                <td><c:out value="${forn.razaoSocial}" /></td>
                                <td><c:out value="${forn.cnpj}" /></td>
                                <td><c:out value="${forn.endereco}" /></td>
                                <td><c:out value="${forn.telefone}" /></td>
                                <td><c:out value="${forn.celular}" /></td>
                                <td><c:out value="${forn.email}" /></td>
                                <td><c:out value="${forn.contato}" /></td>
                                <td><c:out value="${forn.tipoProd}" /></td>

                                <td><a href="FornecedorCTRL?action=alterar&id=<c:out value="${forn.id}"/>">Alterar</a></td>
                                <td><a href="FornecedorCTRL?action=deletar&id=<c:out value="${forn.id}"/>">Deletar</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <p><a href="FornecedorCTRL?action=adicionar">Adicionar</a></p>
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