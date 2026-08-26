package com.verbatim.client.springrest.api;

import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.BaseApi;

import com.verbatim.client.springrest.models.AckResponse;
import com.verbatim.client.springrest.models.CorpusCreateRequest;
import com.verbatim.client.springrest.models.CorpusCreateResponse;
import com.verbatim.client.springrest.models.CorpusItemResponse;
import com.verbatim.client.springrest.models.CorpusListResponse;
import com.verbatim.client.springrest.models.CorpusUpdateRequest;
import com.verbatim.client.springrest.models.CorpusUpdateResponse;
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
public class CorpusApi extends BaseApi {

    public CorpusApi() {
        super(new ApiClient());
    }

    public CorpusApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * List corpora
     * Paginate corpora belonging to an organization.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>200</b> - Page of corpora.
     * @param pageSize Number of items per page. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return CorpusListResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CorpusListResponse callList(Integer pageSize, Integer pageIndex) throws RestClientException {
        return callListWithHttpInfo(pageSize, pageIndex).getBody();
    }

    /**
     * List corpora
     * Paginate corpora belonging to an organization.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>200</b> - Page of corpora.
     * @param pageSize Number of items per page. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return ResponseEntity&lt;CorpusListResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CorpusListResponse> callListWithHttpInfo(Integer pageSize, Integer pageIndex) throws RestClientException {
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

        ParameterizedTypeReference<CorpusListResponse> localReturnType = new ParameterizedTypeReference<CorpusListResponse>() {};
        return apiClient.invokeAPI("/v1/corpus/", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Create a corpus
     * Create a new corpus inside an organization. The embedding model and summary LLM are locked at creation time and used for every document ingested afterwards.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>200</b> - Corpus created.
     * @param corpusCreateRequest  (required)
     * @return CorpusCreateResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CorpusCreateResponse create1(CorpusCreateRequest corpusCreateRequest) throws RestClientException {
        return create1WithHttpInfo(corpusCreateRequest).getBody();
    }

    /**
     * Create a corpus
     * Create a new corpus inside an organization. The embedding model and summary LLM are locked at creation time and used for every document ingested afterwards.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>200</b> - Corpus created.
     * @param corpusCreateRequest  (required)
     * @return ResponseEntity&lt;CorpusCreateResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CorpusCreateResponse> create1WithHttpInfo(CorpusCreateRequest corpusCreateRequest) throws RestClientException {
        Object localVarPostBody = corpusCreateRequest;
        
        // verify the required parameter 'corpusCreateRequest' is set
        if (corpusCreateRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'corpusCreateRequest' when calling create1");
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

        ParameterizedTypeReference<CorpusCreateResponse> localReturnType = new ParameterizedTypeReference<CorpusCreateResponse>() {};
        return apiClient.invokeAPI("/v1/corpus/", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete a corpus
     * Permanently delete a corpus. **Cascades** to every session, post, document and embedding owned by this corpus. This operation cannot be undone.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>200</b> - Corpus and dependencies deleted.
     * @param corpusId ID of the corpus to delete. (required)
     * @return AckResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public AckResponse delete2(UUID corpusId) throws RestClientException {
        return delete2WithHttpInfo(corpusId).getBody();
    }

    /**
     * Delete a corpus
     * Permanently delete a corpus. **Cascades** to every session, post, document and embedding owned by this corpus. This operation cannot be undone.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>200</b> - Corpus and dependencies deleted.
     * @param corpusId ID of the corpus to delete. (required)
     * @return ResponseEntity&lt;AckResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<AckResponse> delete2WithHttpInfo(UUID corpusId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'corpusId' is set
        if (corpusId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'corpusId' when calling delete2");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("corpusId", corpusId);

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
        return apiClient.invokeAPI("/v1/corpus/{corpusId}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get a corpus
     * Fetch a corpus by its identifier.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>200</b> - Corpus found.
     * @param corpusId ID of the corpus. (required)
     * @return CorpusItemResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CorpusItemResponse get2(UUID corpusId) throws RestClientException {
        return get2WithHttpInfo(corpusId).getBody();
    }

    /**
     * Get a corpus
     * Fetch a corpus by its identifier.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>200</b> - Corpus found.
     * @param corpusId ID of the corpus. (required)
     * @return ResponseEntity&lt;CorpusItemResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CorpusItemResponse> get2WithHttpInfo(UUID corpusId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'corpusId' is set
        if (corpusId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'corpusId' when calling get2");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("corpusId", corpusId);

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

        ParameterizedTypeReference<CorpusItemResponse> localReturnType = new ParameterizedTypeReference<CorpusItemResponse>() {};
        return apiClient.invokeAPI("/v1/corpus/{corpusId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Update a corpus
     * Patch the name, description or metadata of an existing corpus. Only the fields present in the request body are updated; omitted fields keep their current value.  &#x60;metadata&#x60; **replaces** the stored map when provided — merge client-side if you want to preserve existing keys.  Changing models does **not** re-process already-ingested documents. 
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>200</b> - Corpus updated.
     * @param corpusId ID of the corpus to update. (required)
     * @param corpusUpdateRequest  (required)
     * @return CorpusUpdateResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CorpusUpdateResponse update2(UUID corpusId, CorpusUpdateRequest corpusUpdateRequest) throws RestClientException {
        return update2WithHttpInfo(corpusId, corpusUpdateRequest).getBody();
    }

    /**
     * Update a corpus
     * Patch the name, description or metadata of an existing corpus. Only the fields present in the request body are updated; omitted fields keep their current value.  &#x60;metadata&#x60; **replaces** the stored map when provided — merge client-side if you want to preserve existing keys.  Changing models does **not** re-process already-ingested documents. 
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>200</b> - Corpus updated.
     * @param corpusId ID of the corpus to update. (required)
     * @param corpusUpdateRequest  (required)
     * @return ResponseEntity&lt;CorpusUpdateResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CorpusUpdateResponse> update2WithHttpInfo(UUID corpusId, CorpusUpdateRequest corpusUpdateRequest) throws RestClientException {
        Object localVarPostBody = corpusUpdateRequest;
        
        // verify the required parameter 'corpusId' is set
        if (corpusId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'corpusId' when calling update2");
        }
        
        // verify the required parameter 'corpusUpdateRequest' is set
        if (corpusUpdateRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'corpusUpdateRequest' when calling update2");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("corpusId", corpusId);

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

        ParameterizedTypeReference<CorpusUpdateResponse> localReturnType = new ParameterizedTypeReference<CorpusUpdateResponse>() {};
        return apiClient.invokeAPI("/v1/corpus/{corpusId}", HttpMethod.PATCH, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
