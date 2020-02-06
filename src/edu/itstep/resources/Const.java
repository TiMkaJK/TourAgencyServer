package edu.itstep.resources;

public final class Const
{
    //Socket server connection settings
    public static final int PORT = 4385;

    //SQL Server connection settings
    public static final String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static final String SERVER_ADDRESS = "jdbc:sqlserver://127.0.0.1;";
    public static final String SERVER_INSTANCE = "instance=SQLEXPRESS;";
    public static final String DB_NAME = "databaseName=TourAgencyAndroid;";
    public static final String USER_NAME = "user=sa;";
    public static final String USER_PASSWORD = "password=1";

    //File path with Properties
    public static final String DATA_PATH = "./src/edu/itstep/resources/data.properties";
}
