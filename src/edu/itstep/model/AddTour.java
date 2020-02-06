package edu.itstep.model;

public class AddTour
{
    private int idTour;
    private int idUser;
    private int quantity;

    public AddTour()
    {
    }

    public AddTour(int idTour, int idUser, int quantity)
    {
        this.idTour = idTour;
        this.idUser = idUser;
        this.quantity = quantity;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("AddTour{");
        sb.append("idTour=").append(idTour);
        sb.append(", idUser=").append(idUser);
        sb.append(", quantity=").append(quantity);
        sb.append('}');
        return sb.toString();
    }

    public int getIdTour()
    {
        return idTour;
    }

    public void setIdTour(int idTour)
    {
        this.idTour = idTour;
    }

    public int getIdUser()
    {
        return idUser;
    }

    public void setIdUser(int idUser)
    {
        this.idUser = idUser;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
}

