package edu.itstep.database.entity;

import edu.itstep.database.DBConnection;
import edu.itstep.database.dao.SaleDao;
import edu.itstep.model.AddTour;
import edu.itstep.model.Sale;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SaleDB extends DBConnection implements SaleDao
{
    private Connection connection;
    private CallableStatement callableStatement;
    private ResultSet resultSet;

    @Override
    public int addSale(AddTour addTour)
    {
        int rowAffected = 0;

        try
        {
            connection = getConnection();
            callableStatement = this.connection.prepareCall(ADD_SALE_QUERY);
            callableStatement.setInt(1, addTour.getIdTour());
            callableStatement.setInt(2, addTour.getIdUser());
            callableStatement.setInt(3, addTour.getQuantity());
            rowAffected = callableStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeConnection(connection, callableStatement, resultSet);
        }

        return rowAffected;
    }

    @Override
    public Sale getAllSales(int id)
    {
        Sale sale = null;

        try
        {
            connection = getConnection();
            callableStatement = this.connection.prepareCall(All_SALES_QUERY);
            callableStatement.setInt(1, id);
            callableStatement.execute();

            resultSet = callableStatement.getResultSet();

            sale = new Sale();

            while (resultSet.next())
            {
                sale.addSale(new Sale(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getString(5).split(" "),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getInt(10),
                        resultSet.getString(11),
                        resultSet.getString(12),
                        resultSet.getFloat(13),
                        resultSet.getString(14)));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeConnection(connection, callableStatement, resultSet);
        }

        return sale;
    }
}

