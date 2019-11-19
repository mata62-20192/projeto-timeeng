package br.ufba.mata62.timeeng.controller;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import br.ufba.mata62.timeeng.domain.Curso;
import br.ufba.mata62.timeeng.service.UniversidadeService;

public class ListarCursosController extends JFrame {

	private JLabel lblNome, lblCodigo, lblQuebraLinha, lblTitulo;
	private JPanel contentPane, panel;
	private JScrollPane panelScroll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarCursosController frame = new ListarCursosController();
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
	public ListarCursosController() {
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		exibirCursos(UniversidadeService.getUniversidade().getCursos());
	}

	public void exibirCursos(List<Curso> cursos) {

		setBounds(100, 100, 520, 520);
        setPreferredSize(new Dimension(500, 500));
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
		
		 panelScroll = new JScrollPane();
	        panelScroll.setPreferredSize(new Dimension(500, 500));

	        panel = new JPanel();
	        panel.setLayout(new GridLayout(0, 1, 10, 10));
	        
	        panelScroll.setViewportView(panel);
	        contentPane.add(panelScroll);
	        
	        lblTitulo = new JLabel("CURSOS", JLabel.CENTER);
	        lblTitulo.setFont(new Font("Lucida Grande", Font.BOLD, 16));
	        panel.add(lblTitulo);
	        

		for (Curso cursoArray : cursos) {
			lblNome = new JLabel("Nome: "+ cursoArray.getNome());
			panel.add(lblNome);
			
			lblCodigo = new JLabel("Código: "+ cursoArray.getCodigo());
			panel.add(lblCodigo);
			
			lblQuebraLinha = new JLabel("-----------------------------------------------------------------------------");
			panel.add(lblQuebraLinha);

		}
	}

}
