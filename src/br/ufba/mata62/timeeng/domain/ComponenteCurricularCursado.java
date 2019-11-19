package br.ufba.mata62.timeeng.domain;

public class ComponenteCurricularCursado {
	private CursoDisciplina componente;
	private String nota;
	private String conceito;
	
	public ComponenteCurricularCursado(CursoDisciplina componente) {
		super();
		this.componente = componente;
	}

	public ComponenteCurricularCursado() {
		super();
	}

	public CursoDisciplina getComponente() {
		return componente;
	}

	public void setComponente(CursoDisciplina componente) {
		this.componente = componente;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public String getConceito() {
		return conceito;
	}

	public void setConceito(String conceito) {
		this.conceito = conceito;
	}
}
