package helpers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import productos.BebAlcoholica;
import productos.Bebidas;
import productos.Conservas;
import productos.CuidadoCapilar;
import productos.Farmacia;
import productos.FrutasVerduras;
import productos.Golosinas;
import productos.Productos;

public class Helper {

	private static float precioDesc;
	private static float precioConDesc;
	private static float precioFinal;
	private static boolean descuento;
	private static float recargo;
	private static boolean hayRecargo;

	public Helper() {

	}

	private static BufferedReader OpenCsv() {
		BufferedReader br = null;
		String txtPath = System.getProperty("user.dir") + "\\src\\proyecto\\listadoProducto.csv";
		try {
			br = new BufferedReader(new FileReader(txtPath));
		} catch (IOException e) {
			System.out.println("Hubo un error en la apertura del archivo CSV:");
			System.out.println(e.getMessage());

		}
		return br;

	}

	public static String calculoDescuentoRecargo(String Tipo, String producto, String marca, String reciclar,
			String cantidad, String vencimiento, String volumen, String Precio) {
		Log.info(" \n" + "#########METODO calculoDescuentoRecargo:"
				+ "\nParametros de entrada: String Tipo, String producto, String marca, String reciclar,\r\n"
				+ "			String cantidad, String vencimiento, String volumen, String Precio");

		try {

			recargo = 0;
			hayRecargo = false;

			// la primer parte del método sirve para aplicar el descuento correspondiente,
			// comenzando del de mayor valor (ya que no son acumulativos)
			// si el condicional no coincide con la característica del producto, sigue hacia
			// el próximo
			Log.info(" \n" + "*****Calculo de descuentos no acumulativos:");
			// productos en stock con mas de 600 unidades:
			if (Integer.valueOf(cantidad) >= 600) {
				float price = Float.parseFloat(Precio);
				precioDesc = (price * 20) / 100;
				descuento = true;
				Log.info(" \n" + "----Descuento del 20% por mas de 600 unidades en stock((precio * 20) / 100): $"
						+ Float.toString(precioDesc) + ". Descuento: " + descuento);
			}
			// productos con tomate
			else if (producto.contains("tomate")) {
				float price = Float.parseFloat(Precio);
				precioDesc = (price * 15) / 100;
				descuento = true;
				Log.info(" \n" + "----Descuento del 15% por producto con tomate((precio * 15) / 100): $"
						+ Float.toString(precioDesc) + ". Descuento: " + descuento);
			}
			// productos marca Arcor
			else if (marca.contains("Arcor")) {
				float price = Float.parseFloat(Precio);
				precioDesc = (price * 12) / 100;
				descuento = true;
				Log.info(" \n" + "----Descuento del 12% por producto marca Arcor((precio * 12) / 100): $"
						+ Float.toString(precioDesc) + ". Descuento: " + descuento);
			}
			// productos reciclables
			else if (reciclar.contains("si")) {
				float price = Float.parseFloat(Precio);
				precioDesc = (price * 10) / 100;
				descuento = true;
				Log.info(" \n" + "----Descuento del 10% por ser reciclable((precio * 10) / 100): $"
						+ Float.toString(precioDesc) + ". Descuento: " + descuento);
			}
			// productos que vencen en el 2022
			else if ((vencimiento.contains("22"))) {
				float price = Float.parseFloat(Precio);
				precioDesc = (price * 7) / 100;
				descuento = true;
				Log.info(" \n" + "----Descuento del 7% por vencer en 2022 ((precio * 7) / 100): $"
						+ Float.toString(precioDesc) + ". Descuento: " + descuento);
			} else {
				descuento = false;
				Log.info(" \n" + "----No hay descuentos para este producto. Descuento: " + descuento);
			}

			// la segunda parte del método verifica que recargos tiene
			// el producto y los suma
			// productos que sean golosinas
			if (!producto.isEmpty()) {
				Log.info(" \n" + "*****Calculo de recargos acumulativos:");
				if (Tipo.contains("Golosina")) {
					recargo += 10;
					Log.info(" \n" + "----Recargo por golosina: 10% =" + Float.toString(recargo) + "%");
					hayRecargo = true;
				}
				// productos con menos de 200 unidades en stock
				if (Integer.valueOf(cantidad) <= 200) {
					recargo += 9;
					hayRecargo = true;
					Log.info(" \n" + "---- +Recargo por 200 unidades en stock: 9% =" + Float.toString(recargo) + "%");
				}
				// productos con envases de menos de 750cc
				if (Integer.valueOf(volumen) <= 750) {
					recargo += 3;
					hayRecargo = true;
					Log.info(
							" \n" + "---- +Recargo por envase con menos de 750cc: 3%=" + Float.toString(recargo) + "%");
				}
				if (hayRecargo == false) {
					Log.info("No hay recargos.");
				}
			}

			// por último, si hay descuentos(descuento==true) se los aplicamos al precio
			// inicial
			// si no hay descuentos, pasamos a los recargos
			// si no hay recargo, el precio inicial queda como precio final

			Log.info(" \n" + "*****Calculo del precio final:");
			if (descuento == true) {
				Log.info(" \n" + "---if (descuento == true):");
				float precioInicial = Float.parseFloat(Precio);
				precioConDesc = precioInicial - precioDesc;
				Log.info("\n" + "-----Precio con descuento= " + precioInicial + " - " + precioDesc + " = "
						+ precioConDesc);
				if (hayRecargo == true) {
					Log.info("\n" + "---if (hayRecargo == true)");
					float precioConRec = precioConDesc + precioInicial * (recargo / 100);
					Log.info("\n" + "-----Precio con recargo= " + precioConDesc + " + (" + precioInicial + "*("
							+ recargo + "/100))");
					precioFinal = precioConRec;
				} else {
					precioFinal = precioConDesc;
					Log.info(" \n" + "---No hay recargos: (precioFinal = precioConDesc)" + "=" + precioConDesc);
				}
			} else if (hayRecargo == true) {
				Log.info(" \n" + "---else if (hayRecargo == true), solo recargos, NO hay descuentos:");
				float precioInicial = Float.parseFloat(Precio);
				float precioConRec = precioInicial + (precioInicial * (recargo / 100));
				Log.info("\n" + "Precio con recargo= " + precioInicial + "+ (" + precioInicial + "*(" + recargo
						+ "/100))");
				precioFinal = precioConRec;
			} else {
				float precioInicial = Float.parseFloat(Precio);
				precioFinal = precioInicial;
				Log.info(" \n" + "No se aplicaron descuentos ni recargos:" + precioFinal);
			}

		} catch (Exception e) {
			System.out.println("Error en Helper.java= " + e.getMessage());
		}
		Log.info(" \n" + "***Precio final: $" + Float.toString(precioFinal));
		return Float.toString(precioFinal);

	}

