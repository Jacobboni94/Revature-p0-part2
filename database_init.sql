create table project0_test.Payment_table (
	payment_id serial primary key,
	username varchar(20),
	vin varchar(17) ,
	amount numeric(8, 2)
	);
	
create table project0_test.Car_table(
	vin varchar(17) primary key,
	username varchar(16),
	price numeric(8,2)
	);
	
create table project0_test.Offer_table(
	offer_id serial primary key,
	vin varchar(17),
	username varchar(16),
	amount numeric(8, 2),
	status varchar(8)
	);
	
create table project0_test.user_table(
	username varchar(16) primary key,
	password varchar(16),
	type varchar(8)
	);
	
insert into user_table ("username", "password", "type") values ('dealership', 'admin', 'employee');
delete from user_table where password = 'password';
insert into car_table (vin, username, price) values ('JH4DA3450JS001899', 'Jacob', 22000);
insert into car_table (vin, username, price) values ('JH4KA4576KC031014', 'Jacob', 37500);
insert into car_table (vin, username, price) values ('JH4DA9360PS004131', 'Jacob', 86521);

select * from car_table where username = 'Jacob';
select * from offer_table where username = 'Jacob';

