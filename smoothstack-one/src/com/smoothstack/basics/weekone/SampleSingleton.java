package com.smoothstack.basics.weekone;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Changes from the provided class:
 *  - The instance now has the volatile modifier, to specify to the JVM that its current value should always be returned
 *  by getInstance
 *  - getInstance now checks if the instance is null, then does so again in a synchronized block, so that only one thread
 *  can make an instance of SampleSingleton
 *  - added a stub of a constructor
 *  - added a try-catch for the SQLException that many of the lines in databaseQuery can throw
 *  - called the input's intValue method so as not to directly multiply an integer with a BigDecimal
 *
 */
public class SampleSingleton {
	
	private static Connection conn = null;
	
	volatile private static SampleSingleton instance = null;
	
	private SampleSingleton() {
		//Do things related to setting up the database connection, perhaps
	}
	
	public static SampleSingleton getInstance() {
		if (instance == null) {
			synchronized (SampleSingleton.class) {
				if (instance == null) {
					instance = new SampleSingleton();
				}
			}
		}
		return instance;
	}
	
	public static void databaseQuery(BigDecimal input) {
		try {
			conn = DriverManager.getConnection("url of database");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select id from table");
			int x = 0;
			while(rs.next()) {
				x = rs.getInt(1) * input.intValue();
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}
}
