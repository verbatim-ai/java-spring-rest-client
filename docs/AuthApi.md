# AuthApi

All URIs are relative to *https://api.verbatim-ai.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**create3**](AuthApi.md#create3) | **POST** /v1/auth/access-token/ | Create an access token |
| [**list3**](AuthApi.md#list3) | **GET** /v1/auth/access-token/ | List access tokens |
| [**revoke**](AuthApi.md#revoke) | **DELETE** /v1/auth/access-token/{token} | Revoke an access token by value |
| [**revokeById**](AuthApi.md#revokeById) | **DELETE** /v1/auth/access-token/id/{id} | Revoke an access token by id |
| [**scopes**](AuthApi.md#scopes) | **GET** /v1/auth/access-token/scopes | List the available scopes |
| [**whoami**](AuthApi.md#whoami) | **GET** /v1/auth/whoami | Who am I |



## create3

> AccessTokenCreateResponse create3(accessTokenCreateRequest)

Create an access token

Mint a short-lived opaque access token for the caller&#39;s organization. Send it as the &#x60;X-Access-Token&#x60; header on &#x60;/v1/&#x60; API calls.  **The &#x60;token&#x60; value is only ever returned here.** Store it or hand it over now: the listing shows only its first characters, and no call returns it again.  - &#x60;scope&#x60; is mandatory and non-empty — a list of &#x60;DOMAIN:ACTION&#x60; entries such as   &#x60;corpus:read&#x60;. &#x60;GET /v1/auth/access-token/scopes&#x60; lists every valid entry. - &#x60;ttl&#x60; is in seconds: 3600 (1 hour) when omitted, at least 10, and no more than the   ceiling the platform sets (&#x60;app.access-token.max-ttl-seconds&#x60;, 86400 — 24 hours — by   default). A longer &#x60;ttl&#x60; is refused with a 400, not shortened. - &#x60;issuer&#x60;, &#x60;email&#x60; and &#x60;userId&#x60; are free labels stored with the token and shown in the   listing; &#x60;userId&#x60; and &#x60;email&#x60; are also what &#x60;GET /v1/auth/whoami&#x60; answers for it.  Only reachable with a JWT: an access token cannot mint another. 

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.AuthApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.verbatim-ai.com");
        
        // Configure HTTP bearer authorization: JWT
        HttpBearerAuth JWT = (HttpBearerAuth) defaultClient.getAuthentication("JWT");
        JWT.setBearerToken("BEARER TOKEN");

        AuthApi apiInstance = new AuthApi(defaultClient);
        AccessTokenCreateRequest accessTokenCreateRequest = new AccessTokenCreateRequest(); // AccessTokenCreateRequest | 
        try {
            AccessTokenCreateResponse result = apiInstance.create3(accessTokenCreateRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AuthApi#create3");
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
| **accessTokenCreateRequest** | [**AccessTokenCreateRequest**](AccessTokenCreateRequest.md)|  | |

### Return type

[**AccessTokenCreateResponse**](AccessTokenCreateResponse.md)

### Authorization

[JWT](../README.md#JWT)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **500** | Internal error. Check body to get more info |  -  |
| **403** | No JWT, or the call was made with an access token. |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **400** | Missing or invalid &#x60;scope&#x60;, or &#x60;ttl&#x60; below 10 seconds or above the platform ceiling. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **413** | The request body exceeds the size accepted by the endpoint. |  -  |
| **200** | Access token created. |  -  |


## list3

> AccessTokenListResponse list3(pageSize, pageIndex)

List access tokens

List the access tokens of the caller&#39;s organization, newest first, with every attribute stored for them — **except the token value**, which is cut down to its first characters followed by &#x60;...&#x60;. The full value is only returned by the create call.  Expired tokens stay listed (compare &#x60;expiresAt&#x60; with the current time) until they are revoked. Use an item&#39;s &#x60;id&#x60; with &#x60;DELETE /v1/auth/access-token/id/{id}&#x60; to revoke it.  Only reachable with a JWT. 

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.AuthApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.verbatim-ai.com");
        
        // Configure HTTP bearer authorization: JWT
        HttpBearerAuth JWT = (HttpBearerAuth) defaultClient.getAuthentication("JWT");
        JWT.setBearerToken("BEARER TOKEN");

        AuthApi apiInstance = new AuthApi(defaultClient);
        Integer pageSize = 25; // Integer | Number of items per page.
        Integer pageIndex = 0; // Integer | Zero-based page index.
        try {
            AccessTokenListResponse result = apiInstance.list3(pageSize, pageIndex);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AuthApi#list3");
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
| **pageSize** | **Integer**| Number of items per page. | [optional] [default to 25] |
| **pageIndex** | **Integer**| Zero-based page index. | [optional] [default to 0] |

### Return type

[**AccessTokenListResponse**](AccessTokenListResponse.md)

### Authorization

[JWT](../README.md#JWT)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **500** | Internal error. Check body to get more info |  -  |
| **403** | No JWT, or the call was made with an access token. |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **400** | &#x60;pageSize&#x60; below 1 or &#x60;pageIndex&#x60; below 0. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **413** | The request body exceeds the size accepted by the endpoint. |  -  |
| **200** | One page of access tokens. |  -  |


## revoke

> AckResponse revoke(token)

Revoke an access token by value

Permanently delete an access token, given its full value. Any request using this token fails immediately after revocation. An unknown value is acknowledged all the same. When you only have the listing, revoke by id instead. Only reachable with a JWT.

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.AuthApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.verbatim-ai.com");
        
        // Configure HTTP bearer authorization: JWT
        HttpBearerAuth JWT = (HttpBearerAuth) defaultClient.getAuthentication("JWT");
        JWT.setBearerToken("BEARER TOKEN");

        AuthApi apiInstance = new AuthApi(defaultClient);
        String token = "abcdf1234abcdf567"; // String | access token to revoke.
        try {
            AckResponse result = apiInstance.revoke(token);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AuthApi#revoke");
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
| **token** | **String**| access token to revoke. | |

### Return type

[**AckResponse**](AckResponse.md)

### Authorization

[JWT](../README.md#JWT)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **500** | Internal error. Check body to get more info |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **413** | The request body exceeds the size accepted by the endpoint. |  -  |
| **200** | Token revoked. |  -  |


## revokeById

> AckResponse revokeById(id)

Revoke an access token by id

Permanently delete one of the organization&#39;s access tokens, identified by the &#x60;id&#x60; the listing returns. Revocation is immediate: the next request carrying the token is refused.  An id that names no token of the caller&#39;s organization — unknown, already revoked, or another organization&#39;s — is a 404.  Only reachable with a JWT. 

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.AuthApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.verbatim-ai.com");
        
        // Configure HTTP bearer authorization: JWT
        HttpBearerAuth JWT = (HttpBearerAuth) defaultClient.getAuthentication("JWT");
        JWT.setBearerToken("BEARER TOKEN");

        AuthApi apiInstance = new AuthApi(defaultClient);
        UUID id = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | Id of the access token to revoke, as listed.
        try {
            AckResponse result = apiInstance.revokeById(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AuthApi#revokeById");
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
| **id** | **UUID**| Id of the access token to revoke, as listed. | |

### Return type

[**AckResponse**](AckResponse.md)

### Authorization

[JWT](../README.md#JWT)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **500** | Internal error. Check body to get more info |  -  |
| **403** | No JWT, or the call was made with an access token. |  -  |
| **404** | No access token with this id in the caller&#39;s organization. |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **413** | The request body exceeds the size accepted by the endpoint. |  -  |
| **200** | Token revoked. |  -  |


## scopes

> AccessTokenScopesResponse scopes()

List the available scopes

Every scope an access token can be created with — the values accepted in the &#x60;scope&#x60; of &#x60;POST /v1/auth/access-token/&#x60;. Use it to build a scope picker rather than hard-coding the list.  A scope entry is &#x60;DOMAIN:ACTION&#x60;, and every domain combines with every action:  - &#x60;domains&#x60; — each domain with the API path it covers, what it gives access to, and its   scope entries, ready to group in a UI; - &#x60;actions&#x60; — each action with the HTTP methods it opens (&#x60;read&#x60; is &#x60;GET&#x60;, so running a   RAG query, &#x60;GET /v1/post/q&#x60;, needs &#x60;post:read&#x60;); - &#x60;scopes&#x60; — the flat list of every valid entry.  The catalog is the same for every organization and every caller. 

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.AuthApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.verbatim-ai.com");
        
        // Configure HTTP bearer authorization: JWT
        HttpBearerAuth JWT = (HttpBearerAuth) defaultClient.getAuthentication("JWT");
        JWT.setBearerToken("BEARER TOKEN");

        AuthApi apiInstance = new AuthApi(defaultClient);
        try {
            AccessTokenScopesResponse result = apiInstance.scopes();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AuthApi#scopes");
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

[**AccessTokenScopesResponse**](AccessTokenScopesResponse.md)

### Authorization

[JWT](../README.md#JWT)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **500** | Internal error. Check body to get more info |  -  |
| **403** | No credential, or an access token whose scope lacks &#x60;auth:read&#x60;. |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **413** | The request body exceeds the size accepted by the endpoint. |  -  |
| **200** | The scope catalog. |  -  |


## whoami

> WhoAmI whoami()

Who am I

Return the identity of the caller as resolved from the Bearer token: organization, user id, email and display name.  Typical use cases:  - Bootstrap a UI session after sign-in. - Verify that a token is still valid and which user it belongs to. 

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.AuthApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.verbatim-ai.com");
        
        // Configure HTTP bearer authorization: JWT
        HttpBearerAuth JWT = (HttpBearerAuth) defaultClient.getAuthentication("JWT");
        JWT.setBearerToken("BEARER TOKEN");

        AuthApi apiInstance = new AuthApi(defaultClient);
        try {
            WhoAmI result = apiInstance.whoami();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AuthApi#whoami");
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

[**WhoAmI**](WhoAmI.md)

### Authorization

[JWT](../README.md#JWT)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **500** | Internal error. Check body to get more info |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **413** | The request body exceeds the size accepted by the endpoint. |  -  |
| **200** | Identity of the authenticated user. |  -  |

