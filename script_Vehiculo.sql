create table vehiculo(
	placa varchar(10) primary key,
	marca varchar(50) not null,
	modelo varchar(50) not null,
	anio int not null,
	precio decimal not null,
	color varchar(30),
	disponible boolean not null
);
alter table vehiculo add kilometraje int;
select * from vehiculo