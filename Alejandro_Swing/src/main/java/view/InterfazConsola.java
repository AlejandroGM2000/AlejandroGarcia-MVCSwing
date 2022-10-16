package view;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;

public class InterfazConsola extends JFrame {
	
	//Definicion nombre tablas

	public final String NamePiezas = "Piezas";
	public final String NameProv = "Proveedores";
	public final String NameSum = "Suministros";
	
	//Constantes estructura de botones
	
	final static boolean shouldFill = true;
	final static boolean shouldWeightX = true;
	final static boolean RIGHT_TO_LEFT = false;
	
	//Definicion del texto de los botones

	public final String ini = "Inicializacion Base de Datos";
	public final String ins = "Insertar paquetes de datos";
	public final String borrar = "Borrar tabla";
	public final String acceso = "Acceder a las tablas";
	public final String fin = "Salir del programa";

	public final String addRegister = "Nuevo registro";
	public final String Consultar = "Consultar por ID o nombre";
	public final String listar = "Listar tabla";
	public final String modi = "Modificar tabla";
	public final String borraregistro = "Borrar registro";
	public final String fintabla = "Salir";

	public final String CodigoSelec = "Codigo";
	public final String NombreSelec = "Nombre";
	
	//Declaracion de variables estaticas que actuan como puente entre listener y métodos.

	public static int selec;
	public static int selec2;
	public static int selec3;
	public static int selec4;
	public static String newPieza;
	public static String resultPieza;
	public static int selec5;

	/*Método encargado de crear JFrame, añadir componentes(botones).
	 * Retorna un Jframe. Se corresponde con la pantalla de botones de selección general(primera).	
	*/
	private JFrame createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("Gestione su base de datos");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set up the content pane.
		addComponentsToPane(frame.getContentPane());

