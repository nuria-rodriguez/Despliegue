package EjerProductos;

import java.io.Serializable;

/**
 * @author Nuria Rodr�guez �lvarez
 * @since 28/03/2022
 * @version 1.0
 * 
 */
/**
 * Clase Productos que es serializable, esto lo hacemos para que pueda convertir
 * un objeto en bytes para luego recuperarlo y as� enviarse a trav�s de red y
 * poder guardarse en un fichero
 * 
 */
public class Productos implements Serializable {

	/**
	 * nombre del producto
	 */
	private String nombre; 
	/**
	 * codigo del producto
	 */
	private String codigo; 
	/**
	 * precio del producto
	 */
	private double precio; 

	/**
	 * Constructor sin par�metros
	 */
	public Productos() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor con tres par�metros. Tambien se llama al super().
	 * 
	 * @param nombre Nombre del producto
	 * @param codigo C�digo del producto
	 * @param precio Precio del producto
	 */
	public Productos(String nombre, String codigo, double precio) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
	}

	/**
	 * GETTERS Y SETTERS
	 * 
	 */

	/**
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	
	/**
	 * @param nombre Nombre del producto
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo C�digo del producto
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio Precio del producto
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * M�todo toString que devuelve una cadena.
	 */
	@Override
	public String toString() {
		return "[nombre=" + nombre + ", codigo=" + codigo + ", precio=" + precio + "]";
	}

}
