/*
 * BrAPI
 * The Breeding API (BrAPI) is a Standardized RESTful Web Service API Specification for
 * communicating Plant Breeding Data. BrAPI allows for easy data sharing between databases and tools
 * involved in plant breeding.  <strong>General Reference Documentation</strong>
 * <a href=\"https://github.com/plantbreeding/API/blob/master/Specification/GeneralInfo/URL_Structure.md\">URL Structure</a>
 * <a href=\"https://github.com/plantbreeding/API/blob/master/Specification/GeneralInfo/Response_Structure.md\">Response Structure</a>
 * <a href=\"https://github.com/plantbreeding/API/blob/master/Specification/GeneralInfo/Date_Time_Encoding.md\">Date/Time Encoding</a>
 * <a href=\"https://github.com/plantbreeding/API/blob/master/Specification/GeneralInfo/Location_Encoding.md\">Location Encoding</a>
 * <a href=\"https://github.com/plantbreeding/API/blob/master/Specification/GeneralInfo/Error_Handling.md\">Error Handling</a>
 * <a href=\"https://github.com/plantbreeding/API/blob/master/Specification/GeneralInfo/Search_Services.md\">Search Services</a>
 * <a href=\"https://github.com/plantbreeding/API/blob/master/Specification/GeneralInfo/Asychronous_Processing.md\">Asynchronous Processing</a>
 *
 * OpenAPI spec version: 1.2
 */
package io.swagger.client;

@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
public class ApiInvoker extends java.lang.Object
{
    // region Fields
    // region Static Fields
    /** Content type "text/plain" with UTF-8 encoding. */
    public static final org.apache.http.entity.ContentType TEXT_PLAIN_UTF8 =
        org.apache.http.entity.ContentType.create(
            "text/plain", org.apache.http.Consts.UTF_8);

    /**
     * ISO 8601 date time format.
     * @see <a href="https://en.wikipedia.org/wiki/ISO_8601">https://en.wikipedia.org/wiki/ISO_8601</a>
     */
    public static final java.text.SimpleDateFormat DATE_TIME_FORMAT =
        new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    /**
     * ISO 8601 date format.
     * @see <a href="https://en.wikipedia.org/wiki/ISO_8601">https://en.wikipedia.org/wiki/ISO_8601</a>
     */
    public static final java.text.SimpleDateFormat DATE_FORMAT =
        new java.text.SimpleDateFormat("yyyy-MM-dd");

    private static io.swagger.client.ApiInvoker INSTANCE;                               // singleton
    // endregion

    // region Instance Fields
    private com.android.volley.RequestQueue requestQueue     ;
    private int                             connectionTimeout;

    @java.lang.SuppressWarnings({"Convert2Diamond"})
    private final java.util.Map<java.lang.String, java.lang.String> defaultHeaderMap =
        new java.util.HashMap<java.lang.String, java.lang.String>();
    private java.util.Map<java.lang.String, io.swagger.client.auth.Authentication> authentications;
    // endregion
    // endregion

    // region Private Methods
    private void startQueue(final com.android.volley.Cache cache,
    final com.android.volley.Network network)
    {
        this.requestQueue = new com.android.volley.RequestQueue(cache, network);
        this.requestQueue.start();
    }

    private void startQueue(final com.android.volley.Cache cache,
    final com.android.volley.Network network, final int threadPoolSize,
    final com.android.volley.ResponseDelivery delivery)
    {
        this.requestQueue =
            new com.android.volley.RequestQueue(cache, network, threadPoolSize, delivery);
        this.requestQueue.start();
    }

    /**
     * Update query and header parameters based on authentication settings.
     *
     * @param authNames The authentications to apply
     */
    private void updateParamsForAuth(
    final java.lang.String                                  authNames[] ,
    final java.util.List<io.swagger.client.Pair>            queryParams ,
    final java.util.Map<java.lang.String, java.lang.String> headerParams)
    {
        for (final java.lang.String authName: authNames)
        {
            final io.swagger.client.auth.Authentication authentication =
                this.authentications.get(authName);
            if (null == authentication)
                throw new java.lang.RuntimeException("Authentication undefined: " + authName);
            else
                authentication.applyToParams(queryParams, headerParams);
        }
    }
    // endregion

