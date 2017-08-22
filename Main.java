package databases11;
import java.util.*;
import databases11.QueryConnection;
import java.sql.*;
import java.util.Date;


/**
 * @author Francisco Delger
 *
 */
public class Main {
	public static void main(String args[]) {
		System.out.println("Connecting...");
		QueryConnection QueryConnect = new QueryConnection();
		QueryConnect.Options();
		
	}
}
