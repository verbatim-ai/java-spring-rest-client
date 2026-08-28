package com.verbatim.client.springrest.api;

import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.BaseApi;

import com.verbatim.client.springrest.models.AckResponse;
import com.verbatim.client.springrest.models.Error;
import com.verbatim.client.springrest.models.Session;
import com.verbatim.client.springrest.models.SessionCreateRequest;
import com.verbatim.client.springrest.models.SessionCreateResponse;
import com.verbatim.client.springrest.models.SessionListResponse;
import com.verbatim.client.springrest.models.SessionUpdateRequest;
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
public class SessionApi extends BaseApi {

    public SessionApi() {
        super(new ApiClient());
    }

    public SessionApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * List sessions
     * Paginate every session of the caller&#39;s organization, newest first.  The organization is resolved from the JWT, so there is nothing to pass and no way to ask for another tenant&#39;s sessions. A session belongs to an organization as soon as one of its corpora does.  The ordering is closed by the session id, so walking &#x60;pageIndex&#x60; never shows the same session twice nor skips one when several were opened in the same millisecond. &#x60;total&#x60; counts every session in the organization, not just those returned here.  To narrow the result — by user, by corpus, by metadata, or by any combination of the three — use &#x60;GET /v1/session/q&#x60;, which takes the same paging parameters. 
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Page of sessions.
     * @param pageSize Number of items per page, 1-100. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return SessionListResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public SessionListResponse callList(Integer pageSize, Integer pageIndex) throws RestClientException {
        return callListWithHttpInfo(pageSize, pageIndex).getBody();
    }

