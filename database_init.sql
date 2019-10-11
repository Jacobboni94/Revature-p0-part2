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

create or replace procedure project0_test.update_owner(myVin text, newOwner text)
	language sql	
	as $$
	update project0_test.car_table set username = newOwner where vin = myVin;
	$$;
	
call update_owner('4S3BK4355T6319316', 'Roberto');
drop procedure updateOwner(text, text);