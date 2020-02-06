package edu.itstep.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Tour
{
    private int id;
    private String name;
    private String description;
    private int nStar;
    private String[] photoLinks;
    private String country;
    private String flagLink;
    private String city;
    private String accommodation;
    private int quantity;
    private String checkIn;
    private String checkOut;
    private double price;
    private boolean isDeleted;

    private ArrayList<Tour> tours;

    public Tour(int id, String name, String description, int nStar, String[] photoLinks, String country,
                String flagLink, String city, String accommodation, int quantity, String checkIn, String checkOut,
                double price, boolean isDeleted)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.nStar = nStar;
        this.photoLinks = photoLinks;
        this.country = country;
        this.flagLink = flagLink;
        this.city = city;
        this.accommodation = accommodation;
        this.quantity = quantity;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.price = price;
        this.isDeleted = isDeleted;
    }

    public Tour()
    {
        tours = new ArrayList<>();
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Tour{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", nStar=").append(nStar);
        sb.append(", photoLinks=").append(Arrays.toString(photoLinks));
        sb.append(", country='").append(country).append('\'');
        sb.append(", flagLink='").append(flagLink).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", accommodation='").append(accommodation).append('\'');
        sb.append(", quantity=").append(quantity);
        sb.append(", checkIn='").append(checkIn).append('\'');
        sb.append(", checkOut='").append(checkOut).append('\'');
        sb.append(", price=").append(price);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", tours=").append(tours);
        sb.append('}');
        return sb.toString();
    }

    public void addTour(Tour tour)
    {
        this.tours.add(tour);
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

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
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

    public ArrayList<Tour> getTours()
    {
        return tours;
    }

    public void setTours(ArrayList<Tour> tours)
    {
        this.tours = tours;
    }

    public String getFlagLink()
    {
        return flagLink;
    }

    public void setFlagLink(String flagLink)
    {
        this.flagLink = flagLink;
    }
}

