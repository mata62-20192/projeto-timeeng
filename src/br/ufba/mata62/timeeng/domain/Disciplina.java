package br.ufba.mata62.timeeng.domain;

public class Disciplina {
	
	private String codigo, nome;
	private int cargaHoraria;
	
	public Disciplina() {
		
	}
	public Disciplina(String codigo, String nome, int cargaHoraria) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	

}
