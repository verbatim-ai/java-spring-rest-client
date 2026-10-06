# ConfigurationApi

All URIs are relative to *https://api.verbatim-ai.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**list7**](ConfigurationApi.md#list7) | **GET** /v1/config/model | List supported LLM models |



## list7

> ModelListResponse list7()

List supported LLM models

Return the LLM models the platform is configured to serve, each with the &#x60;id&#x60; to send and the display name, description and icon URL to present it with.  The list is the same for every caller and is not paginated: &#x60;models&#x60; holds the whole catalog, in the order it is meant to be offered, and &#x60;total&#x60; is how many that is. Preselect the first entry.  &#x60;items&#x60; repeats the same ids without the display fields, for clients written against the first version of this endpoint. It is deprecated — read &#x60;models[].id&#x60;. 

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.ConfigurationApi;

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

        ConfigurationApi apiInstance = new ConfigurationApi(defaultClient);
        try {
            ModelListResponse result = apiInstance.list7();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ConfigurationApi#list7");
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

[**ModelListResponse**](ModelListResponse.md)

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
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **413** | The request body exceeds the size accepted by the endpoint. |  -  |
| **200** | Supported models. |  -  |

