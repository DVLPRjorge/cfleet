create database BDProyecto;
use BDProyecto;

create table marcaVehiculo(
idMarca int primary key auto_increment,
nombreMarca varchar(50) not null
);

create table tipoVehiculo(
idtipoVehiculo int primary key auto_increment,
nombretipoVehiculo varchar(50) not null
);

create table estatusVehiculo(
idEstatus int primary key auto_increment,
estatus varchar(50) not null
);

create table Vehiculo(
idVehiculo int primary key auto_increment,
nombre varchar(70) not null,
marca int,
foreign key (marca) references marcaVehiculo(idMarca),
modelo varchar(50) not null,
año int not null,
tipoVehiculo int,
foreign key (tipoVehiculo) references tipoVehiculo(idtipoVehiculo),
estatus int,
foreign key (estatus) references estatusVehiculo(idEstatus),
kilometraje int not null,
noSerie varchar(17) not null,
placa varchar(9) not null,
color varchar(30) null,
compañiaSeguro varchar(50) null,
polizaSeguro varchar(50) null
);

create table TipoUsuario(
 idTipoUsuario int primary key auto_increment,
 descripcion varchar(50) not null
 );

create table Usuario(
 idUsuario int primary key auto_increment,
 nombre varchar(100),
 user varchar(15) not null,
 pwd varchar(15) not null,
 idTipoUsuario int,
 foreign key (idTipoUsuario) references Tipousuario(idTipoUsuario),
 estatus int not null
 );
 
 create table CargaCombustible(
 idVehiculo int,
 primary key (idVehiculo),
 foreign key (idVehiculo) references Vehiculo(idVehiculo),
 fechaCarga date not null,
 horaCarga time not null,
 referencia varchar(50),
 cantidadCombustible double not null,
 costoUnitario double not null
 );
 
 create table Operador(
 idOperador int primary key auto_increment,
 nombre varchar(30) not null,
 paterno varchar(30) not null,
 materno varchar(30) null,
 direccion varchar(70)
 );
 
 create table OperadorVehiculo(
 idOperador int,
 primary key(idOperador),
 foreign key(idOperador) references Operador(idOperador),
 vehiculoAsignado int,
 foreign key (vehiculoAsignado) references Vehiculo(idVehiculo),
 fecha datetime not null
 );
 
 
 
-- Insertar Registros 
insert into marcaVehiculo (nombreMarca)
values ('Chevrolet');
insert into marcaVehiculo (nombreMarca)
values ('Dodge');
insert into marcaVehiculo (nombreMarca)
values ('Ford');
insert into marcaVehiculo (nombreMarca)
values ('Nissan');
insert into marcaVehiculo (nombreMarca)
values ('Peugeot');
insert into marcaVehiculo (nombreMarca)
values ('VW');

insert into tipoVehiculo (nombretipoVehiculo)
values ('Autobus');
insert into tipoVehiculo (nombretipoVehiculo)
values ('Automovil');
insert into tipoVehiculo (nombretipoVehiculo)
values ('Camion');
insert into tipoVehiculo (nombretipoVehiculo)
values ('Camioneta');
insert into tipoVehiculo (nombretipoVehiculo)
values ('SUV');
insert into tipoVehiculo (nombretipoVehiculo)
values ('Trailer');
insert into tipoVehiculo (nombretipoVehiculo)
values ('Van');

insert into estatusVehiculo (estatus)
values ('Disponible');
insert into estatusVehiculo (estatus)
values ('En Taller');
insert into estatusVehiculo (estatus)
values ('Fuera de Servicio');
insert into estatusVehiculo (estatus)
values ('Ocupado'); 

insert into tipoUsuario (descripcion)
values ('Administrador'); 
insert into tipoUsuario (descripcion)
values ('Usuario Normal'); 

insert into Usuario (nombre,user,pwd,idTipoUsuario,estatus)
values ('Isayanet Segura Urbano','Isa','2203',1,1); 
insert into Usuario (nombre,user,pwd,idTipoUsuario,estatus)
values ('Lizeth Alejandra Correa Segura','LizA','la1306',2,1); 



-- Sentencias DROP: Para borrar 
drop table operador;
drop table tipousuario;
drop table usuario;
drop table Vehiculo;
drop table cargacombustible;
drop table operadorvehiculo;


-- Sentencias SELECT
select * from Usuario;
select * from tipousuario;
select * from estatusvehiculo;

------------------

select idUsuario,nombre,user,pwd,tipousuario.descripcion,estatus
from usuario
inner join tipousuario on usuario.idTipoUsuario=tipousuario.idTipoUsuario;


select vh.idVehiculo,nombre,mv.nombreMarca,modelo,año,tv.nombretipoVehiculo,ev.estatus,kilometraje,noSerie,placa,color,compañiaSeguro,polizaSeguro
from vehiculo vh
inner join marcavehiculo mv on mv.idMarca=vh.marca
inner join tipovehiculo tv on tv.idtipoVehiculo=vh.tipoVehiculo
inner join estatusvehiculo ev on ev.idEstatus=vh.estatus
order by 1









 