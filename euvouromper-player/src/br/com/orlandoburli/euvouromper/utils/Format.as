package br.com.orlandoburli.euvouromper.utils {
	/**
	 * @author orlandoburli
	 */
	// classe Static Para Formatar as Mask
	public class Format {
		// var genericas
		private static var ponto : RegExp = /\./g;
		private static var hifen : RegExp = /\-/g;
		private static var barra : RegExp = /\//g;
		// var cpf
		private static var dig3 : RegExp = /^\d{3}$/;
		private static var dig9 : RegExp = /^\d{3}.\d{3}.\d{3}$/;
		// var cnpj
		private static var cnpj : RegExp = /^\d{2}.\d{3}.\d{3}\/\d{4}-\d{2}$/;
		// var return cpf
		public static var returnMaskCPF : RegExp = /^\d{2}.\d{3}.\d{3}\/\d{3}$/;

		// ******************************************* //
		// **	Format Mask CPF						** //
		// ******************************************* //
		public static function CPF(txt : String) : String {
			// não é necessario colocar a mascara!
			var retorno : String = "";
			
			if (txt.length < 11) {
				return txt;
			}
			
			retorno = txt.substr(0, 3) + "." + txt.substr(4, 3) + "." + txt.substr(7, 3) + "-" + txt.substr(9, 2);
			
			return retorno;
		}

		// ******************************************* //
		// **	Format Mask CNPJ					** //
		// ******************************************* //
		public static function CNPJ(txt : String) : void {
			var str : String = "";

			str = txt.replace(ponto, "");
			// remove pontos
			str = str.replace(hifen, "");
			// remove hifen

			var doisDigitosPonto : String = str.substr(0, 2);
			// copia 2 digitos
			var tresDigitosPonto : String = str.substr(2, 3);
			// copia 3 digitos
			var tresDigitosBarra : String = str.substr(5, 3);
			// copia 3 digitos
			var quatDigitosTraco : String = str.substr(8, 4);
			// copia 4 digitos
			var doisDigitosFim : String = str.substr(12, 2);
			// copia 2 digitos

			// novo cnpj
			var newCNPJ : String = doisDigitosPonto + "." + tresDigitosPonto + "." + tresDigitosBarra + "/" + quatDigitosTraco + "-" + doisDigitosFim;

			if ( cnpj.test(newCNPJ) ) {
				txt = newCNPJ;
			}

			posicionaCursorFinal(txt);
		}

		// ******************************************* //
		// **	Return Mask CPF						** //
		// ******************************************* //
		// ** Exemplo.: 01.622.347/996
		public static function returnCPF(txt : String) : void {
			if ( returnMaskCPF.test(txt) ) {
				var str : String = "";
				str = txt.replace(ponto, "");
				// remove pontos
				str = str.replace(barra, "");
				// remove barra

				var tresDigitosPonto0 : String = str.substr(0, 3);
				// copia 3 digitos
				var tresDigitosPonto3 : String = str.substr(3, 3);
				// copia 3 digitos
				var tresDigitosTraco6 : String = str.substr(6, 3);
				// copia 3 digitos
				var doisDigitosTraco9 : String = str.substr(9, 2);
				// copia 2 digitos

				// novo cnpj
				var newCPF : String = tresDigitosPonto0 + "." + tresDigitosPonto3 + "." + tresDigitosTraco6 + "-" + doisDigitosTraco9;

				txt = newCPF;
			}

			posicionaCursorFinal(txt);
		}

		// posiciona o cursor no final
		private static function posicionaCursorFinal(txt : String) : void {
			// /txt.selectRange(txt.length + 1, txt.length + 1);
		}
	}
}