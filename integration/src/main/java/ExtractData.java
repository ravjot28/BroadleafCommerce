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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExtractData {
	public static void process(String configNumber) throws IOException {
		long updatePet = 0;
		long getPetTypes = 0;
		long findPet = 0;
		long findPet1 = 0;
		long findPet2 = 0;
		long findVets = 0;
		long updateOwner = 0;
		long insertPet = 0;
		long findSingleOwner = 0;
		long findSingleOwner1 = 0;
		long insertOwner = 0;
		long insertVisit = 0;
		long findOwners = 0;

		BufferedReader b = null;
		try {
			b = new BufferedReader(new FileReader(new File("C:\\Users\\Ravjot\\Desktop\\HibernateLogs\\hibernate.log")));
			String line = b.readLine();
			int i = 0;
			while (line != null) {
				if (line.contains("nanoseconds spent executing") && line.endsWith("JDBC statements;")) {
					System.out.println(line.substring(line.indexOf("o.s.s.p.s.AbstractClinicServiceTests -")+"o.s.s.p.s.AbstractClinicServiceTests -".length(), line.indexOf("nanoseconds")).trim());
					switch (i) {
					case 0:
						updatePet += Long.parseLong(line.substring(line.indexOf("o.s.s.p.s.AbstractClinicServiceTests -")+"o.s.s.p.s.AbstractClinicServiceTests -".length(), line.indexOf("nanoseconds")).trim());
						break;
					case 1:
						getPetTypes += Long.parseLong(line.substring(line.indexOf("o.s.s.p.s.AbstractClinicServiceTests -")+"o.s.s.p.s.AbstractClinicServiceTests -".length(), line.indexOf("nanoseconds")).trim());
						break;
					case 2:
						findPet += Long.parseLong(line.substring(line.indexOf("o.s.s.p.s.AbstractClinicServiceTests -")+"o.s.s.p.s.AbstractClinicServiceTests -".length(), line.indexOf("nanoseconds")).trim());
						break;
					case 3:
						findPet1 += Long.parseLong(line.substring(line.indexOf("o.s.s.p.s.AbstractClinicServiceTests -")+"o.s.s.p.s.AbstractClinicServiceTests -".length(), line.indexOf("nanoseconds")).trim());
						break;
					case 4:
						findPet2 += Long.parseLong(line.substring(line.indexOf("o.s.s.p.s.AbstractClinicServiceTests -")+"o.s.s.p.s.AbstractClinicServiceTests -".length(), line.indexOf("nanoseconds")).trim());
						break;
					case 5:
						findVets += Long.parseLong(line.substring(line.indexOf("o.s.s.p.s.AbstractClinicServiceTests -")+"o.s.s.p.s.AbstractClinicServiceTests -".length(), line.indexOf("nanoseconds")).trim());
						break;
					case 6:
						updateOwner += Long.parseLong(line.substring(line.indexOf("o.s.s.p.s.AbstractClinicServiceTests -")+"o.s.s.p.s.AbstractClinicServiceTests -".length(), line.indexOf("nanoseconds")).trim());
						break;
					case 7:
						insertPet += Long.parseLong(line.substring(line.indexOf("o.s.s.p.s.AbstractClinicServiceTests -")+"o.s.s.p.s.AbstractClinicServiceTests -".length(), line.indexOf("nanoseconds")).trim());
						break;
					case 8:
						findSingleOwner += Long.parseLong(line.substring(line.indexOf("o.s.s.p.s.AbstractClinicServiceTests -")+"o.s.s.p.s.AbstractClinicServiceTests -".length(), line.indexOf("nanoseconds")).trim());
						break;
					case 9:
						findSingleOwner1 += Long.parseLong(line.substring(line.indexOf("o.s.s.p.s.AbstractClinicServiceTests -")+"o.s.s.p.s.AbstractClinicServiceTests -".length(), line.indexOf("nanoseconds")).trim());
						break;
					case 10:
						insertOwner += Long.parseLong(line.substring(line.indexOf("o.s.s.p.s.AbstractClinicServiceTests -")+"o.s.s.p.s.AbstractClinicServiceTests -".length(), line.indexOf("nanoseconds")).trim());
						break;
					case 11:
						insertVisit += Long.parseLong(line.substring(line.indexOf("o.s.s.p.s.AbstractClinicServiceTests -")+"o.s.s.p.s.AbstractClinicServiceTests -".length(), line.indexOf("nanoseconds")).trim());
						break;
					case 12:
						findOwners += Long.parseLong(line.substring(line.indexOf("o.s.s.p.s.AbstractClinicServiceTests -")+"o.s.s.p.s.AbstractClinicServiceTests -".length(), line.indexOf("nanoseconds")).trim());
						break;
					}
					if (i == 12) {
						i = 0;
					} else {
						i++;
					}

				}

				line = b.readLine();
			}

			System.out.println("updatePet " + updatePet / 30);
			System.out.println("getPetTypes " + getPetTypes / 30);
			System.out.println("findPet " + findPet / 30);
			System.out.println("findPet1 " + findPet1 / 30);
			System.out.println("findPet2 " + findPet2 / 30);
			System.out.println("updatePet " + findVets / 30);
			System.out.println("insertPet " + insertPet / 30);
			System.out.println("updateOwner " + updateOwner / 30);
			System.out.println("findSingleOwner " + findSingleOwner / 30);
			System.out.println("findSingleOwner1 " + findSingleOwner1 / 30);
			System.out.println("insertOwner " + insertOwner / 30);
			System.out.println("insertVisit " + insertVisit / 30);
			System.out.println("findOwners " + findOwners / 30);

			String sFileName = "DataCollected.csv";

			try {
				FileWriter writer = null;
				if (!new File(sFileName).exists()) {
					writer = new FileWriter(sFileName, true);
					writer.append("Configurations");
					writer.append(',');
					writer.append("updatePet");
					writer.append(',');
					writer.append("getPetTypes");
					writer.append(',');
					writer.append("findPet");
					writer.append(',');
					writer.append("findPet1");
					writer.append(',');
					writer.append("findPet2");
					writer.append(',');
					writer.append("updatePet");
					writer.append(',');
					writer.append("insertPet");
					writer.append(',');
					writer.append("updateOwner");
					writer.append(',');
					writer.append("findSingleOwner");
					writer.append(',');
					writer.append("findSingleOwner1");
					writer.append(',');
					writer.append("insertOwner");
					writer.append(',');
					writer.append("insertVisit");
					writer.append(',');
					writer.append("findOwners");
					writer.append('\n');
					writer.append(configNumber);
					writer.append(',');
					writer.append("" + (updatePet / 30));
					writer.append(',');
					writer.append("" + (getPetTypes / 30));
					writer.append(',');
					writer.append("" + (findPet / 30));
					writer.append(',');
					writer.append("" + (findPet1 / 30));
					writer.append(',');
					writer.append("" + (findPet2 / 30));
					writer.append(',');
					writer.append("" + (findVets / 30));
					writer.append(',');
					writer.append("" + (insertPet / 30));
					writer.append(',');
					writer.append("" + (updateOwner / 30));
					writer.append(',');
					writer.append("" + (findSingleOwner / 30));
					writer.append(',');
					writer.append("" + (findSingleOwner1 / 30));
					writer.append(',');
					writer.append("" + (insertOwner / 30));
					writer.append(',');
					writer.append("" + (insertVisit / 30));
					writer.append(',');
					writer.append("" + (findOwners / 30));
					writer.append('\n');
				} else {
					writer = new FileWriter(sFileName, true);
					writer.append(configNumber);
					writer.append(',');
					writer.append("" + (updatePet / 30));
					writer.append(',');
					writer.append("" + (getPetTypes / 30));
					writer.append(',');
					writer.append("" + (findPet / 30));
					writer.append(',');
					writer.append("" + (findPet1 / 30));
					writer.append(',');
					writer.append("" + (findPet2 / 30));
					writer.append(',');
					writer.append("" + (findVets / 30));
					writer.append(',');
					writer.append("" + (insertPet / 30));
					writer.append(',');
					writer.append("" + (updateOwner / 30));
					writer.append(',');
					writer.append("" + (findSingleOwner / 30));
					writer.append(',');
					writer.append("" + (findSingleOwner1 / 30));
					writer.append(',');
					writer.append("" + (insertOwner / 30));
					writer.append(',');
					writer.append("" + (insertVisit / 30));
					writer.append(',');
					writer.append("" + (findOwners / 30));
					writer.append('\n');
				}

				writer.flush();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			b.close();
		}
	}

}
