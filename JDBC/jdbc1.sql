use jdbcprac1;
drop table userinfo;
create table userinfo (
	uname varchar(10) not null,
    uid varchar(20) primary key,
    upw varchar(20) not null,
    uemail varchar (20)
);

-- 유저 4명을 넣어주세요
-- 2명은 이메일을 넣어주시고 2명은 넣지말아주세요
INSERT INTO userinfo (uname, uid, upw) VALUE("김모씨", "kim01", "kim");
INSERT INTO userinfo VALUES("안모씨", "an01", "an", "an@naver.com");
INSERT INTO userinfo VALUES ("박모씨", "park01", "park", null);
INSERT INTO userinfo VALUES("이모씨", "lee01", "lee", "lee@naver.com");

select * from userinfo;