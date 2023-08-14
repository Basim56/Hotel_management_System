create table hotel_admin(
id int primary key auto_increment,
first_name varchar(2255),
last_name varchar(255),
email varchar(255),
admin_password varchar(255)
);

create table hotel(
id int primary key auto_increment,
hotel_name varchar(255),
location varchar(255),
url varchar(10000),
admin_id int,
foreign key (admin_id) references hotel_admin(id)
);

create table room(
id int primary key auto_increment,
category varchar(255),
room_floor varchar(255),
price double,
hotel_id int,
foreign key (hotel_id) references hotel(id)
);
alter table room add url varchar(10000);


create table customer(
id int primary key auto_increment,
customer_name varchar(255),
phone_number varchar(255),
cnic varchar(255)
);

create table booking(
b_id int primary key auto_increment,
h_id int,
r_id int,
c_id int,
arrival_date date,
departure_date date,
booking_date date,
foreign key (h_id) references hotel(id),
foreign key (r_id) references room(id),
foreign key (c_id) references customer(id)
);
alter table booking add price double

-- insertion admin

insert into hotel_admin(first_name,last_name,email,admin_password) values
('Sufyaan','Sauri','sufyaansauri56@gmail.com','1234'),
('Shaheer','Qamar','shaheerqamar34@gmail.com','4567'),
('Abdullah','Khan','abdullahkhan67@gmail.com','1434'),
('Basim','Afzal','basimafzal5@gmail.com','4387'),
('Sabtain','Mushtaq','sabtainmushtaq66@gmail.com','1674');

select * from hotel_admin;
select * from hotel;
-- insertion hotel

insert into hotel(hotel_name,location,url,admin_id) values
('Rexee hotel','Istanbul,Turkey','https://cf.bstatic.com/xdata/images/hotel/square600/478206630.webp?k=2c8ff9da4ac3d2821a4c01fff175308ecb9067bb33bb2568c4f7f500170f40ab&o=',1),
('İstanbul Efes Hotel','Istanbul,Turkey','https://cf.bstatic.com/xdata/images/hotel/square600/422238953.webp?k=8fa9ee61eae81478547b2efd2c595ec3d16c1d1dd41fb27178379b97d6b61089&o=',1),
('Sk Residence','Islamabad,Pakistan','https://cf.bstatic.com/xdata/images/hotel/square600/478290798.webp?k=bad2c219f5d33608735838da3673bab96626a06d1273c31a4a0fbc7996001280&o=',2),
('Waters Edge, Business Bay', 'Dubai,Abu dhabi','https://cf.bstatic.com/xdata/images/hotel/square600/482433645.webp?k=de6c9401a5945113b8ca4dbe420066af72075e1dcf792085d0df5c32da7e5520&o=',4),
('CitiHome- Business Bay','Dubai,Abu dhabi','https://cf.bstatic.com/xdata/images/hotel/square600/478290798.webp?k=bad2c219f5d33608735838da3673bab96626a06d1273c31a4a0fbc7996001280&o=',4),
('Own it','Lahore, Pakistan','https://cf.bstatic.com/xdata/images/hotel/square600/481676609.webp?k=b04167b004fd5c383af452b2db9fce2feefafee483380316a2d71e6c8a98a205&o=',3),
('Inside City Hotel Baku','Baku,Azerbaijan','https://cf.bstatic.com/xdata/images/hotel/square600/386655956.webp?k=d41f5cef2ee1d56cfcc57a5a0db657d5eba3f7a68aecc9a6bae13d069f9aa296&o=',5);

-- insertion room

