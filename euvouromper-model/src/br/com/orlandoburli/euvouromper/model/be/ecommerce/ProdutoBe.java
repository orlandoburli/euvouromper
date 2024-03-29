package br.com.orlandoburli.euvouromper.model.be.ecommerce;

import java.util.List;

import br.com.orlandoburli.euvouromper.model.dao.ecommerce.ProdutoDao;
import br.com.orlandoburli.euvouromper.model.domains.SimNao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Produto;
import br.com.orlandoburli.euvouromper.model.vo.cadastros.ProfessorVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ProdutoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.TipoProduto;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.TipoValidade;
import br.com.orlandoburli.euvouromper.model.vo.online.ModuloVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.SaveBeException;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class ProdutoBe extends BaseBe<ProdutoVo, ProdutoDao> {

	private static final int TAMANHO_PAGINA_PRODUTOS = 9999;
	private static final String FILTRO_HOME_TIPO = Produto.TABELA_PRODUTO + "." + Produto.Colunas.TIPO_PRODUTO + " IN (" + "'" + TipoProduto.MODULO + "', '" + TipoProduto.PACOTE + "', '" + TipoProduto.CREDITO + "', '" + TipoProduto.TOTAL + "')";

	public ProdutoBe(DAOManager manager) {
		super(manager);
	}

	@Override
	public void doBeforeSave(ProdutoVo vo) throws BeException {
		// Validacoes do tipo de produto
		if (vo.getTipoProduto().equals(TipoProduto.MODULO)) {
			if (vo.getIdModulo() == null) {
				throw new SaveBeException("Informe o módulo!", "idModulo");
			}
			vo.setIdPacote(null);
		} else if (vo.getTipoProduto().equals(TipoProduto.PACOTE)) {
			if (vo.getIdPacote() == null) {
				throw new SaveBeException("Informe o pacote!", "idPacote");
			}
			vo.setIdModulo(null);
		} else if (vo.getTipoProduto().equals(TipoProduto.CREDITO)) {
			vo.setIdModulo(null);
			vo.setIdPacote(null);
		} else if (vo.getTipoProduto().equals(TipoProduto.TOTAL)) {
			vo.setIdModulo(null);
			vo.setIdPacote(null);
		} else if (vo.getTipoProduto().equals(TipoProduto.VIDEO_INDIVIDUAL)) {
			vo.setIdModulo(null);
			vo.setIdPacote(null);
		}

		// Validacoes do tipo de validade
		if (vo.getTipoValidade().equals(TipoValidade.DATA)) {
			if (vo.getDataValidade() == null) {
				throw new SaveBeException("Informe a data de validade!", "dataValidade");
			}
			vo.setDiasValidade(null);
		} else if (vo.getTipoValidade().equals(TipoValidade.DIAS)) {
			if (vo.getDiasValidade() == null || vo.getDiasValidade() <= 0) {
				throw new SaveBeException("Informe os dias de validade!", "dataValidade");
			}
			vo.setDataValidade(null);
		}

		// Recorrente
		if (vo.getRecorrente().equals(SimNao.SIM)) {
			if (vo.getDiasRecorrencia() == null) {
				throw new SaveBeException("Informe os dias de recorrência!", "recorrente");
			} else if (vo.getDiasRecorrencia() <= 0) {
				throw new SaveBeException("Os dias de recorrência deve ser maior que zero!", "recorrente");
			}
		} else if (vo.getRecorrente().equals(SimNao.NAO)) {
			vo.setDiasRecorrencia(null);
		}

		// Url

		if (vo.getUrl() == null || vo.getUrl().trim().equals("") && vo.getNome() != null) {
			vo.setUrl(vo.getNome().toLowerCase());
		}

		super.doBeforeSave(vo);
	}

	public ProdutoVo getByUrl(String url) throws ListException {

		ProdutoVo filter = new ProdutoVo();

		filter.setUrl(url);
		filter.setAtivo(SimNao.SIM);

		List<ProdutoVo> list = getList(filter);

		if (list.size() > 0) {
			return list.get(0);
		}

		return null;
	}

	public ProdutoVo getByModulo(ModuloVo modulo) throws ListException {
		ProdutoVo filter = new ProdutoVo();

		filter.setIdModulo(modulo.getIdModulo());
		filter.setAtivo(SimNao.SIM);

		List<ProdutoVo> list = getList(filter);

		if (list.size() > 0) {
			return list.get(0);
		}

		return null;
	}

	public List<ProdutoVo> getListHome() throws ListException {

		ProdutoVo filter = new ProdutoVo();
		filter.setAtivo(SimNao.SIM);

		return getList(filter, FILTRO_HOME_TIPO, "RANDOM()", 1, 5);
	}

	public Integer getQuantidadePaginasProdutos() throws ListException {
		ProdutoVo filter = new ProdutoVo();

		filter.setAtivo(SimNao.SIM);

		return getPageCount(filter, FILTRO_HOME_TIPO, TAMANHO_PAGINA_PRODUTOS);
	}

	public List<ProdutoVo> getPaginaProdutos(Integer pagina, String tipo) throws ListException {

		ProdutoVo filter = new ProdutoVo();

		filter.setAtivo(SimNao.SIM);

		filter.setTipoProduto(tipo);

		return getList(filter, FILTRO_HOME_TIPO, Produto.TABELA_PRODUTO + "." + Produto.Colunas.NOME, pagina, TAMANHO_PAGINA_PRODUTOS);
	}

	public List<ProdutoVo> getListAtivos() throws ListException {
		ProdutoVo filter = new ProdutoVo();

		filter.setAtivo(SimNao.SIM);

		return getList(filter, FILTRO_HOME_TIPO, Produto.TABELA_PRODUTO + "." + Produto.Colunas.NOME);
	}

	public ProdutoVo getProdutoVideoIndividual() throws ListException {
		ProdutoVo filter = new ProdutoVo();
		filter.setTipoProduto(TipoProduto.VIDEO_INDIVIDUAL);
		filter.setAtivo(SimNao.SIM);

		List<ProdutoVo> list = getList(filter);

		if (list.size() > 0) {
			return list.get(0);
		}

		return null;
	}

	public List<ProdutoVo> getByProfessor(ProfessorVo professor) throws ListException {

		String prefix = Dicionario.Produto.TABELA_PRODUTO + ".";

		StringBuilder sql = new StringBuilder();

		sql.append(prefix + Dicionario.Produto.Colunas.ID_PRODUTO);
		sql.append(" IN (");
		sql.append(" SELECT " + Dicionario.ProfessorProduto.TABELA_PROFESSOR_PRODUTO + "." + Dicionario.ProfessorProduto.Colunas.ID_PRODUTO);
		sql.append(" FROM ");

		sql.append(Dicionario.ProfessorProduto.TABELA_PROFESSOR_PRODUTO + " WHERE ");
		sql.append(Dicionario.ProfessorProduto.Colunas.ID_PROFESSOR + " = " + professor.getIdProfessor());
		sql.append(")");

		return getList(null, sql.toString(), "");
	}
}
