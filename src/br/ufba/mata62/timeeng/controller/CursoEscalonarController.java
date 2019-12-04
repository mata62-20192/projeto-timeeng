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
import br.ufba.mata62.timeeng.domain.EscalonarCrescenteStrategy;
import br.ufba.mata62.timeeng.domain.EscalonarDecrescenteStrategy;
import br.ufba.mata62.timeeng.service.UniversidadeService;

public class CursoEscalonarController extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CursoEscalonarController frame = new CursoEscalonarController();
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
	public CursoEscalonarController() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblCursoCodigo = new JLabel("Curso a Escalonar:");
		contentPane.add(lblCursoCodigo);
		
		 List<Curso> cursos = UniversidadeService.getUniversidade().getCursos();
		
		 String[] array = new String[cursos.size()];
		 for(int i = 0; i < array.length; i++) {
		     array[i] = cursos.get(i).getNome();
		 }
		 
		JComboBox<String> cb = new JComboBox<String>(array);
		contentPane.add(cb);
		
		JButton buttonExibirEscalonamentoDecrescente = new JButton("CR Decrescente");				
		buttonExibirEscalonamentoDecrescente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					//new ExibirDetalheCurriculoController(cb.getSelectedItem().toString()).setVisible(true);
					new ExibirEscalonamentoController(cb.getSelectedItem().toString(), new EscalonarDecrescenteStrategy()).setVisible(true);
			}
		});
		contentPane.add(buttonExibirEscalonamentoDecrescente);
		
		JButton buttonExibirEscalonamentoCrescente = new JButton("CR Crescente");			
		buttonExibirEscalonamentoCrescente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					//new ExibirDetalheCurriculoController(cb.getSelectedItem().toString()).setVisible(true);
				new ExibirEscalonamentoController(cb.getSelectedItem().toString(), new EscalonarCrescenteStrategy()).setVisible(true);
			}
		});
		contentPane.add(buttonExibirEscalonamentoCrescente);
	}

}
