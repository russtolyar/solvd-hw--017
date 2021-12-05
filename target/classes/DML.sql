use restaurantdb;

Insert into Restaurants (name, date_Of_Foundation) values 
('Falcone', str_to_date('01-01-2020','%d-%m-%Y')),
('Bela Rossa', str_to_date('09-08-2020','%d-%m-%Y'));
 
 insert into Passports (number, expire_date) values
 ('10001', str_to_date('01-01-2025','%d-%m-%YYYY')),
 ('10002', str_to_date('02-05-2026','%d-%m-%YYYY')),
 ('10003', str_to_date('20-08-2027','%d-%m-%YYYY')),
 ('10004', str_to_date('14-07-2028','%d-%m-%YYYY')),
 ('10005', str_to_date('15-03-2029','%d-%m-%YYYY')),
 ('10006', str_to_date('29-10-2022','%d-%m-%YYYY')),
 ('10007', str_to_date('30-11-2023','%d-%m-%YYYY'));
 
 insert into Addresses (city, street, house, flat) values
 ('Minsk', 'Zhukov', 1, 100),
 ('Fanipol', 'Sovet', 2, 5),
 (' ', 'Zhukov', 8, 9),
 ('Zaslavl', 'Dachnaya', 4, 50),
 ('Drozdy', 'Levaya', 5, 30),
 ('Minsk', 'Centr', 6, 55),
 ('Minsk', 'Grusheva', 7, 22),
 ('Minsk', 'Usataya', 8, 47),
 ('Minsk', 'Krasnaya', 9, 90),
 ('Minsk', 'Sinyaya', 11, 101);
 
 insert into Employees (passport_id, address_id, first_name, last_name, position, department) values
 (1, 3, 'Ivan', 'Ivanov', 'cook', 'kitchen'),
 (2, 5, 'Ilya', 'Iliyn', 'chif', 'kitchen'),
 (3, 7, 'Petya', 'Petrov', 'helper', 'kitchen'),
 (5, 1, 'Vasya', 'Vasin', 'boss', 'administration'),
 (4, 9, 'Sidor', 'Sidorov', 'cleaner', 'kitchen');
 
 insert into Kitchens (restaurant_id) values
 (1), (2);
 
 insert into Kitchen_employees (kitchen_id, employee_id) values
 (1, 1), (1, 2), (1, 3), (1, 5);
 
 insert into Staff (kitchen_id, name, type) values
 (1, 'FRIGE', 'equipment'),
 (1, 'table', 'furniture'),
 (1, 'knife', 'tool'),
 (1, 'micromave', 'equipment'),
 (1, 'mixer', 'tool'),
 (1, 'boiler', 'equipment');
 
 insert into Products (staff_id, name) values
 (1, 'eggs'),
 (1, 'meat'),
 (1, 'chiken'),
 (1, 'tomato'),
 (1, 'spices'),
 (1, 'potato'),
 (1, 'apple'),
 (1, 'beaf'),
 (1, 'oil'),
 (1, 'carrot');
 
 insert into Menues (restaurant_id, type) values
 (1,'toDrink'),
 (1,'toEat');
 
 insert into Drinks (menu_id, name, isAlcoholic) values
 (1, 'milkShake', false),
 (1, 'tea', false),
 (1, 'coffee', false),
 (1, 'water', false),
 (1, 'cognac', true),
 (1, 'vodka', true),
 (1, 'b52', true),
 (1, 'vino', true),
 (1, 'beer', true),
 (1, 'cola', false);
 
 insert into Dishes (menu_id, name, type) values
 (2, 'vegetabls', 'vegan'),
 (2, 'fried beaf', 'normal'),
 (2, 'boiled potato', 'vegan'),
 (2, 'fried eggs', 'vegetarian'),
 (2, 'pizza', 'vegan'),
 (2, 'pizza with sausages', 'normal'),
 (2, 'baked chiken', 'normal');

 insert into Clients (address_id, dob, name) values
 (2, str_to_date('10-10-2000','%d-%m-%Y'), 'Olya'),
 (4, str_to_date('11-11-1995','%d-%m-%Y'), 'Taya'),
 (6, str_to_date('12-12-1990','%d-%m-%Y'), 'Ira'),
 (8, str_to_date('05-05-2005','%d-%m-%Y'), 'Dima');

insert into Client_dishes (client_id, dish_id) values
(1, 1),
(1, 4),
(2, 5),
(3, 6),
(4, 7),
(4, 3);

insert into Client_drinks (client_id, drink_id) values
(1, 2),
(2, 4),
(3, 6),
(4, 8);

insert into Restaurant_clients (restaurant_id, client_id) values 
(1, 1),
(1, 2),
(1, 4);


