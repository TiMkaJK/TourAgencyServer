package edu.itstep.database.dao;

import edu.itstep.model.AddTour;
import edu.itstep.model.Sale;

public interface SaleDao
{
    String ADD_SALE_QUERY = "{call addSale(?,?,?)}";
    String All_SALES_QUERY = "{call getAllSales(?)}";

    int addSale(AddTour addTour);

    Sale getAllSales(int id);
}
