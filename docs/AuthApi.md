# AuthApi

All URIs are relative to *https://api.verbatim-ai.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**create2**](AuthApi.md#create2) | **POST** /v1/auth/access-token | Create an access token |
| [**revoke**](AuthApi.md#revoke) | **DELETE** /v1/auth/access-token/{token} | Revoke an access token |
| [**whoami**](AuthApi.md#whoami) | **GET** /v1/auth/whoami | Who am I |



## create2

> AccessTokenCreateResponse create2(accessTokenCreateRequest)

Create an access token

Generate a new short-lived opaque access token for the caller&#39;s organization. The token can be used as the &#x60;X-Access-Token&#x60; header on &#x60;/v1/&#x60; API calls. Default TTL is 3600 seconds (1 hour).By default, token inherit privileges over all the domains. To limit access, defined a list of scope, where each must be compliant with the regex (config|auth|session|doc|chunk|corpus|post|usage|agent):(create|read|update|delete)

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
            AccessTokenCreateResponse result = apiInstance.create2(accessTokenCreateRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AuthApi#create2");
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
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | Access token created. |  -  |


## revoke

> AckResponse revoke(token)

Revoke an access token

Permanently delete an access token. Any in-flight request using this token will fail immediately after revocation.

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
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | Token revoked. |  -  |


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
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | Identity of the authenticated user. |  -  |

