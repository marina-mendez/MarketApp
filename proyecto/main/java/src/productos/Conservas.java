package src.productos;

public class Conservas extends Productos{
	
	private String presentacion;
	private String origen;
	
	public Conservas(String nombre, String marca, String tipo, String precioFinal, String volumen, String cantidad,
			String vencimiento, String reciclable, String presentacion, String origen) {
		super(nombre, marca, tipo, precioFinal, volumen, cantidad, vencimiento, reciclable);
		this.presentacion = presentacion;
		this.origen = origen;
	}

	public String getOtro1() {
		return presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	public String getOtro2() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}
	

	
	public String infoProductos() {
		return super.infoProductos() + "Presentacion: " + this.presentacion + ". \n" + "Origen:" + this.origen;
	}
	
	

}
