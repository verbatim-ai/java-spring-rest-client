# WidgetApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**attachment**](WidgetApi.md#attachment) | **GET** /v1/webhook/widget/attachment/{postId} | Get source attachments of a post |
| [**getSession**](WidgetApi.md#getSession) | **GET** /webhook/v1/widget/{lang} |  |
| [**init**](WidgetApi.md#init) | **GET** /v1/webhook/widget/init | Init a session |
| [**postMessage**](WidgetApi.md#postMessage) | **POST** /webhook/v1/widget/{lang} |  |
| [**posts**](WidgetApi.md#posts) | **GET** /v1/webhook/widget/ | List posts in a session |
| [**query**](WidgetApi.md#query) | **GET** /v1/webhook/widget/q | Post a query in a session |



## attachment

> WidgetAttachmentResponse attachment(postId)

Get source attachments of a post

Returns every source document that the AI cited when generating a SYSTEM post. For each document the response includes its summary, metadata, and **presigned preview URLs** for every page that was actually retrieved (1-based index). Two sizes are provided per page — &#x60;previewSmallUrl&#x60; (SMALL) and &#x60;previewSmallLarge&#x60; (MEDIUM) — so the widget can render a thumbnail and a full-size lightbox view without additional round-trips. All presigned URLs share the same &#x60;previewExpirationDate&#x60;; refresh by calling this endpoint again after expiry. The post must belong to the organisation identified by the Access Token.

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.WidgetApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure API key authorization: AccessToken
        ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
        AccessToken.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //AccessToken.setApiKeyPrefix("Token");

        WidgetApi apiInstance = new WidgetApi(defaultClient);
        UUID postId = UUID.fromString("c2e5f3a1-4d6b-5c7e-9f8a-0b1c2d3e4f5a"); // UUID | Id of the post whose source attachments are fetched
        try {
            WidgetAttachmentResponse result = apiInstance.attachment(postId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WidgetApi#attachment");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **postId** | **UUID**| Id of the post whose source attachments are fetched | |

### Return type

[**WidgetAttachmentResponse**](WidgetAttachmentResponse.md)

### Authorization

[AccessToken](../README.md#AccessToken)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **500** | Internal error. Check body to get more info |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **200** | Attachments resolved with presigned preview URLs |  -  |


## getSession

> WidgetSessionResponseLegacy getSession(lang, cid, sid)



### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.WidgetApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        WidgetApi apiInstance = new WidgetApi(defaultClient);
        String lang = "lang_example"; // String | 
        String cid = "cid_example"; // String | 
        UUID sid = UUID.randomUUID(); // UUID | 
        try {
            WidgetSessionResponseLegacy result = apiInstance.getSession(lang, cid, sid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WidgetApi#getSession");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **lang** | **String**|  | |
| **cid** | **String**|  | |
| **sid** | **UUID**|  | |

### Return type

[**WidgetSessionResponseLegacy**](WidgetSessionResponseLegacy.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **500** | Internal error. Check body to get more info |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **200** | OK |  -  |


## init

> WidgetSessionResponse init(widgetSessionRequest)

Init a session

Init a new session with a context : name and a search context, defined by a list of Corpus UID

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.WidgetApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure API key authorization: AccessToken
        ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
        AccessToken.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //AccessToken.setApiKeyPrefix("Token");

        WidgetApi apiInstance = new WidgetApi(defaultClient);
        WidgetSessionRequest widgetSessionRequest = new WidgetSessionRequest(); // WidgetSessionRequest | 
        try {
            WidgetSessionResponse result = apiInstance.init(widgetSessionRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WidgetApi#init");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **widgetSessionRequest** | [**WidgetSessionRequest**](WidgetSessionRequest.md)|  | |

### Return type

[**WidgetSessionResponse**](WidgetSessionResponse.md)

### Authorization

[AccessToken](../README.md#AccessToken)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **500** | Internal error. Check body to get more info |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **200** | session is ready |  -  |


## postMessage

> WidgetMessageResponse postMessage(lang, cid, sid, widgetSessionRequestBody)



### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.WidgetApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        WidgetApi apiInstance = new WidgetApi(defaultClient);
        String lang = "lang_example"; // String | 
        String cid = "cid_example"; // String | 
        UUID sid = UUID.randomUUID(); // UUID | 
        WidgetSessionRequestBody widgetSessionRequestBody = new WidgetSessionRequestBody(); // WidgetSessionRequestBody | 
        try {
            WidgetMessageResponse result = apiInstance.postMessage(lang, cid, sid, widgetSessionRequestBody);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WidgetApi#postMessage");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **lang** | **String**|  | |
| **cid** | **String**|  | |
| **sid** | **UUID**|  | |
| **widgetSessionRequestBody** | [**WidgetSessionRequestBody**](WidgetSessionRequestBody.md)|  | |

### Return type

[**WidgetMessageResponse**](WidgetMessageResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **500** | Internal error. Check body to get more info |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **200** | OK |  -  |


## posts

> WidgetPostsResponse posts(sessionId)

List posts in a session

Returns the full chronological history of a session — both user queries (&#x60;owner: USER&#x60;) and AI answers (&#x60;owner: SYSTEM&#x60;). Each item includes the message text, language, timestamp, and the number of source document chunks cited (&#x60;attachment&#x60; count). The session must belong to the organisation identified by the Access Token.

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.WidgetApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure API key authorization: AccessToken
        ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
        AccessToken.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //AccessToken.setApiKeyPrefix("Token");

        WidgetApi apiInstance = new WidgetApi(defaultClient);
        UUID sessionId = UUID.fromString("8f3e9c7a-2b14-4d6e-9c1a-7a5b8e3f1d2c"); // UUID | Id of the session where the posts are fetched
        try {
            WidgetPostsResponse result = apiInstance.posts(sessionId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WidgetApi#posts");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **sessionId** | **UUID**| Id of the session where the posts are fetched | |

### Return type

[**WidgetPostsResponse**](WidgetPostsResponse.md)

### Authorization

[AccessToken](../README.md#AccessToken)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **500** | Internal error. Check body to get more info |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **200** | Post history retrieved |  -  |


## query

> WidgetQueryResponse query(sessionId, query, lang)

Post a query in a session

User query is posted in the session. AI backend system answer to this query

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.WidgetApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure API key authorization: AccessToken
        ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
        AccessToken.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //AccessToken.setApiKeyPrefix("Token");

        WidgetApi apiInstance = new WidgetApi(defaultClient);
        UUID sessionId = UUID.fromString("abcd-1234-efjk-5678"); // UUID | Id of the session where the query is fired
        String query = "What is the address of our customer BCorp. "; // String | The user's query
        String lang = "fr"; // String | ISO language code use by the model 
        try {
            WidgetQueryResponse result = apiInstance.query(sessionId, query, lang);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WidgetApi#query");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **sessionId** | **UUID**| Id of the session where the query is fired | |
| **query** | **String**| The user&#39;s query | |
| **lang** | **String**| ISO language code use by the model  | [optional] [default to fr] |

### Return type

[**WidgetQueryResponse**](WidgetQueryResponse.md)

### Authorization

[AccessToken](../README.md#AccessToken)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **500** | Internal error. Check body to get more info |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **200** | Answer is ready |  -  |

