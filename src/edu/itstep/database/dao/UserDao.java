package edu.itstep.database.dao;

import edu.itstep.model.User;

public interface UserDao
{
    String REGISTER_QUERY = "{call registerUser(?,?)}";
    String AUTHORIZE_QUERY = "{call authorizeUser(?,?)}";
    String UPDATE_USER = "{call updateUser(?,?,?)}";

    int register(User user);

    User authorize(User user);

    int update(User user);
}