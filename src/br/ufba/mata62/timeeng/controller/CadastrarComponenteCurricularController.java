package br.ufba.mata62.timeeng.controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufba.mata62.timeeng.domain.Aluno;
import br.ufba.mata62.timeeng.domain.ComponenteCurricularCursado;
import br.ufba.mata62.timeeng.domain.CursoDisciplina;
import br.ufba.mata62.timeeng.service.ComponenteCurricularCursadoService;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarComponenteCurricularController extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNota;
	private JTextField textFieldConceito;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarComponenteCurricularController frame = new CadastrarComponenteCurricularController();
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
	
	public CadastrarComponenteCurricularController(CursoDisciplina cursoDis, Aluno aluno) {
		this();
		ComponenteCurricularCursado componente = new ComponenteCurricularCursado(cursoDis);
		JButton btnNewButtonSalvar = new JButton("Salvar");
		btnNewButtonSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				componente.setConceito(textFieldConceito.getText());
				componente.setNota(textFieldNota.getText());
				ComponenteCurricularCursadoService.addAlunoComponente(aluno, componente);
				setVisible(false);
			}
		});
		
		btnNewButtonSalvar.setBounds(263, 121, 89, 23);
		contentPane.add(btnNewButtonSalvar);
	}
	
	public CadastrarComponenteCurricularController() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNota = new JLabel("Nota");
		lblNota.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		lblNota.setBounds(10, 103, 46, 14);
		contentPane.add(lblNota);
		
		textFieldNota = new JTextField();
		textFieldNota.setBounds(105, 100, 86, 20);
		contentPane.add(textFieldNota);
		textFieldNota.setColumns(10);
		
		JLabel lblConceito = new JLabel("Conceito");
		lblConceito.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		lblConceito.setBounds(10, 155, 68, 14);
		contentPane.add(lblConceito);
		
		textFieldConceito = new JTextField();
		textFieldConceito.setBounds(105, 152, 86, 20);
		contentPane.add(textFieldConceito);
		textFieldConceito.setColumns(10);
		
		
	}
}
