package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

	public final String ini = "Inicializacion Base de Datos";
	public final String ins = "Insertar paquetes de datos";
	public final String borrar = "Borrar tabla";
	public final String acceso = "Acceder a las tablas";
	public final String fin = "Salir del programa";

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == ini) {
			InterfazConsola.selec = 1;
		} else if (e.getActionCommand() == ins) {
			InterfazConsola.selec = 2;
		} else if (e.getActionCommand() == borrar) {
			InterfazConsola.selec = 3;
		} else if (e.getActionCommand() == acceso) {
			InterfazConsola.selec = 4;
		} else {
			InterfazConsola.selec = 5;
		}
	}
}
