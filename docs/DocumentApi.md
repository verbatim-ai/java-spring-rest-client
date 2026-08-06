# DocumentApi

All URIs are relative to *https://api.verbatim-ai.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**commitUpload**](DocumentApi.md#commitUpload) | **POST** /v1/doc/{id}/commit | Commit a previously initialized upload |
| [**delete1**](DocumentApi.md#delete1) | **DELETE** /v1/doc/{id} | Delete a document |
| [**downloadUrl1**](DocumentApi.md#downloadUrl1) | **GET** /v1/doc/{id}/download-url | Get a presigned download URL |
| [**get1**](DocumentApi.md#get1) | **GET** /v1/doc/{id} | Get a document |
| [**initUpload**](DocumentApi.md#initUpload) | **POST** /v1/doc/init | Initialize a direct-to-storage upload |
| [**list3**](DocumentApi.md#list3) | **GET** /v1/doc/ | List documents |
| [**listSupportedDocuments**](DocumentApi.md#listSupportedDocuments) | **GET** /v1/doc/accept | List accepted content types |
| [**previewUrls1**](DocumentApi.md#previewUrls1) | **GET** /v1/doc/{id}/preview-urls | Get presigned preview URLs |
| [**reinitUpload**](DocumentApi.md#reinitUpload) | **PUT** /v1/doc/{id}/init | Re-initialize a document for a new upload |
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
| **500** | Internal error. Check body to get more info |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
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
| **500** | Internal error. Check body to get more info |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
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
| **500** | Internal error. Check body to get more info |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
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
| **500** | Internal error. Check body to get more info |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | Document found. |  -  |


## initUpload

> DocumentInit initUpload(documentInitRequest)

Initialize a direct-to-storage upload

Step 1 of the upload flow. Validates inputs, creates a document in &#x60;AWAITING_UPLOAD&#x60; status, and returns a single-use presigned PUT URL the client must use to push the file bytes directly to S3 — no content flows through this server.  The returned &#x60;uploadUrl&#x60; is bound to the requested &#x60;contentType&#x60;: the client MUST send a matching &#x60;Content-Type&#x60; header in the PUT request, or S3 will reject it.  After the PUT succeeds, call &#x60;POST /v1/doc/{id}/commit&#x60; to trigger ingestion.  Accepted content types are listed by &#x60;GET /v1/doc/accept&#x60;. 

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
| **500** | Internal error. Check body to get more info |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | Document created in AWAITING_UPLOAD status. PUT the file to &#x60;uploadUrl&#x60;. |  -  |


## list3

> DocumentListResponse list3(corpusId, status, pageSize, pageIndex)

List documents

Paginate documents stored in a corpus, newest first. Pass the optional &#x60;status&#x60; filter to narrow down by lifecycle state — e.g. &#x60;status&#x3D;PENDING&#x60; returns the ingestion backlog, &#x60;status&#x3D;FAILED&#x60; returns documents that need attention.

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
        Integer pageSize = 25; // Integer | Number of items per page.
        Integer pageIndex = 0; // Integer | Zero-based page index.
        try {
            DocumentListResponse result = apiInstance.list3(corpusId, status, pageSize, pageIndex);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DocumentApi#list3");
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
| **pageSize** | **Integer**| Number of items per page. | [optional] [default to 25] |
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
| **500** | Internal error. Check body to get more info |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
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
| **500** | Internal error. Check body to get more info |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | List of accepted MIME types. |  -  |


## previewUrls1

> DocumentPreviewUrls previewUrls1(id, pages)

Get presigned preview URLs

Return time-limited presigned URLs for the rendered preview images of the document. One entry is issued per (page, size): by default the first 4 pages × {SMALL, MEDIUM}, so up to 8 entries per call.  Pass &#x60;pages&#x60; to restrict the response to specific page indices (e.g. &#x60;pages&#x3D;0&amp;pages&#x3D;2&#x60;). When omitted, pages 0–3 are used. Duplicate values are preserved as supplied.  The URLs point at preview images produced asynchronously by the rendering pipeline. No existence check is performed — individual URLs MAY return 404 when fetched if the corresponding (page, size) hasn&#39;t been generated yet; clients SHOULD fall back per-tile. 

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
        List<Integer> pages = Arrays.asList(); // List<Integer> | Page indices to include. When omitted, pages 0–3 are returned. Repeat for multiple values: `pages=0&pages=2`.
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
| **pages** | [**List&lt;Integer&gt;**](Integer.md)| Page indices to include. When omitted, pages 0–3 are returned. Repeat for multiple values: &#x60;pages&#x3D;0&amp;pages&#x3D;2&#x60;. | [optional] |

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
| **500** | Internal error. Check body to get more info |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | Presigned preview URLs issued. |  -  |


## reinitUpload

> DocumentInit reinitUpload(id)

Re-initialize a document for a new upload

Replace the **content** of an existing document while keeping its identity: same &#x60;id&#x60;, same &#x60;filename&#x60;, &#x60;userId&#x60;, &#x60;provider&#x60;, &#x60;lang&#x60;, &#x60;metadata&#x60; and source dates. Use &#x60;PATCH /v1/doc/{id}&#x60; to change those attributes — this endpoint only touches the file behind them.  The document must be in &#x60;READY&#x60; or &#x60;FAILED&#x60; status; any other status is rejected with &#x60;409&#x60;, since there is either nothing ingested yet or an ingestion in flight.  Everything derived from the previous content is dropped: its embeddings, its summary, and the counters filled in by ingestion (&#x60;size&#x60;, &#x60;tokens&#x60;, &#x60;nbWords&#x60;). The document moves back to &#x60;AWAITING_UPLOAD&#x60; and the response carries a fresh presigned PUT URL — the same payload as &#x60;POST /v1/doc/init&#x60;. From there the flow is unchanged: PUT the new bytes, then call &#x60;POST /v1/doc/{id}/commit&#x60;.  Two things to be aware of:  - Posts that cited this document **lose their attachments to it**, because the   citations point at the embeddings being deleted. Answers already returned to   users are not modified. - The previously uploaded file **stays in storage** until your PUT overwrites it.   Committing without uploading first therefore re-ingests the old content. 

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
| **500** | Internal error. Check body to get more info |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **415** | The document&#39;s content type is no longer accepted — see &#x60;GET /v1/doc/accept&#x60;. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | Document is not in &#x60;READY&#x60; or &#x60;FAILED&#x60; status — nothing to replace, or an ingestion is in flight. |  -  |
| **200** | Document reset to AWAITING_UPLOAD status. PUT the new file to &#x60;uploadUrl&#x60;. |  -  |


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
| **500** | Internal error. Check body to get more info |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
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
| **500** | Internal error. Check body to get more info |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | Summary returned (may be empty). |  -  |


## update1

> Document update1(id, documentUpdateRequest)

Update a document

Patch the editable attributes of a document — &#x60;filename&#x60;, &#x60;docCreate&#x60;, &#x60;docUpdate&#x60; and &#x60;metadata&#x60;. Only the fields present in the request body are updated; omitted fields keep their current value.  &#x60;metadata&#x60; **replaces** the stored map when provided — merge client-side if you want to preserve existing keys.  &#x60;docCreate&#x60; and &#x60;docUpdate&#x60; describe the **source** document, not the platform row: they are yours to correct, while &#x60;createdAt&#x60; and &#x60;updatedAt&#x60; remain server-managed and cannot be set here.  Every attribute is descriptive: renaming a document does not move the stored file nor re-trigger ingestion, so embeddings and previews are left untouched. Available in any lifecycle status. 

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
| **500** | Internal error. Check body to get more info |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **400** | &#x60;filename&#x60; is blank or longer than 256 characters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | Document updated. |  -  |

