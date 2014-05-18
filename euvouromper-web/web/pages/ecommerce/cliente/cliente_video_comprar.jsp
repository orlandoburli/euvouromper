
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<fmt:setLocale value="pt-BR" />

<c:set var="root" value="<%=request.getServletContext().getContextPath()%>" />

<div class="panel">
	<div class="panel-content">
		<div class="">
			<h1 class="">Ops... =/</h1>
			<p>Voc� ainda n�o adquiriu este curso.</p>
			<p>Compre este v�deo individualmente ou em Adicionar ao carrinho acima para comprar o curso completo.</p>

			<c:if test="${not empty produto}">
				<a style="float: none; width: 300px;" href="#" title="Comprar v�deo individual" class="adicionar-carrinho ">Comprar v�deo individual</a>
				<fmt:formatNumber value="${produto.valor}" minFractionDigits="2" type="currency" var="valor" />
				<span class="label-valor">${valor}</span>
			</c:if>
		</div>
	</div>
</div>

<script type="text/javascript">
		$(function() {
			$(".adicionar-carrinho").click(function(e) {
				$.Dialog({
					shadow : true,
					overlay : true,
					flat: true,
					icon : false,
					title : '',
					width : 500,
					padding : 0,
					sysButtons : false,
					content : '',
					onShow : function(_dialog) {
						$.ajax({
							url : '${root}/aluno.video.comprar.page?idVideo=${video.idVideo}',
							type : 'GET',
							success : function(data) {
								$.Dialog.content(data);
								$(".caption").remove();
								$(".window .content").css("padding", "0px");
							}
						});
					}
				});
			});
		});
	</script>