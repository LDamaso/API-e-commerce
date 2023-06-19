create database Ecommerce;

use Ecommerce;
create table produto(
	idproduto serial primary key,
	nomeproduto varchar(50) unique not null,
	preco double not null,
	qtdproduto int
)

select * from produto;