<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    <jsp:include page="cabecalho.jsp" />
    
    <div class="container">

      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron conversation">
        <div class="alert alert-success" role="alert"><strong>João:</strong> Oi quer tc?</div><br />
        <div class="alert alert-info" role="alert"><strong>José:</strong> Escreve direito porra!</div><br />
        <div class="alert alert-warning" role="alert"><strong>Maria:</strong> kkkk</div><br />
        <div class="alert alert-danger" role="alert"><strong>Fulano:</strong> Uma mensagem grande só pra testar a caixa de diálogo Uma mensagem grande só pra testar a caixa de diálogo Uma mensagem grande só pra testar a caixa de diálogo Uma mensagem grande só pra testar a caixa de diálogo Uma mensagem grande só pra testar a caixa de diálogo Uma mensagem grande só pra testar a caixa de diálogo </div><br />
        <div class="alert alert-success align-right" role="alert">Oi quer tc?</div><br />
        <div class="alert alert-info" role="alert"><strong>José:</strong> Escreve direito porra!</div><br />
        <div class="alert alert-warning" role="alert"><strong>Maria:</strong> kkkk</div><br />
        <div class="alert alert-danger" role="alert"><strong>Fulano:</strong> Uma mensagem grande só pra testar a caixa de diálogo</div><br />
        <div> <div class="alert alert-success align-right" role="alert">  só pra testar a caixa de diálogo Uma mensagem grande só pra testar a caixa de diálogo Uma mensagem grande só pra testar a caixa de diálogo </div><br /></div>
        <div class="alert alert-info" role="alert"><strong>José:</strong> Escreve direito porra!</div><br />
        <div class="alert alert-success" role="alert"><strong>João:</strong> Oi quer tc?</div><br />
        <div class="alert alert-info" role="alert"><strong>José:</strong> Escreve direito porra!</div><br />
        <div class="alert alert-warning" role="alert"><strong>Maria:</strong> kkkk</div><br />
        <div class="alert alert-danger" role="alert"><strong>Fulano:</strong> Uma mensagem grande só pra testar a caixa de diálogo Uma mensagem grande só pra testar a caixa de diálogo Uma mensagem grande só pra testar a caixa de diálogo Uma mensagem grande só pra testar a caixa de diálogo Uma mensagem grande só pra testar a caixa de diálogo Uma mensagem grande só pra testar a caixa de diálogo </div><br />
        <div class="alert alert-success align-right" role="alert">Oi quer tc?</div><br />
        <div class="alert alert-info" role="alert"><strong>José:</strong> Escreve direito porra!</div><br />
        <div class="alert alert-warning" role="alert"><strong>Maria:</strong> kkkk</div><br />
        <div class="alert alert-danger" role="alert"><strong>Fulano:</strong> Uma mensagem grande só pra testar a caixa de diálogo</div><br />
        <div> <div class="alert alert-success align-right" role="alert">  só pra testar a caixa de diálogo Uma mensagem grande só pra testar a caixa de diálogo Uma mensagem grande só pra testar a caixa de diálogo </div><br /></div>
        <div class="alert alert-info" role="alert"><strong>José:</strong> Escreve direito porra!</div><br />
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