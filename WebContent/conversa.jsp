
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <jsp:include page="cabecalho.jsp" />
    
    <div class="container">

      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron conversation">
       <c:forEach items="${listaConversa}" var="conversa">
       		<c:if test="${conversa.usuario eq usuario.login}">
       			<div class="alert alert-logado align-right" role="alert">${conversa.mensagem}</div><br />
       		</c:if>
       		<c:if test="${conversa.usuario ne usuario.login}">
       			<div class="alert alert-${usuario.cor}" role="alert"><strong>${conversa.usuario}: </strong>${conversa.mensagem}</div><br />
       		</c:if>
       </c:forEach>        
      </div>
      
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