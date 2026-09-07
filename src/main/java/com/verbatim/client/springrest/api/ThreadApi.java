package com.verbatim.client.springrest.api;

import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.BaseApi;

import com.verbatim.client.springrest.models.AckResponse;
import com.verbatim.client.springrest.models.Error;
import com.verbatim.client.springrest.models.SessionCreateRequest;
import com.verbatim.client.springrest.models.Thread;
import com.verbatim.client.springrest.models.ThreadCreateResponse;
import com.verbatim.client.springrest.models.ThreadListResponse;
import com.verbatim.client.springrest.models.ThreadUpdateRequest;
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
public class ThreadApi extends BaseApi {

    public ThreadApi() {
        super(new ApiClient());
    }

    public ThreadApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * List threads
     * Paginate every thread of the caller&#39;s organization, newest first.  The organization is resolved from the JWT, so there is nothing to pass and no way to ask for another tenant&#39;s threads. A thread belongs to an organization as soon as one of its corpora does.  The ordering is closed by the thread id, so walking &#x60;pageIndex&#x60; never shows the same thread twice nor skips one when several were opened in the same millisecond. &#x60;total&#x60; counts every thread in the organization, not just those returned here.  To narrow the result — by user, by corpus, by metadata, or by any combination of the three — use &#x60;GET /v1/thread/q&#x60;, which takes the same paging parameters. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Page of threads.
     * @param pageSize Number of items per page, 1-100. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return ThreadListResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ThreadListResponse callList(Integer pageSize, Integer pageIndex) throws RestClientException {
        return callListWithHttpInfo(pageSize, pageIndex).getBody();
    }