		// Display the window.
		frame.pack();
		frame.setSize(600, 500);
		frame.setResizable(false);
		frame.setVisible(false);
		return (frame);
	}
	
	/*Método encargado de crear JFrame, añadir componentes(botones).
	 * Retorna un Jframe. Se corresponde con la pantalla de botones de selección en la tabla Piezas(segunda).	
	*/
	
	private JFrame createAndShowGUIPiezas() {
		// Create and set up the window.
		JFrame frame = new JFrame("Gestione  su tabla de piezas");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set up the content pane.
		addComponentsToPanePiezas(frame.getContentPane());

		// Display the window.
		frame.pack();
		frame.setSize(600, 500);
		frame.setResizable(false);
		frame.setVisible(false);
		return (frame);
	}
	
	/*Método encargado de crear JFrame, añadir componentes(botones).
	 * Retorna un Jframe. Se corresponde con la pantalla de botones para escoger si realizar una consulta 
	 * por id o nombre	
	*/
	
	
	private JFrame createAndShowGUIConsulta() {
		// Create and set up the window.
		JFrame frame = new JFrame("Consulte tabla de piezas");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set up the content pane.
		addComponentsToPaneConsultaPiezas(frame.getContentPane());

		// Display the window.
		frame.pack();
		frame.setSize(600, 500);
		frame.setResizable(false);
		frame.setVisible(false);
		return (frame);
	}

	/*Método encargado de crear JFrame, añadir componentes(botones).
	 * Retorna un frame. Se corresponde con la pantalla de botones para escoger cual de las tres tablas borrar
	 * (suministros,proveedores y piezas). 
	*/
	private JFrame createAndShowGUIBorra() {
		// Create and set up the window.
		JFrame frame = new JFrame("Borrar tablas");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set up the content pane.
		addComponentsToPaneBorrarTablas(frame.getContentPane());

		// Display the window.
		frame.pack();
		frame.setSize(600, 500);
		frame.setResizable(false);
		frame.setVisible(false);
		return (frame);
	}
	
	/*
	 *Método en el cual se preparan los bottones. Se establece formato, texto y se añaden los ActionListener
	 *a los correspondientes botones. Se corresponde con la ventana del menu general de seleccion(primero). 
	 */
	public void addComponentsToPane(Container pane) {

		ButtonListener listener = new ButtonListener();

		if (RIGHT_TO_LEFT) {
			pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		}

		JButton button;
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		if (shouldFill) {
			// natural height, maximum width
			c.fill = GridBagConstraints.HORIZONTAL;
		}

		if (shouldWeightX) {
			c.weightx = 0.5;
		}
		button = new JButton(ini);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40; // make this component tall
		c.weightx = 1.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 0;
		button.addActionListener(listener);
		pane.add(button, c);

		button = new JButton(ins);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40; // make this component tall
		c.weightx = 0.0;
		c.gridwidth = 40;
		c.gridx = 0;
		c.gridy = 1;
		button.addActionListener(listener);
		pane.add(button, c);

		button = new JButton(borrar);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40; // make this component tall
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 2;
		button.addActionListener(listener);
		pane.add(button, c);

		button = new JButton(acceso);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40; // make this component tall
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 3;
		button.addActionListener(listener);
		pane.add(button, c);

		button = new JButton(fin);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40; // make this component tall
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 4;
		button.addActionListener(listener);
		pane.add(button, c);

	}
	/*
	 *Método en el cual se preparan los bottones. Se establece formato, texto y se añaden los ActionListener
	 *a los correspondientes botones. Se corresponde con la ventana del menu especifico de la tabla piezas.
	 */
	public void addComponentsToPanePiezas(Container pane) {

		ButtonListenerPiezas listener = new ButtonListenerPiezas();

		if (RIGHT_TO_LEFT) {
			pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		}

		JButton button;
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		if (shouldFill) {
			// natural height, maximum width
			c.fill = GridBagConstraints.HORIZONTAL;
		}

		if (shouldWeightX) {
			c.weightx = 0.5;
		}
		button = new JButton(addRegister);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40; // make this component tall
		c.weightx = 1.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 0;
		button.addActionListener(listener);
		pane.add(button, c);

		button = new JButton(Consultar);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40; // make this component tall
		c.weightx = 0.0;
		c.gridwidth = 40;
		c.gridx = 0;
		c.gridy = 1;
		button.addActionListener(listener);
		pane.add(button, c);

		button = new JButton(listar);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40; // make this component tall
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 2;
		button.addActionListener(listener);
		pane.add(button, c);

		button = new JButton(modi);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40; // make this component tall
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 3;
		button.addActionListener(listener);
		pane.add(button, c);

		button = new JButton(borraregistro);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40; // make this component tall
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 4;
		button.addActionListener(listener);
		pane.add(button, c);

		button = new JButton(fintabla);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40; // make this component tall
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 5;
		button.addActionListener(listener);
		pane.add(button, c);

	}
	/*
	 *Método en el cual se preparan los botones. Se establece formato, texto y se añaden los ActionListener
	 *a los correspondientes botones. Se corresponde con la ventana para escoger si realizar una consulta por ID o nombre. 
	 */
	public void addComponentsToPaneConsultaPiezas(Container pane) {

		IdNombreListener listener = new IdNombreListener();

		if (RIGHT_TO_LEFT) {
			pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		}

		JButton button;
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		if (shouldFill) {
			// natural height, maximum width
			c.fill = GridBagConstraints.HORIZONTAL;
		}

		if (shouldWeightX) {
			c.weightx = 0.5;
		}
		button = new JButton(CodigoSelec);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40; // make this component tall
		c.weightx = 1.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 0;
		button.addActionListener(listener);
		pane.add(button, c);

		button = new JButton(NombreSelec);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40; // make this component tall
		c.weightx = 0.0;
		c.gridwidth = 40;
		c.gridx = 0;
		c.gridy = 1;
		button.addActionListener(listener);
		pane.add(button, c);

	}
	/*
	 *Método en el cual se preparan los botones. Se establece formato, texto y se añaden los ActionListener
	 *a los correspondientes botones. Se corresponde con la ventana para escoger la tabla a borrar. 
	 */
	public void addComponentsToPaneBorrarTablas(Container pane) {

		BorraListener listener = new BorraListener();

		if (RIGHT_TO_LEFT) {
			pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		}

		JButton button;
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		if (shouldFill) {
			// natural height, maximum width
			c.fill = GridBagConstraints.HORIZONTAL;
		}

		if (shouldWeightX) {
			c.weightx = 0.5;
		}
		button = new JButton(NamePiezas);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40; // make this component tall
		c.weightx = 1.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 0;
		button.addActionListener(listener);
		pane.add(button, c);

		button = new JButton(NameProv);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40; // make this component tall
		c.weightx = 0.0;
		c.gridwidth = 40;
		c.gridx = 0;
		c.gridy = 1;
		button.addActionListener(listener);
		pane.add(button, c);

		button = new JButton(NameSum);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40; // make this component tall
		c.weightx = 0.0;
		c.gridwidth = 40;
		c.gridx = 0;
		c.gridy = 2;
		button.addActionListener(listener);
		pane.add(button, c);

	}
