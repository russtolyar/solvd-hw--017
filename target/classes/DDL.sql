drop database if exists restaurantdb;

create database if not exists restaurantdb;
use restaurantdb;

create table if not exists Restaurants(
id serial,
name varchar(45) not null,
date_Of_Foundation date not null,
primary key(id)
);

create table if not exists Passports (
id serial,
number varchar(45) not null,
expire_date timestamp,
primary key(id)
);

create unique index uniqe_idx_passport_number on Passports(number);

create table if not exists Addresses(
id serial,
city varchar(45) not null,
street varchar(45) not null,
house int unsigned not null,
flat int unsigned not null,
primary key(id)
);

create table if not exists Employees(
id serial,
passport_id bigint unsigned not null,
address_id bigint unsigned not null,
first_name varchar(45) not null,
last_name varchar(45) not null,
position varchar(45) not null,
department varchar(45) not null,
primary key(id),
constraint fk_employees_passport_id foreign key (passport_id) references Passports(id) 
on update no action 
on delete cascade,
constraint fk_employees_address_id foreign key (address_id) references Addresses(id)
on update no action
on delete cascade
);

create unique index uniqe_idx_employees_passport_number on Employees(passport_id);
create index uniqe_idx_employees_first_name on Employees(first_name);

create table if not exists Kitchens(
id serial,
restaurant_id bigint unsigned not null,
primary key(id),
constraint fk_kitchens_restaurant_id foreign key (restaurant_id) references Restaurants(id)
on update no action
on delete cascade
);

create table if not exists Kitchen_employees (
id serial,
kitchen_id bigint unsigned not null,
employee_id bigint unsigned not null,
primary key(id),	
constraint fk_kitchen_employees_kitchen_id foreign key (kitchen_id) references Kitchens(id)
on update no action
on delete cascade,
constraint fk_kitchen_employees_employee_id foreign key (employee_id) references Employees(id)
on update no action
on delete cascade
);

create table if not exists Staff(
id serial,
kitchen_id bigint unsigned not null,
name varchar(45) not null,
type varchar(45) not null,
primary key(id),
constraint fk_staff_kitchen_id foreign key(kitchen_id) references Kitchens(id)
on update no action
on delete cascade
);

create table if not exists Products(
id serial,
staff_id bigint unsigned not null,
name varchar(45) not null,
primary key(id),
constraint fk_products_staff_id foreign key (staff_id) references Staff(id)
on update no action
on delete cascade
);

create table if not exists Menues(
id serial,
restaurant_id bigint unsigned not null, 
type varchar(45) not null,
primary key(id),
constraint fk_menues_restaurant_id foreign key(restaurant_id) references Restaurants(id)
on update no action
on delete cascade 
);


create table if not exists Drinks (
id serial,
menu_id bigint unsigned not null,
name varchar(45) not null,
isAlcoholic boolean not null,
primary key(id),
constraint fk_drinks_menu_id foreign key (menu_id) references Menues(id)
on update no action
on delete cascade
);

create table if not exists Dishes(
id serial,
menu_id bigint unsigned not null,
name varchar(45) not null,
type varchar(45) not null,
primary key(id),
constraint fk_dishes_menu_id foreign key (menu_id) references Menues(id)
on update no action
on delete cascade
);

create table if not exists Clients(
id serial,
address_id bigint unsigned not null,
dob timestamp not null,
name varchar(45) not null,
primary key(id),
constraint fk_clients_address_id foreign key(address_id) references Addresses(id)
on update no action 
on delete cascade 
);

create table if not exists Client_dishes (
id serial,
client_id bigint unsigned not null,
dish_id bigint unsigned not null,
primary key(id),
constraint fk_client_dishes_client_id foreign key (client_id) references Clients(id)
on update no action
on delete cascade
);

create table if not exists Client_drinks (
id serial,
client_id bigint unsigned not null,
drink_id bigint unsigned not null,
primary key(id),
constraint fk_client_drinks_client_id foreign key (client_id) references Clients(id)
on update no action
on delete cascade
);
	

create table if not exists Restaurant_clients(
id serial,
restaurant_id bigint unsigned not null,
client_id bigint unsigned not null,
primary key(id),
constraint fk_restaurant_clients_restaurant_id foreign key(restaurant_id) references Restaurants(id)
on update no action
on delete cascade,
constraint fk_restaurant_clients_client_id foreign key(client_id) references Clients(id)
on update no action
on delete cascade
);
