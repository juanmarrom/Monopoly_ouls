<%-- 
    Document   : monopoly
    Created on : 27.05.2017, 11:52:06
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <%
        String nombre_fichero = "";
        String nombre_carpeta = "";
        String id_jugador = request.getParameter("nuevo");
        if (id_jugador.trim().equalsIgnoreCase("0")) {
            nombre_fichero = request.getParameter("nombre");
            nombre_carpeta = request.getParameter("carpeta");            
            HttpSession objSesion = request.getSession(false); 
            objSesion.setAttribute("fichero", nombre_fichero);
            objSesion.setAttribute("carpeta", nombre_carpeta);
        }
    %>    
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Monopoly</title>
        <script src="js/jquery-3.2.1.min.js">

        </script>
        <script>
             <% if (id_jugador.trim().equalsIgnoreCase("1")) {
                    out.print("$(document).ready(function() {");                      
                    out.print("nombreVar = 'inicializar';");
                    out.print("$.ajax({");
                    out.print("data: {'accion':nombreVar},");
                    out.print("url: 'Monopoly_Servlet',");
                    out.print("type: 'post',");
                    out.print("dataType: 'html',");
                    out.print(" success: function(response) {");                    
                    out.print("$('#tablero').html(response);");
                    out.print("}");
                    out.print("});");
                    out.print("nombreVar = 'inicializar_jugadores';");
                    out.print("$.ajax({");
                    out.print("data: {'accion':nombreVar},");
                    out.print("url: 'Monopoly_Servlet',");
                    out.print("type: 'post',");
                    out.print("dataType: 'html',");
                    out.print("success: function(response) {");
                    out.print("$('#menu').html(response);");
                    out.print("}");
                    out.print("});");                                    
                    out.print("});");
                }
                else {
                    out.print("$(document).ready(function() {");                      
                    out.print("var nombreVar = 'cargar';");
                    /*out.print("var nombreFic = '" + nombre_carpeta + "';");
                    out.print("var nombreCarpeta = 'cargar';");*/
                    out.print("    $.ajax({");
                    out.print("data: {'accion':nombreVar},");
                    out.print("      url: 'Monopoly_Servlet',");
                    out.print("      type: 'post',");
                    out.print("      dataType: 'html',");
                    out.print("      success: function(response) {");                    
                    out.print("            $('#tablero').html(response);");
                    out.print("      }");
                    out.print("    });");
                    out.print("nombreVar = 'inicializar_jugadores';");
                    out.print("$.ajax({");
                    out.print("data: {'accion':nombreVar},");
                    out.print("url: 'Monopoly_Servlet',");
                    out.print("type: 'post',");
                    out.print("dataType: 'html',");
                    out.print("success: function(response) {");
                    out.print("$('#menu').html(response);");
                    out.print("}");
                    out.print("});");                                                        
                    out.print("});");                
                }            
            %>    
            /*
                $(document).ready(function() {                      
                    nombreVar = "inicializar";
                    $.ajax({
                      data: {"accion":nombreVar},
                      url: "Monopoly_Servlet",
                      type: "post",
                      dataType: "html",
                      success: function(response) {
                            //alert(response);
                            $('#tablero').html(response);
                      }
                    });
                    nombreVar = "inicializar_jugadores";
                    $.ajax({
                      data: {"accion":nombreVar},
                      url: "Monopoly_Servlet",
                      type: "post",
                      dataType: "html",
                      success: function(response) {
                            //alert(response);
                            $('#menu').html(response);
                      }
                    });                                    
                });*/
                
                function tirar_dado(turno, numero_jugadores) {
                    var nombreVar = "tirar_dado";                    
                    $.ajax({
                      data: {"accion":nombreVar},
                      url: "Monopoly_Servlet",
                      type: "post",
                      dataType: "html",
                      success: function(response) {  
                            $('#menu').html("");
                            $('#menu').html(response);
                      }
                    });          
                }
                
                function comprar(turno_actual, casilla_actual) {
                    var nombreVar = "comprar";                    
                    $.ajax({
                      data: {"accion":nombreVar,"turno_actual":turno_actual,"casilla_actual":casilla_actual},
                      url: "Monopoly_Servlet",
                      type: "post",
                      dataType: "html",
                      success: function(response) {  
                            document.getElementById("id_turno_jugador").style.display = "inline";      
                            document.getElementById("id_boton_turno_jugador").style.display = "inline";
                            document.getElementById("id_si").style.display = "none";
                            document.getElementById("id_no").style.display = "none";
                      }
                    });          
                }

                function pasar() {
                    document.getElementById("id_turno_jugador").style.display = "inline";      
                    document.getElementById("id_boton_turno_jugador").style.display = "inline";      
                    document.getElementById("id_si").style.display = "none";
                    document.getElementById("id_no").style.display = "none";
                }

                function construir(turno_actual, casilla_actual) {
                    var nombreVar = "construir";
                    var casas = 0;
                    if (document.getElementById("id_casas")) {
                        casas = document.getElementById("id_casas").value;
                    }
                    var hoteles = 0;
                    if (document.getElementById("id_hoteles")) {
                       hoteles  = document.getElementById("id_hoteles").value;                   
                    }
                    $.ajax({
                      data: {"accion":nombreVar,"turno_actual":turno_actual,"casilla_actual":casilla_actual,"casas":casas,"hoteles":hoteles},
                      url: "Monopoly_Servlet",
                      type: "post",
                      dataType: "html",
                      success: function(response) {  
                            document.getElementById("id_turno_jugador").style.display = "inline";      
                            document.getElementById("id_boton_turno_jugador").style.display = "inline";
                            document.getElementById("id_const").style.display = "none";
                      }
                    });                    
                    //alert("Casas " + casas + " hoteles " + hoteles);
                }
                
                function guardar() {
                    var nombreVar = "guardar"; 
                    var nombre_fichero = document.getElementById("id_guardar_text").value;
                    $.ajax({
                      data: {"accion":nombreVar,"nombre_guardar":nombre_fichero},
                      url: "Monopoly_Servlet",
                      type: "post",
                      dataType: "html",
                      success: function(response) {  
                           /* document.getElementById("id_turno_jugador").style.display = "inline";      
                            document.getElementById("id_boton_turno_jugador").style.display = "inline";
                            document.getElementById("id_const").style.display = "none";*/
                      }
                    });
                    /*document.getElementById("id_turno_jugador").style.display = "inline";      
                    document.getElementById("id_boton_turno_jugador").style.display = "inline";
                    document.getElementById("id_const").style.display = "none";
                    var casas = document.getElementById("id_casas").value;
                    var hoteles = document.getElementById("id_hoteles").value;
                    alert("Casas " + casas + " hoteles " + hoteles);*/

                }


                
        </script>
	   <style>
		   * {
				margin: 0;
		   }
		   html, body {
				height: 100%;
		   }
		   
		   .wrapper {
			   min-height: 100%;
			   height: auto !important;
			   height: 100%;
			   margin: 0 auto -4em;
		   }
		   .footer, .push {
			   height: 2em;
		   }
		   
		   #cabecera {
				width: 100%;
				margin: 0 auto 10px auto;
				bottom: 0px;
				background: #f8f8f8;
			}
		   
		   #menu {
				height: auto;
				width: 240px;
				min-width: 240px;
				max-width: 240px;
				float: left;
				height: auto;
				text-align: left;
				margin-right: 5px;
				border: 1px black
			}

			#tablero {
				width: 100%;
				background-color: #f8f8f8;
				display: table-cell;
				vertical-align: top;
				border: 1px black
			}
	   </style>        
    </head>
    <body>
 		<div id="cabecera">MONOPOLY
                    <input id='id_guardar' type='button' value='Guardar con nombre' style='width: 200px;' onclick='guardar()'>
                    <input id='id_guardar_text' type='text' value='' style='width: 200px;'>
		</div>
		<div class="wrapper">
			<div style="display:table;width:100%;">
				<div id="menu" style="display: table-cell;">Menu</div>
				<div id="tablero" style="display: table-cell;">
					
				</div>
			</div>
            <div class="push"></div>
       </div>
       <div class="footer">
            <!--<p>Copyright (c) Juan Martínez Romero</p>--->
       </div>
   </body>
</html>
