package kali.jersey;



import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;

@Path("retrive")
public class Retrive {


	ObjectMapper mapper=new ObjectMapper();
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	public Response newRegistration(String data){
		try {
			UserParse ud=mapper.readValue(data,UserParse.class);
			if(!Validator.validate(ud)){
			//	return Response.status(404).entity("Fill Complete Details").build();
			}
			DataSource ds=new DataSource();
			Statement stmt= ds.getStatement();
			ResultSet eff=stmt.executeQuery("select * from user_details where name='"+ud.getUser()
			+"' and pass='"+ud.getPass()+"';");
			
			if(eff.next()){
				ud.setUser(eff.getString(1));ud.setPass(eff.getString(2));
				return Response.status(201).entity(mapper.writeValueAsString(ud)).build(); 
			}
		} catch (IOException e) {
			return Response.status(404).entity("something went wront").build();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return Response.status(404).entity("something went wront").build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(404).entity("something went wront").build();
		}
	
		return Response.status(404).entity("User does not exist").build();
	}
	
	
}