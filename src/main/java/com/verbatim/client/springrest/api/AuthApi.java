package com.verbatim.client.springrest.api;

import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.BaseApi;

import com.verbatim.client.springrest.models.AccessTokenCreateRequest;
import com.verbatim.client.springrest.models.AccessTokenCreateResponse;
import com.verbatim.client.springrest.models.AccessTokenListResponse;
import com.verbatim.client.springrest.models.AccessTokenScopesResponse;
import com.verbatim.client.springrest.models.AckResponse;
import com.verbatim.client.springrest.models.Error;
import java.util.UUID;
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
     * Mint a short-lived opaque access token for the caller&#39;s organization. Send it as the &#x60;X-Access-Token&#x60; header on &#x60;/v1/&#x60; API calls.  **The &#x60;token&#x60; value is only ever returned here.** Store it or hand it over now: the listing shows only its first characters, and no call returns it again.  - &#x60;scope&#x60; is mandatory and non-empty — a list of &#x60;DOMAIN:ACTION&#x60; entries such as   &#x60;corpus:read&#x60;. &#x60;GET /v1/auth/access-token/scopes&#x60; lists every valid entry. - &#x60;ttl&#x60; is in seconds: 3600 (1 hour) when omitted, at least 10, and no more than the   ceiling the platform sets (&#x60;app.access-token.max-ttl-seconds&#x60;, 86400 — 24 hours — by   default). A longer &#x60;ttl&#x60; is refused with a 400, not shortened. - &#x60;issuer&#x60; is a free label stored with the token and shown in the listing. - the token&#39;s &#x60;userId&#x60; and &#x60;email&#x60; are not inputs: they are the caller&#39;s own, and   what &#x60;GET /v1/auth/whoami&#x60; answers for the token. A token minted by a root user   is a root token.  Only reachable with a JWT: an access token cannot mint another. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - No JWT, or the call was made with an access token.
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>400</b> - Missing or invalid &#x60;scope&#x60;, or &#x60;ttl&#x60; below 10 seconds or above the platform ceiling.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>413</b> - The request body exceeds the size accepted by the endpoint.
     * <p><b>200</b> - Access token created.
     * @param accessTokenCreateRequest  (required)
     * @return AccessTokenCreateResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public AccessTokenCreateResponse create3(AccessTokenCreateRequest accessTokenCreateRequest) throws RestClientException {
        return create3WithHttpInfo(accessTokenCreateRequest).getBody();
    }

    /**
     * Create an access token
     * Mint a short-lived opaque access token for the caller&#39;s organization. Send it as the &#x60;X-Access-Token&#x60; header on &#x60;/v1/&#x60; API calls.  **The &#x60;token&#x60; value is only ever returned here.** Store it or hand it over now: the listing shows only its first characters, and no call returns it again.  - &#x60;scope&#x60; is mandatory and non-empty — a list of &#x60;DOMAIN:ACTION&#x60; entries such as   &#x60;corpus:read&#x60;. &#x60;GET /v1/auth/access-token/scopes&#x60; lists every valid entry. - &#x60;ttl&#x60; is in seconds: 3600 (1 hour) when omitted, at least 10, and no more than the   ceiling the platform sets (&#x60;app.access-token.max-ttl-seconds&#x60;, 86400 — 24 hours — by   default). A longer &#x60;ttl&#x60; is refused with a 400, not shortened. - &#x60;issuer&#x60; is a free label stored with the token and shown in the listing. - the token&#39;s &#x60;userId&#x60; and &#x60;email&#x60; are not inputs: they are the caller&#39;s own, and   what &#x60;GET /v1/auth/whoami&#x60; answers for the token. A token minted by a root user   is a root token.  Only reachable with a JWT: an access token cannot mint another. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - No JWT, or the call was made with an access token.
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>400</b> - Missing or invalid &#x60;scope&#x60;, or &#x60;ttl&#x60; below 10 seconds or above the platform ceiling.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>413</b> - The request body exceeds the size accepted by the endpoint.
     * <p><b>200</b> - Access token created.
     * @param accessTokenCreateRequest  (required)
     * @return ResponseEntity&lt;AccessTokenCreateResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<AccessTokenCreateResponse> create3WithHttpInfo(AccessTokenCreateRequest accessTokenCreateRequest) throws RestClientException {
        Object localVarPostBody = accessTokenCreateRequest;
        
        // verify the required parameter 'accessTokenCreateRequest' is set
        if (accessTokenCreateRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accessTokenCreateRequest' when calling create3");
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
        return apiClient.invokeAPI("/v1/auth/access-token/", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List access tokens
     * List the access tokens of the caller&#39;s organization, newest first, with every attribute stored for them — **except the token value**, which is cut down to its first characters followed by &#x60;...&#x60;. The full value is only returned by the create call.  Expired tokens stay listed (compare &#x60;expiresAt&#x60; with the current time) until they are revoked. Use an item&#39;s &#x60;id&#x60; with &#x60;DELETE /v1/auth/access-token/id/{id}&#x60; to revoke it.  Only reachable with a JWT. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - No JWT, or the call was made with an access token.
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>400</b> - &#x60;pageSize&#x60; below 1 or &#x60;pageIndex&#x60; below 0.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>413</b> - The request body exceeds the size accepted by the endpoint.
     * <p><b>200</b> - One page of access tokens.
     * @param pageSize Number of items per page. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return AccessTokenListResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public AccessTokenListResponse list3(Integer pageSize, Integer pageIndex) throws RestClientException {
        return list3WithHttpInfo(pageSize, pageIndex).getBody();
    }

    /**
     * List access tokens
     * List the access tokens of the caller&#39;s organization, newest first, with every attribute stored for them — **except the token value**, which is cut down to its first characters followed by &#x60;...&#x60;. The full value is only returned by the create call.  Expired tokens stay listed (compare &#x60;expiresAt&#x60; with the current time) until they are revoked. Use an item&#39;s &#x60;id&#x60; with &#x60;DELETE /v1/auth/access-token/id/{id}&#x60; to revoke it.  Only reachable with a JWT. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - No JWT, or the call was made with an access token.
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>400</b> - &#x60;pageSize&#x60; below 1 or &#x60;pageIndex&#x60; below 0.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>413</b> - The request body exceeds the size accepted by the endpoint.
     * <p><b>200</b> - One page of access tokens.
     * @param pageSize Number of items per page. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return ResponseEntity&lt;AccessTokenListResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<AccessTokenListResponse> list3WithHttpInfo(Integer pageSize, Integer pageIndex) throws RestClientException {
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

        String[] localVarAuthNames = new String[] { "JWT" };

        ParameterizedTypeReference<AccessTokenListResponse> localReturnType = new ParameterizedTypeReference<AccessTokenListResponse>() {};
        return apiClient.invokeAPI("/v1/auth/access-token/", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Revoke an access token by value
     * Permanently delete an access token, given its full value. Any request using this token fails immediately after revocation. An unknown value is acknowledged all the same. When you only have the listing, revoke by id instead. Only reachable with a JWT.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>413</b> - The request body exceeds the size accepted by the endpoint.
     * <p><b>200</b> - Token revoked.
     * @param token access token to revoke. (required)
     * @return AckResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public AckResponse revoke(String token) throws RestClientException {
        return revokeWithHttpInfo(token).getBody();
    }

    /**
     * Revoke an access token by value
     * Permanently delete an access token, given its full value. Any request using this token fails immediately after revocation. An unknown value is acknowledged all the same. When you only have the listing, revoke by id instead. Only reachable with a JWT.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>413</b> - The request body exceeds the size accepted by the endpoint.
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
     * Revoke an access token by id
     * Permanently delete one of the organization&#39;s access tokens, identified by the &#x60;id&#x60; the listing returns. Revocation is immediate: the next request carrying the token is refused.  An id that names no token of the caller&#39;s organization — unknown, already revoked, or another organization&#39;s — is a 404.  Only reachable with a JWT. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - No JWT, or the call was made with an access token.
     * <p><b>404</b> - No access token with this id in the caller&#39;s organization.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>413</b> - The request body exceeds the size accepted by the endpoint.
     * <p><b>200</b> - Token revoked.
     * @param id Id of the access token to revoke, as listed. (required)
     * @return AckResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public AckResponse revokeById(UUID id) throws RestClientException {
        return revokeByIdWithHttpInfo(id).getBody();
    }

    /**
     * Revoke an access token by id
     * Permanently delete one of the organization&#39;s access tokens, identified by the &#x60;id&#x60; the listing returns. Revocation is immediate: the next request carrying the token is refused.  An id that names no token of the caller&#39;s organization — unknown, already revoked, or another organization&#39;s — is a 404.  Only reachable with a JWT. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - No JWT, or the call was made with an access token.
     * <p><b>404</b> - No access token with this id in the caller&#39;s organization.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>413</b> - The request body exceeds the size accepted by the endpoint.
     * <p><b>200</b> - Token revoked.
     * @param id Id of the access token to revoke, as listed. (required)
     * @return ResponseEntity&lt;AckResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<AckResponse> revokeByIdWithHttpInfo(UUID id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling revokeById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);

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
        return apiClient.invokeAPI("/v1/auth/access-token/id/{id}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List the available scopes
     * Every scope an access token can be created with — the values accepted in the &#x60;scope&#x60; of &#x60;POST /v1/auth/access-token/&#x60;. Use it to build a scope picker rather than hard-coding the list.  A scope entry is &#x60;DOMAIN:ACTION&#x60;, and every domain combines with every action:  - &#x60;domains&#x60; — each domain with the API path it covers, what it gives access to, and its   scope entries, ready to group in a UI; - &#x60;actions&#x60; — each action with the HTTP methods it opens (&#x60;read&#x60; is &#x60;GET&#x60;, so running a   RAG query, &#x60;GET /v1/post/q&#x60;, needs &#x60;post:read&#x60;); - &#x60;scopes&#x60; — the flat list of every valid entry.  The catalog is the same for every organization and every caller. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - No credential, or an access token whose scope lacks &#x60;auth:read&#x60;.
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>413</b> - The request body exceeds the size accepted by the endpoint.
     * <p><b>200</b> - The scope catalog.
     * @return AccessTokenScopesResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public AccessTokenScopesResponse scopes() throws RestClientException {
        return scopesWithHttpInfo().getBody();
    }

    /**
     * List the available scopes
     * Every scope an access token can be created with — the values accepted in the &#x60;scope&#x60; of &#x60;POST /v1/auth/access-token/&#x60;. Use it to build a scope picker rather than hard-coding the list.  A scope entry is &#x60;DOMAIN:ACTION&#x60;, and every domain combines with every action:  - &#x60;domains&#x60; — each domain with the API path it covers, what it gives access to, and its   scope entries, ready to group in a UI; - &#x60;actions&#x60; — each action with the HTTP methods it opens (&#x60;read&#x60; is &#x60;GET&#x60;, so running a   RAG query, &#x60;GET /v1/post/q&#x60;, needs &#x60;post:read&#x60;); - &#x60;scopes&#x60; — the flat list of every valid entry.  The catalog is the same for every organization and every caller. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - No credential, or an access token whose scope lacks &#x60;auth:read&#x60;.
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>413</b> - The request body exceeds the size accepted by the endpoint.
     * <p><b>200</b> - The scope catalog.
     * @return ResponseEntity&lt;AccessTokenScopesResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<AccessTokenScopesResponse> scopesWithHttpInfo() throws RestClientException {
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

        ParameterizedTypeReference<AccessTokenScopesResponse> localReturnType = new ParameterizedTypeReference<AccessTokenScopesResponse>() {};
        return apiClient.invokeAPI("/v1/auth/access-token/scopes", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Who am I
     * Return the identity of the caller as resolved from the Bearer token: organization, user id, email and display name.  Typical use cases:  - Bootstrap a UI session after sign-in. - Verify that a token is still valid and which user it belongs to. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>413</b> - The request body exceeds the size accepted by the endpoint.
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
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>413</b> - The request body exceeds the size accepted by the endpoint.
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
