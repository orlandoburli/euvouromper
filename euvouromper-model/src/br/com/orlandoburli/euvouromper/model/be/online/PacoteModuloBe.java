package br.com.orlandoburli.euvouromper.model.be.online;

import java.util.List;

import br.com.orlandoburli.euvouromper.model.dao.online.PacoteModuloDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.vo.online.ModuloVo;
import br.com.orlandoburli.euvouromper.model.vo.online.PacoteModuloVo;
import br.com.orlandoburli.euvouromper.model.vo.online.PacoteVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class PacoteModuloBe extends BaseBe<PacoteModuloVo, PacoteModuloDao> {

	public PacoteModuloBe(DAOManager manager) {
		super(manager);
	}

	public List<ModuloVo> getListNotIn(PacoteVo pacote) throws ListException {

		StringBuilder sql = new StringBuilder();

		String prefix = Dicionario.Modulo.TABELA_MODULO + ".";

		sql.append(prefix + Dicionario.Modulo.Colunas.ID_MODULO);
		sql.append(" NOT IN (");
		sql.append(" SELECT " + Dicionario.PacoteModulo.TABELA_PACOTE_MODULO + "." + Dicionario.PacoteModulo.Colunas.ID_MODULO);
		sql.append(" FROM ");

		sql.append(Dicionario.PacoteModulo.TABELA_PACOTE_MODULO + " WHERE ");
		sql.append(Dicionario.PacoteModulo.Colunas.ID_PACOTE + " = " + pacote.getIdPacote());
		sql.append(")");

		String orderFields = prefix + Dicionario.Modulo.Colunas.NOME;
		
		List<ModuloVo> list = new ModuloBe(getManager()).getList(null, sql.toString(), orderFields);

		return list;
	}

}
