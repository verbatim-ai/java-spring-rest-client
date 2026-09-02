package com.verbatim.client.springrest.api;

import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.BaseApi;

import com.verbatim.client.springrest.models.AckResponse;
import com.verbatim.client.springrest.models.Document;
import com.verbatim.client.springrest.models.DocumentDownloadUrl;
import com.verbatim.client.springrest.models.DocumentInit;
import com.verbatim.client.springrest.models.DocumentInitRequest;
import com.verbatim.client.springrest.models.DocumentListResponse;
import com.verbatim.client.springrest.models.DocumentPreviewUrls;
import com.verbatim.client.springrest.models.DocumentSearchResponse;
import com.verbatim.client.springrest.models.DocumentStatus;
import com.verbatim.client.springrest.models.DocumentUpdateRequest;
import com.verbatim.client.springrest.models.Error;
import java.time.OffsetDateTime;
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
public class DocumentApi extends BaseApi {

    public DocumentApi() {
        super(new ApiClient());
    }

    public DocumentApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Commit a previously initialized upload
     * Step 2 of the upload flow. Confirms that the file has been PUT to the presigned URL returned by &#x60;POST /v1/doc/init&#x60; and **asynchronously** triggers ingestion (markdown conversion, summarization, chunking, embedding).  Before queuing, the server validates the uploaded object: it must exist, declare a supported content type, fit under the per-document size limit, and not already be present in the same corpus (duplicate detection by content hash).  The response is returned as soon as the document is moved to &#x60;PROCESSING&#x60;. Poll &#x60;GET /v1/doc/{id}/status&#x60; to observe the final &#x60;READY&#x60; or &#x60;FAILED&#x60; status.  Idempotent: committing a document already in &#x60;READY&#x60; status returns the current state unchanged. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>202</b> - Ingestion queued. Document moved to PROCESSING.
     * @param id ID of the document returned by &#x60;POST /v1/doc/init&#x60;. (required)
     * @return Document
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Document commitUpload(UUID id) throws RestClientException {
        return commitUploadWithHttpInfo(id).getBody();
    }

