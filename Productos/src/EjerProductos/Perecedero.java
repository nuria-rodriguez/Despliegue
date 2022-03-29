package EjerProductos;

/**
 * @author Nuria Rodr�guez �lvarez
 * @since 28/03/2022
 * @version 1.0
 * 
 */

/**
 * Clase Perecedero que extiende de Productos
 * 
 */
public class Perecedero extends Productos {
	/**
	 * dias para perecer
	 */
	private int dias; 

	/**
	 * Constructor sin par�metros que llama al super
	 */
	public Perecedero() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor con cuatro par�metros
	 * 
	 * @param nombre Nombre del producto
	 * @param codigo C�digo del producto
	 * @param precio Precio del producto
	 * @param dias Dias para perecer
	 */
	public Perecedero(String nombre, String codigo, double precio, int dias) {
		super(nombre, codigo, precio);
		this.dias = dias;
		// TODO Auto-generated constructor stub
	}

	/**
	 * GETTERS Y SETTERS
	 */
	/**
	 * @return dias
	 */
	public int getDias() {
		return dias;
	}

	/**
	 * @param dias Dias para perecer
	 */
	public void setDias(int dias) {
		this.dias = dias;
	}

	/**
	 * M�toto toString que devuelve una cadena
	 */
	@Override
	public String toString() {
		return "Producto Perecedero [dias=" + dias + super.toString() + "]\n";
	}

	/**
	 * M�todo calcular que recibe un par�metro y consiste en calcular el precio
	 * final de un producto
	 * 
	 * @param cantidad Producto comprado
	 * @return Devolver� el precio final
	 */
	public double calcular(int cantidad) {
		int[] dias = { 1, 2, 3, 4, 5 };
		double[] porcentaje = { 4, 3.5, 3, 2.5, 2 };
		double reducir = 0;
		for (int i = 0; i < dias.length; i++) {
			if (getDias() == dias[i]) {
				reducir = porcentaje[i];
			}
		}
		double precio_final = super.getPrecio() - (super.getPrecio() * (reducir / 100) * cantidad);
		return precio_final;
	}

}
