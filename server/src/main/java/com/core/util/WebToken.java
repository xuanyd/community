package com.core.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.HashMap;
import java.util.Map;

public class WebToken {

	public static String createToken(String username, String passord) throws Exception{
		Map<String, Object> map = new HashMap<>();
		map.put("alg", "HS256");
		map.put("type","JWT");
		String token = JWT.create().withHeader(map)
				.withClaim("name", "admin")
				.withClaim("password","123").sign(Algorithm.HMAC256(Constant.JWT_SECRET));
		return token;
	}

	public static void verifyToken(String token) throws Exception{
		JWTVerifier verifier = JWT.require(Algorithm.HMAC256(Constant.JWT_SECRET)).build();
		DecodedJWT jwt = verifier.verify(token);
		Map<String, Claim> claims = jwt.getClaims();
		System.out.println(claims.get("name").asString());
	}
	public static void main(String[] args) throws Exception{
		String token = createToken("admin", "123");
		verifyToken(token);
	}
}