create database reto3 collate utf8mb4_spanish_ci;
grant all on reto3.* to dam;
use reto3;

create table if not exists locale (

NIF char(9),
Propietario varchar(25),
Direccion varchar(30),
Nombre varchar(40) not null,
Tipo enum("Bar", "Restaurante", "Cafetería") not null,
constraint pk_locale primary key (NIF));

create table if not exists Producto (

Codigo char(5),
Nombre varchar(40) not null,
PrecioComp int not null,
PrecioVent int not null,
FechaCad date,
Tipo  enum("bebida","comida","otros"),
constraint pk_producto primary key (Codigo));

create table if not exists Transaccion (
NTrans int auto_increment,
FechaTrans date,
constraint pk_transaccion primary key (NTrans));

create table if not exists Venta (

NIF char(9),
Codigo char(5),
Stock int,

constraint pk_Venta primary key(NIF,Codigo),
constraint fk_NIF_Venta foreign key (NIF) references locale(NIF),
constraint fk_codigo_Venta foreign key (Codigo) references Producto (Codigo)
);

create table if not exists Contenido (

NTrans int ,
Codigo char(5),
Cantidad int,
PVP int,

constraint pk_Contenido primary key(NTrans,Codigo),
constraint fk_Contenido_Trans foreign key (NTrans) references Transaccion(NTrans),
constraint fk_Contenido_Codigo foreign key (Codigo) references Producto(Codigo)
);


create table if not exists Pedido (

NTrans int ,
Entrega varchar(40),
constraint pk_Pedido primary key (NTrans),
	constraint fk_Pedido foreign key (NTrans) references transaccion(NTrans));


create table if not exists Usuarios (

DNI char(9) ,
Nombre varchar(25),
Apellido varchar (15),
Contraseña varchar (20) not null,
NIFLocal char(9),

	constraint pk_Usuarios primary key (DNI),
constraint fk_NIF_Usuario foreign key (NIFLocal) references locale(NIF));


create table if not exists Factura (

NTrans int ,
NIFC char(9),
	constraint pk_Factura primary key (NTrans,NIFC),
	constraint fk_Factura_NTrans foreign key (NTrans) references Transaccion(NTrans),
    constraint fk_Factura_NIFC foreign key (NIFC) references Comprador(NIFC)

);


create table if not exists Comanda(
NTrans int ,
constraint pk_Comanda primary key (NTrans),
constraint fk_Comanda_NTrans foreign key (NTrans) references Transaccion(NTrans)

);


create table if not exists Plato(

Codigo char(5),
PVP int,
Nombre varchar(30),
Categoria enum("Primer plato","Segundo plato","Postre"),
Tipo enum("Normal", "Vegetariano", "Vegano"),

constraint pk_PlatosAdquiridos primary key (Codigo)

);

create table if not exists PlatosAdquiridos(

NTrans int ,
Codigo char(5),
PVP int,
Cantidad int,
constraint pk_PlatosAdquiridos primary key (NTrans,Codigo),
constraint fk_PlatosAdquiridos_NTrans foreign key (NTrans) references Transaccion(NTrans),
constraint fk_PlatosAdquiridos_Codigo foreign key (Codigo) references Plato (Codigo)

);

create table if not exists Carta(

codigoPlato char(5),
NIFLocal char(9),

constraint pk_Carta primary key (codigoPlato,NIFLocal),
constraint fk_Carta_codigoPlato foreign key (codigoPlato) references Plato(codigo),
constraint fk_Carta_NIFLocal foreign key (NIFLocal) references locale(NIF)

);

create table if not exists Ingrediente(

Nombre varchar(20),
Alergenos enum("Gluten","Mariscos","Frutos Secos"),
constraint pk_Ingrediente primary key (Nombre)

);


create table if not exists IngPlato(

NombreIng varchar(20),
codigoPlato char(5),

constraint pk_IngPlato primary key (NombreIng,codigoPlato),
constraint fk_IngPlato_NombreIng foreign key (NombreIng) references Ingrediente (Nombre),
constraint fk_IngPlato_codigoPlato foreign key (codigoPlato) references Plato (codigo)
);

create table if not exists Fabricante(

Nombre varchar(40),
Duracion int,
constraint pk_Fabricante primary key (Nombre)

);

create table if not exists Aprovisionamiento(

NTrans int ,
NomFabricante varchar(40),
Constraint pk_Aprovisionamiento primary key (NTrans),
constraint fk_Aprovisionamiento_NTrans foreign key (NTrans) references transaccion(NTrans),
constraint fk_Aprovisionamiento_NomFabricante foreign key (NomFabricante) references Fabricante(Nombre)



);

create table if not exists Comprador(

NIFC char(9),
ApellidoC varchar(15),
NombreC varchar(25),

constraint pk_Comprador primary key (NIFC)


);


insert into locale (NIF, Propietario, Direccion, Nombre, Tipo)
values ("06155050C","Ernesto","Avenida","Bar Ernesto","Bar"),
("29099031Y","Loli","Calleja","Restaurante Loli","Restaurante"),
("08038879B","Juan","Callejuela","Cafetería Juan","Cafetería");

insert into Usuarios (DNI,nombre,apellido,contraseña,NIFLocal)
values ("83651135C","Juan","Fernández","12345678","06155050C"),
("32137168G","Jose","Martínez","12345678","29099031Y"),
("91846396J","Unai","Montero","12345678","08038879B"),
("12312312Q","Gorka","Sagrario","123","08038879B");


insert into producto(Codigo,Nombre,PrecioComp,PrecioVent,Tipo)
values("1","kass","0","5","bebida"),
("2","cocacola","0","5","bebida"),
("3","cafe","0","5","bebida"),
("4","pintxos","0","5","comida"),
("5","pastel","0","5","comida"),
("6","pistachos","0","5","comida");







