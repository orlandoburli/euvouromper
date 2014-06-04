package br.com.orlandoburli.euvouromper.model.be.site;

import java.util.List;

import br.com.orlandoburli.euvouromper.model.dao.site.NewsletterDao;
import br.com.orlandoburli.euvouromper.model.vo.site.NewsletterVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.DeleteBeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class NewsletterBe extends BaseBe<NewsletterVo, NewsletterDao> {

	public NewsletterBe(DAOManager manager) {
		super(manager);
	}

	public void registrar(String email) throws BeException {

		NewsletterVo existente = getByEmail(email);

		if (existente == null) {
			NewsletterVo vo = new NewsletterVo();
			vo.setEmail(email);
			save(vo);
		}
	}

	public void remover(String email) throws ListException, DeleteBeException {
		NewsletterVo existente = getByEmail(email);

		remove(existente);
	}

	public NewsletterVo getByEmail(String email) throws ListException {
		NewsletterVo filter = new NewsletterVo();
		filter.setEmail(email);

		List<NewsletterVo> list = getList(filter);

		if (list.size() > 0) {
			return list.get(0);
		}

		return null;
	}

}
