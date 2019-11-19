package br.ufba.mata62.timeeng.domain;

import java.util.ArrayList;
import java.util.List;


public class Curso {
	
	private String nome;
	private String codigo;
//	private List<SemestreSugerido> semestreSugerido = new ArrayList<>();	
	private List<CursoDisciplina> optativas = new ArrayList<>();
	private List<CursoDisciplina> obrigatorias = new ArrayList<>();
	
	public List<CursoDisciplina> getObrigatorias() {
		return obrigatorias;
	}

	public void setObrigatorias(List<CursoDisciplina> obrigatorias) {
		this.obrigatorias = obrigatorias;
	}

	public Curso(String codigo, String nome){
		this.nome = nome;
		this.setCodigo(codigo);		
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
	
	public void adicionarOP(CursoDisciplina dis) {
		optativas.add(dis);
	}
	
	public void adicionarOB(CursoDisciplina dis) {
		obrigatorias.add(dis);
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
		
}
