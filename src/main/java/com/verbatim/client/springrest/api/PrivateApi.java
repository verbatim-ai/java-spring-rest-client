package com.verbatim.client.springrest.api;

import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.BaseApi;

import com.verbatim.client.springrest.models.AckResponse;
import com.verbatim.client.springrest.models.Error;
import com.verbatim.client.springrest.models.Key;
import com.verbatim.client.springrest.models.KeyCreateRequest;
import com.verbatim.client.springrest.models.KeyCreateResponse;
import com.verbatim.client.springrest.models.KeyItemResponse;
import com.verbatim.client.springrest.models.KeyListResponse;
import com.verbatim.client.springrest.models.KeyUpdateRequest;
import com.verbatim.client.springrest.models.KeyUpdateResponse;
import java.util.UUID;
import com.verbatim.client.springrest.models.UserOnboardResponse;

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
public class PrivateApi extends BaseApi {

    public PrivateApi() {
        super(new ApiClient());
    }

    public PrivateApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Activate a key
     * Flip an &#x60;INACTIVE&#x60; key back to &#x60;ACTIVE&#x60;. Only keys that have been published (content set) will actually verify JWTs.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Key activated.
     * @param keyId ID of the key to activate. (required)
     * @return Key
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Key activate(UUID keyId) throws RestClientException {
        return activateWithHttpInfo(keyId).getBody();
    }

