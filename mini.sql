conn system/System1234;
create user mini identified by mini1234;
grant connect, resource to mini;
alter user mini identified by mini1234 account unlock;

conn mini/mini1234;


create table users(
userId varchar2(15) not null primary key,
userPw varchar2(30) not null,
userName varchar2(15) not null,
email varchar2(30),
nickName varchar2(15) not null,
phoneNumber varchar2(12) not null,
address varchar2(2000) not null
);

create table article(
postNo int not null primary key,
writer varchar2(15) not null,
title varchar2(100) not null,
content varchar2(1000),
writeDate date not null,
viewCount int not null,
constraint fk_writer foreign key(writer)
references users(userId)
);

