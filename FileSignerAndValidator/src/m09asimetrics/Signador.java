package m09asimetrics;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.Base64;
import java.util.Scanner;

public class Signador {
	public static KeyStore keystore;

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		final String keyStoreFile = "key.jks";
		final String keyStorePassword = "password";
		boolean signarAltreArchiu = true;
		while (signarAltreArchiu) {
			System.out.print("Ingrese la ruta de la carpeta: ");
			String filePath = scanner.nextLine().trim();
			final String folderPath = filePath;



			filesByFolder(folderPath, keyStoreFile, keyStorePassword);
			System.out.print("¿Desea firmar otros archivos? (s/n): ");
			String respuesta = scanner.nextLine().trim();
			if (!respuesta.equalsIgnoreCase("s") || !respuesta.equalsIgnoreCase("S")) {
				signarAltreArchiu = false;
				System.out.println("Adeu.");
			}
		}
		scanner.close();

	}

	public static void filesByFolder(String folderPath, String keystoreFile, String keystorePassword) {
		try {
			keystore = loadKeyStore(keystoreFile, keystorePassword);
			PrivateKey privateKey = (PrivateKey) keystore.getKey("fitxers", keystorePassword.toCharArray());

			File folder = new File(folderPath);
			File[] files = folder.listFiles();

			if (files != null) {
				for (File file : files) {
					if (file.isFile()) {
						byte[] fileData = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
						byte[] signature = signData(fileData, privateKey);

						System.out.println("Archivo: " + file.getName());
						System.out.println("Firma: " + Base64.getEncoder().encodeToString(signature));
						System.out.println();
					}
				}
			} else {
				throw new Exception("El path introducido no es una carpeta válida.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static byte[] signData(byte[] data, PrivateKey privateKey) {
		byte[] signature = null;

		try {
			Signature signer = Signature.getInstance("SHA256withRSA");
			signer.initSign(privateKey);
			signer.update(data);
			signature = signer.sign();
		} catch (Exception ex) {
			System.err.println("Error signing data: " + ex);
		}
		return signature;
	}

	public static KeyStore loadKeyStore(String keystoreFile, String keystorePassword) throws Exception {
		KeyStore keystore = KeyStore.getInstance("JKS");

		File file = new File(keystoreFile);

		if (file.isFile()) {
			try (FileInputStream in = new FileInputStream(file)) {
				byte[] encodedKS = in.readAllBytes();
				String base64Data = new String(encodedKS, StandardCharsets.UTF_8);
				byte[] decodedData = Base64.getDecoder().decode(base64Data);
				keystore.load(new ByteArrayInputStream(decodedData), keystorePassword.toCharArray());

			}
		}

		return keystore;
	}
}