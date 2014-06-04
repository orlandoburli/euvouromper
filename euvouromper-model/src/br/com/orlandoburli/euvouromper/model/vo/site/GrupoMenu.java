package br.com.orlandoburli.euvouromper.model.vo.site;

import br.com.orlandoburli.framework.core.vo.BaseDomain;

public class GrupoMenu extends BaseDomain {

	public static final String TOPO1 = "9";
	public static final String TOPO2 = "8";
	public static final String LATERAL1 = "7";

	public static final String RODAPE1 = "1";
	public static final String RODAPE2 = "2";
	public static final String RODAPE3 = "3";

	public static final String TOPO1_DESCRITIVO = "Topo 1";
	public static final String TOPO2_DESCRITIVO = "Topo 2";
	public static final String LATERAL1_DESCRITIVO = "Lateral 1";
	public static final String RODAPE1_DESCRITIVO = "Rodapé 1";
	public static final String RODAPE2_DESCRITIVO = "Rodapé 2";
	public static final String RODAPE3_DESCRITIVO = "Rodapé 3";

	@Override
	public String[] getValues() {
		return new String[] { TOPO1, TOPO2, LATERAL1, RODAPE1, RODAPE2, RODAPE3 };
	}

	@Override
	public String[] getDescriptions() {
		return new String[] { TOPO1_DESCRITIVO, TOPO2_DESCRITIVO, LATERAL1_DESCRITIVO, RODAPE1_DESCRITIVO, RODAPE2_DESCRITIVO, RODAPE3_DESCRITIVO };
	}

}
