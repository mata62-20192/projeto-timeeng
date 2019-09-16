package model;

import java.util.List;

public class CursoDisciplina {

	private String naturezaDisciplina;
	private Disciplina disciplina;
	private List<Disciplina> preRequisitos;
	private int semestreSugerido;
	
	
	public int getSemestreSugerido() {
		return semestreSugerido;
	}

	public void setSemestreSugerido(int semestreSugerido) {
		this.semestreSugerido = semestreSugerido;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public String getNaturezaDisciplina() {
		return naturezaDisciplina;
	}

	public void setNaturezaDisciplina(String naturezaDisciplina) {
		this.naturezaDisciplina = naturezaDisciplina;
	}

	public List<Disciplina> getPreRequisitos() {
		return preRequisitos;
	}

	public void setPreRequisitos(List<Disciplina> preRequisitos) {
		this.preRequisitos = preRequisitos;
	}
}
