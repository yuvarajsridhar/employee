package com.yuvaraj.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;

public class SendToMobile {
     
	public static final String account_sid="ACa2169a93e328550129ac91cf457ec535";
	public static final String auth_token="b224a4cdac3725b491f254ce9ba52bf3";
	public static final String twilio_number="+17576934845";
	
	public void sendSms(String num) throws TwilioRestException {
		System.out.println("1");
		TwilioRestClient client=new TwilioRestClient(account_sid,auth_token);
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("Body", num));
		params.add(new BasicNameValuePair("To", "+919659791607")); //Add real number here
		params.add(new BasicNameValuePair("From", twilio_number));
		  MessageFactory messageFactory = client.getAccount().getMessageFactory();
	        Message message = messageFactory.create(params);
	        System.out.println(message.getSid());
	        
	}
	
}