package edu.itstep.controller;

import edu.itstep.resources.Const;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerController implements Runnable
{
    private ServerSocket serverSocket;

    @Override
    public void run()
    {
        try
        {
            serverSocket = new ServerSocket(Const.PORT);

            while (true)
            {
                Socket socket = serverSocket.accept();
                NetworkController networkController = new NetworkController(socket);
                Thread thread = new Thread(networkController);
                thread.start();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

