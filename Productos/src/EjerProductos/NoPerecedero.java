package EjerProductos;

/**
 * @author Nuria Rodr�guez �lvarez
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
	 * Constructor sin par�metros
	 */
	public NoPerecedero() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor con cuatro par�metros.
	 * 
	 * @param nombre Nombre del producto
	 * @param codigo C�digo del producto
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
	 * M�todo toString que muestra una cadena
	 */
	@Override
	public String toString() {
		return "Producto NoPerecedero [tipo=" + tipo + "]" + super.toString() + "\n";
	}

	/**
	 * M�todo calcular que recibe un par�metro cantidad. Consiste en calcular el
	 * precio final de un producto
	 * 
	 * @param cantidad N�mero de productos comprado
	 * @return Devuelve un double que resulta al multiplicar el precio recogido del
	 *         constructor por la cantidad recibida en el par�metro
	 */
	public double calcular(int cantidad) {

		return cantidad * super.getPrecio();

	}

}
