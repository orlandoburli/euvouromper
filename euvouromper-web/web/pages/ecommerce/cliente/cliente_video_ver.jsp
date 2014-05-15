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
</blockquote>