<%-- 
    Document   : exibir
    Created on : 29/10/2019, 15:33:35
    Author     : lcluc
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="resources/css/bootstrap.css" />" rel="stylesheet" type="text/css"/>
        <script src="<c:url value="resources/js/jquery.js" />"></script>
        <script>
            $(document).ready(function()
            {
                $.ajax({
                    url: "retorno",
                    dataType: 'json',
                    success: function(data)
                    {
                        $.each(data, function(idx, obj)
                        {
                            $('#tabela > tbody').append('<tr><td>'+ obj.nome+'</td><td>'+obj.endereco+'</td><td>'+obj.telefone+'</td><td>'+obj.email+'</td></tr>'); //id da tabela
                        });
                    }
                });
            });
        </script>
        <title>Cadastros</title>
    </head>
    <body>
    
    
    <div class="container">
        
        <table class="table" id="tabela">
            <thead>
                <tr>
                  <th>Nome</th>
                  <th>Endereço</th>
                  <th>Telefone</th>
                  <th>Email</th>
                </tr>
            </thead>
            
            <tbody>
                
            </tbody>
        </table>
        
    </div>
        
    </body>    
</html>
