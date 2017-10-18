<%-- 
    Document   : index
    Created on : 24/09/2017, 18:12:06
    Author     : Guilherme Freitas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Marrone's Sapataria</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/jpg" href="image/icon1.jpg">
        <link rel="stylesheet" href="css/estilo.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    </head>
    <body>

         <%@include file="menu.jsp" %>

        <div class="container-fluid text-center">    
            <div class="row content">
                <div class="col-sm-2 sidenav">
                    <section class="logo">
                        <figure>
                            <img src="image/icon.jpg" alt="logo" title="Nossa logo">
                            <figcaption>
                                <h1>Marrone's Sapataria</h1>
                                <br>
                                Começando agora há atuar no mercado, disponibilizamos nossos serviços com eficiência e eficácia.
                            </figcaption>
                        </figure>
                    </section>
                </div>

                <div class="col-sm-8 text-left"> 
                    <section class="fundo">                         
                        <div class="banner">
                            <h2>Seja bem vindo!</h2>
                        </div>

                    </section>

                </div>

                <div class="col-sm-2 sidenav">
                    <h3>Sigam nossas redes sociais</h3>
                    
                    <a href="https://www.facebook.com/profile.php?id=100022302857010" style="font-size:25px;" class="fa fa-facebook"></a><p>
                    <a href="https://twitter.com/signup?lang=pt" style="font-size:25px;" class="fa fa-twitter"></a><p>
                    <a href="https://www.youtube.com/watch?v=87SaRrpB3B4" style="font-size:25px;" class="fa fa-youtube"></a><p>
                    <a href="https://www.instagram.com/?hl=pt-br" style="font-size:25px;" class="fa fa-instagram"></a><p>
                    <a href="https://br.pinterest.com/" style="font-size:25px;" class="fa fa-pinterest"></a>

                </div>
            </div>
        </div>

        <footer class="container-fluid text-center">
            <p></p>
        </footer>

    </body>
</html>