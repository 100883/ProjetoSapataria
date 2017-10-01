<%-- 
    Document   : clienteWeb
    Created on : 24/09/2017, 19:02:11
    Author     : Guilherme Freitas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Cadastro de Cliente</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/png" href="image/cliente.png">
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

                </div>

                <div class="col-sm-8 text-left"> 
                    <form method="post" action="ClienteCTRL" name="frmAdicionaCliente">
                        <input type="submit" value="Salvar" class="btn">
                        <input type="reset" value="Limpar" class="btn">
                        <br><br>

                        Id<br>
                        <input type="text" readonly="readonly" name="id" class="id"
                               value="<c:out value="${cli.id}"/>"/><br><br>                    
                        Nome<br>
                        <input type="text" name="nome" class="campo" maxlength="100" required autofocus 
                               value = "<c:out value="${cli.nome}"/>"/><br>
                        CPF<br>
                        <input type="text" name="cpf" class="campo" maxlength="11" required
                               value = "<c:out value="${cli.cpf}"/>"/><br>
                        Endereço<br>
                        <input type="text" name="endereco" class="campo" maxlength="200" required
                               value = "<c:out value="${cli.endereco}"/>"/><br>
                        Email<br>
                        <input type="email" name="email" class="campo" maxlength="50" required
                               value = "<c:out value="${cli.email}"/>"/><br>
                        Celular<br>
                        <input type="text" name="celular" class="campo" maxlength="16" required
                               value = "<c:out value="${cli.celular}"/>"/><br>
                        Sexo<br><br>
                        <input type="radio" name="sexo" required
                               value= "M"/> Masculino
                        <input type="radio" name="sexo" required
                               value= "F"/> Feminino<br><br>
                        Status<br><br>
                        <input type="radio" name="status" required
                               value="TRUE"/> Ativo
                        <input type="radio" name="status" required
                               value="FALSE"/> Inativo<br><br>

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
