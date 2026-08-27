# AgentApi

All URIs are relative to *https://api.verbatim-ai.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**create3**](AgentApi.md#create3) | **POST** /v1/agent/ | Create an agent |
| [**delete3**](AgentApi.md#delete3) | **DELETE** /v1/agent/{agentId} | Delete an agent |
| [**get3**](AgentApi.md#get3) | **GET** /v1/agent/{agentId} | Get an agent |
| [**list1**](AgentApi.md#list1) | **GET** /v1/agent/ | List agents |
| [**update3**](AgentApi.md#update3) | **PATCH** /v1/agent/{agentId} | Update an agent |



## create3

> Agent create3(agentCreateRequest)

Create an agent

Create a custom agent owned by your organization.  Only &#x60;name&#x60; is required — the smallest useful body is &#x60;{\&quot;name\&quot;: \&quot;...\&quot;}&#x60;, which produces an agent identical in behaviour to the platform default and free to diverge from it later. Every field you leave out either takes its column default (&#x60;topK&#x60; 5, &#x60;rerank&#x60; true, &#x60;useHistory&#x60; true, &#x60;thinkingMode&#x60; HIGH) or stays unset and tracks the platform value.  &#x60;name&#x60; must be free: not one of your own agents&#39; names, and not one carried by a platform agent (&#x60;lock: true&#x60;) either — both answer &#x60;409&#x60;. Core agents appear in your listing, so &#x60;Verbatim Default&#x60; there and &#x60;Verbatim Default&#x60; of your own would be two entries you could only tell apart by &#x60;lock&#x60;. Names are compared exactly, so &#x60;Support&#x60; and &#x60;support&#x60; are two names and &#x60;Verbatim Default v2&#x60; is free. Deleting an agent puts its name back into circulation.  &#x60;rerankModel&#x60; and &#x60;baseModel&#x60; are checked against &#x60;GET /v1/config/model&#x60; here rather than at query time, so a typo is a &#x60;400&#x60; on this request instead of a failure on every query the agent later runs.  The result is always &#x60;lock: false&#x60; and &#x60;default: false&#x60;. Core agents are seeded by the platform and cannot be created over the API. 

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.AgentApi;

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

        AgentApi apiInstance = new AgentApi(defaultClient);
        AgentCreateRequest agentCreateRequest = new AgentCreateRequest(); // AgentCreateRequest | 
        try {
            Agent result = apiInstance.create3(agentCreateRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AgentApi#create3");
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
| **agentCreateRequest** | [**AgentCreateRequest**](AgentCreateRequest.md)|  | |

### Return type

[**Agent**](Agent.md)

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
| **400** | Missing or over-long &#x60;name&#x60;, a non-positive &#x60;topK&#x60; / &#x60;rerankTopK&#x60; / &#x60;historySize&#x60;, a &#x60;temperature&#x60; outside 0–1, or a model name &#x60;GET /v1/config/model&#x60; does not advertise. |  -  |
| **409** | This &#x60;name&#x60; is taken — by one of your agents, or by a platform agent. |  -  |
| **200** | Agent created. |  -  |


## delete3

> AckResponse delete3(agentId)

Delete an agent

Delete a custom agent. From here on it is gone: absent from &#x60;GET /v1/agent/&#x60;, &#x60;404&#x60; on get, update and delete, and &#x60;404&#x60; on any query naming it — a deleted agent is indistinguishable from one that never existed.  What it does **not** do is rewrite the past. Answers already produced under this agent keep naming it in their &#x60;agentId&#x60;, so a conversation stays readable exactly as it happened. Deleting an agent changes what you can use from now on, not what already ran.  Sessions are unaffected: an agent is resolved per query, so a conversation that used this one simply carries on under the platform default.  Its &#x60;name&#x60; goes back into circulation, so a replacement can be created under the same name straight away.  Core agents (&#x60;lock: true&#x60;) cannot be deleted — that answers &#x60;400&#x60;. 

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.AgentApi;

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

        AgentApi apiInstance = new AgentApi(defaultClient);
        UUID agentId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the agent to delete.
        try {
            AckResponse result = apiInstance.delete3(agentId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AgentApi#delete3");
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
| **agentId** | **UUID**| ID of the agent to delete. | |

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
| **404** | No agent with this id is visible to your organization. |  -  |
| **400** | The agent is a core agent (&#x60;lock: true&#x60;). |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | Agent deleted. |  -  |


## get3

> Agent get3(agentId)

Get an agent

Fetch one agent by its identifier — yours or a core one.  An id belonging to another organization answers &#x60;404&#x60;, the same as an id that does not exist: the two are deliberately indistinguishable. 

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.AgentApi;

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

        AgentApi apiInstance = new AgentApi(defaultClient);
        UUID agentId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the agent.
        try {
            Agent result = apiInstance.get3(agentId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AgentApi#get3");
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
| **agentId** | **UUID**| ID of the agent. | |

### Return type

[**Agent**](Agent.md)

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
| **404** | No agent with this id is visible to your organization. |  -  |
| **400** | The request is malformed or contains invalid parameters. |  -  |
| **409** | The request conflicts with the current state of the resource. |  -  |
| **200** | Agent found. |  -  |


## list1

> AgentListResponse list1(pageSize, pageIndex)

List agents

Paginate every agent your organization can query with: the platform&#39;s core agents merged with your own custom ones, **core first**, then by name.  There is no separate endpoint for the core catalogue — the merge is the point. Tell the two apart by &#x60;lock&#x60;: &#x60;true&#x60; is a platform agent you can read and use but not modify. A brand-new organization sees six of them, one per use case, and the single agent carrying &#x60;default: true&#x60; is the one a query that names no agent runs on. 

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.AgentApi;

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

        AgentApi apiInstance = new AgentApi(defaultClient);
        Integer pageSize = 25; // Integer | Number of items per page.
        Integer pageIndex = 0; // Integer | Zero-based page index.
        try {
            AgentListResponse result = apiInstance.list1(pageSize, pageIndex);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AgentApi#list1");
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

[**AgentListResponse**](AgentListResponse.md)

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
| **200** | Page of agents. |  -  |


## update3

> Agent update3(agentId, agentUpdateRequest)

Update an agent

Patch a custom agent. Fields absent from the body keep their current value.  Because \&quot;absent\&quot; already means \&quot;leave alone\&quot;, it cannot also mean \&quot;put this back to the platform default\&quot; — that is what &#x60;reset&#x60; is for. List the nullable fields you want un-set and they go back to tracking the platform value:  &#x60;&#x60;&#x60;json { \&quot;topK\&quot;: 12, \&quot;reset\&quot;: [\&quot;spirit\&quot;, \&quot;temperature\&quot;] } &#x60;&#x60;&#x60;  &#x60;reset&#x60; runs after the rest of the body, so a field named in both ends up cleared.  Renaming onto a name another of your agents holds, or one a platform agent carries, answers &#x60;409&#x60;. Sending this agent&#39;s own current name does not — an unchanged name is not a rename, so a client that echoes the whole object back is unaffected.  Core agents (&#x60;lock: true&#x60;) belong to the platform and every organization sees the same row — patching one answers &#x60;400&#x60;. 

### Example

```java
// Import classes:
import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.ApiException;
import com.verbatim.client.springrest.invoker.Configuration;
import com.verbatim.client.springrest.invoker.auth.*;
import com.verbatim.client.springrest.invoker.models.*;
import com.verbatim.client.springrest.api.AgentApi;

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

        AgentApi apiInstance = new AgentApi(defaultClient);
        UUID agentId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"); // UUID | ID of the agent to update.
        AgentUpdateRequest agentUpdateRequest = new AgentUpdateRequest(); // AgentUpdateRequest | 
        try {
            Agent result = apiInstance.update3(agentId, agentUpdateRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AgentApi#update3");
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
| **agentId** | **UUID**| ID of the agent to update. | |
| **agentUpdateRequest** | [**AgentUpdateRequest**](AgentUpdateRequest.md)|  | |

### Return type

[**Agent**](Agent.md)

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
| **404** | No agent with this id is visible to your organization. |  -  |
| **400** | The agent is a core agent (&#x60;lock: true&#x60;), &#x60;reset&#x60; names a field that has no platform default, or a value fails validation. |  -  |
| **409** | The requested &#x60;name&#x60; is carried by another of your agents, or by a platform agent. |  -  |
| **200** | Agent updated. |  -  |

