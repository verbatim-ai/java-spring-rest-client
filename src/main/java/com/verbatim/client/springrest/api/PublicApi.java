package com.verbatim.client.springrest.api;

import com.verbatim.client.springrest.invoker.ApiClient;
import com.verbatim.client.springrest.invoker.BaseApi;

import com.verbatim.client.springrest.models.AckResponse;
import com.verbatim.client.springrest.models.CheckResponse;
import com.verbatim.client.springrest.models.Error;

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
public class PublicApi extends BaseApi {

    public PublicApi() {
        super(new ApiClient());
    }

    public PublicApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Assert an email free from registration
     * Check if the email is unknown and can be go throw signin process
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Email is free from registration. Email with a verification code is fired. User can go throw signin process
     * @param email Email to assert (required)
     * @param turnstileToken turnstileToken owned by web client. Token delivered throw CloudFare Turnstile service (required)
     * @param languageCode Email verification code language code  (optional, default to en)
     * @return AckResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public AckResponse assertEmail(String email, String turnstileToken, String languageCode) throws RestClientException {
        return assertEmailWithHttpInfo(email, turnstileToken, languageCode).getBody();
    }

    /**
     * Assert an email free from registration
     * Check if the email is unknown and can be go throw signin process
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Email is free from registration. Email with a verification code is fired. User can go throw signin process
     * @param email Email to assert (required)
     * @param turnstileToken turnstileToken owned by web client. Token delivered throw CloudFare Turnstile service (required)
     * @param languageCode Email verification code language code  (optional, default to en)
     * @return ResponseEntity&lt;AckResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<AckResponse> assertEmailWithHttpInfo(String email, String turnstileToken, String languageCode) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'email' is set
        if (email == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'email' when calling assertEmail");
        }
        
        // verify the required parameter 'turnstileToken' is set
        if (turnstileToken == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'turnstileToken' when calling assertEmail");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("email", email);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "languageCode", languageCode));
        

        if (turnstileToken != null)
        localVarHeaderParams.add("turnstileToken", apiClient.parameterToString(turnstileToken));

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<AckResponse> localReturnType = new ParameterizedTypeReference<AckResponse>() {};
        return apiClient.invokeAPI("/pub/v1/user/assert/email/{email}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Deep health check
     * Probe every subsystem the platform depends on and report each outcome:  - **S3** — read an object back from the archive storage - **DB** — run a query on a pooled connection - **LLM** — send a prompt to the inference endpoint and require an answer  Every probe runs on every call, so one failure never hides another. The response is &#x60;200&#x60; when all of them pass and &#x60;500&#x60; as soon as one fails, which is the signal a monitoring tool alerts on; the body names the failing subsystem and carries its reason.
     * <p><b>500</b> - At least one subsystem failed its probe.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Every subsystem answered.
     * @return CheckResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CheckResponse check() throws RestClientException {
        return checkWithHttpInfo().getBody();
    }

    /**
     * Deep health check
     * Probe every subsystem the platform depends on and report each outcome:  - **S3** — read an object back from the archive storage - **DB** — run a query on a pooled connection - **LLM** — send a prompt to the inference endpoint and require an answer  Every probe runs on every call, so one failure never hides another. The response is &#x60;200&#x60; when all of them pass and &#x60;500&#x60; as soon as one fails, which is the signal a monitoring tool alerts on; the body names the failing subsystem and carries its reason.
     * <p><b>500</b> - At least one subsystem failed its probe.
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Every subsystem answered.
     * @return ResponseEntity&lt;CheckResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CheckResponse> checkWithHttpInfo() throws RestClientException {
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

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<CheckResponse> localReturnType = new ParameterizedTypeReference<CheckResponse>() {};
        return apiClient.invokeAPI("/pub/check", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Assert email verification code
     * Assert the code sent to the email
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Code is valid
     * @param email Email to assert (required)
     * @param code Email verification code (required)
     * @param turnstileToken turnstileToken owned by web client. Token delivered throw CloudFare Turnstile service (required)
     * @return AckResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public AckResponse checkVerificationCode(String email, String code, String turnstileToken) throws RestClientException {
        return checkVerificationCodeWithHttpInfo(email, code, turnstileToken).getBody();
    }

    /**
     * Assert email verification code
     * Assert the code sent to the email
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Code is valid
     * @param email Email to assert (required)
     * @param code Email verification code (required)
     * @param turnstileToken turnstileToken owned by web client. Token delivered throw CloudFare Turnstile service (required)
     * @return ResponseEntity&lt;AckResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<AckResponse> checkVerificationCodeWithHttpInfo(String email, String code, String turnstileToken) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'email' is set
        if (email == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'email' when calling checkVerificationCode");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'code' when calling checkVerificationCode");
        }
        
        // verify the required parameter 'turnstileToken' is set
        if (turnstileToken == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'turnstileToken' when calling checkVerificationCode");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("email", email);
        uriVariables.put("code", code);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        if (turnstileToken != null)
        localVarHeaderParams.add("turnstileToken", apiClient.parameterToString(turnstileToken));

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<AckResponse> localReturnType = new ParameterizedTypeReference<AckResponse>() {};
        return apiClient.invokeAPI("/pub/v1/user/assert/code/{email}/{code}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Basic ping
     * Simple open API to ping platform. Easy to use for an healthy check
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Pong.
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void ping() throws RestClientException {
        pingWithHttpInfo();
    }

    /**
     * Basic ping
     * Simple open API to ping platform. Easy to use for an healthy check
     * <p><b>500</b> - Internal error. Check body to get more info
     * <p><b>403</b> - Not authorized. Access not granted for this request
     * <p><b>404</b> - The resource referenced by the request does not exist.
     * <p><b>400</b> - The request is malformed or contains invalid parameters.
     * <p><b>409</b> - The request conflicts with the current state of the resource.
     * <p><b>415</b> - Content type not accepted by the platform. See &#x60;GET /v1/doc/accept&#x60; for the list of supported types.
     * <p><b>200</b> - Pong.
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> pingWithHttpInfo() throws RestClientException {
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

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Void> localReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/pub/ping", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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

        String[] localVarAuthNames = new String[] {  };

        return apiClient.invokeAPI(localVarPath, method, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, returnType);
    }
}
