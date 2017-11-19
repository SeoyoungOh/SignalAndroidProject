/**
 * 시그널 서버 API
 * 소프트웨어 마에스트로 과정
 * <p>
 * OpenAPI spec version: 0.0.1
 * <p>
 * <p>
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.swagger.client.api;

import io.swagger.client.ApiInvoker;
import io.swagger.client.ApiException;
import io.swagger.client.Pair;

import io.swagger.client.model.*;

import java.util.*;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import io.swagger.client.model.InlineResponse2002;

import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class UtilApi {
    String basePath = "http://52.79.36.12:7504/";
    ApiInvoker apiInvoker = ApiInvoker.getInstance();

    public void addHeader(String key, String value) {
        getInvoker().addDefaultHeader(key, value);
    }

    public ApiInvoker getInvoker() {
        return apiInvoker;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getBasePath() {
        return basePath;
    }

    /**
     * 이름으로 퍼블리셔 검색
     * &#x60;김&#x60;, &#x60;김수&#x60;, &#x60;김수현&#x60;처럼 쿼리문으로 검색된 퍼블리셔의 정보를 반환함 (e.g. &#x60;http://server:port/account/publisher/search?name&#x3D;김&#x60;) 만약 &#x60;name&#x60; 쿼리가 없다면 모든 퍼블리셔의 정보 반환
     * @param name 검색할 이름, 값이 비어있을 경우 모든 퍼블리셔 정보를 반환함
     * @return List<InlineResponse2002>
     */
    public List<InlineResponse2002> accountPublisherSearchGet(String name) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
        Object postBody = null;


        // create path and map variables
        String path = "/account/publisher/search".replaceAll("\\{format\\}", "json");

        // query params
        List<Pair> queryParams = new ArrayList<Pair>();
        // header params
        Map<String, String> headerParams = new HashMap<String, String>();
        // form params
        Map<String, String> formParams = new HashMap<String, String>();

        queryParams.addAll(ApiInvoker.parameterToPairs("", "name", name));


        String[] contentTypes = {

        };
        String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

        if (contentType.startsWith("multipart/form-data")) {
            // file uploading
            MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();


            HttpEntity httpEntity = localVarBuilder.build();
            postBody = httpEntity;
        } else {
            // normal form params
        }

        String[] authNames = new String[]{};

        try {
            String localVarResponse = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames);
            if (localVarResponse != null) {
                return (List<InlineResponse2002>) ApiInvoker.deserialize(localVarResponse, "array", InlineResponse2002.class);
            } else {
                return null;
            }
        } catch (ApiException ex) {
            throw ex;
        } catch (InterruptedException ex) {
            throw ex;
        } catch (ExecutionException ex) {
            if (ex.getCause() instanceof VolleyError) {
                VolleyError volleyError = (VolleyError) ex.getCause();
                if (volleyError.networkResponse != null) {
                    throw new ApiException(volleyError.networkResponse.statusCode, volleyError.getMessage());
                }
            }
            throw ex;
        } catch (TimeoutException ex) {
            throw ex;
        }
    }

    /**
     * 이름으로 퍼블리셔 검색
     * &#x60;김&#x60;, &#x60;김수&#x60;, &#x60;김수현&#x60;처럼 쿼리문으로 검색된 퍼블리셔의 정보를 반환함 (e.g. &#x60;http://server:port/account/publisher/search?name&#x3D;김&#x60;) 만약 &#x60;name&#x60; 쿼리가 없다면 모든 퍼블리셔의 정보 반환
     * @param name 검색할 이름, 값이 비어있을 경우 모든 퍼블리셔 정보를 반환함
     */
    public void accountPublisherSearchGet(String name, final Response.Listener<List<InlineResponse2002>> responseListener, final Response.ErrorListener errorListener) {
        Object postBody = null;


        // create path and map variables
        String path = "/account/publisher/search".replaceAll("\\{format\\}", "json");

        // query params
        List<Pair> queryParams = new ArrayList<Pair>();
        // header params
        Map<String, String> headerParams = new HashMap<String, String>();
        // form params
        Map<String, String> formParams = new HashMap<String, String>();

        queryParams.addAll(ApiInvoker.parameterToPairs("", "name", name));


        String[] contentTypes = {

        };
        String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

        if (contentType.startsWith("multipart/form-data")) {
            // file uploading
            MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();


            HttpEntity httpEntity = localVarBuilder.build();
            postBody = httpEntity;
        } else {
            // normal form params
        }

        String[] authNames = new String[]{};

        try {
            apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String localVarResponse) {
                            try {
                                responseListener.onResponse((List<InlineResponse2002>) ApiInvoker.deserialize(localVarResponse, "array", InlineResponse2002.class));
                            } catch (ApiException exception) {
                                errorListener.onErrorResponse(new VolleyError(exception));
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            errorListener.onErrorResponse(error);
                        }
                    });
        } catch (ApiException ex) {
            errorListener.onErrorResponse(new VolleyError(ex));
        }
    }

    /**
     * 추천 퍼블리셔 정보 가져오기
     * 임의로 추천된 5명의 퍼블리셔 정보를 반환함
     * @return List<InlineResponse2002>
     */
    public List<InlineResponse2002> accountRecommendPublisherGet() throws TimeoutException, ExecutionException, InterruptedException, ApiException {
        Object postBody = null;


        // create path and map variables
        String path = "/account/recommend_publisher".replaceAll("\\{format\\}", "json");

        // query params
        List<Pair> queryParams = new ArrayList<Pair>();
        // header params
        Map<String, String> headerParams = new HashMap<String, String>();
        // form params
        Map<String, String> formParams = new HashMap<String, String>();


        String[] contentTypes = {

        };
        String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

        if (contentType.startsWith("multipart/form-data")) {
            // file uploading
            MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();


            HttpEntity httpEntity = localVarBuilder.build();
            postBody = httpEntity;
        } else {
            // normal form params
        }

        String[] authNames = new String[]{};

        try {
            String localVarResponse = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames);
            if (localVarResponse != null) {
                return (List<InlineResponse2002>) ApiInvoker.deserialize(localVarResponse, "array", InlineResponse2002.class);
            } else {
                return null;
            }
        } catch (ApiException ex) {
            throw ex;
        } catch (InterruptedException ex) {
            throw ex;
        } catch (ExecutionException ex) {
            if (ex.getCause() instanceof VolleyError) {
                VolleyError volleyError = (VolleyError) ex.getCause();
                if (volleyError.networkResponse != null) {
                    throw new ApiException(volleyError.networkResponse.statusCode, volleyError.getMessage());
                }
            }
            throw ex;
        } catch (TimeoutException ex) {
            throw ex;
        }
    }

    /**
     * 추천 퍼블리셔 정보 가져오기
     * 임의로 추천된 5명의 퍼블리셔 정보를 반환함

     */
    public void accountRecommendPublisherGet(final Response.Listener<List<InlineResponse2002>> responseListener, final Response.ErrorListener errorListener) {
        Object postBody = null;


        // create path and map variables
        String path = "/account/recommend_publisher".replaceAll("\\{format\\}", "json");

        // query params
        List<Pair> queryParams = new ArrayList<Pair>();
        // header params
        Map<String, String> headerParams = new HashMap<String, String>();
        // form params
        Map<String, String> formParams = new HashMap<String, String>();


        String[] contentTypes = {

        };
        String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

        if (contentType.startsWith("multipart/form-data")) {
            // file uploading
            MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();


            HttpEntity httpEntity = localVarBuilder.build();
            postBody = httpEntity;
        } else {
            // normal form params
        }

        String[] authNames = new String[]{};

        try {
            apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String localVarResponse) {
                            try {
                                responseListener.onResponse((List<InlineResponse2002>) ApiInvoker.deserialize(localVarResponse, "array", InlineResponse2002.class));
                            } catch (ApiException exception) {
                                errorListener.onErrorResponse(new VolleyError(exception));
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            errorListener.onErrorResponse(error);
                        }
                    });
        } catch (ApiException ex) {
            errorListener.onErrorResponse(new VolleyError(ex));
        }
    }

    /**
     * 사진 파일 가져오기
     * response에 있던 &#x60;photo_path&#x60;를 url로 조회
     * @param photoPath 가져오고 싶은 사진의 path (e.g. &#x60;user_profile/image01.jpg&#x60;)
     * @return void
     */
    public void mediaPhotoPathGet(String photoPath) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
        Object postBody = null;

        // verify the required parameter 'photoPath' is set
        if (photoPath == null) {
            VolleyError error = new VolleyError("Missing the required parameter 'photoPath' when calling mediaPhotoPathGet",
                    new ApiException(400, "Missing the required parameter 'photoPath' when calling mediaPhotoPathGet"));
        }


        // create path and map variables
        String path = "/media/{photo_path}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "photo_path" + "\\}", apiInvoker.escapeString(photoPath.toString()));

        // query params
        List<Pair> queryParams = new ArrayList<Pair>();
        // header params
        Map<String, String> headerParams = new HashMap<String, String>();
        // form params
        Map<String, String> formParams = new HashMap<String, String>();


        String[] contentTypes = {

        };
        String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

        if (contentType.startsWith("multipart/form-data")) {
            // file uploading
            MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();


            HttpEntity httpEntity = localVarBuilder.build();
            postBody = httpEntity;
        } else {
            // normal form params
        }

        String[] authNames = new String[]{};

        try {
            String localVarResponse = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames);
            if (localVarResponse != null) {
                return;
            } else {
                return;
            }
        } catch (ApiException ex) {
            throw ex;
        } catch (InterruptedException ex) {
            throw ex;
        } catch (ExecutionException ex) {
            if (ex.getCause() instanceof VolleyError) {
                VolleyError volleyError = (VolleyError) ex.getCause();
                if (volleyError.networkResponse != null) {
                    throw new ApiException(volleyError.networkResponse.statusCode, volleyError.getMessage());
                }
            }
            throw ex;
        } catch (TimeoutException ex) {
            throw ex;
        }
    }

    /**
     * 사진 파일 가져오기
     * response에 있던 &#x60;photo_path&#x60;를 url로 조회
     * @param photoPath 가져오고 싶은 사진의 path (e.g. &#x60;user_profile/image01.jpg&#x60;)
     */
    public void mediaPhotoPathGet(String photoPath, final Response.Listener<String> responseListener, final Response.ErrorListener errorListener) {
        Object postBody = null;


        // verify the required parameter 'photoPath' is set
        if (photoPath == null) {
            VolleyError error = new VolleyError("Missing the required parameter 'photoPath' when calling mediaPhotoPathGet",
                    new ApiException(400, "Missing the required parameter 'photoPath' when calling mediaPhotoPathGet"));
        }


        // create path and map variables
        String path = "/media/{photo_path}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "photo_path" + "\\}", apiInvoker.escapeString(photoPath.toString()));

        // query params
        List<Pair> queryParams = new ArrayList<Pair>();
        // header params
        Map<String, String> headerParams = new HashMap<String, String>();
        // form params
        Map<String, String> formParams = new HashMap<String, String>();


        String[] contentTypes = {

        };
        String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

        if (contentType.startsWith("multipart/form-data")) {
            // file uploading
            MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();


            HttpEntity httpEntity = localVarBuilder.build();
            postBody = httpEntity;
        } else {
            // normal form params
        }

        String[] authNames = new String[]{};

        try {
            apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String localVarResponse) {
                            responseListener.onResponse(localVarResponse);
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            errorListener.onErrorResponse(error);
                        }
                    });
        } catch (ApiException ex) {
            errorListener.onErrorResponse(new VolleyError(ex));
        }
    }
}