    // region Constructors
    static
    {
        // Use UTC as the default time zone.
        final java.util.TimeZone UTCTimeZone = java.util.TimeZone.getTimeZone("UTC");
        io.swagger.client.ApiInvoker.DATE_TIME_FORMAT.setTimeZone(UTCTimeZone);
        io.swagger.client.ApiInvoker.DATE_FORMAT.setTimeZone     (UTCTimeZone);
    }

    private ApiInvoker(
          com.android.volley.Cache            cache            ,
          com.android.volley.Network          network          ,
    final int                                 threadPoolSize   ,
    final com.android.volley.ResponseDelivery delivery         ,
    final int                                 connectionTimeout)
    {
        super();

        if (null == cache  ) cache   = new com.android.volley.toolbox.NoCache();
        if (null == network) network =
            new com.android.volley.toolbox.BasicNetwork(new com.android.volley.toolbox.HurlStack());

        if (null == delivery)
            this.startQueue(cache, network);
        else
            this.startQueue(cache, network, threadPoolSize, delivery);

        this.setConnectionTimeout(connectionTimeout);
    }
    // endregion

    // region Public Methods
    // region Static Public Methods
    public static void setUserAgent(final java.lang.String userAgent)
    { io.swagger.client.ApiInvoker.INSTANCE.addDefaultHeader("User-Agent", userAgent); }

    public static java.util.Date parseDateTime(final java.lang.String str)
    {
        try { return io.swagger.client.ApiInvoker.DATE_TIME_FORMAT.parse(str); }
        catch (final java.text.ParseException e) { throw new java.lang.RuntimeException(e); }
    }

    public static java.util.Date parseDate(final java.lang.String str)
    {
        try { return io.swagger.client.ApiInvoker.DATE_FORMAT.parse(str); }
        catch (final java.text.ParseException e) { throw new java.lang.RuntimeException(e); }
    }

    public static java.lang.String formatDateTime(final java.util.Date datetime)
    { return io.swagger.client.ApiInvoker.DATE_TIME_FORMAT.format(datetime); }

    public static java.lang.String formatDate(final java.util.Date date)
    { return io.swagger.client.ApiInvoker.DATE_FORMAT.format(date); }

    public static java.lang.String parameterToString(final java.lang.Object param)
    {
        if (null == param)
          return "";
        else
            if (param instanceof java.util.Date)
                return io.swagger.client.ApiInvoker.formatDateTime((java.util.Date) param);
            else
                if (param instanceof java.util.Collection)
                {
                    final java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder();
                    for (final java.lang.Object object: (java.util.Collection) param)
                    {
                        if (stringBuilder.length() > 0) stringBuilder.append(",");
                        stringBuilder.append(java.lang.String.valueOf(object));
                    }
                    return stringBuilder.toString();
                }
                else return java.lang.String.valueOf(param);
    }

    /** Format to {@code Pair} objects. */
    public static java.util.List<io.swagger.client.Pair> parameterToPairs(
          java.lang.String collectionFormat,
    final java.lang.String name            ,
    final java.lang.Object value           )
    {
        // noinspection Convert2Diamond
        final java.util.List<io.swagger.client.Pair> result =
            new java.util.ArrayList<io.swagger.client.Pair>();

        // preconditions
        if (null == name || name.isEmpty() || null == value) return result;

        final java.util.Collection valueCollection;
        if (value instanceof java.util.Collection)
            valueCollection = (java.util.Collection) value;
        else
        {
            result.add(new io.swagger.client.Pair(
                name, io.swagger.client.ApiInvoker.parameterToString(value)));
            return result;
        }

        if (valueCollection.isEmpty()) return result;

        // get the collection format
        collectionFormat = null == collectionFormat || collectionFormat.isEmpty() ?
            "csv" : collectionFormat;                                                // default: csv

        // create the result based on the collection format
        if (collectionFormat.equals("multi"))
        {
            for (final java.lang.Object item: valueCollection)
                result.add(new io.swagger.client.Pair(
                    name, io.swagger.client.ApiInvoker.parameterToString(item)));
            return result;
        }

        final java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder();
        {
            final java.lang.String delimiter;
            switch (collectionFormat)
            {
                case "ssv"  : delimiter = " " ; break;
                case "tsv"  : delimiter = "\t"; break;
                case "pipes": delimiter = "|" ; break;
                default     : delimiter = "," ; break;
            }

            for (final java.lang.Object item: valueCollection) stringBuilder.append(delimiter)
                .append(io.swagger.client.ApiInvoker.parameterToString(item));
        }
        result.add(new io.swagger.client.Pair(name, stringBuilder.substring(1)));
        return result;
    }

