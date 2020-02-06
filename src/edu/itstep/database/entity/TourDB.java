package edu.itstep.database.entity;

import edu.itstep.database.DBConnection;
import edu.itstep.database.dao.TourDao;
import edu.itstep.model.Accommodation;
import edu.itstep.model.City;
import edu.itstep.model.Country;
import edu.itstep.model.Tour;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TourDB extends DBConnection implements TourDao
{
    private Connection connection;
    private CallableStatement callableStatement;
    private ResultSet resultSet;

    @Override
    public Tour getAllTours()
    {
        Tour tour = null;

        try
        {
            connection = getConnection();
            callableStatement = connection.prepareCall(ALL_TOURS_QUERY);
            callableStatement.execute();

            resultSet = callableStatement.getResultSet();

            tour = new Tour();

            while (resultSet.next())
            {
                tour.addTour(new Tour(resultSet.getInt(1),
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
                                      resultSet.getDouble(13),
                                      resultSet.getBoolean(14)));
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
        return tour;
    }

    @Override
    public Tour getAllToursById(int id)
    {
        Tour tour = null;

        try
        {
            connection = getConnection();
            callableStatement = connection.prepareCall(ALL_TOURS_BY_ID_QUERY);
            callableStatement.setInt(1, id);
            callableStatement.execute();

            resultSet = callableStatement.getResultSet();

            tour = new Tour();

            while (resultSet.next())
            {
                tour.addTour(new Tour(resultSet.getInt(1),
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
                                      resultSet.getDouble(13),
                                      resultSet.getBoolean(14)));
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

        return tour;
    }

    @Override
    public Country getAllCountries()
    {
        Country country = null;

        try
        {
            connection = getConnection();

            callableStatement = this.connection.prepareCall(All_COUNTRIES_QUERY);
            callableStatement.execute();

            resultSet = callableStatement.getResultSet();

            country = new Country();

            while (resultSet.next())
            {
                country.addCountry(new Country(resultSet.getInt(1),
                                               resultSet.getString(2),
                                               resultSet.getString(3)));
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

        return country;
    }

    @Override
    public City getAllCitiesById(int id)
    {
        City city = null;

        try
        {
            connection = getConnection();
            callableStatement = this.connection.prepareCall(ALL_CITY_BY_ID_QUERY);
            callableStatement.setInt(1, id);
            callableStatement.execute();

            resultSet = callableStatement.getResultSet();

            city = new City();

            while (resultSet.next())
            {
                city.addCity(new City(resultSet.getInt(1),
                        resultSet.getString(2)));
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

        return city;
    }

    @Override
    public Accommodation getAllAccommodations()
    {
        Accommodation accommodation = null;

        try
        {
            connection = getConnection();

            callableStatement = this.connection.prepareCall(All_ACCOMMODATIONS_QUERY);
            callableStatement.execute();

            resultSet = callableStatement.getResultSet();

            accommodation = new Accommodation();

            while (resultSet.next())
            {
                accommodation.addAcommodation(new Accommodation(resultSet.getInt(1),
                                                                resultSet.getString(2)));
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

        return accommodation;
    }
}

