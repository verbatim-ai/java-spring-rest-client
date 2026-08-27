# KeyApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**activate**](KeyApi.md#activate) | **PUT** /_/v1/key/{keyId}/activate | Activate a key |
| [**create4**](KeyApi.md#create4) | **POST** /_/v1/key/ | Register a new key slot |
| [**deactivate**](KeyApi.md#deactivate) | **PUT** /_/v1/key/{keyId}/deactivate | Deactivate a key |
| [**delete1**](KeyApi.md#delete1) | **DELETE** /_/v1/key/{keyId} | Delete a key |
| [**get1**](KeyApi.md#get1) | **GET** /_/v1/key/{keyId} | Get a key |
| [**list3**](KeyApi.md#list3) | **GET** /_/v1/key/ | List keys |
| [**publish**](KeyApi.md#publish) | **POST** /_/v1/key/{keyId}/publish | Publish PEM content for a key |
| [**update1**](KeyApi.md#update1) | **PUT** /_/v1/key/{keyId} | Update a key |



## activate

> Key activate(keyId)

Activate a key

Flip an &#x60;INACTIVE&#x60; key back to &#x60;ACTIVE&#x60;. Only keys that have been published (content set) will actually verify JWTs.

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.KeyApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP bearer authorization: JWT
        HttpBearerAuth JWT = (HttpBearerAuth) defaultClient.getAuthentication("JWT");
        JWT.setBearerToken("BEARER TOKEN");

        // Configure API key authorization: AccessToken
        ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
        AccessToken.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //AccessToken.setApiKeyPrefix("Token");

        KeyApi apiInstance = new KeyApi(defaultClient);
        UUID keyId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the key to activate.
        try {
            Key result = apiInstance.activate(keyId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling KeyApi#activate");
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
| **keyId** | **UUID**| ID of the key to activate. | |

### Return type

[**Key**](Key.md)

### Authorization

[JWT](../README.md#JWT), [AccessToken](../README.md#AccessToken)

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
| **200** | Key activated. |  -  |


## create4

> KeyCreateResponse create4(keyCreateRequest)

Register a new key slot

Create an empty key entry with a name and an optional description. The key starts in &#x60;INACTIVE&#x60; state with no content — call &#x60;POST /_/v1/key/{id}/publish&#x60; to upload the PEM and activate it.

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.KeyApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP bearer authorization: JWT
        HttpBearerAuth JWT = (HttpBearerAuth) defaultClient.getAuthentication("JWT");
        JWT.setBearerToken("BEARER TOKEN");

        // Configure API key authorization: AccessToken
        ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
        AccessToken.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //AccessToken.setApiKeyPrefix("Token");

        KeyApi apiInstance = new KeyApi(defaultClient);
        KeyCreateRequest keyCreateRequest = new KeyCreateRequest(); // KeyCreateRequest | 
        try {
            KeyCreateResponse result = apiInstance.create4(keyCreateRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling KeyApi#create4");
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
| **keyCreateRequest** | [**KeyCreateRequest**](KeyCreateRequest.md)|  | |

### Return type

[**KeyCreateResponse**](KeyCreateResponse.md)

### Authorization

[JWT](../README.md#JWT), [AccessToken](../README.md#AccessToken)

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
| **200** | Key created. |  -  |


## deactivate

> Key deactivate(keyId)

Deactivate a key

Flip an &#x60;ACTIVE&#x60; key to &#x60;INACTIVE&#x60;. Tokens signed with this key will no longer be accepted until it is reactivated.

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.KeyApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP bearer authorization: JWT
        HttpBearerAuth JWT = (HttpBearerAuth) defaultClient.getAuthentication("JWT");
        JWT.setBearerToken("BEARER TOKEN");

        // Configure API key authorization: AccessToken
        ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
        AccessToken.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //AccessToken.setApiKeyPrefix("Token");

        KeyApi apiInstance = new KeyApi(defaultClient);
        UUID keyId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the key to deactivate.
        try {
            Key result = apiInstance.deactivate(keyId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling KeyApi#deactivate");
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
| **keyId** | **UUID**| ID of the key to deactivate. | |

### Return type

[**Key**](Key.md)

### Authorization

[JWT](../README.md#JWT), [AccessToken](../README.md#AccessToken)

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
| **200** | Key deactivated. |  -  |


## delete1

> AckResponse delete1(keyId)

Delete a key

Soft-delete a key. JWT tokens signed with the deleted key will no longer be accepted.

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.KeyApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP bearer authorization: JWT
        HttpBearerAuth JWT = (HttpBearerAuth) defaultClient.getAuthentication("JWT");
        JWT.setBearerToken("BEARER TOKEN");

        // Configure API key authorization: AccessToken
        ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
        AccessToken.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //AccessToken.setApiKeyPrefix("Token");

        KeyApi apiInstance = new KeyApi(defaultClient);
        UUID keyId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the key to delete.
        try {
            AckResponse result = apiInstance.delete1(keyId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling KeyApi#delete1");
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
| **keyId** | **UUID**| ID of the key to delete. | |

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
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **200** | Key deleted. |  -  |


## get1

> KeyItemResponse get1(keyId)

Get a key

Fetch a single key by its identifier. The raw RSA content is never returned.

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.KeyApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP bearer authorization: JWT
        HttpBearerAuth JWT = (HttpBearerAuth) defaultClient.getAuthentication("JWT");
        JWT.setBearerToken("BEARER TOKEN");

        // Configure API key authorization: AccessToken
        ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
        AccessToken.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //AccessToken.setApiKeyPrefix("Token");

        KeyApi apiInstance = new KeyApi(defaultClient);
        UUID keyId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the key.
        try {
            KeyItemResponse result = apiInstance.get1(keyId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling KeyApi#get1");
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
| **keyId** | **UUID**| ID of the key. | |

### Return type

[**KeyItemResponse**](KeyItemResponse.md)

### Authorization

[JWT](../README.md#JWT), [AccessToken](../README.md#AccessToken)

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
| **200** | Key found. |  -  |


## list3

> KeyListResponse list3(pageSize, pageIndex)

List keys

Paginate keys belonging to the caller&#39;s organization. The raw RSA content is never returned.

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.KeyApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP bearer authorization: JWT
        HttpBearerAuth JWT = (HttpBearerAuth) defaultClient.getAuthentication("JWT");
        JWT.setBearerToken("BEARER TOKEN");

        // Configure API key authorization: AccessToken
        ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
        AccessToken.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //AccessToken.setApiKeyPrefix("Token");

        KeyApi apiInstance = new KeyApi(defaultClient);
        Integer pageSize = 25; // Integer | Number of items per page.
        Integer pageIndex = 0; // Integer | Zero-based page index.
        try {
            KeyListResponse result = apiInstance.list3(pageSize, pageIndex);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling KeyApi#list3");
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

[**KeyListResponse**](KeyListResponse.md)

### Authorization

[JWT](../README.md#JWT), [AccessToken](../README.md#AccessToken)

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
| **200** | Page of keys. |  -  |


## publish

> Key publish(keyId, body)

Publish PEM content for a key

Upload the PEM-encoded RSA 2048-bit public key for a previously created slot. The content is validated and stored, and the key transitions to &#x60;ACTIVE&#x60;. Content is write-once — to rotate, create a new key and delete the old one.

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.KeyApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP bearer authorization: JWT
        HttpBearerAuth JWT = (HttpBearerAuth) defaultClient.getAuthentication("JWT");
        JWT.setBearerToken("BEARER TOKEN");

        // Configure API key authorization: AccessToken
        ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
        AccessToken.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //AccessToken.setApiKeyPrefix("Token");

        KeyApi apiInstance = new KeyApi(defaultClient);
        UUID keyId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the key to publish.
        String body = ----BEGIN PUBLIC KEY-----\nMIIBIjANBgkqhkiG9w0BAQEFA...\n-----END PUBLIC KEY-----
; // String | 
        try {
            Key result = apiInstance.publish(keyId, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling KeyApi#publish");
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
| **keyId** | **UUID**| ID of the key to publish. | |
| **body** | **String**|  | |

### Return type

[**Key**](Key.md)

### Authorization

[JWT](../README.md#JWT), [AccessToken](../README.md#AccessToken)

### HTTP request headers

- **Content-Type**: text/plain
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
| **200** | Key published and activated. |  -  |


## update1

> KeyUpdateResponse update1(keyId, keyUpdateRequest)

Update a key

Patch the name and/or description of an existing key. Raw RSA content, format, and state are not editable through this endpoint.

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.KeyApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP bearer authorization: JWT
        HttpBearerAuth JWT = (HttpBearerAuth) defaultClient.getAuthentication("JWT");
        JWT.setBearerToken("BEARER TOKEN");

        // Configure API key authorization: AccessToken
        ApiKeyAuth AccessToken = (ApiKeyAuth) defaultClient.getAuthentication("AccessToken");
        AccessToken.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //AccessToken.setApiKeyPrefix("Token");

        KeyApi apiInstance = new KeyApi(defaultClient);
        UUID keyId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the key to update.
        KeyUpdateRequest keyUpdateRequest = new KeyUpdateRequest(); // KeyUpdateRequest | 
        try {
            KeyUpdateResponse result = apiInstance.update1(keyId, keyUpdateRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling KeyApi#update1");
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
| **keyId** | **UUID**| ID of the key to update. | |
| **keyUpdateRequest** | [**KeyUpdateRequest**](KeyUpdateRequest.md)|  | |

### Return type

[**KeyUpdateResponse**](KeyUpdateResponse.md)

### Authorization

[JWT](../README.md#JWT), [AccessToken](../README.md#AccessToken)

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
| **200** | Key updated. |  -  |

