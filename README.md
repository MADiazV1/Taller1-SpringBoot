# Gestión de Métodos de Pago

Este programa permite gestionar métodos de pago (tarjetas de crédito o débito), proporcionando funcionalidades para crear y eliminar tarjetas registradas.

## Clonar el repositorio

```
git clone https://github.com/MADiazV1/Taller1-SpringBoot.git
```

## Configurar Docker

Primero creamos una red

```
docker network create mynetwork
```

Dentro del documento <strong>docker-compose.yaml</strong> vas a configurar la contraseña de la base da datos que se va a configurar en el contenedor.

```
MYSQL_ROOT_PASSWORD: <mi-contraseña>
```

Ejecutamos el siguiente comando para crear el contenedor de la base de datos.

```
docker-compose up -d
```

## Ejecución

Para ejecutar el programa debes de usar el siguiente comando.

```
mvn spring-boot:run
```

Y el programa se estara ejecutando en 'localhost:8080'.