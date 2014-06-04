package br.com.orlandoburli.euvouromper.model.be.cadastros;

import java.util.List;

import br.com.orlandoburli.euvouromper.model.be.ecommerce.ProdutoBe;
import br.com.orlandoburli.euvouromper.model.dao.cadastros.ProfessorProdutoDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.vo.cadastros.ProfessorProdutoVo;
import br.com.orlandoburli.euvouromper.model.vo.cadastros.ProfessorVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ProdutoVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class ProfessorProdutoBe extends BaseBe<ProfessorProdutoVo, ProfessorProdutoDao>{

	public ProfessorProdutoBe(DAOManager manager) {
		super(manager);
	}

	public List<ProdutoVo> getListNotIn(ProfessorVo professor) throws ListException {
		
		StringBuilder sql = new StringBuilder();

		String prefix = Dicionario.Produto.TABELA_PRODUTO + ".";

		sql.append(prefix + Dicionario.Produto.Colunas.ID_PRODUTO);
		sql.append(" NOT IN (");
		sql.append(" SELECT " + Dicionario.ProfessorProduto.TABELA_PROFESSOR_PRODUTO + "." + Dicionario.ProfessorProduto.Colunas.ID_PRODUTO);
		sql.append(" FROM ");

		sql.append(Dicionario.ProfessorProduto.TABELA_PROFESSOR_PRODUTO + " WHERE ");
		sql.append(Dicionario.ProfessorProduto.Colunas.ID_PROFESSOR+ " = " + professor.getIdProfessor());
		sql.append(")");

		String orderFields = prefix + Dicionario.Produto.Colunas.NOME;
		
		List<ProdutoVo> list = new ProdutoBe(getManager()).getList(null, sql.toString(), orderFields);

		return list;
	}

}
