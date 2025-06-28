
---

```markdown
# 🔐 M09Asimetrics – Firma y Validación de Archivos con Java

Este proyecto implementa un sistema básico de **firma digital** y **verificación de firmas** usando Java y el algoritmo `SHA256withRSA`.

## 📦 Estructura del Proyecto

```

m09asimetrics/
├── Signador.java        # Firma todos los archivos en una carpeta
├── Validador.java       # Verifica la firma de un archivo
├── key.jks              # Keystore codificado en Base64 (alias: fitxers)

````

## 🚀 Cómo usarlo

### 🖊️ Firmar archivos

1. Ejecuta `Signador.java`
2. Introduce la ruta de la carpeta con los archivos a firmar
3. Obtendrás por consola la firma en Base64 de cada archivo

```bash
java Signador
````

📥 Entrada: carpeta con archivos
📤 Salida: firmas mostradas en consola

---

### 🔍 Validar una firma

1. Ejecuta `Validador.java`
2. Introduce la ruta del archivo y la firma en base64
3. Te dirá si la firma es válida

```bash
java Validador
```

✅ Si es válida:

```
La firma es válida.
```

❌ Si no coincide:

```
ATENCIÓ - La firma NO es válida.
```

---

## 🔐 Keystore

* Archivo: `key.jks`
* Alias: `fitxers`
* Contraseña: `password`
* Formato: JKS codificado en Base64 (se decodifica automáticamente al cargar)

Puedes generar uno con:

```bash
keytool -genkeypair -alias fitxers -keyalg RSA -keystore key.jks -storepass password
```

(Después lo codificas en Base64 si deseas replicar el funcionamiento actual.)

---

## 🧰 Requisitos

* Java 8 o superior
* JDK instalado
* Un archivo `key.jks` válido con clave privada y certificado

---

## 💡 Mejoras futuras

* GUI con JavaFX o Swing
* Exportación automática de firmas a archivos `.sig`
* Verificación por lotes
* Logs o registro de firmas realizadas

---

## 📝 Licencia

MIT © \Pau

```

---
