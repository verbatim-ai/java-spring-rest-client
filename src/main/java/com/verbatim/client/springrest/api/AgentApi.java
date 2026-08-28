package com.verbatim.client.springrest.api;

import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.BaseApi;

import com.verbatim.client.springrest.models.AckResponse;
import com.verbatim.client.springrest.models.Agent;
import com.verbatim.client.springrest.models.AgentCreateRequest;
import com.verbatim.client.springrest.models.AgentListResponse;
import com.verbatim.client.springrest.models.AgentUpdateRequest;
import com.verbatim.client.springrest.models.Error;
import java.util.UUID;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.25.0")
public class AgentApi extends BaseApi {

    public AgentApi() {
        super(new ApiClient());
    }

    public AgentApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Create an agent
     * Create a custom agent owned by your organization.  Only &#x60;name&#x60; is required — the smallest useful body is &#x60;{\&quot;name\&quot;: \&quot;...\&quot;}&#x60;, which produces an agent identical in behaviour to the platform default and free to diverge from it later. Every field you leave out either takes its column default (&#x60;topK&#x60; 5, &#x60;rerank&#x60; true, &#x60;useHistory&#x60; true, &#x60;thinkingMode&#x60; HIGH) or stays unset and tracks the platform value.  &#x60;name&#x60; must be free: not one of your own agents&#39; names, and not one carried by a platform agent (&#x60;lock: true&#x60;) either — both answer &#x60;409&#x60;. Core agents appear in your listing, so &#x60;Verbatim Default&#x60; there and &#x60;Verbatim Default&#x60; of your own would be two entries you could only tell apart by &#x60;lock&#x60;. Names are compared exactly, so &#x60;Support&#x60; and &#x60;support&#x60; are two names and &#x60;Verbatim Default v2&#x60; is free. Deleting an agent puts its name back into circulation.  &#x60;rerankModel&#x60; and &#x60;baseModel&#x60; are checked against &#x60;GET /v1/config/model&#x60; here rather than at query time, so a typo is a &#x60;400&#x60; on this request instead of a failure on every query the agent later runs.  The result is always &#x60;lock: false&#x60; and &#x60;default: false&#x60;. Core agents are seeded by the platform and cannot be created over the API. 
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - Missing or over-long &#x60;name&#x60;, a non-positive &#x60;topK&#x60; / &#x60;rerankTopK&#x60; / &#x60;historySize&#x60;, a &#x60;temperature&#x60; outside 0–1, or a model name &#x60;GET /v1/config/model&#x60; does not advertise.
     * <p><b>409</b> - This &#x60;name&#x60; is taken — by one of your agents, or by a platform agent.
     * <p><b>200</b> - Agent created.
     * @param agentCreateRequest  (required)
     * @return Agent
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Agent create3(AgentCreateRequest agentCreateRequest) throws RestClientException {
        return create3WithHttpInfo(agentCreateRequest).getBody();
    }

