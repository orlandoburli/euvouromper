package br.com.orlandoburli.euvouromper.model.be.site;

import java.util.List;

import br.com.orlandoburli.euvouromper.model.dao.site.NoticiaDao;
import br.com.orlandoburli.euvouromper.model.vo.site.NoticiaVo;
import br.com.orlandoburli.euvouromper.model.vo.site.StatusNoticia;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class NoticiaBe extends BaseBe<NoticiaVo, NoticiaDao> {

	public NoticiaBe(DAOManager manager) {
		super(manager);
	}

	@Override
	public void doBeforeSave(NoticiaVo vo) throws BeException {
		if (vo.getTitulo() != null && !vo.getTitulo().trim().equals("")) {
			vo.setUrl(vo.getTitulo().toLowerCase());
		}

		super.doBeforeSave(vo);
	}
	
	public NoticiaVo getByUrl(String url) throws ListException {
		NoticiaVo filter = new NoticiaVo();
		
		filter.setUrl(url);
		filter.setStatus(StatusNoticia.PUBLICADO);
		
		List<NoticiaVo> list = getList(filter);
		
		if (list.size() > 0) {
			return list.get(0);
		}
		
		return null;
	}

}
