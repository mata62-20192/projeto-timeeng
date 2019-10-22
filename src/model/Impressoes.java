package model;

import java.util.List;

public class Impressoes {
	public void imprimirCurriculo(List<SemestreSugerido> semestreSugerido, List<CursoDisciplina> optativas) {
		int cont=0;
		System.out.println("Disciplinas obrigatorias:");
		for(SemestreSugerido s: semestreSugerido) {
			cont++;
			System.out.println("----"+cont+"º Semestre:");
			for(CursoDisciplinaObrigatoria c: s.getObrigatorias()) {
				System.out.println("- "+c.getDisciplina().getCodigo()+": "+c.getDisciplina().getNome()+" <CH>: "+c.getDisciplina().getCargaHoraria());
			}
			System.out.println();
		}
		
		System.out.println("Disciplinas optativas:");
		for(CursoDisciplina c: optativas) {
			System.out.println("- "+c.getDisciplina().getCodigo()+": "+c.getDisciplina().getNome()+" <CH>: "+c.getDisciplina().getCargaHoraria());
		}
		
	}
}
