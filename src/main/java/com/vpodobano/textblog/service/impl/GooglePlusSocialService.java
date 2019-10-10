package com.vpodobano.textblog.service.impl;



//import java.io.IOException;
//import java.security.GeneralSecurityException;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;


import com.vpodobano.textblog.model.SocialAccount;
import com.vpodobano.textblog.service.SocialService;

public class GooglePlusSocialService implements SocialService {
//	private final String googlePlusClientId;
//	private final List<String> issuers;
	
	public GooglePlusSocialService(ServiceManager serviceManager) {
//		this.googlePlusClientId = serviceManager.getApplicationProperty("social.googleplus.clienId");
//		this.issuers = Arrays.asList(new String[]{"https://accounts.google.com", "accounts.google.com"});
	}

	@Override
	public SocialAccount getSocialAccount(String name, String email, String photo, String authToken) {
//		try {
//			GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), JacksonFactory.getDefaultInstance())
//					.setAudience(Collections.singletonList(googlePlusClientId))
//					.setIssuers(issuers).build();
//			GoogleIdToken idToken = verifier.verify(authToken);
//
//		
//			if (idToken != null) {
//				Payload payload = idToken.getPayload();
//				String emaill = payload.getEmail();
				return new SocialAccount(email, name, photo);
//			} else {
//				throw new ApplicationException("Can't get account by authToken: " + authToken);
//			}
//		} catch(GeneralSecurityException | IOException e) {
//			throw new ApplicationException(e);
//		}
	}

}
