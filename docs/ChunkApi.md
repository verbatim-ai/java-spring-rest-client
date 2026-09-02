# ChunkApi

All URIs are relative to *https://api.verbatim-ai.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**delete3**](ChunkApi.md#delete3) | **DELETE** /v1/chunk/{chunkId} | Delete a chunk |
| [**get3**](ChunkApi.md#get3) | **GET** /v1/chunk/{chunkId} | Get a chunk |
| [**list6**](ChunkApi.md#list6) | **GET** /v1/chunk/ | List chunks |
| [**search2**](ChunkApi.md#search2) | **GET** /v1/chunk/q | Search chunks |
| [**update3**](ChunkApi.md#update3) | **PATCH** /v1/chunk/{chunkId} | Update a chunk |



## delete3

> AckResponse delete3(chunkId)

Delete a chunk

Take a chunk out of the index.  **This is a soft delete, like deleting a document or a session.** The chunk stops existing as far as this API and every answer built from now on is concerned: it disappears from &#x60;GET /v1/chunk/&#x60;, &#x60;GET /v1/chunk/q&#x60; and &#x60;GET /v1/chunk/{chunkId}&#x60;, and it can no longer be retrieved as context for a query. Nothing is destroyed underneath — neither the row nor the archived text — which is what makes it a decision about what may be retrieved rather than an erasure of what was. There is no endpoint that undoes it.  Past answers that cited this chunk keep their text and **lose the citation** pointing here.  The document itself is untouched: its file, its summary and its other chunks stay exactly as they were. That is what makes this usable for taking one passage out of the index without destroying the document it came from.  Deleting the document (&#x60;DELETE /v1/doc/{docId}&#x60;) does the same thing to every chunk at once, and re-ingesting it (&#x60;PUT /v1/doc/{docId}/content&#x60;) rebuilds every chunk from the file, this one included. 

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.ChunkApi;

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

        ChunkApi apiInstance = new ChunkApi(defaultClient);
        UUID chunkId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the chunk to delete.
        try {
            AckResponse result = apiInstance.delete3(chunkId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ChunkApi#delete3");
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
| **chunkId** | **UUID**| ID of the chunk to delete. | |

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
| **200** | Chunk deleted. |  -  |


## get3

> Chunk get3(chunkId)

Get a chunk

Fetch one chunk with its text.  Unlike the listings, &#x60;body&#x60; is always read here — a single storage round-trip, which is what this endpoint is for. An **empty** &#x60;body&#x60; on a row that exists is not an error and is worth acting on: it means the stored object is missing, so the chunk still matches vector searches and then contributes nothing to the answer.  &#x60;hash&#x60; is the MD5 of the text as it was pushed to storage. Comparing it against the body you just read is the cheapest integrity check there is, and searching it with &#x60;GET /v1/chunk/q?hash&#x3D;…&#x60; finds every copy of the same passage in your organization. 

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.ChunkApi;

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

        ChunkApi apiInstance = new ChunkApi(defaultClient);
        UUID chunkId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the chunk.
        try {
            Chunk result = apiInstance.get3(chunkId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ChunkApi#get3");
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
| **chunkId** | **UUID**| ID of the chunk. | |

### Return type

[**Chunk**](Chunk.md)

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
| **404** | No chunk with this id, or its document has been deleted. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | Chunk found. |  -  |


## list6

> ChunkListResponse list6(body, pageSize, pageIndex)

List chunks

Paginate every chunk of the caller&#39;s organization.  The organization is resolved from the JWT, so there is nothing to pass and no way to ask for another tenant&#39;s chunks. A chunk belongs to an organization through its document&#39;s corpus, and it is visible exactly as long as that document is: deleting a document takes its chunks out of this API too.  Chunks come back in reading order — by document, then by the first page each one covers, then by id — so a document&#39;s chunks arrive as a contiguous block in the order they appear in the file, with its summary chunk (the one covering no page) heading the block. The id closes the ordering, so walking &#x60;pageIndex&#x60; never shows the same chunk twice nor skips one when a page split into several.  &#x60;body&#x60; is **not** included: it lives in object storage and would cost one read per row. Pass &#x60;body&#x3D;true&#x60; if you want it — the page size is then capped at 25 — or use &#x60;GET /v1/chunk/{chunkId}&#x60;, which always carries it.  To narrow the result — by corpus, document, hash, page or metadata — use &#x60;GET /v1/chunk/q&#x60;, which takes the same paging parameters. 

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.ChunkApi;

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

        ChunkApi apiInstance = new ChunkApi(defaultClient);
        Boolean body = false; // Boolean | Include each chunk's text, read from object storage. One storage read per row — off by default.
        Integer pageSize = 25; // Integer | Number of items per page, 1-100 — or 1-25 when `body=true`.
        Integer pageIndex = 0; // Integer | Zero-based page index.
        try {
            ChunkListResponse result = apiInstance.list6(body, pageSize, pageIndex);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ChunkApi#list6");
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
| **body** | **Boolean**| Include each chunk&#39;s text, read from object storage. One storage read per row — off by default. | [optional] [default to false] |
| **pageSize** | **Integer**| Number of items per page, 1-100 — or 1-25 when &#x60;body&#x3D;true&#x60;. | [optional] [default to 25] |
| **pageIndex** | **Integer**| Zero-based page index. | [optional] [default to 0] |

### Return type

[**ChunkListResponse**](ChunkListResponse.md)

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
| **200** | Page of chunks. |  -  |


## search2

> ChunkListResponse search2(corpusId, documentId, hash, page, key, value, json, body, pageSize, pageIndex)

Search chunks

Find chunks of the caller&#39;s organization by corpus, document, hash, page and metadata.  Every filter is optional and they **narrow together**: a request carrying none of them returns the whole organization — the same answer as &#x60;GET /v1/chunk/&#x60; — and one carrying several returns only the chunks matching all of them.  The organization is never a parameter. It comes from the JWT and is always applied, so no combination of filters reaches another tenant&#39;s chunks.  ### Corpus and document — &#x60;corpusId&#x60;, &#x60;documentId&#x60;  Both must belong to the caller&#39;s organization, and both are checked *before* the search runs — naming one you cannot see answers &#x60;403&#x60; on the request rather than an empty page.  ### Hash — &#x60;hash&#x60;  Exact match on the MD5 of the chunk text. Equal hashes mean equal text, so this is how the same passage is found across documents: read a chunk, then search its hash with no &#x60;documentId&#x60; to see every copy of it in your organization. Sent empty (&#x60;&amp;hash&#x3D;&#x60;) it is treated as absent.  ### Page — &#x60;page&#x60;  Keeps chunks whose span **covers** that page. A chunk is built from consecutive elements and can cross page boundaries, so one covering pages 3 to 5 answers to &#x60;page&#x3D;3&#x60;, &#x60;page&#x3D;4&#x60; and &#x60;page&#x3D;5&#x60; alike. Pages are 1-based; &#x60;page&#x3D;0&#x60; is a &#x60;400&#x60;, not an empty page. Chunks belonging to no page in particular — the document summary — carry an empty span and match no &#x60;page&#x60; filter at all.  ### Metadata — &#x60;key&#x60;/&#x60;value&#x60;, or &#x60;json&#x60;  Matches chunks whose metadata **contains** the fragment (PostgreSQL&#39;s &#x60;@&gt;&#x60; operator), extra keys on the chunk being fine. Pass &#x60;key&#x60; and &#x60;value&#x60; for a single pair — they go together, one without the other is a &#x60;400&#x60; — or &#x60;json&#x60; for a raw object when the filter is nested or has several keys. &#x60;json&#x60; wins when both are supplied. &#x60;kind&#x60; is the key the platform sets: &#x60;chunk&#x60; for a piece of the document, &#x60;summary&#x60; for the generated summary.  ### Bodies — &#x60;body&#x60;  Off by default, because including them costs one storage read per row. With &#x60;body&#x3D;true&#x60; the page size is capped at 25.  ### Examples  * &#x60;?documentId&#x3D;…&#x60; — everything one document was split into, in reading order * &#x60;?documentId&#x3D;…&amp;body&#x3D;true&amp;pageSize&#x3D;10&#x60; — the same, with the text, ten at a time * &#x60;?documentId&#x3D;…&amp;page&#x3D;4&#x60; — every chunk covering page 4, including one that   starts on page 3 * &#x60;?hash&#x3D;9e107d9d372bb6826bd81d3542a419d6&#x60; — every copy of one passage in the   organization, across documents * &#x60;?corpusId&#x3D;…&amp;key&#x3D;kind&amp;value&#x3D;summary&#x60; — the summary chunk of every document in   a corpus * &#x60;?json&#x3D;{\&quot;section\&quot;:\&quot;Article 4\&quot;}&#x60; — a metadata fragment 

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.ChunkApi;

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

        ChunkApi apiInstance = new ChunkApi(defaultClient);
        UUID corpusId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | Keep chunks whose document belongs to this corpus. Must belong to the caller's organization.
        UUID documentId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | Keep chunks of this document. Must belong to the caller's organization.
        String hash = "9e107d9d372bb6826bd81d3542a419d6"; // String | Exact MD5 of the chunk text. Blank or omitted, the hash is not filtered.
        Integer page = 4; // Integer | Keep chunks whose page span covers this page. 1-based.
        String key = "kind"; // String | Metadata key to filter on. Goes together with `value`.
        String value = "summary"; // String | Metadata value matching `key`.
        String json = "{\"section\":\"Article 4\"}"; // String | Raw JSON object used as the containment filter. Wins over `key`/`value` when set.
        Boolean body = false; // Boolean | Include each chunk's text, read from object storage. One storage read per row — off by default.
        Integer pageSize = 25; // Integer | Number of items per page, 1-100 — or 1-25 when `body=true`.
        Integer pageIndex = 0; // Integer | Zero-based page index.
        try {
            ChunkListResponse result = apiInstance.search2(corpusId, documentId, hash, page, key, value, json, body, pageSize, pageIndex);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ChunkApi#search2");
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
| **corpusId** | **UUID**| Keep chunks whose document belongs to this corpus. Must belong to the caller&#39;s organization. | [optional] |
| **documentId** | **UUID**| Keep chunks of this document. Must belong to the caller&#39;s organization. | [optional] |
| **hash** | **String**| Exact MD5 of the chunk text. Blank or omitted, the hash is not filtered. | [optional] |
| **page** | **Integer**| Keep chunks whose page span covers this page. 1-based. | [optional] |
| **key** | **String**| Metadata key to filter on. Goes together with &#x60;value&#x60;. | [optional] |
| **value** | **String**| Metadata value matching &#x60;key&#x60;. | [optional] |
| **json** | **String**| Raw JSON object used as the containment filter. Wins over &#x60;key&#x60;/&#x60;value&#x60; when set. | [optional] |
| **body** | **Boolean**| Include each chunk&#39;s text, read from object storage. One storage read per row — off by default. | [optional] [default to false] |
| **pageSize** | **Integer**| Number of items per page, 1-100 — or 1-25 when &#x60;body&#x3D;true&#x60;. | [optional] [default to 25] |
| **pageIndex** | **Integer**| Zero-based page index. | [optional] [default to 0] |

### Return type

[**ChunkListResponse**](ChunkListResponse.md)

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
| **400** | A filter is malformed, or a paging parameter is out of bounds. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | Page of matching chunks. |  -  |


## update3

> Chunk update3(chunkId, chunkUpdateRequest)

Update a chunk

Patch a chunk&#39;s page span, metadata or text. Only the fields present in the body are applied; omitted fields keep their current value. Returns the full updated chunk, text included.  This is a **repair** endpoint. It exists so a chunk that ingestion got wrong can be corrected without re-processing the document, and it is worth knowing exactly what it does and does not do before reaching for it.  ### Rewriting &#x60;body&#x60; does not re-embed the chunk  The vector is the search index and it is not recomputed here. After patching the text, the chunk is still **retrieved for the text it used to hold** and is then handed to the model as the text it holds now. For a mangled character or a name to redact, that is exactly right — the passage means the same thing and is found the same way. For a rewrite, it is wrong: re-ingest the document instead (&#x60;PUT /v1/doc/{docId}/content&#x60;), which re-splits and re-embeds it.  &#x60;hash&#x60; is deliberately **not** recomputed either. It records the MD5 of what was embedded, so leaving it alone is what makes the divergence visible afterwards: a chunk whose &#x60;hash&#x60; no longer matches its &#x60;body&#x60; is one that has been patched.  ### &#x60;metadata&#x60; replaces, it does not merge  Send the whole object you want stored. &#x60;{}&#x60; clears it.  ### &#x60;pages&#x60; is a span  1-based page numbers, sorted and de-duplicated server-side. &#x60;[]&#x60; clears the span, which is what a chunk belonging to no page in particular carries. A value below 1 is a &#x60;400&#x60;. 

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.ChunkApi;

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

        ChunkApi apiInstance = new ChunkApi(defaultClient);
        UUID chunkId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the chunk to update.
        ChunkUpdateRequest chunkUpdateRequest = new ChunkUpdateRequest(); // ChunkUpdateRequest | 
        try {
            Chunk result = apiInstance.update3(chunkId, chunkUpdateRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ChunkApi#update3");
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
| **chunkId** | **UUID**| ID of the chunk to update. | |
| **chunkUpdateRequest** | [**ChunkUpdateRequest**](ChunkUpdateRequest.md)|  | |

### Return type

[**Chunk**](Chunk.md)

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
| **400** | A page number is below 1. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | Chunk updated. |  -  |

