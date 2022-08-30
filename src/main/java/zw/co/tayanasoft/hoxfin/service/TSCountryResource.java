package zw.co.tayanasoft.hoxfin.service;

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
}
