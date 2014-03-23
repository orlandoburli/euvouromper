package br.com.orlandoburli.euvouromper.model.be.admin;

import java.util.ArrayList;
import java.util.List;

import br.com.orlandoburli.euvouromper.model.dao.admin.UsuarioDao;
import br.com.orlandoburli.euvouromper.model.domains.SimNao;
import br.com.orlandoburli.euvouromper.model.vo.admin.MenuVo;
import br.com.orlandoburli.euvouromper.model.vo.admin.UsuarioVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;

public class UsuarioBe extends BaseBe<UsuarioVo, UsuarioDao> {

	public UsuarioBe(DAOManager manager) {
		super(manager);
	}

	public UsuarioVo login(String login, String senha) throws LoginInvalidoException {
		if (login == null || login.trim().equals("")) {
			throw new LoginInvalidoException("Usuário / Senha inválidos!");
		}

		if (senha == null || senha.trim().equals("")) {
			throw new LoginInvalidoException("Usuário / Senha inválidos!");
		}

		UsuarioVo filter = new UsuarioVo();
		filter.setLogin(login);

		try {
			List<UsuarioVo> list = getList(filter);

			if (list.size() > 0) {
				UsuarioVo usuario = list.get(0);
				if (usuario.getLogin().equalsIgnoreCase(login) && usuario.getSenha().equals(senha)) {
					return usuario;
				}
			}

		} catch (ListException e) {
			Log.error(e.getMessage());
		}

		throw new LoginInvalidoException("Usuário / Senha inválidos!");
	}

	public List<MenuVo> buildMenuUsuario(UsuarioVo usuario) {
		List<MenuVo> list = new ArrayList<MenuVo>();

		if (usuario.getPerfil() == null) {
			return null;
		}

		MenuVo admin = new MenuVo("Admin", "", "");

		list.add(admin);

		if (usuario.getPerfil().getPermissaoPerfilVer().equals(SimNao.SIM)) {
			admin.getSubMenus().add(new MenuVo("Perfis", "", "perfiladminconsulta.admin"));
		}

		if (usuario.getPerfil().getPermissaoUsuarioVer().equals(SimNao.SIM)) {
			admin.getSubMenus().add(new MenuVo("Usuários", "", "usuarioconsulta.admin"));
		}

		return list;
	}

}
