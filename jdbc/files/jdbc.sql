use master
go
if(DB_ID('jdbc') is not null) 
	drop database jdbc
go
create database jdbc
go
use jdbc
go

/*���ű�*/
create table TbDept
(
	deptId int identity primary key not null,/*���ű�ţ�����*/
	deptName nvarchar(50) unique not null,/*�������ƣ�������������ͬ��*/
	deptInfo nvarchar(500) not null, /*����������������д*/
	created datetime default getdate() /*����ʱ�䣬Ĭ���Ǽ�¼��ӵ�ʱ��*/
)
go

/*��ѯTbDept���е�ȫ����¼*/
select * from TbDept
go

/*��Ӽ�¼�����*/
insert into TbDept(deptName,deptInfo) values('������','����Գ�Ĳ���')
insert into TbDept(deptName,deptInfo,created) 
	values('���²�','ѹեԱ�����ʵĲ���','2010-10-10')
go

/*�޸�idΪ1�ļ�¼*/
update TbDept set created='2011-09-19',deptInfo='����Գ�Ĳ��Ű�'
where deptId=1
go

/*ɾ��ָ��id�ļ�¼*/
delete from TbDept where deptId=2
go



