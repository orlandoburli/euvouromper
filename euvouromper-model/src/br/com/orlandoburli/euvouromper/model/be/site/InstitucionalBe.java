package br.com.orlandoburli.euvouromper.model.be.site;

import java.util.List;

import br.com.orlandoburli.euvouromper.model.dao.site.InstitucionalDao;
import br.com.orlandoburli.euvouromper.model.vo.site.InstitucionalVo;
import br.com.orlandoburli.euvouromper.model.vo.site.StatusInstitucional;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class InstitucionalBe extends BaseBe<InstitucionalVo, InstitucionalDao> {

	public InstitucionalBe(DAOManager manager) {
		super(manager);
	}

	@Override
	public void doBeforeSave(InstitucionalVo vo) throws BeException {
		if (vo.getUrl() == null || vo.getUrl().trim().equals("")) {
			vo.setUrl(vo.getTitulo().toLowerCase());
		}
		
		super.doBeforeSave(vo);
	}
	
	
	public InstitucionalVo getByUrl(String url) throws ListException {
		InstitucionalVo filter = new InstitucionalVo();
		
		filter.setUrl(url);
		filter.setStatus(StatusInstitucional.PUBLICADO);
		
		List<InstitucionalVo> list = getList(filter);
		
		if (list.size() > 0) {
			return list.get(0);
		}
		
		return null;
	}
}