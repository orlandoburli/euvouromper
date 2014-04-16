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

			public static final String P_PARAMETRO_VER = "p_parametro_ver";
			public static final String P_PARAMETRO_ALT = "p_parametro_alt";

			public static final String P_PERFIL_VER = "p_perfil_ver";
			public static final String P_PERFIL_ALT = "p_perfil_alt";

			public static final String P_USUARIO_VER = "p_usuario_ver";
			public static final String P_USUARIO_ALT = "p_usuario_alt";

			public static final String P_DISCIPLINA_VER = "p_disciplina_ver";
			public static final String P_DISCIPLINA_ALT = "p_disciplina_alt";

			public static final String P_PROFESSOR_VER = "p_professor_ver";
			public static final String P_PROFESSOR_ALT = "p_professor_alt";

			public static final String P_MENU_VER = "p_menu_ver";
			public static final String P_MENU_ALT = "p_menu_alt";

			public static final String P_BANNER_VER = "p_banner_ver";
			public static final String P_BANNER_ALT = "p_banner_alt";

			public static final String P_DEPOIMENTO_VER = "p_depoimento_ver";
			public static final String P_DEPOIMENTO_ALT = "p_depoimento_alt";

			public static final String P_VIDEOYOUTUBE_VER = "p_videoyoutube_ver";
			public static final String P_VIDEOYOUTUBE_ALT = "p_videoyoutube_alt";

			public static final String P_NOTICIA_VER = "p_noticia_ver";
			public static final String P_NOTICIA_ALT = "p_noticia_alt";

			public static final String P_ARTIGO_VER = "p_artigo_ver";
			public static final String P_ARTIGO_ALT = "p_artigo_alt";

			public static final String P_INSTITUCIONAL_VER = "p_institucional_ver";
			public static final String P_INSTITUCIONAL_ALT = "p_institucional_alt";

			public static final String P_VIDEO_VER = "p_video_ver";
			public static final String P_VIDEO_ALT = "p_video_alt";

			public static final String P_MODULO_VER = "p_modulo_ver";
			public static final String P_MODULO_ALT = "p_modulo_alt";

			public static final String P_PACOTE_VER = "p_pacote_ver";
			public static final String P_PACOTE_ALT = "p_pacote_alt";

			public static final String P_PRODUTO_VER = "p_produto_ver";
			public static final String P_PRODUTO_ALT = "p_produto_alt";

			public static final String P_CUPOM_VER = "p_cupom_ver";
			public static final String P_CUPOM_ALT = "p_cupom_alt";

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
			public static final String ID_PROFESSOR = Professor.Colunas.ID_PROFESSOR;
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
			public static final String PATH_FOTO = "path_foto";
			public static final String URL = "url";
			public static final String MINI_CURRICULO = "mini_curriculo";
			public static final String CURRICULO = "curriculo";
		}
	}

	public final class Menu {
		public static final String TABELA_MENU = "menu";

		public final class Colunas {
			public static final String ID_MENU = "id_menu";
			public static final String NOME = "nome";
			public static final String URL = "url";
			public static final String ORDEM = "ordem";
			public static final String GRUPO = "grupo";
		}
	}

	public final class Institucional {
		public static final String TABELA_INSTITUCIONAL = "institucional";

		public final class Colunas {
			public static final String ID_INSTITUCIONAL = "id_institucional";
			public static final String TITULO = "titulo";
			public static final String TEXTO = "texto";
			public static final String URL = "url";
			public static final String STATUS = "status";
		}
	}

	public final class Noticia {
		public static final String TABELA_NOTICIA = "noticia";

		public final class Colunas {
			public static final String ID_NOTICIA = "id_noticia";
			public static final String TITULO = "titulo";
			public static final String RESUMO = "resumo";
			public static final String TEXTO = "texto";
			public static final String DATA = "data";
			public static final String AUTOR = "autor";
			public static final String URL = "url";
			public static final String STATUS = "status";
		}
	}

	public final class Artigo {
		public static final String TABELA_ARTIGO = "artigo";

		public final class Colunas {
			public static final String ID_ARTIGO = "id_artigo";
			public static final String TITULO = "titulo";
			public static final String RESUMO = "resumo";
			public static final String TEXTO = "texto";
			public static final String DATA = "data";
			public static final String ID_PROFESSOR = Professor.Colunas.ID_PROFESSOR;
			public static final String URL = "url";
			public static final String STATUS = "status";
		}
	}

	public final class Depoimento {
		public static final String TABELA_DEPOIMENTO = "depoimento";

		public final class Colunas {
			public static final String ID_DEPOIMENTO = "id_depoimento";
			public static final String NOME = "nome";
			public static final String TEXTO = "texto";
			public static final String STATUS = "status";
		}
	}

	public final class VideoYoutube {
		public static final String TABELA_VIDEO_YOUTUBE = "video_youtube";

		public final class Colunas {
			public static final String ID_VIDEO_YOUTUBE = "id_video_youtube";
			public static final String DESCRICAO = "descricao";
			public static final String CHAVE = "chave";
		}
	}

	public final class Banner {
		public static final String TABELA_BANNER = "banner";

		public final class Colunas {
			public static final String ID_BANNER = "id_banner";
			public static final String TITULO = "titulo";
			public static final String SUBTITULO = "subtitulo";
			public static final String URL = "url";
			public static final String ATIVO = "ativo";
			public static final String PATH_IMAGEM = "path_imagem";
			public static final String COR_TITULO = "cor_titulo";
			public static final String COR_SUBTITULO = "cor_subtitulo";
		}
	}

	public final class Video {
		public static final String TABELA_VIDEO = "video";

		public final class Colunas {
			public static final String ID_VIDEO = "id_video";
			public static final String NOME = "nome";
			public static final String BLOCO = "bloco";
			public static final String AULA = "aula";
			public static final String GRATUITO = "gratuito";

			public static final String ID_PROFESSOR = "id_professor";
			public static final String ID_DISCIPLINA = "id_disciplina";
			public static final String PATH_VIDEO = "path_video";
			public static final String HASH = "hash";

			public static final String PATH_FOTO = "path_foto";
		}
	}

	public final class Modulo {
		public static final String TABELA_MODULO = "modulo";

		public final class Colunas {
			public static final String ID_MODULO = "id_modulo";
			public static final String NOME = "nome";
			public static final String DESCRICAO = "descricao";
			public static final String HORAS = "horas";
			public static final String CONTEUDO_PROGRAMATICO = "conteudo_programatico";
		}
	}

	public final class ModuloVideo {
		public static final String TABELA_MODULO_VIDEO = "modulo_video";
		public static final String UK_MODULO_VIDEO = "uk_modulo_video_1";

		public final class Colunas {
			public static final String ID_MODULO_VIDEO = "id_modulo_video";
			public static final String ID_MODULO = "id_modulo";
			public static final String ID_VIDEO = "id_video";
		}
	}

	public final class Pacote {
		public static final String TABELA_PACOTE = "pacote";

		public final class Colunas {
			public static final String ID_PACOTE = "id_pacote";
			public static final String NOME = "nome";
		}
	}

	public final class PacoteModulo {
		public static final String TABELA_PACOTE_MODULO = "pacote_modulo";
		public static final String UK_PACOTE_MODULO = "uk_pacote_modulo_1";

		public final class Colunas {
			public static final String ID_PACOTE_MODULO = "id_pacote_modulo";
			public static final String ID_PACOTE = "id_pacote";
			public static final String ID_MODULO = "id_modulo";
		}
	}

	public final class Produto {
		public static final String TABELA_PRODUTO = "produto";

		public final class Colunas {
			public static final String ID_PRODUTO = "id_produto";
			public static final String NOME = "nome";
			public static final String DESCRICAO = "descricao";
			public static final String TIPO_PRODUTO = "tipo_produto";
			public static final String VALOR = "valor";
			public static final String ID_PACOTE = Pacote.Colunas.ID_PACOTE;
			public static final String ID_MODULO = Modulo.Colunas.ID_MODULO;
			public static final String ATIVO = "ativo";
			public static final String TIPO_VALIDADE = "tipo_validade";
			public static final String DATA_VALIDADE = "data_validade";
			public static final String DIAS_VALIDADE = "dias_validade";
			public static final String RECORRENTE = "recorrente";
			public static final String DIAS_RECORRENCIA = "dias_recorrencia";
			public static final String PATH_FOTO = "path_foto";
		}
	}

	public final class Cliente {
		public static final String TABELA_CLIENTE = "cliente";
		public static final String UK_EMAIL_CLIENTE = "uk_email_cliente";

		public final class Colunas {
			public static final String ID_CLIENTE = "id_cliente";
			public static final String NOME = "nome";
			public static final String EMAIL = "email";
			public static final String FLAG_EMAIL_CONFIRMADO = "flag_email_confirmado";
			public static final String SENHA = "senha";
			public static final String HASH = "hash";

			public static final String CPF = "cpf";
			public static final String CEP = "cep";
			public static final String ENDERECO = "endereco";
			public static final String NUMERO = "numero";
			public static final String BAIRRO = "bairro";
			public static final String COMPLEMENTO = "complemento";
			public static final String UF = "uf";
			public static final String CIDADE = "cidade";
			public static final String FONE1 = "fone1";
			public static final String FONE2 = "fone2";
		}
	}

	public final class CupomDesconto {
		public static final String TABELA_CUPOM_DESCONTO = "cupom_desconto";

		public final class Colunas {
			public static final String ID_CUPOM = "id_cupom";
			public static final String DESCRICAO = "descricao";
			public static final String CHAVE = "chave";
			public static final String ID_PRODUTO_DESTINO = "id_produto_destino";
			public static final String TIPO_DESCONTO = "tipo_desconto";
			public static final String ID_CLIENTE = Cliente.Colunas.ID_CLIENTE;
			public static final String DATA_VALIDADE = "data_validade";
			public static final String VALOR = "valor";
		}
	}

	public final class Pedido {
		public static final String TABELA_PEDIDO = "pedido";

		public final class Colunas {
			public static final String ID_PEDIDO = "id_pedido";
			public static final String ID_CLIENTE = Cliente.Colunas.ID_CLIENTE;
			public static final String STATUS_PEDIDO = "status_pedido";
			public static final String ID_PAGSEGURO = "id_pagseguro";
			public static final String ID_CUPOM = CupomDesconto.Colunas.ID_CUPOM;
			public static final String STATUS_PAGAMENTO_PEDIDO = "status_pagamento_pedido";
			public static final String DATA_HORA_LIBERACAO = "data_hora_liberacao";

			public static final String NOME = Cliente.Colunas.NOME;
			public static final String EMAIL = Cliente.Colunas.EMAIL;
			public static final String CPF = Cliente.Colunas.CPF;
			public static final String CEP = Cliente.Colunas.CEP;
			public static final String ENDERECO = Cliente.Colunas.ENDERECO;
			public static final String NUMERO = Cliente.Colunas.NUMERO;
			public static final String BAIRRO = Cliente.Colunas.BAIRRO;
			public static final String COMPLEMENTO = Cliente.Colunas.COMPLEMENTO;
			public static final String UF = Cliente.Colunas.UF;
			public static final String CIDADE = Cliente.Colunas.CIDADE;
			public static final String FONE1 = Cliente.Colunas.FONE1;
			public static final String FONE2 = Cliente.Colunas.FONE2;

			public static final String VALOR_BRUTO = "valor_bruto";
			public static final String VALOR_DESCONTO = "valor_desconto";
			public static final String VALOR_LIQUIDO = "valor_liquido";
		}
	}

	public final class ItemPedido {
		public static final String TABELA_ITEM_PEDIDO = "item_pedido";

		public final class Colunas {
			public static final String ID_ITEM_PEDIDO = "id_item_pedido";
			public static final String ID_PEDIDO = Pedido.Colunas.ID_PEDIDO;
			public static final String VALOR = "valor";

			public static final String ID_PRODUTO = Produto.Colunas.ID_PRODUTO;
			public static final String NOME = Produto.Colunas.NOME;
			public static final String TIPO_PRODUTO = Produto.Colunas.TIPO_PRODUTO;
			public static final String ID_PACOTE = Pacote.Colunas.ID_PACOTE;
			public static final String ID_MODULO = Modulo.Colunas.ID_MODULO;
			public static final String TIPO_VALIDADE = Produto.Colunas.TIPO_VALIDADE;
			public static final String DATA_VALIDADE = "data_validade";
			public static final String DIAS_VALIDADE = "dias_validade";
			public static final String RECORRENTE = "recorrente";
			public static final String DIAS_RECORRENCIA = "dias_recorrencia";
		}
	}

}
