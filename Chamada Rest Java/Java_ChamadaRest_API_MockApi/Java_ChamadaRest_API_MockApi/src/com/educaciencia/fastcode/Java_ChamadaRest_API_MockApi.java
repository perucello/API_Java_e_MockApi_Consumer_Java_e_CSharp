package com.educaciencia.fastcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/******************************************************
 *************** EDUCACIENCIA FAST CODE ***************
 ************ CHAMADA REST - API MOCKAPI **************
 ******************************************************/

public class Java_ChamadaRest_API_MockApi {

	public static void main(String[] args) {

		// insertAPIMock();// Post
		// getAPIMock(); // Get
		// getIdAPIMock(); // Get Id
		// updateAPIMock();// Update
	}

	public static void getAPIMock() {
		try {

			String endpointMockio = "https://600607e63698a80017de12e2.mockapi.io/EducaCiencia";

			URL url = new URL(endpointMockio);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			if (conn.getResponseCode() == 200) {
				System.out.print("HTTP code : " + conn.getResponseCode());
			} else {
				System.out.print("deu erro... HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output, json = "";
			while ((output = br.readLine()) != null) {
				json += output;
			}
			System.out.println("\nResult: " + json);

			conn.disconnect();
		} catch (IOException e) {
			System.out.println("Exception " + e);
		}
	}

	public static void getIdAPIMock() {
		try {

			String id = "1";
			String endpointMockio = "https://600607e63698a80017de12e2.mockapi.io/EducaCiencia" + id;

			URL url = new URL(endpointMockio);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			if (conn.getResponseCode() == 200) {
				System.out.println("HTTP code : " + conn.getResponseCode());
			} else {
				System.out.println("HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output, json = "";
			while ((output = br.readLine()) != null) {
				json += output;
			}
			System.out.println("\n" + json);

			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void insertAPIMock() {
		try {

			String endpointMockio = "https://600607e63698a80017de12e2.mockapi.io/EducaCiencia";

			URL url = new URL(endpointMockio);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String input = "{\"nome\":\"EducaCiencia FastCode\",\"email\":\"eduaciencia-fastcode@outlook.com.br\"}";
			// System.out.println(input);
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void updateAPIMock() {
		try {

			String id = "4";
			String endpointMockio = "https://600607e63698a80017de12e2.mockapi.io/EducaCiencia/" + id;

			URL url = new URL(endpointMockio);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("PUT");
			conn.setRequestProperty("Content-Type", "application/json");

			String input = "{\"nome\":\"Update - EducaCiencia FastCode\",\"email\":\"upate.eduaciencia-fastcode@outlook.com.br\"}";
			// System.out.println(input);
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Update from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println("\n" + output);
			}

			conn.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
