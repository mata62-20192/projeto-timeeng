package model;

public class MainClass {

	public static void main(String[] args) {
		
		Disciplina disciplina = criarDisciplina("Engenharia de Software II", "MATA63", 68);
		Universidade universidade = criarUniversidade("Universidade Federal da Bahia", "UFBA");
		
		Curso si = criarCurso("Sistemas de Informação");
		Curso lc = criarCurso("Licenciatura em Computação");
		Curso cc = criarCurso("Ciência da Computação");
		
		CursoDisciplina cursoDisciplinaSI = criarCursoDisciplina(disciplina, "OB", 5);
		CursoDisciplina cursoDisciplinaCC = criarCursoDisciplina(disciplina, "OB", 6);
		CursoDisciplina cursoDisciplinaLC = criarCursoDisciplina(disciplina, "OP");
		
		lc.getOptativas().add(cursoDisciplinaLC);
		cc.getObrigatorias().add(cursoDisciplinaCC);
		si.getObrigatorias().add(cursoDisciplinaSI);
		
		universidade.getCursos().add(si);
		universidade.getCursos().add(lc);
		universidade.getCursos().add(cc);
		
		imprimeInformacoes(universidade);

	}
	
	private static void imprimeInformacoes(Universidade universidade) {
		System.out.println(universidade.getNome() +" - "+ universidade.getSigla());
		for (Curso curso : universidade.getCursos()) {
			System.out.println("\t"+curso.getNome());
			for (CursoDisciplina obrigatoria : curso.getObrigatorias()) {
				System.out.println("\t\tOBRIGATÓRIAS:");
				imprimeInformacoesDisciplina(obrigatoria);
			}
			for (CursoDisciplina optativa : curso.getOptativas()) {
				System.out.println("\t\tOPTATIVAS:");
				imprimeInformacoesDisciplina(optativa);
			}
		}
	}
	
	private static void imprimeInformacoesDisciplina(CursoDisciplina disciplina) {
		System.out.println("\t\t\tNOME: "+disciplina.getDisciplina().getNome());
		System.out.println("\t\t\tCÓDIGO: "+disciplina.getDisciplina().getCodigo());
		System.out.println("\t\t\tCARGA HORÁRIA: "+disciplina.getDisciplina().getCargaHoraria()+"hrs");
		System.out.println("\t\t\tNATUREZA: "+disciplina.getNaturezaDisciplina());
		System.out.println("\t\t\tSEMESTRE SUGERIDO: "+disciplina.getSemestreSugerido());
	}

	public static Universidade criarUniversidade (String nome, String sigla) {
		Universidade universidade = new Universidade();
		universidade.setNome(nome);
		universidade.setSigla(sigla);
		return universidade;
	}
	
	public static Disciplina criarDisciplina (String nome, String codigo, int cargaHoraria) {
		Disciplina disciplina = new Disciplina();
		disciplina.setNome("Engenharia de Software II");
		disciplina.setCodigo("MATA63");
		disciplina.setCargaHoraria(68);
		return disciplina;
	}
	
	public static Curso criarCurso (String nome) {
		Curso curso = new Curso();
		curso.setNome(nome);
		return curso;
	}

	public static CursoDisciplina criarCursoDisciplina (Disciplina disciplina, String natureza, int semestre) {
		CursoDisciplina cursoDisciplina = new CursoDisciplina();
		cursoDisciplina.setDisciplina(disciplina);
		cursoDisciplina.setNaturezaDisciplina(natureza);
		cursoDisciplina.setSemestreSugerido(semestre);
		return cursoDisciplina;
		
	}
	
	public static CursoDisciplina criarCursoDisciplina (Disciplina disciplina, String natureza) {
		CursoDisciplina cursoDisciplina = new CursoDisciplina();
		cursoDisciplina.setDisciplina(disciplina);
		cursoDisciplina.setNaturezaDisciplina(natureza);
		return cursoDisciplina;
		
	}

}
