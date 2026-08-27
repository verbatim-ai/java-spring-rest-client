package com.verbatim.client.springrest.api;

import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.BaseApi;

import com.verbatim.client.springrest.models.AckResponse;
import com.verbatim.client.springrest.models.DocumentDownloadUrl;
import com.verbatim.client.springrest.models.DocumentPreviewUrls;
import com.verbatim.client.springrest.models.Error;
import com.verbatim.client.springrest.models.Post;
import com.verbatim.client.springrest.models.PostAttachmentResponse;
import com.verbatim.client.springrest.models.PostItemResponse;
import com.verbatim.client.springrest.models.PostListResponse;
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
public class PostApi extends BaseApi {

    public PostApi() {
        super(new ApiClient());
    }

    public PostApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Attachments from a post
     * List the attachments from a post.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Attachments found.
     * @param postId ID of the post. (required)
     * @return PostAttachmentResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public PostAttachmentResponse attachment(UUID postId) throws RestClientException {
        return attachmentWithHttpInfo(postId).getBody();
    }

    /**
     * Attachments from a post
     * List the attachments from a post.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Attachments found.
     * @param postId ID of the post. (required)
     * @return ResponseEntity&lt;PostAttachmentResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<PostAttachmentResponse> attachmentWithHttpInfo(UUID postId) throws RestClientException {
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

        String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

        ParameterizedTypeReference<PostAttachmentResponse> localReturnType = new ParameterizedTypeReference<PostAttachmentResponse>() {};
        return apiClient.invokeAPI("/v1/post/attachment/{postId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete a post
     * Permanently delete a post and its attachments. Documents and embeddings referenced by the attachments are **not** affected.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Post deleted.
     * @param postId ID of the post to delete. (required)
     * @return AckResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public AckResponse delete4(UUID postId) throws RestClientException {
        return delete4WithHttpInfo(postId).getBody();
    }

    /**
     * Delete a post
     * Permanently delete a post and its attachments. Documents and embeddings referenced by the attachments are **not** affected.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Post deleted.
     * @param postId ID of the post to delete. (required)
     * @return ResponseEntity&lt;AckResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<AckResponse> delete4WithHttpInfo(UUID postId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'postId' is set
        if (postId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'postId' when calling delete4");
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

        String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

        ParameterizedTypeReference<AckResponse> localReturnType = new ParameterizedTypeReference<AckResponse>() {};
        return apiClient.invokeAPI("/v1/post/{postId}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get a presigned download URL
     * Return a time-limited presigned URL the client can use to GET the document content directly from the storage backend (S3) — no content flows through this server.  The URL is bound to the document&#39;s content type; clients SHOULD use the returned &#x60;filename&#x60; for the local save name. 
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Presigned URL issued.
     * @param docId ID of the document. (required)
     * @return DocumentDownloadUrl
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public DocumentDownloadUrl downloadUrl(UUID docId) throws RestClientException {
        return downloadUrlWithHttpInfo(docId).getBody();
    }

    /**
     * Get a presigned download URL
     * Return a time-limited presigned URL the client can use to GET the document content directly from the storage backend (S3) — no content flows through this server.  The URL is bound to the document&#39;s content type; clients SHOULD use the returned &#x60;filename&#x60; for the local save name. 
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Presigned URL issued.
     * @param docId ID of the document. (required)
     * @return ResponseEntity&lt;DocumentDownloadUrl&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<DocumentDownloadUrl> downloadUrlWithHttpInfo(UUID docId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'docId' is set
        if (docId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'docId' when calling downloadUrl");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("docId", docId);

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

        ParameterizedTypeReference<DocumentDownloadUrl> localReturnType = new ParameterizedTypeReference<DocumentDownloadUrl>() {};
        return apiClient.invokeAPI("/v1/post/attachment/{docId}/download-url", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get a post
     * Fetch a single post by its identifier, including its attachments.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Post found.
     * @param postId ID of the post. (required)
     * @return Post
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Post get4(UUID postId) throws RestClientException {
        return get4WithHttpInfo(postId).getBody();
    }

    /**
     * Get a post
     * Fetch a single post by its identifier, including its attachments.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Post found.
     * @param postId ID of the post. (required)
     * @return ResponseEntity&lt;Post&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Post> get4WithHttpInfo(UUID postId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'postId' is set
        if (postId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'postId' when calling get4");
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

        String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

        ParameterizedTypeReference<Post> localReturnType = new ParameterizedTypeReference<Post>() {};
        return apiClient.invokeAPI("/v1/post/{postId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List posts
     * Paginate every post (user queries and system answers) in a session, newest first.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Page of posts.
     * @param sessionId ID of the session. (required)
     * @param pageSize Number of items per page. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return PostListResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public PostListResponse list3(UUID sessionId, Integer pageSize, Integer pageIndex) throws RestClientException {
        return list3WithHttpInfo(sessionId, pageSize, pageIndex).getBody();
    }

    /**
     * List posts
     * Paginate every post (user queries and system answers) in a session, newest first.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Page of posts.
     * @param sessionId ID of the session. (required)
     * @param pageSize Number of items per page. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return ResponseEntity&lt;PostListResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<PostListResponse> list3WithHttpInfo(UUID sessionId, Integer pageSize, Integer pageIndex) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'sessionId' is set
        if (sessionId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'sessionId' when calling list3");
        }
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "sessionId", sessionId));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "pageSize", pageSize));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "pageIndex", pageIndex));
        

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

        ParameterizedTypeReference<PostListResponse> localReturnType = new ParameterizedTypeReference<PostListResponse>() {};
        return apiClient.invokeAPI("/v1/post/", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get presigned preview URLs
     * Return time-limited presigned URLs for the rendered preview images of the document.  &#x60;pages&#x60; is **required** and selects the zero-based page indices to issue URLs for: at least one, at most 10 per request — &#x60;400&#x60; otherwise. Repeat the parameter for several values (&#x60;pages&#x3D;0&amp;pages&#x3D;2&#x60;) or send them comma-separated (&#x60;pages&#x3D;0,2&#x60;). Duplicates are preserved as supplied and count towards the limit. Paginate over a long document with several calls rather than asking for every page at once.  Every index must address a page of *that* document: negatives are rejected, and so is anything at or past its page count once that count is known (&#x60;nbPages&#x60; from &#x60;GET /v1/doc/{id}&#x60;, &#x60;0&#x60; while the rendering pipeline has not reported it).  One entry is issued per (page, size) over {SMALL, MEDIUM}, so a call returns &#x60;2 × pages&#x60; entries — at most 20.  The URLs point at preview images produced asynchronously by the rendering pipeline. No existence check is performed — individual URLs MAY return 404 when fetched if the corresponding (page, size) hasn&#39;t been generated yet; clients SHOULD fall back per-tile. 
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - &#x60;pages&#x60; is missing, empty, carries more than 10 indices, or names a page outside the document.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Presigned preview URLs issued.
     * @param docId ID of the document. (required)
     * @param pages Zero-based page indices to issue preview URLs for. Required: 1 to 10 values per request, each within the document&#39;s page range. Repeat for multiple values: &#x60;pages&#x3D;0&amp;pages&#x3D;2&#x60;. (required)
     * @return DocumentPreviewUrls
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public DocumentPreviewUrls previewUrls(UUID docId, List<Integer> pages) throws RestClientException {
        return previewUrlsWithHttpInfo(docId, pages).getBody();
    }

    /**
     * Get presigned preview URLs
     * Return time-limited presigned URLs for the rendered preview images of the document.  &#x60;pages&#x60; is **required** and selects the zero-based page indices to issue URLs for: at least one, at most 10 per request — &#x60;400&#x60; otherwise. Repeat the parameter for several values (&#x60;pages&#x3D;0&amp;pages&#x3D;2&#x60;) or send them comma-separated (&#x60;pages&#x3D;0,2&#x60;). Duplicates are preserved as supplied and count towards the limit. Paginate over a long document with several calls rather than asking for every page at once.  Every index must address a page of *that* document: negatives are rejected, and so is anything at or past its page count once that count is known (&#x60;nbPages&#x60; from &#x60;GET /v1/doc/{id}&#x60;, &#x60;0&#x60; while the rendering pipeline has not reported it).  One entry is issued per (page, size) over {SMALL, MEDIUM}, so a call returns &#x60;2 × pages&#x60; entries — at most 20.  The URLs point at preview images produced asynchronously by the rendering pipeline. No existence check is performed — individual URLs MAY return 404 when fetched if the corresponding (page, size) hasn&#39;t been generated yet; clients SHOULD fall back per-tile. 
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - &#x60;pages&#x60; is missing, empty, carries more than 10 indices, or names a page outside the document.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Presigned preview URLs issued.
     * @param docId ID of the document. (required)
     * @param pages Zero-based page indices to issue preview URLs for. Required: 1 to 10 values per request, each within the document&#39;s page range. Repeat for multiple values: &#x60;pages&#x3D;0&amp;pages&#x3D;2&#x60;. (required)
     * @return ResponseEntity&lt;DocumentPreviewUrls&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<DocumentPreviewUrls> previewUrlsWithHttpInfo(UUID docId, List<Integer> pages) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'docId' is set
        if (docId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'docId' when calling previewUrls");
        }
        
        // verify the required parameter 'pages' is set
        if (pages == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'pages' when calling previewUrls");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("docId", docId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "pages", pages));
        

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

        ParameterizedTypeReference<DocumentPreviewUrls> localReturnType = new ParameterizedTypeReference<DocumentPreviewUrls>() {};
        return apiClient.invokeAPI("/v1/post/attachment/{docId}/preview-urls", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Send a query
     * Submit a user message to a session and run the full RAG pipeline:  1. Persist the query as a post with &#x60;owner &#x3D; USER&#x60;. 2. Vectorize the query and run a cosine-similarity search against the session&#39;s corpora. 3. Feed the top chunks to the session&#39;s LLM as context. 4. Persist the answer as a post with &#x60;owner &#x3D; SYSTEM&#x60;, with attachments pointing to the chunks used.  The response contains both the user post (&#x60;query&#x60;) and the system post (&#x60;answer&#x60;).  ### Choosing an agent  How much of that pipeline runs, and how, is decided by an **agent** — retrieval width, whether the chunks are re-ranked, the system instruction, how much of the conversation is replayed, and which model answers. See &#x60;GET /v1/agent/&#x60;.  Omit &#x60;agentId&#x60; and the query runs on the platform default agent, which is what every query did before agents existed. Pass one to run this single query under a different setup:  &#x60;&#x60;&#x60; GET /v1/post/q?sessionId&#x3D;$SESSION_ID&amp;body&#x3D;What+is+the+refund+policy%3F&amp;agentId&#x3D;$AGENT_ID &#x60;&#x60;&#x60;  The choice is **per query, not per session** — the next query on the same session is independent, so a client can escalate one question to a wider, slower agent without changing the conversation it belongs to.  The agent is then recorded on the answer as &#x60;agentId&#x60;, and only on the answer: the user&#39;s question is not something an agent produced. A missing &#x60;agentId&#x60; on an answer therefore means \&quot;ran on the default agent\&quot;, not \&quot;unknown\&quot;. Deleting an agent does not rewrite the answers it produced, so this still names an agent you have since deleted — resolving that id through &#x60;GET /v1/agent/{agentId}&#x60; answers &#x60;404&#x60;, which is the honest reading.  An &#x60;agentId&#x60; your organization cannot see — someone else&#39;s, or one that never existed — answers &#x60;404&#x60; and no post is written. 
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Query processed and answer returned.
     * @param sessionId ID of the session to post the query into. (required)
     * @param body User message to send to the LLM. (required)
     * @param lang ISO-639 language code used by the LLM. Defaults to &#x60;en&#x60;. (optional)
     * @param agentId Agent to run this query under. Omit to use the platform default agent. Must be one of the agents &#x60;GET /v1/agent/&#x60; lists for your organization. (optional)
     * @return PostItemResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public PostItemResponse query(UUID sessionId, String body, String lang, UUID agentId) throws RestClientException {
        return queryWithHttpInfo(sessionId, body, lang, agentId).getBody();
    }

    /**
     * Send a query
     * Submit a user message to a session and run the full RAG pipeline:  1. Persist the query as a post with &#x60;owner &#x3D; USER&#x60;. 2. Vectorize the query and run a cosine-similarity search against the session&#39;s corpora. 3. Feed the top chunks to the session&#39;s LLM as context. 4. Persist the answer as a post with &#x60;owner &#x3D; SYSTEM&#x60;, with attachments pointing to the chunks used.  The response contains both the user post (&#x60;query&#x60;) and the system post (&#x60;answer&#x60;).  ### Choosing an agent  How much of that pipeline runs, and how, is decided by an **agent** — retrieval width, whether the chunks are re-ranked, the system instruction, how much of the conversation is replayed, and which model answers. See &#x60;GET /v1/agent/&#x60;.  Omit &#x60;agentId&#x60; and the query runs on the platform default agent, which is what every query did before agents existed. Pass one to run this single query under a different setup:  &#x60;&#x60;&#x60; GET /v1/post/q?sessionId&#x3D;$SESSION_ID&amp;body&#x3D;What+is+the+refund+policy%3F&amp;agentId&#x3D;$AGENT_ID &#x60;&#x60;&#x60;  The choice is **per query, not per session** — the next query on the same session is independent, so a client can escalate one question to a wider, slower agent without changing the conversation it belongs to.  The agent is then recorded on the answer as &#x60;agentId&#x60;, and only on the answer: the user&#39;s question is not something an agent produced. A missing &#x60;agentId&#x60; on an answer therefore means \&quot;ran on the default agent\&quot;, not \&quot;unknown\&quot;. Deleting an agent does not rewrite the answers it produced, so this still names an agent you have since deleted — resolving that id through &#x60;GET /v1/agent/{agentId}&#x60; answers &#x60;404&#x60;, which is the honest reading.  An &#x60;agentId&#x60; your organization cannot see — someone else&#39;s, or one that never existed — answers &#x60;404&#x60; and no post is written. 
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Query processed and answer returned.
     * @param sessionId ID of the session to post the query into. (required)
     * @param body User message to send to the LLM. (required)
     * @param lang ISO-639 language code used by the LLM. Defaults to &#x60;en&#x60;. (optional)
     * @param agentId Agent to run this query under. Omit to use the platform default agent. Must be one of the agents &#x60;GET /v1/agent/&#x60; lists for your organization. (optional)
     * @return ResponseEntity&lt;PostItemResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<PostItemResponse> queryWithHttpInfo(UUID sessionId, String body, String lang, UUID agentId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'sessionId' is set
        if (sessionId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'sessionId' when calling query");
        }
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling query");
        }
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "sessionId", sessionId));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "body", body));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "lang", lang));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "agentId", agentId));
        

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

        ParameterizedTypeReference<PostItemResponse> localReturnType = new ParameterizedTypeReference<PostItemResponse>() {};
        return apiClient.invokeAPI("/v1/post/q", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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

        String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

        return apiClient.invokeAPI(localVarPath, method, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, returnType);
    }
}
