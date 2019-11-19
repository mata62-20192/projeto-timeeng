package br.ufba.mata62.timeeng.domain;

import java.util.ArrayList;

public class Aluno {
	private String nome;
	private String numMatricula;
	private String senha;
	private Curso curso;
	private ArrayList<ComponenteCurricularCursado> componentesCursados = new ArrayList<ComponenteCurricularCursado>();
	private String CR;	
	
	public Aluno() {
	}

	public Aluno(String nome, String numMatricula, String senha, Curso curso) {
		super();
		this.nome = nome;
		this.numMatricula = numMatricula;
		this.senha = senha;
		this.curso = curso;
	}

	public Aluno(String nome, String matricula, Curso curso) {
		super();
		this.nome = nome;
		this.numMatricula = matricula;
		this.curso = curso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumMatricula() {
		return numMatricula;
	}

	public void setNumMatricula(String numMatricula) {
		this.numMatricula = numMatricula;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public ArrayList<ComponenteCurricularCursado> getComponentesCursados() {
		return componentesCursados;
	}

	public void setComponentesCursados(ArrayList<ComponenteCurricularCursado> componentesCursados) {
		this.componentesCursados = componentesCursados;
	}
	
	public void addComponenteCurricular(ComponenteCurricularCursado disciplinaCursada) {
		componentesCursados.add(disciplinaCursada);
		this.calcularCR();
	}
	
	public void calcularCR() {
		if(!componentesCursados.isEmpty()) {
			int cont=0;
			double somaNotas=0;
			for(ComponenteCurricularCursado c : componentesCursados) {
				cont++;
				somaNotas+=Double.parseDouble(c.getNota());
			}
			this.setCR(somaNotas/((double)cont));
		}else {
			this.setCR(0.0);;
		}
	}

	public String getCR() {
		return CR;
	}

	private void setCR(Double cR) {
		CR = cR.toString();
	}
	
	

}