/*
 * Método encargado de gestionar la selección del usuario en el menu general.
 * Mientras el usuario no pulse ningun boton, se mantiene un bucle, mostrando dicha pantalla.
 * En el caso de producirse una pulsación, el correspondiente actionListener producira una variacion
 * en el valor de la variable global selec. El metodo retornará el numero(1-6) correspondiente a la
 * seleccion.
 */
	public int menu() {
		int n = 0;
		selec = -1;
		JFrame frame = createAndShowGUI();
		while (n <= 0) {
			frame.setVisible(true);
			if (selec > 0) {
				n = selec;
			}
		}
		frame.setVisible(false);
		return (n);
	}
	
	/*
	 * Método encargado de gestionar la selección del usuario en el menu específico de tabla(añadir registro, consulta...)
	 * Mientras el usuario no pulse ningun boton, se mantiene un bucle, mostrando dicha pantalla.
	 * En el caso de producirse una pulsación, el correspondiente actionListener producira una variacion
	 * en el valor de la variable global selec2. El metodo retornará el numero correspondiente a la
	 * seleccion.
	 */
	
	public int menuGestionTablas() {
		int n = 0;
		selec2 = -1;
		JFrame frame = createAndShowGUIPiezas();
		
		while (n <= 0) {
			frame.setVisible(true);
			if (selec2 > 0) {
				n = selec2;
			}
		}
		frame.setVisible(false);
		return (n);
	}

	/*
	 * Método encargado de gestionar la selección de la tabla a eliminar
	 * Mientras el usuario no pulse ningun boton, se mantiene un bucle, mostrando dicha pantalla.
	 * En el caso de producirse una pulsación, el correspondiente actionListener producira una variacion
	 * en el valor de la variable global selec5. El metodo retornará el numero correspondiente a la
	 * seleccion.
	 */

	public int menuBorraTabla() {
		int n = 0;
		selec5 = -1;
		JFrame frame = createAndShowGUIBorra();
		while (n <= 0) {
			frame.setVisible(true);
			if (selec5 > 0) {
				n = selec5;
			}
		}
		frame.setVisible(false);
		return (n);
	}
	
	//Mensajes de control múltiples
	public void aviso() {
		JOptionPane.showMessageDialog(null, "\nBase/Tabla de datos no creada");
	}

	public void avisoMenu() {
		JOptionPane.showMessageDialog(null, "\nDebe introducir valores enteros en el rango indicado");
	}

	public void avisoTabla() {
		JOptionPane.showMessageDialog(null, "\nEsta tabla no esta disponible");
	}

	public void creacionDatabase() {
		JOptionPane.showMessageDialog(null, "\n-Abierta base de datos - Ok");
	}

	public void creacionTabla() {
		JOptionPane.showMessageDialog(null, "\n-Creada tabla - Ok");
	}

	public void borrarTablaOk() {
		JOptionPane.showMessageDialog(null, "\n-Borrar tabla contacto - Ok");
	}

	public void borrarTablaNoOk() {
		JOptionPane.showMessageDialog(null, "\nDebe mantener la estructura relacional");
	}

	public void insercionOk() {
		JOptionPane.showMessageDialog(null, "\n-Añadir registros a la tabla - Ok");
	}

	public void insercionnoOK() {
		JOptionPane.showMessageDialog(null, "\nSe ha producido un error en la insercion");
	}

	public void error_lecturaEntero() {
		JOptionPane.showMessageDialog(null, "\nDebe introducir un numero entero");
	}

	public void error_sqlDefecto() {
		JOptionPane.showMessageDialog(null, "\nSe ha producido un fallo SQL");
	}
	
	/*
	 * Método encargado de gestionar la selección del usuario en el menu encargado de especificar si la
	 * consulta se realiza por id o nombre.
	 * Mientras el usuario no pulse ningun boton, se mantiene un bucle, mostrando dicha pantalla.
	 * En el caso de producirse una pulsación, el correspondiente actionListener producira una variacion
	 * en el valor de la variable global selec3. El metodo retornará el numero correspondiente a la
	 * seleccion.
	 */

	public int SeleccionePiezasIdName() {
		int n = -1;
		selec3 = -1;
		JFrame frame = createAndShowGUIConsulta();

		while (n <= -1) {
			frame.setVisible(true);
			if (selec3 >= 0) {
				n = selec3;
			}
		}
		frame.setVisible(false);
		return (n);
	}

