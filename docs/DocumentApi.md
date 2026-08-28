# DocumentApi

All URIs are relative to *https://api.verbatim-ai.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**commitUpload**](DocumentApi.md#commitUpload) | **POST** /v1/doc/{id}/commit | Commit a previously initialized upload |
| [**delete1**](DocumentApi.md#delete1) | **DELETE** /v1/doc/{id} | Delete a document |
| [**downloadUrl1**](DocumentApi.md#downloadUrl1) | **GET** /v1/doc/{id}/download-url | Get a presigned download URL |
| [**get1**](DocumentApi.md#get1) | **GET** /v1/doc/{id} | Get a document |
| [**initUpload**](DocumentApi.md#initUpload) | **POST** /v1/doc/init | Initialize a direct-to-storage upload |
| [**list4**](DocumentApi.md#list4) | **GET** /v1/doc/ | List documents |
| [**listSupportedDocuments**](DocumentApi.md#listSupportedDocuments) | **GET** /v1/doc/accept | List accepted content types |
| [**previewUrls1**](DocumentApi.md#previewUrls1) | **GET** /v1/doc/{id}/preview-urls | Get presigned preview URLs |
| [**reinitUpload**](DocumentApi.md#reinitUpload) | **PUT** /v1/doc/{id}/init | Re-initialize a document for a new upload |
| [**search1**](DocumentApi.md#search1) | **GET** /v1/doc/q | Search documents |
| [**status**](DocumentApi.md#status) | **GET** /v1/doc/{id}/status | Get a document&#39;s status |
| [**summary**](DocumentApi.md#summary) | **GET** /v1/doc/{id}/summary | Get a document summary |
| [**update1**](DocumentApi.md#update1) | **PATCH** /v1/doc/{id} | Update a document |



## commitUpload

> Document commitUpload(id)

Commit a previously initialized upload

Step 2 of the upload flow. Confirms that the file has been PUT to the presigned URL returned by &#x60;POST /v1/doc/init&#x60; and **asynchronously** triggers ingestion (markdown conversion, summarization, chunking, embedding).  Before queuing, the server validates the uploaded object: it must exist, declare a supported content type, fit under the per-document size limit, and not already be present in the same corpus (duplicate detection by content hash).  The response is returned as soon as the document is moved to &#x60;PROCESSING&#x60;. Poll &#x60;GET /v1/doc/{id}/status&#x60; to observe the final &#x60;READY&#x60; or &#x60;FAILED&#x60; status.  Idempotent: committing a document already in &#x60;READY&#x60; status returns the current state unchanged. 

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.DocumentApi;

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

        DocumentApi apiInstance = new DocumentApi(defaultClient);
        UUID id = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the document returned by `POST /v1/doc/init`.
        try {
            Document result = apiInstance.commitUpload(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DocumentApi#commitUpload");
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
| **id** | **UUID**| ID of the document returned by &#x60;POST /v1/doc/init&#x60;. | |

### Return type

[**Document**](Document.md)

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
| **202** | Ingestion queued. Document moved to PROCESSING. |  -  |


## delete1

> AckResponse delete1(id)

Delete a document

Permanently remove a document from its corpus. **Cascades** to all embeddings and attachments referencing this document. This operation cannot be undone.

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.DocumentApi;

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

        DocumentApi apiInstance = new DocumentApi(defaultClient);
        UUID id = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the document to delete.
        try {
            AckResponse result = apiInstance.delete1(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DocumentApi#delete1");
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
| **id** | **UUID**| ID of the document to delete. | |

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
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **500** | Internal error. Check body to get more info |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | Document and dependencies deleted. |  -  |


## downloadUrl1

> DocumentDownloadUrl downloadUrl1(id)

Get a presigned download URL

Return a time-limited presigned URL the client can use to GET the document content directly from the storage backend (S3) — no content flows through this server.  The URL is bound to the document&#39;s content type; clients SHOULD use the returned &#x60;filename&#x60; for the local save name. 

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.DocumentApi;

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

        DocumentApi apiInstance = new DocumentApi(defaultClient);
        UUID id = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the document.
        try {
            DocumentDownloadUrl result = apiInstance.downloadUrl1(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DocumentApi#downloadUrl1");
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
| **id** | **UUID**| ID of the document. | |

### Return type

[**DocumentDownloadUrl**](DocumentDownloadUrl.md)

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
| **200** | Presigned URL issued. |  -  |


## get1

> Document get1(id)

Get a document

Return the metadata of a document by its ID, including provider, language and arbitrary metadata.

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.DocumentApi;

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

        DocumentApi apiInstance = new DocumentApi(defaultClient);
        UUID id = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the document.
        try {
            Document result = apiInstance.get1(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DocumentApi#get1");
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
| **id** | **UUID**| ID of the document. | |

### Return type

[**Document**](Document.md)

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
| **200** | Document found. |  -  |


## initUpload

> DocumentInit initUpload(documentInitRequest)

Initialize a direct-to-storage upload

Step 1 of the upload flow. Validates inputs, creates a document in &#x60;AWAITING_UPLOAD&#x60; status, and returns a single-use presigned PUT URL the client must use to push the file bytes directly to S3 — no content flows through this server.  The returned &#x60;uploadUrl&#x60; is bound to the requested &#x60;contentType&#x60;: the client MUST send a matching &#x60;Content-Type&#x60; header in the PUT request, or S3 will reject it.  After the PUT succeeds, call &#x60;POST /v1/doc/{id}/commit&#x60; to trigger ingestion.  Accepted content types are listed by &#x60;GET /v1/doc/accept&#x60;.  Two optional fields shape what happens later: &#x60;tags&#x60; classifies the document so &#x60;GET /v1/doc/?tags&#x3D;…&#x60; can find it, and &#x60;chunk&#x60; overrides how ingestion splits it into embeddable pieces. &#x60;chunk&#x60; accepts the Unstructured chunking options (&#x60;strategy&#x60;, &#x60;max_characters&#x60;, &#x60;overlap&#x60;, …) — see the request schema for the full key reference, and the *Chunking* examples below for the three shapes that cover most documents. Omit &#x60;chunk&#x60; and the platform default applies (&#x60;by_title&#x60;, &#x60;max_characters: 10000&#x60;, &#x60;combine_text_under_n_chars: 1000&#x60;). 

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.DocumentApi;

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

        DocumentApi apiInstance = new DocumentApi(defaultClient);
        DocumentInitRequest documentInitRequest = new DocumentInitRequest(); // DocumentInitRequest | 
        try {
            DocumentInit result = apiInstance.initUpload(documentInitRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DocumentApi#initUpload");
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
| **documentInitRequest** | [**DocumentInitRequest**](DocumentInitRequest.md)|  | |

### Return type

[**DocumentInit**](DocumentInit.md)

### Authorization

[JWT](../README.md#JWT), [AccessToken](../README.md#AccessToken)

### HTTP request headers

- **Content-Type**: application/json
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
| **200** | Document created in AWAITING_UPLOAD status. PUT the file to &#x60;uploadUrl&#x60;. |  -  |


## list4

> DocumentListResponse list4(corpusId, status, tags, pageSize, pageIndex)

List documents

Paginate documents stored in a corpus. Pass the optional &#x60;status&#x60; filter to narrow down by lifecycle state — e.g. &#x60;status&#x3D;PENDING&#x60; returns the ingestion backlog, &#x60;status&#x3D;FAILED&#x60; returns documents that need attention.  Pass &#x60;tags&#x60; to keep only documents carrying **at least one** of the given tags (repeat the parameter for several: &#x60;tags&#x3D;legal&amp;tags&#x3D;2026&#x60;). Combining &#x60;status&#x60; and &#x60;tags&#x60; narrows on both. 

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.DocumentApi;

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

        DocumentApi apiInstance = new DocumentApi(defaultClient);
        UUID corpusId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the corpus.
        String status = "AWAITING_UPLOAD"; // String | Optional lifecycle filter. When omitted, documents of all statuses are returned.
        List<String> tags = Arrays.asList(); // List<String> | Optional tag filter. Returns documents carrying at least one of the given tags. Repeat for multiple values: `tags=legal&tags=2026`. When omitted, tags are ignored.
        Integer pageSize = 25; // Integer | Number of items per page, 1-100.
        Integer pageIndex = 0; // Integer | Zero-based page index.
        try {
            DocumentListResponse result = apiInstance.list4(corpusId, status, tags, pageSize, pageIndex);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DocumentApi#list4");
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
| **corpusId** | **UUID**| ID of the corpus. | |
| **status** | **String**| Optional lifecycle filter. When omitted, documents of all statuses are returned. | [optional] [enum: AWAITING_UPLOAD, PENDING, PROCESSING, READY, FAILED] |
| **tags** | [**List&lt;String&gt;**](String.md)| Optional tag filter. Returns documents carrying at least one of the given tags. Repeat for multiple values: &#x60;tags&#x3D;legal&amp;tags&#x3D;2026&#x60;. When omitted, tags are ignored. | [optional] |
| **pageSize** | **Integer**| Number of items per page, 1-100. | [optional] [default to 25] |
| **pageIndex** | **Integer**| Zero-based page index. | [optional] [default to 0] |

### Return type

[**DocumentListResponse**](DocumentListResponse.md)

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
| **200** | Page of documents. |  -  |


## listSupportedDocuments

> String listSupportedDocuments()

List accepted content types

Return the MIME types accepted by &#x60;POST /v1/doc/init&#x60;. Use this to validate files client-side before initializing an upload.

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.DocumentApi;

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

        DocumentApi apiInstance = new DocumentApi(defaultClient);
        try {
            String result = apiInstance.listSupportedDocuments();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DocumentApi#listSupportedDocuments");
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

**String**

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
| **200** | List of accepted MIME types. |  -  |


## previewUrls1

> DocumentPreviewUrls previewUrls1(id, pages)

Get presigned preview URLs

Return time-limited presigned URLs for the rendered preview images of the document.  &#x60;pages&#x60; is **required** and selects the zero-based page indices to issue URLs for: at least one, at most 10 per request — &#x60;400&#x60; otherwise. Repeat the parameter for several values (&#x60;pages&#x3D;0&amp;pages&#x3D;2&#x60;) or send them comma-separated (&#x60;pages&#x3D;0,2&#x60;). Duplicates are preserved as supplied and count towards the limit. Paginate over a long document with several calls rather than asking for every page at once.  Every index must address a page of *that* document: negatives are rejected, and so is anything at or past its page count once that count is known (&#x60;nbPages&#x60; from &#x60;GET /v1/doc/{id}&#x60;, &#x60;0&#x60; while the rendering pipeline has not reported it).  One entry is issued per (page, size) over {SMALL, MEDIUM}, so a call returns &#x60;2 × pages&#x60; entries — at most 20.  The URLs point at preview images produced asynchronously by the rendering pipeline. No existence check is performed — individual URLs MAY return 404 when fetched if the corresponding (page, size) hasn&#39;t been generated yet; clients SHOULD fall back per-tile. 

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.DocumentApi;

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

        DocumentApi apiInstance = new DocumentApi(defaultClient);
        UUID id = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the document.
        List<Integer> pages = Arrays.asList(); // List<Integer> | One-based page indices to issue preview URLs for. Required: 1 to 10 values per request, each within the document's page range. Repeat for multiple values: `pages=1&pages=2`.
        try {
            DocumentPreviewUrls result = apiInstance.previewUrls1(id, pages);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DocumentApi#previewUrls1");
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
| **id** | **UUID**| ID of the document. | |
| **pages** | [**List&lt;Integer&gt;**](Integer.md)| One-based page indices to issue preview URLs for. Required: 1 to 10 values per request, each within the document&#39;s page range. Repeat for multiple values: &#x60;pages&#x3D;1&amp;pages&#x3D;2&#x60;. | |

### Return type

[**DocumentPreviewUrls**](DocumentPreviewUrls.md)

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
| **400** | &#x60;pages&#x60; is missing, empty, carries more than 10 indices, or names a page outside the document. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | Presigned preview URLs issued. |  -  |


## reinitUpload

> DocumentInit reinitUpload(id)

Re-initialize a document for a new upload

Replace the **content** of an existing document while keeping its identity: same &#x60;id&#x60;, same &#x60;filename&#x60;, &#x60;userId&#x60;, &#x60;provider&#x60;, &#x60;lang&#x60;, &#x60;metadata&#x60;, &#x60;tags&#x60;, &#x60;chunk&#x60; and source dates. Use &#x60;PATCH /v1/doc/{id}&#x60; to change those attributes — this endpoint only touches the file behind them.  The document must be in &#x60;READY&#x60; or &#x60;FAILED&#x60; status; any other status is rejected with &#x60;409&#x60;, since there is either nothing ingested yet or an ingestion in flight.  Everything derived from the previous content is dropped: its embeddings, its summary, and the counters filled in by ingestion (&#x60;size&#x60;, &#x60;tokens&#x60;, &#x60;nbWords&#x60;). The document moves back to &#x60;AWAITING_UPLOAD&#x60; and the response carries a fresh presigned PUT URL — the same payload as &#x60;POST /v1/doc/init&#x60;. From there the flow is unchanged: PUT the new bytes, then call &#x60;POST /v1/doc/{id}/commit&#x60;.  Two things to be aware of:  - Posts that cited this document **lose their attachments to it**, because the   citations point at the embeddings being deleted. Answers already returned to   users are not modified. - The previously uploaded file **stays in storage** until your PUT overwrites it.   Committing without uploading first therefore re-ingests the old content. 

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.DocumentApi;

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

        DocumentApi apiInstance = new DocumentApi(defaultClient);
        UUID id = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the document whose content is being replaced.
        try {
            DocumentInit result = apiInstance.reinitUpload(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DocumentApi#reinitUpload");
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
| **id** | **UUID**| ID of the document whose content is being replaced. | |

### Return type

[**DocumentInit**](DocumentInit.md)

### Authorization

[JWT](../README.md#JWT), [AccessToken](../README.md#AccessToken)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **415** | The document&#39;s content type is no longer accepted — see &#x60;GET /v1/doc/accept&#x60;. |  -  |
| **500** | Internal error. Check body to get more info |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | Document is not in &#x60;READY&#x60; or &#x60;FAILED&#x60; status — nothing to replace, or an ingestion is in flight. |  -  |
| **200** | Document reset to AWAITING_UPLOAD status. PUT the new file to &#x60;uploadUrl&#x60;. |  -  |


## search1

> DocumentSearchResponse search1(corpusId, q, tags, tagsMatch, status, contentType, lang, provider, createdAfter, createdBefore, minSize, maxSize, sort, order, pageSize, pageIndex)

Search documents

Find documents in a corpus by filename, tags, lifecycle status, content type, language, provider or ingestion date, sorted the way you need them.  Every filter is optional and they **narrow together**: a request carrying none of them returns the whole corpus, one carrying several returns only the documents matching all of them. For a plain corpus listing, &#x60;GET /v1/doc/&#x60; is the simpler endpoint — this one is for finding a document you cannot scroll to.  ### Filename — &#x60;q&#x60;  Case-insensitive, and **anchored at the start** of the filename: &#x60;q&#x3D;annual&#x60; finds &#x60;Annual-Report-2025.pdf&#x60;, &#x60;q&#x3D;report&#x60; does not. Put a &#x60;*&#x60; anywhere to match elsewhere — &#x60;q&#x3D;*report&#x60; searches any position, &#x60;q&#x3D;*report*&#x60; a substring, &#x60;q&#x3D;2025-*.pdf&#x60; a name that starts with &#x60;2025-&#x60; and ends in &#x60;.pdf&#x60;.  The default is anchored because that is the shape the index can serve: an anchored pattern is a range scan, a leading &#x60;*&#x60; is a filter over the corpus. Both are correct, the first is cheaper — prefer it when your client knows how the filename begins.  &#x60;%&#x60; and &#x60;_&#x60; carry no special meaning here: they match themselves.  ### Tags — &#x60;tags&#x60;, &#x60;tagsMatch&#x60;  Repeat the parameter for several tags (&#x60;tags&#x3D;legal&amp;tags&#x3D;2026&#x60;). By default (&#x60;tagsMatch&#x3D;ANY&#x60;) a document matches when it carries **at least one** of them, which is what &#x60;GET /v1/doc/?tags&#x3D;…&#x60; does; &#x60;tagsMatch&#x3D;ALL&#x60; requires **every** one of them, extra tags on the document being fine.  ### Status — &#x60;status&#x60;  Repeatable as well, and any of the listed states matches: &#x60;status&#x3D;PENDING&amp;status&#x3D;FAILED&#x60; returns everything that is not ingested yet or needs attention.  ### Content type — &#x60;contentType&#x60;  Repeatable too, and any of the listed types matches: &#x60;contentType&#x3D;application/pdf&amp;contentType&#x3D;text/plain&#x60;. Values are taken as they come — nothing is checked against &#x60;GET /v1/doc/accept&#x60;, so a type the platform does not ingest is not an error, it simply matches no document.  ### Size — &#x60;minSize&#x60;, &#x60;maxSize&#x60;  A range on the stored size in bytes, **inclusive at both ends** and each bound independent: &#x60;minSize&#x3D;1048576&#x60; alone is \&quot;at least 1 MB\&quot;, &#x60;maxSize&#x60; alone \&quot;at most\&quot;, and &#x60;minSize&#x3D;maxSize&#x3D;N&#x60; the documents of exactly that many bytes. &#x60;minSize&#x60; above &#x60;maxSize&#x60; is refused with &#x60;400&#x60; rather than answering an empty page.  A document only has a size once its upload is committed, so setting either bound also excludes everything still &#x60;AWAITING_UPLOAD&#x60; — the same documents &#x60;sort&#x3D;SIZE&#x60; pushes to the end of the result.  ### Dates — &#x60;createdAfter&#x60;, &#x60;createdBefore&#x60;  A half-open window on the ingestion date: &#x60;createdAfter&#x60; is inclusive, &#x60;createdBefore&#x60; exclusive, so consecutive windows tile the timeline without returning a document twice. Supplying &#x60;createdAfter&#x60; at or after &#x60;createdBefore&#x60; is refused with &#x60;400&#x60; rather than answering an empty page.  ### Ordering and paging  &#x60;sort&#x60; defaults to &#x60;CREATED_AT&#x60; and &#x60;order&#x60; to &#x60;DESC&#x60; — newest first. The ordering is closed by the document id, so walking &#x60;pageIndex&#x60; never shows the same document twice nor skips one, even when many documents share a sort key. Documents whose &#x60;size&#x60; is not known yet sort last whatever the direction.  &#x60;total&#x60; counts every match across all pages, not just the ones returned here.  ### Examples  * &#x60;?corpusId&#x3D;…&amp;q&#x3D;annual-report&#x60; — every document whose name starts with it * &#x60;?corpusId&#x3D;…&amp;q&#x3D;*report*&#x60; — anywhere in the name, at the cost of a scan * &#x60;?corpusId&#x3D;…&amp;q&#x3D;2025-*.pdf&#x60; — starts with &#x60;2025-&#x60;, ends in &#x60;.pdf&#x60; * &#x60;?corpusId&#x3D;…&amp;status&#x3D;FAILED&amp;status&#x3D;PENDING&amp;sort&#x3D;UPDATED_AT&amp;order&#x3D;ASC&#x60; — the   ingestion backlog, longest-waiting first * &#x60;?corpusId&#x3D;…&amp;tags&#x3D;legal&amp;tags&#x3D;2026&amp;tagsMatch&#x3D;ALL&#x60; — documents carrying both tags * &#x60;?corpusId&#x3D;…&amp;contentType&#x3D;application/pdf&amp;createdAfter&#x3D;2026-07-01T00:00:00Z&amp;createdBefore&#x3D;2026-10-01T00:00:00Z&amp;sort&#x3D;SIZE&amp;order&#x3D;DESC&#x60;   — last quarter&#39;s PDFs, biggest first * &#x60;?corpusId&#x3D;…&amp;contentType&#x3D;application/pdf&amp;contentType&#x3D;text/plain&amp;minSize&#x3D;1048576&#x60;   — PDFs and plain text over 1 MB * &#x60;?corpusId&#x3D;…&amp;maxSize&#x3D;0&#x60; — documents that were uploaded empty 

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.DocumentApi;

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

        DocumentApi apiInstance = new DocumentApi(defaultClient);
        UUID corpusId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the corpus to search.
        String q = "annual-report"; // String | Filename pattern, case-insensitive and anchored at the start of the name: `annual` matches `Annual-Report-2025.pdf`, `report` does not. Add `*` anywhere to match elsewhere (`*report*`), at the cost of a scan over the corpus. `%` and `_` match themselves. Blank or omitted, filenames are not filtered.
        List<String> tags = Arrays.asList(); // List<String> | Tag filter. Repeat for multiple values: `tags=legal&tags=2026`. When omitted, tags are ignored.
        String tagsMatch = "ANY"; // String | How `tags` combine: `ANY` keeps documents carrying at least one of them, `ALL` only those carrying every one. Ignored without `tags`.
        List<String> status = Arrays.asList(); // List<String> | Lifecycle filter. Repeat for several: `status=PENDING&status=FAILED` matches either. When omitted, documents of all statuses are returned.
        List<String> contentType = Arrays.asList(); // List<String> | MIME type filter. Repeat for several: `contentType=application/pdf&contentType=text/plain` matches either. Values are not checked against `GET /v1/doc/accept` — an unsupported one simply matches nothing. When omitted, content types are not filtered.
        String lang = "fr"; // String | Exact ISO-639 language code of the document.
        String provider = "user"; // String | Exact provider identifier, as supplied at upload time.
        OffsetDateTime createdAfter = OffsetDateTime.parse("2026-07-01T00:00:00Z"); // OffsetDateTime | Keep documents ingested at or after this instant (ISO-8601, inclusive).
        OffsetDateTime createdBefore = OffsetDateTime.parse("2026-10-01T00:00:00Z"); // OffsetDateTime | Keep documents ingested strictly before this instant (ISO-8601, exclusive).
        Long minSize = 1048576L; // Long | Keep documents of at least this many bytes (inclusive). Documents still awaiting upload have no size and drop out.
        Long maxSize = 10485760L; // Long | Keep documents of at most this many bytes (inclusive).
        String sort = "CREATED_AT"; // String | Column to sort on. Defaults to `CREATED_AT`.
        String order = "ASC"; // String | Sort direction. Defaults to `DESC` — newest, largest or alphabetically last first.
        Integer pageSize = 25; // Integer | Number of items per page, 1-100.
        Integer pageIndex = 0; // Integer | Zero-based page index.
        try {
            DocumentSearchResponse result = apiInstance.search1(corpusId, q, tags, tagsMatch, status, contentType, lang, provider, createdAfter, createdBefore, minSize, maxSize, sort, order, pageSize, pageIndex);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DocumentApi#search1");
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
| **corpusId** | **UUID**| ID of the corpus to search. | |
| **q** | **String**| Filename pattern, case-insensitive and anchored at the start of the name: &#x60;annual&#x60; matches &#x60;Annual-Report-2025.pdf&#x60;, &#x60;report&#x60; does not. Add &#x60;*&#x60; anywhere to match elsewhere (&#x60;*report*&#x60;), at the cost of a scan over the corpus. &#x60;%&#x60; and &#x60;_&#x60; match themselves. Blank or omitted, filenames are not filtered. | [optional] |
| **tags** | [**List&lt;String&gt;**](String.md)| Tag filter. Repeat for multiple values: &#x60;tags&#x3D;legal&amp;tags&#x3D;2026&#x60;. When omitted, tags are ignored. | [optional] |
| **tagsMatch** | **String**| How &#x60;tags&#x60; combine: &#x60;ANY&#x60; keeps documents carrying at least one of them, &#x60;ALL&#x60; only those carrying every one. Ignored without &#x60;tags&#x60;. | [optional] [enum: ANY, ALL] |
| **status** | [**List&lt;String&gt;**](String.md)| Lifecycle filter. Repeat for several: &#x60;status&#x3D;PENDING&amp;status&#x3D;FAILED&#x60; matches either. When omitted, documents of all statuses are returned. | [optional] [enum: AWAITING_UPLOAD, PENDING, PROCESSING, READY, FAILED] |
| **contentType** | [**List&lt;String&gt;**](String.md)| MIME type filter. Repeat for several: &#x60;contentType&#x3D;application/pdf&amp;contentType&#x3D;text/plain&#x60; matches either. Values are not checked against &#x60;GET /v1/doc/accept&#x60; — an unsupported one simply matches nothing. When omitted, content types are not filtered. | [optional] |
| **lang** | **String**| Exact ISO-639 language code of the document. | [optional] |
| **provider** | **String**| Exact provider identifier, as supplied at upload time. | [optional] |
| **createdAfter** | **OffsetDateTime**| Keep documents ingested at or after this instant (ISO-8601, inclusive). | [optional] |
| **createdBefore** | **OffsetDateTime**| Keep documents ingested strictly before this instant (ISO-8601, exclusive). | [optional] |
| **minSize** | **Long**| Keep documents of at least this many bytes (inclusive). Documents still awaiting upload have no size and drop out. | [optional] |
| **maxSize** | **Long**| Keep documents of at most this many bytes (inclusive). | [optional] |
| **sort** | **String**| Column to sort on. Defaults to &#x60;CREATED_AT&#x60;. | [optional] [enum: CREATED_AT, UPDATED_AT, FILENAME, SIZE] |
| **order** | **String**| Sort direction. Defaults to &#x60;DESC&#x60; — newest, largest or alphabetically last first. | [optional] [enum: ASC, DESC] |
| **pageSize** | **Integer**| Number of items per page, 1-100. | [optional] [default to 25] |
| **pageIndex** | **Integer**| Zero-based page index. | [optional] [default to 0] |

### Return type

[**DocumentSearchResponse**](DocumentSearchResponse.md)

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
| **400** | A filter or paging parameter is out of bounds, or the date window is empty. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | Page of matching documents. |  -  |


## status

> DocumentStatus status(id)

Get a document&#39;s status

Lightweight polling endpoint. Returns the current lifecycle status, an optional message (typically a failure reason when &#x60;status &#x3D;&#x3D; FAILED&#x60;), and the last update timestamp. Cheaper than &#x60;GET /v1/doc/{id}&#x60; for polling between commit and the final &#x60;READY&#x60; or &#x60;FAILED&#x60; status.

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.DocumentApi;

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

        DocumentApi apiInstance = new DocumentApi(defaultClient);
        UUID id = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the document.
        try {
            DocumentStatus result = apiInstance.status(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DocumentApi#status");
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
| **id** | **UUID**| ID of the document. | |

### Return type

[**DocumentStatus**](DocumentStatus.md)

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
| **200** | Status returned. |  -  |


## summary

> String summary(id)

Get a document summary

Return the Markdown summary generated during ingestion. Returns an empty body if the document has not been ingested yet or has no summary.

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.DocumentApi;

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

        DocumentApi apiInstance = new DocumentApi(defaultClient);
        UUID id = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the document.
        try {
            String result = apiInstance.summary(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DocumentApi#summary");
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
| **id** | **UUID**| ID of the document. | |

### Return type

**String**

### Authorization

[JWT](../README.md#JWT), [AccessToken](../README.md#AccessToken)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, text/markdown


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **500** | Internal error. Check body to get more info |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | Summary returned (may be empty). |  -  |


## update1

> Document update1(id, documentUpdateRequest)

Update a document

Patch the editable attributes of a document — &#x60;filename&#x60;, &#x60;docCreate&#x60;, &#x60;docUpdate&#x60;, &#x60;metadata&#x60;, &#x60;tags&#x60; and &#x60;chunk&#x60;. Only the fields present in the request body are updated; omitted fields keep their current value.  &#x60;metadata&#x60;, &#x60;tags&#x60; and &#x60;chunk&#x60; **replace** the stored value when provided — merge client-side if you want to preserve existing entries. Send &#x60;\&quot;tags\&quot;: []&#x60; to clear every tag, and &#x60;\&quot;chunk\&quot;: {}&#x60; to drop the chunking override and fall back to the platform default.  &#x60;docCreate&#x60; and &#x60;docUpdate&#x60; describe the **source** document, not the platform row: they are yours to correct, while &#x60;createdAt&#x60; and &#x60;updatedAt&#x60; remain server-managed and cannot be set here.  Every attribute is descriptive: renaming a document does not move the stored file nor re-trigger ingestion, so embeddings and previews are left untouched. Changing &#x60;chunk&#x60; likewise applies to the **next** ingestion — it does not re-chunk an already ingested document. Available in any lifecycle status. 

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.DocumentApi;

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

        DocumentApi apiInstance = new DocumentApi(defaultClient);
        UUID id = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the document to update.
        DocumentUpdateRequest documentUpdateRequest = new DocumentUpdateRequest(); // DocumentUpdateRequest | 
        try {
            Document result = apiInstance.update1(id, documentUpdateRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DocumentApi#update1");
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
| **id** | **UUID**| ID of the document to update. | |
| **documentUpdateRequest** | [**DocumentUpdateRequest**](DocumentUpdateRequest.md)|  | |

### Return type

[**Document**](Document.md)

### Authorization

[JWT](../README.md#JWT), [AccessToken](../README.md#AccessToken)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **500** | Internal error. Check body to get more info |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **400** | &#x60;filename&#x60; is blank or longer than 256 characters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | Document updated. |  -  |