    /**
     * Commit a previously initialized upload
     * Step 2 of the upload flow. Confirms that the file has been PUT to the presigned URL returned by &#x60;POST /v1/doc/init&#x60; and **asynchronously** triggers ingestion (markdown conversion, summarization, chunking, embedding).  Before queuing, the server validates the uploaded object: it must exist, declare a supported content type, fit under the per-document size limit, and not already be present in the same corpus (duplicate detection by content hash).  The response is returned as soon as the document is moved to &#x60;PROCESSING&#x60;. Poll &#x60;GET /v1/doc/{id}/status&#x60; to observe the final &#x60;READY&#x60; or &#x60;FAILED&#x60; status.  Idempotent: committing a document already in &#x60;READY&#x60; status returns the current state unchanged. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>202</b> - Ingestion queued. Document moved to PROCESSING.
     * @param id ID of the document returned by &#x60;POST /v1/doc/init&#x60;. (required)
     * @return ResponseEntity&lt;Document&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Document> commitUploadWithHttpInfo(UUID id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling commitUpload");
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

        String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

        ParameterizedTypeReference<Document> localReturnType = new ParameterizedTypeReference<Document>() {};
        return apiClient.invokeAPI("/v1/doc/{id}/commit", HttpMethod.POST, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete a document
     * Permanently remove a document from its corpus. **Cascades** to all embeddings and attachments referencing this document. This operation cannot be undone.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Document and dependencies deleted.
     * @param id ID of the document to delete. (required)
     * @return AckResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public AckResponse delete1(UUID id) throws RestClientException {
        return delete1WithHttpInfo(id).getBody();
    }

    /**
     * Delete a document
     * Permanently remove a document from its corpus. **Cascades** to all embeddings and attachments referencing this document. This operation cannot be undone.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Document and dependencies deleted.
     * @param id ID of the document to delete. (required)
     * @return ResponseEntity&lt;AckResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<AckResponse> delete1WithHttpInfo(UUID id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling delete1");
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

        String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

        ParameterizedTypeReference<AckResponse> localReturnType = new ParameterizedTypeReference<AckResponse>() {};
        return apiClient.invokeAPI("/v1/doc/{id}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get a presigned download URL
     * Return a time-limited presigned URL the client can use to GET the document content directly from the storage backend (S3) — no content flows through this server.  The URL is bound to the document&#39;s content type; clients SHOULD use the returned &#x60;filename&#x60; for the local save name. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Presigned URL issued.
     * @param id ID of the document. (required)
     * @return DocumentDownloadUrl
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public DocumentDownloadUrl downloadUrl1(UUID id) throws RestClientException {
        return downloadUrl1WithHttpInfo(id).getBody();
    }

    /**
     * Get a presigned download URL
     * Return a time-limited presigned URL the client can use to GET the document content directly from the storage backend (S3) — no content flows through this server.  The URL is bound to the document&#39;s content type; clients SHOULD use the returned &#x60;filename&#x60; for the local save name. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Presigned URL issued.
     * @param id ID of the document. (required)
     * @return ResponseEntity&lt;DocumentDownloadUrl&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<DocumentDownloadUrl> downloadUrl1WithHttpInfo(UUID id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling downloadUrl1");
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

        String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

        ParameterizedTypeReference<DocumentDownloadUrl> localReturnType = new ParameterizedTypeReference<DocumentDownloadUrl>() {};
        return apiClient.invokeAPI("/v1/doc/{id}/download-url", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get a document
     * Return the metadata of a document by its ID, including provider, language and arbitrary metadata.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Document found.
     * @param id ID of the document. (required)
     * @return Document
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Document get1(UUID id) throws RestClientException {
        return get1WithHttpInfo(id).getBody();
    }

    /**
     * Get a document
     * Return the metadata of a document by its ID, including provider, language and arbitrary metadata.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Document found.
     * @param id ID of the document. (required)
     * @return ResponseEntity&lt;Document&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Document> get1WithHttpInfo(UUID id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling get1");
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

        String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

        ParameterizedTypeReference<Document> localReturnType = new ParameterizedTypeReference<Document>() {};
        return apiClient.invokeAPI("/v1/doc/{id}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Initialize a direct-to-storage upload
     * Step 1 of the upload flow. Validates inputs, creates a document in &#x60;AWAITING_UPLOAD&#x60; status, and returns a single-use presigned PUT URL the client must use to push the file bytes directly to S3 — no content flows through this server.  The returned &#x60;uploadUrl&#x60; is bound to the requested &#x60;contentType&#x60;: the client MUST send a matching &#x60;Content-Type&#x60; header in the PUT request, or S3 will reject it.  After the PUT succeeds, call &#x60;POST /v1/doc/{id}/commit&#x60; to trigger ingestion.  Accepted content types are listed by &#x60;GET /v1/doc/accept&#x60;.  Two optional fields shape what happens later: &#x60;tags&#x60; classifies the document so &#x60;GET /v1/doc/?tags&#x3D;…&#x60; can find it, and &#x60;chunk&#x60; overrides how ingestion splits it into embeddable pieces. &#x60;chunk&#x60; accepts the Unstructured chunking options (&#x60;strategy&#x60;, &#x60;max_characters&#x60;, &#x60;overlap&#x60;, …) — see the request schema for the full key reference, and the *Chunking* examples below for the three shapes that cover most documents. Omit &#x60;chunk&#x60; and the platform default applies (&#x60;by_title&#x60;, &#x60;max_characters: 10000&#x60;, &#x60;combine_text_under_n_chars: 1000&#x60;). 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Document created in AWAITING_UPLOAD status. PUT the file to &#x60;uploadUrl&#x60;.
     * @param documentInitRequest  (required)
     * @return DocumentInit
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public DocumentInit initUpload(DocumentInitRequest documentInitRequest) throws RestClientException {
        return initUploadWithHttpInfo(documentInitRequest).getBody();
    }

    /**
     * Initialize a direct-to-storage upload
     * Step 1 of the upload flow. Validates inputs, creates a document in &#x60;AWAITING_UPLOAD&#x60; status, and returns a single-use presigned PUT URL the client must use to push the file bytes directly to S3 — no content flows through this server.  The returned &#x60;uploadUrl&#x60; is bound to the requested &#x60;contentType&#x60;: the client MUST send a matching &#x60;Content-Type&#x60; header in the PUT request, or S3 will reject it.  After the PUT succeeds, call &#x60;POST /v1/doc/{id}/commit&#x60; to trigger ingestion.  Accepted content types are listed by &#x60;GET /v1/doc/accept&#x60;.  Two optional fields shape what happens later: &#x60;tags&#x60; classifies the document so &#x60;GET /v1/doc/?tags&#x3D;…&#x60; can find it, and &#x60;chunk&#x60; overrides how ingestion splits it into embeddable pieces. &#x60;chunk&#x60; accepts the Unstructured chunking options (&#x60;strategy&#x60;, &#x60;max_characters&#x60;, &#x60;overlap&#x60;, …) — see the request schema for the full key reference, and the *Chunking* examples below for the three shapes that cover most documents. Omit &#x60;chunk&#x60; and the platform default applies (&#x60;by_title&#x60;, &#x60;max_characters: 10000&#x60;, &#x60;combine_text_under_n_chars: 1000&#x60;). 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Document created in AWAITING_UPLOAD status. PUT the file to &#x60;uploadUrl&#x60;.
     * @param documentInitRequest  (required)
     * @return ResponseEntity&lt;DocumentInit&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<DocumentInit> initUploadWithHttpInfo(DocumentInitRequest documentInitRequest) throws RestClientException {
        Object localVarPostBody = documentInitRequest;
        
        // verify the required parameter 'documentInitRequest' is set
        if (documentInitRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'documentInitRequest' when calling initUpload");
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

        ParameterizedTypeReference<DocumentInit> localReturnType = new ParameterizedTypeReference<DocumentInit>() {};
        return apiClient.invokeAPI("/v1/doc/init", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List documents
     * Paginate documents stored in a corpus. Pass the optional &#x60;status&#x60; filter to narrow down by lifecycle state — e.g. &#x60;status&#x3D;PENDING&#x60; returns the ingestion backlog, &#x60;status&#x3D;FAILED&#x60; returns documents that need attention.  Pass &#x60;tags&#x60; to keep only documents carrying **at least one** of the given tags (repeat the parameter for several: &#x60;tags&#x3D;legal&amp;tags&#x3D;2026&#x60;). Combining &#x60;status&#x60; and &#x60;tags&#x60; narrows on both. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Page of documents.
     * @param corpusId ID of the corpus. (required)
     * @param status Optional lifecycle filter. When omitted, documents of all statuses are returned. (optional)
     * @param tags Optional tag filter. Returns documents carrying at least one of the given tags. Repeat for multiple values: &#x60;tags&#x3D;legal&amp;tags&#x3D;2026&#x60;. When omitted, tags are ignored. (optional)
     * @param pageSize Number of items per page, 1-100. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return DocumentListResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public DocumentListResponse list4(UUID corpusId, String status, List<String> tags, Integer pageSize, Integer pageIndex) throws RestClientException {
        return list4WithHttpInfo(corpusId, status, tags, pageSize, pageIndex).getBody();
    }

    /**
     * List documents
     * Paginate documents stored in a corpus. Pass the optional &#x60;status&#x60; filter to narrow down by lifecycle state — e.g. &#x60;status&#x3D;PENDING&#x60; returns the ingestion backlog, &#x60;status&#x3D;FAILED&#x60; returns documents that need attention.  Pass &#x60;tags&#x60; to keep only documents carrying **at least one** of the given tags (repeat the parameter for several: &#x60;tags&#x3D;legal&amp;tags&#x3D;2026&#x60;). Combining &#x60;status&#x60; and &#x60;tags&#x60; narrows on both. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Page of documents.
     * @param corpusId ID of the corpus. (required)
     * @param status Optional lifecycle filter. When omitted, documents of all statuses are returned. (optional)
     * @param tags Optional tag filter. Returns documents carrying at least one of the given tags. Repeat for multiple values: &#x60;tags&#x3D;legal&amp;tags&#x3D;2026&#x60;. When omitted, tags are ignored. (optional)
     * @param pageSize Number of items per page, 1-100. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return ResponseEntity&lt;DocumentListResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<DocumentListResponse> list4WithHttpInfo(UUID corpusId, String status, List<String> tags, Integer pageSize, Integer pageIndex) throws RestClientException {
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
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "status", status));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "tags", tags));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "pageSize", pageSize));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "pageIndex", pageIndex));
        

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

        ParameterizedTypeReference<DocumentListResponse> localReturnType = new ParameterizedTypeReference<DocumentListResponse>() {};
        return apiClient.invokeAPI("/v1/doc/", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List accepted content types
     * Return the MIME types accepted by &#x60;POST /v1/doc/init&#x60;. Use this to validate files client-side before initializing an upload.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - List of accepted MIME types.
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String listSupportedDocuments() throws RestClientException {
        return listSupportedDocumentsWithHttpInfo().getBody();
    }

    /**
     * List accepted content types
     * Return the MIME types accepted by &#x60;POST /v1/doc/init&#x60;. Use this to validate files client-side before initializing an upload.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - List of accepted MIME types.
     * @return ResponseEntity&lt;String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<String> listSupportedDocumentsWithHttpInfo() throws RestClientException {
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

        ParameterizedTypeReference<String> localReturnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI("/v1/doc/accept", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get presigned preview URLs
     * Return time-limited presigned URLs for the rendered preview images of the document.  &#x60;pages&#x60; is **required** and selects the zero-based page indices to issue URLs for: at least one, at most 10 per request — &#x60;400&#x60; otherwise. Repeat the parameter for several values (&#x60;pages&#x3D;0&amp;pages&#x3D;2&#x60;) or send them comma-separated (&#x60;pages&#x3D;0,2&#x60;). Duplicates are preserved as supplied and count towards the limit. Paginate over a long document with several calls rather than asking for every page at once.  Every index must address a page of *that* document: negatives are rejected, and so is anything at or past its page count once that count is known (&#x60;nbPages&#x60; from &#x60;GET /v1/doc/{id}&#x60;, &#x60;0&#x60; while the rendering pipeline has not reported it).  One entry is issued per (page, size) over {SMALL, MEDIUM}, so a call returns &#x60;2 × pages&#x60; entries — at most 20.  The URLs point at preview images produced asynchronously by the rendering pipeline. No existence check is performed — individual URLs MAY return 404 when fetched if the corresponding (page, size) hasn&#39;t been generated yet; clients SHOULD fall back per-tile. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - &#x60;pages&#x60; is missing, empty, carries more than 10 indices, or names a page outside the document.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Presigned preview URLs issued.
     * @param id ID of the document. (required)
     * @param pages One-based page indices to issue preview URLs for. Required: 1 to 10 values per request, each within the document&#39;s page range. Repeat for multiple values: &#x60;pages&#x3D;1&amp;pages&#x3D;2&#x60;. (required)
     * @return DocumentPreviewUrls
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public DocumentPreviewUrls previewUrls1(UUID id, List<Integer> pages) throws RestClientException {
        return previewUrls1WithHttpInfo(id, pages).getBody();
    }

    /**
     * Get presigned preview URLs
     * Return time-limited presigned URLs for the rendered preview images of the document.  &#x60;pages&#x60; is **required** and selects the zero-based page indices to issue URLs for: at least one, at most 10 per request — &#x60;400&#x60; otherwise. Repeat the parameter for several values (&#x60;pages&#x3D;0&amp;pages&#x3D;2&#x60;) or send them comma-separated (&#x60;pages&#x3D;0,2&#x60;). Duplicates are preserved as supplied and count towards the limit. Paginate over a long document with several calls rather than asking for every page at once.  Every index must address a page of *that* document: negatives are rejected, and so is anything at or past its page count once that count is known (&#x60;nbPages&#x60; from &#x60;GET /v1/doc/{id}&#x60;, &#x60;0&#x60; while the rendering pipeline has not reported it).  One entry is issued per (page, size) over {SMALL, MEDIUM}, so a call returns &#x60;2 × pages&#x60; entries — at most 20.  The URLs point at preview images produced asynchronously by the rendering pipeline. No existence check is performed — individual URLs MAY return 404 when fetched if the corresponding (page, size) hasn&#39;t been generated yet; clients SHOULD fall back per-tile. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - &#x60;pages&#x60; is missing, empty, carries more than 10 indices, or names a page outside the document.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Presigned preview URLs issued.
     * @param id ID of the document. (required)
     * @param pages One-based page indices to issue preview URLs for. Required: 1 to 10 values per request, each within the document&#39;s page range. Repeat for multiple values: &#x60;pages&#x3D;1&amp;pages&#x3D;2&#x60;. (required)
     * @return ResponseEntity&lt;DocumentPreviewUrls&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<DocumentPreviewUrls> previewUrls1WithHttpInfo(UUID id, List<Integer> pages) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling previewUrls1");
        }
        
        // verify the required parameter 'pages' is set
        if (pages == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'pages' when calling previewUrls1");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);

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
        return apiClient.invokeAPI("/v1/doc/{id}/preview-urls", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Re-initialize a document for a new upload
     * Replace the **content** of an existing document while keeping its identity: same &#x60;id&#x60;, same &#x60;filename&#x60;, &#x60;userId&#x60;, &#x60;provider&#x60;, &#x60;lang&#x60;, &#x60;metadata&#x60;, &#x60;tags&#x60;, &#x60;chunk&#x60; and source dates. Use &#x60;PATCH /v1/doc/{id}&#x60; to change those attributes — this endpoint only touches the file behind them.  The document must be in &#x60;READY&#x60; or &#x60;FAILED&#x60; status; any other status is rejected with &#x60;409&#x60;, since there is either nothing ingested yet or an ingestion in flight.  Everything derived from the previous content is dropped: its embeddings, its summary, and the counters filled in by ingestion (&#x60;size&#x60;, &#x60;tokens&#x60;, &#x60;nbWords&#x60;). The document moves back to &#x60;AWAITING_UPLOAD&#x60; and the response carries a fresh presigned PUT URL — the same payload as &#x60;POST /v1/doc/init&#x60;. From there the flow is unchanged: PUT the new bytes, then call &#x60;POST /v1/doc/{id}/commit&#x60;.  Two things to be aware of:  - Posts that cited this document **lose their attachments to it**, because the   citations point at the embeddings being deleted. Answers already returned to   users are not modified. - The previously uploaded file **stays in storage** until your PUT overwrites it.   Committing without uploading first therefore re-ingests the old content. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - The document&#39;s content type is no longer accepted — see &#x60;GET /v1/doc/accept&#x60;.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - Document is not in &#x60;READY&#x60; or &#x60;FAILED&#x60; status — nothing to replace, or an ingestion is in flight.
     * <p><b>200</b> - Document reset to AWAITING_UPLOAD status. PUT the new file to &#x60;uploadUrl&#x60;.
     * @param id ID of the document whose content is being replaced. (required)
     * @return DocumentInit
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public DocumentInit reinitUpload(UUID id) throws RestClientException {
        return reinitUploadWithHttpInfo(id).getBody();
    }

    /**
     * Re-initialize a document for a new upload
     * Replace the **content** of an existing document while keeping its identity: same &#x60;id&#x60;, same &#x60;filename&#x60;, &#x60;userId&#x60;, &#x60;provider&#x60;, &#x60;lang&#x60;, &#x60;metadata&#x60;, &#x60;tags&#x60;, &#x60;chunk&#x60; and source dates. Use &#x60;PATCH /v1/doc/{id}&#x60; to change those attributes — this endpoint only touches the file behind them.  The document must be in &#x60;READY&#x60; or &#x60;FAILED&#x60; status; any other status is rejected with &#x60;409&#x60;, since there is either nothing ingested yet or an ingestion in flight.  Everything derived from the previous content is dropped: its embeddings, its summary, and the counters filled in by ingestion (&#x60;size&#x60;, &#x60;tokens&#x60;, &#x60;nbWords&#x60;). The document moves back to &#x60;AWAITING_UPLOAD&#x60; and the response carries a fresh presigned PUT URL — the same payload as &#x60;POST /v1/doc/init&#x60;. From there the flow is unchanged: PUT the new bytes, then call &#x60;POST /v1/doc/{id}/commit&#x60;.  Two things to be aware of:  - Posts that cited this document **lose their attachments to it**, because the   citations point at the embeddings being deleted. Answers already returned to   users are not modified. - The previously uploaded file **stays in storage** until your PUT overwrites it.   Committing without uploading first therefore re-ingests the old content. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - The document&#39;s content type is no longer accepted — see &#x60;GET /v1/doc/accept&#x60;.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - Document is not in &#x60;READY&#x60; or &#x60;FAILED&#x60; status — nothing to replace, or an ingestion is in flight.
     * <p><b>200</b> - Document reset to AWAITING_UPLOAD status. PUT the new file to &#x60;uploadUrl&#x60;.
     * @param id ID of the document whose content is being replaced. (required)
     * @return ResponseEntity&lt;DocumentInit&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<DocumentInit> reinitUploadWithHttpInfo(UUID id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling reinitUpload");
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

        String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

        ParameterizedTypeReference<DocumentInit> localReturnType = new ParameterizedTypeReference<DocumentInit>() {};
        return apiClient.invokeAPI("/v1/doc/{id}/init", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Search documents
     * Find documents in a corpus by filename, tags, lifecycle status, content type, language, provider or ingestion date, sorted the way you need them.  Every filter is optional and they **narrow together**: a request carrying none of them returns the whole corpus, one carrying several returns only the documents matching all of them. For a plain corpus listing, &#x60;GET /v1/doc/&#x60; is the simpler endpoint — this one is for finding a document you cannot scroll to.  ### Filename — &#x60;q&#x60;  Case-insensitive, and **anchored at the start** of the filename: &#x60;q&#x3D;annual&#x60; finds &#x60;Annual-Report-2025.pdf&#x60;, &#x60;q&#x3D;report&#x60; does not. Put a &#x60;*&#x60; anywhere to match elsewhere — &#x60;q&#x3D;*report&#x60; searches any position, &#x60;q&#x3D;*report*&#x60; a substring, &#x60;q&#x3D;2025-*.pdf&#x60; a name that starts with &#x60;2025-&#x60; and ends in &#x60;.pdf&#x60;.  The default is anchored because that is the shape the index can serve: an anchored pattern is a range scan, a leading &#x60;*&#x60; is a filter over the corpus. Both are correct, the first is cheaper — prefer it when your client knows how the filename begins.  &#x60;%&#x60; and &#x60;_&#x60; carry no special meaning here: they match themselves.  ### Tags — &#x60;tags&#x60;, &#x60;tagsMatch&#x60;  Repeat the parameter for several tags (&#x60;tags&#x3D;legal&amp;tags&#x3D;2026&#x60;). By default (&#x60;tagsMatch&#x3D;ANY&#x60;) a document matches when it carries **at least one** of them, which is what &#x60;GET /v1/doc/?tags&#x3D;…&#x60; does; &#x60;tagsMatch&#x3D;ALL&#x60; requires **every** one of them, extra tags on the document being fine.  ### Status — &#x60;status&#x60;  Repeatable as well, and any of the listed states matches: &#x60;status&#x3D;PENDING&amp;status&#x3D;FAILED&#x60; returns everything that is not ingested yet or needs attention.  ### Content type — &#x60;contentType&#x60;  Repeatable too, and any of the listed types matches: &#x60;contentType&#x3D;application/pdf&amp;contentType&#x3D;text/plain&#x60;. Values are taken as they come — nothing is checked against &#x60;GET /v1/doc/accept&#x60;, so a type the platform does not ingest is not an error, it simply matches no document.  ### Size — &#x60;minSize&#x60;, &#x60;maxSize&#x60;  A range on the stored size in bytes, **inclusive at both ends** and each bound independent: &#x60;minSize&#x3D;1048576&#x60; alone is \&quot;at least 1 MB\&quot;, &#x60;maxSize&#x60; alone \&quot;at most\&quot;, and &#x60;minSize&#x3D;maxSize&#x3D;N&#x60; the documents of exactly that many bytes. &#x60;minSize&#x60; above &#x60;maxSize&#x60; is refused with &#x60;400&#x60; rather than answering an empty page.  A document only has a size once its upload is committed, so setting either bound also excludes everything still &#x60;AWAITING_UPLOAD&#x60; — the same documents &#x60;sort&#x3D;SIZE&#x60; pushes to the end of the result.  ### Dates — &#x60;createdAfter&#x60;, &#x60;createdBefore&#x60;  A half-open window on the ingestion date: &#x60;createdAfter&#x60; is inclusive, &#x60;createdBefore&#x60; exclusive, so consecutive windows tile the timeline without returning a document twice. Supplying &#x60;createdAfter&#x60; at or after &#x60;createdBefore&#x60; is refused with &#x60;400&#x60; rather than answering an empty page.  ### Ordering and paging  &#x60;sort&#x60; defaults to &#x60;CREATED_AT&#x60; and &#x60;order&#x60; to &#x60;DESC&#x60; — newest first. The ordering is closed by the document id, so walking &#x60;pageIndex&#x60; never shows the same document twice nor skips one, even when many documents share a sort key. Documents whose &#x60;size&#x60; is not known yet sort last whatever the direction.  &#x60;total&#x60; counts every match across all pages, not just the ones returned here.  ### Examples  * &#x60;?corpusId&#x3D;…&amp;q&#x3D;annual-report&#x60; — every document whose name starts with it * &#x60;?corpusId&#x3D;…&amp;q&#x3D;*report*&#x60; — anywhere in the name, at the cost of a scan * &#x60;?corpusId&#x3D;…&amp;q&#x3D;2025-*.pdf&#x60; — starts with &#x60;2025-&#x60;, ends in &#x60;.pdf&#x60; * &#x60;?corpusId&#x3D;…&amp;status&#x3D;FAILED&amp;status&#x3D;PENDING&amp;sort&#x3D;UPDATED_AT&amp;order&#x3D;ASC&#x60; — the   ingestion backlog, longest-waiting first * &#x60;?corpusId&#x3D;…&amp;tags&#x3D;legal&amp;tags&#x3D;2026&amp;tagsMatch&#x3D;ALL&#x60; — documents carrying both tags * &#x60;?corpusId&#x3D;…&amp;contentType&#x3D;application/pdf&amp;createdAfter&#x3D;2026-07-01T00:00:00Z&amp;createdBefore&#x3D;2026-10-01T00:00:00Z&amp;sort&#x3D;SIZE&amp;order&#x3D;DESC&#x60;   — last quarter&#39;s PDFs, biggest first * &#x60;?corpusId&#x3D;…&amp;contentType&#x3D;application/pdf&amp;contentType&#x3D;text/plain&amp;minSize&#x3D;1048576&#x60;   — PDFs and plain text over 1 MB * &#x60;?corpusId&#x3D;…&amp;maxSize&#x3D;0&#x60; — documents that were uploaded empty 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - A filter or paging parameter is out of bounds, or the date window is empty.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Page of matching documents.
     * @param corpusId ID of the corpus to search. (required)
     * @param q Filename pattern, case-insensitive and anchored at the start of the name: &#x60;annual&#x60; matches &#x60;Annual-Report-2025.pdf&#x60;, &#x60;report&#x60; does not. Add &#x60;*&#x60; anywhere to match elsewhere (&#x60;*report*&#x60;), at the cost of a scan over the corpus. &#x60;%&#x60; and &#x60;_&#x60; match themselves. Blank or omitted, filenames are not filtered. (optional)
     * @param tags Tag filter. Repeat for multiple values: &#x60;tags&#x3D;legal&amp;tags&#x3D;2026&#x60;. When omitted, tags are ignored. (optional)
     * @param tagsMatch How &#x60;tags&#x60; combine: &#x60;ANY&#x60; keeps documents carrying at least one of them, &#x60;ALL&#x60; only those carrying every one. Ignored without &#x60;tags&#x60;. (optional)
     * @param status Lifecycle filter. Repeat for several: &#x60;status&#x3D;PENDING&amp;status&#x3D;FAILED&#x60; matches either. When omitted, documents of all statuses are returned. (optional)
     * @param contentType MIME type filter. Repeat for several: &#x60;contentType&#x3D;application/pdf&amp;contentType&#x3D;text/plain&#x60; matches either. Values are not checked against &#x60;GET /v1/doc/accept&#x60; — an unsupported one simply matches nothing. When omitted, content types are not filtered. (optional)
     * @param lang Exact ISO-639 language code of the document. (optional)
     * @param provider Exact provider identifier, as supplied at upload time. (optional)
     * @param createdAfter Keep documents ingested at or after this instant (ISO-8601, inclusive). (optional)
     * @param createdBefore Keep documents ingested strictly before this instant (ISO-8601, exclusive). (optional)
     * @param minSize Keep documents of at least this many bytes (inclusive). Documents still awaiting upload have no size and drop out. (optional)
     * @param maxSize Keep documents of at most this many bytes (inclusive). (optional)
     * @param sort Column to sort on. Defaults to &#x60;CREATED_AT&#x60;. (optional)
     * @param order Sort direction. Defaults to &#x60;DESC&#x60; — newest, largest or alphabetically last first. (optional)
     * @param pageSize Number of items per page, 1-100. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return DocumentSearchResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public DocumentSearchResponse search1(UUID corpusId, String q, List<String> tags, String tagsMatch, List<String> status, List<String> contentType, String lang, String provider, OffsetDateTime createdAfter, OffsetDateTime createdBefore, Long minSize, Long maxSize, String sort, String order, Integer pageSize, Integer pageIndex) throws RestClientException {
        return search1WithHttpInfo(corpusId, q, tags, tagsMatch, status, contentType, lang, provider, createdAfter, createdBefore, minSize, maxSize, sort, order, pageSize, pageIndex).getBody();
    }

    /**
     * Search documents
     * Find documents in a corpus by filename, tags, lifecycle status, content type, language, provider or ingestion date, sorted the way you need them.  Every filter is optional and they **narrow together**: a request carrying none of them returns the whole corpus, one carrying several returns only the documents matching all of them. For a plain corpus listing, &#x60;GET /v1/doc/&#x60; is the simpler endpoint — this one is for finding a document you cannot scroll to.  ### Filename — &#x60;q&#x60;  Case-insensitive, and **anchored at the start** of the filename: &#x60;q&#x3D;annual&#x60; finds &#x60;Annual-Report-2025.pdf&#x60;, &#x60;q&#x3D;report&#x60; does not. Put a &#x60;*&#x60; anywhere to match elsewhere — &#x60;q&#x3D;*report&#x60; searches any position, &#x60;q&#x3D;*report*&#x60; a substring, &#x60;q&#x3D;2025-*.pdf&#x60; a name that starts with &#x60;2025-&#x60; and ends in &#x60;.pdf&#x60;.  The default is anchored because that is the shape the index can serve: an anchored pattern is a range scan, a leading &#x60;*&#x60; is a filter over the corpus. Both are correct, the first is cheaper — prefer it when your client knows how the filename begins.  &#x60;%&#x60; and &#x60;_&#x60; carry no special meaning here: they match themselves.  ### Tags — &#x60;tags&#x60;, &#x60;tagsMatch&#x60;  Repeat the parameter for several tags (&#x60;tags&#x3D;legal&amp;tags&#x3D;2026&#x60;). By default (&#x60;tagsMatch&#x3D;ANY&#x60;) a document matches when it carries **at least one** of them, which is what &#x60;GET /v1/doc/?tags&#x3D;…&#x60; does; &#x60;tagsMatch&#x3D;ALL&#x60; requires **every** one of them, extra tags on the document being fine.  ### Status — &#x60;status&#x60;  Repeatable as well, and any of the listed states matches: &#x60;status&#x3D;PENDING&amp;status&#x3D;FAILED&#x60; returns everything that is not ingested yet or needs attention.  ### Content type — &#x60;contentType&#x60;  Repeatable too, and any of the listed types matches: &#x60;contentType&#x3D;application/pdf&amp;contentType&#x3D;text/plain&#x60;. Values are taken as they come — nothing is checked against &#x60;GET /v1/doc/accept&#x60;, so a type the platform does not ingest is not an error, it simply matches no document.  ### Size — &#x60;minSize&#x60;, &#x60;maxSize&#x60;  A range on the stored size in bytes, **inclusive at both ends** and each bound independent: &#x60;minSize&#x3D;1048576&#x60; alone is \&quot;at least 1 MB\&quot;, &#x60;maxSize&#x60; alone \&quot;at most\&quot;, and &#x60;minSize&#x3D;maxSize&#x3D;N&#x60; the documents of exactly that many bytes. &#x60;minSize&#x60; above &#x60;maxSize&#x60; is refused with &#x60;400&#x60; rather than answering an empty page.  A document only has a size once its upload is committed, so setting either bound also excludes everything still &#x60;AWAITING_UPLOAD&#x60; — the same documents &#x60;sort&#x3D;SIZE&#x60; pushes to the end of the result.  ### Dates — &#x60;createdAfter&#x60;, &#x60;createdBefore&#x60;  A half-open window on the ingestion date: &#x60;createdAfter&#x60; is inclusive, &#x60;createdBefore&#x60; exclusive, so consecutive windows tile the timeline without returning a document twice. Supplying &#x60;createdAfter&#x60; at or after &#x60;createdBefore&#x60; is refused with &#x60;400&#x60; rather than answering an empty page.  ### Ordering and paging  &#x60;sort&#x60; defaults to &#x60;CREATED_AT&#x60; and &#x60;order&#x60; to &#x60;DESC&#x60; — newest first. The ordering is closed by the document id, so walking &#x60;pageIndex&#x60; never shows the same document twice nor skips one, even when many documents share a sort key. Documents whose &#x60;size&#x60; is not known yet sort last whatever the direction.  &#x60;total&#x60; counts every match across all pages, not just the ones returned here.  ### Examples  * &#x60;?corpusId&#x3D;…&amp;q&#x3D;annual-report&#x60; — every document whose name starts with it * &#x60;?corpusId&#x3D;…&amp;q&#x3D;*report*&#x60; — anywhere in the name, at the cost of a scan * &#x60;?corpusId&#x3D;…&amp;q&#x3D;2025-*.pdf&#x60; — starts with &#x60;2025-&#x60;, ends in &#x60;.pdf&#x60; * &#x60;?corpusId&#x3D;…&amp;status&#x3D;FAILED&amp;status&#x3D;PENDING&amp;sort&#x3D;UPDATED_AT&amp;order&#x3D;ASC&#x60; — the   ingestion backlog, longest-waiting first * &#x60;?corpusId&#x3D;…&amp;tags&#x3D;legal&amp;tags&#x3D;2026&amp;tagsMatch&#x3D;ALL&#x60; — documents carrying both tags * &#x60;?corpusId&#x3D;…&amp;contentType&#x3D;application/pdf&amp;createdAfter&#x3D;2026-07-01T00:00:00Z&amp;createdBefore&#x3D;2026-10-01T00:00:00Z&amp;sort&#x3D;SIZE&amp;order&#x3D;DESC&#x60;   — last quarter&#39;s PDFs, biggest first * &#x60;?corpusId&#x3D;…&amp;contentType&#x3D;application/pdf&amp;contentType&#x3D;text/plain&amp;minSize&#x3D;1048576&#x60;   — PDFs and plain text over 1 MB * &#x60;?corpusId&#x3D;…&amp;maxSize&#x3D;0&#x60; — documents that were uploaded empty 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - A filter or paging parameter is out of bounds, or the date window is empty.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Page of matching documents.
     * @param corpusId ID of the corpus to search. (required)
     * @param q Filename pattern, case-insensitive and anchored at the start of the name: &#x60;annual&#x60; matches &#x60;Annual-Report-2025.pdf&#x60;, &#x60;report&#x60; does not. Add &#x60;*&#x60; anywhere to match elsewhere (&#x60;*report*&#x60;), at the cost of a scan over the corpus. &#x60;%&#x60; and &#x60;_&#x60; match themselves. Blank or omitted, filenames are not filtered. (optional)
     * @param tags Tag filter. Repeat for multiple values: &#x60;tags&#x3D;legal&amp;tags&#x3D;2026&#x60;. When omitted, tags are ignored. (optional)
     * @param tagsMatch How &#x60;tags&#x60; combine: &#x60;ANY&#x60; keeps documents carrying at least one of them, &#x60;ALL&#x60; only those carrying every one. Ignored without &#x60;tags&#x60;. (optional)
     * @param status Lifecycle filter. Repeat for several: &#x60;status&#x3D;PENDING&amp;status&#x3D;FAILED&#x60; matches either. When omitted, documents of all statuses are returned. (optional)
     * @param contentType MIME type filter. Repeat for several: &#x60;contentType&#x3D;application/pdf&amp;contentType&#x3D;text/plain&#x60; matches either. Values are not checked against &#x60;GET /v1/doc/accept&#x60; — an unsupported one simply matches nothing. When omitted, content types are not filtered. (optional)
     * @param lang Exact ISO-639 language code of the document. (optional)
     * @param provider Exact provider identifier, as supplied at upload time. (optional)
     * @param createdAfter Keep documents ingested at or after this instant (ISO-8601, inclusive). (optional)
     * @param createdBefore Keep documents ingested strictly before this instant (ISO-8601, exclusive). (optional)
     * @param minSize Keep documents of at least this many bytes (inclusive). Documents still awaiting upload have no size and drop out. (optional)
     * @param maxSize Keep documents of at most this many bytes (inclusive). (optional)
     * @param sort Column to sort on. Defaults to &#x60;CREATED_AT&#x60;. (optional)
     * @param order Sort direction. Defaults to &#x60;DESC&#x60; — newest, largest or alphabetically last first. (optional)
     * @param pageSize Number of items per page, 1-100. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return ResponseEntity&lt;DocumentSearchResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<DocumentSearchResponse> search1WithHttpInfo(UUID corpusId, String q, List<String> tags, String tagsMatch, List<String> status, List<String> contentType, String lang, String provider, OffsetDateTime createdAfter, OffsetDateTime createdBefore, Long minSize, Long maxSize, String sort, String order, Integer pageSize, Integer pageIndex) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'corpusId' is set
        if (corpusId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'corpusId' when calling search1");
        }
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "corpusId", corpusId));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "q", q));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "tags", tags));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "tagsMatch", tagsMatch));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "status", status));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "contentType", contentType));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "lang", lang));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "provider", provider));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "createdAfter", createdAfter));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "createdBefore", createdBefore));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "minSize", minSize));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "maxSize", maxSize));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort", sort));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "order", order));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "pageSize", pageSize));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "pageIndex", pageIndex));
        

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

        ParameterizedTypeReference<DocumentSearchResponse> localReturnType = new ParameterizedTypeReference<DocumentSearchResponse>() {};
        return apiClient.invokeAPI("/v1/doc/q", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get a document&#39;s status
     * Lightweight polling endpoint. Returns the current lifecycle status, an optional message (typically a failure reason when &#x60;status &#x3D;&#x3D; FAILED&#x60;), and the last update timestamp. Cheaper than &#x60;GET /v1/doc/{id}&#x60; for polling between commit and the final &#x60;READY&#x60; or &#x60;FAILED&#x60; status.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Status returned.
     * @param id ID of the document. (required)
     * @return DocumentStatus
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public DocumentStatus status(UUID id) throws RestClientException {
        return statusWithHttpInfo(id).getBody();
    }

    /**
     * Get a document&#39;s status
     * Lightweight polling endpoint. Returns the current lifecycle status, an optional message (typically a failure reason when &#x60;status &#x3D;&#x3D; FAILED&#x60;), and the last update timestamp. Cheaper than &#x60;GET /v1/doc/{id}&#x60; for polling between commit and the final &#x60;READY&#x60; or &#x60;FAILED&#x60; status.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Status returned.
     * @param id ID of the document. (required)
     * @return ResponseEntity&lt;DocumentStatus&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<DocumentStatus> statusWithHttpInfo(UUID id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling status");
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

        String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

        ParameterizedTypeReference<DocumentStatus> localReturnType = new ParameterizedTypeReference<DocumentStatus>() {};
        return apiClient.invokeAPI("/v1/doc/{id}/status", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get a document summary
     * Return the Markdown summary generated during ingestion. Returns an empty body if the document has not been ingested yet or has no summary.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Summary returned (may be empty).
     * @param id ID of the document. (required)
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String summary(UUID id) throws RestClientException {
        return summaryWithHttpInfo(id).getBody();
    }

    /**
     * Get a document summary
     * Return the Markdown summary generated during ingestion. Returns an empty body if the document has not been ingested yet or has no summary.
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Summary returned (may be empty).
     * @param id ID of the document. (required)
     * @return ResponseEntity&lt;String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<String> summaryWithHttpInfo(UUID id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling summary");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json", "text/markdown"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

        ParameterizedTypeReference<String> localReturnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI("/v1/doc/{id}/summary", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Update a document
     * Patch the editable attributes of a document — &#x60;filename&#x60;, &#x60;docCreate&#x60;, &#x60;docUpdate&#x60;, &#x60;metadata&#x60;, &#x60;tags&#x60; and &#x60;chunk&#x60;. Only the fields present in the request body are updated; omitted fields keep their current value.  &#x60;metadata&#x60;, &#x60;tags&#x60; and &#x60;chunk&#x60; **replace** the stored value when provided — merge client-side if you want to preserve existing entries. Send &#x60;\&quot;tags\&quot;: []&#x60; to clear every tag, and &#x60;\&quot;chunk\&quot;: {}&#x60; to drop the chunking override and fall back to the platform default.  &#x60;docCreate&#x60; and &#x60;docUpdate&#x60; describe the **source** document, not the platform row: they are yours to correct, while &#x60;createdAt&#x60; and &#x60;updatedAt&#x60; remain server-managed and cannot be set here.  Every attribute is descriptive: renaming a document does not move the stored file nor re-trigger ingestion, so embeddings and previews are left untouched. Changing &#x60;chunk&#x60; likewise applies to the **next** ingestion — it does not re-chunk an already ingested document. Available in any lifecycle status. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - &#x60;filename&#x60; is blank or longer than 256 characters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Document updated.
     * @param id ID of the document to update. (required)
     * @param documentUpdateRequest  (required)
     * @return Document
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Document update1(UUID id, DocumentUpdateRequest documentUpdateRequest) throws RestClientException {
        return update1WithHttpInfo(id, documentUpdateRequest).getBody();
    }

    /**
     * Update a document
     * Patch the editable attributes of a document — &#x60;filename&#x60;, &#x60;docCreate&#x60;, &#x60;docUpdate&#x60;, &#x60;metadata&#x60;, &#x60;tags&#x60; and &#x60;chunk&#x60;. Only the fields present in the request body are updated; omitted fields keep their current value.  &#x60;metadata&#x60;, &#x60;tags&#x60; and &#x60;chunk&#x60; **replace** the stored value when provided — merge client-side if you want to preserve existing entries. Send &#x60;\&quot;tags\&quot;: []&#x60; to clear every tag, and &#x60;\&quot;chunk\&quot;: {}&#x60; to drop the chunking override and fall back to the platform default.  &#x60;docCreate&#x60; and &#x60;docUpdate&#x60; describe the **source** document, not the platform row: they are yours to correct, while &#x60;createdAt&#x60; and &#x60;updatedAt&#x60; remain server-managed and cannot be set here.  Every attribute is descriptive: renaming a document does not move the stored file nor re-trigger ingestion, so embeddings and previews are left untouched. Changing &#x60;chunk&#x60; likewise applies to the **next** ingestion — it does not re-chunk an already ingested document. Available in any lifecycle status. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - &#x60;filename&#x60; is blank or longer than 256 characters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Document updated.
     * @param id ID of the document to update. (required)
     * @param documentUpdateRequest  (required)
     * @return ResponseEntity&lt;Document&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Document> update1WithHttpInfo(UUID id, DocumentUpdateRequest documentUpdateRequest) throws RestClientException {
        Object localVarPostBody = documentUpdateRequest;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling update1");
        }
        
        // verify the required parameter 'documentUpdateRequest' is set
        if (documentUpdateRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'documentUpdateRequest' when calling update1");
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
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

        ParameterizedTypeReference<Document> localReturnType = new ParameterizedTypeReference<Document>() {};
        return apiClient.invokeAPI("/v1/doc/{id}", HttpMethod.PATCH, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
