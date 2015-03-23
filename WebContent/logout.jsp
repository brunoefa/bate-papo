<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<jsp:include page="cabecalho.jsp" />

    <div class="container">
      <div class="jumbotron">
        <form class="form-signin" method="post" action="login">
          <label for="usuario" class="sr-only">Usuário</label>
          <input type="hidden" name="acao" value="sair">
          <div class="usuario-logado">${usuario.login}</div>
          <button class="btn btn-lg btn-primary btn-block" type="submit">Sair</button>
          <a class="btn btn-lg btn-success btn-block" href="conversa">Voltar à conversa</a>
        </form>
      </div>
    </div> <!-- /container -->
    
  	<jsp:include page="rodape.jsp" />