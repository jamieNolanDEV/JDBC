
drop table videoGames ;
drop table purchases;
drop table empstore;
drop table Employee ;
drop table Store;


DROP sequence sId_seq;
DROP sequence eId_seq;
DROP sequence vId_seq;
DROP sequence pId_seq;



create table Store(
storeId number primary key,
StoreLocation varchar2(255),
StoreName varchar2(255)
);

create table employee(
empId number primary key,
empFName varchar(255),
empLName varchar (255),
STARTDATE DATE
);

create table EMPSTORE (
    EID INTEGER,
    SID INTEGER,
    PRIMARY KEY (EID, SID),
    FOREIGN KEY (EID) REFERENCES EMPLOYEE (EMPID) ,
    FOREIGN KEY (SID) REFERENCES STORE (STOREID) 
);


create table purchases(
purchaseid number PRIMARY KEY
);


create table videoGames(
GameId number primary key,
gameName varchar(255),
price number,
pidd number,
FOREIGN KEY (pidd) REFERENCES purchases (purchaseid)
);



create sequence pId_seq increment by 1 start with 1;
create sequence vId_seq increment by 1 start with 1;
create sequence eId_seq increment by 1 start with 1;
create sequence sId_seq increment by 1 start with 1;

