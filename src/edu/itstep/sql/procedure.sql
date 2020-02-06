use TourAgencyAndroid
go

create procedure registerUser 
	@phoneNumber varchar(13),
    @password varchar(255)
as
begin
    set nocount on
    declare @phoneExists char(13)

    select @phoneExists = [User].phoneNumber
    from [User]
    where [User].phoneNumber = @phoneNumber

    if (@phoneExists like @phoneNumber)
        return -1
    else
        begin
            declare @pass varbinary(100)
            select @pass = HASHBYTES('SHA2_256', @password)

            insert into [User](phoneNumber, [password])
            values (@phoneNumber, @pass)

            select [User].id
            from [User]
            where [User].phoneNumber = @phoneNumber
        end
end
go

create procedure authorizeUser 
	@phoneNumber varchar(13),
    @password varchar(255)
as
begin
    declare @id int
    set @id = 0

    select @id = [User].id
    from [User]
    where [User].phoneNumber = @phoneNumber
      and [User].[password] = HASHBYTES('SHA2_256', @password)

    if (@id = 0) return -1

    select [User].id,
           [User].firstName,
           [User].lastName,
           [User].phoneNumber,
           [User].isDeleted
    from [User]
    where [User].id = @id
      and [User].isDeleted = 0
end
go

create procedure updateUser 
	@id int,
    @firstName varchar(50),
    @lastName varchar(100)
as
begin
    update [User]
    set [User].firstName = @firstName,
        [User].lastName  = @lastName
    where [User].id = @id
end
go

create procedure updateUser2 
	@id int,
    @firstName varchar(50),
    @lastName varchar(100)
as
begin
    update [User]
    set [User].firstName = @firstName,
        [User].lastName  = @lastName
    where [User].id = @id

    select [User].id,
           [User].firstName,
           [User].lastName,
           [User].phoneNumber,
           [User].isDeleted
    from [User]
    where [User].id = @id
      and [User].isDeleted = 0
end
go

create procedure getUser 
	@id int
as
begin
    select [User].firstName,
           [User].lastName,
           [User].phoneNumber,
           [User].isAdmin
    from [User]
    where [User].id = @id
      and [User].isDeleted = 0
end
go

create procedure getAllCountries
as
begin
    select Country.id,
           Country.name,
           Country.flagLink
    from Country
    order by Country.name
end
go

create procedure getAllCitiesById 
	@idCountry int
as
begin
    select City.id,
           City.name
    from City
             inner join Country on City.idCountry = Country.id
    where Country.id = @idCountry
    order by City.name
end
go

create procedure getAllToursById 
	@idCity int
as
begin
    select Tour.id,
           Hotel.name,
           Hotel.description,
           Hotel.nStar,
           Hotel.photoLinks,
           Country.name,
           Country.flagLink,
           City.name,
           Accommodation.name,
           Tour.quantity,
           Tour.checkIn,
           Tour.checkOut,
           Tour.price,
           Tour.isDeleted
    from Tour
             inner join Hotel on Tour.idHotel = Hotel.id
             inner join City on Hotel.idCity = City.id
             inner join Country on Country.id = City.idCountry
             inner join Accommodation on Tour.idAccommodation = Accommodation.id
    where Hotel.idCity = @idCity
      and Tour.isDeleted = 0
end
go

create procedure getAllAccommodations
as
begin
    select Accommodation.id,
           Accommodation.name
    from Accommodation
    order by Accommodation.name
end
go

create procedure getAllTours
as
begin
    select Tour.id,
           Hotel.name,
           Hotel.description,
           Hotel.nStar,
           Hotel.photoLinks,
           Country.name,
           Country.flagLink,
           City.name,
           Accommodation.name,
           Tour.quantity,
           Tour.checkIn,
           Tour.checkOut,
           Tour.price,
           Tour.isDeleted
    from Tour
             inner join Hotel on Tour.idHotel = Hotel.id
             inner join City on Hotel.idCity = City.id
             inner join Country on Country.id = City.idCountry
             inner join Accommodation on Tour.idAccommodation = Accommodation.id
    where Tour.isDeleted = 0
end
go

create procedure getAllSales 
	@idUser int
as
begin
    select Hotel.id,
           Hotel.name,
           Hotel.description,
           Hotel.nStar,
           Hotel.photoLinks,
           Country.name,
           Country.flagLink,
           City.name,
           Accommodation.name,
           Sale.quantity,
           Tour.checkIn,
           Tour.checkOut,
           Sale.price,
           Sale.dateSale
    from Sale
             inner join Tour on Tour.id = Sale.idTour
             inner join Hotel on Hotel.id = Tour.idHotel
             inner join City on Hotel.idCity = City.id
             inner join Accommodation on Tour.idAccommodation = Accommodation.id
             inner join Country on Country.id = City.idCountry
             inner join [User] on [User].id = Sale.idUser
    where [User].id = @idUser
end
go

create procedure addSale 
	@idTour int,
    @idUser int,
    @quantity int
as
begin
    insert into Sale(idTour,
                     idUser,
                     quantity,
                     price,
                     dateSale)
    values (@idTour,
            @idUser,
            @quantity,
            (select Tour.price from Tour where Tour.id = @idTour) * @quantity,
            getdate())
end
go

execute registerUser '+380665346691', '1'
execute addSale 3, 1, 2