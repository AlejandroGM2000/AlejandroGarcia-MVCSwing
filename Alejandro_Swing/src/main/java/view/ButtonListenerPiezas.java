package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListenerPiezas implements ActionListener {
	public final String addRegister = "Nuevo registro";
	public final String Consultar = "Consultar por ID o nombre";
	public final String listar = "Listar tabla";
	public final String modi = "Modificar tabla";
	public final String borraregistro = "Borrar registro";
	public final String fintabla = "Salir";

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == addRegister) {
			InterfazConsola.selec2 = 1;
		} else if (e.getActionCommand() == Consultar) {
			InterfazConsola.selec2 = 2;
		} else if (e.getActionCommand() == listar) {
			InterfazConsola.selec2 = 3;
		} else if (e.getActionCommand() == modi) {
			InterfazConsola.selec2 = 4;
		} else if (e.getActionCommand() == borraregistro) {
			InterfazConsola.selec2 = 5;
		} else {
			InterfazConsola.selec2 = 6;

		}
	}
}
