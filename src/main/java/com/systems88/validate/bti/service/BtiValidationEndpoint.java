package com.systems88.validate.bti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.systems88.validate.bti.bean.AuthSessionTokenRequest;
import com.systems88.validate.bti.bean.AuthSessionTokenResponse;
import com.systems88.validate.bti.repository.MemberRepository;

@Endpoint
public class BtiValidationEndpoint {

	private static final String NAMESPACE_URI = "http://validate.systems88.com/bti/bean";

	@Autowired
	private MemberRepository memberRepository;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "AuthSessionTokenRequest")
	@ResponsePayload
	public AuthSessionTokenResponse getAuthSessionTokenResponse(@RequestPayload AuthSessionTokenRequest request) {
		AuthSessionTokenResponse response = new AuthSessionTokenResponse();
		response.setStatusCode("00");
		response.setCurrency("KRW");
		response.setMemberId("1111");

		return response;
	}

}
