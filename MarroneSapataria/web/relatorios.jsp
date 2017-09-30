<%-- 
    Document   : index
    Created on : 24/09/2017, 18:12:06
    Author     : Guilherme Freitas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Bootstrap Example</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
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
                        <li class="active"><a href="#">Home</a></li>
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
                   <li><a href="listaCliente.jsp">Clientes</a></li>
                   <li><a href="#">Fornecedores</a></li>
                   <li><a href="#">Produtos</a></li>
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