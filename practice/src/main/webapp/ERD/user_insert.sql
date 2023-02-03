/*
이름            널?       유형            
------------- -------- ------------- 
USER_ID       NOT NULL VARCHAR2(20)  
USER_PASSWORD NOT NULL VARCHAR2(20)  
USER_NAME     NOT NULL VARCHAR2(20)  
USER_PHONE    NOT NULL VARCHAR2(20)  
USER_EMAIL    NOT NULL VARCHAR2(50)  
USER_ADDRESS           VARCHAR2(100) 
*/

insert into userinfo(user_id,user_password,user_name,user_phone,user_email,user_address) 
    values('test1',
            '1111',
            '테스터',
            '010-1111-1111',
            'test@gmail.com','서울시 강남구');
insert into userinfo(user_id,user_password,user_name,user_phone,user_email,user_address) 
    values('test2',
            '2222',
            '테스터2',
            '010-2222-2222',
            'test2@gmail.com','서울시 강남구');
insert into userinfo(user_id,user_password,user_name,user_phone,user_email,user_address) 
    values('test3',
            '3333',
            '테스터3',
            '010-3333-3333',
            'test3@gmail.com','서울시 강남구');

-- update 
update userinfo set user_name = '테스트',user_phone=010-2222-2222;








