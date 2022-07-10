package com.educaciencia.fastcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/******************************************************
 *************** EDUCACIENCIA FAST CODE ***************
 *************** CHAMADA REST - API JAVA **************
 ******************************************************/

public class ChamadaRest_API_Java {

	/** Metodo Main */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// insertAPI_Java();// Post
		// getAPI_Java(); // Get
		// getIdAPI_Java(); // Get Id
		updateAPI_Java();// Update
	}


	/** GET */
	public static void getAPI_Java() {
		try {
			String endpoint = "http://localhost:8080/api/JPA/educaciencia/clientes/get";

			URL url = new URL(endpoint);
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

	/** GET */
	public static void getIdAPI_Java() {
		try {

			String id = "1";
			String endpoint = "http://localhost:8080/api/JPA/educaciencia/clientes/get/" + id;

			URL url = new URL(endpoint);
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

	/** POST */
	public static void insertAPI_Java() {
		try {

			String endpoint = "http://localhost:8080/api/JPA/educaciencia/clientes/post/";

			URL url = new URL(endpoint);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String input = "{\"nome\":\"EducaCiencia FastCode\",\"email\":\"eduaciencia-fastcode@outlook.com.br\"}";
			// System.out.println(input);
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				System.out.println("Inserido novo dado.");
			} else {
				System.out.println("falha!");
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

	/** PUT */
	public static void updateAPI_Java() {
		try {

			String id = "4";
			String endpoint = "http://localhost:8080/api/JPA/educaciencia/clientes/put/" + id;

			URL url = new URL(endpoint);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("PUT");
			conn.setRequestProperty("Content-Type", "application/json");

            //  String input = "{\"id\":\"4\",\"nome\":\"upate.Eduaciencia Fastcode\",\"email\":\"upate.eduaciencia-fastcode@outlook.com.br\"}";
			String input = "{" + "\"id\":\"4\"," + "\"nome\":\"update.Eduaciencia Fastcode\","
					+ "\"email\":\"update.eduaciencia-fastcode@outlook.com.br\"" + "}";
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
