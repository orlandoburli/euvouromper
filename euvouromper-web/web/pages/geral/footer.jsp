
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<footer id="footer" class="clear ">
	<div id="footer-content" class="">
		<div id="redes-sociais">
			<ul class="">
				<li><a href="" title="" class="facebook">facebook</a></li>
				<li><a href="" title="" class="twitter">twitter</a></li>
				<li><a href="" title="" class="google">google +</a></li>
				<li><a href="" title="" class="youtube">youtube</a></li>
			</ul>
		</div>
		<!-- end redes-sociais -->
		<div id="informacoes" class="box-footer span3 left">
			<span><h3>Informações</h3></span>

			<ul class="lista-footer">
				<c:forEach items="${menusRodape1}" var="menu">
					<li><a href="${menu.url}">${menu.nome}</a></li>
				</c:forEach>
			</ul>

		</div>
		<div id="minha-conta" class="box-footer span3 left">
			<span><h3>Minha Conta</h3></span>

			<ul class="lista-footer">
				<c:forEach items="${menusRodape2}" var="menu">
					<li><a href="${menu.url}">${menu.nome}</a></li>
				</c:forEach>
			</ul>
		</div>
		<div id="fale-conosco" class="box-footer span3 left">
			<span><h3>Fale conosco</h3></span>
			<p style="margin-top: 15px;">Telefone: 1-000-000-0000</p>
			<p>Rua Teste Q. 03 Nº 04 Apto. 16</p>
			<p>E-mail: contato@euvouromper.com.br</p>
			<!-- <a href="" title="" style="color: #fff;">Google Maps</a> -->
		</div>
		<div id="newsletter" class="box-footer span3 left">
			<span><h3>Newsletter</h3></span>
			<p>Receba nossas informações:</p>
			<form action="" method="get" accept-charset="utf-8">
				<div class="">
					<input type="text" value="" placeholder="e-mail" />
				</div>
				<input type="submit" value="Cadastrar">
			</form>
		</div>
		<div id="pagseguro"></div>
	</div>
	<!-- end footer-content -->
</footer>