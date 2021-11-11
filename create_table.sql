create database db_estoque;
use db_estoque;
create table produtos(
id int primary key auto_increment,
decricao varchar(50) not null,
preco double not null,
estoque int not null

);