    /**
     * List threads
     * Paginate every thread of the caller&#39;s organization, newest first.  The organization is resolved from the JWT, so there is nothing to pass and no way to ask for another tenant&#39;s threads. A thread belongs to an organization as soon as one of its corpora does.  The ordering is closed by the thread id, so walking &#x60;pageIndex&#x60; never shows the same thread twice nor skips one when several were opened in the same millisecond. &#x60;total&#x60; counts every thread in the organization, not just those returned here.  To narrow the result — by user, by corpus, by metadata, or by any combination of the three — use &#x60;GET /v1/thread/q&#x60;, which takes the same paging parameters. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Page of threads.
     * @param pageSize Number of items per page, 1-100. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return ResponseEntity&lt;ThreadListResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ThreadListResponse> callListWithHttpInfo(Integer pageSize, Integer pageIndex) throws RestClientException {
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

        ParameterizedTypeReference<ThreadListResponse> localReturnType = new ParameterizedTypeReference<ThreadListResponse>() {};
        return apiClient.invokeAPI("/v1/session/", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Create a thread
     * Open a new conversation thread against one or more corpora. The thread is attached to the user carried by the caller&#39;s JWT. How its queries are answered is not decided here: the agent named on each query decides, so a thread carries the corpora, the owner and whatever metadata you attach to it.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Thread created.
     * @param sessionCreateRequest  (required)
     * @return ThreadCreateResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ThreadCreateResponse create(SessionCreateRequest sessionCreateRequest) throws RestClientException {
        return createWithHttpInfo(sessionCreateRequest).getBody();
    }

    /**
     * Create a thread
     * Open a new conversation thread against one or more corpora. The thread is attached to the user carried by the caller&#39;s JWT. How its queries are answered is not decided here: the agent named on each query decides, so a thread carries the corpora, the owner and whatever metadata you attach to it.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Thread created.
     * @param sessionCreateRequest  (required)
     * @return ResponseEntity&lt;ThreadCreateResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ThreadCreateResponse> createWithHttpInfo(SessionCreateRequest sessionCreateRequest) throws RestClientException {
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

        ParameterizedTypeReference<ThreadCreateResponse> localReturnType = new ParameterizedTypeReference<ThreadCreateResponse>() {};
        return apiClient.invokeAPI("/v1/session/", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Create a thread
     * Open a new conversation thread against one or more corpora. The thread is attached to the user carried by the caller&#39;s JWT. How its queries are answered is not decided here: the agent named on each query decides, so a thread carries the corpora, the owner and whatever metadata you attach to it.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Thread created.
     * @param sessionCreateRequest  (required)
     * @return ThreadCreateResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ThreadCreateResponse create1(SessionCreateRequest sessionCreateRequest) throws RestClientException {
        return create1WithHttpInfo(sessionCreateRequest).getBody();
    }

    /**
     * Create a thread
     * Open a new conversation thread against one or more corpora. The thread is attached to the user carried by the caller&#39;s JWT. How its queries are answered is not decided here: the agent named on each query decides, so a thread carries the corpora, the owner and whatever metadata you attach to it.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Thread created.
     * @param sessionCreateRequest  (required)
     * @return ResponseEntity&lt;ThreadCreateResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ThreadCreateResponse> create1WithHttpInfo(SessionCreateRequest sessionCreateRequest) throws RestClientException {
        Object localVarPostBody = sessionCreateRequest;
        
        // verify the required parameter 'sessionCreateRequest' is set
        if (sessionCreateRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'sessionCreateRequest' when calling create1");
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

        ParameterizedTypeReference<ThreadCreateResponse> localReturnType = new ParameterizedTypeReference<ThreadCreateResponse>() {};
        return apiClient.invokeAPI("/v1/thread/", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete a thread
     * Soft-delete a thread. **Cascades** to every post in the thread (also soft-deleted). Documents and embeddings are **not** affected.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Thread and posts deleted.
     * @param threadId ID of the thread to delete. (required)
     * @return AckResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public AckResponse delete(UUID threadId) throws RestClientException {
        return deleteWithHttpInfo(threadId).getBody();
    }

    /**
     * Delete a thread
     * Soft-delete a thread. **Cascades** to every post in the thread (also soft-deleted). Documents and embeddings are **not** affected.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Thread and posts deleted.
     * @param threadId ID of the thread to delete. (required)
     * @return ResponseEntity&lt;AckResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<AckResponse> deleteWithHttpInfo(UUID threadId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'threadId' is set
        if (threadId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'threadId' when calling delete");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("threadId", threadId);

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
        return apiClient.invokeAPI("/v1/session/{threadId}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete a thread
     * Soft-delete a thread. **Cascades** to every post in the thread (also soft-deleted). Documents and embeddings are **not** affected.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Thread and posts deleted.
     * @param threadId ID of the thread to delete. (required)
     * @return AckResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public AckResponse delete1(UUID threadId) throws RestClientException {
        return delete1WithHttpInfo(threadId).getBody();
    }

    /**
     * Delete a thread
     * Soft-delete a thread. **Cascades** to every post in the thread (also soft-deleted). Documents and embeddings are **not** affected.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Thread and posts deleted.
     * @param threadId ID of the thread to delete. (required)
     * @return ResponseEntity&lt;AckResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<AckResponse> delete1WithHttpInfo(UUID threadId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'threadId' is set
        if (threadId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'threadId' when calling delete1");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("threadId", threadId);

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
        return apiClient.invokeAPI("/v1/thread/{threadId}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get a thread
     * Fetch a thread&#39;s metadata (user, corpora, model, system prompt, parameters). Use &#x60;GET /v1/post&#x60; to retrieve its posts.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Thread found.
     * @param threadId ID of the thread. (required)
     * @return Thread
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Thread get(UUID threadId) throws RestClientException {
        return getWithHttpInfo(threadId).getBody();
    }

    /**
     * Get a thread
     * Fetch a thread&#39;s metadata (user, corpora, model, system prompt, parameters). Use &#x60;GET /v1/post&#x60; to retrieve its posts.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Thread found.
     * @param threadId ID of the thread. (required)
     * @return ResponseEntity&lt;Thread&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Thread> getWithHttpInfo(UUID threadId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'threadId' is set
        if (threadId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'threadId' when calling get");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("threadId", threadId);

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

        ParameterizedTypeReference<Thread> localReturnType = new ParameterizedTypeReference<Thread>() {};
        return apiClient.invokeAPI("/v1/session/{threadId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get a thread
     * Fetch a thread&#39;s metadata (user, corpora, model, system prompt, parameters). Use &#x60;GET /v1/post&#x60; to retrieve its posts.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Thread found.
     * @param threadId ID of the thread. (required)
     * @return Thread
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Thread get1(UUID threadId) throws RestClientException {
        return get1WithHttpInfo(threadId).getBody();
    }

    /**
     * Get a thread
     * Fetch a thread&#39;s metadata (user, corpora, model, system prompt, parameters). Use &#x60;GET /v1/post&#x60; to retrieve its posts.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Thread found.
     * @param threadId ID of the thread. (required)
     * @return ResponseEntity&lt;Thread&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Thread> get1WithHttpInfo(UUID threadId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'threadId' is set
        if (threadId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'threadId' when calling get1");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("threadId", threadId);

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

        ParameterizedTypeReference<Thread> localReturnType = new ParameterizedTypeReference<Thread>() {};
        return apiClient.invokeAPI("/v1/thread/{threadId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List threads
     * Paginate every thread of the caller&#39;s organization, newest first.  The organization is resolved from the JWT, so there is nothing to pass and no way to ask for another tenant&#39;s threads. A thread belongs to an organization as soon as one of its corpora does.  The ordering is closed by the thread id, so walking &#x60;pageIndex&#x60; never shows the same thread twice nor skips one when several were opened in the same millisecond. &#x60;total&#x60; counts every thread in the organization, not just those returned here.  To narrow the result — by user, by corpus, by metadata, or by any combination of the three — use &#x60;GET /v1/thread/q&#x60;, which takes the same paging parameters. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Page of threads.
     * @param pageSize Number of items per page, 1-100. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return ThreadListResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ThreadListResponse list1(Integer pageSize, Integer pageIndex) throws RestClientException {
        return list1WithHttpInfo(pageSize, pageIndex).getBody();
    }

    /**
     * List threads
     * Paginate every thread of the caller&#39;s organization, newest first.  The organization is resolved from the JWT, so there is nothing to pass and no way to ask for another tenant&#39;s threads. A thread belongs to an organization as soon as one of its corpora does.  The ordering is closed by the thread id, so walking &#x60;pageIndex&#x60; never shows the same thread twice nor skips one when several were opened in the same millisecond. &#x60;total&#x60; counts every thread in the organization, not just those returned here.  To narrow the result — by user, by corpus, by metadata, or by any combination of the three — use &#x60;GET /v1/thread/q&#x60;, which takes the same paging parameters. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Page of threads.
     * @param pageSize Number of items per page, 1-100. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return ResponseEntity&lt;ThreadListResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ThreadListResponse> list1WithHttpInfo(Integer pageSize, Integer pageIndex) throws RestClientException {
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

        ParameterizedTypeReference<ThreadListResponse> localReturnType = new ParameterizedTypeReference<ThreadListResponse>() {};
        return apiClient.invokeAPI("/v1/thread/", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Search threads
     * Find threads of the caller&#39;s organization by owner, corpus and metadata.  Every filter is optional and they **narrow together**: a request carrying none of them returns the whole organization — the same answer as &#x60;GET /v1/thread/&#x60; — and one carrying several returns only the threads matching all of them. That is what this endpoint adds over the &#x60;by…&#x60; listings it replaces, which each answer one fixed combination.  The organization is never a parameter. It comes from the JWT and is always applied, so no combination of filters reaches another tenant&#39;s threads.  ### Owner — &#x60;userId&#x60;  Exact match on the identifier carried by the JWT when the thread was opened. Sent empty (&#x60;&amp;userId&#x3D;&#x60;) it is treated as absent rather than as a match on the empty string.  ### Corpus — &#x60;corpusId&#x60;  Keeps threads bound to that corpus. A thread may be bound to several, and it matches as soon as one of them is the requested one. The corpus must belong to the caller&#39;s organization.  ### Metadata — &#x60;key&#x60;/&#x60;value&#x60;, or &#x60;json&#x60;  Matches threads whose metadata **contains** the fragment (PostgreSQL&#39;s &#x60;@&gt;&#x60; operator), extra keys on the thread being fine. Pass &#x60;key&#x60; and &#x60;value&#x60; for a single pair — they go together, one without the other is a &#x60;400&#x60; — or &#x60;json&#x60; for a raw object when the filter is nested or has several keys. &#x60;json&#x60; wins when both are supplied.  ### Ordering and paging  Newest first, closed by the thread id, so walking &#x60;pageIndex&#x60; never shows the same thread twice nor skips one. &#x60;total&#x60; counts every match across all pages.  ### Examples  * &#x60;?userId&#x3D;user_42&#x60; — every thread that user opened, across corpora * &#x60;?corpusId&#x3D;…&#x60; — every thread opened against one corpus, whoever opened it * &#x60;?userId&#x3D;user_42&amp;corpusId&#x3D;…&#x60; — both, which &#x60;GET /v1/thread/byUser&#x60; also did * &#x60;?userId&#x3D;user_42&amp;key&#x3D;customer_id&amp;value&#x3D;42&#x60; — the combination none of the   &#x60;by…&#x60; endpoints could express * &#x60;?json&#x3D;{\&quot;channel\&quot;:{\&quot;kind\&quot;:\&quot;web\&quot;}}&#x60; — a nested metadata fragment 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - A metadata filter is malformed, or a paging parameter is out of bounds.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Page of matching threads.
     * @param userId Exact identifier of the user who opened the thread. Blank or omitted, the owner is not filtered. (optional)
     * @param corpusId Keep threads bound to this corpus. Must belong to the caller&#39;s organization. (optional)
     * @param key Metadata key to filter on. Goes together with &#x60;value&#x60;. (optional)
     * @param value Metadata value matching &#x60;key&#x60;. (optional)
     * @param json Raw JSON object used as the containment filter. Wins over &#x60;key&#x60;/&#x60;value&#x60; when set. (optional)
     * @param pageSize Number of items per page, 1-100. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return ThreadListResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ThreadListResponse search(String userId, UUID corpusId, String key, String value, String json, Integer pageSize, Integer pageIndex) throws RestClientException {
        return searchWithHttpInfo(userId, corpusId, key, value, json, pageSize, pageIndex).getBody();
    }

    /**
     * Search threads
     * Find threads of the caller&#39;s organization by owner, corpus and metadata.  Every filter is optional and they **narrow together**: a request carrying none of them returns the whole organization — the same answer as &#x60;GET /v1/thread/&#x60; — and one carrying several returns only the threads matching all of them. That is what this endpoint adds over the &#x60;by…&#x60; listings it replaces, which each answer one fixed combination.  The organization is never a parameter. It comes from the JWT and is always applied, so no combination of filters reaches another tenant&#39;s threads.  ### Owner — &#x60;userId&#x60;  Exact match on the identifier carried by the JWT when the thread was opened. Sent empty (&#x60;&amp;userId&#x3D;&#x60;) it is treated as absent rather than as a match on the empty string.  ### Corpus — &#x60;corpusId&#x60;  Keeps threads bound to that corpus. A thread may be bound to several, and it matches as soon as one of them is the requested one. The corpus must belong to the caller&#39;s organization.  ### Metadata — &#x60;key&#x60;/&#x60;value&#x60;, or &#x60;json&#x60;  Matches threads whose metadata **contains** the fragment (PostgreSQL&#39;s &#x60;@&gt;&#x60; operator), extra keys on the thread being fine. Pass &#x60;key&#x60; and &#x60;value&#x60; for a single pair — they go together, one without the other is a &#x60;400&#x60; — or &#x60;json&#x60; for a raw object when the filter is nested or has several keys. &#x60;json&#x60; wins when both are supplied.  ### Ordering and paging  Newest first, closed by the thread id, so walking &#x60;pageIndex&#x60; never shows the same thread twice nor skips one. &#x60;total&#x60; counts every match across all pages.  ### Examples  * &#x60;?userId&#x3D;user_42&#x60; — every thread that user opened, across corpora * &#x60;?corpusId&#x3D;…&#x60; — every thread opened against one corpus, whoever opened it * &#x60;?userId&#x3D;user_42&amp;corpusId&#x3D;…&#x60; — both, which &#x60;GET /v1/thread/byUser&#x60; also did * &#x60;?userId&#x3D;user_42&amp;key&#x3D;customer_id&amp;value&#x3D;42&#x60; — the combination none of the   &#x60;by…&#x60; endpoints could express * &#x60;?json&#x3D;{\&quot;channel\&quot;:{\&quot;kind\&quot;:\&quot;web\&quot;}}&#x60; — a nested metadata fragment 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - A metadata filter is malformed, or a paging parameter is out of bounds.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Page of matching threads.
     * @param userId Exact identifier of the user who opened the thread. Blank or omitted, the owner is not filtered. (optional)
     * @param corpusId Keep threads bound to this corpus. Must belong to the caller&#39;s organization. (optional)
     * @param key Metadata key to filter on. Goes together with &#x60;value&#x60;. (optional)
     * @param value Metadata value matching &#x60;key&#x60;. (optional)
     * @param json Raw JSON object used as the containment filter. Wins over &#x60;key&#x60;/&#x60;value&#x60; when set. (optional)
     * @param pageSize Number of items per page, 1-100. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return ResponseEntity&lt;ThreadListResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ThreadListResponse> searchWithHttpInfo(String userId, UUID corpusId, String key, String value, String json, Integer pageSize, Integer pageIndex) throws RestClientException {
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

        ParameterizedTypeReference<ThreadListResponse> localReturnType = new ParameterizedTypeReference<ThreadListResponse>() {};
        return apiClient.invokeAPI("/v1/thread/q", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Search threads
     * Find threads of the caller&#39;s organization by owner, corpus and metadata.  Every filter is optional and they **narrow together**: a request carrying none of them returns the whole organization — the same answer as &#x60;GET /v1/thread/&#x60; — and one carrying several returns only the threads matching all of them. That is what this endpoint adds over the &#x60;by…&#x60; listings it replaces, which each answer one fixed combination.  The organization is never a parameter. It comes from the JWT and is always applied, so no combination of filters reaches another tenant&#39;s threads.  ### Owner — &#x60;userId&#x60;  Exact match on the identifier carried by the JWT when the thread was opened. Sent empty (&#x60;&amp;userId&#x3D;&#x60;) it is treated as absent rather than as a match on the empty string.  ### Corpus — &#x60;corpusId&#x60;  Keeps threads bound to that corpus. A thread may be bound to several, and it matches as soon as one of them is the requested one. The corpus must belong to the caller&#39;s organization.  ### Metadata — &#x60;key&#x60;/&#x60;value&#x60;, or &#x60;json&#x60;  Matches threads whose metadata **contains** the fragment (PostgreSQL&#39;s &#x60;@&gt;&#x60; operator), extra keys on the thread being fine. Pass &#x60;key&#x60; and &#x60;value&#x60; for a single pair — they go together, one without the other is a &#x60;400&#x60; — or &#x60;json&#x60; for a raw object when the filter is nested or has several keys. &#x60;json&#x60; wins when both are supplied.  ### Ordering and paging  Newest first, closed by the thread id, so walking &#x60;pageIndex&#x60; never shows the same thread twice nor skips one. &#x60;total&#x60; counts every match across all pages.  ### Examples  * &#x60;?userId&#x3D;user_42&#x60; — every thread that user opened, across corpora * &#x60;?corpusId&#x3D;…&#x60; — every thread opened against one corpus, whoever opened it * &#x60;?userId&#x3D;user_42&amp;corpusId&#x3D;…&#x60; — both, which &#x60;GET /v1/thread/byUser&#x60; also did * &#x60;?userId&#x3D;user_42&amp;key&#x3D;customer_id&amp;value&#x3D;42&#x60; — the combination none of the   &#x60;by…&#x60; endpoints could express * &#x60;?json&#x3D;{\&quot;channel\&quot;:{\&quot;kind\&quot;:\&quot;web\&quot;}}&#x60; — a nested metadata fragment 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - A metadata filter is malformed, or a paging parameter is out of bounds.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Page of matching threads.
     * @param userId Exact identifier of the user who opened the thread. Blank or omitted, the owner is not filtered. (optional)
     * @param corpusId Keep threads bound to this corpus. Must belong to the caller&#39;s organization. (optional)
     * @param key Metadata key to filter on. Goes together with &#x60;value&#x60;. (optional)
     * @param value Metadata value matching &#x60;key&#x60;. (optional)
     * @param json Raw JSON object used as the containment filter. Wins over &#x60;key&#x60;/&#x60;value&#x60; when set. (optional)
     * @param pageSize Number of items per page, 1-100. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return ThreadListResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ThreadListResponse search1(String userId, UUID corpusId, String key, String value, String json, Integer pageSize, Integer pageIndex) throws RestClientException {
        return search1WithHttpInfo(userId, corpusId, key, value, json, pageSize, pageIndex).getBody();
    }

    /**
     * Search threads
     * Find threads of the caller&#39;s organization by owner, corpus and metadata.  Every filter is optional and they **narrow together**: a request carrying none of them returns the whole organization — the same answer as &#x60;GET /v1/thread/&#x60; — and one carrying several returns only the threads matching all of them. That is what this endpoint adds over the &#x60;by…&#x60; listings it replaces, which each answer one fixed combination.  The organization is never a parameter. It comes from the JWT and is always applied, so no combination of filters reaches another tenant&#39;s threads.  ### Owner — &#x60;userId&#x60;  Exact match on the identifier carried by the JWT when the thread was opened. Sent empty (&#x60;&amp;userId&#x3D;&#x60;) it is treated as absent rather than as a match on the empty string.  ### Corpus — &#x60;corpusId&#x60;  Keeps threads bound to that corpus. A thread may be bound to several, and it matches as soon as one of them is the requested one. The corpus must belong to the caller&#39;s organization.  ### Metadata — &#x60;key&#x60;/&#x60;value&#x60;, or &#x60;json&#x60;  Matches threads whose metadata **contains** the fragment (PostgreSQL&#39;s &#x60;@&gt;&#x60; operator), extra keys on the thread being fine. Pass &#x60;key&#x60; and &#x60;value&#x60; for a single pair — they go together, one without the other is a &#x60;400&#x60; — or &#x60;json&#x60; for a raw object when the filter is nested or has several keys. &#x60;json&#x60; wins when both are supplied.  ### Ordering and paging  Newest first, closed by the thread id, so walking &#x60;pageIndex&#x60; never shows the same thread twice nor skips one. &#x60;total&#x60; counts every match across all pages.  ### Examples  * &#x60;?userId&#x3D;user_42&#x60; — every thread that user opened, across corpora * &#x60;?corpusId&#x3D;…&#x60; — every thread opened against one corpus, whoever opened it * &#x60;?userId&#x3D;user_42&amp;corpusId&#x3D;…&#x60; — both, which &#x60;GET /v1/thread/byUser&#x60; also did * &#x60;?userId&#x3D;user_42&amp;key&#x3D;customer_id&amp;value&#x3D;42&#x60; — the combination none of the   &#x60;by…&#x60; endpoints could express * &#x60;?json&#x3D;{\&quot;channel\&quot;:{\&quot;kind\&quot;:\&quot;web\&quot;}}&#x60; — a nested metadata fragment 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - A metadata filter is malformed, or a paging parameter is out of bounds.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Page of matching threads.
     * @param userId Exact identifier of the user who opened the thread. Blank or omitted, the owner is not filtered. (optional)
     * @param corpusId Keep threads bound to this corpus. Must belong to the caller&#39;s organization. (optional)
     * @param key Metadata key to filter on. Goes together with &#x60;value&#x60;. (optional)
     * @param value Metadata value matching &#x60;key&#x60;. (optional)
     * @param json Raw JSON object used as the containment filter. Wins over &#x60;key&#x60;/&#x60;value&#x60; when set. (optional)
     * @param pageSize Number of items per page, 1-100. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return ResponseEntity&lt;ThreadListResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ThreadListResponse> search1WithHttpInfo(String userId, UUID corpusId, String key, String value, String json, Integer pageSize, Integer pageIndex) throws RestClientException {
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

        ParameterizedTypeReference<ThreadListResponse> localReturnType = new ParameterizedTypeReference<ThreadListResponse>() {};
        return apiClient.invokeAPI("/v1/session/q", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Update a thread
     * Patch one or more thread attributes. Only the fields provided in the request body are updated; omitted fields keep their current value. Returns the full updated thread.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Thread updated.
     * @param threadId ID of the thread to update. (required)
     * @param threadUpdateRequest  (required)
     * @return Thread
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Thread update(UUID threadId, ThreadUpdateRequest threadUpdateRequest) throws RestClientException {
        return updateWithHttpInfo(threadId, threadUpdateRequest).getBody();
    }

    /**
     * Update a thread
     * Patch one or more thread attributes. Only the fields provided in the request body are updated; omitted fields keep their current value. Returns the full updated thread.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Thread updated.
     * @param threadId ID of the thread to update. (required)
     * @param threadUpdateRequest  (required)
     * @return ResponseEntity&lt;Thread&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Thread> updateWithHttpInfo(UUID threadId, ThreadUpdateRequest threadUpdateRequest) throws RestClientException {
        Object localVarPostBody = threadUpdateRequest;
        
        // verify the required parameter 'threadId' is set
        if (threadId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'threadId' when calling update");
        }
        
        // verify the required parameter 'threadUpdateRequest' is set
        if (threadUpdateRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'threadUpdateRequest' when calling update");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("threadId", threadId);

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

        ParameterizedTypeReference<Thread> localReturnType = new ParameterizedTypeReference<Thread>() {};
        return apiClient.invokeAPI("/v1/session/{threadId}", HttpMethod.PATCH, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Update a thread
     * Patch one or more thread attributes. Only the fields provided in the request body are updated; omitted fields keep their current value. Returns the full updated thread.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Thread updated.
     * @param threadId ID of the thread to update. (required)
     * @param threadUpdateRequest  (required)
     * @return Thread
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Thread update1(UUID threadId, ThreadUpdateRequest threadUpdateRequest) throws RestClientException {
        return update1WithHttpInfo(threadId, threadUpdateRequest).getBody();
    }

    /**
     * Update a thread
     * Patch one or more thread attributes. Only the fields provided in the request body are updated; omitted fields keep their current value. Returns the full updated thread.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Thread updated.
     * @param threadId ID of the thread to update. (required)
     * @param threadUpdateRequest  (required)
     * @return ResponseEntity&lt;Thread&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Thread> update1WithHttpInfo(UUID threadId, ThreadUpdateRequest threadUpdateRequest) throws RestClientException {
        Object localVarPostBody = threadUpdateRequest;
        
        // verify the required parameter 'threadId' is set
        if (threadId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'threadId' when calling update1");
        }
        
        // verify the required parameter 'threadUpdateRequest' is set
        if (threadUpdateRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'threadUpdateRequest' when calling update1");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("threadId", threadId);

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

        ParameterizedTypeReference<Thread> localReturnType = new ParameterizedTypeReference<Thread>() {};
        return apiClient.invokeAPI("/v1/thread/{threadId}", HttpMethod.PATCH, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
