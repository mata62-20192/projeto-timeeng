package br.ufba.mata62.timeeng.controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.PriorityQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import br.ufba.mata62.timeeng.domain.Aluno;
import br.ufba.mata62.timeeng.domain.Curso;
import br.ufba.mata62.timeeng.domain.EscalonarStrategy;
import br.ufba.mata62.timeeng.service.EscalonarService;

public class ExibirEscalonamentoController extends JFrame {

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
					ExibirEscalonamentoController frame = new ExibirEscalonamentoController();
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
	
	public ExibirEscalonamentoController(String curso, EscalonarStrategy strategy) {
		this();
		panelScroll = new JScrollPane();
        panelScroll.setPreferredSize(new Dimension(500, 500));

        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 10, 10));
        
        panelScroll.setViewportView(panel);
        contentPane.add(panelScroll);
        
        lblTitulo = new JLabel("Alunos", JLabel.CENTER);
        lblTitulo.setFont(new Font("Lucida Grande", Font.BOLD, 16));
        panel.add(lblTitulo);
        
        EscalonarService escalonarService = new EscalonarService(curso, strategy);
        PriorityQueue<Aluno> alunos = escalonarService.Escalonar();
        
        while (!alunos.isEmpty()) {
        	System.out.println("deu ruim?");
        	Aluno alunoArray = alunos.poll();
        	lblNome = new JLabel("Nome: "+ alunoArray.getNome());
        	panel.add(lblNome);
		
        	lblCodigo = new JLabel("Matricula: "+alunoArray.getNumMatricula());
        	panel.add(lblCodigo);
        	
        	lblCodigo = new JLabel("Curso: "+alunoArray.getCurso().getNome());
        	panel.add(lblCodigo);
		
        	lblQuebraLinha = new JLabel("-----------------------------------------------------------------------------");
        	panel.add(lblQuebraLinha);

        }
		
	}
	
	public ExibirEscalonamentoController() {
		setBounds(100, 100, 520, 520);
        setPreferredSize(new Dimension(500, 500));
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
		
		 
	}

}
