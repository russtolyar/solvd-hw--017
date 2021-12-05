use restaurantdb;

/*
*Выбор всех столбцов и строк в таблице Restaurants
*/
Select * from Restaurants;

Select id, name, date_Of_Foundation from Restaurants;

/*
*Выбор всех столбцов и строк в таблице Restaurants с переиноменованием полей
*/
Select id as restaurant_id, name as restaurant_name, date_Of_Foundation as started_at from Restaurants;

/*
*Выбор всех строк  и полей id, name в таблице Restaurants которые соответствуют  ресторану с именем Falcone
*/
Select id, name as restaurant_name from Restaurants where name = 'Falcone';

/*
*Выбор всех объектов в таблице Restaurants где значение поля date_Of_Foundation содержит 01
*/
Select id, name, date_Of_Foundation from Restaurants where date_Of_Foundation like '%01%';

/*
*Выбор столбцов id, name, dob всех объектов в таблице Clients 
*/
Select id, name, dob from Clients;

/*
*Выбор столбцов id, name, dob всех объектов в таблице Clients  где name заанчивается на ya  или начинается на D
*/
Select id, name, dob from Clients where name like '%ya' or name like 'D%';

/*
*Выбор столбцов id, name всех объектов в таблице Drinks  где id четный
*/
Select id, name from Drinks where (id%2) =0;

/*
*Выбор столбцов id, name всех объектов в таблице Drinks  напитки, которые безалкогольные
*/
Select id, name from Drinks where isAlcoholic = false;

/*
*Выбор столбцов id, name всех объектов в таблице Dishes  где id 2 или 6
*/
Select  id, name, type from Dishes where id in (2,6);

/*
*Выбор столбцов id, first_name, last_name, position всех объектов в таблице Employees,  где department указан как kitchen
*/
Select id, first_name, last_name, position from Employees where department = 'kitchen';

/*
*Выбор столбцов id, name всех объектов в таблице Products  где staff_id соответствует id из таблицы staff позиции соответствующей  name равным frige
*/
Select id, name from Products where staff_id in (select id from staff where name = 'frige');

/*
*Выбор столбцов id, first_name всех объектов в таблице Employees и  столбцов id, number, expire_date всех объектов в таблице Passports,
 где  id из таблицы Passports соответствует значению позиции passport_id  в таблице Employees, 
 причем из таблицы Employees берутся все объекты, а из Passports только те, которые имеют связь с Employees  по  passport_id
*/
Select e.id,e.first_name, p.id,p.number,p.expire_date from Employees e right join Passports p 
on p.id = e.passport_id;

/*
*Выбор столбцов id, first_name всех объектов в таблице Employees и  столбцов id, number, expire_date всех объектов в таблице Passports,
 где  id из таблицы Passports соответствует значению позиции passport_id  в таблице Employees в выборку будут элементы Passports,
 где number >= 1004, причем из таблицы Employees берутся все объекты а из Passports только те которые имеют связь с Employees  по  passport_id
*/
Select e.id, e.first_name, p.id,p.number, p.expire_date from Employees e right join Passports p 
on p.id = e.passport_id where p.number >= 10004;

/*
*Выбор столбцов id, name, type всех объектов в таблице Dishes и столбцов id всех объектов в таблице Clients_dishes, и столбцов id, name всех объектов в таблице Clients,
 где id из таблицы Dishes соответствует значению позиции dish_id  в таблице Clients_dishes,
 в выборку попадают все элементы таблицы Dishes и клиенты которые, что-либо заказывали из Dishes 
*/
Select d.id, d.name, d.type, cd.id, c.id, c.name
from Dishes d 
left join Client_dishes cd 
on d.id = cd.dish_id
left join Clients c
on c.id = cd.client_id;

/*
*Выбор столбцов id, first_name, last_name всех объектов в таблице Employees и сортировка их по имени в алфавитном порядке
*/
Select id, first_name, last_name
from Employees
order by first_name asc;

/*
*Выбор столбцов id,first_name, last_name всех объектов в таблице Employees и сортировка их по фамилии в порядке обратном алфавитному
*/
Select id, first_name, last_name 
from Employees
order by last_name desc;

/*
*обновление  поля last_name на значение Ivasin в объекте с id = 4 и поля first_name на значение Igor в объекте с first_name  Vasya в таблице Employees 
*/
Update Employees set last_name = 'Ivasin' where id = 4;
Update Employees set first_name = 'Igor' where first_name = 'Vasya';

/*
*Выбор столбцов id, first_name, last_name всех объектов в таблице Employees и сортировка их по фамилии в порядке обратном алфавитному
и по имени в алфавитном порядке
*/
Select id, first_name, last_name from Employees 
order by  last_name desc, first_name asc; 

/*
*Вставка объекта в таблицу Employees и Выбор всех столбцов в таблице Employees 
*/
insert into  Employees (passport_id, address_id, first_name, last_name, position, department) value
(7, 9, 'Katya','Sydorova', 'washer', 'kitchen');

Select * from Employees;

/*
*удаление объекта из таблицу Employees соответствующего имени Katya и Выбор всех столбцов в таблице Employees 
*/
Delete from Employees where first_name = 'Katya';

Select * from Employees;

/*
*Выбор столбцов  имен клиентов  заказавших более одного блюда и их реальное количество в заказе  count(id) преименнованных в double_ordered_id  
*/
Select count(cd.id) as double_ordered_id, c.name
from Dishes d 
left join Client_dishes cd 
on d.id = cd.dish_id
left join Clients c
on c.id = cd.client_id
group by c.name
having double_ordered_id > 1;

/*
*Выбор столбцов  имен клиентов  заказавших блюда и их блюда с с именем и типом 
*/
Select d.name, d.type, c.name 
from Dishes d
inner join Client_dishes cd
on d.id = cd.dish_id
inner join Clients c 
on c.id = cd.client_id;




 