    public static void initializeInstance()
    { io.swagger.client.ApiInvoker.initializeInstance(null); }

    public static void initializeInstance(final com.android.volley.Cache cache)
    {
        io.swagger.client.ApiInvoker.initializeInstance(
            cache,null,0,null,30);
    }

    public static void initializeInstance(
    final com.android.volley.Cache            cache            ,
    final com.android.volley.Network          network          ,
    final int                                 threadPoolSize   ,
    final com.android.volley.ResponseDelivery delivery         ,
    final int                                 connectionTimeout)
    {
        io.swagger.client.ApiInvoker.INSTANCE = new io.swagger.client.ApiInvoker(
            cache, network, threadPoolSize, delivery, connectionTimeout);
        io.swagger.client.ApiInvoker.setUserAgent("Swagger-Codegen/1.0.0/android");

        // Setup authentications (key: authentication name, value: authentication).
        // noinspection Convert2Diamond
        io.swagger.client.ApiInvoker.INSTANCE.authentications =
            new java.util.HashMap<java.lang.String, io.swagger.client.auth.Authentication>();

        // Prevent the authentications from being modified.
        io.swagger.client.ApiInvoker.INSTANCE.authentications =
            java.util.Collections.unmodifiableMap(
                io.swagger.client.ApiInvoker.INSTANCE.authentications);
    }

    public static io.swagger.client.ApiInvoker getInstance()
    {
        if (null == io.swagger.client.ApiInvoker.INSTANCE)
            io.swagger.client.ApiInvoker.initializeInstance();
        return io.swagger.client.ApiInvoker.INSTANCE;
    }

    public static java.lang.Object deserialize(
    final java.lang.String json         ,
    final java.lang.String containerType,
    final java.lang.Class  cls          ) throws io.swagger.client.ApiException
    {
        try
        {
            if (containerType.equalsIgnoreCase("list" )
            ||  containerType.equalsIgnoreCase("array"))
                return io.swagger.client.JsonUtil.deserializeToList(json, cls);
            else
                if (cls.equals(java.lang.String.class))
                    if (null != json        && json.startsWith("\"")
                    &&  json.endsWith("\"") && json.length() > 1    )
                        return json.substring(1, json.length() - 1);
                    else
                        return json;
                else
                    return io.swagger.client.JsonUtil.deserializeToObject(json, cls);
        }
        catch (final com.google.gson.JsonParseException e)
        { throw new io.swagger.client.ApiException(500, e.getMessage()); }
    }

    public static java.lang.String serialize(final java.lang.Object obj)
    throws io.swagger.client.ApiException
    {
        try { return null == obj ? null : io.swagger.client.JsonUtil.serialize(obj); }
        catch (final java.lang.Exception e)
        { throw new io.swagger.client.ApiException(500, e.getMessage()); }
    }
    // endregion

    // region Instance Public Methods
    public void addDefaultHeader(final java.lang.String key, final java.lang.String value)
    { this.defaultHeaderMap.put(key, value); }

    public java.lang.String escapeString(final java.lang.String str)
    {
        try { return java.net.URLEncoder.encode(str,"UTF-8"); }
        catch (final java.io.UnsupportedEncodingException e) { return str; }
    }

    /** Get authentications (key: authentication name, value: authentication). */
    public java.util.Map<java.lang.String, io.swagger.client.auth.Authentication>
    getAuthentications() { return this.authentications; }

