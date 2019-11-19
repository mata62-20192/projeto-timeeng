package br.ufba.mata62.timeeng.domain;

import java.util.List;

public class CursoDisciplina {

	private Disciplina disciplina;
	private List<Disciplina> preRequisitos;	
	private int semestreSugerido;
	
	public int getSemestreSugerido() {
		return semestreSugerido;
	}

	public void setSemestreSugerido(int semestreSugerido) {
		this.semestreSugerido = semestreSugerido;
	}

	public CursoDisciplina() {
	}
	
	public CursoDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	public CursoDisciplina(Disciplina disciplina, int semestre, List<Disciplina> preRequisitos){
		super();
		this.disciplina = disciplina;
		this.preRequisitos = preRequisitos;
		this.semestreSugerido = semestre;
	}
			

	public CursoDisciplina(Disciplina disciplina, List<Disciplina> preRequisitos) {
		super();
		this.disciplina = disciplina;
		this.preRequisitos = preRequisitos;
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public List<Disciplina> getPreRequisitos() {
		return preRequisitos;
	}

	public void setPreRequisitos(List<Disciplina> preRequisitos) {
		this.preRequisitos = preRequisitos;
	}
}
