
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<footer id="footer" class="clear ">
	<div id="footer-content" class="">
		
		<!-- end redes-sociais -->
		<div id="informacoes" class="box-footer span3 left">
			<span><h3>Informações</h3></span>

			<ul class="lista-footer">
				<c:forEach items="${menusRodape1}" var="menu">
					<li><a href="${root}/${menu.url}">${menu.nome}</a></li>
				</c:forEach>
			</ul>

		</div>
		<div id="minha-conta" class="box-footer span3 left">
			<span><h3>Minha Conta</h3></span>

			<ul class="lista-footer">
				<c:forEach items="${menusRodape2}" var="menu">
					<li><a href="${root}/${menu.url}">${menu.nome}</a></li>
				</c:forEach>
			</ul>
		</div>
		<div id="fale-conosco" class="box-footer span3 left">
			<span><h3>Fale conosco</h3></span>
			<p style="margin-top: 15px;">Telefone: (65) 3025-1630</p>
			<p>Rua 2800, N. 25. Jardim Imperial, Cuiabá - MT</p>
			<p>E-mail: contato@euvouromper.com.br</p>
			<!-- <a href="" title="" style="color: #fff;">Google Maps</a> -->
		</div>
		<div id="newsletter" class="box-footer span3 left">
			<span><h3>Newsletter</h3></span>
			<p>Receba nossas informações:</p>
			<form action="${root}/news" method="get" accept-charset="utf-8">
				<div class="">
					<input type="text" value="" placeholder="e-mail" id="email" name="email" />
				</div>
				<input type="submit" value="Cadastrar">
			</form>
		</div>
		
		<div id="pagseguro">
			<img src='https://p.simg.uol.com.br/out/pagseguro/i/banners/divulgacao/468X60_10X_pagseguro.gif' alt='' />
		</div>
	</div>
	<!-- end footer-content -->
</footer>