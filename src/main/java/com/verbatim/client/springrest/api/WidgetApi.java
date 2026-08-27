package com.verbatim.client.springrest.api;

import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.BaseApi;

import com.verbatim.client.springrest.models.Error;
import java.util.UUID;
import com.verbatim.client.springrest.models.WidgetAttachmentResponse;
import com.verbatim.client.springrest.models.WidgetMessageResponse;
import com.verbatim.client.springrest.models.WidgetPostsResponse;
import com.verbatim.client.springrest.models.WidgetQueryResponse;
import com.verbatim.client.springrest.models.WidgetSessionRequest;
import com.verbatim.client.springrest.models.WidgetSessionRequestBody;
import com.verbatim.client.springrest.models.WidgetSessionResponse;
import com.verbatim.client.springrest.models.WidgetSessionResponseLegacy;

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
public class WidgetApi extends BaseApi {

    public WidgetApi() {
        super(new ApiClient());
    }

    public WidgetApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Get source attachments of a post
     * Returns every source document that the AI cited when generating a SYSTEM post. For each document the response includes its summary, metadata, and **presigned preview URLs** for every page that was actually retrieved (1-based index). Two sizes are provided per page — &#x60;previewSmallUrl&#x60; (SMALL) and &#x60;previewSmallLarge&#x60; (MEDIUM) — so the widget can render a thumbnail and a full-size lightbox view without additional round-trips. All presigned URLs share the same &#x60;previewExpirationDate&#x60;; refresh by calling this endpoint again after expiry. The post must belong to the organisation identified by the Access Token.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Attachments resolved with presigned preview URLs
     * @param postId Id of the post whose source attachments are fetched (required)
     * @return WidgetAttachmentResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     * @deprecated
     */
    @Deprecated
    public WidgetAttachmentResponse attachment(UUID postId) throws RestClientException {
        return attachmentWithHttpInfo(postId).getBody();
    }

