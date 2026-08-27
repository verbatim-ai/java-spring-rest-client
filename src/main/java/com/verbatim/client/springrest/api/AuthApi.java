package com.verbatim.client.springrest.api;

import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.BaseApi;

import com.verbatim.client.springrest.models.AccessTokenCreateRequest;
import com.verbatim.client.springrest.models.AccessTokenCreateResponse;
import com.verbatim.client.springrest.models.AckResponse;
import com.verbatim.client.springrest.models.Error;
import com.verbatim.client.springrest.models.WhoAmI;

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
public class AuthApi extends BaseApi {

    public AuthApi() {
        super(new ApiClient());
    }

    public AuthApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Create an access token
     * Generate a new short-lived opaque access token for the caller&#39;s organization. The token can be used as the &#x60;X-Access-Token&#x60; header on &#x60;/v1/&#x60; API calls. Default TTL is 3600 seconds (1 hour).By default, token inherit privileges over all the domains. To limit access, defined a list of scope, where each must be compliant with the regex (config|auth|session|doc|corpus|post|usage|agent):(create|read|update|delete)
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Access token created.
     * @param accessTokenCreateRequest  (required)
     * @return AccessTokenCreateResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public AccessTokenCreateResponse create2(AccessTokenCreateRequest accessTokenCreateRequest) throws RestClientException {
        return create2WithHttpInfo(accessTokenCreateRequest).getBody();
    }

    /**
     * Create an access token
     * Generate a new short-lived opaque access token for the caller&#39;s organization. The token can be used as the &#x60;X-Access-Token&#x60; header on &#x60;/v1/&#x60; API calls. Default TTL is 3600 seconds (1 hour).By default, token inherit privileges over all the domains. To limit access, defined a list of scope, where each must be compliant with the regex (config|auth|session|doc|corpus|post|usage|agent):(create|read|update|delete)
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Access token created.
     * @param accessTokenCreateRequest  (required)
     * @return ResponseEntity&lt;AccessTokenCreateResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<AccessTokenCreateResponse> create2WithHttpInfo(AccessTokenCreateRequest accessTokenCreateRequest) throws RestClientException {
        Object localVarPostBody = accessTokenCreateRequest;
        
        // verify the required parameter 'accessTokenCreateRequest' is set
        if (accessTokenCreateRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accessTokenCreateRequest' when calling create2");
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

        String[] localVarAuthNames = new String[] { "JWT" };

        ParameterizedTypeReference<AccessTokenCreateResponse> localReturnType = new ParameterizedTypeReference<AccessTokenCreateResponse>() {};
        return apiClient.invokeAPI("/v1/auth/access-token", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Revoke an access token
     * Permanently delete an access token. Any in-flight request using this token will fail immediately after revocation.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Token revoked.
     * @param token access token to revoke. (required)
     * @return AckResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public AckResponse revoke(String token) throws RestClientException {
        return revokeWithHttpInfo(token).getBody();
    }

    /**
     * Revoke an access token
     * Permanently delete an access token. Any in-flight request using this token will fail immediately after revocation.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Token revoked.
     * @param token access token to revoke. (required)
     * @return ResponseEntity&lt;AckResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<AckResponse> revokeWithHttpInfo(String token) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'token' is set
        if (token == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'token' when calling revoke");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("token", token);

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

        ParameterizedTypeReference<AckResponse> localReturnType = new ParameterizedTypeReference<AckResponse>() {};
        return apiClient.invokeAPI("/v1/auth/access-token/{token}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Who am I
     * Return the identity of the caller as resolved from the Bearer token: organization, user id, email and display name.  Typical use cases:  - Bootstrap a UI session after sign-in. - Verify that a token is still valid and which user it belongs to. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Identity of the authenticated user.
     * @return WhoAmI
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public WhoAmI whoami() throws RestClientException {
        return whoamiWithHttpInfo().getBody();
    }

    /**
     * Who am I
     * Return the identity of the caller as resolved from the Bearer token: organization, user id, email and display name.  Typical use cases:  - Bootstrap a UI session after sign-in. - Verify that a token is still valid and which user it belongs to. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Identity of the authenticated user.
     * @return ResponseEntity&lt;WhoAmI&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<WhoAmI> whoamiWithHttpInfo() throws RestClientException {
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

        ParameterizedTypeReference<WhoAmI> localReturnType = new ParameterizedTypeReference<WhoAmI>() {};
        return apiClient.invokeAPI("/v1/auth/whoami", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "JWT" };

        return apiClient.invokeAPI(localVarPath, method, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, returnType);
    }
}
