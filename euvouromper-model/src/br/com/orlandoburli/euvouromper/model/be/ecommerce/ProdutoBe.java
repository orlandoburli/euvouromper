package br.com.orlandoburli.euvouromper.model.be.ecommerce;

import java.util.List;

import br.com.orlandoburli.euvouromper.model.dao.ecommerce.ProdutoDao;
import br.com.orlandoburli.euvouromper.model.domains.SimNao;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ProdutoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.TipoProduto;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.TipoValidade;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.SaveBeException;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class ProdutoBe extends BaseBe<ProdutoVo, ProdutoDao> {

	public ProdutoBe(DAOManager manager) {
		super(manager);
	}

	@Override
	public void doBeforeSave(ProdutoVo vo) throws BeException {
		// Validacoes do tipo de produto
		if (vo.getTipoProduto().equals(TipoProduto.MODULO)) {
			if (vo.getIdModulo() == null) {
				throw new SaveBeException("Informe o módulo!");
			}
			vo.setIdPacote(null);
		} else if (vo.getTipoProduto().equals(TipoProduto.PACOTE)) {
			if (vo.getIdPacote() == null) {
				throw new SaveBeException("Informe o pacote!");
			}
			vo.setIdModulo(null);
		} else if (vo.getTipoProduto().equals(TipoProduto.CREDITO)) {
			vo.setIdModulo(null);
			vo.setIdPacote(null);
		} else if (vo.getTipoProduto().equals(TipoProduto.TOTAL)) {
			vo.setIdModulo(null);
			vo.setIdPacote(null);
		}

		// Validacoes do tipo de validade
		if (vo.getTipoValidade().equals(TipoValidade.DATA)) {
			if (vo.getDataValidade() == null) {
				throw new SaveBeException("Informe a data de validade!");
			}
			vo.setDiasValidade(null);
		} else if (vo.getTipoValidade().equals(TipoValidade.DIAS)) {
			if (vo.getDiasValidade() == null) {
				throw new SaveBeException("Informe os dias de validade!");
			}
			vo.setDataValidade(null);
		}

		// Recorrente
		if (vo.getRecorrente().equals(SimNao.SIM)) {
			if (vo.getDiasRecorrencia() == null) {
				throw new SaveBeException("Informe os dias de recorrência!");
			} else if (vo.getDiasRecorrencia() <= 0) {
				throw new SaveBeException("Os dias de recorrência deve ser maior que zero!");
			}
		} else if (vo.getRecorrente().equals(SimNao.NAO)) {
			vo.setDiasRecorrencia(null);
		}

		super.doBeforeSave(vo);
	}

	public List<ProdutoVo> getListHome() throws ListException {

		ProdutoVo filter = new ProdutoVo();
		filter.setAtivo(SimNao.SIM);

		return getList(filter, null, "RANDOM()", 1, 5);
	}
}
