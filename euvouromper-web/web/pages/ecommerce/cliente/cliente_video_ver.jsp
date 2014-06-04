<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:set var="root" value="<%=request.getServletContext().getContextPath()%>" />


<div style="text-align: center;">
	<iframe src="<%= request.getContextPath() %>/flex/index.html?v=${urlVideo}&i=${item}&nome=${nomeCliente64}&cpf=${cpfCliente64}" frameborder="0" width="500" height="300"> </iframe>
</div>

<blockquote>
	<div class="input-control text size4 ">
		<div class="input-control text size4">
			<span class="item-title-secondary">${video.nome} Aula ${video.aula} Bloco ${video.bloco}</span>
		</div>
	</div>
	
	<div class="input-control text size4 block">
		<p>Professor: ${video.professor.nome}</p>
	</div>
	
	<div class="input-control text size4 block">
		<p>Disciplina: ${video.disciplina.nome}</p>
	</div>
	
	<div class="input-control text size4 block">
		<a href="javascript:void(0)" class="material-apoio">Materiais de apoio</a>
	</div>
	
</blockquote>

<script type="text/javascript">
		$(function() {
			$(".material-apoio").click(function(e) {
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
							url : '${root}/materialapoio.page?idModulo=${idModulo}',
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