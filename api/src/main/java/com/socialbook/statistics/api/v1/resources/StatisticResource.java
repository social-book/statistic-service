package com.socialbook.statistics.api.v1.resources;

import com.socialbook.statistic.entites.Statistic;
import com.socialbook.statistic.services.StatisticBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@RequestScoped
@Path("/statistics")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StatisticResource {

    @Context
    protected UriInfo uriInfo;

    @Inject
    StatisticBean statisticBean;

    @GET
    public Response getAll() {
        List<Statistic> statistics = statisticBean.getData();
        if (statistics != null) return Response.ok(statistics).header("X-Total-Count", statistics.size()).build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    public Response addNewStat(Statistic statistic) {
        statisticBean.insertStat(statistic);
        return Response.status(Response.Status.CREATED).build();
    }

}
