package core;

import java.io.IOException;
import java.util.Properties;

public class Internal {
	Properties propfile = new Properties();

	String getPropertyIn(String prop_file, String property) throws IOException {
		propfile.load(ClassLoader.getSystemResourceAsStream(prop_file));
		return propfile.getProperty(property);
	}

	public static void main(String[] args) throws IOException {
		String pf_in = "inside.properties";
		if (!pf_in.contains(".properties")) {
			System.err.println("Must be an properties file");
			System.exit(1);
		}
		Internal propfile = new Internal();
		System.out.println("Title: \t\t\t\t" + propfile.getPropertyIn(pf_in, "location"));

		System.out.println("First Name: \t\t\t" + propfile.getPropertyIn(pf_in, "name"));

		System.out.println("Last Name: \t\t\t" + propfile.getPropertyIn(pf_in, "nickname"));

		System.out.println("Current directory: \t\t" + System.getProperty("user.dir"));

		System.out.println("Properties file location: \t" + new java.io.File(pf_in).getCanonicalPath());

	}
}
