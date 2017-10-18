<%-- 
    Document   : produto
    Created on : 24/09/2017, 19:17:28
    Author     : Guilherme Freitas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Cadastro de Produto</title>
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
                    <img src="image/produto.png" alt="Produto" title="Produto">
                </div>

                <div class="col-sm-8 text-left"> 
                    <form method="post" action="ProdutoCTRL" name="frmAdicionaProduto" id="prdform">
                        <input type="submit" value="Salvar" class="btn">
                        <input type="reset" value="Limpar" class="btn">
                        <br><br>

                        Id<br>
                        <input type="text" readonly="readonly" name="id" class="id"
                               value="<c:out value="${prod.id}"/>"/><br><br>                    
                        Descrição<br>                        
                        <textarea rows="4" cols="50" name="desc" form="prdform" maxlength="500" required autofocus/><c:out value="${prod.desc}"/></textarea><br><br>
                        Tipo de Produto<br><br>
                        <input type="radio" name="tipo" required
                               value="sapato"/> Sapato
                        <input type="radio" name="tipo" required
                               value="tenis"/> Tênis
                        <input type="radio" name="tipo" required
                               value="coturno"/> Coturno
                        <input type="radio" name="tipo" required
                               value="sandalia"/> Sandália<br><br>
                        Tamanho<br>
                        <input type="text" name="tamanho" class="campo" maxlength="2" required
                               value = "<c:out value="${prod.tamanho}"/>"/><br>
                        Marca<br>
                        <input type="text" name="marca" class="campo" maxlength="20" required
                               value = "<c:out value="${prod.marca}"/>"/><br>
                        Fabricante<br>
                        <input type="text" name="fabricante" class="campo" maxlength="20" required
                               value = "<c:out value="${prod.fabricante}"/>"/><br>
                        Vida Útil<br>
                        <input type="text" name="vidaUtil" class="campo" maxlength="10" required
                               value = "<c:out value="${prod.vidaUtil}"/>"/><br>
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
