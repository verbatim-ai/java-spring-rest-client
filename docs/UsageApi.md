# UsageApi

All URIs are relative to *https://api.verbatim-ai.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**usage**](UsageApi.md#usage) | **GET** /v1/usage/all | Organization usage |
| [**usageByCorpus**](UsageApi.md#usageByCorpus) | **GET** /v1/usage/corpus/{corpusId} | Corpus usage |
| [**usageByUser**](UsageApi.md#usageByUser) | **GET** /v1/usage/user/{userId} | User usage |



## usage

> Usage usage(timeframe)

Organization usage

Return the aggregated usage report for the caller&#39;s organization, as headline totals and as a per-bucket time series.  Each dimension is reported as: - **tokens** — &#x60;total&#x60; (lifetime, soft-deleted included) and &#x60;inPeriod&#x60; (over the reported range). At organization scope this sums &#x60;post.token&#x60; AND &#x60;document.token&#x60; (vectorization tokens are billed at organization level). - **corpora / sessions / posts / storage** — &#x60;total&#x60;, &#x60;created&#x60; and &#x60;removed&#x60; over the range. - **storage** values are bytes. - **series** — the same &#x60;created&#x60;/&#x60;removed&#x60; deltas and a &#x60;tokens&#x60; count, bucket by bucket.  &#x60;timeframe&#x60; selects the **bucket size**, and with it how far back the report reaches:  | &#x60;timeframe&#x60; | bucket    | buckets | history      | |-------------|-----------|---------|--------------| | &#x60;Day&#x60;       | one day   | 30      | ~1 month     | | &#x60;Week&#x60;      | ISO week  | 12      | ~3 months    | | &#x60;Month&#x60;     | one month | 12      | 1 year       | | &#x60;Year&#x60;      | one year  | 5       | 5 years      |  Buckets are aligned to **UTC calendar boundaries** — midnight, Monday, the 1st of the month, the 1st of January — not measured backwards from the current instant, so two calls minutes apart return the same boundaries and two reports line up on a chart.  The report covers **completed buckets only**: the bucket in progress (today, this week, this month, this year) is left out, so &#x60;to&#x60; is the instant that bucket starts at and is never in the future, while &#x60;timestamp&#x60; is the real server time the report was computed at and is later than &#x60;to&#x60;. Activity from the current bucket counts toward the lifetime &#x60;total&#x60;s, but reaches &#x60;created&#x60;, &#x60;removed&#x60;, &#x60;inPeriod&#x60; and &#x60;series&#x60; only once that bucket closes.  &#x60;series&#x60; is contiguous and gapless — a bucket in which nothing happened is present with zeros rather than omitted — and its entries sum exactly to the top-level &#x60;created&#x60;, &#x60;removed&#x60; and &#x60;inPeriod&#x60;. Every window is half-open: &#x60;from&#x60; inclusive, &#x60;to&#x60; exclusive. 

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.UsageApi;

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

        UsageApi apiInstance = new UsageApi(defaultClient);
        String timeframe = "Day"; // String | Bucket size to aggregate by, and with it how far back the report reaches. Defaults to `Day` (30 daily buckets).
        try {
            Usage result = apiInstance.usage(timeframe);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UsageApi#usage");
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
| **timeframe** | **String**| Bucket size to aggregate by, and with it how far back the report reaches. Defaults to &#x60;Day&#x60; (30 daily buckets). | [optional] [enum: Day, Week, Month, Year] |

### Return type

[**Usage**](Usage.md)

### Authorization

[JWT](../README.md#JWT), [AccessToken](../README.md#AccessToken)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **500** | Internal error. Check body to get more info |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | Organization usage report. The example&#39;s &#x60;series&#x60; is trimmed to three buckets for readability; a real &#x60;Day&#x60; report carries 30. |  -  |


## usageByCorpus

> Usage usageByCorpus(corpusId, timeframe)

Corpus usage

Return the aggregated usage report for a single corpus, as headline totals and as a per-bucket time series.  Differences with the organization-scope report: - **tokens** sums &#x60;post.token&#x60; only — vectorization tokens (&#x60;document.token&#x60;) are reported only at organization scope, because they are billed against the org. - **corpora** is &#x60;null&#x60; — cardinality is always 1 at corpus scope. It is absent from the &#x60;series&#x60; entries too.  Sessions, posts and storage are restricted to the requested corpus.  &#x60;timeframe&#x60; selects the **bucket size**, and with it how far back the report reaches:  | &#x60;timeframe&#x60; | bucket    | buckets | history      | |-------------|-----------|---------|--------------| | &#x60;Day&#x60;       | one day   | 30      | ~1 month     | | &#x60;Week&#x60;      | ISO week  | 12      | ~3 months    | | &#x60;Month&#x60;     | one month | 12      | 1 year       | | &#x60;Year&#x60;      | one year  | 5       | 5 years      |  Buckets are aligned to **UTC calendar boundaries** — midnight, Monday, the 1st of the month, the 1st of January — not measured backwards from the current instant, so two calls minutes apart return the same boundaries and two reports line up on a chart.  The report covers **completed buckets only**: the bucket in progress (today, this week, this month, this year) is left out, so &#x60;to&#x60; is the instant that bucket starts at and is never in the future, while &#x60;timestamp&#x60; is the real server time the report was computed at and is later than &#x60;to&#x60;. Activity from the current bucket counts toward the lifetime &#x60;total&#x60;s, but reaches &#x60;created&#x60;, &#x60;removed&#x60;, &#x60;inPeriod&#x60; and &#x60;series&#x60; only once that bucket closes.  &#x60;series&#x60; is contiguous and gapless — a bucket in which nothing happened is present with zeros rather than omitted — and its entries sum exactly to the top-level &#x60;created&#x60;, &#x60;removed&#x60; and &#x60;inPeriod&#x60;. Every window is half-open: &#x60;from&#x60; inclusive, &#x60;to&#x60; exclusive. 

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.UsageApi;

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

        UsageApi apiInstance = new UsageApi(defaultClient);
        UUID corpusId = UUID.fromString("550e8400-e29b-41d4-a716-446655440001"); // UUID | ID of the corpus to compute usage for.
        String timeframe = "Day"; // String | Bucket size to aggregate by, and with it how far back the report reaches. Defaults to `Day` (30 daily buckets).
        try {
            Usage result = apiInstance.usageByCorpus(corpusId, timeframe);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UsageApi#usageByCorpus");
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
| **corpusId** | **UUID**| ID of the corpus to compute usage for. | |
| **timeframe** | **String**| Bucket size to aggregate by, and with it how far back the report reaches. Defaults to &#x60;Day&#x60; (30 daily buckets). | [optional] [enum: Day, Week, Month, Year] |

### Return type

[**Usage**](Usage.md)

### Authorization

[JWT](../README.md#JWT), [AccessToken](../README.md#AccessToken)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **500** | Internal error. Check body to get more info |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | Corpus usage report. The example&#39;s &#x60;series&#x60; is trimmed to two buckets for readability; a real &#x60;Week&#x60; report carries 12. |  -  |


## usageByUser

> Usage usageByUser(userId, timeframe)

User usage

Return the aggregated usage report for a single user within the caller&#39;s organization, as headline totals and as a per-bucket time series.  Scope: - **tokens** sums &#x60;post.token&#x60; of sessions where &#x60;session.user_id &#x3D; userId&#x60; AND &#x60;document.token&#x60; of documents where &#x60;document.user_id &#x3D; userId&#x60;, both restricted to corpora of the caller&#39;s organization. - **sessions** counts distinct sessions owned by &#x60;userId&#x60; in the organization. - **posts** counts posts in those sessions. - **storage** sums &#x60;document.size&#x60; of documents uploaded by &#x60;userId&#x60; in the organization. - **corpora** is &#x60;null&#x60; — cardinality is not meaningful at user scope. It is absent from the &#x60;series&#x60; entries too.  Soft-deleted rows count toward lifetime totals; the &#x60;removed&#x60; deltas detect cleanup.  &#x60;timeframe&#x60; selects the **bucket size**, and with it how far back the report reaches:  | &#x60;timeframe&#x60; | bucket    | buckets | history      | |-------------|-----------|---------|--------------| | &#x60;Day&#x60;       | one day   | 30      | ~1 month     | | &#x60;Week&#x60;      | ISO week  | 12      | ~3 months    | | &#x60;Month&#x60;     | one month | 12      | 1 year       | | &#x60;Year&#x60;      | one year  | 5       | 5 years      |  Buckets are aligned to **UTC calendar boundaries** — midnight, Monday, the 1st of the month, the 1st of January — not measured backwards from the current instant, so two calls minutes apart return the same boundaries and two reports line up on a chart.  The report covers **completed buckets only**: the bucket in progress (today, this week, this month, this year) is left out, so &#x60;to&#x60; is the instant that bucket starts at and is never in the future, while &#x60;timestamp&#x60; is the real server time the report was computed at and is later than &#x60;to&#x60;. Activity from the current bucket counts toward the lifetime &#x60;total&#x60;s, but reaches &#x60;created&#x60;, &#x60;removed&#x60;, &#x60;inPeriod&#x60; and &#x60;series&#x60; only once that bucket closes.  &#x60;series&#x60; is contiguous and gapless — a bucket in which nothing happened is present with zeros rather than omitted — and its entries sum exactly to the top-level &#x60;created&#x60;, &#x60;removed&#x60; and &#x60;inPeriod&#x60;. Every window is half-open: &#x60;from&#x60; inclusive, &#x60;to&#x60; exclusive. 

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.UsageApi;

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

        UsageApi apiInstance = new UsageApi(defaultClient);
        String userId = "user-42"; // String | ID of the user to compute usage for. Free-form string (max 256 chars), matched against `session.user_id` and `document.user_id`.
        String timeframe = "Day"; // String | Bucket size to aggregate by, and with it how far back the report reaches. Defaults to `Day` (30 daily buckets).
        try {
            Usage result = apiInstance.usageByUser(userId, timeframe);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UsageApi#usageByUser");
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
| **userId** | **String**| ID of the user to compute usage for. Free-form string (max 256 chars), matched against &#x60;session.user_id&#x60; and &#x60;document.user_id&#x60;. | |
| **timeframe** | **String**| Bucket size to aggregate by, and with it how far back the report reaches. Defaults to &#x60;Day&#x60; (30 daily buckets). | [optional] [enum: Day, Week, Month, Year] |

### Return type

[**Usage**](Usage.md)

### Authorization

[JWT](../README.md#JWT), [AccessToken](../README.md#AccessToken)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **500** | Internal error. Check body to get more info |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | User usage report. The example&#39;s &#x60;series&#x60; is trimmed to two buckets for readability; a real &#x60;Month&#x60; report carries 12. |  -  |

