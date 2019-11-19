package br.ufba.mata62.timeeng.repository;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import br.ufba.mata62.timeeng.domain.Curso;
import br.ufba.mata62.timeeng.domain.CursoDisciplina;
import br.ufba.mata62.timeeng.domain.Disciplina;
import br.ufba.mata62.timeeng.domain.Universidade;
import br.ufba.mata62.timeeng.service.CursoService;
import br.ufba.mata62.timeeng.service.DisciplinaService;
import br.ufba.mata62.timeeng.service.UniversidadeService;

public class FileRepository {

	public static void readInfos() throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("src/dados.txt")));

		Universidade universidade = new Universidade();
		universidade.setNome("Universidade Federal da Bahia");
		universidade.setSigla("UFBA");
		UniversidadeService.setUniversidade(universidade);

		int numCursos = Integer.parseInt(input.readLine());

		for (int i = 0; i < numCursos; i++) {
			// Leitura das infos do curso
			String nome = input.readLine();
			String codigo = input.readLine();
			int numDisciplinas = Integer.parseInt(input.readLine());

			Curso curso = new Curso(codigo, nome);

			for (int j = 0; j < numDisciplinas; j++) {
				// Tratamento para ler uma linha no formato "ADMF56 1 OB 34 20102" e dividi-los
				// em um array com cada info em uma posição
				String nomeDisc = input.readLine();
				String line = input.readLine();
				String[] lineArray = line.split(" ");

				// Percorrendo array e separando as informações em cada atributo
				String codigoDisc = lineArray[0];
				int semestre = Integer.parseInt(lineArray[1]);
				String natureza = lineArray[2];
				int ch = Integer.parseInt(lineArray[3]);
				
				Disciplina dis = new Disciplina(codigoDisc, nomeDisc, ch);

				if (!DisciplinaService.existeDisciplinaUniversidade(codigoDisc)) {
					// Se a disciplina não estiver relacionada à faculdade, adicionamos ela. Se estiver, não faz nada
					UniversidadeService.getUniversidade().getDisciplinas().add(dis);
				}

				if (natureza.equals("OB")) {
					// Se a discplina for obrigatória para aquele curso, usamos o metodo adicionarOB
					// para popular o Array de matérias OB
					CursoDisciplina disciplina = new CursoDisciplina(dis, semestre, null);
					curso.adicionarOB(disciplina);
				} else {
					// Se a discplina for optativa para aquele curso, usamos o metodo adicionarOP
					// para popular o Array de matérias OP
					CursoDisciplina disciplina = new CursoDisciplina(dis, null);
					curso.adicionarOP(disciplina);
				}

			}
			
			if (!CursoService.existeCurso(curso.getCodigo())) {
				// Se o curso não estiver relacionado à faculdade, adicionamos ele. Se estiver, não faz nada
				UniversidadeService.getUniversidade().getCursos().add(curso);
			}
			
		}

		input.close();

	}
}
