package productos;

public class FrutasVerduras extends Productos {
	private String conservantes;
	private String origen;
	
	public FrutasVerduras(String nombre, String marca, String tipo, String precioFinal, String volumen, String cantidad,
			String vencimiento, String reciclable, String conservantes, String origen) {
		super(nombre, marca, tipo, precioFinal, volumen, cantidad, vencimiento, reciclable);
		this.conservantes = conservantes;
		this.origen = origen;
	}

	public String getOtro1() {
		return conservantes;
	}

	public void setConservantes(String conservantes) {
		this.conservantes = conservantes;
	}

	public String getOtro2() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}


	public String infoProductos() {
		return super.infoProductos() + "Contiene conservantes artificiales: " + this.conservantes + "Origen:"
				+ this.origen;
	}

}
