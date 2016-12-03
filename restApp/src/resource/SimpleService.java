package resource;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("sample")
public class SimpleService {
     
    @Path("greet")
    @GET
    public String doGreet() {
        return "Hello Stranger, the time is "+ new Date();
    }
}