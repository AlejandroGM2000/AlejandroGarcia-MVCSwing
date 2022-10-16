package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListaResultados extends JFrame implements ActionListener {

	private JTable tabla = null;
	DefaultTableModel modelo = null;
	JScrollPane desplazamiento = null;
	JButton boton1;

	public ListaResultados(ResultSet rs) {
		String[] columnas = { "Codigo", "Nombre" };
		tabla = new JTable();
		modelo = new DefaultTableModel();
		desplazamiento = new JScrollPane(tabla);
		boton1 = new JButton("Aceptar");
		boton1.setBounds(350, 350, 100, 30);
		boton1.addActionListener(this);
		add(boton1);

		// Parametros de la ventana
		this.setTitle("Piezas");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		// Modelo de la tabla
		modelo.setColumnIdentifiers(columnas);

		// Barras de desplazamiento
		desplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		desplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		// Propiedades de la tabla
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tabla.setFillsViewportHeight(true);

		tabla.setModel(modelo);

		// Agrego datos
		this.agregarDatos(modelo, rs);

		// Agrego elementos a la ventana
		this.getContentPane().add(desplazamiento, BorderLayout.NORTH);
		this.pack();
	}
	/*
	 * Método encargado de llenar la variable modelo(defaultTable) con los datos del ResultSet. 
	 */
	public void agregarDatos(DefaultTableModel modelo, ResultSet rs) {
		try {
			while (rs.next()) {
				// Se crea un array que será una de las filas de la tabla.
				Object[] fila = new Object[2]; // Hay dos columnas en la tabla

				// Se rellena cada posición del array con una de las columnas de la tabla en
				// base de datos.
				for (int i = 0; i < 2; i++)
					fila[i] = rs.getObject(i + 1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.

				// Se añade al modelo la fila completa.
				modelo.addRow(fila);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Aceptar") {
			InterfazConsola.selec4 = 1;
		}
	}
}
