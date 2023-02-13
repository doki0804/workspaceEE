
insert into userinfo(user_id,user_password,user_name,user_phone,user_email,user_address) values('test1','1111','김경호1','guard1@korea.com');
insert into userinfo(user_id,user_password,user_name,user_phone,user_email,user_address) values('test2','2222','김경호2','guard2@korea.com');
insert into userinfo(user_id,user_password,user_name,user_phone,user_email,user_address) values('test3','3333','김경호3','guard3@korea.com');

--pk update
update  userinfo 
set password='1111',name='이름변경',email='change@naver.com' 
where userid='guard1';
--pk delete
delete userinfo where userid='guard1';

--select pk
select userid,password,name,email from userinfo where userid='guard2';

--select all
select userid,password,name,email from userinfo;

--select count by userid
select count(*) cnt from userinfo where userid='guard1'; 
select count(*) cnt from userinfo where userid='guard2'; 




commit;