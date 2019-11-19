package br.ufba.mata62.timeeng.service;

import br.ufba.mata62.timeeng.domain.Aluno;
import br.ufba.mata62.timeeng.domain.ComponenteCurricularCursado;

public class ComponenteCurricularCursadoService {
	public static void addAlunoComponente(Aluno aluno, ComponenteCurricularCursado compo) {
		aluno.addComponenteCurricular(compo);
		
	}
	

}
