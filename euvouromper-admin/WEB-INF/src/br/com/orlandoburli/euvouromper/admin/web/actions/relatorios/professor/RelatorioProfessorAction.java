package br.com.orlandoburli.euvouromper.admin.web.actions.relatorios.professor;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import br.com.orlandoburli.euvouromper.model.vo.admin.UsuarioVo;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.utils.Utils;
import br.com.orlandoburli.framework.core.vo.DomainVo;
import br.com.orlandoburli.framework.core.web.BaseAction;

@SuppressWarnings("deprecation")
public class RelatorioProfessorAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private Integer mes;
	private Integer ano;
	private UsuarioVo usuario;

	public void execute() {
		getRequest().setAttribute("titulo", "Relatório de Faturamento Professor");
		getRequest().setAttribute("subtitulo", "Relatório de Faturamento dos Professores");
		getRequest().setAttribute("submenu", "Relatórios");
		getRequest().setAttribute("menuAtivo", "Faturamento Professor");

		List<DomainVo> listMeses = new ArrayList<DomainVo>();

		listMeses.add(new DomainVo("1", "Janeiro"));
		listMeses.add(new DomainVo("2", "Fevereiro"));
		listMeses.add(new DomainVo("3", "Março"));
		listMeses.add(new DomainVo("4", "Abril"));
		listMeses.add(new DomainVo("5", "Maio"));
		listMeses.add(new DomainVo("6", "Junho"));
		listMeses.add(new DomainVo("7", "Julho"));
		listMeses.add(new DomainVo("8", "Agosto"));
		listMeses.add(new DomainVo("9", "Setembro"));
		listMeses.add(new DomainVo("10", "Outubro"));
		listMeses.add(new DomainVo("11", "Novembro"));
		listMeses.add(new DomainVo("12", "Dezembro"));

		Calendar hoje = Calendar.getInstance();

		int anoCorrente = hoje.get(Calendar.YEAR);

		List<DomainVo> listAnos = new ArrayList<DomainVo>();

		for (int i = 2014; i <= anoCorrente; i++) {
			listAnos.add(new DomainVo(Integer.toString(i), Integer.toString(i)));
		}

		getRequest().setAttribute("meses", listMeses);
		getRequest().setAttribute("anos", listAnos);

		forward("web/pages/relatorios/professor/relatorioprofessor.jsp");
	}

	public void view() {
		Map<String, Object> parameters = new HashMap<String, Object>();

		Calendar dataInicial = Utils.toCalendar("01/" + Utils.fillString(mes, "0", 2, 1) + "/" + ano);
		Calendar dataFinal = (Calendar) dataInicial.clone();
		dataFinal.set(Calendar.DAY_OF_MONTH, dataFinal.getMaximum(Calendar.DAY_OF_MONTH));

		parameters.put("DataInicial", new java.sql.Date(dataInicial.getTime().getTime()));
		parameters.put("DataFinal", new java.sql.Date(dataFinal.getTime().getTime()));
		parameters.put("idProfessor", usuario.getIdProfessor());
		parameters.put("SUBREPORT_DIR", getContext().getRealPath("web/reports/professor/") + "/");

		SimpleDateFormat sdf2 = new SimpleDateFormat("MMMM/yyyy");
		parameters.put("referencia", sdf2.format(dataInicial.getTime()));

		DAOManager manager = DAOManager.getDAOManager();
		try {
			@SuppressWarnings("rawtypes")
			JRAbstractExporter saida = null;
			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			// JasperReport relatorio = (JasperReport)
			// JRLoader.loadObject(context.getRealPath(getJasperFileName()));
			JasperReport relatorio = (JasperReport) JRLoader.loadObject(new FileInputStream(getContext().getRealPath("web/reports/professor/relatorio_professor.jasper")));

			JasperPrint impressao = new JasperPrint();

			// doParameter(parameters);
			impressao = JasperFillManager.fillReport(relatorio, parameters, manager.getConnection());

			saida = new JRPdfExporter(); // O padrao e PDF

			saida.setParameter(JRExporterParameter.CHARACTER_ENCODING, "UTF-8");
			saida.setParameter(JRExporterParameter.JASPER_PRINT, impressao);
			saida.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);

			saida.exportReport();

			byte[] bytes = baos.toByteArray();
			getResponse().setContentLength(bytes.length);
			// if (getTipoSaida().equalsIgnoreCase(Constants.Saida.SAIDA_PDF)) {
			// response.setContentType("application/pdf");
			// } else if
			// (getTipoSaida().equalsIgnoreCase(Constants.Saida.SAIDA_XLS)) {
			// response.setContentType("application/vnd.ms-excel");
			// }

			getResponse().setContentType("application/pdf");

			ServletOutputStream ouputStream = getResponse().getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();

		} catch (JRException e) {
			Log.critical(e);
		} catch (IOException e) {
			Log.critical(e);
		} finally {
			manager.commit();
		}
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public UsuarioVo getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioVo usuario) {
		this.usuario = usuario;
	}

}
