package net.frozerain.jersey;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/dns")
public class DNSServer {

    DNSResource resource = new DNSResource();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<DNSModel> allRecords(){
        return resource.getAllRecordDB();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public DNSModel currentRecord(@PathParam("id") int id){
        return resource.getRecordDB(id);
    }

    @POST
    @Path("add")
    @Consumes({MediaType.APPLICATION_XML, "text/html"})
    public String createRecord(DNSModel record){
        return (resource.addRecordDB(record)) ? "Record added":"Record failed";
    }

    @PUT
    @Path("update")
    @Consumes({MediaType.APPLICATION_XML, "text/html"})
    public String updateRecord(DNSModel record){
        if (resource.getRecordDB(record.getId())==null){
            return "Record doesn't exists";
        } else {
            resource.updateRecordDB(record);
            return "Record updated";
        }
    }

    @DELETE
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_XML, "text/html"})
    public String deleteRecord(@PathParam("id") int id){
        if (resource.getRecordDB(id)==null){
            return "Record doesn't exists";
        } else {
            resource.deleteRecordDB(id);
            return "Record deleted";
        }
    }
}
