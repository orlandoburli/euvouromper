package br.com.orlandoburli.euvouromper.model.be.online;

import java.util.List;

import br.com.orlandoburli.euvouromper.model.dao.online.ModuloVideoDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.vo.online.ModuloVideoVo;
import br.com.orlandoburli.euvouromper.model.vo.online.ModuloVo;
import br.com.orlandoburli.euvouromper.model.vo.online.VideoVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class ModuloVideoBe extends BaseBe<ModuloVideoVo, ModuloVideoDao> {

	public ModuloVideoBe(DAOManager manager) {
		super(manager);
	}

	/**
	 * Retorna a lista de videos que nao estao no modulo.
	 * 
	 * @param modulo
	 * @return Lista de videos.
	 * @throws ListException
	 */
	public List<VideoVo> getListNotIn(ModuloVo modulo) throws ListException {
		StringBuilder sql = new StringBuilder();

		String prefix = Dicionario.Video.TABELA_VIDEO + ".";

		sql.append(prefix + Dicionario.Video.Colunas.ID_VIDEO);

		sql.append(" NOT IN (");

		sql.append(" SELECT " + Dicionario.ModuloVideo.TABELA_MODULO_VIDEO + "." + Dicionario.ModuloVideo.Colunas.ID_VIDEO);

		sql.append(" FROM ");

		sql.append(Dicionario.ModuloVideo.TABELA_MODULO_VIDEO + " WHERE ");

		sql.append(Dicionario.ModuloVideo.Colunas.ID_MODULO + " = " + modulo.getIdModulo());

		sql.append(")");

		String orderFields = prefix + Dicionario.Video.Colunas.NOME;
		orderFields += ", " + prefix + Dicionario.Video.Colunas.AULA;
		orderFields += ", " + prefix + Dicionario.Video.Colunas.BLOCO;

		List<VideoVo> list = new VideoBe(getManager()).getList(null, sql.toString(), orderFields);

		return list;
	}
}
