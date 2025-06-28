¡Aquí lo tienes listo para copiar y pegar directamente, sin secciones innecesarias! 👇

---

````markdown
# 🔐 M09Asimetrics – Firma y Validación de Archivos con Java

Este proyecto implementa un sistema básico de **firma digital** y **verificación de firmas** utilizando Java y el algoritmo `SHA256withRSA`.

## Cómo usarlo

### 🖊️ Firmar archivos

1. Ejecuta `Signador.java`
2. Introduce la ruta de la carpeta con los archivos a firmar
3. Obtendrás por consola la firma en Base64 de cada archivo

```bash
java Signador
````

### 🔍 Validar una firma

1. Ejecuta `Validador.java`
2. Introduce la ruta del archivo y la firma en base64
3. El sistema te dirá si la firma es válida o no

```bash
java Validador
```

## Keystore

* Archivo: `key.jks`
* Alias: `fitxers`
* Contraseña: `password`

Para generar uno:

```bash
keytool -genkeypair -alias fitxers -keyalg RSA -keystore key.jks -storepass password
```

## Requisitos

* Java 8 o superior
* Archivo `key.jks` válido en la raíz del proyecto

## Licencia

MIT © Pau

```
```
