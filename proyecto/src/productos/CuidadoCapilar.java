package productos;

public class CuidadoCapilar extends Productos {
	private String perfumado;
	
	public CuidadoCapilar(String nombre, String marca, String tipo, String precioFinal, String volumen, String cantidad,
			String vencimiento, String reciclable, String perfumado) {
		super(nombre, marca, tipo, precioFinal, volumen, cantidad, vencimiento, reciclable);
		this.perfumado = perfumado;
	}

	public String getOtro1() {
		return perfumado;
	}

	public void setPerfumado(String perfumado) {
		this.perfumado = perfumado;
	}


	public String infoProductos() {
		return super.infoProductos() + "Perfumado: " + this.perfumado;
	}

	@Override
	public String getOtro2() {
		// TODO Auto-generated method stub
		return "ND";
	}

}
