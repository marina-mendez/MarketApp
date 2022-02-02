package productos;

import helpers.Helper;

@SuppressWarnings("rawtypes")
public abstract class Productos implements Comparable{
	
	protected String nombre; 
	protected String marca;
	protected String tipo;
	protected String precioFinal;
	private String volumen;
	private String cantidad;
	private String vencimiento;
	private String reciclable;
	
	
	public Productos(String nombre, String marca, String tipo, String precioFinal, String volumen, String cantidad,
			String vencimiento, String reciclable) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.tipo = tipo;
		this.precioFinal = precioFinal;
		this.volumen = volumen;
		this.cantidad = cantidad;
		this.vencimiento = vencimiento;
		this.reciclable = reciclable;
		
		calcularPrecioFinal();

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(String precioFinal) {
		this.precioFinal = precioFinal;
	}


	public String getVolumen() {
		return volumen;
	}


	public void setVolumen(String volumen) {
		this.volumen = volumen;
	}


	public String getCantidad() {
		return cantidad;
	}


	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}


	public String getVencimiento() {
		return vencimiento;
	}


	public void setVencimiento(String vencimiento) {
		this.vencimiento = vencimiento;
	}


	public String getReciclable() {
		return reciclable;
	}


	public void setReciclable(String reciclable) {
		this.reciclable = reciclable;
	}
	

	
	public String infoProductos() {
		return "Producto: " + this.nombre + ". \n" + "Precio final: $" + this.precioFinal + ". \n" +"Marca: " + this.marca + ". \n" +"Tipo: " + this.tipo + ". \n";
	}

	public void calcularPrecioFinal() {
		this.precioFinal=Helper.calculoDescuentoRecargo(tipo, nombre, marca, reciclable, cantidad, vencimiento, volumen, precioFinal);
	}

	@Override
	public int compareTo(Object o) {
		Productos comparingTo = (Productos)o;
		
		int difference = this.toString().compareTo(comparingTo.toString());
		
		return difference;
	}

	public abstract String getOtro1();
	public abstract String getOtro2();


	
}
