package src.helpers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {

	public Log() {

	}

	static String txtPath = System.getProperty("user.dir") + "\\main\\java\\src\\proyecto\\logProductos.txt";

	private static void write(String text) {
		
		try {
			File archivo;

			archivo = new File(txtPath);

			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			FileWriter fw = new FileWriter(archivo, true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(text);
			bw.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public static void actualDate() {

			@SuppressWarnings("unused")
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();

			write("*************DATE=" +now.toString());

	}

	public static void info(String text) {

		try {
			File archivo;

			archivo = new File(txtPath);

			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			FileWriter fw = new FileWriter(archivo, true);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.close();
			
			write(text);
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public static void logDatos(String tipo, String nombre, String marca, String volumen, String price, String cant,
			String venc, String rec, String otro1, String otro2) {

		try {

			File archivo;

			archivo = new File(txtPath);

			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			FileWriter fw = new FileWriter(archivo, true);
			BufferedWriter bw = new BufferedWriter(fw);
			Log.info("\n#########METODO logDatos");
			String datos = "\r\n*************LECTURA DE DATOS DEL PRODUCTO:" + "\n" + "Tipo de producto: " + tipo + ". \n" + "Nombre: "
					+ nombre + ". \n" + "Volumen: " + volumen + ". \n" + "Precio: " + price + ". \n" + "Cantidad: "
					+ cant + ". \n" + "Vencimiento: " + venc + ". \n" + "Reciclable: " + rec + ". \n" + "Otro1: "
					+ otro1 + ". \n" + "Otro2: " + otro2;
			bw.close();
			
			write(datos);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void logCheckTipo() {
		Log.info(" \n" + "#########METODO checkTipo: asignar categorías a OTRO1 y OTRO2 según tipo de producto"
				+ "\nParametros de entrada: String tipo, String name, String price, String marca, String otro1, String otro2");
	}
	
		
	
	
}
