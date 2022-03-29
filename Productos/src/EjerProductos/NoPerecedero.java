package EjerProductos;

/**
 * @author Nuria Rodríguez Álvarez
 * @since 28/03/2022
 * @version 1.0
 * 
 */
/**
 * Clase que extiende de Productos
 * 
 */
public class NoPerecedero extends Productos {
	/**
	 * tipo de producto
	 */
	private String tipo; 

	/**
	 * Constructor sin parámetros
	 */
	public NoPerecedero() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor con cuatro parámetros.
	 * 
	 * @param nombre Nombre del producto
	 * @param codigo Código del producto
	 * @param precio Precio del producto
	 * @param tipo Tipo de producto
	 */
	public NoPerecedero(String nombre, String codigo, double precio, String tipo) {
		super(nombre, codigo, precio);
		this.tipo = tipo;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Getters y Setters
	 */
	/**
	 * @return tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo Tipo de producto
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Método toString que muestra una cadena
	 */
	@Override
	public String toString() {
		return "Producto NoPerecedero [tipo=" + tipo + "]" + super.toString() + "\n";
	}

	/**
	 * Método calcular que recibe un parámetro cantidad. Consiste en calcular el
	 * precio final de un producto
	 * 
	 * @param cantidad Número de productos comprado
	 * @return Devuelve un double que resulta al multiplicar el precio recogido del
	 *         constructor por la cantidad recibida en el parámetro
	 */
	public double calcular(int cantidad) {

		return cantidad * super.getPrecio();

	}

}
