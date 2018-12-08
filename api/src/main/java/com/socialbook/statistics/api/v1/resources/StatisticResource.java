package com.socialbook.statistics.api.v1.resources;

import com.socialbook.statistic.entites.Statistic;
import com.socialbook.statistic.services.StatisticsBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestScoped
@Path("/statistics")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StatisticResource {

    @Context
    protected UriInfo uriInfo;

    @Inject
    StatisticsBean statisticBean;

    @GET
    public Response getAll() {
        List<Statistic> statistics = statisticBean.getData();
        if (statistics != null) return Response.ok(statistics).header("X-Total-Count", statistics.size()).build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/collect/{service_name}")
    public Response addNewStatGet(@PathParam("service_name") String serviceName) {
        Statistic statistic = new Statistic();
        statistic.setService_name(serviceName);
        return addNewStat(statistic);
    }

    @POST
    @Path("/collect")
    public Response addNewStat(Statistic statistic) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd, HH:mm: ss");
        Date date = new Date();
        statistic.setTimestamp(sdf.format(date.getTime()) + "");
        statisticBean.insertStat(statistic);
        return Response.status(Response.Status.CREATED).build();
    }

}
