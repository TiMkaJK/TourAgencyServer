package edu.itstep.database.dao;

import edu.itstep.model.Accommodation;
import edu.itstep.model.City;
import edu.itstep.model.Country;
import edu.itstep.model.Tour;

public interface TourDao
{
    String ALL_TOURS_QUERY = "{call getAllTours}";
    String ALL_TOURS_BY_ID_QUERY = "{call getAllToursById(?)}";
    String All_COUNTRIES_QUERY = "{call getAllCountries}";
    String ALL_CITY_BY_ID_QUERY = "{call getAllCitiesById(?)}";
    String All_ACCOMMODATIONS_QUERY = "{call getAllAccommodations}";

    Tour getAllTours();

    Tour getAllToursById(int id);

    Country getAllCountries();

    City getAllCitiesById(int id);

    Accommodation getAllAccommodations();
}
