package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IdNombreListener implements ActionListener {
	public final String CodigoSelec = "Codigo";
	public final String NombreSelec = "Nombre";

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == CodigoSelec) {
			InterfazConsola.selec3 = 1;
		} else {
			InterfazConsola.selec3 = 0;
		}
	}
}
