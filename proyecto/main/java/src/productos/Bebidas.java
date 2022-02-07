package src.productos;

public class Bebidas extends Productos{
	private String azucar;

	public Bebidas(String nombre, String marca, String tipo, String precioFinal, String volumen, String cantidad,
			String vencimiento, String reciclable, String azucar) {
		super(nombre, marca, tipo, precioFinal, volumen, cantidad, vencimiento, reciclable);
		this.azucar = azucar;
	}

	public String getOtro1() {
		return azucar;
	}

	public void setAzucar(String azucar) {
		this.azucar = azucar;
	}
	
	public String infoProductos() {
		return super.infoProductos() + "Contiene azucar: " + this.azucar;
	}

	@Override
	public String getOtro2() {
		// TODO Auto-generated method stub
		return "ND";
	}
}
