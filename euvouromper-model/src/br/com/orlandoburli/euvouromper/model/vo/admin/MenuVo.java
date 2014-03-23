package br.com.orlandoburli.euvouromper.model.vo.admin;

import java.util.ArrayList;
import java.util.List;

public class MenuVo {

	private String nomeMenu;
	private String tipoMenu;
	private String nomeObjeto;

	private List<MenuVo> subMenus;

	public MenuVo(String nomeMenu, String tipoMenu, String nomeObjeto) {
		this.nomeMenu = nomeMenu;
		this.tipoMenu = tipoMenu;
		this.nomeObjeto = nomeObjeto;
	}
	
	public String getNomeMenu() {
		return nomeMenu;
	}

	public void setNomeMenu(String nomeMenu) {
		this.nomeMenu = nomeMenu;
	}

	public String getTipoMenu() {
		return tipoMenu;
	}

	public void setTipoMenu(String tipoMenu) {
		this.tipoMenu = tipoMenu;
	}

	public String getNomeObjeto() {
		return nomeObjeto;
	}

	public void setNomeObjeto(String nomeObjeto) {
		this.nomeObjeto = nomeObjeto;
	}

	public List<MenuVo> getSubMenus() {
		if (subMenus == null) {
			this.subMenus = new  ArrayList<MenuVo>();
		}
		return subMenus;
	}

	public void setSubMenus(List<MenuVo> subMenus) {
		this.subMenus = subMenus;
	}

}