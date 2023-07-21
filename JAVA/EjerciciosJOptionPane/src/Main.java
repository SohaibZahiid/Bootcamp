import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
//		1 --
//		JOptionPane.showMessageDialog(null, "Message", "Title", JOptionPane.ERROR_MESSAGE);
//		JOptionPane.showMessageDialog(null, "Message", "Title", JOptionPane.WARNING_MESSAGE);
//		JOptionPane.showMessageDialog(null, "Message", "Title", JOptionPane.INFORMATION_MESSAGE);
//		JOptionPane.showMessageDialog(null, "Message", "Title", JOptionPane.QUESTION_MESSAGE);

//		2 --
//		JOptionPane.showMessageDialog(null, "El total es:\n 120 € (IVA 10 % no incl.)\n 132 € (con IVA incl.)", "Ticket", JOptionPane.INFORMATION_MESSAGE);

//		3 --
//		String nombre = JOptionPane.showInputDialog("Cual es tu nombre?");
//		JOptionPane.showMessageDialog(null, nombre);

//		4 --
//		String nombre = null;
//        int respuesta = 0;
//
//        do {
//            nombre = JOptionPane.showInputDialog("Cual es tu nombre?");
//            if (nombre == null) {
//                respuesta = JOptionPane.showConfirmDialog(null, "Seguro que quieres salir?", "Salir",
//                        JOptionPane.OK_CANCEL_OPTION);
//                if (respuesta == JOptionPane.OK_OPTION) {
//                    System.exit(0);
//                }
//            } else if (nombre.isEmpty()) {
//                JOptionPane.showMessageDialog(null, "Debes ingresar un nombre válido.", "Error",
//                        JOptionPane.ERROR_MESSAGE);
//            } else {
//                JOptionPane.showMessageDialog(null, nombre, nombre, JOptionPane.INFORMATION_MESSAGE);
//            }
//        } while (nombre == null || nombre.isEmpty());
		
		
		
		
//		5 --
//		int response = Integer.parseInt(JOptionPane.showInputDialog(null, "Queue Operations Menu\n 1.Insert\n 2.Delete\n 3.Display\n 4.Exit\n", "input", JOptionPane.INFORMATION_MESSAGE));
//		System.out.println(response);
//		if(response == 1) {
//			JOptionPane.showMessageDialog(null, "Insert", "Insert", JOptionPane.INFORMATION_MESSAGE);
//		} else if (response == 2) {
//			JOptionPane.showMessageDialog(null, "Delete", "Delete", JOptionPane.ERROR_MESSAGE);
//		} else if (response == 3) {
//			JOptionPane.showMessageDialog(null, "Display", "Display", JOptionPane.INFORMATION_MESSAGE);
//		} else if (response == 4) {
//			JOptionPane.showMessageDialog(null, "Exit", "Exit", JOptionPane.WARNING_MESSAGE);
//		} else {
//			JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.WARNING_MESSAGE);
//		}
//		
		
		
		
//		6 --
//		String[] animales = {"Perro", "Lobo", "Gato"};
//		Object res = JOptionPane.showInputDialog(null, "Cual es tu animal favorito?", "Animal Quiz", JOptionPane.QUESTION_MESSAGE, null, animales, animales[1]);
//		JOptionPane.showMessageDialog(null, res);
		
		
		
//		7 --
//		int res = JOptionPane.showConfirmDialog(null, "Would you like green eggs and ham");
//		JOptionPane.showMessageDialog(null, res);
		
		
		
//		8 --
		ImageIcon Ipizza = new ImageIcon("./pizza.png");
		ImageIcon Icream = new ImageIcon("./ice-cream.png");
		ImageIcon Iburger = new ImageIcon("./hamburger.png");
		
		ArrayList<String> arr = new ArrayList<String>(Arrays.asList("pizza", "burger", "ice cream"));
		
		Random r = new Random();
		String random = arr.get(r.nextInt(arr.size()));
		
		if(random.equals("pizza")) {
			JOptionPane.showConfirmDialog(null, random, "Preguntas sobre comida", 0, 0, Ipizza);
		} else if(random.equals("burger")) {
			JOptionPane.showConfirmDialog(null, random, "Preguntas sobre comida", 0, 0, Iburger);
		} else if(random.equals("ice cream")) {
			JOptionPane.showConfirmDialog(null, random, "Preguntas sobre comida", 0, 0, Icream);
		}
		
		
	}
}
