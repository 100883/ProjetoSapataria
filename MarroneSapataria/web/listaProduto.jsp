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
        <title>Consulta de Produtos</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/png" href="image/produto.png">
        <link rel="stylesheet" href="css/estilo.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    </head>
    <body>    
        
     <%@include file="menu.jsp" %>

    <div class="container-fluid text-center">    
        <div class="row content">
            <div class="col-sm-2 sidenav">                
                <li><a href="ClienteCTRL?action=listaCliente">Clientes</a></li>
                <li><a href="FornecedorCTRL?action=listaFornecedor">Fornecedores</a></li>
                <li><a href="#">Produtos</a></li>
            </div>

            <div class="col-sm-8 text-left"> 
                <h1>Consulta de Produtos</h1>
                <hr><br><br>
                <table border=1>
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Descrição do Produto</th>
                            <th>Tipo</th>
                            <th>Tamanho</th>
                            <th>Marca</th>
                            <th>Fabricante</th>
                            <th>Vida Útil</th>

                            <th colspan=2>Opção</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${produtos}" var="prod">
                            <tr>
                                <td><c:out value="${prod.id}" /></td>
                                <td><c:out value="${prod.desc}" /></td>
                                <td><c:out value="${prod.tipo}" /></td>
                                <td><c:out value="${prod.tamanho}" /></td>
                                <td><c:out value="${prod.marca}" /></td>
                                <td><c:out value="${prod.fabricante}" /></td>
                                <td><c:out value="${prod.vidaUtil}" /></td>

                                <td><a href="ProdutoCTRL?action=alterar&id=<c:out value="${prod.id}"/>">Alterar</a></td>
                                <td><a href="ProdutoCTRL?action=deletar&id=<c:out value="${prod.id}"/>">Deletar</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <p><a href="ProdutoCTRL?action=adicionar">Adicionar</a></p>
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