package br.ufba.mata62.timeeng.controller;

import java.awt.BorderLayout;
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

import br.ufba.mata62.timeeng.domain.Aluno;
import br.ufba.mata62.timeeng.domain.Curso;
import br.ufba.mata62.timeeng.domain.CursoDisciplina;
import br.ufba.mata62.timeeng.service.CursoService;
import br.ufba.mata62.timeeng.service.UniversidadeService;

public class ExibirComponentesCursoController extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExibirComponentesCursoController frame = new ExibirComponentesCursoController();
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
	
	public ExibirComponentesCursoController(Aluno aluno) {
		this();
		Curso curso = CursoService.getCursoByName(aluno.getCurso().getNome());
		
		List<CursoDisciplina> compo = curso.getObrigatorias();
		String[] array = new String[compo.size()];
		 for(int i = 0; i < array.length; i++) {
		     array[i] = compo.get(i).getDisciplina().getNome();
		 }
		 
		JComboBox<String> cb = new JComboBox<String>(array);
		contentPane.add(cb);
		
		JLabel label_1 = new JLabel("");
		contentPane.add(label_1);
		
		
		JButton buttonAddComponente = new JButton("Adicionar");		
		
		buttonAddComponente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					//new ExibirDetalheCurriculoController(cb.getSelectedItem().toString()).setVisible(true);
				CursoDisciplina cursoDis = new CursoDisciplina();
				for(int i = 0; i < array.length; i++) {
				     if(compo.get(i).getDisciplina().getNome()==cb.getSelectedItem().toString()) {
				    	 cursoDis=compo.get(i);
				    	 break;
				     }
				 }				 
					new CadastrarComponenteCurricularController(cursoDis, aluno).setVisible(true);
					setVisible(false);
			}
		});
		contentPane.add(buttonAddComponente);
		
	}
	
	public ExibirComponentesCursoController() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		setContentPane(contentPane);
	}

}
