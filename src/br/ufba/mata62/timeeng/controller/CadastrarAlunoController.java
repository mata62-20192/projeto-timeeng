package br.ufba.mata62.timeeng.controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufba.mata62.timeeng.domain.Curso;
import br.ufba.mata62.timeeng.service.AlunoService;
import br.ufba.mata62.timeeng.service.UniversidadeService;

import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class CadastrarAlunoController extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textMatricula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarAlunoController frame = new CadastrarAlunoController();
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
	public CadastrarAlunoController() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNome = new JLabel("Nome");
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblMatrcula = new JLabel("Matrícula");
		contentPane.add(lblMatrcula);
		
		textMatricula = new JTextField();
		contentPane.add(textMatricula);
		textMatricula.setColumns(10);
		
		JLabel lblCurso = new JLabel("Curso");
		contentPane.add(lblCurso);
		
		 List<Curso> cursos = UniversidadeService.getUniversidade().getCursos();
			
		 String[] array = new String[cursos.size()];
		 for(int i = 0; i < array.length; i++) {
		     array[i] = cursos.get(i).getNome();
		 }
		 
		JComboBox<String> cb = new JComboBox<String>(array);
		contentPane.add(cb);
		
		JLabel label_1 = new JLabel("");
		contentPane.add(label_1);
		
		JButton btnSalvar = new JButton("Salvar");
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textNome.getText();
				String matricula = textMatricula.getText();
				String curso = cb.getSelectedItem().toString();
				
				if (nome.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O nome não pode ser vazio.");
				} else if (matricula.isEmpty()) {
					JOptionPane.showMessageDialog(null, "A matrícula não pode ser vazia.");
				} else if (AlunoService.existeAluno(matricula)) {
					JOptionPane.showMessageDialog(null, "A matrícula já está vinculada a um aluno.");
				} 					
				else {
					setVisible(false);
					AlunoService.cadastrarAluno(nome, matricula, curso);
				}
			}
		});
		contentPane.add(btnSalvar);
		
		JLabel label_2 = new JLabel("");
		contentPane.add(label_2);
	}

}
