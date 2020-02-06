--create database TourAgencyAndroid
use TourAgencyAndroid

create table Country
(
    id       int primary key identity (1,1),
    name     varchar(100) unique not null,
    flagLink varchar(max)        not null
)

create table City
(
    id        int primary key identity (1,1),
    name      varchar(100) unique not null,
    idCountry int foreign key references Country (id)
)

create table [User]
(
    id          int primary key identity (1,1),
    firstName   varchar(50),
    lastName    varchar(100),
    phoneNumber varchar(13) unique not null,
    [password]  varbinary(100)     not null,
    isAdmin     bit default 0,
    isDeleted   bit default 0
)

create table Hotel
(
    id            int primary key identity (1,1),
    name          varchar(50)   not null,
    nStar         int           not null,
    idCity        int foreign key references City (id),
    photoLinks    nvarchar(max) not null,
    [description] nvarchar(max) not null
)

create table Accommodation
(
    id   int primary key identity (1,1),
    name varchar(30) unique not null
)

create table Tour
(
    id              int primary key identity (1,1),
    idHotel         int foreign key references Hotel (id),
    idAccommodation int foreign key references Accommodation (id),
    quantity        int      not null,
    checkIn         date     not null,
    checkOut        date     not null,
    price           float(2) not null,
    isDeleted       bit default 0
)

create table Sale
(
    id       int primary key identity (1,1),
    idTour   int foreign key references Tour (id),
    idUser   int foreign key references [User] (id),
    quantity int           not null,
    price    float(2)      not null,
    dateSale smalldatetime not null
)



