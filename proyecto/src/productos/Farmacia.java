package productos;

public class Farmacia extends Productos {
	private String aptoChicos;
	private String restriccion;

	public Farmacia(String nombre, String marca, String tipo, String precioFinal, String volumen, String cantidad,
			String vencimiento, String reciclable, String aptoChicos, String restriccion) {
		super(nombre, marca, tipo, precioFinal, volumen, cantidad, vencimiento, reciclable);
		this.aptoChicos = aptoChicos;
		this.restriccion = restriccion;
	}

	public String getOtro2() {
		return restriccion;
	}

	public void setRestriccion(String restriccion) {
		this.restriccion = restriccion;
	}

	public String getOtro1() {
		return aptoChicos;
	}

	public void setAptoChicos(String aptoChicos) {
		this.aptoChicos = aptoChicos;
	}



	public String infoProductos() {
		return super.infoProductos() + "Restricción p/ la venta: " + this.restriccion + ". \n" + "Apto p/ chicos:"
				+ this.aptoChicos;
	}

}
