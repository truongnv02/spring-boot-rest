use master
go

create database send_mail
go

use send_mail
go

create table users (
	[id] bigint primary key identity(1,1),
	[name] nvarchar(255),
	[email] nvarchar(255),
	[password] nvarchar(100),
	[active] bit default 0,
	[otp] nvarchar(20),
	[optGeneratedTime] datetime
);
go

select * from users