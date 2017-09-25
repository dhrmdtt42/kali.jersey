package kali.jersey;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;

@Path("update")
public class Update {


	ObjectMapper mapper=new ObjectMapper();
	
	@POST
	@Path("/delete")
	@Produces(MediaType.TEXT_HTML)
	public Response newRegistration(String data){
		try {
			UserParse ud=mapper.readValue(data,UserParse.class);
			if(!Validator.validate(ud)){
				return Response.status(404).entity("Fill Complete Details").build();
			}
			DataSource ds=new DataSource();
			Statement stmt= ds.getStatement();
			int aff=stmt.executeUpdate("delete from user_details where name='"+ud.getUser()+"' and pass='"+ud.getPass()+"';");
			if(aff==0){
				return Response.status(404).entity("User Does NOT EXIST").build();
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
		return Response.status(202).entity("Successfully DELETED").build();
	}
	
	@POST
	@Path("/update")
	@Produces(MediaType.TEXT_HTML)
	public Response updateUser(String data){
		try {
			UpdateUserParse ud=mapper.readValue(data,UpdateUserParse.class);
			if(!Validator.validateUD(ud)){
				return Response.status(404).entity("Fill Complete Details").build();
			}
			DataSource ds=new DataSource();
			Statement stmt= ds.getStatement();
			int aff=stmt.executeUpdate("update user_details set name='"+ud.getNewUser()+"' , pass='"+ud.getNewPass()
												+"' where name='"+ud.getUser()+"' and pass='"+ud.getPass()+"';");
			if(aff==0){
				return Response.status(404).entity("User Does NOT EXIST").build();
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
		return Response.status(202).entity("Successfully UPDATED").build();
	}
}