    /**
     * Get authentication for the given name.
     *
     * @param authName The authentication name
     * @return The authentication, null if not found
     */
    public io.swagger.client.auth.Authentication getAuthentication(final java.lang.String authName)
    { return this.authentications.get(authName); }

    /** Helper method to set username for the first HTTP basic authentication. */
    public void setUsername(final java.lang.String username)
    {
        for (final io.swagger.client.auth.Authentication authentication:
        this.authentications.values())
            if (authentication instanceof io.swagger.client.auth.HttpBasicAuth)
            {
                ((io.swagger.client.auth.HttpBasicAuth) authentication).setUsername(username);
                return;
            }
        throw new java.lang.RuntimeException("No HTTP basic authentication configured!");
    }

    /** Helper method to set password for the first HTTP basic authentication. */
    public void setPassword(final java.lang.String password)
    {
        for (final io.swagger.client.auth.Authentication authentication:
        this.authentications.values())
            if (authentication instanceof io.swagger.client.auth.HttpBasicAuth)
            {
                ((io.swagger.client.auth.HttpBasicAuth) authentication).setPassword(password);
                return;
            }
        throw new java.lang.RuntimeException("No HTTP basic authentication configured!");
    }

    /** Helper method to set API key value for the first API key authentication. */
    public void setApiKey(final java.lang.String apiKey)
    {
        for (final io.swagger.client.auth.Authentication authentication:
        this.authentications.values())
            if (authentication instanceof io.swagger.client.auth.ApiKeyAuth)
            {
                ((io.swagger.client.auth.ApiKeyAuth) authentication).setApiKey(apiKey);
                return;
            }
        throw new java.lang.RuntimeException("No API key authentication configured!");
    }

    /** Helper method to set API key prefix for the first API key authentication. */
    public void setApiKeyPrefix(final java.lang.String apiKeyPrefix)
    {
        for (final io.swagger.client.auth.Authentication authentication:
        this.authentications.values())
            if (authentication instanceof io.swagger.client.auth.ApiKeyAuth)
            {
                ((io.swagger.client.auth.ApiKeyAuth) authentication).setApiKeyPrefix(apiKeyPrefix);
                return;
            }
        throw new java.lang.RuntimeException("No API key authentication configured!");
    }

    public void setConnectionTimeout(final int connectionTimeout)
    { this.connectionTimeout = connectionTimeout; }

    public int getConnectionTimeout() { return this.connectionTimeout; }

    public java.lang.String invokeAPI(
    final java.lang.String                                  host        ,
    final java.lang.String                                  path        ,
    final java.lang.String                                  method      ,
    final java.util.List<io.swagger.client.Pair>            queryParams ,
    final java.lang.Object                                  body        ,
    final java.util.Map<java.lang.String, java.lang.String> headerParams,
    final java.util.Map<java.lang.String, java.lang.String> formParams  ,
    final java.lang.String                                  contentType ,
    final java.lang.String                                  authNames[] ) throws
    io.swagger.client.ApiException         , java.lang.InterruptedException       ,
    java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException
    {
        try
        {
            final com.android.volley.toolbox.RequestFuture<java.lang.String> requestFuture =
                com.android.volley.toolbox.RequestFuture.newFuture();
            final com.android.volley.Request request = this.createRequest(host, path, method,
                queryParams, body, headerParams, formParams, contentType, authNames, requestFuture,
                requestFuture);
            if (null != request)
            {
                this.requestQueue.add(request);
                return requestFuture.get(this.connectionTimeout,
                    java.util.concurrent.TimeUnit.SECONDS);
            }
            else return "no data";
        }
        catch (final java.io.UnsupportedEncodingException e)
        { throw new io.swagger.client.ApiException(0, "UnsupportedEncodingException"); }
    }

