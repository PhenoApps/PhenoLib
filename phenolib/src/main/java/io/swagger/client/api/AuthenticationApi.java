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

import io.swagger.client.model.Body;
import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;

import java.io.IOException;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthenticationApi {
    private ApiClient apiClient;

    public AuthenticationApi() {
        this(Configuration.getDefaultApiClient());
    }

    public AuthenticationApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for loginPost
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call loginPostCall(Body body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/login";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
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
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call loginPostValidateBeforeCall(Body body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = loginPostCall(body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Login
     * Implemented by: Tripal Brapi module, Cassavabase, Germinate, BMS  Used by: Flapjack, BMS  Response data types Exception: the result is not embeded in a \&quot;result\&quot; structure in order to be (one day) OAuth2 compliant. It&#x27;s also why the anwser mixes snake_case and camelCase. For login, returns a hash with the user name and the token as the value. A metadata key is also present (but usually set to null, unless an error condition occurs).  For logout, returns an empty resource. A token to remove could be provided (amdin interface) but it is not required. By default, current user token will be removed.  |Variable|Datatype|Description|Required|   |------|------|------|:-----:| | userDisplayName| string| the display name of the user | Y | | access_token | string | the access token for the session | Y | | expires_in | integer | The lifetime in seconds of the access token | Y | 
     * @param body  (optional)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void loginPost(Body body) throws ApiException {
        loginPostWithHttpInfo(body);
    }

    /**
     * Login
     * Implemented by: Tripal Brapi module, Cassavabase, Germinate, BMS  Used by: Flapjack, BMS  Response data types Exception: the result is not embeded in a \&quot;result\&quot; structure in order to be (one day) OAuth2 compliant. It&#x27;s also why the anwser mixes snake_case and camelCase. For login, returns a hash with the user name and the token as the value. A metadata key is also present (but usually set to null, unless an error condition occurs).  For logout, returns an empty resource. A token to remove could be provided (amdin interface) but it is not required. By default, current user token will be removed.  |Variable|Datatype|Description|Required|   |------|------|------|:-----:| | userDisplayName| string| the display name of the user | Y | | access_token | string | the access token for the session | Y | | expires_in | integer | The lifetime in seconds of the access token | Y | 
     * @param body  (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> loginPostWithHttpInfo(Body body) throws ApiException {
        com.squareup.okhttp.Call call = loginPostValidateBeforeCall(body, null, null);
        return apiClient.execute(call);
    }

    /**
     * Login (asynchronously)
     * Implemented by: Tripal Brapi module, Cassavabase, Germinate, BMS  Used by: Flapjack, BMS  Response data types Exception: the result is not embeded in a \&quot;result\&quot; structure in order to be (one day) OAuth2 compliant. It&#x27;s also why the anwser mixes snake_case and camelCase. For login, returns a hash with the user name and the token as the value. A metadata key is also present (but usually set to null, unless an error condition occurs).  For logout, returns an empty resource. A token to remove could be provided (amdin interface) but it is not required. By default, current user token will be removed.  |Variable|Datatype|Description|Required|   |------|------|------|:-----:| | userDisplayName| string| the display name of the user | Y | | access_token | string | the access token for the session | Y | | expires_in | integer | The lifetime in seconds of the access token | Y | 
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call loginPostAsync(Body body, final ApiCallback<Void> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = loginPostValidateBeforeCall(body, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for logoutDelete
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call logoutDeleteCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/logout";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

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
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call logoutDeleteValidateBeforeCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = logoutDeleteCall(progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Logout
     * Implemented by: Tripal Brapi module, Cassavabase, Germinate, BMS  Used by: Flapjack, BMS  For logout, returns an empty resource. A token to remove could be provided (amdin interface) but it is not required. By default, current user token will be removed.
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void logoutDelete() throws ApiException {
        logoutDeleteWithHttpInfo();
    }

    /**
     * Logout
     * Implemented by: Tripal Brapi module, Cassavabase, Germinate, BMS  Used by: Flapjack, BMS  For logout, returns an empty resource. A token to remove could be provided (amdin interface) but it is not required. By default, current user token will be removed.
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> logoutDeleteWithHttpInfo() throws ApiException {
        com.squareup.okhttp.Call call = logoutDeleteValidateBeforeCall(null, null);
        return apiClient.execute(call);
    }

    /**
     * Logout (asynchronously)
     * Implemented by: Tripal Brapi module, Cassavabase, Germinate, BMS  Used by: Flapjack, BMS  For logout, returns an empty resource. A token to remove could be provided (amdin interface) but it is not required. By default, current user token will be removed.
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call logoutDeleteAsync(final ApiCallback<Void> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = logoutDeleteValidateBeforeCall(progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
}
