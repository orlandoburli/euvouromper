package br.com.orlandoburli.euvouromper.model.be.online;

import java.util.List;

import br.com.orlandoburli.euvouromper.model.dao.online.VideoDao;
import br.com.orlandoburli.euvouromper.model.domains.SimNao;
import br.com.orlandoburli.euvouromper.model.vo.online.VideoVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class VideoBe extends BaseBe<VideoVo, VideoDao> {

	public VideoBe(DAOManager manager) {
		super(manager);
	}

	public List<VideoVo> getListaGratuitosHome() throws ListException {
		VideoVo filter = new VideoVo();

		filter.setGratuito(SimNao.SIM);

		return getList(filter, null, " RANDOM()", 1, 4);
	}

}
