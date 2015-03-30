
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <jsp:include page="cabecalho.jsp" />
    
    <div class="container">

      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron conversation">
       <c:forEach items="${listaConversa}" var="conversa">
       		<div class="alert alert-danger" role="alert"><strong>${conversa.usuario}: </strong>${conversa.mensagem}</div><br />
       </c:forEach>        
      </div>
      
      <%
	      int i = 0;	
	      for(i = 0; i<10; i++){
      %>
      		<div class="alert alert-danger" role="alert"><strong>${conversa.usuario}: </strong>${conversa.mensagem}</div><br />
      <%
      	   }
      %>
      
      
      <div class="box-div">
        <form class="form-inline" action="conversa" method="post">
          <div class="form-group">
            <input type="text" class="form-control input-message" id="mensagem" name="mensagem" autofocus>
            <input type="hidden" class="form-control" name="acao" value="salvar">
          </div>
          <button type="submit" class="btn btn-primary enviar-mensagem"> <span class="glyphicon glyphicon-share-alt" aria-hidden="true"></span></button>
        </form>
      </div>

    </div> <!-- /container -->
    
    <jsp:include page="rodape.jsp" />