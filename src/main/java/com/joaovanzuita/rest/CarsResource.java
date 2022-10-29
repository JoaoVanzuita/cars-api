package com.joaovanzuita.rest;

import com.joaovanzuita.domain.Car;
import com.joaovanzuita.domain.CarService;
import com.joaovanzuita.domain.Response;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/cars")
@Produces(MediaType.APPLICATION_JSON+"charset=UTF-8")
@Consumes(MediaType.APPLICATION_JSON+"charset=UTF-8")
public class CarsResource {
    private final CarService carService = CarService.getInstace();

    @GET
    public List<Car> getCars(){
        return carService.getCars();
    }
    @GET
    @Path("{id}")
    public Car get(@PathParam("id") long id){
        return carService.getCar(id);
    }
    @GET
    @Path("{type}")
    public List<Car> getByType(@PathParam("type") String type){
        return carService.findByType(type);
    }
    @GET
    @Path("{name}")
    public List<Car> getByName(@PathParam("name") String name){
        return carService.findByName(name);
    }
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("{id}") long id){
        carService.deleteCar(id);
        return Response.OK("Car deleted successfully");
    }
    @POST
    public Response post(Car car){
        carService.saveCar(car);
        return Response.OK("Car saved successfully");
    }
    @PUT
    public Response put(Car car){
        carService.saveCar(car);
        return Response.OK("Car updated successfully");
    }
}
