package br.ufba.mata62.timeeng.controller;

import java.awt.EventQueue;

import javax.swing.JFrame;

import br.ufba.mata62.timeeng.repository.FileRepository;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainController {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileRepository.readInfos();
					MainController window = new MainController();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainController() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnListarCursos = new JButton("Listar Cursos");
		btnListarCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ListarCursosController().setVisible(true);
			}
		});
		frame.getContentPane().add(btnListarCursos);
		
		JButton btnCadastrarAluno = new JButton("Cadastrar Aluno");
		btnCadastrarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CadastrarAlunoController().setVisible(true);
			}
		});
		frame.getContentPane().add(btnCadastrarAluno);
		
		JButton btnNewButton = new JButton("Listar Alunos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ListarAlunosController().setVisible(true);
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnExibirCurrculo = new JButton("Exibir Currículo");
		btnExibirCurrculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ExibirCurriculoCursoController().setVisible(true);
			}
		});
		frame.getContentPane().add(btnExibirCurrculo);
		
		JButton btnExibirEscalonamento = new JButton("Exibir Escalonamento");
		frame.getContentPane().add(btnExibirEscalonamento);
	}

}
