package br.com.orlandoburli.euvouromper.model.be.online;

import java.util.List;

import br.com.orlandoburli.euvouromper.model.dao.online.ModuloDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Modulo;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.PacoteModulo;
import br.com.orlandoburli.euvouromper.model.vo.online.ModuloVo;
import br.com.orlandoburli.euvouromper.model.vo.online.PacoteVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class ModuloBe extends BaseBe<ModuloVo, ModuloDao> {

	public ModuloBe(DAOManager manager) {
		super(manager);
	}

	public List<ModuloVo> getByPacote(PacoteVo pacote) throws ListException {
		String sql = " " + Modulo.TABELA_MODULO + "." + Modulo.Colunas.ID_MODULO + " IN ";
		sql += "(SELECT " + PacoteModulo.TABELA_PACOTE_MODULO + "." + PacoteModulo.Colunas.ID_MODULO;
		sql += " FROM " + PacoteModulo.TABELA_PACOTE_MODULO;
		sql += " WHERE " + PacoteModulo.TABELA_PACOTE_MODULO + "." + PacoteModulo.Colunas.ID_PACOTE + " = " + pacote.getIdPacote() + ")";

		return getList(null, sql, Modulo.TABELA_MODULO + "." + Modulo.Colunas.NOME);
	}
}