insert into room(category,room_floor,price,hotel_id,url) values
('Business Class','8',30000.0,1,'https://cf.bstatic.com/xdata/images/hotel/max500/481841044.jpg?k=2e5e93208d5290e8320c526ba71a7481cc090ac64bc0de0c995209a21685c137&o=&hp=1'),
('Economy Class','5',17000.0,1,'data-src="https://cf.bstatic.com/xdata/images/hotel/max1024x768/481535541.jpg?k=33e4da1e14b0b21aed99d4273793bab806386d332f8beb178b5a6fe22b9ba04c&o=&hp=1'),
('VIP','12',45000.0,2,'https://cf.bstatic.com/xdata/images/hotel/max1280x900/481526837.jpg?k=9d938976bd5ea595e1b023c38c6ea5f1c58b370293e0e345172219eb5bddadd7&o=&hp=1'),
('Business Class','8',25000.0,2,'https://cf.bstatic.com/xdata/images/hotel/max1280x900/481526837.jpg?k=9d938976bd5ea595e1b023c38c6ea5f1c58b370293e0e345172219eb5bddadd7&o=&hp=1'),
('Economy Class','4',20000.0,3,'https://cf.bstatic.com/xdata/images/hotel/max1280x900/480529015.jpg?k=5aa6481b9b50079118bbcec0b227c4510eed7842a7b0c50cad5d6ed39daf3eb1&o=&hp=1'),
('Economy Class','5',23000.0,3,'https://cf.bstatic.com/xdata/images/hotel/max1280x900/480529023.jpg?k=b2886b77b7944b6ecb3128e3f897e9743e4d85dab5c032ff24932990dc6a7111&o=&hp=1'),
('VIP','25',55000.0,4,'https://cf.bstatic.com/xdata/images/hotel/max1280x900/481526824.jpg?k=c13a2279546866b793289ffedfda30d7b92ba6111f38d33b6de727fc9b9151b1&o=&hp=1'),
('VIP','27',50000.0,4,'https://cf.bstatic.com/xdata/images/hotel/max1280x900/481526824.jpg?k=c13a2279546866b793289ffedfda30d7b92ba6111f38d33b6de727fc9b9151b1&o=&hp=1'),
('Business Class','17',45000.0,5,'https://cf.bstatic.com/xdata/images/hotel/max1280x900/483171241.jpg?k=85f4ce0ec8d91b0ed20ee224efcea52dcc3165304b2db5e143f9cef75fff96d1&o=&hp=1'),
('Economy Class','18',32000.0,5,'https://cf.bstatic.com/xdata/images/hotel/max1280x900/471879256.jpg?k=e7d66ece3428f3493c034230e0117a0258ccd7ab5d48d2808fffdbbcab2e3395&o=&hp=1'),
('Economy Class','6',20000.0,6,'https://cf.bstatic.com/xdata/images/hotel/max1280x900/467968233.jpg?k=686ef2d8a2fc565af5a51cd8ba34a64b444dccc7e1e64c4e8c24b05732d32915&o=&hp=1'),
('Business Class','8',34000.0,6,'https://cf.bstatic.com/xdata/images/hotel/max1280x900/465085044.jpg?k=e6cece00e85339c0ca99442e3e468421f6db0ca39f403bc0bb162c81353b6a19&o=&hp=1'),
('VIP','20',34500.0,7,'https://cf.bstatic.com/xdata/images/hotel/max1280x900/471879234.jpg?k=2dca9629e172e53341dfa0064249b4a153bcfef00d5e84f737b7724b393e54c3&o=&hp=1'),
('VIP','20',45000.0,7,'https://cf.bstatic.com/xdata/images/hotel/max1280x900/471879255.jpg?k=1bae0f6aab8126a438c31250dec1b6ad07b50ce5b89a68d1327f04c17ac6df52&o=&hp=1');

-- select count(max(h.id)),ha.first_name,ha.last_name from hotel_admin ha join hotel h on ha.id=h.admin_id group by h.admin_id;
-- select max(h.id),a.first_name,a.last_name from hotel_admin a join hotel h
-- on a.id=h.admin_id group by a.id;
-- select * from hotel_admin ha join hotel h on ha.id=h.admin_id;
-- insertion customers
insert into customer(customer_name,phone_number,cnic) values
('Saqlain Mushtaq','03452345798','904039429342'),
('Hiba khan','03784232424','9040356940945'),
('Sufyaan khan','0598342424','42201324234'),
('Afzal khan','05433242342','422013123747'),
('Shehzad Iqbal','0562314676','422019423424'),
('Shaheer Ahmed','05763332444','4220989793424'),
('Jarjees Ahmed','0345639324','43304325534'),
('Kayla Puff','034243543353','2421545i5354');


insert into booking(h_id,r_id,c_id,arrival_date,departure_date,booking_date,price) values
(1,2,4,curdate(),'2023-8-15',curdate(),10000),
(1,1,1,'2022-6-18','2022-6-26','2022-6-18',20000),
(2,2,5,'2021-4-4','2021-4-10','2021-4-4',25000),
(1,2,4,'2021-5-13','2021-5-18','2021-5-13',30000),
(3,14,8,'2023-8-15','2023-8-25','2023-8-15',48000),
(4,12,7,'2022-10-15','2022-10-21','2022-10-15',45000),
(5,10,8,curdate(),'2023-8-27',curdate(),50000),
(7,7,7,'2020-3-18','2020-3-26','2020-3-18',65000);
truncate table booking;

update booking
set h_id=6,r_id=7,c_id=5,arrival_date=curdate(),departure_date='2023-8-28',booking_date=curdate(),price=62000.0 where b_id=8