# ThreadApi

All URIs are relative to *https://api.verbatim-ai.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**callList**](ThreadApi.md#callList) | **GET** /v1/session/ | List threads |
| [**create**](ThreadApi.md#create) | **POST** /v1/session/ | Create a thread |
| [**create1**](ThreadApi.md#create1) | **POST** /v1/thread/ | Create a thread |
| [**delete**](ThreadApi.md#delete) | **DELETE** /v1/session/{threadId} | Delete a thread |
| [**delete1**](ThreadApi.md#delete1) | **DELETE** /v1/thread/{threadId} | Delete a thread |
| [**get**](ThreadApi.md#get) | **GET** /v1/session/{threadId} | Get a thread |
| [**get1**](ThreadApi.md#get1) | **GET** /v1/thread/{threadId} | Get a thread |
| [**list1**](ThreadApi.md#list1) | **GET** /v1/thread/ | List threads |
| [**search**](ThreadApi.md#search) | **GET** /v1/thread/q | Search threads |
| [**search1**](ThreadApi.md#search1) | **GET** /v1/session/q | Search threads |
| [**update**](ThreadApi.md#update) | **PATCH** /v1/session/{threadId} | Update a thread |
| [**update1**](ThreadApi.md#update1) | **PATCH** /v1/thread/{threadId} | Update a thread |



## callList

> ThreadListResponse callList(pageSize, pageIndex)

List threads

Paginate every thread of the caller&#39;s organization, newest first.  The organization is resolved from the JWT, so there is nothing to pass and no way to ask for another tenant&#39;s threads. A thread belongs to an organization as soon as one of its corpora does.  The ordering is closed by the thread id, so walking &#x60;pageIndex&#x60; never shows the same thread twice nor skips one when several were opened in the same millisecond. &#x60;total&#x60; counts every thread in the organization, not just those returned here.  To narrow the result — by user, by corpus, by metadata, or by any combination of the three — use &#x60;GET /v1/thread/q&#x60;, which takes the same paging parameters. 

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.ThreadApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.verbatim-ai.com");
        
        // Configure HTTP bearer authorization: JWT
        HttpBearerAuth JWT = (HttpBearerAuth) defaultClient.getAuthentication("JWT");
        JWT.setBearerToken("BEARER TOKEN");

        // Configure API key authorization: AccessToken
        ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
        AccessToken.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //AccessToken.setApiKeyPrefix("Token");

        ThreadApi apiInstance = new ThreadApi(defaultClient);
        Integer pageSize = 25; // Integer | Number of items per page, 1-100.
        Integer pageIndex = 0; // Integer | Zero-based page index.
        try {
            ThreadListResponse result = apiInstance.callList(pageSize, pageIndex);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ThreadApi#callList");
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
| **pageSize** | **Integer**| Number of items per page, 1-100. | [optional] [default to 25] |
| **pageIndex** | **Integer**| Zero-based page index. | [optional] [default to 0] |

### Return type

[**ThreadListResponse**](ThreadListResponse.md)

### Authorization

[JWT](../README.md#JWT), [AccessToken](../README.md#AccessToken)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **500** | Internal error. Check body to get more info |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | Page of threads. |  -  |


## create

> ThreadCreateResponse create(sessionCreateRequest)

Create a thread

Open a new conversation thread against one or more corpora. The thread is attached to the user carried by the caller&#39;s JWT. How its queries are answered is not decided here: the agent named on each query decides, so a thread carries the corpora, the owner and whatever metadata you attach to it.

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.ThreadApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.verbatim-ai.com");
        
        // Configure HTTP bearer authorization: JWT
        HttpBearerAuth JWT = (HttpBearerAuth) defaultClient.getAuthentication("JWT");
        JWT.setBearerToken("BEARER TOKEN");

        // Configure API key authorization: AccessToken
        ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
        AccessToken.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //AccessToken.setApiKeyPrefix("Token");

        ThreadApi apiInstance = new ThreadApi(defaultClient);
        SessionCreateRequest sessionCreateRequest = new SessionCreateRequest(); // SessionCreateRequest | 
        try {
            ThreadCreateResponse result = apiInstance.create(sessionCreateRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ThreadApi#create");
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
| **sessionCreateRequest** | [**SessionCreateRequest**](SessionCreateRequest.md)|  | |

### Return type

[**ThreadCreateResponse**](ThreadCreateResponse.md)

### Authorization

[JWT](../README.md#JWT), [AccessToken](../README.md#AccessToken)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **500** | Internal error. Check body to get more info |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | Thread created. |  -  |


## create1

> ThreadCreateResponse create1(sessionCreateRequest)

Create a thread

Open a new conversation thread against one or more corpora. The thread is attached to the user carried by the caller&#39;s JWT. How its queries are answered is not decided here: the agent named on each query decides, so a thread carries the corpora, the owner and whatever metadata you attach to it.

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.ThreadApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.verbatim-ai.com");
        
        // Configure HTTP bearer authorization: JWT
        HttpBearerAuth JWT = (HttpBearerAuth) defaultClient.getAuthentication("JWT");
        JWT.setBearerToken("BEARER TOKEN");

        // Configure API key authorization: AccessToken
        ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
        AccessToken.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //AccessToken.setApiKeyPrefix("Token");

        ThreadApi apiInstance = new ThreadApi(defaultClient);
        SessionCreateRequest sessionCreateRequest = new SessionCreateRequest(); // SessionCreateRequest | 
        try {
            ThreadCreateResponse result = apiInstance.create1(sessionCreateRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ThreadApi#create1");
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
| **sessionCreateRequest** | [**SessionCreateRequest**](SessionCreateRequest.md)|  | |

### Return type

[**ThreadCreateResponse**](ThreadCreateResponse.md)

### Authorization

[JWT](../README.md#JWT), [AccessToken](../README.md#AccessToken)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **500** | Internal error. Check body to get more info |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | Thread created. |  -  |


## delete

> AckResponse delete(threadId)

Delete a thread

Soft-delete a thread. **Cascades** to every post in the thread (also soft-deleted). Documents and embeddings are **not** affected.

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.ThreadApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.verbatim-ai.com");
        
        // Configure HTTP bearer authorization: JWT
        HttpBearerAuth JWT = (HttpBearerAuth) defaultClient.getAuthentication("JWT");
        JWT.setBearerToken("BEARER TOKEN");

        // Configure API key authorization: AccessToken
        ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
        AccessToken.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //AccessToken.setApiKeyPrefix("Token");

        ThreadApi apiInstance = new ThreadApi(defaultClient);
        UUID threadId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the thread to delete.
        try {
            AckResponse result = apiInstance.delete(threadId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ThreadApi#delete");
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
| **threadId** | **UUID**| ID of the thread to delete. | |

### Return type

[**AckResponse**](AckResponse.md)

### Authorization

[JWT](../README.md#JWT), [AccessToken](../README.md#AccessToken)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **500** | Internal error. Check body to get more info |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | Thread and posts deleted. |  -  |


## delete1

> AckResponse delete1(threadId)

Delete a thread

Soft-delete a thread. **Cascades** to every post in the thread (also soft-deleted). Documents and embeddings are **not** affected.

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.ThreadApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.verbatim-ai.com");
        
        // Configure HTTP bearer authorization: JWT
        HttpBearerAuth JWT = (HttpBearerAuth) defaultClient.getAuthentication("JWT");
        JWT.setBearerToken("BEARER TOKEN");

        // Configure API key authorization: AccessToken
        ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
        AccessToken.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //AccessToken.setApiKeyPrefix("Token");

        ThreadApi apiInstance = new ThreadApi(defaultClient);
        UUID threadId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the thread to delete.
        try {
            AckResponse result = apiInstance.delete1(threadId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ThreadApi#delete1");
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
| **threadId** | **UUID**| ID of the thread to delete. | |

### Return type

[**AckResponse**](AckResponse.md)

### Authorization

[JWT](../README.md#JWT), [AccessToken](../README.md#AccessToken)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **500** | Internal error. Check body to get more info |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | Thread and posts deleted. |  -  |


## get

> Thread get(threadId)

Get a thread

Fetch a thread&#39;s metadata (user, corpora, model, system prompt, parameters). Use &#x60;GET /v1/post&#x60; to retrieve its posts.

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.ThreadApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.verbatim-ai.com");
        
        // Configure HTTP bearer authorization: JWT
        HttpBearerAuth JWT = (HttpBearerAuth) defaultClient.getAuthentication("JWT");
        JWT.setBearerToken("BEARER TOKEN");

        // Configure API key authorization: AccessToken
        ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
        AccessToken.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //AccessToken.setApiKeyPrefix("Token");

        ThreadApi apiInstance = new ThreadApi(defaultClient);
        UUID threadId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the thread.
        try {
            Thread result = apiInstance.get(threadId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ThreadApi#get");
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
| **threadId** | **UUID**| ID of the thread. | |

### Return type

[**Thread**](Thread.md)

### Authorization

[JWT](../README.md#JWT), [AccessToken](../README.md#AccessToken)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **500** | Internal error. Check body to get more info |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | Thread found. |  -  |


## get1

> Thread get1(threadId)

Get a thread

Fetch a thread&#39;s metadata (user, corpora, model, system prompt, parameters). Use &#x60;GET /v1/post&#x60; to retrieve its posts.

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.ThreadApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.verbatim-ai.com");
        
        // Configure HTTP bearer authorization: JWT
        HttpBearerAuth JWT = (HttpBearerAuth) defaultClient.getAuthentication("JWT");
        JWT.setBearerToken("BEARER TOKEN");

        // Configure API key authorization: AccessToken
        ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
        AccessToken.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //AccessToken.setApiKeyPrefix("Token");

        ThreadApi apiInstance = new ThreadApi(defaultClient);
        UUID threadId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the thread.
        try {
            Thread result = apiInstance.get1(threadId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ThreadApi#get1");
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
| **threadId** | **UUID**| ID of the thread. | |

### Return type

[**Thread**](Thread.md)

### Authorization

[JWT](../README.md#JWT), [AccessToken](../README.md#AccessToken)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **500** | Internal error. Check body to get more info |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | Thread found. |  -  |


## list1

> ThreadListResponse list1(pageSize, pageIndex)

List threads

Paginate every thread of the caller&#39;s organization, newest first.  The organization is resolved from the JWT, so there is nothing to pass and no way to ask for another tenant&#39;s threads. A thread belongs to an organization as soon as one of its corpora does.  The ordering is closed by the thread id, so walking &#x60;pageIndex&#x60; never shows the same thread twice nor skips one when several were opened in the same millisecond. &#x60;total&#x60; counts every thread in the organization, not just those returned here.  To narrow the result — by user, by corpus, by metadata, or by any combination of the three — use &#x60;GET /v1/thread/q&#x60;, which takes the same paging parameters. 

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.ThreadApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.verbatim-ai.com");
        
        // Configure HTTP bearer authorization: JWT
        HttpBearerAuth JWT = (HttpBearerAuth) defaultClient.getAuthentication("JWT");
        JWT.setBearerToken("BEARER TOKEN");

        // Configure API key authorization: AccessToken
        ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
        AccessToken.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //AccessToken.setApiKeyPrefix("Token");

        ThreadApi apiInstance = new ThreadApi(defaultClient);
        Integer pageSize = 25; // Integer | Number of items per page, 1-100.
        Integer pageIndex = 0; // Integer | Zero-based page index.
        try {
            ThreadListResponse result = apiInstance.list1(pageSize, pageIndex);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ThreadApi#list1");
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
| **pageSize** | **Integer**| Number of items per page, 1-100. | [optional] [default to 25] |
| **pageIndex** | **Integer**| Zero-based page index. | [optional] [default to 0] |

### Return type

[**ThreadListResponse**](ThreadListResponse.md)

### Authorization

[JWT](../README.md#JWT), [AccessToken](../README.md#AccessToken)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **500** | Internal error. Check body to get more info |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | Page of threads. |  -  |


## search

> ThreadListResponse search(userId, corpusId, key, value, json, pageSize, pageIndex)

Search threads

Find threads of the caller&#39;s organization by owner, corpus and metadata.  Every filter is optional and they **narrow together**: a request carrying none of them returns the whole organization — the same answer as &#x60;GET /v1/thread/&#x60; — and one carrying several returns only the threads matching all of them. That is what this endpoint adds over the &#x60;by…&#x60; listings it replaces, which each answer one fixed combination.  The organization is never a parameter. It comes from the JWT and is always applied, so no combination of filters reaches another tenant&#39;s threads.  ### Owner — &#x60;userId&#x60;  Exact match on the identifier carried by the JWT when the thread was opened. Sent empty (&#x60;&amp;userId&#x3D;&#x60;) it is treated as absent rather than as a match on the empty string.  ### Corpus — &#x60;corpusId&#x60;  Keeps threads bound to that corpus. A thread may be bound to several, and it matches as soon as one of them is the requested one. The corpus must belong to the caller&#39;s organization.  ### Metadata — &#x60;key&#x60;/&#x60;value&#x60;, or &#x60;json&#x60;  Matches threads whose metadata **contains** the fragment (PostgreSQL&#39;s &#x60;@&gt;&#x60; operator), extra keys on the thread being fine. Pass &#x60;key&#x60; and &#x60;value&#x60; for a single pair — they go together, one without the other is a &#x60;400&#x60; — or &#x60;json&#x60; for a raw object when the filter is nested or has several keys. &#x60;json&#x60; wins when both are supplied.  ### Ordering and paging  Newest first, closed by the thread id, so walking &#x60;pageIndex&#x60; never shows the same thread twice nor skips one. &#x60;total&#x60; counts every match across all pages.  ### Examples  * &#x60;?userId&#x3D;user_42&#x60; — every thread that user opened, across corpora * &#x60;?corpusId&#x3D;…&#x60; — every thread opened against one corpus, whoever opened it * &#x60;?userId&#x3D;user_42&amp;corpusId&#x3D;…&#x60; — both, which &#x60;GET /v1/thread/byUser&#x60; also did * &#x60;?userId&#x3D;user_42&amp;key&#x3D;customer_id&amp;value&#x3D;42&#x60; — the combination none of the   &#x60;by…&#x60; endpoints could express * &#x60;?json&#x3D;{\&quot;channel\&quot;:{\&quot;kind\&quot;:\&quot;web\&quot;}}&#x60; — a nested metadata fragment 

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.ThreadApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.verbatim-ai.com");
        
        // Configure HTTP bearer authorization: JWT
        HttpBearerAuth JWT = (HttpBearerAuth) defaultClient.getAuthentication("JWT");
        JWT.setBearerToken("BEARER TOKEN");

        // Configure API key authorization: AccessToken
        ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
        AccessToken.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //AccessToken.setApiKeyPrefix("Token");

        ThreadApi apiInstance = new ThreadApi(defaultClient);
        String userId = "user_42"; // String | Exact identifier of the user who opened the thread. Blank or omitted, the owner is not filtered.
        UUID corpusId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | Keep threads bound to this corpus. Must belong to the caller's organization.
        String key = "customer_id"; // String | Metadata key to filter on. Goes together with `value`.
        String value = "42"; // String | Metadata value matching `key`.
        String json = "{\"customer_id\":\"42\"}"; // String | Raw JSON object used as the containment filter. Wins over `key`/`value` when set.
        Integer pageSize = 25; // Integer | Number of items per page, 1-100.
        Integer pageIndex = 0; // Integer | Zero-based page index.
        try {
            ThreadListResponse result = apiInstance.search(userId, corpusId, key, value, json, pageSize, pageIndex);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ThreadApi#search");
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
| **userId** | **String**| Exact identifier of the user who opened the thread. Blank or omitted, the owner is not filtered. | [optional] |
| **corpusId** | **UUID**| Keep threads bound to this corpus. Must belong to the caller&#39;s organization. | [optional] |
| **key** | **String**| Metadata key to filter on. Goes together with &#x60;value&#x60;. | [optional] |
| **value** | **String**| Metadata value matching &#x60;key&#x60;. | [optional] |
| **json** | **String**| Raw JSON object used as the containment filter. Wins over &#x60;key&#x60;/&#x60;value&#x60; when set. | [optional] |
| **pageSize** | **Integer**| Number of items per page, 1-100. | [optional] [default to 25] |
| **pageIndex** | **Integer**| Zero-based page index. | [optional] [default to 0] |

### Return type

[**ThreadListResponse**](ThreadListResponse.md)

### Authorization

[JWT](../README.md#JWT), [AccessToken](../README.md#AccessToken)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **500** | Internal error. Check body to get more info |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **400** | A metadata filter is malformed, or a paging parameter is out of bounds. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | Page of matching threads. |  -  |


## search1

> ThreadListResponse search1(userId, corpusId, key, value, json, pageSize, pageIndex)

Search threads

Find threads of the caller&#39;s organization by owner, corpus and metadata.  Every filter is optional and they **narrow together**: a request carrying none of them returns the whole organization — the same answer as &#x60;GET /v1/thread/&#x60; — and one carrying several returns only the threads matching all of them. That is what this endpoint adds over the &#x60;by…&#x60; listings it replaces, which each answer one fixed combination.  The organization is never a parameter. It comes from the JWT and is always applied, so no combination of filters reaches another tenant&#39;s threads.  ### Owner — &#x60;userId&#x60;  Exact match on the identifier carried by the JWT when the thread was opened. Sent empty (&#x60;&amp;userId&#x3D;&#x60;) it is treated as absent rather than as a match on the empty string.  ### Corpus — &#x60;corpusId&#x60;  Keeps threads bound to that corpus. A thread may be bound to several, and it matches as soon as one of them is the requested one. The corpus must belong to the caller&#39;s organization.  ### Metadata — &#x60;key&#x60;/&#x60;value&#x60;, or &#x60;json&#x60;  Matches threads whose metadata **contains** the fragment (PostgreSQL&#39;s &#x60;@&gt;&#x60; operator), extra keys on the thread being fine. Pass &#x60;key&#x60; and &#x60;value&#x60; for a single pair — they go together, one without the other is a &#x60;400&#x60; — or &#x60;json&#x60; for a raw object when the filter is nested or has several keys. &#x60;json&#x60; wins when both are supplied.  ### Ordering and paging  Newest first, closed by the thread id, so walking &#x60;pageIndex&#x60; never shows the same thread twice nor skips one. &#x60;total&#x60; counts every match across all pages.  ### Examples  * &#x60;?userId&#x3D;user_42&#x60; — every thread that user opened, across corpora * &#x60;?corpusId&#x3D;…&#x60; — every thread opened against one corpus, whoever opened it * &#x60;?userId&#x3D;user_42&amp;corpusId&#x3D;…&#x60; — both, which &#x60;GET /v1/thread/byUser&#x60; also did * &#x60;?userId&#x3D;user_42&amp;key&#x3D;customer_id&amp;value&#x3D;42&#x60; — the combination none of the   &#x60;by…&#x60; endpoints could express * &#x60;?json&#x3D;{\&quot;channel\&quot;:{\&quot;kind\&quot;:\&quot;web\&quot;}}&#x60; — a nested metadata fragment 

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.ThreadApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.verbatim-ai.com");
        
        // Configure HTTP bearer authorization: JWT
        HttpBearerAuth JWT = (HttpBearerAuth) defaultClient.getAuthentication("JWT");
        JWT.setBearerToken("BEARER TOKEN");

        // Configure API key authorization: AccessToken
        ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
        AccessToken.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //AccessToken.setApiKeyPrefix("Token");

        ThreadApi apiInstance = new ThreadApi(defaultClient);
        String userId = "user_42"; // String | Exact identifier of the user who opened the thread. Blank or omitted, the owner is not filtered.
        UUID corpusId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | Keep threads bound to this corpus. Must belong to the caller's organization.
        String key = "customer_id"; // String | Metadata key to filter on. Goes together with `value`.
        String value = "42"; // String | Metadata value matching `key`.
        String json = "{customer_id=42}"; // String | Raw JSON object used as the containment filter. Wins over `key`/`value` when set.
        Integer pageSize = 25; // Integer | Number of items per page, 1-100.
        Integer pageIndex = 0; // Integer | Zero-based page index.
        try {
            ThreadListResponse result = apiInstance.search1(userId, corpusId, key, value, json, pageSize, pageIndex);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ThreadApi#search1");
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
| **userId** | **String**| Exact identifier of the user who opened the thread. Blank or omitted, the owner is not filtered. | [optional] |
| **corpusId** | **UUID**| Keep threads bound to this corpus. Must belong to the caller&#39;s organization. | [optional] |
| **key** | **String**| Metadata key to filter on. Goes together with &#x60;value&#x60;. | [optional] |
| **value** | **String**| Metadata value matching &#x60;key&#x60;. | [optional] |
| **json** | **String**| Raw JSON object used as the containment filter. Wins over &#x60;key&#x60;/&#x60;value&#x60; when set. | [optional] |
| **pageSize** | **Integer**| Number of items per page, 1-100. | [optional] [default to 25] |
| **pageIndex** | **Integer**| Zero-based page index. | [optional] [default to 0] |

### Return type

[**ThreadListResponse**](ThreadListResponse.md)

### Authorization

[JWT](../README.md#JWT), [AccessToken](../README.md#AccessToken)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **500** | Internal error. Check body to get more info |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **400** | A metadata filter is malformed, or a paging parameter is out of bounds. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | Page of matching threads. |  -  |


## update

> Thread update(threadId, threadUpdateRequest)

Update a thread

Patch one or more thread attributes. Only the fields provided in the request body are updated; omitted fields keep their current value. Returns the full updated thread.

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.ThreadApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.verbatim-ai.com");
        
        // Configure HTTP bearer authorization: JWT
        HttpBearerAuth JWT = (HttpBearerAuth) defaultClient.getAuthentication("JWT");
        JWT.setBearerToken("BEARER TOKEN");

        // Configure API key authorization: AccessToken
        ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
        AccessToken.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //AccessToken.setApiKeyPrefix("Token");

        ThreadApi apiInstance = new ThreadApi(defaultClient);
        UUID threadId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the thread to update.
        ThreadUpdateRequest threadUpdateRequest = new ThreadUpdateRequest(); // ThreadUpdateRequest | 
        try {
            Thread result = apiInstance.update(threadId, threadUpdateRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ThreadApi#update");
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
| **threadId** | **UUID**| ID of the thread to update. | |
| **threadUpdateRequest** | [**ThreadUpdateRequest**](ThreadUpdateRequest.md)|  | |

### Return type

[**Thread**](Thread.md)

### Authorization

[JWT](../README.md#JWT), [AccessToken](../README.md#AccessToken)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **500** | Internal error. Check body to get more info |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | Thread updated. |  -  |


## update1

> Thread update1(threadId, threadUpdateRequest)

Update a thread

Patch one or more thread attributes. Only the fields provided in the request body are updated; omitted fields keep their current value. Returns the full updated thread.

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.ThreadApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.verbatim-ai.com");
        
        // Configure HTTP bearer authorization: JWT
        HttpBearerAuth JWT = (HttpBearerAuth) defaultClient.getAuthentication("JWT");
        JWT.setBearerToken("BEARER TOKEN");

        // Configure API key authorization: AccessToken
        ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
        AccessToken.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //AccessToken.setApiKeyPrefix("Token");

        ThreadApi apiInstance = new ThreadApi(defaultClient);
        UUID threadId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the thread to update.
        ThreadUpdateRequest threadUpdateRequest = new ThreadUpdateRequest(); // ThreadUpdateRequest | 
        try {
            Thread result = apiInstance.update1(threadId, threadUpdateRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ThreadApi#update1");
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
| **threadId** | **UUID**| ID of the thread to update. | |
| **threadUpdateRequest** | [**ThreadUpdateRequest**](ThreadUpdateRequest.md)|  | |

### Return type

[**Thread**](Thread.md)

### Authorization

[JWT](../README.md#JWT), [AccessToken](../README.md#AccessToken)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **500** | Internal error. Check body to get more info |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | Thread updated. |  -  |

