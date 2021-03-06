<%-- 
    Document   : fornecedor
    Created on : 24/09/2017, 19:17:08
    Author     : Guilherme Freitas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Cadastro de Fornecedor</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/png" href="image/fornecedor.png">
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
                    <img src="image/fornecedor.png" alt="Fornecedor" title="Fornecedor">
                </div>

                <div class="col-sm-8 text-left"> 
                    <form method="post" action="FornecedorCTRL" name="frmAdicionaFornecedor">
                        <input type="submit" value="Salvar" class="btn">
                        <input type="reset" value="Limpar" class="btn">
                        <br><br>

                        Id<br>
                        <input type="text" readonly="readonly" name="id" class="id"
                               value="<c:out value="${forn.id}"/>"/><br><br>                    
                        Razão Social<br>
                        <input type="text" name="razao" class="campo" maxlength="100" required autofocus 
                               value = "<c:out value="${forn.razaoSocial}"/>"/><br>
                        CNPJ<br>
                        <input type="text" name="cnpj" class="campo" maxlength="11" required
                               value = "<c:out value="${forn.cnpj}"/>"/><br>
                        Endereço<br>
                        <input type="text" name="endereco" class="campo" maxlength="200" required
                               value = "<c:out value="${forn.endereco}"/>"/><br>
                        Telefone<br>
                        <input type="text" name="telefone" class="campo" maxlength="50" required
                               value = "<c:out value="${forn.telefone}"/>"/><br>
                        Celular<br>
                        <input type="text" name="celular" class="campo" maxlength="16" required
                               value = "<c:out value="${forn.celular}"/>"/><br>
                        Email<br>
                        <input type="email" name="email" class="campo" maxlength="50" required
                               value = "<c:out value="${forn.email}"/>"/><br>
                        Contato<br>
                        <input type="text" name="contato" class="campo" maxlength="50" required
                               value = "<c:out value="${forn.contato}"/>"/><br>
                        Tipo de Produto Fornecido<br><br>
                        <select>
                            <option value=""></option>
                            <option value="<c:out value="${forn.tipoProd}"/>">Sapato</option>
                            <option value="<c:out value="${forn.tipoProd}"/>">Tênis</option>
                            <option value="<c:out value="${forn.tipoProd}"/>">Coturno</option>
                            <option value="<c:out value="${forn.tipoProd}"/>">Sandália</option>
                            <br><br>
                        </select>
                        
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
