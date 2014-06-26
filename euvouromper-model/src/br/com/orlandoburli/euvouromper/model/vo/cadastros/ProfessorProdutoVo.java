package br.com.orlandoburli.euvouromper.model.vo.cadastros;

import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Produto;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Professor;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ProdutoVo;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Join;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import static br.com.orlandoburli.euvouromper.model.utils.Dicionario.ProfessorProduto.Colunas.*;

@Table(Dicionario.ProfessorProduto.TABELA_PROFESSOR_PRODUTO)
public class ProfessorProdutoVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	@Column(name = ID_PROFESSOR_PRODUTO, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idProfessorProduto;

	@Column(name = ID_PROFESSOR, dataType = DataType.INT, isNotNull = true)
	private Integer idProfessor;

	@Column(name = ID_PRODUTO, dataType = DataType.INT, isNotNull = true)
	private Integer idProduto;

	@Join(columnsLocal = { ID_PROFESSOR }, columnsRemote = { Professor.Colunas.ID_PROFESSOR })
	private ProfessorVo professor;

	@Join(columnsLocal = { ID_PRODUTO }, columnsRemote = { Produto.Colunas.ID_PRODUTO })
	private ProdutoVo produto;

	public Integer getIdProfessorProduto() {
		return idProfessorProduto;
	}

	public void setIdProfessorProduto(Integer idProfessorProduto) {
		this.idProfessorProduto = idProfessorProduto;
	}

	public Integer getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(Integer idProfessor) {
		this.idProfessor = idProfessor;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public ProfessorVo getProfessor() {
		return professor;
	}

	public void setProfessor(ProfessorVo professor) {
		this.professor = professor;
	}

	public ProdutoVo getProduto() {
		return produto;
	}

	public void setProduto(ProdutoVo produto) {
		this.produto = produto;
	}
}
