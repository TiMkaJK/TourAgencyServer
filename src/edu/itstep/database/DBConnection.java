package edu.itstep.database;

import edu.itstep.resources.Const;

import java.sql.*;

public class DBConnection
{
    public Connection getConnection()
    {
        Connection connection = null;

        try
        {
            Class.forName(Const.DRIVER_NAME);

            connection = DriverManager.getConnection(Const.SERVER_ADDRESS +
                                                         Const.SERVER_INSTANCE +
                                                         Const.DB_NAME +
                                                         Const.USER_NAME +
                                                         Const.USER_PASSWORD);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }

        return connection;
    }

    public void closeConnection(Connection connection, CallableStatement callableStatement, ResultSet resultSet)
    {
        try
        {
            if (resultSet != null)
            {
                if (!resultSet.isClosed())
                {
                    resultSet.close();
                }
                resultSet = null;
            }
            if (callableStatement != null)
            {
                if (!callableStatement.isClosed())
                {
                    callableStatement.close();
                }
                callableStatement = null;
            }
            if (connection != null)
            {
                if (!connection.isClosed())
                {
                    connection.close();
                }
                connection = null;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}

