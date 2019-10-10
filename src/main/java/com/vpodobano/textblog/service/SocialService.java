package com.vpodobano.textblog.service;

import com.vpodobano.textblog.model.SocialAccount;

public interface SocialService {
	SocialAccount getSocialAccount(String name, String email, String photo, String authToken);
}
