drop table if exists USER_TBL;
drop table if exists CUSTOMER_TBL;
drop table if exists ACCOUNT_TBL;

create table USER_TBL(
	USER_ID integer identity primary key,
	FK_CUSTOMER_ID integer not null,
	USERNAME varchar(100) not null,
	PASSWORD varchar(100) not null
);

create table CUSTOMER_TBL(
	CUSTOMER_ID integer identity primary key,
	NAME varchar(100) not null,
	LAST_NAME varchar(100) not null
);

create table ACCOUNT_TBL(
	ACCOUNT_ID integer identity primary key,
	FK_CUSTOMER_ID integer not null,
	ACCOUNT_NUMBER varchar(16) not null,
	CREATED_DATE timestamp not null,
	BALANCE decimal(20,4) not null
);

/* MYSQL
DELIMITER //
CREATE PROCEDURE read_customer_user (
    IN in_customerId INTEGER,
    OUT out_user_id integer,
    OUT out_customer_id integer,
    OUT out_username VARCHAR(100),
    OUT out_password VARCHAR(100),
    OUT out_name VARCHAR(100),
    OUT out_last_name VARCHAR(100))
BEGIN
    SELECT USER_ID, CUSTOMER_ID, USERNAME, PASSWORD, NAME, LAST_NAME  
    INTO out_user_id, out_customer_id, out_username, out_password, out_name, out_last_name  
    FROM USER_TBL, CUSTOMER_TBL  WHERE CUSTOMER_ID = FK_CUSTOMER_ID AND CUSTOMER_ID = in_customerId;
END //
DELIMITER ;
*/
