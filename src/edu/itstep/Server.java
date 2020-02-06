package edu.itstep;

import edu.itstep.controller.ServerController;

public class Server
{
    public static void main(String[] args)
    {
        ServerController serverController = new ServerController();
        Thread thread = new Thread(serverController);
        thread.start();
    }
}
