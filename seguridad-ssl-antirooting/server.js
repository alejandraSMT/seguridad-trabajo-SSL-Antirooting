const https = require("https");
const fs = require("fs");
const express = require('express');
const bodyParser = require('body-parser');

const app = express();

app.use(bodyParser.json());

const options = {
    key: fs.readFileSync("./certs/localhost_android.key"),
    cert: fs.readFileSync("./certs/localhost_android.crt"),
};

app.post('/login', (req, res) => {
    const { body } = req;
    console.log('Datos recibidos en el login:', body);

    res.status(200).json({ message: 'Datos recibidos', received: body });
});


https.createServer(options, app).listen(3001, () => {
    console.log("Servidor HTTPS escuchando en https://localhost:3001");
});
