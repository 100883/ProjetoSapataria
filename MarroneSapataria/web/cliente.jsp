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

        <script language="javascript">
            function VerificaCPF() {
                if (vercpf(document.frmAdicionaCliente.cpf.value))
                {
                    document.frmAdicionaCliente.submit();
                } else
                {
                    errors = "1";
                    if (errors)
                        alert('CPF INVÁLIDO');
                    document.retorno = (errors === '');
                }
            }
            function vercpf(cpf)
            {
                if (cpf.length !== 11 || cpf === "00000000000" || cpf === "11111111111" || cpf === "22222222222" || cpf === "33333333333" || cpf === "44444444444" || cpf === "55555555555" || cpf === "66666666666" || cpf === "77777777777" || cpf === "88888888888" || cpf === "99999999999")
                    return false;
                add = 0;
                for (i = 0; i < 9; i ++)
                    add += parseInt(cpf.charAt(i)) * (10 - i);
                rev = 11 - (add % 11);
                if (rev === 10 || rev === 11)
                    rev = 0;
                if (rev !== parseInt(cpf.charAt(9)))
                    return false;
                add = 0;
                for (i = 0; i < 10; i ++)
                    add += parseInt(cpf.charAt(i)) * (11 - i);
                rev = 11 - (add % 11);
                if (rev === 10 || rev === 11)
                    rev = 0;
                if (rev !== parseInt(cpf.charAt(10)))
                    return false;

                return true;
            }
        </script>
    </head>
    <body>

         <%@include file="menu.jsp" %>

        <div class="container-fluid text-center">    
            <div class="row content">
                <div class="col-sm-2 sidenav">
                    <img src="image/cliente.png" alt="Cliente" title="Cliente">
                </div>

                <div class="col-sm-8 text-left"> 

                    <form method="post" action="ClienteCTRL" name="frmAdicionaCliente" onsubmit="VerificaCPF();">
                        <input type="submit" value="Salvar" class="btn" onclick="VerificaCPF();">
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
                               value= "M" ${cli.sexo == valorSexo ? 'checked':''}/> Masculino   
                        <input type="radio" name="sexo" required
                               value= "F" ${cli.sexo != valorSexo ? 'checked':''}/> Feminino<br><br>
                        Status<br><br>
                        <input type="radio" name="status" required
                               value="true" ${cli.status == valorStatus ? 'checked':''}/> Ativo
                        <input type="radio" name="status" required
                               value="false" ${cli.status != valorStatus ? 'checked':''}/> Inativo<br><br>

                        </div>

                        <div class="col-sm-2 sidenav">

                        </div>
                </div>
            </div>

    </body>

    <footer class="container-fluid text-center">
        <p></p>
    </footer>
</html>
