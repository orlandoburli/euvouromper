package br.com.orlandoburli.euvouromper.model.vo.admin;

import br.com.orlandoburli.euvouromper.model.domains.SimNao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.PerfilAdmin;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.PerfilAdmin.Colunas;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Domain;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MaxSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;

@Table(PerfilAdmin.TABELA_PERFIL_ADMIN)
public class PerfilAdminVo extends BaseVo {
	@Column(name = Colunas.ID_PERFIL, dataType = DataType.INT, isNotNull = true, isAutoIncrement = true, isKey = true)
	private Integer idPerfil;

	@Column(name = Colunas.NOME, dataType = DataType.VARCHAR, isNotNull = true, maxSize = 100)
	@NotEmpty
	@NotNull
	@MaxSize(100)
	@Description("Nome")
	private String nome;

	// Grupo Administracao

	@Column(name = Colunas.P_PARAMETRO_VER, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoParametroVer;

	@Column(name = Colunas.P_PARAMETRO_ALT, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoParametroAlt;

	@Column(name = Colunas.P_PERFIL_VER, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoPerfilVer;

	@Column(name = Colunas.P_PERFIL_ALT, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoPerfilAlt;

	@Column(name = Colunas.P_USUARIO_VER, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoUsuarioVer;

	@Column(name = Colunas.P_USUARIO_ALT, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoUsuarioAlt;

	// Grupo Cadastros

	@Column(name = Colunas.P_DISCIPLINA_VER, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoDisciplinaVer;

	@Column(name = Colunas.P_DISCIPLINA_ALT, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoDisciplinaAlt;

	@Column(name = Colunas.P_PROFESSOR_VER, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoProfessorVer;

	@Column(name = Colunas.P_PROFESSOR_ALT, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoProfessorAlt;

	// Grupo Site

	@Column(name = Colunas.P_DEPARTAMENTO_VER, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoDepartamentoVer;

	@Column(name = Colunas.P_DEPARTAMENTO_ALT, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoDepartamentoAlt;

	@Column(name = Colunas.P_MENU_VER, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoMenuVer;

	@Column(name = Colunas.P_MENU_ALT, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoMenuAlt;

	@Column(name = Colunas.P_BANNER_VER, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoBannerVer;

	@Column(name = Colunas.P_BANNER_ALT, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoBannerAlt;

	@Column(name = Colunas.P_DEPOIMENTO_VER, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoDepoimentoVer;

	@Column(name = Colunas.P_DEPOIMENTO_ALT, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoDepoimentoAlt;

	@Column(name = Colunas.P_VIDEOYOUTUBE_VER, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoVideoYoutubeVer;

	@Column(name = Colunas.P_VIDEOYOUTUBE_ALT, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoVideoYoutubeAlt;

	@Column(name = Colunas.P_NOTICIA_VER, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoNoticiaVer;

	@Column(name = Colunas.P_NOTICIA_ALT, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoNoticiaAlt;

	@Column(name = Colunas.P_ARTIGO_VER, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoArtigoVer;

	@Column(name = Colunas.P_ARTIGO_ALT, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoArtigoAlt;

	@Column(name = Colunas.P_AGENDA_VER, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoAgendaVer;

	@Column(name = Colunas.P_AGENDA_ALT, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoAgendaAlt;

	@Column(name = Colunas.P_INSTITUCIONAL_VER, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoInstitucionalVer;

	@Column(name = Colunas.P_INSTITUCIONAL_ALT, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoInstitucionalAlt;

	// Online

	@Column(name = Colunas.P_VIDEO_VER, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoVideoVer;

	@Column(name = Colunas.P_VIDEO_ALT, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoVideoAlt;

	@Column(name = Colunas.P_MODULO_VER, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoModuloVer;

	@Column(name = Colunas.P_MODULO_ALT, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoModuloAlt;

	@Column(name = Colunas.P_PACOTE_VER, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoPacoteVer;

	@Column(name = Colunas.P_PACOTE_ALT, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoPacoteAlt;

	@Column(name = Colunas.P_MATERIAL_APOIO_VER, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoMaterialApoioVer;

	@Column(name = Colunas.P_MATERIAL_APOIO_ALT, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoMaterialApoioAlt;

	// e-Commerce

	@Column(name = Colunas.P_PRODUTO_VER, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoProdutoVer;

	@Column(name = Colunas.P_PRODUTO_ALT, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoProdutoAlt;

	@Column(name = Colunas.P_CUPOM_VER, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoCupomVer;

	@Column(name = Colunas.P_CUPOM_ALT, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoCupomAlt;

	@Column(name = Colunas.P_EMAIL_VER, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoEmailVer;

	@Column(name = Colunas.P_EMAIL_ALT, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoEmailAlt;

	@Column(name = Colunas.P_MENSAGEM_VER, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoMensagemVer;

	@Column(name = Colunas.P_MENSAGEM_ALT, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoMensagemAlt;

	@Column(name = Colunas.P_PEDIDO_VER, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoPedidoVer;

	@Column(name = Colunas.P_PEDIDO_ALT, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'N'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoPedidoAlt;

	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getPermissaoPerfilVer() {
		return permissaoPerfilVer;
	}

	public void setPermissaoPerfilVer(String permissaoPerfilVer) {
		this.permissaoPerfilVer = permissaoPerfilVer;
	}

	public String getPermissaoPerfilAlt() {
		return permissaoPerfilAlt;
	}

	public void setPermissaoPerfilAlt(String permissaoPerfilAlt) {
		this.permissaoPerfilAlt = permissaoPerfilAlt;
	}

	public String getPermissaoUsuarioVer() {
		return permissaoUsuarioVer;
	}

	public void setPermissaoUsuarioVer(String permissaoUsuarioVer) {
		this.permissaoUsuarioVer = permissaoUsuarioVer;
	}

	public String getPermissaoUsuarioAlt() {
		return permissaoUsuarioAlt;
	}

	public void setPermissaoUsuarioAlt(String permissaoUsuarioAlt) {
		this.permissaoUsuarioAlt = permissaoUsuarioAlt;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPermissaoParametroVer() {
		return permissaoParametroVer;
	}

	public void setPermissaoParametroVer(String permissaoParametroVer) {
		this.permissaoParametroVer = permissaoParametroVer;
	}

	public String getPermissaoParametroAlt() {
		return permissaoParametroAlt;
	}

	public void setPermissaoParametroAlt(String permissaoParametroAlt) {
		this.permissaoParametroAlt = permissaoParametroAlt;
	}

	public String getPermissaoDisciplinaVer() {
		return permissaoDisciplinaVer;
	}

	public void setPermissaoDisciplinaVer(String permissaoDisciplinaVer) {
		this.permissaoDisciplinaVer = permissaoDisciplinaVer;
	}

	public String getPermissaoDisciplinaAlt() {
		return permissaoDisciplinaAlt;
	}

	public void setPermissaoDisciplinaAlt(String permissaoDisciplinaAlt) {
		this.permissaoDisciplinaAlt = permissaoDisciplinaAlt;
	}

	public String getPermissaoProfessorVer() {
		return permissaoProfessorVer;
	}

	public void setPermissaoProfessorVer(String permissaoProfessorVer) {
		this.permissaoProfessorVer = permissaoProfessorVer;
	}

	public String getPermissaoProfessorAlt() {
		return permissaoProfessorAlt;
	}

	public void setPermissaoProfessorAlt(String permissaoProfessorAlt) {
		this.permissaoProfessorAlt = permissaoProfessorAlt;
	}

	public String getPermissaoMenuVer() {
		return permissaoMenuVer;
	}

	public void setPermissaoMenuVer(String permissaoMenuVer) {
		this.permissaoMenuVer = permissaoMenuVer;
	}

	public String getPermissaoMenuAlt() {
		return permissaoMenuAlt;
	}

	public void setPermissaoMenuAlt(String permissaoMenuAlt) {
		this.permissaoMenuAlt = permissaoMenuAlt;
	}

	public String getPermissaoNoticiaVer() {
		return permissaoNoticiaVer;
	}

	public void setPermissaoNoticiaVer(String permissaoNoticiaVer) {
		this.permissaoNoticiaVer = permissaoNoticiaVer;
	}

	public String getPermissaoNoticiaAlt() {
		return permissaoNoticiaAlt;
	}

	public void setPermissaoNoticiaAlt(String permissaoNoticiaAlt) {
		this.permissaoNoticiaAlt = permissaoNoticiaAlt;
	}

	public String getPermissaoArtigoVer() {
		return permissaoArtigoVer;
	}

	public void setPermissaoArtigoVer(String permissaoArtigoVer) {
		this.permissaoArtigoVer = permissaoArtigoVer;
	}

	public String getPermissaoArtigoAlt() {
		return permissaoArtigoAlt;
	}

	public void setPermissaoArtigoAlt(String permissaoArtigoAlt) {
		this.permissaoArtigoAlt = permissaoArtigoAlt;
	}

	public String getPermissaoInstitucionalVer() {
		return permissaoInstitucionalVer;
	}

	public void setPermissaoInstitucionalVer(String permissaoInstitucionalVer) {
		this.permissaoInstitucionalVer = permissaoInstitucionalVer;
	}

	public String getPermissaoInstitucionalAlt() {
		return permissaoInstitucionalAlt;
	}

	public void setPermissaoInstitucionalAlt(String permissaoInstitucionalAlt) {
		this.permissaoInstitucionalAlt = permissaoInstitucionalAlt;
	}

	public String getPermissaoVideoVer() {
		return permissaoVideoVer;
	}

	public void setPermissaoVideoVer(String permissaoVideoVer) {
		this.permissaoVideoVer = permissaoVideoVer;
	}

	public String getPermissaoVideoAlt() {
		return permissaoVideoAlt;
	}

	public void setPermissaoVideoAlt(String permissaoVideoAlt) {
		this.permissaoVideoAlt = permissaoVideoAlt;
	}

	public String getPermissaoModuloVer() {
		return permissaoModuloVer;
	}

	public void setPermissaoModuloVer(String permissaoModuloVer) {
		this.permissaoModuloVer = permissaoModuloVer;
	}

	public String getPermissaoModuloAlt() {
		return permissaoModuloAlt;
	}

	public void setPermissaoModuloAlt(String permissaoModuloAlt) {
		this.permissaoModuloAlt = permissaoModuloAlt;
	}

	public String getPermissaoPacoteVer() {
		return permissaoPacoteVer;
	}

	public void setPermissaoPacoteVer(String permissaoPacoteVer) {
		this.permissaoPacoteVer = permissaoPacoteVer;
	}

	public String getPermissaoPacoteAlt() {
		return permissaoPacoteAlt;
	}

	public void setPermissaoPacoteAlt(String permissaoPacoteAlt) {
		this.permissaoPacoteAlt = permissaoPacoteAlt;
	}

	public String getPermissaoProdutoVer() {
		return permissaoProdutoVer;
	}

	public void setPermissaoProdutoVer(String permissaoProdutoVer) {
		this.permissaoProdutoVer = permissaoProdutoVer;
	}

	public String getPermissaoProdutoAlt() {
		return permissaoProdutoAlt;
	}

	public void setPermissaoProdutoAlt(String permissaoProdutoAlt) {
		this.permissaoProdutoAlt = permissaoProdutoAlt;
	}

	public String getPermissaoCupomVer() {
		return permissaoCupomVer;
	}

	public void setPermissaoCupomVer(String permissaoCupomVer) {
		this.permissaoCupomVer = permissaoCupomVer;
	}

	public String getPermissaoCupomAlt() {
		return permissaoCupomAlt;
	}

	public void setPermissaoCupomAlt(String permissaoCupomAlt) {
		this.permissaoCupomAlt = permissaoCupomAlt;
	}

	public String getPermissaoBannerVer() {
		return permissaoBannerVer;
	}

	public void setPermissaoBannerVer(String permissaoBannerVer) {
		this.permissaoBannerVer = permissaoBannerVer;
	}

	public String getPermissaoBannerAlt() {
		return permissaoBannerAlt;
	}

	public void setPermissaoBannerAlt(String permissaoBannerAlt) {
		this.permissaoBannerAlt = permissaoBannerAlt;
	}

	public String getPermissaoDepoimentoVer() {
		return permissaoDepoimentoVer;
	}

	public void setPermissaoDepoimentoVer(String permissaoDepoimentoVer) {
		this.permissaoDepoimentoVer = permissaoDepoimentoVer;
	}

	public String getPermissaoDepoimentoAlt() {
		return permissaoDepoimentoAlt;
	}

	public void setPermissaoDepoimentoAlt(String permissaoDepoimentoAlt) {
		this.permissaoDepoimentoAlt = permissaoDepoimentoAlt;
	}

	public String getPermissaoVideoYoutubeVer() {
		return permissaoVideoYoutubeVer;
	}

	public void setPermissaoVideoYoutubeVer(String permissaoVideoYoutubeVer) {
		this.permissaoVideoYoutubeVer = permissaoVideoYoutubeVer;
	}

	public String getPermissaoVideoYoutubeAlt() {
		return permissaoVideoYoutubeAlt;
	}

	public void setPermissaoVideoYoutubeAlt(String permissaoVideoYoutubeAlt) {
		this.permissaoVideoYoutubeAlt = permissaoVideoYoutubeAlt;
	}

	public String getPermissaoEmailVer() {
		return permissaoEmailVer;
	}

	public void setPermissaoEmailVer(String permissaoEmailVer) {
		this.permissaoEmailVer = permissaoEmailVer;
	}

	public String getPermissaoEmailAlt() {
		return permissaoEmailAlt;
	}

	public void setPermissaoEmailAlt(String permissaoEmailAlt) {
		this.permissaoEmailAlt = permissaoEmailAlt;
	}

	public String getPermissaoMensagemVer() {
		return permissaoMensagemVer;
	}

	public void setPermissaoMensagemVer(String permissaoMensagemVer) {
		this.permissaoMensagemVer = permissaoMensagemVer;
	}

	public String getPermissaoMensagemAlt() {
		return permissaoMensagemAlt;
	}

	public void setPermissaoMensagemAlt(String permissaoMensagemAlt) {
		this.permissaoMensagemAlt = permissaoMensagemAlt;
	}

	public String getPermissaoDepartamentoVer() {
		return permissaoDepartamentoVer;
	}

	public void setPermissaoDepartamentoVer(String permissaoDepartamentoVer) {
		this.permissaoDepartamentoVer = permissaoDepartamentoVer;
	}

	public String getPermissaoDepartamentoAlt() {
		return permissaoDepartamentoAlt;
	}

	public void setPermissaoDepartamentoAlt(String permissaoDepartamentoAlt) {
		this.permissaoDepartamentoAlt = permissaoDepartamentoAlt;
	}

	public String getPermissaoPedidoVer() {
		return permissaoPedidoVer;
	}

	public void setPermissaoPedidoVer(String permissaoPedidoVer) {
		this.permissaoPedidoVer = permissaoPedidoVer;
	}

	public String getPermissaoPedidoAlt() {
		return permissaoPedidoAlt;
	}

	public void setPermissaoPedidoAlt(String permissaoPedidoAlt) {
		this.permissaoPedidoAlt = permissaoPedidoAlt;
	}

	public String getPermissaoAgendaAlt() {
		return permissaoAgendaAlt;
	}

	public void setPermissaoAgendaAlt(String permissaoAgendaAlt) {
		this.permissaoAgendaAlt = permissaoAgendaAlt;
	}

	public String getPermissaoAgendaVer() {
		return permissaoAgendaVer;
	}

	public void setPermissaoAgendaVer(String permissaoAgendaVer) {
		this.permissaoAgendaVer = permissaoAgendaVer;
	}

	public String getPermissaoMaterialApoioVer() {
		return permissaoMaterialApoioVer;
	}

	public void setPermissaoMaterialApoioVer(String permissaoMaterialApoioVer) {
		this.permissaoMaterialApoioVer = permissaoMaterialApoioVer;
	}

	public String getPermissaoMaterialApoioAlt() {
		return permissaoMaterialApoioAlt;
	}

	public void setPermissaoMaterialApoioAlt(String permissaoMaterialApoioAlt) {
		this.permissaoMaterialApoioAlt = permissaoMaterialApoioAlt;
	}
}
