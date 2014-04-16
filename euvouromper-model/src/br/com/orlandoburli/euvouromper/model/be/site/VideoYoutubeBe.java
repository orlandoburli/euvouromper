package br.com.orlandoburli.euvouromper.model.be.site;

import java.util.List;

import br.com.orlandoburli.euvouromper.model.dao.site.VideoYoutubeDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.VideoYoutube;
import br.com.orlandoburli.euvouromper.model.vo.site.VideoYoutubeVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class VideoYoutubeBe extends BaseBe<VideoYoutubeVo, VideoYoutubeDao>{

	public VideoYoutubeBe(DAOManager manager) {
		super(manager);
	}

	public VideoYoutubeVo getVideoHome() throws ListException {
		
		List<VideoYoutubeVo> list = getList(null, null, VideoYoutube.TABELA_VIDEO_YOUTUBE + "." + VideoYoutube.Colunas.ID_VIDEO_YOUTUBE + " DESC", 1, 1);
		
		if (list.size() > 0) {
			return list.get(0);
		}
		
		return null;
	}

}
