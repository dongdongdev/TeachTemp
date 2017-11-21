use master
go
if(DB_ID('jdbc') is not null) 
	drop database jdbc
go
create database jdbc
go
use jdbc
go

/*部门表*/
create table TbDept
(
	deptId int identity primary key not null,/*部门编号，主键*/
	deptName nvarchar(50) unique not null,/*部门名称，不能有两个相同的*/
	deptInfo nvarchar(500) not null, /*部门描述，必须填写*/
	created datetime default getdate() /*创建时间，默认是记录添加的时间*/
)
go

/*查询TbDept表中的全部记录*/
select * from TbDept
go

/*添加纪录的语句*/
insert into TbDept(deptName,deptInfo) values('开发部','程序猿的部门')
insert into TbDept(deptName,deptInfo,created) 
	values('人事部','压榨员工工资的部门','2010-10-10')
go

/*修改id为1的记录*/
update TbDept set created='2011-09-19',deptInfo='程序猿的部门啊'
where deptId=1
go

/*删除指定id的记录*/
delete from TbDept where deptId=2
go



