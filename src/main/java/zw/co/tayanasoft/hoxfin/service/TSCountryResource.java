package zw.co.tayanasoft.hoxfin.service;

import org.postgresql.copy.CopyOut;
import zw.co.tayanasoft.hoxfin.dao.Country;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/hoxfin/v1/countries")
public class TSCountryResource {
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Country> getCountries(){
        return Country.listAll();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Country addCountry(Country country){
        country.persist();
        return country;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Country removeCountry(Long id){
        Country country = Country.findById(id);
        if(country == null){
            return null;
        }
        country.softDeleted=true;
        country.persist();
        return country;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Country updateCountry(Long id, Country editCountry){
        Country country = Country.findById(id);
        if (country == null){
            return editCountry;
        }
        if(country.countryName.equals(editCountry.countryName))
            country.countryName = editCountry.countryName;
        country.persist();
        return country;
    }

    @GET
    @Path("/{id}")
    public Country getCountry(Long id){
        return Country.findById(id);
    }

    @GET
    @Path("/search/{name}")
    public List<Country> getCountries(String name){
        return Country.getCountriesByName(name);
    }
}
