package br.ufba.mata62.timeeng.controller;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufba.mata62.timeeng.domain.Aluno;
import br.ufba.mata62.timeeng.service.AlunoService;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ListarAlunosController extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarAlunosController frame = new ListarAlunosController();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListarAlunosController() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		criarBotoesDosAlunos();
	}

	private void criarBotoesDosAlunos() {
//		String[] alunos = CursoService.getAlunos();
		List<Aluno> alunos = AlunoService.getAlunos();
		
		
		for (Aluno aluno : alunos) {
			JButton buttonAluno = new JButton(aluno.getNome());
			buttonAluno.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new ExibirAlunoController(aluno).setVisible(true);
				}
			});
			contentPane.add(buttonAluno);
		}
	}
}
