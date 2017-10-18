<%-- 
    Document   : index
    Created on : 24/09/2017, 18:12:06
    Author     : Guilherme Freitas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        
    </head>
    <body>

         <%@include file="menu.jsp" %>

        <div class="container-fluid text-center">    
            <div class="row content">
                <div class="col-sm-2 sidenav">
                   <li><a href="ClienteCTRL?action=listaCliente">Clientes</a></li>
                   <li><a href="FornecedorCTRL?action=listaFornecedor">Fornecedores</a></li>
                   <li><a href="ProdutoCTRL?action=listaProduto">Produtos</a></li>
                </div>
                
                <div class="col-sm-8 text-left"> 

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