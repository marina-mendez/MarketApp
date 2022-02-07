package src.productos;

public class BebAlcoholica extends Productos {
	private String graduacion;
	private String region;

	public BebAlcoholica(String nombre, String marca, String tipo, String precioFinal, String volumen, String cantidad,
			String vencimiento, String reciclable, String graduacion, String region) {
		super(nombre, marca, tipo, precioFinal, volumen, cantidad, vencimiento, reciclable);
		this.graduacion = graduacion;
		this.region = region;
	}

	public String getOtro1() {
		return graduacion;
	}

	public void setGraduacion(String graduacion) {
		this.graduacion = graduacion;
	}

	public String getOtro2() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String infoProductos() {
		return super.infoProductos() + "Graduacion alcoholica: " + this.graduacion + ". \n" + "Region de origen:" + this.region;
	}

}
