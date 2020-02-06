use TourAgencyAndroid
go

create trigger saleInsertCheck
    on Sale
    after insert
    as
    declare
        @tourQuantity int,
        @saleQuantity int ,
        @idTour       int
select @saleQuantity = inserted.quantity,
       @idTour = inserted.idTour
from inserted

select @tourQuantity = Tour.quantity
from Tour
where Tour.id = @idTour

if (@saleQuantity > @tourQuantity) rollback transaction

update Tour
set quantity = quantity - @saleQuantity
where id = @idTour