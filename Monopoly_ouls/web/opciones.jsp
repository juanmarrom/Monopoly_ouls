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
                    /*$.ajax({
                        data: {"nombre":valor},
                        url: "Monopoly_Servlet",
                        type: "post",
                        dataType: "html",
                        success: function(response) {
                            location.href ="monopoly.jsp";  
                        }
                    });*/
                    if (valor == "nueva") {
                        document.getElementById("id_menu").style.display = "none";
                        document.getElementById("id_numero_jugadores").style.display = "inline";
                        document.getElementById("id_seleccion").style.display = "inline";                        
                    }
                }

                function numero_jugadores(valor) {
                   var valor2 = "nueva";
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
            th, td {
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
            <table id="id_menu">
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
            
            <span id="id_seleccion" style="display:none;"><h3>Seleccione número de Jugadores</h3></span>
            <table id="id_numero_jugadores" style="display:none">
                <tr>
                    <td onmouseover="this.style.background='black'; this.style.cursor='pointer'; this.style.color='white';" onmouseout="this.style.background='white'; this.style.color='black';" onclick="numero_jugadores(2);">
                        2
                    </td>
                </tr>                
                <tr>
                    <td onmouseover="this.style.background='black'; this.style.cursor='pointer'; this.style.color='white';" onmouseout="this.style.background='white'; this.style.color='black';" onclick="numero_jugadores(3);">
                        3
                    </td>
                </tr>
                <tr>
                    <td onmouseover="this.style.background='black'; this.style.cursor='pointer'; this.style.color='white';" onmouseout="this.style.background='white'; this.style.color='black';" onclick="numero_jugadores(4);">
                        4
                    </td>
                </tr>
                <tr>
                    <td onmouseover="this.style.background='black'; this.style.cursor='pointer'; this.style.color='white';" onmouseout="this.style.background='white'; this.style.color='black';" onclick="numero_jugadores(5);">
                        5
                    </td>
                </tr>
                <tr>
                    <td onmouseover="this.style.background='black'; this.style.cursor='pointer'; this.style.color='white';" onmouseout="this.style.background='white'; this.style.color='black';" onclick="numero_jugadores(6);">
                        6
                    </td>
                </tr>
                <tr>
                    <td onmouseover="this.style.background='black'; this.style.cursor='pointer'; this.style.color='white';" onmouseout="this.style.background='white'; this.style.color='black';" onclick="numero_jugadores(7);">
                        7
                    </td>
                </tr>
                   
            </table>
            
            
            <span id="id_seleccion" style="display:none;"><h3>Nombre de los Jugadores</h3></span>
            <table id="id_numero_jugadores" style="display:none">
                <tr>
                    <td onmouseover="this.style.background='black'; this.style.cursor='pointer'; this.style.color='white';" onmouseout="this.style.background='white'; this.style.color='black';">
                        <input id="id_jugador_1" >
                    </td>
                </tr>                
                <tr>
                    <td onmouseover="this.style.background='black'; this.style.cursor='pointer'; this.style.color='white';" onmouseout="this.style.background='white'; this.style.color='black';" onclick="numero_jugadores(3);">
                         <input id="id_jugador_2" >
                    </td>
                </tr>
                <tr>
                    <td onmouseover="this.style.background='black'; this.style.cursor='pointer'; this.style.color='white';" onmouseout="this.style.background='white'; this.style.color='black';" onclick="numero_jugadores(4);">
                         <input id="id_jugador_3" >
                    </td>
                </tr>
                <tr>
                    <td onmouseover="this.style.background='black'; this.style.cursor='pointer'; this.style.color='white';" onmouseout="this.style.background='white'; this.style.color='black';" onclick="numero_jugadores(5);">
                         <input id="id_jugador_4" >
                    </td>
                </tr>
                <tr>
                    <td onmouseover="this.style.background='black'; this.style.cursor='pointer'; this.style.color='white';" onmouseout="this.style.background='white'; this.style.color='black';" onclick="numero_jugadores(6);">
                         <input id="id_jugador_5" >
                    </td>
                </tr>
                <tr>
                    <td onmouseover="this.style.background='black'; this.style.cursor='pointer'; this.style.color='white';" onmouseout="this.style.background='white'; this.style.color='black';" onclick="numero_jugadores(7);">
                         <input id="id_jugador_6" >
                    </td>
                </tr>
                <tr>
                    <td onmouseover="this.style.background='black'; this.style.cursor='pointer'; this.style.color='white';" onmouseout="this.style.background='white'; this.style.color='black';" onclick="numero_jugadores(7);">
                         <input id="id_jugador_7" >
                    </td>
                </tr>
                   
            </table>            
        </center>
    </body>
</html>
