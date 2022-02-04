# kanban
Tablero kanban

![Image text](https://github.com/yipson/kanban/blob/master/arquitectura-microservices.png)


El proyecto consta de 6 microservicios:
- users: encargado de la comunicacion de la entidad users con la base de datos, el cual cuenta con 3 controladores los cuales responde a peticiones de registro de usuarios, buscar un usuario por su id y login. 
- tasks: encargado de la comunicacion de la entidad tasks con la base de datos, cuanta con 6 controladores los cuales responden a peticiones de CRUD (las peticiones correspondientes a READ son 3, tasksByUserId, listTasks y getOneTask). 
- board: encargado de consumir una API del servicio users (getOneUser) y otra del servicio tasks (tasksByUserId), para poder exponer un API correspondiente a la pantalla principal del usuario en la cual se puede ver su nombre y las tareas asociadas a su id.
- auth: encargado de brindar el servicio de verificacion de sesion el cual nos indica si el token con el que se esta navegando aun se encuantra vigente.
- eurekaserver: encargado de registrar todos los servicios en un lugar centralizado y brindar balanceo de cargas
- api gateway: este servicio se encarga de recibir todas las peticiones del cliente.
Para el consumo de APIs entre microservicios se uso la libreria de feign la cual por medio de los controladores nos permitia consumir servicios.
Adicionalmente se crea un servicio capaz de centralizar la configuracion de cada uno de los microservicios en un repositorio git
La desicion que se tomo de independizar las entidades se debe a se parar las responsabilidades de los servicios lo cual hace de un codigo mas limpio y mantenible. Asi mismo el servicio de auth a pezar de ser muy sencillo, tiene la responsabilidad de verificar la sesion manejada en cada una de las peticiones de todos los microservicios asi que si se requiere una o mas instancias de este servicio sera mas facil y ligero de hacer.

Base de datos:
Se hace uso del motor de base de datos MySQL en el cual se crean 2 entidades user y task las cuales se relaciononan por medio del id_user en la tabla tasks
al pasar todas las peticiones por nuestro servicio gateway, este contiene todas las uris necesarias para acceder a los diferentes servicios

localhost:8765/login
localhost:8765/user/register
localhost:8765/board/{userId}
localhost:8765/task/{taskId} (GET, POST, DELETE)
localhost:8765/task (POST)
localhost:8765/task/user/{userID} (GET)

script-database:
CREATE DATABASE kanban

CREATE TABLE user (
id bigint auto_increment,
name varchar(80) not null,
last_name varchar(80) not null,
email varchar(80) unique not null,
password varchar(255) not null,
PRIMARY KEY (id)
);

CREATE TABLE task(
id bigint auto_increment,
description varchar(255) not null,
status varchar(50) not null,
id_user bigint,
PRIMARY KEY (id)
);

ALTER TABLE task
ADD CONSTRAINT fk_user_task
FOREIGN KEY (id_user) REFERENCES user (id);