    /**
     * List sessions
     * Paginate every session of the caller&#39;s organization, newest first.  The organization is resolved from the JWT, so there is nothing to pass and no way to ask for another tenant&#39;s sessions. A session belongs to an organization as soon as one of its corpora does.  The ordering is closed by the session id, so walking &#x60;pageIndex&#x60; never shows the same session twice nor skips one when several were opened in the same millisecond. &#x60;total&#x60; counts every session in the organization, not just those returned here.  To narrow the result — by user, by corpus, by metadata, or by any combination of the three — use &#x60;GET /v1/session/q&#x60;, which takes the same paging parameters. 
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Page of sessions.
     * @param pageSize Number of items per page, 1-100. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return ResponseEntity&lt;SessionListResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<SessionListResponse> callListWithHttpInfo(Integer pageSize, Integer pageIndex) throws RestClientException {
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

        ParameterizedTypeReference<SessionListResponse> localReturnType = new ParameterizedTypeReference<SessionListResponse>() {};
        return apiClient.invokeAPI("/v1/session/", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Create a session
     * Open a new conversation session against one or more corpora. The session is attached to the user carried by the caller&#39;s JWT. How its queries are answered is not decided here: the agent named on each query decides, so a session carries the corpora, the owner and whatever metadata you attach to it.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Session created.
     * @param sessionCreateRequest  (required)
     * @return SessionCreateResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public SessionCreateResponse create(SessionCreateRequest sessionCreateRequest) throws RestClientException {
        return createWithHttpInfo(sessionCreateRequest).getBody();
    }

    /**
     * Create a session
     * Open a new conversation session against one or more corpora. The session is attached to the user carried by the caller&#39;s JWT. How its queries are answered is not decided here: the agent named on each query decides, so a session carries the corpora, the owner and whatever metadata you attach to it.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Session created.
     * @param sessionCreateRequest  (required)
     * @return ResponseEntity&lt;SessionCreateResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<SessionCreateResponse> createWithHttpInfo(SessionCreateRequest sessionCreateRequest) throws RestClientException {
        Object localVarPostBody = sessionCreateRequest;
        
        // verify the required parameter 'sessionCreateRequest' is set
        if (sessionCreateRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'sessionCreateRequest' when calling create");
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

        ParameterizedTypeReference<SessionCreateResponse> localReturnType = new ParameterizedTypeReference<SessionCreateResponse>() {};
        return apiClient.invokeAPI("/v1/session/", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete a session
     * Soft-delete a session. **Cascades** to every post in the session (also soft-deleted). Documents and embeddings are **not** affected.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Session and posts deleted.
     * @param sessionId ID of the session to delete. (required)
     * @return AckResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public AckResponse delete(UUID sessionId) throws RestClientException {
        return deleteWithHttpInfo(sessionId).getBody();
    }

    /**
     * Delete a session
     * Soft-delete a session. **Cascades** to every post in the session (also soft-deleted). Documents and embeddings are **not** affected.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Session and posts deleted.
     * @param sessionId ID of the session to delete. (required)
     * @return ResponseEntity&lt;AckResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<AckResponse> deleteWithHttpInfo(UUID sessionId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'sessionId' is set
        if (sessionId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'sessionId' when calling delete");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("sessionId", sessionId);

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
        return apiClient.invokeAPI("/v1/session/{sessionId}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get a session
     * Fetch a session&#39;s metadata (user, corpora, model, system prompt, parameters). Use &#x60;GET /v1/post&#x60; to retrieve its posts.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Session found.
     * @param sessionId ID of the session. (required)
     * @return Session
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Session get(UUID sessionId) throws RestClientException {
        return getWithHttpInfo(sessionId).getBody();
    }

    /**
     * Get a session
     * Fetch a session&#39;s metadata (user, corpora, model, system prompt, parameters). Use &#x60;GET /v1/post&#x60; to retrieve its posts.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Session found.
     * @param sessionId ID of the session. (required)
     * @return ResponseEntity&lt;Session&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Session> getWithHttpInfo(UUID sessionId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'sessionId' is set
        if (sessionId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'sessionId' when calling get");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("sessionId", sessionId);

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

        ParameterizedTypeReference<Session> localReturnType = new ParameterizedTypeReference<Session>() {};
        return apiClient.invokeAPI("/v1/session/{sessionId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Search sessions
     * Find sessions of the caller&#39;s organization by owner, corpus and metadata.  Every filter is optional and they **narrow together**: a request carrying none of them returns the whole organization — the same answer as &#x60;GET /v1/session/&#x60; — and one carrying several returns only the sessions matching all of them. That is what this endpoint adds over the &#x60;by…&#x60; listings it replaces, which each answer one fixed combination.  The organization is never a parameter. It comes from the JWT and is always applied, so no combination of filters reaches another tenant&#39;s sessions.  ### Owner — &#x60;userId&#x60;  Exact match on the identifier carried by the JWT when the session was opened. Sent empty (&#x60;&amp;userId&#x3D;&#x60;) it is treated as absent rather than as a match on the empty string.  ### Corpus — &#x60;corpusId&#x60;  Keeps sessions bound to that corpus. A session may be bound to several, and it matches as soon as one of them is the requested one. The corpus must belong to the caller&#39;s organization.  ### Metadata — &#x60;key&#x60;/&#x60;value&#x60;, or &#x60;json&#x60;  Matches sessions whose metadata **contains** the fragment (PostgreSQL&#39;s &#x60;@&gt;&#x60; operator), extra keys on the session being fine. Pass &#x60;key&#x60; and &#x60;value&#x60; for a single pair — they go together, one without the other is a &#x60;400&#x60; — or &#x60;json&#x60; for a raw object when the filter is nested or has several keys. &#x60;json&#x60; wins when both are supplied.  ### Ordering and paging  Newest first, closed by the session id, so walking &#x60;pageIndex&#x60; never shows the same session twice nor skips one. &#x60;total&#x60; counts every match across all pages.  ### Examples  * &#x60;?userId&#x3D;user_42&#x60; — every session that user opened, across corpora * &#x60;?corpusId&#x3D;…&#x60; — every session opened against one corpus, whoever opened it * &#x60;?userId&#x3D;user_42&amp;corpusId&#x3D;…&#x60; — both, which &#x60;GET /v1/session/byUser&#x60; also did * &#x60;?userId&#x3D;user_42&amp;key&#x3D;customer_id&amp;value&#x3D;42&#x60; — the combination none of the   &#x60;by…&#x60; endpoints could express * &#x60;?json&#x3D;{\&quot;channel\&quot;:{\&quot;kind\&quot;:\&quot;web\&quot;}}&#x60; — a nested metadata fragment 
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - A metadata filter is malformed, or a paging parameter is out of bounds.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Page of matching sessions.
     * @param userId Exact identifier of the user who opened the session. Blank or omitted, the owner is not filtered. (optional)
     * @param corpusId Keep sessions bound to this corpus. Must belong to the caller&#39;s organization. (optional)
     * @param key Metadata key to filter on. Goes together with &#x60;value&#x60;. (optional)
     * @param value Metadata value matching &#x60;key&#x60;. (optional)
     * @param json Raw JSON object used as the containment filter. Wins over &#x60;key&#x60;/&#x60;value&#x60; when set. (optional)
     * @param pageSize Number of items per page, 1-100. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return SessionListResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public SessionListResponse search(String userId, UUID corpusId, String key, String value, String json, Integer pageSize, Integer pageIndex) throws RestClientException {
        return searchWithHttpInfo(userId, corpusId, key, value, json, pageSize, pageIndex).getBody();
    }

    /**
     * Search sessions
     * Find sessions of the caller&#39;s organization by owner, corpus and metadata.  Every filter is optional and they **narrow together**: a request carrying none of them returns the whole organization — the same answer as &#x60;GET /v1/session/&#x60; — and one carrying several returns only the sessions matching all of them. That is what this endpoint adds over the &#x60;by…&#x60; listings it replaces, which each answer one fixed combination.  The organization is never a parameter. It comes from the JWT and is always applied, so no combination of filters reaches another tenant&#39;s sessions.  ### Owner — &#x60;userId&#x60;  Exact match on the identifier carried by the JWT when the session was opened. Sent empty (&#x60;&amp;userId&#x3D;&#x60;) it is treated as absent rather than as a match on the empty string.  ### Corpus — &#x60;corpusId&#x60;  Keeps sessions bound to that corpus. A session may be bound to several, and it matches as soon as one of them is the requested one. The corpus must belong to the caller&#39;s organization.  ### Metadata — &#x60;key&#x60;/&#x60;value&#x60;, or &#x60;json&#x60;  Matches sessions whose metadata **contains** the fragment (PostgreSQL&#39;s &#x60;@&gt;&#x60; operator), extra keys on the session being fine. Pass &#x60;key&#x60; and &#x60;value&#x60; for a single pair — they go together, one without the other is a &#x60;400&#x60; — or &#x60;json&#x60; for a raw object when the filter is nested or has several keys. &#x60;json&#x60; wins when both are supplied.  ### Ordering and paging  Newest first, closed by the session id, so walking &#x60;pageIndex&#x60; never shows the same session twice nor skips one. &#x60;total&#x60; counts every match across all pages.  ### Examples  * &#x60;?userId&#x3D;user_42&#x60; — every session that user opened, across corpora * &#x60;?corpusId&#x3D;…&#x60; — every session opened against one corpus, whoever opened it * &#x60;?userId&#x3D;user_42&amp;corpusId&#x3D;…&#x60; — both, which &#x60;GET /v1/session/byUser&#x60; also did * &#x60;?userId&#x3D;user_42&amp;key&#x3D;customer_id&amp;value&#x3D;42&#x60; — the combination none of the   &#x60;by…&#x60; endpoints could express * &#x60;?json&#x3D;{\&quot;channel\&quot;:{\&quot;kind\&quot;:\&quot;web\&quot;}}&#x60; — a nested metadata fragment 
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - A metadata filter is malformed, or a paging parameter is out of bounds.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Page of matching sessions.
     * @param userId Exact identifier of the user who opened the session. Blank or omitted, the owner is not filtered. (optional)
     * @param corpusId Keep sessions bound to this corpus. Must belong to the caller&#39;s organization. (optional)
     * @param key Metadata key to filter on. Goes together with &#x60;value&#x60;. (optional)
     * @param value Metadata value matching &#x60;key&#x60;. (optional)
     * @param json Raw JSON object used as the containment filter. Wins over &#x60;key&#x60;/&#x60;value&#x60; when set. (optional)
     * @param pageSize Number of items per page, 1-100. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return ResponseEntity&lt;SessionListResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<SessionListResponse> searchWithHttpInfo(String userId, UUID corpusId, String key, String value, String json, Integer pageSize, Integer pageIndex) throws RestClientException {
        Object localVarPostBody = null;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "userId", userId));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "corpusId", corpusId));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "key", key));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "value", value));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "json", json));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "pageSize", pageSize));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "pageIndex", pageIndex));
        

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

        ParameterizedTypeReference<SessionListResponse> localReturnType = new ParameterizedTypeReference<SessionListResponse>() {};
        return apiClient.invokeAPI("/v1/session/q", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Update a session
     * Patch one or more session attributes. Only the fields provided in the request body are updated; omitted fields keep their current value. Returns the full updated session.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Session updated.
     * @param sessionId ID of the session to update. (required)
     * @param sessionUpdateRequest  (required)
     * @return Session
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Session update(UUID sessionId, SessionUpdateRequest sessionUpdateRequest) throws RestClientException {
        return updateWithHttpInfo(sessionId, sessionUpdateRequest).getBody();
    }

    /**
     * Update a session
     * Patch one or more session attributes. Only the fields provided in the request body are updated; omitted fields keep their current value. Returns the full updated session.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Session updated.
     * @param sessionId ID of the session to update. (required)
     * @param sessionUpdateRequest  (required)
     * @return ResponseEntity&lt;Session&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Session> updateWithHttpInfo(UUID sessionId, SessionUpdateRequest sessionUpdateRequest) throws RestClientException {
        Object localVarPostBody = sessionUpdateRequest;
        
        // verify the required parameter 'sessionId' is set
        if (sessionId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'sessionId' when calling update");
        }
        
        // verify the required parameter 'sessionUpdateRequest' is set
        if (sessionUpdateRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'sessionUpdateRequest' when calling update");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("sessionId", sessionId);

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

        ParameterizedTypeReference<Session> localReturnType = new ParameterizedTypeReference<Session>() {};
        return apiClient.invokeAPI("/v1/session/{sessionId}", HttpMethod.PATCH, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
