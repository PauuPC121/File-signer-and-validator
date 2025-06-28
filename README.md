Firmador y Validador de Archivos con Java

Este proyecto implementa un sistema básico de firma digital y verificación de firmas utilizando Java y claves RSA almacenadas en un keystore.

Qué hace este programa:

Firma todos los archivos de una carpeta y devuelve su firma en Base64.

Valida archivos contra su firma para comprobar si han sido modificados.

Cómo usarlo:

Firmar archivos:

Compila y ejecuta el archivo Signador.java:

javac Signador.java
java Signador

Luego:

Introduce la ruta de la carpeta con los archivos a firmar.

Obtendrás en consola la firma en Base64 de cada archivo.

Validar un archivo:

Compila y ejecuta el archivo Validador.java:

javac Validador.java
java Validador

Luego:

Introduce la ruta del archivo y su firma (en Base64).

El sistema te dirá si la firma es válida o no.

Keystore:

Archivo: key.jks

Alias: fitxers

Contraseña: password

Para generar el keystore:

keytool -genkeypair -alias fitxers -keyalg RSA -keystore key.jks -storepass password

Requisitos:

Java 8 o superior

Archivo key.jks válido en el mismo directorio del programa

Licencia:

MIT © Pau