	// validacion de valores numericos
	public static String validaValor(String valor) {

		if (valor != null && !valor.isEmpty()) {
			return valor;
		}
		return "0";
	}

	// validacion de valores con texto
	public static String validaTexto(String valor) {

		if (valor != null && !valor.isEmpty()) {
			return valor;
		}
		return "ND";
	}

	// chequeo que tipo de producto es y por lo tanto que categoría poner en OTRO1 y
	// OTRO2
	public static void checkTipo(String name, String marca, String tipo, String price, String volumen, String cantidad,
			String vencimiento, String reciclable, String otro1, String otro2, ArrayList<Productos> productos) {
		if (tipo.equalsIgnoreCase("golosina")) {
			Productos golosina = new Golosinas(name, marca, tipo, price, volumen, cantidad, vencimiento, reciclable,
					otro1, otro2);
			Log.logCheckTipo();
			Log.info(" \n" + "#Tipo: " + tipo + ", golosina.infoProductos() = \n" + golosina.infoProductos());
			System.out.println(golosina.infoProductos());
			productos.add(golosina);
		} else if (tipo.equalsIgnoreCase("bebida alcoholica")) {
			Productos balcohol = new BebAlcoholica(name, marca, tipo, price, volumen, cantidad, vencimiento, reciclable,
					otro1, otro2);
			Log.logCheckTipo();
			Log.info(" \n" + "#Tipo: " + tipo + ", balcohol.infoProductos() = \n" + balcohol.infoProductos());
			System.out.println(balcohol.infoProductos());
			productos.add(balcohol);
		} else if (tipo.equalsIgnoreCase("conservas")) {
			Productos conservas = new Conservas(name, marca, tipo, price, volumen, cantidad, vencimiento, reciclable,
					otro1, otro2);
			System.out.println(conservas.infoProductos());
			Log.logCheckTipo();
			Log.info(" \n" + "#Tipo: " + tipo + ", conservas.infoProductos() = \n" + conservas.infoProductos());
			productos.add(conservas);
		} else if (tipo.contains("frutas")) {
			Productos frutas = new FrutasVerduras(name, marca, tipo, price, volumen, cantidad, vencimiento, reciclable,
					otro1, otro2);
			System.out.println(frutas.infoProductos());
			Log.logCheckTipo();
			Log.info(" \n" + "#Tipo: " + tipo + ", frutas.infoProductos() = \n" + frutas.infoProductos());
			productos.add(frutas);
		} else if (tipo.equalsIgnoreCase("farmacia")) {
			Productos farmacia = new Farmacia(name, marca, tipo, price, volumen, cantidad, vencimiento, reciclable,
					otro1, otro2);
			System.out.println(farmacia.infoProductos());
			Log.logCheckTipo();
			Log.info(" \n" + "#Tipo: " + tipo + ", farmacia.infoProductos()= \n" + farmacia.infoProductos());
			productos.add(farmacia);
		} else if (tipo.equalsIgnoreCase("bebida")) {
			Productos bebida = new Bebidas(name, marca, tipo, price, volumen, cantidad, vencimiento, reciclable, otro1);
			System.out.println(bebida.infoProductos());
			Log.logCheckTipo();
			Log.info(" \n" + "#Tipo: " + tipo + ", bebida.infoProductos() = \n" + bebida.infoProductos());
			productos.add(bebida);
		} else if (tipo.contains("cuidado")) {
			Productos cuidado = new CuidadoCapilar(name, marca, tipo, price, volumen, cantidad, vencimiento, reciclable,
					otro1);
			System.out.println(cuidado.infoProductos());
			Log.logCheckTipo();
			Log.info(" \n" + "#Tipo: " + tipo + ", cuidado.infoProductos() = \n" + cuidado.infoProductos());
			productos.add(cuidado);
		}
	}

