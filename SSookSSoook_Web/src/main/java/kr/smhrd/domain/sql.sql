create table springboard(
	idx number not null,
	title varchar2(100) not null,
	content varchar2(2000) not null,
	writer varchar2(20) not null,
	indate date default sysdate,
	count number default 0,
	constraint pk_sb primary key(idx)
	
);


create sequence sboard_seq
start with 1
increment by 1
maxvalue 100
cycle
nocache;

insert into springboard(idx,title,content,writer) values (sboard_seq.nextval, '제목1', '내용1', '관리자');
insert into springboard(idx,title,content,writer) values (sboard_seq.nextval, '제목2', '내용2', '강예진');

select * from SPRINGBOARD

select * from web_member;
select * from member;

create table T_Member(
	idx number not null,
	name varchar2(100) not null,
	Nick varchar2(2000) not null,
	email varchar2(20) not null,
	address varchar2(20) not null,
	indate date default sysdate,
	constraint pk_test_idx primary key(idx)
);

create sequence TMember_seq
start with 1
increment by 1
maxvalue 100
cycle
nocache;

create table product(
	product_id number,
	product_name varchar2(50),
	product_price number Default 0,
	product_desc varchar2(500),
	product_url varchar2(500),
	primary key(product_id)
	);
	

select * from product;