    public void invokeAPI(
    final java.lang.String                                       host        ,
    final java.lang.String                                       path        ,
    final java.lang.String                                       method      ,
    final java.util.List<io.swagger.client.Pair>                 queryParams ,
    final java.lang.Object                                       body        ,
    final java.util.Map<java.lang.String, java.lang.String>      headerParams,
    final java.util.Map<java.lang.String, java.lang.String>      formParams  ,
    final java.lang.String                                       contentType ,
    final java.lang.String                                       authNames[] ,
    final com.android.volley.Response.Listener<java.lang.String> stringRequest,
    final com.android.volley.Response.ErrorListener              errorListener)
    throws io.swagger.client.ApiException
    {
        try
        {
          final com.android.volley.Request request = this.createRequest(host, path, method,
              queryParams, body, headerParams, formParams, contentType, authNames, stringRequest,
              errorListener);
          if (null != request) this.requestQueue.add(request);
        }
        catch (final java.io.UnsupportedEncodingException e)
        { throw new io.swagger.client.ApiException(0, "UnsupportedEncodingException"); }
    }

    public com.android.volley.Request<java.lang.String> createRequest(
    final java.lang.String                                       host         ,
    final java.lang.String                                       path         ,
    final java.lang.String                                       method       ,
    final java.util.List<io.swagger.client.Pair>                 queryParams  ,
    final java.lang.Object                                       body         ,
    final java.util.Map<java.lang.String, java.lang.String>      headerParams ,
    final java.util.Map<java.lang.String, java.lang.String>      formParams   ,
    final java.lang.String                                       contentType  ,
    final java.lang.String                                       authNames[]  ,
    final com.android.volley.Response.Listener<java.lang.String> stringRequest,
    final com.android.volley.Response.ErrorListener              errorListener)
    throws io.swagger.client.ApiException, java.io.UnsupportedEncodingException
    {
        final com.android.volley.Request<java.lang.String> result;
        // region Create result.
        {
            final java.lang.String url;
            {
                final java.lang.String queryString;
                {
                    final java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder("?");
                    this.updateParamsForAuth(authNames, queryParams, headerParams);
                    if (null != queryParams)
                        for (final io.swagger.client.Pair queryParam: queryParams)
                            if (!queryParam.getName().isEmpty())
                                stringBuilder.append(this.escapeString(queryParam.getName()))
                                    .append("=").append(this.escapeString(queryParam.getValue()))
                                    .append("&");
                    queryString = stringBuilder.substring(0, stringBuilder.length() - 1);
                }
                url = host + path + queryString;
            }

            @java.lang.SuppressWarnings({"Convert2Diamond"})
            final java.util.HashMap<java.lang.String, java.lang.String> headers =
                new java.util.HashMap<java.lang.String, java.lang.String>();
            for (final java.lang.String key: headerParams.keySet())
                headers.put(key, headerParams.get(key));
            for (final java.lang.String key: this.defaultHeaderMap.keySet())
                if (!headerParams.containsKey(key))
                    headers.put(key, this.defaultHeaderMap.get(key));
            headers.put("Accept", "application/json");

            final java.lang.String formParamString;       // URL-encoded string from form parameters
            if (contentType.equals("application/x-www-form-urlencoded"))            // for form data
            {
                final java.lang.StringBuilder formParamStringBuilder =
                    new java.lang.StringBuilder();

                // encode the form params
                for (final java.lang.String key: formParams.keySet())
                {
                    final java.lang.String value = formParams.get(key);
                    if (null != value && !value.trim().equals(""))
                    {
                        if (formParamStringBuilder.length() > 0) formParamStringBuilder.append("&");
                        try
                        {
                            formParamStringBuilder.append(
                                java.net.URLEncoder.encode(key,"utf8")).append("=")
                                .append(java.net.URLEncoder.encode(value,"utf8"));
                        }
                        catch (final java.lang.Exception e) { /* move on to next */ }
                    }
                }
                formParamString = formParamStringBuilder.toString();
            }
            else formParamString = null;

            if (method.equals("GET"))
                result = new io.swagger.client.request.GetRequest(
                    url, headers,null, stringRequest, errorListener);
            else
                if (method.equals("POST"))
                    if (null != formParamString)
                        result = new io.swagger.client.request.PostRequest(url, headers,
                            contentType,
                            new org.apache.http.entity.StringEntity(
                                formParamString,"UTF-8"),
                            stringRequest, errorListener);
                    else
                        if (null != body)
                            if (body instanceof org.apache.http.HttpEntity)
                                result = new io.swagger.client.request.PostRequest(url, headers,
                                    null, (org.apache.http.HttpEntity) body,
                                    stringRequest, errorListener);
                            else
                                result = new io.swagger.client.request.PostRequest(
                                    url, headers, contentType,
                                    new org.apache.http.entity.StringEntity(
                                        io.swagger.client.ApiInvoker.serialize(body),
                                        "UTF-8"),
                                    stringRequest, errorListener);
                        else
                            result = new io.swagger.client.request.PostRequest(url, headers,
                                null,null, stringRequest, errorListener);
                else
                    if (method.equals("PUT"))
                        if (null != formParamString)
                            result = new io.swagger.client.request.PutRequest(url, headers,
                                contentType,
                                new org.apache.http.entity.StringEntity(
                                    formParamString,"UTF-8"),
                                stringRequest, errorListener);
                        else
                            if (null != body)
                                if (body instanceof org.apache.http.HttpEntity)
                                    result = new io.swagger.client.request.PutRequest(url, headers,
                                        null, (org.apache.http.HttpEntity) body,
                                        stringRequest, errorListener);
                                else
                                    result = new io.swagger.client.request.PutRequest(url, headers,
                                        contentType,
                                        new org.apache.http.entity.StringEntity(
                                            io.swagger.client.ApiInvoker.serialize(body),
                                            "UTF-8"),
                                        stringRequest, errorListener);
                            else
                                result = new io.swagger.client.request.PutRequest(url, headers,
                                    null,null, stringRequest, errorListener);
                    else
                        if (method.equals("DELETE"))
                            if (null != formParamString)
                                result = new io.swagger.client.request.DeleteRequest(url, headers,
                                    contentType,
                                    new org.apache.http.entity.StringEntity(
                                        formParamString,"UTF-8"),
                                    stringRequest, errorListener);
                            else
                                if (null != body)
                                    if (body instanceof org.apache.http.HttpEntity)
                                        result = new io.swagger.client.request.DeleteRequest(url,
                                            headers,null,
                                            (org.apache.http.HttpEntity) body, stringRequest,
                                            errorListener);
                                    else
                                        result = new io.swagger.client.request.DeleteRequest(
                                            url, headers, contentType,
                                            new org.apache.http.entity.StringEntity(
                                                io.swagger.client.ApiInvoker.serialize(body),
                                                "UTF-8"),
                                            stringRequest, errorListener);
                                else
                                    result = new io.swagger.client.request.DeleteRequest(url,
                                        headers,null,null, stringRequest,
                                        errorListener);
                        else
                            if (method.equals("PATCH"))
                                if (null != formParamString)
                                    result = new io.swagger.client.request.PatchRequest(
                                        url, headers, contentType,
                                        new org.apache.http.entity.StringEntity(
                                            formParamString,"UTF-8"),
                                        stringRequest, errorListener);
                                else
                                    if (null != body)
                                        if (body instanceof org.apache.http.HttpEntity)
                                            result = new io.swagger.client.request.PatchRequest(url,
                                                headers,null,
                                                (org.apache.http.HttpEntity) body, stringRequest,
                                                errorListener);
                                        else
                                            result = new io.swagger.client.request.PatchRequest(url,
                                                headers, contentType,
                                                new org.apache.http.entity.StringEntity(
                                                    io.swagger.client.ApiInvoker.serialize(body),
                                                    "UTF-8"),
                                                stringRequest, errorListener);
                                    else
                                        result = new io.swagger.client.request.PatchRequest(url,
                                            headers,null,null, stringRequest,
                                            errorListener);
                            else result = null;
        }
        // endregion
        if (null != result) result.setRetryPolicy(new com.android.volley.DefaultRetryPolicy(
            (int) java.util.concurrent.TimeUnit.SECONDS.toMillis(this.connectionTimeout),
            com.android.volley.DefaultRetryPolicy.DEFAULT_MAX_RETRIES                   ,
            com.android.volley.DefaultRetryPolicy.DEFAULT_BACKOFF_MULT                  ));
        return result;
    }

    public void stopQueue() { this.requestQueue.stop(); }
    // endregion
    // endregion
}