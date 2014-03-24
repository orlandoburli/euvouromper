package br.com.orlandoburli.euvouromper.model.be.online;

import br.com.orlandoburli.euvouromper.model.dao.online.VideoDao;
import br.com.orlandoburli.euvouromper.model.vo.online.VideoVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class VideoBe extends BaseBe<VideoVo, VideoDao>{

	public VideoBe(DAOManager manager) {
		super(manager);
	}

}
