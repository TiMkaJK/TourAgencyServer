package edu.itstep.model;

import java.util.ArrayList;

public class City
{
    private int id;
    private String name;

    private ArrayList<City> cities;

    public City(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public City()
    {
        this.cities = new ArrayList<>();
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("City{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", cities=").append(cities);
        sb.append('}');
        return sb.toString();
    }

    public void addCity(City city)
    {
        this.cities.add(city);
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

    public ArrayList<City> getCities()
    {
        return cities;
    }

    public void setCities(ArrayList<City> cities)
    {
        this.cities = cities;
    }
}
