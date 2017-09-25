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


@Path("register")
public class Register {

	ObjectMapper mapper=new ObjectMapper();
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	public Response newRegistration(String data){
		try {
			UserParse ud=mapper.readValue(data,UserParse.class);
			if(!Validator.validate(ud)){
				return Response.status(404).entity("not registerd").build();
			}
			DataSource ds=new DataSource();
			Statement stmt= ds.getStatement();
			ResultSet eff=stmt.executeQuery("select * from user_details where name='"+ud.getUser()
													+"' and pass='"+ud.getPass()+"';");
			if(eff.next()){
				return Response.status(404).entity("Alredy registerd").build();
			}
			stmt.executeUpdate("insert into user_details values('"+ud.getUser()+"' ,'"+ud.getPass()+"');");
			
		} catch (IOException e) {
			return Response.status(404).entity("not registerd").build();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return Response.status(404).entity("not registerd").build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(404).entity("not registerd").build();
		}
		return Response.status(202).entity("registerd").build();
		
	}
}
