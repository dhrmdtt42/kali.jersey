package kali.jersey;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

   
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt(String data) throws ClassNotFoundException, SQLException {
    	System.out.println(data);
    	DataSource ds=new DataSource();
		Statement stmt= ds.getStatement();
		ResultSet rs=stmt.executeQuery("select * from user_account");
		rs.next();
    	File f=new File("/dharam.txt");
    	if(f.exists()){
    		String s="can not read";
    		if(f.canRead()){
    			s="can read";
    		}
    		
        return rs.getString(5);}
    	else 
    		return "no00kjn";
    }
}
