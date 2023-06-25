package com.jianping5.openapisdkjava;

import com.jianping5.openapisdkjava.client.OpenApiClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static com.jianping5.openapisdkjava.utils.SignUtils.genSign;

@SpringBootTest
class OpenApiSdkJavaApplicationTests {

    @Resource
    private OpenApiClient openApiClient;

    @Test
    void contextLoads() {
        String s = genSign("1", "2");
        System.out.println(s);

        String s1 = openApiClient.sayHelloUsingGet();
        System.out.println(s1);

        String nameByIdUsingPost = openApiClient.getNameByIdUsingPost("{\"id\":1}");
        System.out.println(nameByIdUsingPost);
    }

}
