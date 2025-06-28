# 🛡️ M09Asimetrics – Firma Digital y Verificación de Archivos en Java

Este proyecto implementa un sistema sencillo de **firma digital** y **verificación de integridad** de archivos utilizando Java y claves RSA contenidas en un **Keystore**.

---

## ✍️ Firmar Archivos

1. Compila y ejecuta `Signador.java`:
   ```bash
   javac Signador.java
   java Signador
Introduce la ruta de la carpeta que contiene los archivos a firmar.

El sistema imprimirá en consola la firma Base64 de cada archivo.

🔎 Validar una Firma
Compila y ejecuta Validador.java:

bash
Copiar
Editar
javac Validador.java
java Validador
Introduce la ruta del archivo y la firma en Base64.

El sistema te dirá si la firma es válida o no válida.

🔐 Keystore
Archivo: key.jks

Alias: fitxers

Contraseña: password

Crear un keystore con keytool:
bash
Copiar
Editar
keytool -genkeypair -alias fitxers -keyalg RSA -keystore key.jks -storepass password
📦 Requisitos
Java 8 o superior

Archivo key.jks válido en el mismo directorio del proyecto

🧾 Licencia
MIT © Pau
