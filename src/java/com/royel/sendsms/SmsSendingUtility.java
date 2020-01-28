package com.royel.sendsms;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.util.Random;

public class SmsSendingUtility {

	private final static String USER_AGENT = "Mozilla/5.0";

	public static int sendGet(String mobileNo, String message) throws Exception {

		String token = "use_sms_service_provider_token";
		String urlParameters = "token=" + token + "&" + "to=" + mobileNo + "&" + "message=" + message;
		String url = "use_sms_service_provider_url?" + urlParameters;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();

		System.out.println("\nSending message request...");
		System.out.println("Response Code : " + responseCode);
		System.out.println("Response code in returning");

		return responseCode;
	}
	
	public static boolean isInternetConnectionAvailable(){
		
		Socket socket = new Socket();
		InetSocketAddress address = new InetSocketAddress("google.com", 80);
		
		try {
			socket.connect(address, 3000);
			return true;			
		} catch (IOException e) {
			return false;
			
		}finally {
			try {socket.close();}
			catch (IOException e) {}
		}				
	}
	

	// genrate random number from
	public static int generateRandomNumber() {

		Random rnd = new Random();
		int n = 100000 + rnd.nextInt(900000);
		return n;
	}

	// check valid mobile number..
	public static boolean checkPhoneNumber(String phoneNumber) {

		String firstThreeDigit = phoneNumber.substring(0, 3);

		if (firstThreeDigit.equals("015") || firstThreeDigit.equals("016") || firstThreeDigit.equals("017")
				|| firstThreeDigit.equals("018") || firstThreeDigit.equals("019")) {

			return (phoneNumber.length() == 11) ? true : false;

		}

		return false;
	}

}
