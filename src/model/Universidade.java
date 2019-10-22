package model;

import java.util.ArrayList;
import java.util.List;

public class Universidade {

	private String nome, sigla;
	private List<Curso> cursos =  new ArrayList<>();
	private List<Disciplina> disciplinas =  new ArrayList<>();
	private List<Aluno> alunos = new ArrayList<Aluno>();	
	
	public Universidade() {
		
	}

	public Universidade(String nome, String sigla, List<Curso> cursos, List<Disciplina> disciplinas,
			List<Aluno> alunos) {
		super();
		this.nome = nome;
		this.sigla = sigla;
		this.cursos = cursos;
		this.disciplinas = disciplinas;
		this.alunos = alunos;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	private void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	private void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	private void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	private void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	private void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public void adicionarCurso(Curso curso) {
		boolean flag=true;
		
		for(Curso c: cursos) {
			if (c.getNome().equals(curso.getNome())){
				flag=false;
				break;
			}
		}
		
		if(flag) {
			cursos.add(curso);
		}else {
			System.out.println("Curso já existente!");
		}
	}
	
	public void removerCurso(String nomeCurso) {
		boolean flag=false;
		int index=0;
		for(Curso c: cursos) {
			if (c.getNome().equals(nomeCurso)){
				flag=true;
				break;
			}
			index++;
		}
		
		if(flag) {
			cursos.remove(index);
		}else {
			System.out.println("Curso não existente!");
		}
	}
	
	public void adicionarDisciplina(Disciplina disciplina) {
		boolean flag=true;
		
		for(Disciplina d: disciplinas) {
			if (d.getCodigo().equals(disciplina.getCodigo())){
				flag=false;
				break;
			}
		}
		
		if(flag) {
			disciplinas.add(disciplina);
		}else {
			System.out.println("Disciplina já existente!");
		}
	}
	
	public void removerDisciplina(String codigo) {
		boolean flag=false;
		int index=0;
		for(Disciplina d: disciplinas) {
			if (d.getCodigo().equals(codigo)){
				flag=true;
				break;
			}
			index++;
		}
		
		if(flag) {
			disciplinas.remove(index);
		}else {
			System.out.println("Disciplina não existente!");
		}
	}
	
	public void adicionarAluno(Aluno aluno) {
		boolean flag=true;
		for(Aluno a: alunos) {
			if(a.getNumMatricula().equals(aluno.getNumMatricula())) {
				flag=false;
				break;
			}
		}
		if(flag) {
			alunos.add(aluno);
		}else {
			System.out.println("Aluno já existente!");
		}
	}
}
