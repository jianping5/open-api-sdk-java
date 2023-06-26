package com.jianping5.openapisdkjava.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;

import java.util.HashMap;
import java.util.Map;

import static com.jianping5.openapisdkjava.utils.SignUtils.genSign;

/**
 * @author jianping5
 * @createDate 25/6/2023 下午 8:53
 */
public class OpenApiClient {
    private static final String GATEWAY_HOST = "http://localhost:3000";

    private String accessKey;

    private String secretKey;

    public OpenApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public String sayHelloUsingGet() {
        HashMap<String, Object> paramMap = new HashMap<>();
        HttpResponse httpResponse = HttpRequest.get(GATEWAY_HOST + "/api/hello")
                .addHeaders(getHeaderMap(""))
                .execute();
        String result = httpResponse.body();
        return result;
    }

    private Map<String, String> getHeaderMap(String body) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("accessKey", accessKey);
        hashMap.put("nonce", RandomUtil.randomNumbers(4));
        hashMap.put("body", body);
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("sign", genSign(body, secretKey));
        return hashMap;
    }

    public String getNameByIdUsingPost(String body) {
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST + "/api/name")
                .addHeaders(getHeaderMap(body))
                .body(body)
                .execute();
        String result = httpResponse.body();
        return result;
    }
}
