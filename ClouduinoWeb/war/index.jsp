<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link href="favicon.ico" rel="icon" type="image/x-icon">
    <title>Clouduino! App Engine</title>

	<style type="text/css">		
		.large { 
		  font-family:arial; 
		  font-size: 1.8em; 
		}
		.mensagem { 
		  font-family:arial; 
		  font-size: 0.8em; 
		  margin: 20px;
		  background: #CFC;
		  width: 300px; 
		  text-align: center;
		  <!--border: 1px dotted green;-->
		  
		}
		body {
			font-family:arial; 
			font-size: 1em; 
		}
		
	</style>
	
	<script language="javascript" type="text/javascript">	
	    function limpar() {
	    	document.getElementById("mensagem").value = "";
	    	document.getElementById("msgsimbols").innerHTML= "";
	    	document.getElementById("msgsucesso").innerHTML= "";
	    }
	</script>
	
	<script language="javascript" type="text/javascript">	
		function enviaComando(valor){
			document.getElementById("mensagem").value = valor;
			document.forms[0].submit();
		}
   </script> 
   
	<script language="javascript" type="text/javascript">	
		function show(){
			document.getElementById('msgsucesso').style.visibility = 'visible';
			setInterval(hide, 3000);
		}
			function hide(){
			document.getElementById('msgsucesso').style.visibility = 'hidden';
		}
	</script> 
   
	<script language="javascript" type="text/javascript">	
		function preencheMensagem(valor){
			msg = document.getElementById("mensagem").value;
			document.getElementById("mensagem").value = msg + valor;
			switch (valor){
				case 1:
					msgsimbols = document.getElementById("msgsimbols").innerHTML;
					document.getElementById("msgsimbols").innerHTML = msgsimbols + "&uarr; ";
					break;
				case 2:
					msgsimbols = document.getElementById("msgsimbols").innerHTML;
					document.getElementById("msgsimbols").innerHTML = msgsimbols + "&darr; ";
					break;
				case 3:
					msgsimbols = document.getElementById("msgsimbols").innerHTML;
					document.getElementById("msgsimbols").innerHTML = msgsimbols + "&larr; ";
					break;
				case 4:
					msgsimbols = document.getElementById("msgsimbols").innerHTML;
					document.getElementById("msgsimbols").innerHTML = msgsimbols + "&rarr; ";
					break;
				case 5:
					msgsimbols = document.getElementById("msgsimbols").innerHTML;
					document.getElementById("msgsimbols").innerHTML = msgsimbols + "&Lambda; ";
					break;
				case 6:
					msgsimbols = document.getElementById("msgsimbols").innerHTML;
					document.getElementById("msgsimbols").innerHTML= msgsimbols + "&Delta; ";
					break;				
			}			
		}	
	</script>

  </head>

  <!--<body onload="show();">-->
  <body>
    <h1>Clouduino! App Engine</h1>
    
    
	<form name="formMensagem" action="/GravaDadosServlet">
	Comandos:
	    <table>
	      <tr>
	        <td onmouseover="this.style.border='1px solid #0000FF';" onmouseout="this.style.border='1px solid #FFFFFF';"><a href="#"><img onclick="enviaComando(1)" alt="Up" id="up" src="arrow_up.png"></a></td>
	        <td onmouseover="this.style.border='1px solid #0000FF';" onmouseout="this.style.border='1px solid #FFFFFF';"><a href="#"><img onclick="enviaComando(2)" alt="Down" id="down" src="arrow_down.png"></a></td>
	
	        <td onmouseover="this.style.border='1px solid #0000FF';" onmouseout="this.style.border='1px solid #FFFFFF';"><a href="#"><img onclick="enviaComando(3)" alt="Left" id="left" src="arrow_left.png"></a></td>
	        <td onmouseover="this.style.border='1px solid #0000FF';" onmouseout="this.style.border='1px solid #FFFFFF';"><a href="#"><img onclick="enviaComando(4)" alt="Right" id="right" src="arrow_right.png"></a></td>
 
	        <td onmouseover="this.style.border='1px solid #0000FF';" onmouseout="this.style.border='1px solid #FFFFFF';"><a href="#"><img onclick="enviaComando(5)" alt="Open" id="open" src="open.jpg"></a></td>
	        <td onmouseover="this.style.border='1px solid #0000FF';" onmouseout="this.style.border='1px solid #FFFFFF';"><a href="#"><img onclick="enviaComando(6)" alt="Close" id="close" src="close_2.jpg"></a></td>
	      </tr>  	      
	    </table>
	</br>
	    
	    <div class="large" id="msgsimbols"></div>
	    
	    <div class="mensagem" id="msgsucesso" style="visibility:hidden; display:none;">
	    	${param.msgsucesso}
	    </div>
	    
	    <input type="hidden" value="" id="mensagem" name="mensagem" size="20">
	</br>
 	<div style="visibility:hidden; display:none;">
		<input type="submit" value="Enviar"> 
		<input type="button" value="Limpar" onclick="limpar()">
    </div>
    </form>
    
  </body>
</html>
