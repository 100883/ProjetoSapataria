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
        <link rel="icon" type="image/jpg" href="image/icon.jpg">
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
                        <li><a href="fornecedor.jsp">Fronecedor</a></li>
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
                        Tipo de Produto Fornecido<br>
                        <input type="radio" name="tipoprod" required
                               value="sapato"/> Sapato
                        <input type="radio" name="tipoprod" required
                               value="tenis"/> Tênis
                        <input type="radio" name="tipoprod" required
                               value="coturno"/> Coturno
                        <input type="radio" name="tipoprod" required
                               value="sandalia"/> Sandália<br><br>

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