    /**
     * Get source attachments of a post
     * Returns every source document that the AI cited when generating a SYSTEM post. For each document the response includes its summary, metadata, and **presigned preview URLs** for every page that was actually retrieved (1-based index). Two sizes are provided per page — &#x60;previewSmallUrl&#x60; (SMALL) and &#x60;previewSmallLarge&#x60; (MEDIUM) — so the widget can render a thumbnail and a full-size lightbox view without additional round-trips. All presigned URLs share the same &#x60;previewExpirationDate&#x60;; refresh by calling this endpoint again after expiry. The post must belong to the organisation identified by the Access Token.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Attachments resolved with presigned preview URLs
     * @param postId Id of the post whose source attachments are fetched (required)
     * @return ResponseEntity&lt;WidgetAttachmentResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     * @deprecated
     */
    @Deprecated
    public ResponseEntity<WidgetAttachmentResponse> attachmentWithHttpInfo(UUID postId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'postId' is set
        if (postId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'postId' when calling attachment");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("postId", postId);

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

        String[] localVarAuthNames = new String[] { "AccessToken" };

        ParameterizedTypeReference<WidgetAttachmentResponse> localReturnType = new ParameterizedTypeReference<WidgetAttachmentResponse>() {};
        return apiClient.invokeAPI("/v1/webhook/widget/attachment/{postId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
     * @param lang  (required)
     * @param cid  (required)
     * @param sid  (required)
     * @return WidgetSessionResponseLegacy
     * @throws RestClientException if an error occurs while attempting to invoke the API
     * @deprecated
     */
    @Deprecated
    public WidgetSessionResponseLegacy getSession(String lang, String cid, UUID sid) throws RestClientException {
        return getSessionWithHttpInfo(lang, cid, sid).getBody();
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
     * @param lang  (required)
     * @param cid  (required)
     * @param sid  (required)
     * @return ResponseEntity&lt;WidgetSessionResponseLegacy&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     * @deprecated
     */
    @Deprecated
    public ResponseEntity<WidgetSessionResponseLegacy> getSessionWithHttpInfo(String lang, String cid, UUID sid) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'lang' is set
        if (lang == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'lang' when calling getSession");
        }
        
        // verify the required parameter 'cid' is set
        if (cid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'cid' when calling getSession");
        }
        
        // verify the required parameter 'sid' is set
        if (sid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'sid' when calling getSession");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("lang", lang);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "cid", cid));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "sid", sid));
        

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<WidgetSessionResponseLegacy> localReturnType = new ParameterizedTypeReference<WidgetSessionResponseLegacy>() {};
        return apiClient.invokeAPI("/webhook/v1/widget/{lang}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Init a session
     * Init a new session with a context : name and a search context, defined by a list of Corpus UID
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - session is ready
     * @param widgetSessionRequest  (required)
     * @return WidgetSessionResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     * @deprecated
     */
    @Deprecated
    public WidgetSessionResponse init(WidgetSessionRequest widgetSessionRequest) throws RestClientException {
        return initWithHttpInfo(widgetSessionRequest).getBody();
    }

    /**
     * Init a session
     * Init a new session with a context : name and a search context, defined by a list of Corpus UID
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - session is ready
     * @param widgetSessionRequest  (required)
     * @return ResponseEntity&lt;WidgetSessionResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     * @deprecated
     */
    @Deprecated
    public ResponseEntity<WidgetSessionResponse> initWithHttpInfo(WidgetSessionRequest widgetSessionRequest) throws RestClientException {
        Object localVarPostBody = widgetSessionRequest;
        
        // verify the required parameter 'widgetSessionRequest' is set
        if (widgetSessionRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'widgetSessionRequest' when calling init");
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

        String[] localVarAuthNames = new String[] { "AccessToken" };

        ParameterizedTypeReference<WidgetSessionResponse> localReturnType = new ParameterizedTypeReference<WidgetSessionResponse>() {};
        return apiClient.invokeAPI("/v1/webhook/widget/init", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
     * @param lang  (required)
     * @param cid  (required)
     * @param sid  (required)
     * @param widgetSessionRequestBody  (required)
     * @return WidgetMessageResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     * @deprecated
     */
    @Deprecated
    public WidgetMessageResponse postMessage(String lang, String cid, UUID sid, WidgetSessionRequestBody widgetSessionRequestBody) throws RestClientException {
        return postMessageWithHttpInfo(lang, cid, sid, widgetSessionRequestBody).getBody();
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
     * @param lang  (required)
     * @param cid  (required)
     * @param sid  (required)
     * @param widgetSessionRequestBody  (required)
     * @return ResponseEntity&lt;WidgetMessageResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     * @deprecated
     */
    @Deprecated
    public ResponseEntity<WidgetMessageResponse> postMessageWithHttpInfo(String lang, String cid, UUID sid, WidgetSessionRequestBody widgetSessionRequestBody) throws RestClientException {
        Object localVarPostBody = widgetSessionRequestBody;
        
        // verify the required parameter 'lang' is set
        if (lang == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'lang' when calling postMessage");
        }
        
        // verify the required parameter 'cid' is set
        if (cid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'cid' when calling postMessage");
        }
        
        // verify the required parameter 'sid' is set
        if (sid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'sid' when calling postMessage");
        }
        
        // verify the required parameter 'widgetSessionRequestBody' is set
        if (widgetSessionRequestBody == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'widgetSessionRequestBody' when calling postMessage");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("lang", lang);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "cid", cid));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "sid", sid));
        

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<WidgetMessageResponse> localReturnType = new ParameterizedTypeReference<WidgetMessageResponse>() {};
        return apiClient.invokeAPI("/webhook/v1/widget/{lang}", HttpMethod.POST, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List posts in a session
     * Returns the full chronological history of a session — both user queries (&#x60;owner: USER&#x60;) and AI answers (&#x60;owner: SYSTEM&#x60;). Each item includes the message text, language, timestamp, and the number of source document chunks cited (&#x60;attachment&#x60; count). The session must belong to the organisation identified by the Access Token.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Post history retrieved
     * @param sessionId Id of the session where the posts are fetched (required)
     * @return WidgetPostsResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     * @deprecated
     */
    @Deprecated
    public WidgetPostsResponse posts(UUID sessionId) throws RestClientException {
        return postsWithHttpInfo(sessionId).getBody();
    }

    /**
     * List posts in a session
     * Returns the full chronological history of a session — both user queries (&#x60;owner: USER&#x60;) and AI answers (&#x60;owner: SYSTEM&#x60;). Each item includes the message text, language, timestamp, and the number of source document chunks cited (&#x60;attachment&#x60; count). The session must belong to the organisation identified by the Access Token.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Post history retrieved
     * @param sessionId Id of the session where the posts are fetched (required)
     * @return ResponseEntity&lt;WidgetPostsResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     * @deprecated
     */
    @Deprecated
    public ResponseEntity<WidgetPostsResponse> postsWithHttpInfo(UUID sessionId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'sessionId' is set
        if (sessionId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'sessionId' when calling posts");
        }
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "sessionId", sessionId));
        

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "AccessToken" };

        ParameterizedTypeReference<WidgetPostsResponse> localReturnType = new ParameterizedTypeReference<WidgetPostsResponse>() {};
        return apiClient.invokeAPI("/v1/webhook/widget/", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Post a query in a session
     * User query is posted in the session. AI backend system answer to this query
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Answer is ready
     * @param sessionId Id of the session where the query is fired (required)
     * @param query The user&#39;s query (required)
     * @param lang ISO language code use by the model  (optional, default to fr)
     * @return WidgetQueryResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     * @deprecated
     */
    @Deprecated
    public WidgetQueryResponse query(UUID sessionId, String query, String lang) throws RestClientException {
        return queryWithHttpInfo(sessionId, query, lang).getBody();
    }

    /**
     * Post a query in a session
     * User query is posted in the session. AI backend system answer to this query
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Answer is ready
     * @param sessionId Id of the session where the query is fired (required)
     * @param query The user&#39;s query (required)
     * @param lang ISO language code use by the model  (optional, default to fr)
     * @return ResponseEntity&lt;WidgetQueryResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     * @deprecated
     */
    @Deprecated
    public ResponseEntity<WidgetQueryResponse> queryWithHttpInfo(UUID sessionId, String query, String lang) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'sessionId' is set
        if (sessionId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'sessionId' when calling query");
        }
        
        // verify the required parameter 'query' is set
        if (query == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'query' when calling query");
        }
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "sessionId", sessionId));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "query", query));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "lang", lang));
        

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "AccessToken" };

        ParameterizedTypeReference<WidgetQueryResponse> localReturnType = new ParameterizedTypeReference<WidgetQueryResponse>() {};
        return apiClient.invokeAPI("/v1/webhook/widget/q", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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

        String[] localVarAuthNames = new String[] { "AccessToken" };

        return apiClient.invokeAPI(localVarPath, method, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, returnType);
    }
}
