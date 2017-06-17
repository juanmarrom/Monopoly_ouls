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
        <title>JSP Page</title>
        <script src="js/jquery-3.2.1.min.js">

        </script>
        <script>
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
                });
                
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
                      }
                    });          
                }

                function pasar() {
                    document.getElementById("id_turno_jugador").style.display = "inline";      
                    document.getElementById("id_boton_turno_jugador").style.display = "inline";      
                   //id_turno_jugador
                   //id_boton_turno_jugador
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
