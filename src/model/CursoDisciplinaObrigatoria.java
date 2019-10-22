package model;

public class CursoDisciplinaObrigatoria extends CursoDisciplina {
	
	private int semestreSugerido;
	
	public CursoDisciplinaObrigatoria() {
		super();
	}

	public CursoDisciplinaObrigatoria(Disciplina disciplina, int semestre) {
		super(disciplina);
		this.semestreSugerido = semestreSugerido;
	}

	public int getSemestreSugerido() {
		return semestreSugerido;
	}

	public void setSemestreSugerido(int semestreSugerido) {
		this.semestreSugerido = semestreSugerido;
	}

}
