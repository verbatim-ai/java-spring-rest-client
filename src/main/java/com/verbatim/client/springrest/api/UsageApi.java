package com.verbatim.client.springrest.api;

import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.BaseApi;

import com.verbatim.client.springrest.models.Error;
import java.util.UUID;
import com.verbatim.client.springrest.models.Usage;

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
public class UsageApi extends BaseApi {

    public UsageApi() {
        super(new ApiClient());
    }

    public UsageApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Organization usage
     * Return the aggregated usage report for the caller&#39;s organization, as headline totals and as a per-bucket time series.  Each dimension is reported as: - **tokens** — &#x60;total&#x60; (lifetime, soft-deleted included) and &#x60;inPeriod&#x60; (over the reported range). At organization scope this sums &#x60;post.token&#x60; AND &#x60;document.token&#x60; (vectorization tokens are billed at organization level). - **corpora / sessions / posts / storage** — &#x60;total&#x60;, &#x60;created&#x60; and &#x60;removed&#x60; over the range. - **storage** values are bytes. - **series** — the same &#x60;created&#x60;/&#x60;removed&#x60; deltas and a &#x60;tokens&#x60; count, bucket by bucket.  &#x60;timeframe&#x60; selects the **bucket size**, and with it how far back the report reaches:  | &#x60;timeframe&#x60; | bucket    | buckets | history      | |-------------|-----------|---------|--------------| | &#x60;Day&#x60;       | one day   | 30      | ~1 month     | | &#x60;Week&#x60;      | ISO week  | 12      | ~3 months    | | &#x60;Month&#x60;     | one month | 12      | 1 year       | | &#x60;Year&#x60;      | one year  | 5       | 5 years      |  Buckets are aligned to **UTC calendar boundaries** — midnight, Monday, the 1st of the month, the 1st of January — not measured backwards from the current instant, so two calls minutes apart return the same boundaries and two reports line up on a chart.  The report covers **completed buckets only**: the bucket in progress (today, this week, this month, this year) is left out, so &#x60;to&#x60; is the instant that bucket starts at and is never in the future, while &#x60;timestamp&#x60; is the real server time the report was computed at and is later than &#x60;to&#x60;. Activity from the current bucket counts toward the lifetime &#x60;total&#x60;s, but reaches &#x60;created&#x60;, &#x60;removed&#x60;, &#x60;inPeriod&#x60; and &#x60;series&#x60; only once that bucket closes.  &#x60;series&#x60; is contiguous and gapless — a bucket in which nothing happened is present with zeros rather than omitted — and its entries sum exactly to the top-level &#x60;created&#x60;, &#x60;removed&#x60; and &#x60;inPeriod&#x60;. Every window is half-open: &#x60;from&#x60; inclusive, &#x60;to&#x60; exclusive. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Organization usage report. The example&#39;s &#x60;series&#x60; is trimmed to three buckets for readability; a real &#x60;Day&#x60; report carries 30.
     * @param timeframe Bucket size to aggregate by, and with it how far back the report reaches. Defaults to &#x60;Day&#x60; (30 daily buckets). (optional)
     * @return Usage
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Usage usage(String timeframe) throws RestClientException {
        return usageWithHttpInfo(timeframe).getBody();
    }

