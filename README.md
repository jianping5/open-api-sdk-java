# Open-API Java SDK

## 快速开始
### 1. 引入 sdk（暂未上传）
```xml
<dependency>
    <groupId>com.jianping5</groupId>
    <artifactId>open-api-sdk-java</artifactId>
    <version>0.0.1</version>
</dependency>
```

### 2. 添加配置
```yaml
openapi:
  accessKey: 你的 accessKey
  secretKey: 你的 secretKey
```

### 3. 创建 client
```Java
// 方法 1：自主 new 对象
String accessKey = "你的 accessKey";
String secretKey = "你的 secretKey";
OpenApiClient client = new OpenApiClient (accessKey, secretKey);

// 方法 2：通过配置注入对象
修改配置：
openapi:
    access-key: 你的 access-key
    secret-key: 你的 secret-key
    
@Resource
private OpenApiClient client;
```

### 4. 接口调用示例代码
```Java
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
```

## API 文档
### 1. 你好
方法名：SayHelloUsingGet

方法类型：GET

请求参数：无

响应参数：data 响应结果

### 2. 根据 ID 获取姓名
方法名：GetNameByIdUsingPost

方法类型：POST

请求参数：id int

响应参数：data 响应结果

