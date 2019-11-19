package br.ufba.mata62.timeeng.domain;

import java.util.ArrayList;
import java.util.PriorityQueue;

public interface EscalonarStrategy {
	
	PriorityQueue<Aluno> Escalonar(String curso);

}
