<%-- 
<div style="text-align: center;">
	<iframe src="<%= request.getContextPath() %>/flex/index.html?v=${urlVideo}&i=${item}&nome=${nomeCliente64}&cpf=${cpfCliente64}" frameborder="0" width="500" height="300"> </iframe>
</div>
 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="root" value="<%=request.getServletContext().getContextPath()%>" />

<video id="video1" class="video-js vjs-default-skin" controls preload="auto" width="600" height="264" poster="http://video-js.zencoder.com/oceans-clip.png" data-setup='{"example_option":true}'>
	<source src="${root}/aluno.video.get?v=${urlVideo}" type='video/mp4' />
</video>

<script type="text/javascript">
	videojs("video1").ready(function(){
	  var myPlayer = this;

	  myPlayer.play();

	});
</script>