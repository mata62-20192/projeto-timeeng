package model;

import java.util.ArrayList;
import java.util.List;

public class Curso {
	
	private String nome;
	private List<CursoDisciplina> obrigatorias = new ArrayList<>();
	private List<CursoDisciplina> optativas = new ArrayList<>();
	
	public List<CursoDisciplina> getObrigatorias() {
		return obrigatorias;
	}
	public void setObrigatorias(List<CursoDisciplina> obrigatorias) {
		this.obrigatorias = obrigatorias;
	}
	public List<CursoDisciplina> getOptativas() {
		return optativas;
	}
	public void setOptativas(List<CursoDisciplina> optativas) {
		this.optativas = optativas;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
