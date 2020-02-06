package edu.itstep.model;

import java.util.ArrayList;

public class Country
{
    private int id;
    private String name;
    private String flagLink;

    private ArrayList<Country> countries;

    public Country(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public Country(int id, String name, String flagLink)
    {
        this.id = id;
        this.name = name;
        this.flagLink = flagLink;
    }

    public Country()
    {
        this.countries = new ArrayList<>();
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Country{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", flagLink='").append(flagLink).append('\'');
        sb.append(", countries=").append(countries);
        sb.append('}');
        return sb.toString();
    }

    public void addCountry(Country country)
    {
        this.countries.add(country);
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

    public String getFlagLink()
    {
        return flagLink;
    }

    public void setFlagLink(String flagLink)
    {
        this.flagLink = flagLink;
    }

    public ArrayList<Country> getCountries()
    {
        return countries;
    }

    public void setCountries(ArrayList<Country> countries)
    {
        this.countries = countries;
    }
}
