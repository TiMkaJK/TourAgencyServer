package edu.itstep.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Hotel
{
    private int id;
    private String name;
    private String description;
    private int nStar;
    private String[] photoLinks;
    private String country;
    private String city;
    private String accommodation;
    private int quantity;
    private String checkIn;
    private String checkOut;
    private double price;
    private boolean isDeleted;

    private ArrayList<Hotel> hotels;

    public Hotel(int id, String name, String description, int nStar, String[] photoLinks, String city, String country,
                 String accommodation, int quantity, String checkIn, String checkOut, double price, boolean isDeleted)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.nStar = nStar;
        this.photoLinks = photoLinks;
        this.city = city;
        this.country = country;
        this.accommodation = accommodation;
        this.quantity = quantity;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.price = price;
        this.isDeleted = isDeleted;
    }

    public Hotel()
    {
        this.hotels = new ArrayList<>();
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Hotel{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", nStar=").append(nStar);
        sb.append(", photoLinks=").append(Arrays.toString(photoLinks));
        sb.append(", city='").append(city).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", accommodation='").append(accommodation).append('\'');
        sb.append(", quantity=").append(quantity);
        sb.append(", checkIn='").append(checkIn).append('\'');
        sb.append(", checkOut='").append(checkOut).append('\'');
        sb.append(", price=").append(price);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", hotels=").append(hotels);
        sb.append('}');
        return sb.toString();
    }

    public void addHotel(Hotel hotel)
    {
        this.hotels.add(hotel);
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getnStar()
    {
        return nStar;
    }

    public void setnStar(int nStar)
    {
        this.nStar = nStar;
    }

    public String[] getPhotoLinks()
    {
        return photoLinks;
    }

    public void setPhotoLinks(String[] photoLinks)
    {
        this.photoLinks = photoLinks;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getAccommodation()
    {
        return accommodation;
    }

    public void setAccommodation(String accommodation)
    {
        this.accommodation = accommodation;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public String getCheckIn()
    {
        return checkIn;
    }

    public void setCheckIn(String checkIn)
    {
        this.checkIn = checkIn;
    }

    public String getCheckOut()
    {
        return checkOut;
    }

    public void setCheckOut(String checkOut)
    {
        this.checkOut = checkOut;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public boolean isDeleted()
    {
        return isDeleted;
    }

    public void setDeleted(boolean deleted)
    {
        isDeleted = deleted;
    }

    public ArrayList<Hotel> getHotels()
    {
        return hotels;
    }

    public void setHotels(ArrayList<Hotel> hotels)
    {
        this.hotels = hotels;
    }
}
