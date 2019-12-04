package br.ufba.mata62.timeeng.test;

import java.io.IOException;
import java.util.PriorityQueue;

import br.ufba.mata62.timeeng.domain.Aluno;
import br.ufba.mata62.timeeng.domain.ComponenteCurricularCursado;
import br.ufba.mata62.timeeng.domain.EscalonarCrescenteStrategy;
import br.ufba.mata62.timeeng.repository.FileRepository;
import br.ufba.mata62.timeeng.service.AlunoService;
import br.ufba.mata62.timeeng.service.ComponenteCurricularCursadoService;
import br.ufba.mata62.timeeng.service.EscalonarService;
import br.ufba.mata62.timeeng.service.UniversidadeService;
import junit.framework.TestCase;

public class ProjectTest extends TestCase {

	public void testCadastraAlunoComSucesso() {
		readInfosFile();
		String nome = "Maria da Silva";
		String matricula = "123456";
		String cursoCodigo = "ADMINISTRAÇÃO   - SALVADOR";
		AlunoService.cadastrarAluno(nome, matricula, cursoCodigo);
		assertTrue(AlunoService.existeAluno("123456"));
	}
	
	public void testCadastraAlunoDoisComSucesso() {
		readInfosFile();
		String nome = "Luana de Souza";
		String matricula = "654321";
		String cursoCodigo = "ADMINISTRAÇÃO   - SALVADOR";
		AlunoService.cadastrarAluno(nome, matricula, cursoCodigo);
		assertTrue(AlunoService.existeAluno("654321"));
	}
	
	public void testCadastraAlunoSemSucesso() {
		String nome = "Joao da Silva";
		String matricula = "123456";
		String cursoCodigo = "ADMINISTRAÇÃO   - SALVADOR";
		AlunoService.cadastrarAluno(nome, matricula, cursoCodigo);
		assertFalse(AlunoService.existeAlunoByName("Joao da Silva"));
	}
	
	public void testCadastraAlunoCursoInvalido() {
		String nome = "Ana da Silva";
		String matricula = "123457";
		String cursoCodigo = "CURSO FALSO";
		AlunoService.cadastrarAluno(nome, matricula, cursoCodigo);
		assertFalse(AlunoService.existeAlunoByName("Ana da Silva"));
	}
	
	public void testExisteAluno() {
		assertTrue(AlunoService.existeAluno("123456"));
	}
	
	public void testCadastraCompCurricularAprovadoAlunoUm() {
		Aluno aluno = AlunoService.getAlunoByMatricula("123456");
		ComponenteCurricularCursado compo = new ComponenteCurricularCursado(aluno.getCurso().getObrigatorias().get(1));
		compo.setNota("10");
		ComponenteCurricularCursadoService.addAlunoComponente(aluno, compo);
		
		compo = new ComponenteCurricularCursado(aluno.getCurso().getObrigatorias().get(2));
		compo.setNota("5");
		ComponenteCurricularCursadoService.addAlunoComponente(aluno, compo);
		
		compo = new ComponenteCurricularCursado(aluno.getCurso().getObrigatorias().get(3));
		compo.setNota("6");
		ComponenteCurricularCursadoService.addAlunoComponente(aluno, compo);
		assertEquals("7.0", aluno.getCR());
	}
	
	public void testCadastraCompCurricularAprovadoAlunoDois() {
		Aluno aluno = AlunoService.getAlunoByMatricula("654321");
		ComponenteCurricularCursado compo = new ComponenteCurricularCursado(aluno.getCurso().getObrigatorias().get(1));
		compo.setNota("5");
		ComponenteCurricularCursadoService.addAlunoComponente(aluno, compo);
		
		compo = new ComponenteCurricularCursado(aluno.getCurso().getObrigatorias().get(2));
		compo.setNota("5");
		ComponenteCurricularCursadoService.addAlunoComponente(aluno, compo);
		
		compo = new ComponenteCurricularCursado(aluno.getCurso().getObrigatorias().get(3));
		compo.setNota("8");
		ComponenteCurricularCursadoService.addAlunoComponente(aluno, compo);
		assertEquals("6.0", aluno.getCR());
	}
	
	public void testEscalonarDescrescente() {
		 EscalonarService escalonarService = new EscalonarService("ADMINISTRAÇÃO   - SALVADOR", new EscalonarCrescenteStrategy());
	     PriorityQueue<Aluno> alunos = escalonarService.Escalonar();
//	     System.out.println(escalonarService.estrategia);
//	     System.out.println(alunos);
//	     assertEquals("123456", alunos.poll().getNumMatricula());
	}
	

	public void readInfosFile() {
		if (UniversidadeService.getUniversidade() == null) {
			try {
				FileRepository.readInfos();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
