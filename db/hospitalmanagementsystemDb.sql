create table login(
username varchar(30) not null,
password varchar(30) not null,
type varchar(30) not null
);
insert into login(username,password,type) values ("admin","admin","admin"),
("user","user","user");

create table doctor(
id int not null auto_increment primary key,
name varchar(30) not null,
contact varchar(30) not null,
specialization varchar(30) not null,
address varchar(30) not null,
fee double not null
);
insert into doctor(name,contact,specialization,address,fee) values
("Asad","0322111554","child specialist","North Karachi","5000.00"),
("Iqbal","035435542","Allergy and immunology","North Karachi","4000.00"),
("Ifham","0333515351","Emergency medicine","Nazimabad","5000.00"),
("Mubashir","0364761451","Family medicine","Orangi Town","3000.00"),
("Talha","0367898799","Medical genetics","Airport","8000.00"),
("Hashmi","0384654651","Surgery","Gulshan Hadeed","25000.00"),
("Wajih","0326456844","Urology","Malir","15000.00");


create table patient(
id int not null auto_increment primary key,
name varchar(30) not null,
age varchar(30) not null,
address varchar(30) not null,
contact varchar(30) not null,
gender varchar(30) not null
);
insert into patient(name,age,address,contact,gender) values("Umer",20,"Star Gate","684684","Male"),
("Samreen",30,"Malir","6464684","Female"),
("Sumaira",35,"Saddar","87464","Female"),
("Saman",20,"Clifton","486464","Female"),
("Ali",24,"Muree","844551","Male"),
("Aroob",28,"Hydrabad","53131","Female"),
("Khaleel",40,"Orangi","154125","Male"),
("Afzal",45,"Gulshan e Iqbal","2645156","Male");
select * from patient ;
create table appointment(
id int not null auto_increment primary key,
date Date,
time Time,
serviceCharges double not null,
doctor_id int not null,
foreign key (doctor_id) references doctor(id) on delete cascade on update cascade,
patient_id int not null,
foreign key (patient_id) references patient(id) on delete cascade on update cascade
);
select a.date, a.time, a.serviceCharges, d.name as doctor_name, d.specialization, d.fee, p.name as patient_name, p.contact from appointment a join doctor d on a.doctor_id=d.id join patient p on a.patient_id= p.id where p.contact= '6464684';
insert into appointment(date,time,serviceCharges,doctor_id,patient_id)values(STR_TO_DATE('08/17/2022', '%m/%d/%Y'),'02:00:00',500.00,5,1),
(STR_TO_DATE('09/18/2022', '%m/%d/%Y'),'03:23:00',500.00,7,2),
(STR_TO_DATE('08/19/2022', '%m/%d/%Y'),'04:53:00',500.00,4,3),
(STR_TO_DATE('09/05/2022', '%m/%d/%Y'),'09:13:00',500.00,2,4),
(STR_TO_DATE('11/06/2022', '%m/%d/%Y'),'01:23:00',500.00,5,5),
(STR_TO_DATE('12/9/2022', '%m/%d/%Y'),'02:30:00',500.00,1,6),
(STR_TO_DATE('9/30/2022', '%m/%d/%Y'),'01:50:00',500.00,2,7),
(STR_TO_DATE('11/15/2022', '%m/%d/%Y'),'07:45:00',500.00,4,8);

create table bill(
id int not null auto_increment primary key,
invoiceNumber varchar(30) not null,
appoinment_id int not null,
foreign key(appoinment_id) references appointment(id) on delete cascade on update cascade
);
insert into bill(invoiceNumber,appoinment_id)values("20210531-1001",1),
("20210531-1002",2),
("20210531-1003",3),
("20210531-1004",4),
("20210531-1005",5),
("20210531-1006",6),
("20210531-1007",7),
("20210531-1008",8);