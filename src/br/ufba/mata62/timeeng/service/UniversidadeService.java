package br.ufba.mata62.timeeng.service;

import br.ufba.mata62.timeeng.domain.Universidade;

public class UniversidadeService {
	private static Universidade universidade;
	
	
	public static void setUniversidade (Universidade universidadeParam) {
		universidade = universidadeParam;
	}
	
	public static Universidade getUniversidade() {
		return universidade;
	}
}
