
markdown
Copiar
Editar
# File Signer and Verifier (Java)

This Java application allows you to digitally **sign** and **verify** files using RSA encryption. It operates with a local keystore (`.jks`) for key management, and Base64 encoding for signature output.

## Getting Started

Follow these steps to compile and run the application:

1. Clone or download this repository.

2. Open the project in your favorite Java IDE.

3. Compile the following files:
   - `Signador.java`
   - `Validador.java`

4. Make sure the `key.jks` file is in the root directory of the project.

## Usage

### Signing Files

Run the `Signador` program to sign files in a folder:

```bash
java Signador
You will be prompted to enter the path to a folder.

The program will read all files and generate a Base64-encoded digital signature for each.

After signing, you can choose whether to sign more files.

Verifying a Signature
Run the Validador program to verify the integrity of a file:

bash
Copiar
Editar
java Validador
Enter the path to the file you want to verify.

Enter the Base64-encoded signature.

The program will validate it using the public key stored in the keystore.

Keystore Details
File: key.jks

Alias: fitxers

Password: password

To generate your own keystore:

bash
Copiar
Editar
keytool -genkeypair -alias fitxers -keyalg RSA -keystore key.jks -storepass password
Requirements
Java 8 or higher

key.jks keystore file in the project root directory

Notes
The key.jks file is expected to be Base64-encoded and will be decoded before loading.

The project uses SHA256withRSA as the signature algorithm.

Both signing and verification are done using native Java KeyStore, Signature, and Base64 libraries.

Contributing
Pull requests and suggestions are welcome. Feel free to fork this repo and improve it!

License
MIT © Pau
