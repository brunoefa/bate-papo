<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<jsp:include page="cabecalho.jsp" />

    <div class="container">
      <div class="jumbotron">
        <form class="form-signin" method="get" action="login">
          <label for="usuario" class="sr-only">Usuário</label>
          <input type="hidden" name="acao" value="cadastrar">
          <input type="text" id="nome" name="nome" class="form-control" placeholder="Nome" required autofocus>
          <input type="text" id="usuario" name="login" class="form-control" placeholder="Usuário" required>
          <input type="password" id="senha" name="senha" class="form-control" placeholder="Senha" required>
          <button class="btn btn-lg btn-primary btn-block" type="submit">Cadastrar</button>
          ${mensagem}
          <a href="login" >Já possui cadastro? Faça login.</a>
        </form>
      </div>
    </div> <!-- /container -->
    
  	<jsp:include page="rodape.jsp" />