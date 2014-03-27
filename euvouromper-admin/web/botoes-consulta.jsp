<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="form-actions text-right">
	<button class="BotaoNavegacaoPrimeiro btn btn-default btn-icon tip" title="Primeiro [Home]">
		<i class="icon-first"></i>
	</button>
	<button class="BotaoNavegacaoAnterior btn btn-default btn-icon tip" title="Anterior [&larr;/PgUp]">
		<i class="icon-previous"></i>
	</button>
	<button class="BotaoNavegacaoProximo btn btn-default btn-icon tip" title="Próximo [&rarr;/PgDown]">
		<i class="icon-next"></i>
	</button>
	<button class="BotaoNavegacaoUltimo btn btn-default btn-icon tip" title="Último [End]">
		<i class="icon-last"></i>
	</button>

</div>

<div class="FormularioBotoes form-actions text-right">
	${customButtons}

	<c:if test="${empty hideNovo}">
		<button type="button" class="BotaoNovo btn btn-lg btn-primary tip" title="Novo Registro (Ctrl + N)">
			<i class="icon-plus-circle"></i> Novo
		</button>
	</c:if>

	<c:if test="${empty hideEditar}">
		<button type="button" class="BotaoEditar btn btn-lg btn-success tip" title="Editar Registro Selecionado (Ctrl + E)">
			<i class="icon-pencil4"></i> Editar
		</button>
	</c:if>
	
	<c:if test="${empty hideExcluir}">
		<button type="button" class="BotaoExcluir btn btn-lg btn-danger tip" title="Excluir Registro Selecionado (Ctrl + Del)">
			<i class="icon-minus-circle"></i> Excluir
		</button>
	</c:if>
</div>