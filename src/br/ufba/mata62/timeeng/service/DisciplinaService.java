package br.ufba.mata62.timeeng.service;

import br.ufba.mata62.timeeng.domain.Disciplina;

public class DisciplinaService {

	public static boolean existeDisciplinaUniversidade (String codigoDisciplina) {
		for (Disciplina a : UniversidadeService.getUniversidade().getDisciplinas()) {
			if (a.getCodigo().equals(codigoDisciplina)) {
				return true;
			}
		}
		return false;
	}
}
