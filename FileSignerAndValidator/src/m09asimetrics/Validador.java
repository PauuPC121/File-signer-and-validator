package m09asimetrics;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.util.Base64;
import java.util.Scanner;
import java.io.FileInputStream;

public class Validador {
	private static KeyStore keystore;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean validarOtroArchivo = true;

		while (validarOtroArchivo) {
			System.out.print("Ingrese la ruta del archivo: ");
			String filePath = scanner.nextLine().trim();
			System.out.print("Ingrese la firma en formato Base64: ");
			String signatureBase64 = scanner.nextLine().trim();
			validateSignature(filePath, signatureBase64);

			System.out.print("¿Desea validar otro archivo? (s/n): ");
			String respuesta = scanner.nextLine().trim();
			if (!respuesta.equalsIgnoreCase("s") || !respuesta.equalsIgnoreCase("S")) {
				validarOtroArchivo = false;
				System.out.println("Adeu.");
			}
		}

		scanner.close();
	}

	public static void validateSignature(String filePath, String signatureBase64) {
		try {
			File file = new File(filePath);
			byte[] fileData = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
			byte[] signature = Base64.getDecoder().decode(signatureBase64);

			keystore = loadKeyStore("key.jks", "password");
			Certificate certificate = keystore.getCertificate("fitxers");
			PublicKey publicKey = certificate.getPublicKey();

			Signature verifier = Signature.getInstance("SHA256withRSA");
			verifier.initVerify(publicKey);
			verifier.update(fileData);
			boolean isValid = verifier.verify(signature);

			if (isValid) {
				System.out.println("La firma es válida.");
			} else {
				System.out.println("ATENCIÓ - La firma NO es válida.");
			}
		} catch (NoSuchFileException e) {
			System.out.println("Aquest fitxer o directori no existeix.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static KeyStore loadKeyStore(String keystoreFile, String keystorePassword) throws Exception {
		KeyStore keystore = KeyStore.getInstance("JKS");

		File file = new File(keystoreFile);

		if (file.isFile()) {
			try (FileInputStream in = new FileInputStream(file)) {
				byte[] encodedKS = in.readAllBytes();
				String base64Data = new String(encodedKS);
				byte[] decodedData = Base64.getDecoder().decode(base64Data);
				keystore.load(new ByteArrayInputStream(decodedData), keystorePassword.toCharArray());
			}
		}

		return keystore;
	}
}
