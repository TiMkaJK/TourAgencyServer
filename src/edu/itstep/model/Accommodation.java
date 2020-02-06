package edu.itstep.model;

import java.util.ArrayList;

public class Accommodation
{
    private int id;
    private String name;

    private ArrayList<Accommodation> accommodations;

    public Accommodation(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Accommodation{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", accommodations=").append(accommodations);
        sb.append('}');
        return sb.toString();
    }

    public Accommodation()
    {
        this.accommodations = new ArrayList<>();
    }

    public void addAcommodation(Accommodation accommodation)
    {
        this.accommodations.add(accommodation);
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

    public ArrayList<Accommodation> getAccommodations()
    {
        return accommodations;
    }

    public void setAccommodations(ArrayList<Accommodation> accommodations)
    {
        this.accommodations = accommodations;
    }
}
