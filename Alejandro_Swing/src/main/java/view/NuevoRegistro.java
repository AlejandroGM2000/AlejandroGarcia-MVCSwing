package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.*;
import java.awt.event.*;

public class NuevoRegistro extends JFrame implements ActionListener {
	private JTextField textfield1;
	private JLabel label1;
	private JButton boton1;

	public NuevoRegistro() {
		setLayout(null);
		setTitle("Piezas");
		label1 = new JLabel("Nombre Pieza");
		label1.setBounds(10, 10, 100, 30);
		add(label1);
		textfield1 = new JTextField();
		textfield1.setBounds(120, 10, 150, 20);
		add(textfield1);
		boton1 = new JButton("Aceptar");
		boton1.setBounds(10, 80, 100, 30);
		add(boton1);
		boton1.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Aceptar") {
			InterfazConsola.newPieza = textfield1.getText();
			setTitle(InterfazConsola.newPieza);
		}
	}
}
