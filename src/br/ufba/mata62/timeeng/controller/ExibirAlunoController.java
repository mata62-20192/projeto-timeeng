package br.ufba.mata62.timeeng.controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufba.mata62.timeeng.domain.Aluno;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExibirAlunoController extends JFrame {
	private JLabel lblNome, lblCurso, lblMatricula, lblCR;
	private JPanel contentPane;
	private JButton btnAddComponentes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExibirAlunoController frame = new ExibirAlunoController();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ExibirAlunoController(Aluno aluno) {
		this();
		lblNome.setText(aluno.getNome());
		lblCurso.setText(aluno.getCurso().getNome());
		lblMatricula.setText(aluno.getNumMatricula());
		lblCR.setText(aluno.getCR());
		

		btnAddComponentes = new JButton("AddComponenteCurricular");
		btnAddComponentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ExibirComponentesCursoController(aluno).setVisible(true);
			}
		});
		contentPane.add(btnAddComponentes);
	}
	
	/**
	 * Create the frame.
	 */
	public ExibirAlunoController() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNomeDoAluno = new JLabel("NOME:");
		lblNomeDoAluno.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		contentPane.add(lblNomeDoAluno);
		
		lblNome = new JLabel("XYZ");
		contentPane.add(lblNome);
		
		JLabel lblCursoDoAluno = new JLabel("CURSO:");
		lblCursoDoAluno.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		contentPane.add(lblCursoDoAluno);
		
		lblCurso = new JLabel("XYZ");
		contentPane.add(lblCurso);
		

		JLabel lblMatriculaDoAluno = new JLabel("MATRÍCULA:");
		lblMatriculaDoAluno.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		contentPane.add(lblMatriculaDoAluno);
		
		lblMatricula = new JLabel("XYZ");
		contentPane.add(lblMatricula);
		
		JLabel lblCRDoAluno = new JLabel("CR:");
		lblCRDoAluno.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		contentPane.add(lblCRDoAluno);
		
		lblCR = new JLabel("XYZ");
		contentPane.add(lblCR);
		
	}

}
