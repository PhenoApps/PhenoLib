/*
 * BrAPI
 * The Breeding API (BrAPI) is a Standardized RESTful Web Service API Specification for communicating Plant Breeding Data. BrAPI allows for easy data sharing between databases and tools involved in plant breeding.  <strong>General Reference Documentation</strong>  <a href=\"https://github.com/plantbreeding/API/blob/master/Specification/GeneralInfo/URL_Structure.md\">URL Structure</a>  <a href=\"https://github.com/plantbreeding/API/blob/master/Specification/GeneralInfo/Response_Structure.md\">Response Structure</a>  <a href=\"https://github.com/plantbreeding/API/blob/master/Specification/GeneralInfo/Date_Time_Encoding.md\">Date/Time Encoding</a>  <a href=\"https://github.com/plantbreeding/API/blob/master/Specification/GeneralInfo/Location_Encoding.md\">Location Encoding</a>  <a href=\"https://github.com/plantbreeding/API/blob/master/Specification/GeneralInfo/Error_Handling.md\">Error Handling</a>  <a href=\"https://github.com/plantbreeding/API/blob/master/Specification/GeneralInfo/Search_Services.md\">Search Services</a>  <a href=\"https://github.com/plantbreeding/API/blob/master/Specification/GeneralInfo/Asychronous_Processing.md\">Asynchronous Processing</a>
 *
 * OpenAPI spec version: 1.3
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.api;

import io.swagger.client.model.CallsResponse;
import io.swagger.client.model.WSMIMEDataTypes;
import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CallsApi {
    private ApiClient apiClient;

    public CallsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public CallsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for callsGet
     * @param datatype DEPRECATED in v1.3 - see dataType (camel case) (optional)
     * @param dataType The data format supported by the call. Example: &#x60;json&#x60; (optional)
     * @param page Which result page is requested. The page indexing starts at 0 (the first page is &#x27;page&#x27;&#x3D; 0). Default is &#x60;0&#x60;. (optional)
     * @param pageSize The size of the pages to be returned. Default is &#x60;1000&#x60;. (optional)
     * @param authorization HTTP HEADER - Token used for Authorization   &lt;strong&gt;Bearer {token_string} &lt;/strong&gt; (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call callsGetCall(String datatype, WSMIMEDataTypes dataType, Integer page, Integer pageSize, String authorization, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/calls";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (datatype != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("datatype", datatype));
        if (dataType != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("dataType", dataType));
        if (page != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("page", page));
        if (pageSize != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("pageSize", pageSize));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (authorization != null)
        localVarHeaderParams.put("Authorization", apiClient.parameterToString(authorization));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "AuthorizationToken" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call callsGetValidateBeforeCall(String datatype, WSMIMEDataTypes dataType, Integer page, Integer pageSize, String authorization, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = callsGetCall(datatype, dataType, page, pageSize, authorization, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get the list of implemented Calls
     *  Implementation Notes Having a consistent structure for the path string of each call is very important for teams to be able to connect and find errors. Read more on Github. Here are the rules for the path of each call that should be returned    Every word in the call path should match the documentation exactly, both in spelling and capitalization. Note that path strings are all lower case, but path parameters are camel case.  Each path should start relative to \&quot;/\&quot; and therefore should not include \&quot;/\&quot;  No leading or trailing slashes (\&quot;/\&quot;)   Path parameters are wrapped in curly braces (\&quot;{}\&quot;). The name of the path parameter should be spelled exactly as it is specified in the documentation.     Examples GOOD    \&quot;call\&quot;: \&quot;germplasm/{germplasmDbId}/markerprofiles\&quot; BAD    \&quot;call\&quot;: \&quot;germplasm/{id}/markerprofiles\&quot; BAD    \&quot;call\&quot;: \&quot;germplasm/{germplasmDbId}/markerProfiles\&quot; BAD    \&quot;call\&quot;: \&quot;germplasm/{germplasmdbid}/markerprofiles\&quot; BAD    \&quot;call\&quot;: \&quot;brapi/v1/germplasm/{germplasmDbId}/markerprofiles\&quot; BAD    \&quot;call\&quot;: \&quot;/germplasm/{germplasmDbId}/markerprofiles/\&quot; BAD    \&quot;call\&quot;: \&quot;germplasm/&lt;germplasmDbId&gt;/markerprofiles\&quot;    test-server.brapi.org/brapi/v1/calls
     * @param datatype DEPRECATED in v1.3 - see dataType (camel case) (optional)
     * @param dataType The data format supported by the call. Example: &#x60;json&#x60; (optional)
     * @param page Which result page is requested. The page indexing starts at 0 (the first page is &#x27;page&#x27;&#x3D; 0). Default is &#x60;0&#x60;. (optional)
     * @param pageSize The size of the pages to be returned. Default is &#x60;1000&#x60;. (optional)
     * @param authorization HTTP HEADER - Token used for Authorization   &lt;strong&gt;Bearer {token_string} &lt;/strong&gt; (optional)
     * @return CallsResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CallsResponse callsGet(String datatype, WSMIMEDataTypes dataType, Integer page, Integer pageSize, String authorization) throws ApiException {
        ApiResponse<CallsResponse> resp = callsGetWithHttpInfo(datatype, dataType, page, pageSize, authorization);
        return resp.getData();
    }

    /**
     * Get the list of implemented Calls
     *  Implementation Notes Having a consistent structure for the path string of each call is very important for teams to be able to connect and find errors. Read more on Github. Here are the rules for the path of each call that should be returned    Every word in the call path should match the documentation exactly, both in spelling and capitalization. Note that path strings are all lower case, but path parameters are camel case.  Each path should start relative to \&quot;/\&quot; and therefore should not include \&quot;/\&quot;  No leading or trailing slashes (\&quot;/\&quot;)   Path parameters are wrapped in curly braces (\&quot;{}\&quot;). The name of the path parameter should be spelled exactly as it is specified in the documentation.     Examples GOOD    \&quot;call\&quot;: \&quot;germplasm/{germplasmDbId}/markerprofiles\&quot; BAD    \&quot;call\&quot;: \&quot;germplasm/{id}/markerprofiles\&quot; BAD    \&quot;call\&quot;: \&quot;germplasm/{germplasmDbId}/markerProfiles\&quot; BAD    \&quot;call\&quot;: \&quot;germplasm/{germplasmdbid}/markerprofiles\&quot; BAD    \&quot;call\&quot;: \&quot;brapi/v1/germplasm/{germplasmDbId}/markerprofiles\&quot; BAD    \&quot;call\&quot;: \&quot;/germplasm/{germplasmDbId}/markerprofiles/\&quot; BAD    \&quot;call\&quot;: \&quot;germplasm/&lt;germplasmDbId&gt;/markerprofiles\&quot;    test-server.brapi.org/brapi/v1/calls
     * @param datatype DEPRECATED in v1.3 - see dataType (camel case) (optional)
     * @param dataType The data format supported by the call. Example: &#x60;json&#x60; (optional)
     * @param page Which result page is requested. The page indexing starts at 0 (the first page is &#x27;page&#x27;&#x3D; 0). Default is &#x60;0&#x60;. (optional)
     * @param pageSize The size of the pages to be returned. Default is &#x60;1000&#x60;. (optional)
     * @param authorization HTTP HEADER - Token used for Authorization   &lt;strong&gt;Bearer {token_string} &lt;/strong&gt; (optional)
     * @return ApiResponse&lt;CallsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CallsResponse> callsGetWithHttpInfo(String datatype, WSMIMEDataTypes dataType, Integer page, Integer pageSize, String authorization) throws ApiException {
        com.squareup.okhttp.Call call = callsGetValidateBeforeCall(datatype, dataType, page, pageSize, authorization, null, null);
        Type localVarReturnType = new TypeToken<CallsResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get the list of implemented Calls (asynchronously)
     *  Implementation Notes Having a consistent structure for the path string of each call is very important for teams to be able to connect and find errors. Read more on Github. Here are the rules for the path of each call that should be returned    Every word in the call path should match the documentation exactly, both in spelling and capitalization. Note that path strings are all lower case, but path parameters are camel case.  Each path should start relative to \&quot;/\&quot; and therefore should not include \&quot;/\&quot;  No leading or trailing slashes (\&quot;/\&quot;)   Path parameters are wrapped in curly braces (\&quot;{}\&quot;). The name of the path parameter should be spelled exactly as it is specified in the documentation.     Examples GOOD    \&quot;call\&quot;: \&quot;germplasm/{germplasmDbId}/markerprofiles\&quot; BAD    \&quot;call\&quot;: \&quot;germplasm/{id}/markerprofiles\&quot; BAD    \&quot;call\&quot;: \&quot;germplasm/{germplasmDbId}/markerProfiles\&quot; BAD    \&quot;call\&quot;: \&quot;germplasm/{germplasmdbid}/markerprofiles\&quot; BAD    \&quot;call\&quot;: \&quot;brapi/v1/germplasm/{germplasmDbId}/markerprofiles\&quot; BAD    \&quot;call\&quot;: \&quot;/germplasm/{germplasmDbId}/markerprofiles/\&quot; BAD    \&quot;call\&quot;: \&quot;germplasm/&lt;germplasmDbId&gt;/markerprofiles\&quot;    test-server.brapi.org/brapi/v1/calls
     * @param datatype DEPRECATED in v1.3 - see dataType (camel case) (optional)
     * @param dataType The data format supported by the call. Example: &#x60;json&#x60; (optional)
     * @param page Which result page is requested. The page indexing starts at 0 (the first page is &#x27;page&#x27;&#x3D; 0). Default is &#x60;0&#x60;. (optional)
     * @param pageSize The size of the pages to be returned. Default is &#x60;1000&#x60;. (optional)
     * @param authorization HTTP HEADER - Token used for Authorization   &lt;strong&gt;Bearer {token_string} &lt;/strong&gt; (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call callsGetAsync(String datatype, WSMIMEDataTypes dataType, Integer page, Integer pageSize, String authorization, final ApiCallback<CallsResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = callsGetValidateBeforeCall(datatype, dataType, page, pageSize, authorization, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CallsResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
