package br.ufba.mata62.timeeng.domain;

import java.util.ArrayList;
import java.util.List;

public class Universidade {

	private String nome, sigla;
	private List<Curso> cursos =  new ArrayList<>();
	private List<Disciplina> disciplinas =  new ArrayList<>();
	private List<Aluno> alunos = new ArrayList<Aluno>();	
	
	public Universidade() {
		
	}

	public Universidade(String nome, String sigla, List<Curso> cursos, List<Disciplina> disciplinas,
			List<Aluno> alunos) {
		super();
		this.nome = nome;
		this.sigla = sigla;
		this.cursos = cursos;
		this.disciplinas = disciplinas;
		this.alunos = alunos;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	
}
