const express = require('express');
const bodyParser = require('body-parser');

const app = express();

app.use(bodyParser.json());

app.post('/login', (req, res) => {
    const { body } = req;
    console.log('Datos recibidos en el login:', body);

    res.status(200).json({ message: 'Datos recibidos', received: body });
});

const puerto = 3001;

app.listen(puerto, () => {
    console.log(`Servidor en funcionamiento en el puerto ${puerto}`);
  });
  