/*
 * Método encargado de realizar las lecturas de los parámetros introducidos por teclado por el usuario.
 * Se controla que el valor leído no sea nulo. Si el valor no es nulo y se pulsa el boton aceptar, el mensaje 
 * desaparece. Cabe destacar que se usa la variable global newPieza para almacenar el contenido del JText. Este contenido
 * es retornado por el metodo.
 */
	public String lecturaStringPieza() {
		String PiezaLocal = null;
		NuevoRegistro r = new NuevoRegistro();
		r.setBounds(0, 0, 350, 170);
		r.setResizable(false);
		r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		while (newPieza == null) {
			r.setVisible(true);

			if (newPieza != null) {
				PiezaLocal = newPieza;
				r.setVisible(false);
			}
		}
		newPieza = null;
		return (PiezaLocal);
	}
//Mensajes de control multiples. 
	public void consultaVacia() {
		JOptionPane.showMessageDialog(null, "\nLa consulta esta vacia");
	}

	public void valorDefecto() {
		JOptionPane.showMessageDialog(null, "\nSe establece el valor 0");
	}
	
	public void borraRegistro() {
		JOptionPane.showMessageDialog(null, "\nRegistro borrado");
	}
	public void modificacion() {
		JOptionPane.showMessageDialog(null, "\nModificacion realizada con exito");
	}
/*
 * Método en el cual se traspasan los resultados de un ResultSet a un JTable y se muestra por pantalla
 * Se muestra por pantalla el contenido hasta que el usuario pulse el boton aceptar.
 */
	public void mostrarConsultaPiezas(ResultSet rs) {
		ListaResultados lr = new ListaResultados(rs);
		lr.setLocationRelativeTo(null);

		int n = 0;
		selec4 = -1;

		while (n <= 0) {
			lr.setVisible(true);
			if (selec4 > 0) {
				n = selec4;
			}
		}

		lr.setVisible(false);
	}
	
	public void nuevoNombrePieza() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "\nIntroduzca el nuevo nombre de la pieza");
	}
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * Métodos no aplicables a piezas o bien no tienen sentido con una interfaz gráfica. 
	 */
	
	
	public void avisoDelete() {
		System.out.println("\nSi desea borrar este proveedor/pieza, elimine antes el correspondiente Suministro");
	}
	
	public int lecturaInt() {
		int myint = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un numero entero");
		myint = sc.nextInt();
		return (myint);
	}

	public void mostrarConsultaProveedores(ResultSet rs) {
		try {
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			error_sqlDefecto();
		}
	}

	public void mostrarConsultaSuministros(ResultSet rs) {
		try {
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			error_sqlDefecto();
		}
	}

	
	
	public int modificaProveedor() {
		System.out.println("\n Desea realizar la modificacion por nombre o ID?");
		System.out.println("Introduzca");
		System.out.println("0-Busqueda por nombre");
		System.out.println("1-Busqueda por codigo\n");
		return (lecturaInt());

	}

	public void modificaSuministro() {
		System.out.println("\n Modificacion del precio");

	}

	public void prosigaModificacion() {
		System.out.println("\nRealize la modificacion que desee");
	}

	public void precio() {
		System.out.println("\nIntroduzca el nuevo precio");

	}

	public void nuevoCodigoProv() {
		System.out.println("\nIntroduzca el nuevo codigo de proveedor");
	}

	public void nuevoNombreProv() {
		System.out.println("\nIntroduzca el nuevo nombre de proveedor");

	}
	public int lecturaNumeroEntero() {
		int n = 0;
		Scanner sc8 = new Scanner(System.in);
		n = sc8.nextInt();
		return (n);
	}
	
	public String menuTabla() {
		String tab = "";
		System.out.println("Introduzca el nombre de la tabla");
		tab = lecturaCadena();
		return (tab);
	}
	
	public String lecturaCadena() {
		String tab = "";
		Scanner sc7 = new Scanner(System.in);
		tab = sc7.nextLine();
		return (tab);
	}
	public int SeleccioneProvIdName() {
		System.out.println("\nDesea realizar la busqueda por ID o nombre?");
		System.out.println("Introduzca");
		System.out.println("0-Busqueda por nombre");
		System.out.println("1-Busqueda por codigo\n");
		return (lecturaInt());
	}

	public int SeleccioneSumIdName() {
		System.out.println("\nDesea realizar la busqueda por ID de pieza o ID proveedor?");
		System.out.println("Introduzca");
		System.out.println("0-Busqueda por ID pieza");
		System.out.println("1-Busqueda por ID proveedor\n");
		return (lecturaInt());
	}

	public String lecturaString() {
		String lectura = "";
		System.out.println("Introduzca un nombre");
		lectura = lecturaCadena();
		return (lectura);
	}
}
