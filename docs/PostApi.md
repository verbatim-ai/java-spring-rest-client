# PostApi

All URIs are relative to *https://api.verbatim-ai.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**attachment**](PostApi.md#attachment) | **GET** /v1/post/attachment/{postId} | Attachments from a post |
| [**delete5**](PostApi.md#delete5) | **DELETE** /v1/post/{postId} | Delete a post |
| [**downloadUrl**](PostApi.md#downloadUrl) | **GET** /v1/post/attachment/{docId}/download-url | Get a presigned download URL |
| [**get5**](PostApi.md#get5) | **GET** /v1/post/{postId} | Get a post |
| [**list3**](PostApi.md#list3) | **GET** /v1/post/ | List posts |
| [**previewUrls**](PostApi.md#previewUrls) | **GET** /v1/post/attachment/{docId}/preview-urls | Get presigned preview URLs |
| [**query**](PostApi.md#query) | **GET** /v1/post/q | Send a query |



## attachment

> PostAttachmentResponse attachment(postId)

Attachments from a post

List the attachments from a post.

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.PostApi;

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

        PostApi apiInstance = new PostApi(defaultClient);
        UUID postId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the post.
        try {
            PostAttachmentResponse result = apiInstance.attachment(postId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PostApi#attachment");
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
| **postId** | **UUID**| ID of the post. | |

### Return type

[**PostAttachmentResponse**](PostAttachmentResponse.md)

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
| **200** | Attachments found. |  -  |


## delete5

> AckResponse delete5(postId)

Delete a post

Permanently delete a post and its attachments. Documents and embeddings referenced by the attachments are **not** affected.

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.PostApi;

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

        PostApi apiInstance = new PostApi(defaultClient);
        UUID postId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the post to delete.
        try {
            AckResponse result = apiInstance.delete5(postId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PostApi#delete5");
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
| **postId** | **UUID**| ID of the post to delete. | |

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
| **200** | Post deleted. |  -  |


## downloadUrl

> DocumentDownloadUrl downloadUrl(docId)

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
import com.verbatim.client.springrest.api.PostApi;

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

        PostApi apiInstance = new PostApi(defaultClient);
        UUID docId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the document.
        try {
            DocumentDownloadUrl result = apiInstance.downloadUrl(docId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PostApi#downloadUrl");
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
| **docId** | **UUID**| ID of the document. | |

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
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | Presigned URL issued. |  -  |


## get5

> Post get5(postId)

Get a post

Fetch a single post by its identifier. The response carries &#x60;attachment&#x60;, the number of source chunks behind it; the sources themselves come from &#x60;GET /v1/post/attachment/{postId}&#x60;.

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.PostApi;

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

        PostApi apiInstance = new PostApi(defaultClient);
        UUID postId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the post.
        try {
            Post result = apiInstance.get5(postId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PostApi#get5");
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
| **postId** | **UUID**| ID of the post. | |

### Return type

[**Post**](Post.md)

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
| **200** | Post found. |  -  |


## list3

> PostListResponse list3(sessionId, pageSize, pageIndex, order)

List posts

Paginate every post of a session — the user questions and the system answers alike, interleaved in the order they were written.  **Ordering.** &#x60;order&#x3D;ASC&#x60; (the default) reads the conversation, natural timestamp (lastest post first). Ordering &#x60;order&#x3D;DESC&#x60; reads the conversation backwards, most recent first, which is what a client polling for what just happened wants: page &#x60;0&#x60; is the latest exchange whatever the session has grown to. &#x60;order&#x3D;ASC&#x60; reads it forwards, oldest first — the transcript order, and the one to walk when rendering a whole conversation from the beginning.  Posts are ordered on &#x60;createdAt&#x60; and the ordering is closed by the post id, so walking &#x60;pageIndex&#x60; never shows the same post twice nor skips one — the two posts of a single exchange are written microseconds apart and can share a timestamp. Note the consequence of that tie: when they do share one, the question and its answer are ordered by id, which is arbitrary. Read &#x60;owner&#x60; rather than position to tell them apart.  **Paging.** &#x60;pageSize&#x60; is 1–100 and defaults to &#x60;25&#x60;; &#x60;pageIndex&#x60; is zero-based. Values outside those bounds are refused with &#x60;400&#x60;. &#x60;total&#x60; carries the number of posts in the session across every page, so a client knows how far it has to walk. Soft-deleted posts are excluded from both the page and the count.  Examples:  * &#x60;?sessionId&#x3D;…&#x60; — the 25 most recent posts of the session, newest first. * &#x60;?sessionId&#x3D;…&amp;order&#x3D;ASC&amp;pageSize&#x3D;50&#x60; — the conversation from its first post,   50 at a time. * &#x60;?sessionId&#x3D;…&amp;pageIndex&#x3D;1&#x60; — the exchange before the latest ones. 

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.PostApi;

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

        PostApi apiInstance = new PostApi(defaultClient);
        UUID sessionId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the session.
        Integer pageSize = 25; // Integer | Number of items per page, 1-100.
        Integer pageIndex = 0; // Integer | Zero-based page index.
        String order = "ASC"; // String | Direction to read the session in: `DESC` newest first, `ASC` oldest first. Defaults to `DESC`.
        try {
            PostListResponse result = apiInstance.list3(sessionId, pageSize, pageIndex, order);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PostApi#list3");
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
| **sessionId** | **UUID**| ID of the session. | |
| **pageSize** | **Integer**| Number of items per page, 1-100. | [optional] [default to 25] |
| **pageIndex** | **Integer**| Zero-based page index. | [optional] [default to 0] |
| **order** | **String**| Direction to read the session in: &#x60;DESC&#x60; newest first, &#x60;ASC&#x60; oldest first. Defaults to &#x60;DESC&#x60;. | [optional] [enum: ASC, DESC] |

### Return type

[**PostListResponse**](PostListResponse.md)

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
| **400** | &#x60;pageSize&#x60; outside 1–100, a negative &#x60;pageIndex&#x60;, or an &#x60;order&#x60; other than &#x60;ASC&#x60; or &#x60;DESC&#x60;. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | Page of posts. |  -  |


## previewUrls

> DocumentPreviewUrls previewUrls(docId, pages)

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
import com.verbatim.client.springrest.api.PostApi;

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

        PostApi apiInstance = new PostApi(defaultClient);
        UUID docId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the document.
        List<Integer> pages = Arrays.asList(); // List<Integer> | One-based page indices to issue preview URLs for. Required: 1 to 10 values per request, each within the document's page range. Repeat for multiple values: `pages=1&pages=2`.
        try {
            DocumentPreviewUrls result = apiInstance.previewUrls(docId, pages);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PostApi#previewUrls");
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
| **docId** | **UUID**| ID of the document. | |
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
| **500** | Internal error. Check body to get more info |  -  |
| **415** | Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types. |  -  |
| **403** | Not authorized. Access not granted for this request |  -  |
| **404** | The resource referenced by the request does not exist. |  -  |
| **400** | &#x60;pages&#x60; is missing, empty, carries more than 10 indices, or names a page outside the document. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | Presigned preview URLs issued. |  -  |


## query

> PostItemResponse query(sessionId, body, lang, agentId)

Send a query

Submit a user message to a session and run the full RAG pipeline:  1. Persist the query as a post with &#x60;owner &#x3D; USER&#x60;. 2. Vectorize the query and run a cosine-similarity search against the session&#39;s corpora. 3. Feed the top chunks to the session&#39;s LLM as context. 4. Persist the answer as a post with &#x60;owner &#x3D; SYSTEM&#x60;, with attachments pointing to the chunks used.  The response contains both the user post (&#x60;query&#x60;) and the system post (&#x60;answer&#x60;).  ### Choosing an agent  How much of that pipeline runs, and how, is decided by an **agent** — retrieval width, whether the chunks are re-ranked, the system instruction, how much of the conversation is replayed, and which model answers. See &#x60;GET /v1/agent/&#x60;.  Omit &#x60;agentId&#x60; and the query runs on the platform default agent, which is what every query did before agents existed. Pass one to run this single query under a different setup:  &#x60;&#x60;&#x60; GET /v1/post/q?sessionId&#x3D;$SESSION_ID&amp;body&#x3D;What+is+the+refund+policy%3F&amp;agentId&#x3D;$AGENT_ID &#x60;&#x60;&#x60;  The choice is **per query, not per session** — the next query on the same session is independent, so a client can escalate one question to a wider, slower agent without changing the conversation it belongs to.  The agent is then recorded on the answer as &#x60;agentId&#x60;, and only on the answer: the user&#39;s question is not something an agent produced. A missing &#x60;agentId&#x60; on an answer therefore means \&quot;ran on the default agent\&quot;, not \&quot;unknown\&quot;. Deleting an agent does not rewrite the answers it produced, so this still names an agent you have since deleted — resolving that id through &#x60;GET /v1/agent/{agentId}&#x60; answers &#x60;404&#x60;, which is the honest reading.  An &#x60;agentId&#x60; your organization cannot see — someone else&#39;s, or one that never existed — answers &#x60;404&#x60; and no post is written. 

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.PostApi;

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

        PostApi apiInstance = new PostApi(defaultClient);
        UUID sessionId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the session to post the query into.
        String body = "What is the main topic of the corpus?"; // String | User message to send to the LLM.
        String lang = "fr"; // String | ISO-639 language code used by the LLM. Defaults to `en`.
        UUID agentId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | Agent to run this query under. Omit to use the platform default agent. Must be one of the agents `GET /v1/agent/` lists for your organization.
        try {
            PostItemResponse result = apiInstance.query(sessionId, body, lang, agentId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PostApi#query");
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
| **sessionId** | **UUID**| ID of the session to post the query into. | |
| **body** | **String**| User message to send to the LLM. | |
| **lang** | **String**| ISO-639 language code used by the LLM. Defaults to &#x60;en&#x60;. | [optional] |
| **agentId** | **UUID**| Agent to run this query under. Omit to use the platform default agent. Must be one of the agents &#x60;GET /v1/agent/&#x60; lists for your organization. | [optional] |

### Return type

[**PostItemResponse**](PostItemResponse.md)

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
| **200** | Query processed and answer returned. |  -  |

