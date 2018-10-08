package com.fgnb.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Created by jiangyitao.
 */
public class TokenUtil {

    private static final String key = "healthmall_tester";

    public static String create(String subject){
        return Jwts.builder().setSubject(subject).signWith(SignatureAlgorithm.HS512, key).compact();
    }

    public static String parse(String token) throws Exception{
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject();
    }

}