    /**
     * Organization usage
     * Return the aggregated usage report for the caller&#39;s organization, as headline totals and as a per-bucket time series.  Each dimension is reported as: - **tokens** — &#x60;total&#x60; (lifetime, soft-deleted included) and &#x60;inPeriod&#x60; (over the reported range). At organization scope this sums &#x60;post.token&#x60; AND &#x60;document.token&#x60; (vectorization tokens are billed at organization level). - **corpora / sessions / posts / storage** — &#x60;total&#x60;, &#x60;created&#x60; and &#x60;removed&#x60; over the range. - **storage** values are bytes. - **series** — the same &#x60;created&#x60;/&#x60;removed&#x60; deltas and a &#x60;tokens&#x60; count, bucket by bucket.  &#x60;timeframe&#x60; selects the **bucket size**, and with it how far back the report reaches:  | &#x60;timeframe&#x60; | bucket    | buckets | history      | |-------------|-----------|---------|--------------| | &#x60;Day&#x60;       | one day   | 30      | ~1 month     | | &#x60;Week&#x60;      | ISO week  | 12      | ~3 months    | | &#x60;Month&#x60;     | one month | 12      | 1 year       | | &#x60;Year&#x60;      | one year  | 5       | 5 years      |  Buckets are aligned to **UTC calendar boundaries** — midnight, Monday, the 1st of the month, the 1st of January — not measured backwards from the current instant, so two calls minutes apart return the same boundaries and two reports line up on a chart.  The report covers **completed buckets only**: the bucket in progress (today, this week, this month, this year) is left out, so &#x60;to&#x60; is the instant that bucket starts at and is never in the future, while &#x60;timestamp&#x60; is the real server time the report was computed at and is later than &#x60;to&#x60;. Activity from the current bucket counts toward the lifetime &#x60;total&#x60;s, but reaches &#x60;created&#x60;, &#x60;removed&#x60;, &#x60;inPeriod&#x60; and &#x60;series&#x60; only once that bucket closes.  &#x60;series&#x60; is contiguous and gapless — a bucket in which nothing happened is present with zeros rather than omitted — and its entries sum exactly to the top-level &#x60;created&#x60;, &#x60;removed&#x60; and &#x60;inPeriod&#x60;. Every window is half-open: &#x60;from&#x60; inclusive, &#x60;to&#x60; exclusive. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Organization usage report. The example&#39;s &#x60;series&#x60; is trimmed to three buckets for readability; a real &#x60;Day&#x60; report carries 30.
     * @param timeframe Bucket size to aggregate by, and with it how far back the report reaches. Defaults to &#x60;Day&#x60; (30 daily buckets). (optional)
     * @return ResponseEntity&lt;Usage&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Usage> usageWithHttpInfo(String timeframe) throws RestClientException {
        Object localVarPostBody = null;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "timeframe", timeframe));
        

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

        ParameterizedTypeReference<Usage> localReturnType = new ParameterizedTypeReference<Usage>() {};
        return apiClient.invokeAPI("/v1/usage/all", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Corpus usage
     * Return the aggregated usage report for a single corpus, as headline totals and as a per-bucket time series.  Differences with the organization-scope report: - **tokens** sums &#x60;post.token&#x60; only — vectorization tokens (&#x60;document.token&#x60;) are reported only at organization scope, because they are billed against the org. - **corpora** is &#x60;null&#x60; — cardinality is always 1 at corpus scope. It is absent from the &#x60;series&#x60; entries too.  Sessions, posts and storage are restricted to the requested corpus.  &#x60;timeframe&#x60; selects the **bucket size**, and with it how far back the report reaches:  | &#x60;timeframe&#x60; | bucket    | buckets | history      | |-------------|-----------|---------|--------------| | &#x60;Day&#x60;       | one day   | 30      | ~1 month     | | &#x60;Week&#x60;      | ISO week  | 12      | ~3 months    | | &#x60;Month&#x60;     | one month | 12      | 1 year       | | &#x60;Year&#x60;      | one year  | 5       | 5 years      |  Buckets are aligned to **UTC calendar boundaries** — midnight, Monday, the 1st of the month, the 1st of January — not measured backwards from the current instant, so two calls minutes apart return the same boundaries and two reports line up on a chart.  The report covers **completed buckets only**: the bucket in progress (today, this week, this month, this year) is left out, so &#x60;to&#x60; is the instant that bucket starts at and is never in the future, while &#x60;timestamp&#x60; is the real server time the report was computed at and is later than &#x60;to&#x60;. Activity from the current bucket counts toward the lifetime &#x60;total&#x60;s, but reaches &#x60;created&#x60;, &#x60;removed&#x60;, &#x60;inPeriod&#x60; and &#x60;series&#x60; only once that bucket closes.  &#x60;series&#x60; is contiguous and gapless — a bucket in which nothing happened is present with zeros rather than omitted — and its entries sum exactly to the top-level &#x60;created&#x60;, &#x60;removed&#x60; and &#x60;inPeriod&#x60;. Every window is half-open: &#x60;from&#x60; inclusive, &#x60;to&#x60; exclusive. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Corpus usage report. The example&#39;s &#x60;series&#x60; is trimmed to two buckets for readability; a real &#x60;Week&#x60; report carries 12.
     * @param corpusId ID of the corpus to compute usage for. (required)
     * @param timeframe Bucket size to aggregate by, and with it how far back the report reaches. Defaults to &#x60;Day&#x60; (30 daily buckets). (optional)
     * @return Usage
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Usage usageByCorpus(UUID corpusId, String timeframe) throws RestClientException {
        return usageByCorpusWithHttpInfo(corpusId, timeframe).getBody();
    }

    /**
     * Corpus usage
     * Return the aggregated usage report for a single corpus, as headline totals and as a per-bucket time series.  Differences with the organization-scope report: - **tokens** sums &#x60;post.token&#x60; only — vectorization tokens (&#x60;document.token&#x60;) are reported only at organization scope, because they are billed against the org. - **corpora** is &#x60;null&#x60; — cardinality is always 1 at corpus scope. It is absent from the &#x60;series&#x60; entries too.  Sessions, posts and storage are restricted to the requested corpus.  &#x60;timeframe&#x60; selects the **bucket size**, and with it how far back the report reaches:  | &#x60;timeframe&#x60; | bucket    | buckets | history      | |-------------|-----------|---------|--------------| | &#x60;Day&#x60;       | one day   | 30      | ~1 month     | | &#x60;Week&#x60;      | ISO week  | 12      | ~3 months    | | &#x60;Month&#x60;     | one month | 12      | 1 year       | | &#x60;Year&#x60;      | one year  | 5       | 5 years      |  Buckets are aligned to **UTC calendar boundaries** — midnight, Monday, the 1st of the month, the 1st of January — not measured backwards from the current instant, so two calls minutes apart return the same boundaries and two reports line up on a chart.  The report covers **completed buckets only**: the bucket in progress (today, this week, this month, this year) is left out, so &#x60;to&#x60; is the instant that bucket starts at and is never in the future, while &#x60;timestamp&#x60; is the real server time the report was computed at and is later than &#x60;to&#x60;. Activity from the current bucket counts toward the lifetime &#x60;total&#x60;s, but reaches &#x60;created&#x60;, &#x60;removed&#x60;, &#x60;inPeriod&#x60; and &#x60;series&#x60; only once that bucket closes.  &#x60;series&#x60; is contiguous and gapless — a bucket in which nothing happened is present with zeros rather than omitted — and its entries sum exactly to the top-level &#x60;created&#x60;, &#x60;removed&#x60; and &#x60;inPeriod&#x60;. Every window is half-open: &#x60;from&#x60; inclusive, &#x60;to&#x60; exclusive. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - Corpus usage report. The example&#39;s &#x60;series&#x60; is trimmed to two buckets for readability; a real &#x60;Week&#x60; report carries 12.
     * @param corpusId ID of the corpus to compute usage for. (required)
     * @param timeframe Bucket size to aggregate by, and with it how far back the report reaches. Defaults to &#x60;Day&#x60; (30 daily buckets). (optional)
     * @return ResponseEntity&lt;Usage&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Usage> usageByCorpusWithHttpInfo(UUID corpusId, String timeframe) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'corpusId' is set
        if (corpusId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'corpusId' when calling usageByCorpus");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("corpusId", corpusId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "timeframe", timeframe));
        

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

        ParameterizedTypeReference<Usage> localReturnType = new ParameterizedTypeReference<Usage>() {};
        return apiClient.invokeAPI("/v1/usage/corpus/{corpusId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * User usage
     * Return the aggregated usage report for a single user within the caller&#39;s organization, as headline totals and as a per-bucket time series.  Scope: - **tokens** sums &#x60;post.token&#x60; of sessions where &#x60;session.user_id &#x3D; userId&#x60; AND &#x60;document.token&#x60; of documents where &#x60;document.user_id &#x3D; userId&#x60;, both restricted to corpora of the caller&#39;s organization. - **sessions** counts distinct sessions owned by &#x60;userId&#x60; in the organization. - **posts** counts posts in those sessions. - **storage** sums &#x60;document.size&#x60; of documents uploaded by &#x60;userId&#x60; in the organization. - **corpora** is &#x60;null&#x60; — cardinality is not meaningful at user scope. It is absent from the &#x60;series&#x60; entries too.  Soft-deleted rows count toward lifetime totals; the &#x60;removed&#x60; deltas detect cleanup.  &#x60;timeframe&#x60; selects the **bucket size**, and with it how far back the report reaches:  | &#x60;timeframe&#x60; | bucket    | buckets | history      | |-------------|-----------|---------|--------------| | &#x60;Day&#x60;       | one day   | 30      | ~1 month     | | &#x60;Week&#x60;      | ISO week  | 12      | ~3 months    | | &#x60;Month&#x60;     | one month | 12      | 1 year       | | &#x60;Year&#x60;      | one year  | 5       | 5 years      |  Buckets are aligned to **UTC calendar boundaries** — midnight, Monday, the 1st of the month, the 1st of January — not measured backwards from the current instant, so two calls minutes apart return the same boundaries and two reports line up on a chart.  The report covers **completed buckets only**: the bucket in progress (today, this week, this month, this year) is left out, so &#x60;to&#x60; is the instant that bucket starts at and is never in the future, while &#x60;timestamp&#x60; is the real server time the report was computed at and is later than &#x60;to&#x60;. Activity from the current bucket counts toward the lifetime &#x60;total&#x60;s, but reaches &#x60;created&#x60;, &#x60;removed&#x60;, &#x60;inPeriod&#x60; and &#x60;series&#x60; only once that bucket closes.  &#x60;series&#x60; is contiguous and gapless — a bucket in which nothing happened is present with zeros rather than omitted — and its entries sum exactly to the top-level &#x60;created&#x60;, &#x60;removed&#x60; and &#x60;inPeriod&#x60;. Every window is half-open: &#x60;from&#x60; inclusive, &#x60;to&#x60; exclusive. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - User usage report. The example&#39;s &#x60;series&#x60; is trimmed to two buckets for readability; a real &#x60;Month&#x60; report carries 12.
     * @param userId ID of the user to compute usage for. Free-form string (max 256 chars), matched against &#x60;session.user_id&#x60; and &#x60;document.user_id&#x60;. (required)
     * @param timeframe Bucket size to aggregate by, and with it how far back the report reaches. Defaults to &#x60;Day&#x60; (30 daily buckets). (optional)
     * @return Usage
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Usage usageByUser(String userId, String timeframe) throws RestClientException {
        return usageByUserWithHttpInfo(userId, timeframe).getBody();
    }

    /**
     * User usage
     * Return the aggregated usage report for a single user within the caller&#39;s organization, as headline totals and as a per-bucket time series.  Scope: - **tokens** sums &#x60;post.token&#x60; of sessions where &#x60;session.user_id &#x3D; userId&#x60; AND &#x60;document.token&#x60; of documents where &#x60;document.user_id &#x3D; userId&#x60;, both restricted to corpora of the caller&#39;s organization. - **sessions** counts distinct sessions owned by &#x60;userId&#x60; in the organization. - **posts** counts posts in those sessions. - **storage** sums &#x60;document.size&#x60; of documents uploaded by &#x60;userId&#x60; in the organization. - **corpora** is &#x60;null&#x60; — cardinality is not meaningful at user scope. It is absent from the &#x60;series&#x60; entries too.  Soft-deleted rows count toward lifetime totals; the &#x60;removed&#x60; deltas detect cleanup.  &#x60;timeframe&#x60; selects the **bucket size**, and with it how far back the report reaches:  | &#x60;timeframe&#x60; | bucket    | buckets | history      | |-------------|-----------|---------|--------------| | &#x60;Day&#x60;       | one day   | 30      | ~1 month     | | &#x60;Week&#x60;      | ISO week  | 12      | ~3 months    | | &#x60;Month&#x60;     | one month | 12      | 1 year       | | &#x60;Year&#x60;      | one year  | 5       | 5 years      |  Buckets are aligned to **UTC calendar boundaries** — midnight, Monday, the 1st of the month, the 1st of January — not measured backwards from the current instant, so two calls minutes apart return the same boundaries and two reports line up on a chart.  The report covers **completed buckets only**: the bucket in progress (today, this week, this month, this year) is left out, so &#x60;to&#x60; is the instant that bucket starts at and is never in the future, while &#x60;timestamp&#x60; is the real server time the report was computed at and is later than &#x60;to&#x60;. Activity from the current bucket counts toward the lifetime &#x60;total&#x60;s, but reaches &#x60;created&#x60;, &#x60;removed&#x60;, &#x60;inPeriod&#x60; and &#x60;series&#x60; only once that bucket closes.  &#x60;series&#x60; is contiguous and gapless — a bucket in which nothing happened is present with zeros rather than omitted — and its entries sum exactly to the top-level &#x60;created&#x60;, &#x60;removed&#x60; and &#x60;inPeriod&#x60;. Every window is half-open: &#x60;from&#x60; inclusive, &#x60;to&#x60; exclusive. 
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>200</b> - User usage report. The example&#39;s &#x60;series&#x60; is trimmed to two buckets for readability; a real &#x60;Month&#x60; report carries 12.
     * @param userId ID of the user to compute usage for. Free-form string (max 256 chars), matched against &#x60;session.user_id&#x60; and &#x60;document.user_id&#x60;. (required)
     * @param timeframe Bucket size to aggregate by, and with it how far back the report reaches. Defaults to &#x60;Day&#x60; (30 daily buckets). (optional)
     * @return ResponseEntity&lt;Usage&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Usage> usageByUserWithHttpInfo(String userId, String timeframe) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'userId' when calling usageByUser");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("userId", userId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "timeframe", timeframe));
        

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

        ParameterizedTypeReference<Usage> localReturnType = new ParameterizedTypeReference<Usage>() {};
        return apiClient.invokeAPI("/v1/usage/user/{userId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
