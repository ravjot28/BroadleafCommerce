/*
 * #%L
 * BroadleafCommerce Integration
 * %%
 * Copyright (C) 2009 - 2015 Broadleaf Commerce
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;

import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.Invoker;
import org.apache.maven.shared.invoker.MavenInvocationException;

public class Test {

	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/broadleaf";
	private static Connection connection = null;
	public static Statement statement = null;

	public static void main(String[] args) throws IOException {
		// runFor30Times("");
		long startTime = System.currentTimeMillis();
		process("");
		System.out.println((System.currentTimeMillis() - startTime));
	}

	public static void runFor30Times(String configNumber) {
		for (int i = 0; i < 30; i++) {
			try {
				process(configNumber);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void process(String configNumber) throws IOException {
		initSQLServer();
		InvocationRequest request = new DefaultInvocationRequest();
		request.setPomFile(new File("C:\\Users\\Ravjot\\Desktop\\BroadLeaf\\BroadleafCommerce\\integration\\pom.xml"));
		request.setGoals(Collections.singletonList("clean package"));
		Invoker invoker = new DefaultInvoker();
		invoker.setMavenHome(new File("C:\\apache-maven-3.2.3\\"));
		try {
			invoker.execute(request);
		} catch (MavenInvocationException e) {
			e.printStackTrace();
		}
	}

	private static void initSQLServer() {
		try {
			Class.forName(DRIVER).newInstance();
			try {
				connection = DriverManager.getConnection(DATABASE_URL, "root", "admin");

				String sql = "DROP DATABASE broadleaf";

				Statement statement = connection.createStatement();
				statement.executeUpdate(sql);
				statement.close();

				sql = "CREATE DATABASE broadleaf";

				statement = connection.createStatement();
				statement.executeUpdate(sql);
				statement.close();

			} catch (SQLException e) {
				System.out.println("SQLException: " + e.getMessage());
				System.out.println("SQLState: " + e.getSQLState());
				System.out.println("VendorError: " + e.getErrorCode());
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
