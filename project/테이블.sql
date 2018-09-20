create table board(
num int not null primary key , --각 게시판 글들을 구분하는 값
writer varchar2(10) not null, -- 작성자 이름
email varchar2(30), 
subject varchar2(50) not null,-- 글제목
passwd varchar2(12) not null,
reg_date timestamp(6) not null,--글 작성일
readcount NUMBER default 0,--조회수
ref NUMBER not null,-- 관련글 번호
re_step NUMBER not null, -- 동일한 관련글 번호를 가진 글 중 출력순서
re_level NUMBER not null, -- 답글 레벨
content varchar2(4000) not null, -- 글내용
ip varchar2(20) not null -- 클라이언트 IP
);

CREATE SEQUENCE board_seq;









