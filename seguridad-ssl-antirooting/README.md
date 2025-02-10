# Herramientas

1. OpenSSL
2. Python
3. Frida - https://frida.re/
4. objection - https://github.com/sensepost/objection
5. Gentymotion - https://www.genymotion.com/product-desktop/download/
6. Android Studio

Crear SSL certificate
```cmd
openssl req -x509 -out localhost_android.crt -keyout localhost_android.key -newkey rsa:2048 -days 1024 -nodes -sha256 -subj "/C=US/O=Dev-Certificate/CN=Seguridad" -extensions EXT -config config.txt
```