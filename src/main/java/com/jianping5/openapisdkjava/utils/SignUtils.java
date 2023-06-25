package com.jianping5.openapisdkjava.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author jianping5
 * @createDate 25/6/2023 下午 8:54
 */
public class SignUtils {
    /**
     * 生成签名
     * @param body
     * @param secretKey
     * @return
     */
    public static String genSign(String body, String secretKey) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] s1Bytes = body.getBytes(StandardCharsets.UTF_8);
            byte[] s2Bytes = secretKey.getBytes(StandardCharsets.UTF_8);

            digest.update(s1Bytes);
            digest.update(s2Bytes);

            byte[] hashValue = digest.digest();

            StringBuilder hexString = new StringBuilder();
            for (byte b : hashValue) {
                String hex = String.format("%02x", b);
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
