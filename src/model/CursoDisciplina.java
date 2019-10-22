package model;

import java.util.List;

public class CursoDisciplina {

	private Disciplina disciplina;
	private List<Disciplina> preRequisitos;	
	
	
	public CursoDisciplina() {
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
