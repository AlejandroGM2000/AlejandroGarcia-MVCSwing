package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorraListener implements ActionListener {
	public final String NamePiezas = "Piezas";
	public final String NameProv = "Proveedores";
	public final String NameSum = "Suministros";

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == NamePiezas) {
			InterfazConsola.selec5 = 1;
		} else if (e.getActionCommand() == NameProv) {
			InterfazConsola.selec5 = 2;
		} else {
			InterfazConsola.selec5 = 3;
		}

	}
}
