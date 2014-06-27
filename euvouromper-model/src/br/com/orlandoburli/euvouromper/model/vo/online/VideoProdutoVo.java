package br.com.orlandoburli.euvouromper.model.vo.online;

import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Produto;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Video;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.VideoProduto;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ProdutoVo;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Join;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.dao.annotations.UniqueConstraint;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import static br.com.orlandoburli.euvouromper.model.utils.Dicionario.VideoProduto.Colunas.*;

@Table(value = VideoProduto.TABELA_VIDEO_PRODUTO, constraints = { @UniqueConstraint(columns = { ID_VIDEO, ID_PRODUTO }, constraintName = Dicionario.VideoProduto.UNQ_VIDEO_PRODUTO) })
public class VideoProdutoVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	@Column(name = ID_VIDEO_PRODUTO, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idVideoProduto;

	@Column(name = ID_VIDEO, dataType = DataType.INT, isNotNull = true)
	private Integer idVideo;

	@Column(name = ID_PRODUTO, dataType = DataType.INT, isNotNull = true)
	private Integer idProduto;

	@Join(columnsLocal = { ID_VIDEO }, columnsRemote = { Video.Colunas.ID_VIDEO })
	private VideoVo video;

	@Join(columnsLocal = { ID_PRODUTO }, columnsRemote = { Produto.Colunas.ID_PRODUTO })
	private ProdutoVo produto;

	public Integer getIdVideoProduto() {
		return idVideoProduto;
	}

	public void setIdVideoProduto(Integer idVideoProduto) {
		this.idVideoProduto = idVideoProduto;
	}

	public Integer getIdVideo() {
		return idVideo;
	}

	public void setIdVideo(Integer idVideo) {
		this.idVideo = idVideo;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public VideoVo getVideo() {
		return video;
	}

	public void setVideo(VideoVo video) {
		this.video = video;
	}

	public ProdutoVo getProduto() {
		return produto;
	}

	public void setProduto(ProdutoVo produto) {
		this.produto = produto;
	}
}
