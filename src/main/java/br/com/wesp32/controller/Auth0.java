package br.com.wesp32.controller;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

public class Auth0 {

	public String generateToken() {
		String token = null;
		try {
			Algorithm algorithm = Algorithm.HMAC256("secret");
			token = JWT.create().withExpiresAt(new Date(System.currentTimeMillis() + (1 * 60 * 5000)))
					.withIssuer("auth0").
					sign(algorithm);
		} catch (JWTCreationException exception) {
			// Invalid Signing configuration / Couldn't convert Claims.
		}
		return token;
	}

	public String verificToken(String token) {
		try {
			
			Algorithm algorithm = Algorithm.HMAC256("secret");
				JWTVerifier verifier = JWT.require(algorithm)
						.withIssuer("auth0")
		                .acceptExpiresAt(4)
		                .build();
			DecodedJWT jwt = verifier.verify(token);
			return "OK";
		} catch (JWTVerificationException exception) {
			return exception.getMessage();
		}
	}

}
