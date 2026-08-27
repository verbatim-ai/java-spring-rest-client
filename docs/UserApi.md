# UserApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**assertEmail**](UserApi.md#assertEmail) | **GET** /pub/v1/user/assert/email/{email} | Assert an email free from registration |
| [**checkVerificationCode**](UserApi.md#checkVerificationCode) | **GET** /pub/v1/user/assert/code/{email}/{code} | Assert email verification code |
| [**onboard**](UserApi.md#onboard) | **PUT** /_/v1/user/onboard | Onboard the authenticated user |



## assertEmail

> AckResponse assertEmail(email, turnstileToken, languageCode)

Assert an email free from registration

Check if the email is unknown and can be go throw signin process

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.UserApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        UserApi apiInstance = new UserApi(defaultClient);
        String email = "email_example"; // String | Email to assert
        String turnstileToken = "gfhFs45fdg6-6575fdgg..."; // String | turnstileToken owned by web client. Token delivered throw CloudFare Turnstile service
        String languageCode = "en"; // String | Email verification code language code 
        try {
            AckResponse result = apiInstance.assertEmail(email, turnstileToken, languageCode);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserApi#assertEmail");
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
| **email** | **String**| Email to assert | |
| **turnstileToken** | **String**| turnstileToken owned by web client. Token delivered throw CloudFare Turnstile service | |
| **languageCode** | **String**| Email verification code language code  | [optional] [default to en] |

### Return type

[**AckResponse**](AckResponse.md)

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
| **200** | Email is free from registration. Email with a verification code is fired. User can go throw signin process |  -  |


## checkVerificationCode

> AckResponse checkVerificationCode(email, code, turnstileToken)

Assert email verification code

Assert the code sent to the email

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.UserApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        UserApi apiInstance = new UserApi(defaultClient);
        String email = "email_example"; // String | Email to assert
        String code = "code_example"; // String | Email verification code
        String turnstileToken = "gfhFs45fdg6-6575fdgg"; // String | turnstileToken owned by web client. Token delivered throw CloudFare Turnstile service
        try {
            AckResponse result = apiInstance.checkVerificationCode(email, code, turnstileToken);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserApi#checkVerificationCode");
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
| **email** | **String**| Email to assert | |
| **code** | **String**| Email verification code | |
| **turnstileToken** | **String**| turnstileToken owned by web client. Token delivered throw CloudFare Turnstile service | |

### Return type

[**AckResponse**](AckResponse.md)

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
| **200** | Code is valid |  -  |


## onboard

> UserOnboardResponse onboard()

Onboard the authenticated user

Bootstrap the caller into a Verbatim organization. Must be called with a Firebase JWT that does **not** yet carry an &#x60;oid&#x60; claim tokens already bound to an organization are rejected at the security layer (403). On success the user is provisioned, an organization is created (or joined), and the caller should refresh their Firebase token to pick up the new &#x60;oid&#x60; claim before calling any &#x60;/v1/_*&#x60; endpoint. 

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.UserApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP bearer authorization: JWT
        HttpBearerAuth JWT = (HttpBearerAuth) defaultClient.getAuthentication("JWT");
        JWT.setBearerToken("BEARER TOKEN");

        UserApi apiInstance = new UserApi(defaultClient);
        try {
            UserOnboardResponse result = apiInstance.onboard();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserApi#onboard");
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

[**UserOnboardResponse**](UserOnboardResponse.md)

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
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **200** | User onboarded; organization and identity returned. |  -  |

