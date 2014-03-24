package br.com.orlandoburli.euvouromper.model.dao.online;

import br.com.orlandoburli.euvouromper.model.vo.online.VideoVo;
import br.com.orlandoburli.framework.core.dao.BaseCadastroDao;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class VideoDao extends BaseCadastroDao<VideoVo>{

	public VideoDao(DAOManager manager) {
		super(manager);
	}

}
