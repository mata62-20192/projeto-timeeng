package br.ufba.mata62.timeeng.domain;

import java.awt.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import br.ufba.mata62.timeeng.service.UniversidadeService;

public class EscalonarDecrescenteStrategy implements EscalonarStrategy {

	public EscalonarDecrescenteStrategy() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public PriorityQueue<Aluno> Escalonar(String curso) {
		ArrayList<Aluno> alunosGeral = (ArrayList<Aluno>) UniversidadeService.getUniversidade().getAlunos();
		PriorityQueue<Aluno> alunosCurso = new PriorityQueue<Aluno>(1,new ComparadorAluno());
		for(Aluno a : alunosGeral) {
			System.out.println("rodou");
			if(a.getCurso().getNome().equals(curso)) {
				alunosCurso.add(a);
			}
		}
		
		return alunosCurso;
	}

}

class ComparadorAluno implements Comparator<Aluno>{ 
    
    // Overriding compare()method of Comparator  
                // for descending order of cgpa 
    public int compare(Aluno a1, Aluno a2) { 
        if (Double.parseDouble(a1.getCR()) < Double.parseDouble(a2.getCR())) 
            return 1; 
        else if (Double.parseDouble(a1.getCR()) > Double.parseDouble(a2.getCR())) 
            return -1; 
                        return 0; 
        } 
} 
