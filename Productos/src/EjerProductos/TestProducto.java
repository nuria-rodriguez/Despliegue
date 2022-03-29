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
 * @author Nuria Rodríguez Álvarez
 * @since 28/03/2022
 * @version 1.0
 * 
 */

/**
 * Esta clase contiene diferentes métodos estáticos que permitirán que funcione
 * una aplicación
 */

public class TestProducto {
	/**
	 * Método main que podría lanzar una excepción. En él se crea un arrayLIst de
	 * productos y se llamará a tres métodos
	 * 
	 * @param args Argumentos
	 * @throws ClassNotFoundException Excepción de clase no encontrada
	 * @throws FileNotFoundException  Excepción de archivo no encontrado
	 * @throws IOException  Excepción IO
	 */
	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException {
		ArrayList<Productos> lista = new ArrayList<>();
		cargarProductos(lista);
		visualizarProductos(lista);
		menu(lista);
	}

	/**
	 * Método menú que se le pasa como parámetro un arrayList. Este método genera un
	 * menú de 5 opciones y el usuario podrá interactuar con él.
	 * 
	 * @throws ClassNotFoundException Excepción de clase no encontrada
	 * @throws FileNotFoundException  Excepción de archivo no encontrado
	 * @throws IOException  Excepción IO
	 * @param lista ArrayList de Productos
	 */
	public static void menu(ArrayList<Productos> lista)
			throws ClassNotFoundException, FileNotFoundException, IOException {

		Scanner teclado = new Scanner(System.in);
		int opcion;
		do {
			System.out.println();
			System.out.println("--------MENÚ--------");
			System.out.println("1-Grabar productos en un fichero");
			System.out.println("2-Añadir productos");
			System.out.println("3-Calcular importe total");
			System.out.println("4-Eliminar productos");
			System.out.println("5-Finalizar");
			System.out.print("Introducir opcion: ");
			opcion = teclado.nextInt();
			//si la opcion es menor que 1 o mayor de 5 se producirá un error. 
			while ((opcion < 1) || (opcion > 5)) {
				System.out.println("Error en opción");
				System.out.print("Introducir opción: ");
				opcion = teclado.nextInt();
			}
			//menú de opciones
			switch (opcion) {
			case 1:
				grabarProductos(lista);
				System.out.println("Fichero grabado");
				break;
			case 2:
				añadirNuevosProductos(lista);
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
	 * Método cargarProductos al que se le pasa un ArrayList de la clase Productos.
	 * En él añadimos al array nuevos objetos de las clases Perecedero y
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
	 * Método visualizarProductos al que se le pasa un ArrayList de la clase
	 * Productos. Dicho método consiste en visualizar todos los productos, para ello
	 * llamamos al método toString que hemos creado anteriormente en la clase
	 * Productos.
	 * @param lista ArrayList de Productos
	 */
	public static void visualizarProductos(ArrayList<Productos> lista) {
		System.out.println(lista.toString());

	}

	/**
	 * Método calcularImporteTotal al que se le pasa un ArrayList de la clase
	 * Productos por parámetro. El método consistirá en calcular el precio del
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
			//si es NoPerecedero se llamará al método correspondiente de dicha clase
			if (aux instanceof NoPerecedero) {
				importe = ((NoPerecedero) aux).calcular(cantidad);
				System.out.println("Producto No Perecedero: " + aux.getNombre() + " Precio unidad: " + aux.getPrecio()
						+ " cantidad vendida: " + cantidad + " importe total: " + importe);
			//si es Perecedero se llamará al método correcto de dicha clase
			} else if (aux instanceof Perecedero) {
				importe = ((Perecedero) aux).calcular(cantidad);
				System.out.println("Producto Perecedero: " + aux.getNombre() + " Precio unidad: " + aux.getPrecio()
						+ " cantidad vendida: " + cantidad + " importe total: " + importe);
			}
		}

	}

	/**
	 * Método hallarCodigo al que se le pasa un arrayList de la clase productos y un
	 * código como parámetros. El método consistirá en saber si el código que el
	 * usuario introduce en consola existe o no, dependiendo de esto, se mostrará un
	 * resultado u otro.
	 * @param lista ArrayList de Productos
	 * @param cod Código del producto
	 * @return true si encuentra el código del producto o false si no lo encuentra
	 * 
	 */
	public static boolean hallarCodigo(ArrayList<Productos> lista, String cod) {

		for (Productos aux : lista) {
			//si el codigo existe se devuelve true
			if (aux.getCodigo().equalsIgnoreCase(cod)) {
				return true;
			}
		}
		//si no exsiste retornará false
		return false;

	}

	/**
	 * Método añadirNuevosProductos al que se le pasa un ArrayList de l aclase
	 * productos. Dicho método consiste en que el usuario añada un nuevo producto,
	 * para ello el código que se introduzca no ha de existir, si esta condición se
	 * cumple, se añadirá el producto correctamente.
	 * @param lista ArrayList de Productos
	 */
	public static void añadirNuevosProductos(ArrayList<Productos> lista) {
		Scanner sc = new Scanner(System.in);
		//variables que vamos a utilizar
		String nombre, codigo, tipo;
		double precio;
		int dias;
		boolean existente = false;
		String type;
		System.out.println("Introduce el codigo del que quieras añadir nuevos productos");
		codigo = sc.next();
		//llamamos al método que hemos creado antes y su resultado lo guardamos en una variable
		existente = hallarCodigo(lista, codigo);
		//si la variable que hemos creado tiene el resultado de true nos mostrará un mensaje y nos pedirá volver 
		//a insertar otro. Lo hará siempre y cuando la variable sea true.
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
		
		//si la letra introducida por teclado es "P" se añadirá el producto a la clase Perecedero
		if (type == "P") {
			System.out.println("Introduce los dias de caducidad del nuevo producto");
			dias = sc.nextInt();
			lista.add(new Perecedero(nombre, codigo, precio, dias));
		
		//sino, el producto se añadirá a la clase NoPerecedero
		} else {
			System.out.println("Introduce el tipo del nuevo producto");
			tipo = sc.next();
			lista.add(new NoPerecedero(nombre, codigo, precio, tipo));

		}
		System.out.println("Producto Añadido");
		
		//Por ultimo se visualizarán los productos que hay llamando al metodo visualizar que hemos creado antes.
		visualizarProductos(lista);
	}

	/**
	 * Método grabarProductos que tiene como parámetro un ArrayList de la clase
	 * Productos. Dicho método consiste en grabar un producto en un fichero.
	 * 
	 * @throws ClassNotFoundException Excepción de clase no encontrada
	 * @throws FileNotFoundException  Excepción de archivo no encontrado
	 * @throws IOException  Excepción IO
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
	 * Método leerNuevoFichero que tiene como parámetro un ArrayList de la clase
	 * Productos. Consistirá en leer el fichero que hemos grabado anteriormente
	 * gracias al método grabarProductos.
	 * @throws ClassNotFoundException Excepción de clase no encontrada
	 * @throws FileNotFoundException  Excepción de archivo no encontrado
	 * @throws IOException  Excepción IO
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
	 * Método eliminarProductos que tiene como parámetro un ArrayList de la clase
	 * Productos. El método consiste en eliminar un producto existente. Si el nombre
	 * del producto no existe, se mostrará un mensaje indicándolo
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
			//si el nombre que introducimos se encuentra en la lista de productos, se eliminará con el remove() y se 
			//pondrá la variable a true.
			if (prod.getNombre().equalsIgnoreCase(nombre)) {
				it.remove();
				sw = true;
			}
		}
		//si el nombre no existe, la variable sigue en false y se mostrará un mensaje.
		if (sw == false) {
			System.out.println("No existen productos con ese nombre");
		}
	}

}
