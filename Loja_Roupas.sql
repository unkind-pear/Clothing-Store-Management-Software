create database loja_roupas;
use loja_roupas;

create table camisetas(
	cod int auto_increment,
    preco double,
    tamanho char,
    cor varchar(25),
    check(tamanho="P" or tamanho="M" or tamanho="G"),
    primary key(cod)
);

create table calcas(
	cod int auto_increment,
    preco double,
    tamanho int,
    tipo varchar(5),
    check(tamanho>35 and tamanho<47 and mod(tamanho, 2)=0),
    primary key(cod)
);

create table vestidos(
	cod int auto_increment,
    preco double,
    estampa varchar(10),
    tipo varchar(20),
    primary key(cod)
);

create table clientes(
	cod int auto_increment,
    nome varchar(120),
    primary key(cod)
);

create table loja(
	cod int auto_increment,
    nome varchar(120),
    endereco varchar(180),
    primary key(cod)
);

create table produtosComprados(
	cod int auto_increment,
    codCliente int,
    produto varchar(150),
    foreign key(codCliente) references clientes(cod),
    primary key(cod)
);