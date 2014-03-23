package br.com.orlandoburli.euvouromper.model.utils;

public final class Dicionario {

	public final class Parametro {
		public static final String TABELA_PARAMETRO = "parametro";

		public final class Colunas {
			public static final String ID_PARAMETRO = "id_parametro";
			public static final String NOME = "nome";
			public static final String VALOR = "valor";
		}
	}

	public final class PerfilAdmin {
		public static final String TABELA_PERFIL_ADMIN = "perfil_admin";

		public final class Colunas {
			public static final String ID_PERFIL = "id_perfil";
			public static final String NOME = "nome";

			public static final String P_PERFIL_VER = "p_perfil_ver";
			public static final String P_PERFIL_ALT = "p_perfil_alt";

			public static final String P_USUARIO_VER = "p_usuario_ver";
			public static final String P_USUARIO_ALT = "p_usuario_alt";

		}
	}

	public final class Usuario {
		public static final String TABELA_USUARIO = "usuario";

		public final class Colunas {
			public static final String ID_USUARIO = "id_usuario";
			public static final String NOME = "nome";
			public static final String LOGIN = "login";
			public static final String EMAIL = "email";
			public static final String SENHA = "senha";
			public static final String ATIVO = "ativo";
			public static final String ID_PERFIL = "id_perfil";
			public static final String PATH_FOTO = "path_foto";
		}
	}

	public final class Disciplina {
		public static final String TABELA_DISCIPLINA = "disciplina";

		public final class Colunas {
			public static final String ID_DISCIPLINA = "id_disciplina";
			public static final String NOME = "nome";
		}
	}

	public final class Professor {
		public static final String TABELA_PROFESSOR = "professor";

		public final class Colunas {
			public static final String ID_PROFESSOR = "id_professor";
			public static final String NOME = "nome";
			public static final String EMAIL = "email";
			public static final String TITULO = "titulo";
		}
	}

}
