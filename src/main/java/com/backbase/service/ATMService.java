package com.backbase.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import com.backbase.model.ATMAddress;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ATMService {

	private static final String EXTERNAL_URL = "https://www.ing.nl/api/locator/atms/";

	public ArrayList<ATMAddress> getATMsByCity(String city) throws JsonParseException, JsonMappingException, IOException {
		ArrayList<ATMAddress> resultList = null;
			String s = readStringFromUrl();
			// String stringData = getStringFromUrl();
//			File file = new File("/Users/akhilkarun/atms.json");
			ArrayList<ATMAddress> readValue = convertJSONtoArrayList(s
					.substring(5));
			ArrayList<ATMAddress> items = readValue;
			resultList = new ArrayList<ATMAddress>();
			for (ATMAddress item : items) {
				if (city.equals(item.getAddress().getCity()))
					resultList.add(item);

			}
		return resultList;
	}

	public ArrayList<ATMAddress> getAllATMs() {
		ArrayList<ATMAddress> readList = null;
		try {
			// String stringData = getStringFromUrl();
//			File file = new File("/Users/akhilkarun/atms.json");
			String s = readStringFromUrl();
			readList = convertJSONtoArrayList(s
					.substring(5));
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return readList;
	}

	private ArrayList<ATMAddress> convertJSONtoArrayList(String s)
			throws IOException, JsonParseException, JsonMappingException {
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<ATMAddress> readValue = mapper.readValue(
				s,
				mapper.getTypeFactory().constructCollectionType(List.class,
						ATMAddress.class));
		return readValue;
	}

	private String getStringFromUrl() throws IOException, MalformedURLException {
		return IOUtils
				.toString(new URL(EXTERNAL_URL), Charset.forName("UTF-8"));
	}

	public static String readStringFromUrl() throws IOException {
		InputStream is = new URL(EXTERNAL_URL).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is,
					Charset.forName("UTF-8")));
			String str = readAll(rd);
			return str;
		} finally {
			is.close();
		}
	}

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

}
