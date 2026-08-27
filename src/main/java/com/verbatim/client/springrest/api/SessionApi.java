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
     * Create a session
     * Open a new conversation session against one or more corpora. The session is attached to the user carried by the caller&#39;s JWT. The model, system prompt, temperature and thinking flag are locked at creation time and apply to every post in the session.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
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
     * Open a new conversation session against one or more corpora. The session is attached to the user carried by the caller&#39;s JWT. The model, system prompt, temperature and thinking flag are locked at creation time and apply to every post in the session.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
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
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Session and posts deleted.
     * @param sessionId ID of the session to delete. (required)
     * @return AckResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public AckResponse delete2(UUID sessionId) throws RestClientException {
        return delete2WithHttpInfo(sessionId).getBody();
    }

    /**
     * Delete a session
     * Soft-delete a session. **Cascades** to every post in the session (also soft-deleted). Documents and embeddings are **not** affected.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Session and posts deleted.
     * @param sessionId ID of the session to delete. (required)
     * @return ResponseEntity&lt;AckResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<AckResponse> delete2WithHttpInfo(UUID sessionId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'sessionId' is set
        if (sessionId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'sessionId' when calling delete2");
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
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Session found.
     * @param sessionId ID of the session. (required)
     * @return Session
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Session get2(UUID sessionId) throws RestClientException {
        return get2WithHttpInfo(sessionId).getBody();
    }

    /**
     * Get a session
     * Fetch a session&#39;s metadata (user, corpora, model, system prompt, parameters). Use &#x60;GET /v1/post&#x60; to retrieve its posts.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Session found.
     * @param sessionId ID of the session. (required)
     * @return ResponseEntity&lt;Session&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Session> get2WithHttpInfo(UUID sessionId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'sessionId' is set
        if (sessionId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'sessionId' when calling get2");
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
     * List sessions attached to a corpus
     * Paginate the sessions opened against a corpus, newest first. The corpus must belong to the caller&#39;s organization.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Page of sessions.
     * @param corpusId ID of the corpus. (required)
     * @param pageSize Number of items per page. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return SessionListResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public SessionListResponse list4(UUID corpusId, Integer pageSize, Integer pageIndex) throws RestClientException {
        return list4WithHttpInfo(corpusId, pageSize, pageIndex).getBody();
    }

    /**
     * List sessions attached to a corpus
     * Paginate the sessions opened against a corpus, newest first. The corpus must belong to the caller&#39;s organization.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Page of sessions.
     * @param corpusId ID of the corpus. (required)
     * @param pageSize Number of items per page. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return ResponseEntity&lt;SessionListResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<SessionListResponse> list4WithHttpInfo(UUID corpusId, Integer pageSize, Integer pageIndex) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'corpusId' is set
        if (corpusId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'corpusId' when calling list4");
        }
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "corpusId", corpusId));
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
        return apiClient.invokeAPI("/v1/session/byCorpus", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List sessions matching a metadata fragment
     * Paginate sessions whose metadata JSONB *contains* the provided fragment (PostgreSQL &#x60;@&gt;&#x60; operator). Results are scoped to the caller&#39;s organization. Filtering on a single key/value pair: pass &#x60;key&#x60; and &#x60;value&#x60;. For richer filtering (nested JSON, multiple keys) pass a raw JSON object as &#x60;json&#x60;.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Page of sessions.
     * @param key Metadata key to filter on. Pair with &#x60;value&#x60;. (optional)
     * @param value Metadata value matching &#x60;key&#x60;. (optional)
     * @param json Raw JSON object used as the containment filter. Wins over &#x60;key&#x60;/&#x60;value&#x60; when set. (optional)
     * @param pageSize Number of items per page. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return SessionListResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public SessionListResponse listByMetadata(String key, String value, String json, Integer pageSize, Integer pageIndex) throws RestClientException {
        return listByMetadataWithHttpInfo(key, value, json, pageSize, pageIndex).getBody();
    }

    /**
     * List sessions matching a metadata fragment
     * Paginate sessions whose metadata JSONB *contains* the provided fragment (PostgreSQL &#x60;@&gt;&#x60; operator). Results are scoped to the caller&#39;s organization. Filtering on a single key/value pair: pass &#x60;key&#x60; and &#x60;value&#x60;. For richer filtering (nested JSON, multiple keys) pass a raw JSON object as &#x60;json&#x60;.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Page of sessions.
     * @param key Metadata key to filter on. Pair with &#x60;value&#x60;. (optional)
     * @param value Metadata value matching &#x60;key&#x60;. (optional)
     * @param json Raw JSON object used as the containment filter. Wins over &#x60;key&#x60;/&#x60;value&#x60; when set. (optional)
     * @param pageSize Number of items per page. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return ResponseEntity&lt;SessionListResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<SessionListResponse> listByMetadataWithHttpInfo(String key, String value, String json, Integer pageSize, Integer pageIndex) throws RestClientException {
        Object localVarPostBody = null;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

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
        return apiClient.invokeAPI("/v1/session/byMetadata", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List every session in the caller&#39;s organization
     * Paginate every session attached to at least one corpus of the caller&#39;s organization, newest first. The organization is resolved from the JWT, no parameter is needed.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Page of sessions.
     * @param pageSize Number of items per page. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return SessionListResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public SessionListResponse listByOrganization(Integer pageSize, Integer pageIndex) throws RestClientException {
        return listByOrganizationWithHttpInfo(pageSize, pageIndex).getBody();
    }

    /**
     * List every session in the caller&#39;s organization
     * Paginate every session attached to at least one corpus of the caller&#39;s organization, newest first. The organization is resolved from the JWT, no parameter is needed.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Page of sessions.
     * @param pageSize Number of items per page. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return ResponseEntity&lt;SessionListResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<SessionListResponse> listByOrganizationWithHttpInfo(Integer pageSize, Integer pageIndex) throws RestClientException {
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
        return apiClient.invokeAPI("/v1/session/byOrganization", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List sessions owned by a user
     * Paginate the sessions opened by a given user identifier, newest first. Results are scoped to the caller&#39;s organization at the SQL level: only sessions attached to at least one corpus of the caller&#39;s org are returned, so a user identifier shared across tenants never leaks rows. Pass &#x60;corpusId&#x60; to further restrict results to sessions bound to that specific corpus.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Page of sessions.
     * @param userId Identifier of the user (free-form string). (required)
     * @param corpusId Optional corpus filter. When provided, only sessions bound to this corpus are returned. (optional)
     * @param pageSize Number of items per page. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return SessionListResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public SessionListResponse listByUser(String userId, UUID corpusId, Integer pageSize, Integer pageIndex) throws RestClientException {
        return listByUserWithHttpInfo(userId, corpusId, pageSize, pageIndex).getBody();
    }

    /**
     * List sessions owned by a user
     * Paginate the sessions opened by a given user identifier, newest first. Results are scoped to the caller&#39;s organization at the SQL level: only sessions attached to at least one corpus of the caller&#39;s org are returned, so a user identifier shared across tenants never leaks rows. Pass &#x60;corpusId&#x60; to further restrict results to sessions bound to that specific corpus.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Page of sessions.
     * @param userId Identifier of the user (free-form string). (required)
     * @param corpusId Optional corpus filter. When provided, only sessions bound to this corpus are returned. (optional)
     * @param pageSize Number of items per page. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return ResponseEntity&lt;SessionListResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<SessionListResponse> listByUserWithHttpInfo(String userId, UUID corpusId, Integer pageSize, Integer pageIndex) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'userId' when calling listByUser");
        }
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "userId", userId));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "corpusId", corpusId));
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
        return apiClient.invokeAPI("/v1/session/byUser", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Update a session
     * Patch one or more session attributes. Only the fields provided in the request body are updated; omitted fields keep their current value. Returns the full updated session.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Session updated.
     * @param sessionId ID of the session to update. (required)
     * @param sessionUpdateRequest  (required)
     * @return Session
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Session update2(UUID sessionId, SessionUpdateRequest sessionUpdateRequest) throws RestClientException {
        return update2WithHttpInfo(sessionId, sessionUpdateRequest).getBody();
    }

    /**
     * Update a session
     * Patch one or more session attributes. Only the fields provided in the request body are updated; omitted fields keep their current value. Returns the full updated session.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Session updated.
     * @param sessionId ID of the session to update. (required)
     * @param sessionUpdateRequest  (required)
     * @return ResponseEntity&lt;Session&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Session> update2WithHttpInfo(UUID sessionId, SessionUpdateRequest sessionUpdateRequest) throws RestClientException {
        Object localVarPostBody = sessionUpdateRequest;
        
        // verify the required parameter 'sessionId' is set
        if (sessionId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'sessionId' when calling update2");
        }
        
        // verify the required parameter 'sessionUpdateRequest' is set
        if (sessionUpdateRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'sessionUpdateRequest' when calling update2");
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
