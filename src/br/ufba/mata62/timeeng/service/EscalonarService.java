package br.ufba.mata62.timeeng.service;

import java.util.ArrayList;
import java.util.PriorityQueue;

import br.ufba.mata62.timeeng.domain.Aluno;
import br.ufba.mata62.timeeng.domain.EscalonarStrategy;

public class EscalonarService {
	public EscalonarStrategy estrategia;
	public String curso;
	
	
	
	public EscalonarService(String curso, EscalonarStrategy estrategia) {
		super();
		this.curso = curso;
		this.estrategia = estrategia;
	}

	public PriorityQueue<Aluno> Escalonar(){
		//System.out.println("existe");
		return estrategia.Escalonar(curso);
	}

}
