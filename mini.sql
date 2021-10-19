conn system/System1234;
create user mini identified by mini1234;
grant connect, resource to mini;
alter user mini identified by mini1234 account unlock;

conn mini/mini1234;

drop sequence idx_seq;

CREATE SEQUENCE idx_seq
     MINVALUE 1
     MAXVALUE 999999
     START WITH 1
     INCREMENT BY 1
     CACHE 20;


drop table users cascade constraints;
drop table board_news;
drop table board_free;
drop table board_tip;
drop table board_qna;
drop table board_job;

create table users(
userId varchar2(15) not null primary key,
userPw varchar2(30) not null,
userName varchar2(15) not null,
email varchar2(30),
nickName varchar2(15) not null,
phoneNumber varchar2(12) not null,
address varchar2(2000) not null,
profileImgLoc varchar2(100),
admin varchar2(2)
);

create table board_news(
postNo int not null primary key,
writer varchar2(15) not null,
title varchar2(100) not null,
content varchar2(1000),
writeDate date not null,
viewCount int not null,
imgLoc varchar2(100),
constraint fk_writer_news foreign key(writer)
references users(userId)
);

create table board_free(
postNo int not null primary key,
writer varchar2(15) not null,
title varchar2(100) not null,
content varchar2(1000),
writeDate date not null,
viewCount int not null,
constraint fk_writer_free foreign key(writer)
references users(userId)
);
create table board_tip(
postNo int not null primary key,
writer varchar2(15) not null,
title varchar2(100) not null,
content varchar2(1000),
writeDate date not null,
viewCount int not null,
constraint fk_writer_tip foreign key(writer)
references users(userId)
);
create table board_qna(
postNo int not null primary key,
writer varchar2(15) not null,
title varchar2(100) not null,
content varchar2(1000),
writeDate date not null,
viewCount int not null,
constraint fk_writer_qna foreign key(writer)
references users(userId)
);
create table board_job(
postNo int not null primary key,
writer varchar2(15) not null,
title varchar2(100) not null,
content varchar2(1000),
writeDate date not null,
viewCount int not null,
constraint fk_writer_job foreign key(writer)
references users(userId)
);

insert into users values ('(알수없음)', '(알수없음)', '(알수없음)', '(알수없음)', '(알수없음)', '(알수없음)', '(알수없음)', null, 'Y');
