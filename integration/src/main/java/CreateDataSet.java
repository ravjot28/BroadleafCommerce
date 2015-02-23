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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;

public class CreateDataSet {

	public static void main(String[] args) throws IOException {
		String order_updates = null;
		String order_inserts = null;
		String default_batch_fetch_size = null;
		String max_fetch_depth = null;
		String fetch_size = null;
		String batch_size = null;
		String release_mode = null;
		String batch_versioned_data = null;
		String new_generator_mappings = null;
		String use_reflection_optimizer = null;
		for (int i = 0; i < 1024; i++) {
			// resetFile();
			long temp = Long.parseLong(Integer.toBinaryString(i));
			String number = String.format("%010d", temp);
			System.out.println(number);
			int t = 0;
			for (char c : number.toCharArray()) {
				switch (t) {
				case 0:
					if (isTrue("" + c)) {
						order_updates = "true";
					} else {
						order_updates = "false";
					}
					break;
				case 1:
					if (isTrue("" + c)) {
						order_inserts = "true";
					} else {
						order_inserts = "false";
					}
					break;
				case 2:
					if (isTrue("" + c)) {
						default_batch_fetch_size = "0";
					} else {
						default_batch_fetch_size = "100";
					}
					break;
				case 3:
					if (isTrue("" + c)) {
						max_fetch_depth = "0";
					} else {
						max_fetch_depth = "2";
					}
					break;
				case 4:
					if (isTrue("" + c)) {
						fetch_size = "0";
					} else {
						fetch_size = "100";
					}
					break;
				case 5:
					if (isTrue("" + c)) {
						batch_size = "0";
					} else {
						batch_size = "30";
					}
					break;
				case 6:
					if (isTrue("" + c)) {
						release_mode = "on_close";
					} else {
						release_mode = "after_transaction";
					}
					break;
				case 7:
					if (isTrue("" + c)) {
						batch_versioned_data = "true";
					} else {
						batch_versioned_data = "false";
					}
					break;
				case 8:
					if (isTrue("" + c)) {
						new_generator_mappings = "true";
					} else {
						new_generator_mappings = "false";
					}
					break;
				case 9:
					if (isTrue("" + c)) {
						use_reflection_optimizer = "true";
					} else {
						use_reflection_optimizer = "false";
					}
					break;

				}
				t++;
			}
			writeFile(order_updates, order_inserts, default_batch_fetch_size, max_fetch_depth, fetch_size, batch_size,
					release_mode, batch_versioned_data, new_generator_mappings, use_reflection_optimizer);
			String configNumber = "Config" + (i + 1);
			Test.runFor30Times(configNumber);
		}
	}

	private static boolean isTrue(String val) {
		if (val.equals("1"))
			return true;
		return false;
	}

	private static void writeFile(String order_updates, String order_inserts, String default_batch_fetch_size,
			String max_fetch_depth, String fetch_size, String batch_size, String release_mode,
			String batch_versioned_data, String new_generator_mappings, String use_reflection_optimizer)
			throws IOException {
		StringTemplateGroup configTemplateGroup = new StringTemplateGroup("Config",
				"C:\\Users\\Ravjot\\Desktop\\Hibernate_Log_1");
		StringTemplate configs = configTemplateGroup.getInstanceOf("config");
		configs.setAttribute("order_updates", order_updates);
		configs.setAttribute("order_inserts", order_inserts);
		configs.setAttribute("default_batch_fetch_size", default_batch_fetch_size);
		configs.setAttribute("max_fetch_depth", max_fetch_depth);
		configs.setAttribute("fetch_size", fetch_size);
		configs.setAttribute("batch_size", batch_size);
		configs.setAttribute("release_mode", release_mode);
		configs.setAttribute("batch_versioned_data", batch_versioned_data);
		configs.setAttribute("new_generator_mappings", new_generator_mappings);
		configs.setAttribute("use_reflection_optimizer", use_reflection_optimizer);

		String message = configs.toString();
		// System.out.println(message);
		BufferedWriter b = null;
		try {
			b = new BufferedWriter(
					new FileWriter(
							new File(
									"C:\\Users\\Ravjot\\Desktop\\BroadLeaf\\BroadleafCommerce\\integration\\src\\test\\resources\\META-INF\\persistence-test.xml")));
			b.write(message);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			b.close();
		}
	}

}
