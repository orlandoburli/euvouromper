package br.com.orlandoburli.euvouromper.model.be.site;

import java.util.List;

import br.com.orlandoburli.euvouromper.model.dao.site.ArtigoDao;
import br.com.orlandoburli.euvouromper.model.vo.site.ArtigoVo;
import br.com.orlandoburli.euvouromper.model.vo.site.StatusArtigo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class ArtigoBe extends BaseBe<ArtigoVo, ArtigoDao>{

	public ArtigoBe(DAOManager manager) {
		super(manager);
	}

	public ArtigoVo getByUrl(String url) throws ListException {
		ArtigoVo filter = new ArtigoVo();
		
		filter.setUrl(url);
		filter.setStatus(StatusArtigo.PUBLICADO);
		
		List<ArtigoVo> list = getList(filter);
		
		if (list.size() > 0) {
			return list.get(0);
		}
		
		return null;
	}
}
