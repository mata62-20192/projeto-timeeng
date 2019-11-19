package br.ufba.mata62.timeeng.controller;


import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufba.mata62.timeeng.domain.Curso;
import br.ufba.mata62.timeeng.service.UniversidadeService;

public class ExibirCurriculoCursoController extends JFrame {

	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExibirCurriculoCursoController frame = new ExibirCurriculoCursoController();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ExibirCurriculoCursoController() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblCursoCodigo = new JLabel("Curso");
		contentPane.add(lblCursoCodigo);
		
		 List<Curso> cursos = UniversidadeService.getUniversidade().getCursos();
		
		 String[] array = new String[cursos.size()];
		 for(int i = 0; i < array.length; i++) {
		     array[i] = cursos.get(i).getNome();
		 }
		 
		JComboBox<String> cb = new JComboBox<String>(array);
		contentPane.add(cb);
		
		JLabel label_1 = new JLabel("");
		contentPane.add(label_1);
		
		
		JButton buttonExibirCurriculo = new JButton("Exibir currículo");
		
		
		buttonExibirCurriculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					new ExibirDetalheCurriculoController(cb.getSelectedItem().toString()).setVisible(true);
			}
		});
		contentPane.add(buttonExibirCurriculo);
	}
	

	
	
	
}
