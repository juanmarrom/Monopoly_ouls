<%-- 
    Document   : opciones
    Created on : 27.05.2017, 11:51:37
    Author     : User
--%>

<%-- 
    Document   : monopoly
    Created on : 27.05.2017, 11:52:06
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Monopoly</title>
        <script src="js/jquery-3.2.1.min.js"></script>
        <script>
                function continuar(valor) {
                    $.ajax({
                        data: {"nombre":valor},
                        url: "Monopoly_Servlet",
                        type: "post",
                        dataType: "html",
                        success: function(response) {
                            location.href ="monopoly.jsp";  
                        }
                    }); 
                }
                
        </script>          
        
        <style type="text/css">   
            table, th, td {
                font-size: 20px;
                padding-left: 20px;
                padding-right: 20px;
                padding-top: 10px;
                padding-bottom:10px; 
                border: 1px solid black;
                border-collapse: collapse;
            }
        </style>
    </head>
    <body>
        <center>    
            <h2>Bienvenidos al Monopoly Versión Eduard-Victor-Juan</h2>
            <br>
            <img src="img/monopoly.png" />
            <br>
            <br>
            <table>
                <tr>
                    <td onmouseover="this.style.background='black'; this.style.cursor='pointer'; this.style.color='white';" onmouseout="this.style.background='white'; this.style.color='black';" onclick="continuar('nueva');">
                        Nueva Partida
                    </td>
                </tr>                
                <tr>
                    <td onmouseover="this.style.background='black'; this.style.cursor='pointer'; this.style.color='white';" onmouseout="this.style.background='white'; this.style.color='black';" onclick="continuar('cargar');">
                        Cargar Partida
                    </td>
                </tr>
                   
            </table>
        </center>
    </body>
</html>
