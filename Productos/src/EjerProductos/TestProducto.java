package EjerProductos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Nuria Rodr�guez �lvarez
 * @since 28/03/2022
 * @version 1.0
 * 
 */

/**
 * Esta clase contiene diferentes m�todos est�ticos que permitir�n que funcione
 * una aplicaci�n
 */

public class TestProducto {
	/**
	 * M�todo main que podr�a lanzar una excepci�n. En �l se crea un arrayLIst de
	 * productos y se llamar� a tres m�todos
	 * 
	 * @param args Argumentos
	 * @throws ClassNotFoundException Excepci�n de clase no encontrada
	 * @throws FileNotFoundException  Excepci�n de archivo no encontrado
	 * @throws IOException  Excepci�n IO
	 */
	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException {
		ArrayList<Productos> lista = new ArrayList<>();
		cargarProductos(lista);
		visualizarProductos(lista);
		menu(lista);
	}

	/**
	 * M�todo men� que se le pasa como par�metro un arrayList. Este m�todo genera un
	 * men� de 5 opciones y el usuario podr� interactuar con �l.
	 * 
	 * @throws ClassNotFoundException Excepci�n de clase no encontrada
	 * @throws FileNotFoundException  Excepci�n de archivo no encontrado
	 * @throws IOException  Excepci�n IO
	 * @param lista ArrayList de Productos
	 */
	public static void menu(ArrayList<Productos> lista)
			throws ClassNotFoundException, FileNotFoundException, IOException {

		Scanner teclado = new Scanner(System.in);
		int opcion;
		do {
			System.out.println();
			System.out.println("--------MEN�--------");
			System.out.println("1-Grabar productos en un fichero");
			System.out.println("2-A�adir productos");
			System.out.println("3-Calcular importe total");
			System.out.println("4-Eliminar productos");
			System.out.println("5-Finalizar");
			System.out.print("Introducir opcion: ");
			opcion = teclado.nextInt();
			//si la opcion es menor que 1 o mayor de 5 se producir� un error. 
			while ((opcion < 1) || (opcion > 5)) {
				System.out.println("Error en opci�n");
				System.out.print("Introducir opci�n: ");
				opcion = teclado.nextInt();
			}
			//men� de opciones
			switch (opcion) {
			case 1:
				grabarProductos(lista);
				System.out.println("Fichero grabado");
				break;
			case 2:
				a�adirNuevosProductos(lista);
				break;
			case 3:
				calcularImporteTotal(lista);
				visualizarProductos(lista);

				break;
			case 4:
				eliminarProductos(lista);
				visualizarProductos(lista);
				break;
			}
		} while (opcion != 5);

	}

	/**
	 * M�todo cargarProductos al que se le pasa un ArrayList de la clase Productos.
	 * En �l a�adimos al array nuevos objetos de las clases Perecedero y
	 * NoPerecedero.
	 * @param lista ArrayList de Productos
	 */
	public static void cargarProductos(ArrayList<Productos> lista) {

		lista.add(new NoPerecedero("LataAtun", "LT", 2.34, "Latas"));
		lista.add(new NoPerecedero("Sopa Vegetal", "LT", 2.34, "Latas"));
		lista.add(new NoPerecedero("Sopa Vegetal", "SP", 1.24, "Sobres"));
		lista.add(new NoPerecedero("PastaII", "PT", 4.34, "Embasado"));
		lista.add(new Perecedero("Lubina", "LB", 16.34, 2));
		lista.add(new Perecedero("Tomates", "TA", 11.44, 3));
		lista.add(new Perecedero("Naranjas", "NJ", 6.34, 1));
		lista.add(new Perecedero("Tomates", "TM", 3.55, 4));

	}

	/**
	 * M�todo visualizarProductos al que se le pasa un ArrayList de la clase
	 * Productos. Dicho m�todo consiste en visualizar todos los productos, para ello
	 * llamamos al m�todo toString que hemos creado anteriormente en la clase
	 * Productos.
	 * @param lista ArrayList de Productos
	 */
	public static void visualizarProductos(ArrayList<Productos> lista) {
		System.out.println(lista.toString());

	}

	/**
	 * M�todo calcularImporteTotal al que se le pasa un ArrayList de la clase
	 * Productos por par�metro. El m�todo consistir� en calcular el precio del
	 * producto dependiendo de si pertenece a la clase Perecedero o NoPerecedero.
	 * @param lista ArrayList de Productos
	 */
	public static void calcularImporteTotal(ArrayList<Productos> lista) {
		Scanner sc = new Scanner(System.in);
		double importe = 0;
		//bucle for each que recorre la lista de Productos
		for (Productos aux : lista) {
			System.out.println("Producto: " + aux.getNombre());
			System.out.println("Introduce la cantidad vendida");
			int cantidad = sc.nextInt();
			//si es NoPerecedero se llamar� al m�todo correspondiente de dicha clase
			if (aux instanceof NoPerecedero) {
				importe = ((NoPerecedero) aux).calcular(cantidad);
				System.out.println("Producto No Perecedero: " + aux.getNombre() + " Precio unidad: " + aux.getPrecio()
						+ " cantidad vendida: " + cantidad + " importe total: " + importe);
			//si es Perecedero se llamar� al m�todo correcto de dicha clase
			} else if (aux instanceof Perecedero) {
				importe = ((Perecedero) aux).calcular(cantidad);
				System.out.println("Producto Perecedero: " + aux.getNombre() + " Precio unidad: " + aux.getPrecio()
						+ " cantidad vendida: " + cantidad + " importe total: " + importe);
			}
		}

	}

