use master
go
if(DB_ID('shop') is not null)
	drop database shop
go
create database shop
go
use shop
go
create table TbGoods
(
	gid int identity primary key not null,
	gname nvarchar(50) unique not null,
	ginfo nvarchar(500) not null,
	price decimal(10,2) check(price>=0) not null,
	amount int check(amount>=0) not null
)
go
select * from TbGoods
go
	