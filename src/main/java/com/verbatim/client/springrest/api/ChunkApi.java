package com.verbatim.client.springrest.api;

import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.BaseApi;

import com.verbatim.client.springrest.models.AckResponse;
import com.verbatim.client.springrest.models.Chunk;
import com.verbatim.client.springrest.models.ChunkListResponse;
import com.verbatim.client.springrest.models.ChunkUpdateRequest;
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
public class ChunkApi extends BaseApi {

    public ChunkApi() {
        super(new ApiClient());
    }

    public ChunkApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Delete a chunk
     * Remove a chunk: the row and its stored text.  **This is a hard delete and it reaches further than the chunk.** Unlike a document or a session, a chunk is not soft-deleted — there is no row left underneath and nothing to restore. The links between past answers and this chunk go with it, so those answers keep their text and lose the citation pointing here.  The document itself is untouched: its file, its summary and its other chunks stay exactly as they were. What changes is that the deleted passage can no longer be retrieved, which is the point — it is how a chunk carrying content that should never have been ingested is taken out of the index without destroying the document it came from.  Re-ingesting the document (&#x60;PUT /v1/doc/{docId}/content&#x60;) rebuilds every chunk from the file, this one included. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Chunk deleted.
     * @param chunkId ID of the chunk to delete. (required)
     * @return AckResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public AckResponse delete3(UUID chunkId) throws RestClientException {
        return delete3WithHttpInfo(chunkId).getBody();
    }

    /**
     * Delete a chunk
     * Remove a chunk: the row and its stored text.  **This is a hard delete and it reaches further than the chunk.** Unlike a document or a session, a chunk is not soft-deleted — there is no row left underneath and nothing to restore. The links between past answers and this chunk go with it, so those answers keep their text and lose the citation pointing here.  The document itself is untouched: its file, its summary and its other chunks stay exactly as they were. What changes is that the deleted passage can no longer be retrieved, which is the point — it is how a chunk carrying content that should never have been ingested is taken out of the index without destroying the document it came from.  Re-ingesting the document (&#x60;PUT /v1/doc/{docId}/content&#x60;) rebuilds every chunk from the file, this one included. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Chunk deleted.
     * @param chunkId ID of the chunk to delete. (required)
     * @return ResponseEntity&lt;AckResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<AckResponse> delete3WithHttpInfo(UUID chunkId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'chunkId' is set
        if (chunkId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'chunkId' when calling delete3");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("chunkId", chunkId);

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
        return apiClient.invokeAPI("/v1/chunk/{chunkId}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get a chunk
     * Fetch one chunk with its text.  Unlike the listings, &#x60;body&#x60; is always read here — a single storage round-trip, which is what this endpoint is for. An **empty** &#x60;body&#x60; on a row that exists is not an error and is worth acting on: it means the stored object is missing, so the chunk still matches vector searches and then contributes nothing to the answer.  &#x60;hash&#x60; is the MD5 of the text as it was pushed to storage. Comparing it against the body you just read is the cheapest integrity check there is, and searching it with &#x60;GET /v1/chunk/q?hash&#x3D;…&#x60; finds every copy of the same passage in your organization. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - No chunk with this id, or its document has been deleted.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Chunk found.
     * @param chunkId ID of the chunk. (required)
     * @return Chunk
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Chunk get3(UUID chunkId) throws RestClientException {
        return get3WithHttpInfo(chunkId).getBody();
    }

    /**
     * Get a chunk
     * Fetch one chunk with its text.  Unlike the listings, &#x60;body&#x60; is always read here — a single storage round-trip, which is what this endpoint is for. An **empty** &#x60;body&#x60; on a row that exists is not an error and is worth acting on: it means the stored object is missing, so the chunk still matches vector searches and then contributes nothing to the answer.  &#x60;hash&#x60; is the MD5 of the text as it was pushed to storage. Comparing it against the body you just read is the cheapest integrity check there is, and searching it with &#x60;GET /v1/chunk/q?hash&#x3D;…&#x60; finds every copy of the same passage in your organization. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - No chunk with this id, or its document has been deleted.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Chunk found.
     * @param chunkId ID of the chunk. (required)
     * @return ResponseEntity&lt;Chunk&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Chunk> get3WithHttpInfo(UUID chunkId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'chunkId' is set
        if (chunkId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'chunkId' when calling get3");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("chunkId", chunkId);

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

        ParameterizedTypeReference<Chunk> localReturnType = new ParameterizedTypeReference<Chunk>() {};
        return apiClient.invokeAPI("/v1/chunk/{chunkId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List chunks
     * Paginate every chunk of the caller&#39;s organization.  The organization is resolved from the JWT, so there is nothing to pass and no way to ask for another tenant&#39;s chunks. A chunk belongs to an organization through its document&#39;s corpus, and it is visible exactly as long as that document is: deleting a document takes its chunks out of this API too.  Chunks come back in reading order — by document, then by the first page each one covers, then by id — so a document&#39;s chunks arrive as a contiguous block in the order they appear in the file, with its summary chunk (the one covering no page) heading the block. The id closes the ordering, so walking &#x60;pageIndex&#x60; never shows the same chunk twice nor skips one when a page split into several.  &#x60;body&#x60; is **not** included: it lives in object storage and would cost one read per row. Pass &#x60;body&#x3D;true&#x60; if you want it — the page size is then capped at 25 — or use &#x60;GET /v1/chunk/{chunkId}&#x60;, which always carries it.  To narrow the result — by corpus, document, hash, page or metadata — use &#x60;GET /v1/chunk/q&#x60;, which takes the same paging parameters. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Page of chunks.
     * @param body Include each chunk&#39;s text, read from object storage. One storage read per row — off by default. (optional, default to false)
     * @param pageSize Number of items per page, 1-100 — or 1-25 when &#x60;body&#x3D;true&#x60;. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return ChunkListResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ChunkListResponse list6(Boolean body, Integer pageSize, Integer pageIndex) throws RestClientException {
        return list6WithHttpInfo(body, pageSize, pageIndex).getBody();
    }

    /**
     * List chunks
     * Paginate every chunk of the caller&#39;s organization.  The organization is resolved from the JWT, so there is nothing to pass and no way to ask for another tenant&#39;s chunks. A chunk belongs to an organization through its document&#39;s corpus, and it is visible exactly as long as that document is: deleting a document takes its chunks out of this API too.  Chunks come back in reading order — by document, then by the first page each one covers, then by id — so a document&#39;s chunks arrive as a contiguous block in the order they appear in the file, with its summary chunk (the one covering no page) heading the block. The id closes the ordering, so walking &#x60;pageIndex&#x60; never shows the same chunk twice nor skips one when a page split into several.  &#x60;body&#x60; is **not** included: it lives in object storage and would cost one read per row. Pass &#x60;body&#x3D;true&#x60; if you want it — the page size is then capped at 25 — or use &#x60;GET /v1/chunk/{chunkId}&#x60;, which always carries it.  To narrow the result — by corpus, document, hash, page or metadata — use &#x60;GET /v1/chunk/q&#x60;, which takes the same paging parameters. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Page of chunks.
     * @param body Include each chunk&#39;s text, read from object storage. One storage read per row — off by default. (optional, default to false)
     * @param pageSize Number of items per page, 1-100 — or 1-25 when &#x60;body&#x3D;true&#x60;. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return ResponseEntity&lt;ChunkListResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ChunkListResponse> list6WithHttpInfo(Boolean body, Integer pageSize, Integer pageIndex) throws RestClientException {
        Object localVarPostBody = null;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "body", body));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "pageSize", pageSize));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "pageIndex", pageIndex));
        

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

        ParameterizedTypeReference<ChunkListResponse> localReturnType = new ParameterizedTypeReference<ChunkListResponse>() {};
        return apiClient.invokeAPI("/v1/chunk/", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Search chunks
     * Find chunks of the caller&#39;s organization by corpus, document, hash, page and metadata.  Every filter is optional and they **narrow together**: a request carrying none of them returns the whole organization — the same answer as &#x60;GET /v1/chunk/&#x60; — and one carrying several returns only the chunks matching all of them.  The organization is never a parameter. It comes from the JWT and is always applied, so no combination of filters reaches another tenant&#39;s chunks.  ### Corpus and document — &#x60;corpusId&#x60;, &#x60;documentId&#x60;  Both must belong to the caller&#39;s organization, and both are checked *before* the search runs — naming one you cannot see answers &#x60;403&#x60; on the request rather than an empty page.  ### Hash — &#x60;hash&#x60;  Exact match on the MD5 of the chunk text. Equal hashes mean equal text, so this is how the same passage is found across documents: read a chunk, then search its hash with no &#x60;documentId&#x60; to see every copy of it in your organization. Sent empty (&#x60;&amp;hash&#x3D;&#x60;) it is treated as absent.  ### Page — &#x60;page&#x60;  Keeps chunks whose span **covers** that page. A chunk is built from consecutive elements and can cross page boundaries, so one covering pages 3 to 5 answers to &#x60;page&#x3D;3&#x60;, &#x60;page&#x3D;4&#x60; and &#x60;page&#x3D;5&#x60; alike. Pages are 1-based; &#x60;page&#x3D;0&#x60; is a &#x60;400&#x60;, not an empty page. Chunks belonging to no page in particular — the document summary — carry an empty span and match no &#x60;page&#x60; filter at all.  ### Metadata — &#x60;key&#x60;/&#x60;value&#x60;, or &#x60;json&#x60;  Matches chunks whose metadata **contains** the fragment (PostgreSQL&#39;s &#x60;@&gt;&#x60; operator), extra keys on the chunk being fine. Pass &#x60;key&#x60; and &#x60;value&#x60; for a single pair — they go together, one without the other is a &#x60;400&#x60; — or &#x60;json&#x60; for a raw object when the filter is nested or has several keys. &#x60;json&#x60; wins when both are supplied. &#x60;kind&#x60; is the key the platform sets: &#x60;chunk&#x60; for a piece of the document, &#x60;summary&#x60; for the generated summary.  ### Bodies — &#x60;body&#x60;  Off by default, because including them costs one storage read per row. With &#x60;body&#x3D;true&#x60; the page size is capped at 25.  ### Examples  * &#x60;?documentId&#x3D;…&#x60; — everything one document was split into, in reading order * &#x60;?documentId&#x3D;…&amp;body&#x3D;true&amp;pageSize&#x3D;10&#x60; — the same, with the text, ten at a time * &#x60;?documentId&#x3D;…&amp;page&#x3D;4&#x60; — every chunk covering page 4, including one that   starts on page 3 * &#x60;?hash&#x3D;9e107d9d372bb6826bd81d3542a419d6&#x60; — every copy of one passage in the   organization, across documents * &#x60;?corpusId&#x3D;…&amp;key&#x3D;kind&amp;value&#x3D;summary&#x60; — the summary chunk of every document in   a corpus * &#x60;?json&#x3D;{\&quot;section\&quot;:\&quot;Article 4\&quot;}&#x60; — a metadata fragment 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - A filter is malformed, or a paging parameter is out of bounds.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Page of matching chunks.
     * @param corpusId Keep chunks whose document belongs to this corpus. Must belong to the caller&#39;s organization. (optional)
     * @param documentId Keep chunks of this document. Must belong to the caller&#39;s organization. (optional)
     * @param hash Exact MD5 of the chunk text. Blank or omitted, the hash is not filtered. (optional)
     * @param page Keep chunks whose page span covers this page. 1-based. (optional)
     * @param key Metadata key to filter on. Goes together with &#x60;value&#x60;. (optional)
     * @param value Metadata value matching &#x60;key&#x60;. (optional)
     * @param json Raw JSON object used as the containment filter. Wins over &#x60;key&#x60;/&#x60;value&#x60; when set. (optional)
     * @param body Include each chunk&#39;s text, read from object storage. One storage read per row — off by default. (optional, default to false)
     * @param pageSize Number of items per page, 1-100 — or 1-25 when &#x60;body&#x3D;true&#x60;. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return ChunkListResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ChunkListResponse search2(UUID corpusId, UUID documentId, String hash, Integer page, String key, String value, String json, Boolean body, Integer pageSize, Integer pageIndex) throws RestClientException {
        return search2WithHttpInfo(corpusId, documentId, hash, page, key, value, json, body, pageSize, pageIndex).getBody();
    }

    /**
     * Search chunks
     * Find chunks of the caller&#39;s organization by corpus, document, hash, page and metadata.  Every filter is optional and they **narrow together**: a request carrying none of them returns the whole organization — the same answer as &#x60;GET /v1/chunk/&#x60; — and one carrying several returns only the chunks matching all of them.  The organization is never a parameter. It comes from the JWT and is always applied, so no combination of filters reaches another tenant&#39;s chunks.  ### Corpus and document — &#x60;corpusId&#x60;, &#x60;documentId&#x60;  Both must belong to the caller&#39;s organization, and both are checked *before* the search runs — naming one you cannot see answers &#x60;403&#x60; on the request rather than an empty page.  ### Hash — &#x60;hash&#x60;  Exact match on the MD5 of the chunk text. Equal hashes mean equal text, so this is how the same passage is found across documents: read a chunk, then search its hash with no &#x60;documentId&#x60; to see every copy of it in your organization. Sent empty (&#x60;&amp;hash&#x3D;&#x60;) it is treated as absent.  ### Page — &#x60;page&#x60;  Keeps chunks whose span **covers** that page. A chunk is built from consecutive elements and can cross page boundaries, so one covering pages 3 to 5 answers to &#x60;page&#x3D;3&#x60;, &#x60;page&#x3D;4&#x60; and &#x60;page&#x3D;5&#x60; alike. Pages are 1-based; &#x60;page&#x3D;0&#x60; is a &#x60;400&#x60;, not an empty page. Chunks belonging to no page in particular — the document summary — carry an empty span and match no &#x60;page&#x60; filter at all.  ### Metadata — &#x60;key&#x60;/&#x60;value&#x60;, or &#x60;json&#x60;  Matches chunks whose metadata **contains** the fragment (PostgreSQL&#39;s &#x60;@&gt;&#x60; operator), extra keys on the chunk being fine. Pass &#x60;key&#x60; and &#x60;value&#x60; for a single pair — they go together, one without the other is a &#x60;400&#x60; — or &#x60;json&#x60; for a raw object when the filter is nested or has several keys. &#x60;json&#x60; wins when both are supplied. &#x60;kind&#x60; is the key the platform sets: &#x60;chunk&#x60; for a piece of the document, &#x60;summary&#x60; for the generated summary.  ### Bodies — &#x60;body&#x60;  Off by default, because including them costs one storage read per row. With &#x60;body&#x3D;true&#x60; the page size is capped at 25.  ### Examples  * &#x60;?documentId&#x3D;…&#x60; — everything one document was split into, in reading order * &#x60;?documentId&#x3D;…&amp;body&#x3D;true&amp;pageSize&#x3D;10&#x60; — the same, with the text, ten at a time * &#x60;?documentId&#x3D;…&amp;page&#x3D;4&#x60; — every chunk covering page 4, including one that   starts on page 3 * &#x60;?hash&#x3D;9e107d9d372bb6826bd81d3542a419d6&#x60; — every copy of one passage in the   organization, across documents * &#x60;?corpusId&#x3D;…&amp;key&#x3D;kind&amp;value&#x3D;summary&#x60; — the summary chunk of every document in   a corpus * &#x60;?json&#x3D;{\&quot;section\&quot;:\&quot;Article 4\&quot;}&#x60; — a metadata fragment 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - A filter is malformed, or a paging parameter is out of bounds.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Page of matching chunks.
     * @param corpusId Keep chunks whose document belongs to this corpus. Must belong to the caller&#39;s organization. (optional)
     * @param documentId Keep chunks of this document. Must belong to the caller&#39;s organization. (optional)
     * @param hash Exact MD5 of the chunk text. Blank or omitted, the hash is not filtered. (optional)
     * @param page Keep chunks whose page span covers this page. 1-based. (optional)
     * @param key Metadata key to filter on. Goes together with &#x60;value&#x60;. (optional)
     * @param value Metadata value matching &#x60;key&#x60;. (optional)
     * @param json Raw JSON object used as the containment filter. Wins over &#x60;key&#x60;/&#x60;value&#x60; when set. (optional)
     * @param body Include each chunk&#39;s text, read from object storage. One storage read per row — off by default. (optional, default to false)
     * @param pageSize Number of items per page, 1-100 — or 1-25 when &#x60;body&#x3D;true&#x60;. (optional, default to 25)
     * @param pageIndex Zero-based page index. (optional, default to 0)
     * @return ResponseEntity&lt;ChunkListResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ChunkListResponse> search2WithHttpInfo(UUID corpusId, UUID documentId, String hash, Integer page, String key, String value, String json, Boolean body, Integer pageSize, Integer pageIndex) throws RestClientException {
        Object localVarPostBody = null;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "corpusId", corpusId));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "documentId", documentId));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "hash", hash));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "key", key));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "value", value));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "json", json));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "body", body));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "pageSize", pageSize));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "pageIndex", pageIndex));
        

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

        ParameterizedTypeReference<ChunkListResponse> localReturnType = new ParameterizedTypeReference<ChunkListResponse>() {};
        return apiClient.invokeAPI("/v1/chunk/q", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Update a chunk
     * Patch a chunk&#39;s page span, metadata or text. Only the fields present in the body are applied; omitted fields keep their current value. Returns the full updated chunk, text included.  This is a **repair** endpoint. It exists so a chunk that ingestion got wrong can be corrected without re-processing the document, and it is worth knowing exactly what it does and does not do before reaching for it.  ### Rewriting &#x60;body&#x60; does not re-embed the chunk  The vector is the search index and it is not recomputed here. After patching the text, the chunk is still **retrieved for the text it used to hold** and is then handed to the model as the text it holds now. For a mangled character or a name to redact, that is exactly right — the passage means the same thing and is found the same way. For a rewrite, it is wrong: re-ingest the document instead (&#x60;PUT /v1/doc/{docId}/content&#x60;), which re-splits and re-embeds it.  &#x60;hash&#x60; is deliberately **not** recomputed either. It records the MD5 of what was embedded, so leaving it alone is what makes the divergence visible afterwards: a chunk whose &#x60;hash&#x60; no longer matches its &#x60;body&#x60; is one that has been patched.  ### &#x60;metadata&#x60; replaces, it does not merge  Send the whole object you want stored. &#x60;{}&#x60; clears it.  ### &#x60;pages&#x60; is a span  1-based page numbers, sorted and de-duplicated server-side. &#x60;[]&#x60; clears the span, which is what a chunk belonging to no page in particular carries. A value below 1 is a &#x60;400&#x60;. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - A page number is below 1.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Chunk updated.
     * @param chunkId ID of the chunk to update. (required)
     * @param chunkUpdateRequest  (required)
     * @return Chunk
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Chunk update3(UUID chunkId, ChunkUpdateRequest chunkUpdateRequest) throws RestClientException {
        return update3WithHttpInfo(chunkId, chunkUpdateRequest).getBody();
    }

    /**
     * Update a chunk
     * Patch a chunk&#39;s page span, metadata or text. Only the fields present in the body are applied; omitted fields keep their current value. Returns the full updated chunk, text included.  This is a **repair** endpoint. It exists so a chunk that ingestion got wrong can be corrected without re-processing the document, and it is worth knowing exactly what it does and does not do before reaching for it.  ### Rewriting &#x60;body&#x60; does not re-embed the chunk  The vector is the search index and it is not recomputed here. After patching the text, the chunk is still **retrieved for the text it used to hold** and is then handed to the model as the text it holds now. For a mangled character or a name to redact, that is exactly right — the passage means the same thing and is found the same way. For a rewrite, it is wrong: re-ingest the document instead (&#x60;PUT /v1/doc/{docId}/content&#x60;), which re-splits and re-embeds it.  &#x60;hash&#x60; is deliberately **not** recomputed either. It records the MD5 of what was embedded, so leaving it alone is what makes the divergence visible afterwards: a chunk whose &#x60;hash&#x60; no longer matches its &#x60;body&#x60; is one that has been patched.  ### &#x60;metadata&#x60; replaces, it does not merge  Send the whole object you want stored. &#x60;{}&#x60; clears it.  ### &#x60;pages&#x60; is a span  1-based page numbers, sorted and de-duplicated server-side. &#x60;[]&#x60; clears the span, which is what a chunk belonging to no page in particular carries. A value below 1 is a &#x60;400&#x60;. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - A page number is below 1.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Chunk updated.
     * @param chunkId ID of the chunk to update. (required)
     * @param chunkUpdateRequest  (required)
     * @return ResponseEntity&lt;Chunk&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Chunk> update3WithHttpInfo(UUID chunkId, ChunkUpdateRequest chunkUpdateRequest) throws RestClientException {
        Object localVarPostBody = chunkUpdateRequest;
        
        // verify the required parameter 'chunkId' is set
        if (chunkId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'chunkId' when calling update3");
        }
        
        // verify the required parameter 'chunkUpdateRequest' is set
        if (chunkUpdateRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'chunkUpdateRequest' when calling update3");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("chunkId", chunkId);

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

        ParameterizedTypeReference<Chunk> localReturnType = new ParameterizedTypeReference<Chunk>() {};
        return apiClient.invokeAPI("/v1/chunk/{chunkId}", HttpMethod.PATCH, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