	/**
	 * M�todo hallarCodigo al que se le pasa un arrayList de la clase productos y un
	 * c�digo como par�metros. El m�todo consistir� en saber si el c�digo que el
	 * usuario introduce en consola existe o no, dependiendo de esto, se mostrar� un
	 * resultado u otro.
	 * @param lista ArrayList de Productos
	 * @param cod C�digo del producto
	 * @return true si encuentra el c�digo del producto o false si no lo encuentra
	 * 
	 */
	public static boolean hallarCodigo(ArrayList<Productos> lista, String cod) {

		for (Productos aux : lista) {
			//si el codigo existe se devuelve true
			if (aux.getCodigo().equalsIgnoreCase(cod)) {
				return true;
			}
		}
		//si no exsiste retornar� false
		return false;

	}

	/**
	 * M�todo a�adirNuevosProductos al que se le pasa un ArrayList de l aclase
	 * productos. Dicho m�todo consiste en que el usuario a�ada un nuevo producto,
	 * para ello el c�digo que se introduzca no ha de existir, si esta condici�n se
	 * cumple, se a�adir� el producto correctamente.
	 * @param lista ArrayList de Productos
	 */
	public static void a�adirNuevosProductos(ArrayList<Productos> lista) {
		Scanner sc = new Scanner(System.in);
		//variables que vamos a utilizar
		String nombre, codigo, tipo;
		double precio;
		int dias;
		boolean existente = false;
		String type;
		System.out.println("Introduce el codigo del que quieras a�adir nuevos productos");
		codigo = sc.next();
		//llamamos al m�todo que hemos creado antes y su resultado lo guardamos en una variable
		existente = hallarCodigo(lista, codigo);
		//si la variable que hemos creado tiene el resultado de true nos mostrar� un mensaje y nos pedir� volver 
		//a insertar otro. Lo har� siempre y cuando la variable sea true.
		while (existente == true) {
			System.out.println("Codigo existente. Introduce otro");
			codigo = sc.next();
			existente = hallarCodigo(lista, codigo);
		}
		System.out.println("Introduce tipo de producto: Perecedero(P)//No Perecedero(NP)");
		type = sc.next();
		System.out.println("Introduce nombre del nuevo producto");
		nombre = sc.next();
		System.out.println("Introduce precio del nuevo producto");
		precio = sc.nextDouble();
		
		//si la letra introducida por teclado es "P" se a�adir� el producto a la clase Perecedero
		if (type == "P") {
			System.out.println("Introduce los dias de caducidad del nuevo producto");
			dias = sc.nextInt();
			lista.add(new Perecedero(nombre, codigo, precio, dias));
		
		//sino, el producto se a�adir� a la clase NoPerecedero
		} else {
			System.out.println("Introduce el tipo del nuevo producto");
			tipo = sc.next();
			lista.add(new NoPerecedero(nombre, codigo, precio, tipo));

		}
		System.out.println("Producto A�adido");
		
		//Por ultimo se visualizar�n los productos que hay llamando al metodo visualizar que hemos creado antes.
		visualizarProductos(lista);
	}

	/**
	 * M�todo grabarProductos que tiene como par�metro un ArrayList de la clase
	 * Productos. Dicho m�todo consiste en grabar un producto en un fichero.
	 * 
	 * @throws ClassNotFoundException Excepci�n de clase no encontrada
	 * @throws FileNotFoundException  Excepci�n de archivo no encontrado
	 * @throws IOException  Excepci�n IO
	 * @param lista ArrayList de Productos
	 */
	public static void grabarProductos(ArrayList<Productos> lista)
			throws ClassNotFoundException, FileNotFoundException, IOException {
		ObjectOutputStream salida = new ObjectOutputStream(// output para grabar
				new FileOutputStream("C:\\Users\\Nuria\\OneDrive\\Escritorio\\Ficheros\\productos.txt"));

		salida.writeObject(lista);
		salida.close();

	}

	/**
	 * M�todo leerNuevoFichero que tiene como par�metro un ArrayList de la clase
	 * Productos. Consistir� en leer el fichero que hemos grabado anteriormente
	 * gracias al m�todo grabarProductos.
	 * @throws ClassNotFoundException Excepci�n de clase no encontrada
	 * @throws FileNotFoundException  Excepci�n de archivo no encontrado
	 * @throws IOException  Excepci�n IO
	 * @param lista ArrayList productos
	 * 
	 */
	public static void leerNuevoFichero(ArrayList<Productos> lista)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream entrada = new ObjectInputStream(
				new FileInputStream("C:\\Users\\Nuria\\OneDrive\\Escritorio\\Ficheros\\productos.txt")); //input para leer.
		lista = (ArrayList<Productos>) entrada.readObject();

		entrada.close();
		System.out.println(lista.toString());

	}

	/**
	 * M�todo eliminarProductos que tiene como par�metro un ArrayList de la clase
	 * Productos. El m�todo consiste en eliminar un producto existente. Si el nombre
	 * del producto no existe, se mostrar� un mensaje indic�ndolo
	 * @param lista ArrayList productos
	 */
	static void eliminarProductos(ArrayList<Productos> lista) {
		Productos prod;
		String nombre;
		boolean sw = false;
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce el nombre del producto a eliminar: ");
		nombre = teclado.next();
		
		//esta vez, para recorrer la lista de productos utilizaremos un iterator.
		Iterator<Productos> it = lista.iterator();
		while (it.hasNext()) {
			prod = it.next();
			//si el nombre que introducimos se encuentra en la lista de productos, se eliminar� con el remove() y se 
			//pondr� la variable a true.
			if (prod.getNombre().equalsIgnoreCase(nombre)) {
				it.remove();
				sw = true;
			}
		}
		//si el nombre no existe, la variable sigue en false y se mostrar� un mensaje.
		if (sw == false) {
			System.out.println("No existen productos con ese nombre");
		}
	}

}
