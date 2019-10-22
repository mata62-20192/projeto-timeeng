package model;

public class Aluno {
	private String nome;
	private String numMatricula;
	private String senha;
	private Curso curso;
	
	
	public Aluno() {
	}

	public Aluno(String nome, String numMatricula, String senha, Curso curso) {
		super();
		this.nome = nome;
		this.numMatricula = numMatricula;
		this.senha = senha;
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
	
	

}
