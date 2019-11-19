package br.ufba.mata62.timeeng.controller;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import br.ufba.mata62.timeeng.domain.Curso;
import br.ufba.mata62.timeeng.domain.CursoDisciplina;
import br.ufba.mata62.timeeng.service.CursoService;

public class ExibirDetalheCurriculoController extends JFrame {

	private JPanel contentPane, panel;
	private JScrollPane panelScroll;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExibirDetalheCurriculoController frame = new ExibirDetalheCurriculoController();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ExibirDetalheCurriculoController(String cursoNome) {
		this();
		Curso curso = CursoService.getCursoByName(cursoNome);
		setTitle("Currículo do curso "+curso.getNome());
		JLabel lblNaturezaDisciplina = new JLabel("DISCIPLINAS OBRIGATÓRIAS", JLabel.CENTER);
		lblNaturezaDisciplina.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		
		panel.add(lblNaturezaDisciplina);
		
		for (CursoDisciplina c : curso.getObrigatorias()) {
			JLabel lblNomeDisciplina = new JLabel("Nome: " + c.getDisciplina().getNome());
			panel.add(lblNomeDisciplina);

			JLabel lblCodigoDisciplina = new JLabel("Código: " + c.getDisciplina().getCodigo());
			panel.add(lblCodigoDisciplina);

			JLabel lblCargaHoraria = new JLabel("CH: " + c.getDisciplina().getCargaHoraria());
			panel.add(lblCargaHoraria);
			
			JLabel lblSemestre = new JLabel("SEMESTRE: " + c.getSemestreSugerido());
			panel.add(lblSemestre);
		}
		
		
		lblNaturezaDisciplina = new JLabel("DISCIPLINAS OPTATIVAS", JLabel.CENTER);
		lblNaturezaDisciplina.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		
		panel.add(lblNaturezaDisciplina);
		
		for (CursoDisciplina c : curso.getOptativas()) {
			JLabel lblNomeDisciplina = new JLabel("Nome: " + c.getDisciplina().getNome());
			panel.add(lblNomeDisciplina);

			JLabel lblCodigoDisciplina = new JLabel("Código: " + c.getDisciplina().getCodigo());
			panel.add(lblCodigoDisciplina);

			JLabel lblCargaHoraria = new JLabel("CH: " + c.getDisciplina().getCargaHoraria());
			panel.add(lblCargaHoraria);

		}

	}

	public ExibirDetalheCurriculoController() {
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

	}
}