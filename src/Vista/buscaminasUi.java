package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Control.Principal;

import java.awt.GridLayout;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class buscaminasUi extends JFrame {

	protected JPanel contentPane;
	protected JPanel panelBotones;
	protected JButton boton;
	protected JLabel lblTexto;

	/**
	 * Create the frame.
	 */
	public buscaminasUi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnMenu = new JMenu("Archivo");
		menuBar.add(mnMenu);

		JMenuItem mntmReiniciar = new JMenuItem("Reiniciar");
		mntmReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblTexto.setText("Has reiniciado");
				Principal.main(null);
			}
		});
		mnMenu.add(mntmReiniciar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panelBotones = new JPanel();
		contentPane.add(panelBotones, BorderLayout.CENTER);

		panelBotones.setLayout(new GridLayout(10, 10, 0, 0));

		JLabel lblNewLabel = new JLabel("BUSCAMINAS");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);

		lblTexto = new JLabel("Aqui pongo si ganas o pierdes");
		lblTexto.setFont(new Font("Vivaldi", Font.BOLD, 30));
		lblTexto.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTexto, BorderLayout.SOUTH);

		for (int filas = 0; filas < 10; filas++) {
			for (int columnas = 0; columnas < 10; columnas++) {
				boton = new JButton();
				String nombre = Integer.toString(filas) + Integer.toString(columnas);
				boton.setName(nombre);
				boton.setBackground(new Color(10, 0, 90));
				boton.setBorder(new LineBorder(new Color(0, 0, 0)));
				panelBotones.add(boton);
			}
		}
	}

}
