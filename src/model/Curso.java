package model;

import java.util.ArrayList;
import java.util.List;

public class Curso {
	
	private String nome;
	private List<SemestreSugerido> semestreSugerido = new ArrayList<>();	
	private List<CursoDisciplina> optativas = new ArrayList<>();

	public List<CursoDisciplina> getOptativas() {
		return optativas;
	}
	private void setOptativas(List<CursoDisciplina> optativas) {
		this.optativas = optativas;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void imprimirCurriculo() {
		Impressoes imp = new Impressoes();
		imp.imprimirCurriculo(this.semestreSugerido, this.optativas);
	}
		
}
