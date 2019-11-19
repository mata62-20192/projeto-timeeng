package br.ufba.mata62.timeeng.service;

import java.util.ArrayList;
import java.util.List;

import br.ufba.mata62.timeeng.domain.Aluno;
import br.ufba.mata62.timeeng.domain.Curso;

public class AlunoService {

	private static List<Aluno> alunos = new ArrayList<>();

	public static List<Aluno> getAlunos() {
		return alunos;
	}

	public static void cadastrarAluno(String nome, String matricula, String cursoCodigo) {
			Curso curso = CursoService.getCursoByName(cursoCodigo);
			Aluno aluno = new Aluno(nome, matricula, curso);
			alunos.add(aluno);
	}
	
	public static boolean existeAluno (String matricula) {
		for (Aluno a : alunos) {
			if (a.getNumMatricula().equals(matricula)) {
				return true;
			}
		}
		return false;
	}
	
}
