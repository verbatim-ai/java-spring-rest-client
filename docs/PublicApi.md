# PublicApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**assertEmail**](PublicApi.md#assertEmail) | **GET** /pub/v1/user/assert/email/{email} | Assert an email free from registration |
| [**check**](PublicApi.md#check) | **GET** /pub/check | Deep health check |
| [**checkVerificationCode**](PublicApi.md#checkVerificationCode) | **GET** /pub/v1/user/assert/code/{email}/{code} | Assert email verification code |
| [**ping**](PublicApi.md#ping) | **GET** /pub/ping | Basic ping |



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
import com.verbatim.client.springrest.api.PublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        PublicApi apiInstance = new PublicApi(defaultClient);
        String email = "email_example"; // String | Email to assert
        String turnstileToken = "gfhFs45fdg6-6575fdgg..."; // String | turnstileToken owned by web client. Token delivered throw CloudFare Turnstile service
        String languageCode = "en"; // String | Email verification code language code 
        try {
            AckResponse result = apiInstance.assertEmail(email, turnstileToken, languageCode);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PublicApi#assertEmail");
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


## check

> CheckResponse check()

Deep health check

Probe every subsystem the platform depends on and report each outcome:  - **S3** — read an object back from the archive storage - **DB** — run a query on a pooled connection - **LLM** — send a prompt to the inference endpoint and require an answer  Every probe runs on every call, so one failure never hides another. The response is &#x60;200&#x60; when all of them pass and &#x60;500&#x60; as soon as one fails, which is the signal a monitoring tool alerts on; the body names the failing subsystem and carries its reason.

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.PublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        PublicApi apiInstance = new PublicApi(defaultClient);
        try {
            CheckResponse result = apiInstance.check();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PublicApi#check");
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

[**CheckResponse**](CheckResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **500** | At least one subsystem failed its probe. |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **200** | Every subsystem answered. |  -  |


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
import com.verbatim.client.springrest.api.PublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        PublicApi apiInstance = new PublicApi(defaultClient);
        String email = "email_example"; // String | Email to assert
        String code = "code_example"; // String | Email verification code
        String turnstileToken = "gfhFs45fdg6-6575fdgg"; // String | turnstileToken owned by web client. Token delivered throw CloudFare Turnstile service
        try {
            AckResponse result = apiInstance.checkVerificationCode(email, code, turnstileToken);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PublicApi#checkVerificationCode");
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


## ping

> ping()

Basic ping

Simple open API to ping platform. Easy to use for an healthy check

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.PublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        PublicApi apiInstance = new PublicApi(defaultClient);
        try {
            apiInstance.ping();
        } catch (ApiException e) {
            System.err.println("Exception when calling PublicApi#ping");
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

null (empty response body)

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
| **200** | Pong. |  -  |

