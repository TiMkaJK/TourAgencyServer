package edu.itstep.controller;

import com.google.gson.Gson;
import edu.itstep.database.entity.SaleDB;
import edu.itstep.database.entity.TourDB;
import edu.itstep.database.entity.UserDB;
import edu.itstep.model.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class NetworkController implements Runnable
{
    private Socket socket;
    private Scanner scanner;
    private PrintWriter printWriter;

    public NetworkController(Socket socket)
    {
        this.socket = socket;

        try
        {
            this.printWriter = new PrintWriter(socket.getOutputStream());
            this.scanner = new Scanner(socket.getInputStream());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void run()
    {
        Gson gson = new Gson();

        UserDB userDB = new UserDB();
        TourDB tourDB = new TourDB();
        SaleDB saleDB = new SaleDB();

        boolean isWorking = true;

        while (isWorking)
        {
            User user = null;
            Tour tour = null;
            Sale sale = null;

            AddTour addTour = null;
            Country country = null;
            City city = null;
            Accommodation accommodation = null;

            String request = scanner.nextLine();
            String JSON = "";

            String message = "";
            int rowAffected = 0;

            switch (request)
            {
                case "registerUser":
                    JSON = scanner.nextLine();
                    user = gson.fromJson(JSON, User.class);
                    int id = userDB.register(user);
                    message = String.valueOf(id);
                    send(message);
                    break;
                case "authorizeUser":
                    JSON = scanner.nextLine();
                    user = gson.fromJson(JSON, User.class);
                    user = userDB.authorize(user);
                    message = gson.toJson(user);
                    send(message);
                    break;
                case "getAllTours":
                    tour = tourDB.getAllTours();
                    message = gson.toJson(tour);
                    send(message);
                    break;
                case "getAllToursById":
                    JSON = scanner.nextLine();
                    int idCity = Integer.parseInt(JSON);
                    tour = tourDB.getAllToursById(idCity);
                    message = gson.toJson(tour);
                    send(message);
                    break;
                case "getAllCountries":
                    country = tourDB.getAllCountries();
                    message = gson.toJson(country);
                    send(message);
                    break;
                case "getAllCitiesById":
                    JSON = scanner.nextLine();
                    int idCountry = Integer.parseInt(JSON);
                    city = tourDB.getAllCitiesById(idCountry);
                    message = gson.toJson(city);
                    send(message);
                    break;
                case "getAllAccommodations":
                    accommodation = tourDB.getAllAccommodations();
                    message = gson.toJson(accommodation);
                    send(message);
                    break;
                case "getAllSales":
                    JSON = scanner.nextLine();
                    id = Integer.parseInt(JSON);
                    sale = saleDB.getAllSales(id);
                    message = gson.toJson(sale);
                    send(message);
                    break;
                case "addSale":
                    JSON = scanner.nextLine();
                    addTour = gson.fromJson(JSON, AddTour.class);
                    rowAffected = saleDB.addSale(addTour);
                    send(String.valueOf(rowAffected));
                    break;
                case "updateUser":
                    JSON = scanner.nextLine();
                    user = gson.fromJson(JSON, User.class);
                    rowAffected = userDB.update(user);
                    send(String.valueOf(rowAffected));
                    break;
                case "disconnect":
                    isWorking = false;
                    break;
            }
        }
    }

    public void send(String message)
    {
        printWriter.write(message + "\n");
        printWriter.flush();
    }
}

            /*String request = null;
            try
            {
                request = scanner.nextLine();
            }
            catch (Exception e)
            {
                request = "disconnect";
            }*/