    /**
     * Activate a key
     * Flip an &#x60;INACTIVE&#x60; key back to &#x60;ACTIVE&#x60;. Only keys that have been published (content set) will actually verify JWTs.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Key activated.
     * @param keyId ID of the key to activate. (required)
     * @return ResponseEntity&lt;Key&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Key> activateWithHttpInfo(UUID keyId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'keyId' is set
        if (keyId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'keyId' when calling activate");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("keyId", keyId);

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

        ParameterizedTypeReference<Key> localReturnType = new ParameterizedTypeReference<Key>() {};
        return apiClient.invokeAPI("/_/v1/key/{keyId}/activate", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Register a new key slot
     * Create an empty key entry with a name and an optional description. The key starts in &#x60;INACTIVE&#x60; state with no content — call &#x60;POST /_/v1/key/{id}/publish&#x60; to upload the PEM and activate it.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Key created.
     * @param keyCreateRequest  (required)
     * @return KeyCreateResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public KeyCreateResponse create4(KeyCreateRequest keyCreateRequest) throws RestClientException {
        return create4WithHttpInfo(keyCreateRequest).getBody();
    }

    /**
     * Register a new key slot
     * Create an empty key entry with a name and an optional description. The key starts in &#x60;INACTIVE&#x60; state with no content — call &#x60;POST /_/v1/key/{id}/publish&#x60; to upload the PEM and activate it.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Key created.
     * @param keyCreateRequest  (required)
     * @return ResponseEntity&lt;KeyCreateResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<KeyCreateResponse> create4WithHttpInfo(KeyCreateRequest keyCreateRequest) throws RestClientException {
        Object localVarPostBody = keyCreateRequest;
        
        // verify the required parameter 'keyCreateRequest' is set
        if (keyCreateRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'keyCreateRequest' when calling create4");
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

        ParameterizedTypeReference<KeyCreateResponse> localReturnType = new ParameterizedTypeReference<KeyCreateResponse>() {};
        return apiClient.invokeAPI("/_/v1/key/", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Deactivate a key
     * Flip an &#x60;ACTIVE&#x60; key to &#x60;INACTIVE&#x60;. Tokens signed with this key will no longer be accepted until it is reactivated.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Key deactivated.
     * @param keyId ID of the key to deactivate. (required)
     * @return Key
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Key deactivate(UUID keyId) throws RestClientException {
        return deactivateWithHttpInfo(keyId).getBody();
    }

    /**
     * Deactivate a key
     * Flip an &#x60;ACTIVE&#x60; key to &#x60;INACTIVE&#x60;. Tokens signed with this key will no longer be accepted until it is reactivated.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Key deactivated.
     * @param keyId ID of the key to deactivate. (required)
     * @return ResponseEntity&lt;Key&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Key> deactivateWithHttpInfo(UUID keyId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'keyId' is set
        if (keyId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'keyId' when calling deactivate");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("keyId", keyId);

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

        ParameterizedTypeReference<Key> localReturnType = new ParameterizedTypeReference<Key>() {};
        return apiClient.invokeAPI("/_/v1/key/{keyId}/deactivate", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete a key
     * Soft-delete a key. JWT tokens signed with the deleted key will no longer be accepted.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Key deleted.
     * @param keyId ID of the key to delete. (required)
     * @return AckResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public AckResponse delete1(UUID keyId) throws RestClientException {
        return delete1WithHttpInfo(keyId).getBody();
    }

    /**
     * Delete a key
     * Soft-delete a key. JWT tokens signed with the deleted key will no longer be accepted.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Key deleted.
     * @param keyId ID of the key to delete. (required)
     * @return ResponseEntity&lt;AckResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<AckResponse> delete1WithHttpInfo(UUID keyId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'keyId' is set
        if (keyId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'keyId' when calling delete1");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("keyId", keyId);

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
        return apiClient.invokeAPI("/_/v1/key/{keyId}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get a key
     * Fetch a single key by its identifier. The raw RSA content is never returned.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Key found.
     * @param keyId ID of the key. (required)
     * @return KeyItemResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public KeyItemResponse get1(UUID keyId) throws RestClientException {
        return get1WithHttpInfo(keyId).getBody();
    }

    /**
     * Get a key
     * Fetch a single key by its identifier. The raw RSA content is never returned.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Key found.
     * @param keyId ID of the key. (required)
     * @return ResponseEntity&lt;KeyItemResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<KeyItemResponse> get1WithHttpInfo(UUID keyId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'keyId' is set
        if (keyId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'keyId' when calling get1");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("keyId", keyId);

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

        ParameterizedTypeReference<KeyItemResponse> localReturnType = new ParameterizedTypeReference<KeyItemResponse>() {};
        return apiClient.invokeAPI("/_/v1/key/{keyId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * 
     * 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - OK
     * @return List&lt;Map&lt;String, Object&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Map<String, Object>> getMigrationInfo() throws RestClientException {
        return getMigrationInfoWithHttpInfo().getBody();
    }

    /**
     * 
     * 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - OK
     * @return ResponseEntity&lt;List&lt;Map&lt;String, Object&gt;&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Map<String, Object>>> getMigrationInfoWithHttpInfo() throws RestClientException {
        Object localVarPostBody = null;
        

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

        ParameterizedTypeReference<List<Map<String, Object>>> localReturnType = new ParameterizedTypeReference<List<Map<String, Object>>>() {};
        return apiClient.invokeAPI("/_/v1/flyway/info", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List keys
     * Paginate keys belonging to the caller&#39;s organization. The raw RSA content is never returned.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Page of keys.
     * @param pageSize Number of items per page. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return KeyListResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public KeyListResponse list3(Integer pageSize, Integer pageIndex) throws RestClientException {
        return list3WithHttpInfo(pageSize, pageIndex).getBody();
    }

    /**
     * List keys
     * Paginate keys belonging to the caller&#39;s organization. The raw RSA content is never returned.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Page of keys.
     * @param pageSize Number of items per page. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return ResponseEntity&lt;KeyListResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<KeyListResponse> list3WithHttpInfo(Integer pageSize, Integer pageIndex) throws RestClientException {
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

        ParameterizedTypeReference<KeyListResponse> localReturnType = new ParameterizedTypeReference<KeyListResponse>() {};
        return apiClient.invokeAPI("/_/v1/key/", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Onboard the authenticated user
     * Bootstrap the caller into a Verbatim organization. Must be called with a Firebase JWT that does **not** yet carry an &#x60;oid&#x60; claim tokens already bound to an organization are rejected at the security layer (403). On success the user is provisioned, an organization is created (or joined), and the caller should refresh their Firebase token to pick up the new &#x60;oid&#x60; claim before calling any &#x60;/v1/_*&#x60; endpoint. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - User onboarded; organization and identity returned.
     * @return UserOnboardResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public UserOnboardResponse onboard() throws RestClientException {
        return onboardWithHttpInfo().getBody();
    }

    /**
     * Onboard the authenticated user
     * Bootstrap the caller into a Verbatim organization. Must be called with a Firebase JWT that does **not** yet carry an &#x60;oid&#x60; claim tokens already bound to an organization are rejected at the security layer (403). On success the user is provisioned, an organization is created (or joined), and the caller should refresh their Firebase token to pick up the new &#x60;oid&#x60; claim before calling any &#x60;/v1/_*&#x60; endpoint. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - User onboarded; organization and identity returned.
     * @return ResponseEntity&lt;UserOnboardResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<UserOnboardResponse> onboardWithHttpInfo() throws RestClientException {
        Object localVarPostBody = null;
        

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

        String[] localVarAuthNames = new String[] { "JWT" };

        ParameterizedTypeReference<UserOnboardResponse> localReturnType = new ParameterizedTypeReference<UserOnboardResponse>() {};
        return apiClient.invokeAPI("/_/v1/user/onboard", HttpMethod.PUT, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Publish PEM content for a key
     * Upload the PEM-encoded RSA 2048-bit public key for a previously created slot. The content is validated and stored, and the key transitions to &#x60;ACTIVE&#x60;. Content is write-once — to rotate, create a new key and delete the old one.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Key published and activated.
     * @param keyId ID of the key to publish. (required)
     * @param body  (required)
     * @return Key
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Key publish(UUID keyId, String body) throws RestClientException {
        return publishWithHttpInfo(keyId, body).getBody();
    }

    /**
     * Publish PEM content for a key
     * Upload the PEM-encoded RSA 2048-bit public key for a previously created slot. The content is validated and stored, and the key transitions to &#x60;ACTIVE&#x60;. Content is write-once — to rotate, create a new key and delete the old one.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Key published and activated.
     * @param keyId ID of the key to publish. (required)
     * @param body  (required)
     * @return ResponseEntity&lt;Key&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Key> publishWithHttpInfo(UUID keyId, String body) throws RestClientException {
        Object localVarPostBody = body;
        
        // verify the required parameter 'keyId' is set
        if (keyId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'keyId' when calling publish");
        }
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling publish");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("keyId", keyId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "text/plain"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

        ParameterizedTypeReference<Key> localReturnType = new ParameterizedTypeReference<Key>() {};
        return apiClient.invokeAPI("/_/v1/key/{keyId}/publish", HttpMethod.POST, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Update a key
     * Patch the name and/or description of an existing key. Raw RSA content, format, and state are not editable through this endpoint.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Key updated.
     * @param keyId ID of the key to update. (required)
     * @param keyUpdateRequest  (required)
     * @return KeyUpdateResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public KeyUpdateResponse update1(UUID keyId, KeyUpdateRequest keyUpdateRequest) throws RestClientException {
        return update1WithHttpInfo(keyId, keyUpdateRequest).getBody();
    }

    /**
     * Update a key
     * Patch the name and/or description of an existing key. Raw RSA content, format, and state are not editable through this endpoint.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Key updated.
     * @param keyId ID of the key to update. (required)
     * @param keyUpdateRequest  (required)
     * @return ResponseEntity&lt;KeyUpdateResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<KeyUpdateResponse> update1WithHttpInfo(UUID keyId, KeyUpdateRequest keyUpdateRequest) throws RestClientException {
        Object localVarPostBody = keyUpdateRequest;
        
        // verify the required parameter 'keyId' is set
        if (keyId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'keyId' when calling update1");
        }
        
        // verify the required parameter 'keyUpdateRequest' is set
        if (keyUpdateRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'keyUpdateRequest' when calling update1");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("keyId", keyId);

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

        ParameterizedTypeReference<KeyUpdateResponse> localReturnType = new ParameterizedTypeReference<KeyUpdateResponse>() {};
        return apiClient.invokeAPI("/_/v1/key/{keyId}", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
