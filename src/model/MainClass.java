package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("dados.txt");
		Scanner input = new Scanner(file);

		Universidade universidade = new Universidade();

		int numCursos = input.nextInt();
		System.out.println("numcursos:"+numCursos);
		for (int i = 0; i < numCursos; i++) {
		    // Le nome
		    input.skip("\n");
		    String nome = input.nextLine();
		    System.out.println("nome:"+nome);
		    String codigo = input.nextLine();
		    System.out.println("codigo: "+codigo);
		    int numDisciplinas = input.nextInt();
		    
		    Curso curso = new Curso(codigo, nome);
		    int ant=1;
		    
		    for (int j = 0; j < numDisciplinas; j++) {
		        // ADMF52 1 OB 34 20102
		        //input.skip("\n");
		        String nomeDisc = input.nextLine();
		        String codigoDisc = input.next();
		        int semestre = input.nextInt();
		        String natureza = input.next();
		        int ch = input.nextInt();
		        String curriculo = input.next();
		        
		        Disciplina dis = new Disciplina(codigoDisc, nomeDisc, ch);		        
		        SemestreSugerido semestreS = new SemestreSugerido();
		        
		        if(natureza=="OB"){
		        	CursoDisciplinaObrigatoria disciplina = new CursoDisciplinaObrigatoria(dis, semestre);
		        	 if(semestre==ant){
				        	semestreS.adicionarDisciplina(disciplina);
				      }else if(semestre!=0){
				        	ant=semestre;
				        	curso.adicionarSemestre(semestreS);
				        	semestreS = new SemestreSugerido();
				        	semestreS.adicionarDisciplina(disciplina);	
				      }
		        	
		        }else{
		        	CursoDisciplina disciplina = new CursoDisciplina(dis);
		        	curso.adicionarOP(disciplina);
		        }
  
		        
		        universidade.adicionarDisciplina(dis);

		    }
		    universidade.adicionarCurso(curso);
		}

		input.close();	

	}
}
