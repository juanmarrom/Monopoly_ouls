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
                var numero_jugadores_global=2;
            
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
                    numero_jugadores_global = valor;
                    document.getElementById("id_numero_jugadores").style.display = "none";
                    document.getElementById("id_seleccion").style.display = "none";                        
                    document.getElementById("id_seleccion_jugadores").style.display = "inline";
                    document.getElementById("id_nombre_jugadores").style.display = "inline";   
                    document.getElementById("id_carpeta").style.display = "inline";   
                    document.getElementById("id_carpeta_text").style.display = "inline";   
                    
                    
                    
                    for (var i = 1; i <= 7; i++) {
                        //console.log(i);
                        var input_id = "id_jugador_" + i + "_tr";
                        if (i > valor) {
                            document.getElementById(input_id).style.display = "none";
                        }
                    }
                    document.getElementById("id_aceptar").style.display = "inline";                        
                    
                                                                                                 
                   /*var valor2 = "nueva";
                   $.ajax({
                        data: {"nombre":valor},
                        url: "Monopoly_Servlet",
                        type: "post",
                        dataType: "html",
                        success: function(response) {
                            location.href ="monopoly.jsp";  
                        }
                    });*/
                }

               function crear_partida() {
                   var nombre1 = document.getElementById("id_jugador_1").value;
                   var color1 = document.getElementById("id_select_1").value;
                   var nombre2 = document.getElementById("id_jugador_2").value;
                   var color2 = document.getElementById("id_select_2").value;
                   var nombre3 = document.getElementById("id_jugador_3").value;
                   var color3 = document.getElementById("id_select_3").value;
                   var nombre4 = document.getElementById("id_jugador_4").value;
                   var color4 = document.getElementById("id_select_4").value;
                   var nombre5 = document.getElementById("id_jugador_5").value;
                   var color5 = document.getElementById("id_select_5").value;
                   var nombre6 = document.getElementById("id_jugador_6").value;
                   var color6 = document.getElementById("id_select_6").value;
                   var nombre7 = document.getElementById("id_jugador_7").value;
                   var color7 = document.getElementById("id_select_7").value;
                   
                   var colores1 = [color1, color2, color3, color4, color5, color6, color7];
                   var colores2 = [color1, color2, color3, color4, color5, color6, color7];
                   for (var i = 0; i < colores1.length; i++) {
                    for (var j = 0; j < colores2.length; j++) {                        
                        if (i != j && i < numero_jugadores_global && j < numero_jugadores_global) {
                            console.log(colores1[i] + "==" + colores2[j]);
                            if (colores1[i] == colores2[j]) {
                                alert("El color " + colores1[i] + " se repite");
                                return;
                            }
                        }
                    }
                   }
                   var carpeta = document.getElementById("id_carpeta").value;
                   if (carpeta == null || carpeta == "") {
                       alert("No hay ruta de ficheros configuración");        
                   }
                   
                   var accion = "nueva";
                   $.ajax({
                        data: {"carpeta":carpeta,"accion":accion,"nombre1":nombre1,"color1":color1,"nombre2":nombre2,"color2":color2,"nombre3":nombre3,"color3":color3,"nombre4":nombre4,"color4":color4,"nombre5":nombre5,"color5":color5,"nombre6":nombre6,"color6":color6,"nombre7":nombre7,"color7":color7},
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
            
            
            <span id="id_seleccion_jugadores" style="display:none;"><h3>Nombre de los Jugadores</h3></span>
            <table id="id_nombre_jugadores" style="display:none">
                <tr id="id_jugador_1_tr">
                    <td>
                        Nombre:&nbsp;<input id="id_jugador_1" >
                    </td>
                    <td>
                        Color:&nbsp;<select id="id_select_1">
                             <option value="azul">Azul</option>
                             <option value="amarillo">Amarillo</option>
                             <option value="rojo">Rojo</option>
                             <option value="naranja">Naranja</option>
                             <option value="verde">Verde</option>
                             <option value="violeta">Violeta</option>
                             <option value="negro">Negro</option>
                         </select>    
                    </td>                                        
                </tr>                
                <tr id="id_jugador_2_tr">
                    <td>
                        Nombre:&nbsp;<input id="id_jugador_2" >
                    </td>
                    <td>
                        Color:&nbsp;<select id="id_select_2">
                             <option value="azul">Azul</option>
                             <option value="amarillo">Amarillo</option>
                             <option value="rojo">Rojo</option>
                             <option value="naranja">Naranja</option>
                             <option value="verde">Verde</option>
                             <option value="violeta">Violeta</option>
                             <option value="negro">Negro</option>
                         </select>    
                    </td>                                        
                </tr>
                <tr id="id_jugador_3_tr">
                    <td>
                        Nombre:&nbsp;<input id="id_jugador_3" >
                    </td>
                    <td>
                        Color:&nbsp;<select id="id_select_3">
                             <option value="azul">Azul</option>
                             <option value="amarillo">Amarillo</option>
                             <option value="rojo">Rojo</option>
                             <option value="naranja">Naranja</option>
                             <option value="verde">Verde</option>
                             <option value="violeta">Violeta</option>
                             <option value="negro">Negro</option>
                         </select>    
                    </td>                                        
                </tr>
                <tr id="id_jugador_4_tr">
                    <td>
                        Nombre:&nbsp;<input id="id_jugador_4" >
                    </td>
                    <td>
                        Color:&nbsp;<select id="id_select_4">
                             <option value="azul">Azul</option>
                             <option value="amarillo">Amarillo</option>
                             <option value="rojo">Rojo</option>
                             <option value="naranja">Naranja</option>
                             <option value="verde">Verde</option>
                             <option value="violeta">Violeta</option>
                             <option value="negro">Negro</option>
                         </select>    
                    </td>                                        
                </tr>
                <tr id="id_jugador_5_tr">
                    <td>
                        Nombre:&nbsp;<input id="id_jugador_5" >
                    </td>
                    <td>
                        Color:&nbsp;<select id="id_select_5">
                             <option value="azul">Azul</option>
                             <option value="amarillo">Amarillo</option>
                             <option value="rojo">Rojo</option>
                             <option value="naranja">Naranja</option>
                             <option value="verde">Verde</option>
                             <option value="violeta">Violeta</option>
                             <option value="negro">Negro</option>
                         </select>    
                    </td>                                        
                </tr>
                <tr id="id_jugador_6_tr">
                    <td>
                        Nombre:&nbsp;<input id="id_jugador_6" >
                    </td>
                    <td>
                        Color:&nbsp;<select id="id_select_6">
                             <option value="azul">Azul</option>
                             <option value="amarillo">Amarillo</option>
                             <option value="rojo">Rojo</option>
                             <option value="naranja">Naranja</option>
                             <option value="verde">Verde</option>
                             <option value="violeta">Violeta</option>
                             <option value="negro">Negro</option>
                         </select>    
                    </td>                                        
                </tr>
                <tr id="id_jugador_7_tr">
                    <td>
                        Nombre:&nbsp;<input id="id_jugador_7" >
                    </td>
                    <td>
                        Color:&nbsp;<select id="id_select_7">
                             <option value="azul">Azul</option>
                             <option value="amarillo">Amarillo</option>
                             <option value="rojo">Rojo</option>
                             <option value="naranja">Naranja</option>
                             <option value="verde">Verde</option>
                             <option value="violeta">Violeta</option>
                             <option value="negro">Negro</option>
                         </select>    
                    </td>
                </tr>   
            </table>
            <br>
            <br>
            <span id="id_carpeta_text"  style="display:none;">Introduzca ruta de ficheros de configuración:<span>&nbsp;<input id="id_carpeta" type="text" style="display:none; width: 300px;">
            <br>
            <br><br>
            <input id="id_aceptar" type="button" value="Aceptar" style="display:none; width: 100px;" onclick="crear_partida()">
        </center>
    </body>
</html>