    /**
     * Create an agent
     * Create a custom agent owned by your organization.  Only &#x60;name&#x60; is required — the smallest useful body is &#x60;{\&quot;name\&quot;: \&quot;...\&quot;}&#x60;, which produces an agent identical in behaviour to the platform default and free to diverge from it later. Every field you leave out either takes its column default (&#x60;topK&#x60; 5, &#x60;rerank&#x60; true, &#x60;useHistory&#x60; true, &#x60;thinkingMode&#x60; HIGH) or stays unset and tracks the platform value.  &#x60;name&#x60; must be free: not one of your own agents&#39; names, and not one carried by a platform agent (&#x60;lock: true&#x60;) either — both answer &#x60;409&#x60;. Core agents appear in your listing, so &#x60;Verbatim Default&#x60; there and &#x60;Verbatim Default&#x60; of your own would be two entries you could only tell apart by &#x60;lock&#x60;. Names are compared exactly, so &#x60;Support&#x60; and &#x60;support&#x60; are two names and &#x60;Verbatim Default v2&#x60; is free. Deleting an agent puts its name back into circulation.  &#x60;rerankModel&#x60; and &#x60;baseModel&#x60; are checked against &#x60;GET /v1/config/model&#x60; here rather than at query time, so a typo is a &#x60;400&#x60; on this request instead of a failure on every query the agent later runs.  The result is always &#x60;lock: false&#x60; and &#x60;default: false&#x60;. Core agents are seeded by the platform and cannot be created over the API. 
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - Missing or over-long &#x60;name&#x60;, a non-positive &#x60;topK&#x60; / &#x60;rerankTopK&#x60; / &#x60;historySize&#x60;, a &#x60;temperature&#x60; outside 0–1, or a model name &#x60;GET /v1/config/model&#x60; does not advertise.
     * <p><b>409</b> - This &#x60;name&#x60; is taken — by one of your agents, or by a platform agent.
     * <p><b>200</b> - Agent created.
     * @param agentCreateRequest  (required)
     * @return ResponseEntity&lt;Agent&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Agent> create3WithHttpInfo(AgentCreateRequest agentCreateRequest) throws RestClientException {
        Object localVarPostBody = agentCreateRequest;
        
        // verify the required parameter 'agentCreateRequest' is set
        if (agentCreateRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'agentCreateRequest' when calling create3");
        }
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

        ParameterizedTypeReference<Agent> localReturnType = new ParameterizedTypeReference<Agent>() {};
        return apiClient.invokeAPI("/v1/agent/", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete an agent
     * Delete a custom agent. From here on it is gone: absent from &#x60;GET /v1/agent/&#x60;, &#x60;404&#x60; on get, update and delete, and &#x60;404&#x60; on any query naming it — a deleted agent is indistinguishable from one that never existed.  What it does **not** do is rewrite the past. Answers already produced under this agent keep naming it in their &#x60;agentId&#x60;, so a conversation stays readable exactly as it happened. Deleting an agent changes what you can use from now on, not what already ran.  Sessions are unaffected: an agent is resolved per query, so a conversation that used this one simply carries on under the platform default.  Its &#x60;name&#x60; goes back into circulation, so a replacement can be created under the same name straight away.  Core agents (&#x60;lock: true&#x60;) cannot be deleted — that answers &#x60;400&#x60;. 
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - No agent with this id is visible to your organization.
     * <p><b>400</b> - The agent is a core agent (&#x60;lock: true&#x60;).
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Agent deleted.
     * @param agentId ID of the agent to delete. (required)
     * @return AckResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public AckResponse delete3(UUID agentId) throws RestClientException {
        return delete3WithHttpInfo(agentId).getBody();
    }

    /**
     * Delete an agent
     * Delete a custom agent. From here on it is gone: absent from &#x60;GET /v1/agent/&#x60;, &#x60;404&#x60; on get, update and delete, and &#x60;404&#x60; on any query naming it — a deleted agent is indistinguishable from one that never existed.  What it does **not** do is rewrite the past. Answers already produced under this agent keep naming it in their &#x60;agentId&#x60;, so a conversation stays readable exactly as it happened. Deleting an agent changes what you can use from now on, not what already ran.  Sessions are unaffected: an agent is resolved per query, so a conversation that used this one simply carries on under the platform default.  Its &#x60;name&#x60; goes back into circulation, so a replacement can be created under the same name straight away.  Core agents (&#x60;lock: true&#x60;) cannot be deleted — that answers &#x60;400&#x60;. 
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - No agent with this id is visible to your organization.
     * <p><b>400</b> - The agent is a core agent (&#x60;lock: true&#x60;).
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Agent deleted.
     * @param agentId ID of the agent to delete. (required)
     * @return ResponseEntity&lt;AckResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<AckResponse> delete3WithHttpInfo(UUID agentId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'agentId' is set
        if (agentId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'agentId' when calling delete3");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("agentId", agentId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

        ParameterizedTypeReference<AckResponse> localReturnType = new ParameterizedTypeReference<AckResponse>() {};
        return apiClient.invokeAPI("/v1/agent/{agentId}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get an agent
     * Fetch one agent by its identifier — yours or a core one.  An id belonging to another organization answers &#x60;404&#x60;, the same as an id that does not exist: the two are deliberately indistinguishable. 
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - No agent with this id is visible to your organization.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Agent found.
     * @param agentId ID of the agent. (required)
     * @return Agent
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Agent get3(UUID agentId) throws RestClientException {
        return get3WithHttpInfo(agentId).getBody();
    }

    /**
     * Get an agent
     * Fetch one agent by its identifier — yours or a core one.  An id belonging to another organization answers &#x60;404&#x60;, the same as an id that does not exist: the two are deliberately indistinguishable. 
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - No agent with this id is visible to your organization.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Agent found.
     * @param agentId ID of the agent. (required)
     * @return ResponseEntity&lt;Agent&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Agent> get3WithHttpInfo(UUID agentId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'agentId' is set
        if (agentId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'agentId' when calling get3");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("agentId", agentId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

        ParameterizedTypeReference<Agent> localReturnType = new ParameterizedTypeReference<Agent>() {};
        return apiClient.invokeAPI("/v1/agent/{agentId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List agents
     * Paginate every agent your organization can query with: the platform&#39;s core agents merged with your own custom ones, **core first**, then by name.  There is no separate endpoint for the core catalogue — the merge is the point. Tell the two apart by &#x60;lock&#x60;: &#x60;true&#x60; is a platform agent you can read and use but not modify. A brand-new organization sees six of them, one per use case, and the single agent carrying &#x60;default: true&#x60; is the one a query that names no agent runs on. 
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Page of agents.
     * @param pageSize Number of items per page. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return AgentListResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public AgentListResponse list2(Integer pageSize, Integer pageIndex) throws RestClientException {
        return list2WithHttpInfo(pageSize, pageIndex).getBody();
    }

    /**
     * List agents
     * Paginate every agent your organization can query with: the platform&#39;s core agents merged with your own custom ones, **core first**, then by name.  There is no separate endpoint for the core catalogue — the merge is the point. Tell the two apart by &#x60;lock&#x60;: &#x60;true&#x60; is a platform agent you can read and use but not modify. A brand-new organization sees six of them, one per use case, and the single agent carrying &#x60;default: true&#x60; is the one a query that names no agent runs on. 
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Page of agents.
     * @param pageSize Number of items per page. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return ResponseEntity&lt;AgentListResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<AgentListResponse> list2WithHttpInfo(Integer pageSize, Integer pageIndex) throws RestClientException {
        Object localVarPostBody = null;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "pageSize", pageSize));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "pageIndex", pageIndex));
        

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

        ParameterizedTypeReference<AgentListResponse> localReturnType = new ParameterizedTypeReference<AgentListResponse>() {};
        return apiClient.invokeAPI("/v1/agent/", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Update an agent
     * Patch a custom agent. Fields absent from the body keep their current value.  Because \&quot;absent\&quot; already means \&quot;leave alone\&quot;, it cannot also mean \&quot;put this back to the platform default\&quot; — that is what &#x60;reset&#x60; is for. List the nullable fields you want un-set and they go back to tracking the platform value:  &#x60;&#x60;&#x60;json { \&quot;topK\&quot;: 12, \&quot;reset\&quot;: [\&quot;spirit\&quot;, \&quot;temperature\&quot;] } &#x60;&#x60;&#x60;  &#x60;reset&#x60; runs after the rest of the body, so a field named in both ends up cleared.  Renaming onto a name another of your agents holds, or one a platform agent carries, answers &#x60;409&#x60;. Sending this agent&#39;s own current name does not — an unchanged name is not a rename, so a client that echoes the whole object back is unaffected.  Core agents (&#x60;lock: true&#x60;) belong to the platform and every organization sees the same row — patching one answers &#x60;400&#x60;. 
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - No agent with this id is visible to your organization.
     * <p><b>400</b> - The agent is a core agent (&#x60;lock: true&#x60;), &#x60;reset&#x60; names a field that has no platform default, or a value fails validation.
     * <p><b>409</b> - The requested &#x60;name&#x60; is carried by another of your agents, or by a platform agent.
     * <p><b>200</b> - Agent updated.
     * @param agentId ID of the agent to update. (required)
     * @param agentUpdateRequest  (required)
     * @return Agent
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Agent update3(UUID agentId, AgentUpdateRequest agentUpdateRequest) throws RestClientException {
        return update3WithHttpInfo(agentId, agentUpdateRequest).getBody();
    }

    /**
     * Update an agent
     * Patch a custom agent. Fields absent from the body keep their current value.  Because \&quot;absent\&quot; already means \&quot;leave alone\&quot;, it cannot also mean \&quot;put this back to the platform default\&quot; — that is what &#x60;reset&#x60; is for. List the nullable fields you want un-set and they go back to tracking the platform value:  &#x60;&#x60;&#x60;json { \&quot;topK\&quot;: 12, \&quot;reset\&quot;: [\&quot;spirit\&quot;, \&quot;temperature\&quot;] } &#x60;&#x60;&#x60;  &#x60;reset&#x60; runs after the rest of the body, so a field named in both ends up cleared.  Renaming onto a name another of your agents holds, or one a platform agent carries, answers &#x60;409&#x60;. Sending this agent&#39;s own current name does not — an unchanged name is not a rename, so a client that echoes the whole object back is unaffected.  Core agents (&#x60;lock: true&#x60;) belong to the platform and every organization sees the same row — patching one answers &#x60;400&#x60;. 
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - No agent with this id is visible to your organization.
     * <p><b>400</b> - The agent is a core agent (&#x60;lock: true&#x60;), &#x60;reset&#x60; names a field that has no platform default, or a value fails validation.
     * <p><b>409</b> - The requested &#x60;name&#x60; is carried by another of your agents, or by a platform agent.
     * <p><b>200</b> - Agent updated.
     * @param agentId ID of the agent to update. (required)
     * @param agentUpdateRequest  (required)
     * @return ResponseEntity&lt;Agent&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Agent> update3WithHttpInfo(UUID agentId, AgentUpdateRequest agentUpdateRequest) throws RestClientException {
        Object localVarPostBody = agentUpdateRequest;
        
        // verify the required parameter 'agentId' is set
        if (agentId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'agentId' when calling update3");
        }
        
        // verify the required parameter 'agentUpdateRequest' is set
        if (agentUpdateRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'agentUpdateRequest' when calling update3");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("agentId", agentId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

        ParameterizedTypeReference<Agent> localReturnType = new ParameterizedTypeReference<Agent>() {};
        return apiClient.invokeAPI("/v1/agent/{agentId}", HttpMethod.PATCH, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }

    @Override
    public <T> ResponseEntity<T> invokeAPI(String url, HttpMethod method, Object request, ParameterizedTypeReference<T> returnType) throws RestClientException {
        String localVarPath = url.replace(apiClient.getBasePath(), "");
        Object localVarPostBody = request;

        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

        return apiClient.invokeAPI(localVarPath, method, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, returnType);
    }
}
