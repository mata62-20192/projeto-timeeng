package br.ufba.mata62.timeeng.service;

import java.util.List;

import br.ufba.mata62.timeeng.domain.Curso;

public class CursoService {

	public static Curso getCurso(String cursoCodigo) {
		List<Curso> cursos = UniversidadeService.getUniversidade().getCursos();
		Curso curso = null;

		for (Curso cursoArray : cursos) {
			if (cursoArray.getCodigo().equals(cursoCodigo)) {
				curso = cursoArray;
				break;
			}
		}

		return curso;
	}
	
	public static Curso getCursoByName(String cursoNome) {
		List<Curso> cursos = UniversidadeService.getUniversidade().getCursos();
		Curso curso = null;

		for (Curso cursoArray : cursos) {
			if (cursoArray.getNome().equals(cursoNome)) {
				curso = cursoArray;
				break;
			}
		}

		return curso;
	}

	public static boolean existeCurso(String cursoCodigo) {

		try {
			Integer.parseInt(cursoCodigo);
		} catch (Exception e) {
			return false;
		}
		
		List<Curso> cursos = UniversidadeService.getUniversidade().getCursos();
		for (Curso cursoArray : cursos) {
			if (cursoArray.getCodigo().equals(cursoCodigo)) {
				return true;
			}
		}
		return false;
	}

}