	public static ArrayList<Productos> creacionArreglo() {
		ArrayList<Productos> productos = new ArrayList<Productos>();
		int cnt = 0;
		try {
			Log.actualDate();

			BufferedReader br = Helper.OpenCsv();

			String linea = br.readLine();

			while (linea != null) {
				String[] campos = linea.split(";");

				linea = br.readLine();

				cnt++;

				if (cnt >= 2) {
					Log.info(" \n");
					Log.info(
							" \n#########METODO Helper.validaTexto y Helper.validaValor: Reemplazo valores null con 0 o ND");
					String tipo = Helper.validaTexto(campos[0]);
					String nombre = Helper.validaTexto(campos[1]);
					String marca = Helper.validaTexto(campos[2]);
					String volumen = Helper.validaValor(
							campos[3].replace("cc", "").replace("gr", "").replace("N/A", "").replaceAll(" ", ""));
					String precio = campos[4].replace(",", ".");
					String cant = Helper.validaValor(campos[5]).replace(",", ".");
					String vencim = Helper.validaValor(campos[6]);
					String reciclable = Helper.validaValor(campos[8]);
					String otro1 = Helper.validaValor(campos[9]);
					String otro2 = Helper.validaValor(campos[10]);

					Log.logDatos(tipo, nombre, marca, volumen, precio, cant, vencim, reciclable, otro1, otro2);
					
					
					// Chequeo el tipo de producto para asignar categorías a OTRO1 y OTRO2, e
					// instanciarlo y guardarlos en ArrayList produc
					Helper.checkTipo(nombre, marca, tipo, precio, volumen, cant, vencim, reciclable, otro1, otro2,
							productos);
				}
			}

		} catch (IOException e) {
			System.out.println("Hubo un error en la lectura del archivo CSV:");
			System.out.println(e.getMessage());

		}

		return productos;
	}
	
	
}
