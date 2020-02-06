package edu.itstep.database.entity;

import edu.itstep.database.DBConnection;
import edu.itstep.database.dao.UserDao;
import edu.itstep.model.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDB extends DBConnection implements UserDao
{
    private Connection connection;
    private CallableStatement callableStatement;
    private ResultSet resultSet;

    @Override
    public int register(User user)
    {
        try
        {
            connection = getConnection();
            callableStatement = connection.prepareCall(REGISTER_QUERY);
            callableStatement.setString(1, user.getPhoneNumber());
            callableStatement.setString(2, user.getPassword());
            callableStatement.execute();

            resultSet = callableStatement.getResultSet();

            if (resultSet != null)
            {
                if (resultSet.next())
                {
                    int id = resultSet.getInt(1);
                    user.setId(id);
                    return id;
                }
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
        return -1;
    }

    @Override
    public User authorize(User user)
    {
        try
        {
            connection = getConnection();
            callableStatement = connection.prepareCall(AUTHORIZE_QUERY);
            callableStatement.setString(1, user.getPhoneNumber());
            callableStatement.setString(2, user.getPassword());
            callableStatement.execute();

            resultSet = callableStatement.getResultSet();

            user = new User();

            if (resultSet != null)
            {
                if (resultSet.next())
                {
                    user.setId(resultSet.getInt(1));
                    user.setFirstName(resultSet.getString(2));
                    user.setLastName(resultSet.getString(3));
                    user.setPhoneNumber(resultSet.getString(4));
                    user.setAdmin(resultSet.getBoolean(5));

                    return user;
                }
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

        user.setId(-1);
        return user;
    }

    @Override
    public int update(User user)
    {
        int rowAffected = 0;
        try
        {
            connection = getConnection();
            callableStatement = this.connection.prepareCall(UPDATE_USER);
            callableStatement.setInt(1, user.getId());
            callableStatement.setString(2, user.getFirstName());
            callableStatement.setString(3, user.getLastName());
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
}