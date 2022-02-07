package src.productos;

public class Golosinas extends Productos {
	private String azucar;
	private String grasas;

	public Golosinas(String nombre, String marca, String tipo, String precioFinal, String volumen, String cantidad,
			String vencimiento, String reciclable, String azucar, String grasas) {
		super(nombre, marca, tipo, precioFinal, volumen, cantidad, vencimiento, reciclable);
		this.azucar = azucar;
		this.grasas = grasas;
	}

	public String getOtro1() {
		return azucar;
	}

	public void setAzucar(String azucar) {
		this.azucar = azucar;
	}

	public String getOtro2() {
		return grasas;
	}

	public void setGrasas(String grasas) {
		this.grasas = grasas;
	}

	public String infoProductos() {
		return super.infoProductos() + "Contiene azucar: " + this.azucar + ". \n" + "Bajo en grasas: " + this.grasas;

	}

}
