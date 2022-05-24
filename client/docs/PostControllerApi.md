# PostControllerApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createPost**](PostControllerApi.md#createPost) | **POST** /v1/post/create | 
[**getAllPosts**](PostControllerApi.md#getAllPosts) | **GET** /v1/post/get/all | 
[**getAllPostsByAuthorId**](PostControllerApi.md#getAllPostsByAuthorId) | **GET** /v1/post/get/all/{authorId} | 
[**getAllPostsByCategory**](PostControllerApi.md#getAllPostsByCategory) | **GET** /v1/post/get/all/{category} | 
[**getAllPostsByLocalization**](PostControllerApi.md#getAllPostsByLocalization) | **GET** /v1/post/get/all/{localization} | 
[**getPostById**](PostControllerApi.md#getPostById) | **GET** /v1/post/get/{id} | 
[**updatePost**](PostControllerApi.md#updatePost) | **PUT** /v1/post/update/{id} | 



## createPost

> createPost(inlineObject1)



### Example

```java
// Import classes:
import com.gametrader.api.invoker.ApiClient;
import com.gametrader.api.invoker.ApiException;
import com.gametrader.api.invoker.Configuration;
import com.gametrader.api.invoker.models.*;
import com.gametrader.api.PostControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        PostControllerApi apiInstance = new PostControllerApi(defaultClient);
        InlineObject1 inlineObject1 = new InlineObject1(); // InlineObject1 | 
        try {
            apiInstance.createPost(inlineObject1);
        } catch (ApiException e) {
            System.err.println("Exception when calling PostControllerApi#createPost");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **inlineObject1** | [**InlineObject1**](InlineObject1.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## getAllPosts

> List&lt;PostDto&gt; getAllPosts()



### Example

```java
// Import classes:
import com.gametrader.api.invoker.ApiClient;
import com.gametrader.api.invoker.ApiException;
import com.gametrader.api.invoker.Configuration;
import com.gametrader.api.invoker.models.*;
import com.gametrader.api.PostControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        PostControllerApi apiInstance = new PostControllerApi(defaultClient);
        try {
            List<PostDto> result = apiInstance.getAllPosts();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PostControllerApi#getAllPosts");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**List&lt;PostDto&gt;**](PostDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## getAllPostsByAuthorId

> List&lt;PostDto&gt; getAllPostsByAuthorId(authorId)



### Example

```java
// Import classes:
import com.gametrader.api.invoker.ApiClient;
import com.gametrader.api.invoker.ApiException;
import com.gametrader.api.invoker.Configuration;
import com.gametrader.api.invoker.models.*;
import com.gametrader.api.PostControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        PostControllerApi apiInstance = new PostControllerApi(defaultClient);
        Long authorId = 56L; // Long | 
        try {
            List<PostDto> result = apiInstance.getAllPostsByAuthorId(authorId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PostControllerApi#getAllPostsByAuthorId");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorId** | **Long**|  |

### Return type

[**List&lt;PostDto&gt;**](PostDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## getAllPostsByCategory

> List&lt;PostDto&gt; getAllPostsByCategory(category)



### Example

```java
// Import classes:
import com.gametrader.api.invoker.ApiClient;
import com.gametrader.api.invoker.ApiException;
import com.gametrader.api.invoker.Configuration;
import com.gametrader.api.invoker.models.*;
import com.gametrader.api.PostControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        PostControllerApi apiInstance = new PostControllerApi(defaultClient);
        String category = "GAMES"; // String | 
        try {
            List<PostDto> result = apiInstance.getAllPostsByCategory(category);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PostControllerApi#getAllPostsByCategory");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **category** | **String**|  | [enum: GAMES, LAPTOPS]

### Return type

[**List&lt;PostDto&gt;**](PostDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## getAllPostsByLocalization

> List&lt;PostDto&gt; getAllPostsByLocalization(localization)



### Example

```java
// Import classes:
import com.gametrader.api.invoker.ApiClient;
import com.gametrader.api.invoker.ApiException;
import com.gametrader.api.invoker.Configuration;
import com.gametrader.api.invoker.models.*;
import com.gametrader.api.PostControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        PostControllerApi apiInstance = new PostControllerApi(defaultClient);
        String localization = "localization_example"; // String | 
        try {
            List<PostDto> result = apiInstance.getAllPostsByLocalization(localization);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PostControllerApi#getAllPostsByLocalization");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **localization** | **String**|  |

### Return type

[**List&lt;PostDto&gt;**](PostDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## getPostById

> PostDto getPostById(id)



### Example

```java
// Import classes:
import com.gametrader.api.invoker.ApiClient;
import com.gametrader.api.invoker.ApiException;
import com.gametrader.api.invoker.Configuration;
import com.gametrader.api.invoker.models.*;
import com.gametrader.api.PostControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        PostControllerApi apiInstance = new PostControllerApi(defaultClient);
        Long id = 56L; // Long | 
        try {
            PostDto result = apiInstance.getPostById(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PostControllerApi#getPostById");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**|  |

### Return type

[**PostDto**](PostDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## updatePost

> updatePost(inlineObject)



### Example

```java
// Import classes:
import com.gametrader.api.invoker.ApiClient;
import com.gametrader.api.invoker.ApiException;
import com.gametrader.api.invoker.Configuration;
import com.gametrader.api.invoker.models.*;
import com.gametrader.api.PostControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        PostControllerApi apiInstance = new PostControllerApi(defaultClient);
        InlineObject inlineObject = new InlineObject(); // InlineObject | 
        try {
            apiInstance.updatePost(inlineObject);
        } catch (ApiException e) {
            System.err.println("Exception when calling PostControllerApi#updatePost");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **inlineObject** | [**InlineObject**](InlineObject.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

