package databases11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;


public class QueryConnection {
	private final String user = "root";
	private final String password = "fran";
	private final String url = "jdbc:mysql://35.184.45.192:3306/MusicianDb?"
			+ "autoReconnect=true&useSSL=false";

	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;


	public QueryConnection() {
		connect();
	}
	private void connect() {
		try {
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();
			System.out.println("Connected!");
		} catch (SQLException e) {
			System.out.println(e);
		}

	}
	public void Options() {
		QueryOptions();
	}

	private void QueryOptions() {
		try{
			Scanner scanner = new Scanner(System.in);
			System.out.println("Please select one of the following options, 0 to exit: \n");
			System.out.println("1: Insert new Musician into the Database \n");
			System.out.println("2: Delete a song from the Database\n");
			System.out.println("3: Change the address of a musician\n");
			System.out.println("4: List albums by a certain musician\n");
			System.out.println("5: List Musicians who know how to play a given instrument ordered alphabetically\n");
			System.out.println("6: List Songs of Desired Album\n");
			System.out.println("7: Number of Albums in 2015\n");
			System.out.println("8: List Musicians who have produced more than the average number of songs in the company\n");
			System.out.println("9: Musicians who play more than two instruments \n");
			System.out.println("10: List Number of Performances by Each Musician\n");
			System.out.println("Input Option here, once you hit enter, scroll up for results:");
			int command = scanner.nextInt();
			scanner.nextLine();
			if (command > 0) {
				switch (command) {
				case 1:
					statement = connection.createStatement();
					Scanner scan = new Scanner(System.in);
					
					System.out.println("Input the SSN of the musician you wish to register: \n");
					String SSN = scan.nextLine();
					
					System.out.println("Input the full name of the musician: \n");
					String name = scan.nextLine();
					
					System.out.println("Input the home address of the musician: \n");
					String address = scan.nextLine();
					
					System.out.println("Input the home phone number: \n");
					int number = scan.nextInt();
			
					String query
					= "INSERT INTO Musician (SSN,Full_Name,Address,House_Number) VALUES (?,?,?,?)";
					PreparedStatement ps = connection.prepareStatement(query);
					ps.setString(1, SSN);
					ps.setString(2, name);
					ps.setString(3, address);
					ps.setInt(4, number);
					ps.executeUpdate();
					//rs = statement.executeQuery(query);
					System.out.println("Submitted information successfully");
					QueryOptions();
					break;
				case 2:
					statement = connection.createStatement();
					query = "Delete from Song where Title=?";
					System.out.println("Input the Title you desire to delete: \n");
					String title = scanner.nextLine();
					ps = connection.prepareStatement(query);
					ps.setString(1, title);
					ps.executeUpdate();
					//rs = statement.executeQuery(query);
					System.out.println("Submitted information successfully");
					QueryOptions();
					break;
				case 3:
					statement = connection.createStatement();
					query = "Update Musician set Address=? where Full_Name=?";
					System.out.println("Input the Musician you desire to alter: \n");
					name = scanner.nextLine();
					System.out.println("Input the new address: \n");
					address = scanner.nextLine();
					ps = connection.prepareStatement(query);
					ps.setString(1, address);
					ps.setString(2, name);
					ps.executeUpdate();
					//rs = statement.executeQuery(query);
					System.out.println("Submitted information successfully");
					QueryOptions();
					break;
				case 4:
					statement = connection.createStatement();
					query = "Select AlbumID, Copyright_Date, Format from Album where SSN = (Select SSN from Musician where Full_Name=?)";
					System.out.println("Input the Musician you desire to list: \n");
					name = scanner.nextLine();
					ps = connection.prepareStatement(query);
					ps.setString(1, name);
					rs = ps.executeQuery();
					System.out.println("The Query result is:\n");
					System.out.println("AlbumID				Copyright 			Format\n");
					while (rs.next()) {
						String id = rs.getString("AlbumID");
						String copyright = rs.getString("Copyright_Date");
						String format = rs.getString("Format");
						
						System.out.printf("%-25s", id);
						System.out.printf("\t%-25s", copyright);
						System.out.printf("\t%-25s\n", format);
						
					}
					//rs = statement.executeQuery(query);
					System.out.println("Submitted information successfully");
					QueryOptions();
					break;
				case 5:
					statement = connection.createStatement();
					query = "Select m.SSN, m.Full_Name, m.Address, m.House_Number from Musician m, Instrument i where m.SSN = i.SSN and i.Full_Name=? order by m.Full_Name DESC";
					System.out.println("Input the instrument you desire to list: \n");
					name = scanner.nextLine();
					ps = connection.prepareStatement(query);
					ps.setString(1, name);
					rs = ps.executeQuery();
					System.out.println("The Query result is:\n");
					System.out.println("SSN				Name				Address 			Number\n");
					while (rs.next()) {
						String SNumber = rs.getString("SSN");
						String FName = rs.getString("Full_Name");
						address = rs.getString("Address");
						long number2 = rs.getLong("House_Number");
						
						System.out.printf("%-25s", SNumber);
						System.out.printf("\t%-25s", FName);
						System.out.printf("\t%-25s", address);
						System.out.printf("\t%-25d\n", number2);
						
					}
					//rs = statement.executeQuery(query);
					System.out.println("Submitted information successfully");
					QueryOptions();
					break;
				case 6:
					statement = connection.createStatement();
					query = "Select s.TrackID, s.Title from Song s, Album a where a.AlbumID=(Select AlbumID from Album where Title=?) and a.AlbumID = s.AlbumID";
					System.out.println("Input the Album you desire to list: \n");
					name = scanner.nextLine();
					ps = connection.prepareStatement(query);
					ps.setString(1, name);
					rs = ps.executeQuery();
					System.out.println("The Query result is:\n");
					System.out.println("TrackID				Title\n");
					while (rs.next()) {
						String Tid = rs.getString("TrackID");
						title = rs.getString("Title");
						
						System.out.printf("%-25s", Tid);
						System.out.printf("\t%-25s\n", title);
						
					}
					//rs = statement.executeQuery(query);
					System.out.println("Submitted information successfully");
					QueryOptions();
					break;
				case 7:
					statement = connection.createStatement();
					query = "Select Count(*) as NoOfAlbums from Album where Copyright_Date between \"1-20-2015\" AND \"11-30-2015\"";
					rs = statement.executeQuery(query);
					System.out.println("The Query result is:\n");
					System.out.println("NoOfAlbums\n");
					while (rs.next()) {
						int count = rs.getInt("NoOfAlbums");
						System.out.printf("%-25d\n", count);
					}
					QueryOptions();
					break;
				case 8:
					statement = connection.createStatement();
					query = "Select m.Full_Name, n.No_Of_Songs from Musician m, Musician_Talents n where No_Of_Songs >=(Select AVG(No_Of_Songs) from Musician_Talents) AND m.SSN = n.SSN";
					rs = statement.executeQuery(query);
					System.out.println("The Query result is:\n");
					System.out.println("Name			Amount Produced\n");
					while (rs.next()) {
						int count = rs.getInt("No_Of_Songs");
						name = rs.getString("Full_Name");
						System.out.printf("%-25s", name);
						System.out.printf("%-25d\n", count);
					}
					QueryOptions();
					break;
				case 9:
					statement = connection.createStatement();
					query = "Select m.Full_Name from Musician m, Musician_Talents n where n.No_Of_Instruments>=2 and m.SSN = n.SSN;";
					rs = statement.executeQuery(query);
					System.out.println("The Query result is:\n");
					System.out.println("Name\n");
					while (rs.next()) {
						name = rs.getString("Full_Name");
						System.out.printf("%s\n", name);
					}
					QueryOptions();
					break;
				case 10:
					statement = connection.createStatement();
					query = "Select n.Full_Name, m.No_Of_Performances from Musician_Talents m, Musician n where m.SSN = n.SSN";
					rs = statement.executeQuery(query);
					System.out.println("The Query result is:\n");
					System.out.println("Name			Performances\n");
					while (rs.next()) {
						name = rs.getString("Full_Name");
						System.out.printf("%-25s", name);
						int count2 = rs.getInt("No_Of_Performances");
						System.out.printf("%-25s\n", count2);
					}
					QueryOptions();
					break;
				default:
					break;

				}
			} else {
				System.out.println("Invalid Command, please start over \n");
				
			}

		} catch (SQLException e) {
			System.out.println(e);

		}
	}
}