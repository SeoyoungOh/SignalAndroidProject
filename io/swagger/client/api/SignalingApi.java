/**
 * 시그널 서버 API
 * 소프트웨어 마에스트로 과정
 *
 * OpenAPI spec version: 0.0.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
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

import java.io.File;
import io.swagger.client.model.InlineResponse2002;
import io.swagger.client.model.InlineResponse2013;
import io.swagger.client.model.InlineResponse2014;

import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class SignalingApi {
  String basePath = "http://13.124.38.242:7504/";
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
  * 요청받은 만남 보기
  * 퍼블리셔용 API, 시그널러가 자신한테 보낸 &#x60;만남 요청&#x60;을 확인할 수 있음
   * @param authorization 유저 토큰
   * @return List<InlineResponse2002>
  */
  public List<InlineResponse2002> demandMeetingGet (String authorization) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  
      // verify the required parameter 'authorization' is set
      if (authorization == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'authorization' when calling demandMeetingGet",
      new ApiException(400, "Missing the required parameter 'authorization' when calling demandMeetingGet"));
      }
  

  // create path and map variables
  String path = "/demand/meeting".replaceAll("\\{format\\}","json");

  // query params
  List<Pair> queryParams = new ArrayList<Pair>();
      // header params
      Map<String, String> headerParams = new HashMap<String, String>();
      // form params
      Map<String, String> formParams = new HashMap<String, String>();


          headerParams.put("Authorization", ApiInvoker.parameterToString(authorization));

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

      String[] authNames = new String[] {  };

      try {
        String localVarResponse = apiInvoker.invokeAPI (basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames);
        if(localVarResponse != null){
           return (List<InlineResponse2002>) ApiInvoker.deserialize(localVarResponse, "array", InlineResponse2002.class);
        } else {
           return null;
        }
      } catch (ApiException ex) {
         throw ex;
      } catch (InterruptedException ex) {
         throw ex;
      } catch (ExecutionException ex) {
         if(ex.getCause() instanceof VolleyError) {
	    VolleyError volleyError = (VolleyError)ex.getCause();
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
   * 요청받은 만남 보기
   * 퍼블리셔용 API, 시그널러가 자신한테 보낸 &#x60;만남 요청&#x60;을 확인할 수 있음
   * @param authorization 유저 토큰
  */
  public void demandMeetingGet (String authorization, final Response.Listener<List<InlineResponse2002>> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  
    // verify the required parameter 'authorization' is set
    if (authorization == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'authorization' when calling demandMeetingGet",
         new ApiException(400, "Missing the required parameter 'authorization' when calling demandMeetingGet"));
    }
    

    // create path and map variables
    String path = "/demand/meeting".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();


    headerParams.put("Authorization", ApiInvoker.parameterToString(authorization));

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

      String[] authNames = new String[] {  };

    try {
      apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames,
        new Response.Listener<String>() {
          @Override
          public void onResponse(String localVarResponse) {
            try {
              responseListener.onResponse((List<InlineResponse2002>) ApiInvoker.deserialize(localVarResponse,  "array", InlineResponse2002.class));
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
  * 만남 요청하기
  * &#x60;multipart/form-data&#x60;으로 퍼블리셔에게 사연을 써서 만남을 요청
   * @param authorization 유저 토큰
   * @param publisherId 만남 요청(시그널)을 보낼 퍼블리셔의 &#x60;id&#x60;
   * @param title 사연의 제목 (e.g. &#x60;바둑 배우고 싶어요&#x60;)
   * @param introduce 사연의 내용 (e.g. &#x60;바둑 1년 째 실력이 전혀 안늘어요ㅠ 도와주세여. 고수님&#x60;)
   * @return InlineResponse2013
  */
  public InlineResponse2013 demandMeetingPost (String authorization, String publisherId, String title, String introduce) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  
      // verify the required parameter 'authorization' is set
      if (authorization == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'authorization' when calling demandMeetingPost",
      new ApiException(400, "Missing the required parameter 'authorization' when calling demandMeetingPost"));
      }
  
      // verify the required parameter 'publisherId' is set
      if (publisherId == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'publisherId' when calling demandMeetingPost",
      new ApiException(400, "Missing the required parameter 'publisherId' when calling demandMeetingPost"));
      }
  
      // verify the required parameter 'title' is set
      if (title == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'title' when calling demandMeetingPost",
      new ApiException(400, "Missing the required parameter 'title' when calling demandMeetingPost"));
      }
  
      // verify the required parameter 'introduce' is set
      if (introduce == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'introduce' when calling demandMeetingPost",
      new ApiException(400, "Missing the required parameter 'introduce' when calling demandMeetingPost"));
      }
  

  // create path and map variables
  String path = "/demand/meeting".replaceAll("\\{format\\}","json");

  // query params
  List<Pair> queryParams = new ArrayList<Pair>();
      // header params
      Map<String, String> headerParams = new HashMap<String, String>();
      // form params
      Map<String, String> formParams = new HashMap<String, String>();


          headerParams.put("Authorization", ApiInvoker.parameterToString(authorization));

      String[] contentTypes = {
  "multipart/form-data","application/x-www-form-urlencoded"
      };
      String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

      if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
  
          if (publisherId != null) {
          localVarBuilder.addTextBody("publisher_id", ApiInvoker.parameterToString(publisherId), ApiInvoker.TEXT_PLAIN_UTF8);
          }
  
          if (title != null) {
          localVarBuilder.addTextBody("title", ApiInvoker.parameterToString(title), ApiInvoker.TEXT_PLAIN_UTF8);
          }
  
          if (introduce != null) {
          localVarBuilder.addTextBody("introduce", ApiInvoker.parameterToString(introduce), ApiInvoker.TEXT_PLAIN_UTF8);
          }
  

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
      } else {
      // normal form params
  formParams.put("publisher_id", ApiInvoker.parameterToString(publisherId));
formParams.put("title", ApiInvoker.parameterToString(title));
formParams.put("introduce", ApiInvoker.parameterToString(introduce));
      }

      String[] authNames = new String[] {  };

      try {
        String localVarResponse = apiInvoker.invokeAPI (basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType, authNames);
        if(localVarResponse != null){
           return (InlineResponse2013) ApiInvoker.deserialize(localVarResponse, "", InlineResponse2013.class);
        } else {
           return null;
        }
      } catch (ApiException ex) {
         throw ex;
      } catch (InterruptedException ex) {
         throw ex;
      } catch (ExecutionException ex) {
         if(ex.getCause() instanceof VolleyError) {
	    VolleyError volleyError = (VolleyError)ex.getCause();
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
   * 만남 요청하기
   * &#x60;multipart/form-data&#x60;으로 퍼블리셔에게 사연을 써서 만남을 요청
   * @param authorization 유저 토큰   * @param publisherId 만남 요청(시그널)을 보낼 퍼블리셔의 &#x60;id&#x60;   * @param title 사연의 제목 (e.g. &#x60;바둑 배우고 싶어요&#x60;)   * @param introduce 사연의 내용 (e.g. &#x60;바둑 1년 째 실력이 전혀 안늘어요ㅠ 도와주세여. 고수님&#x60;)
  */
  public void demandMeetingPost (String authorization, String publisherId, String title, String introduce, final Response.Listener<InlineResponse2013> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  
    // verify the required parameter 'authorization' is set
    if (authorization == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'authorization' when calling demandMeetingPost",
         new ApiException(400, "Missing the required parameter 'authorization' when calling demandMeetingPost"));
    }
    
    // verify the required parameter 'publisherId' is set
    if (publisherId == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'publisherId' when calling demandMeetingPost",
         new ApiException(400, "Missing the required parameter 'publisherId' when calling demandMeetingPost"));
    }
    
    // verify the required parameter 'title' is set
    if (title == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'title' when calling demandMeetingPost",
         new ApiException(400, "Missing the required parameter 'title' when calling demandMeetingPost"));
    }
    
    // verify the required parameter 'introduce' is set
    if (introduce == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'introduce' when calling demandMeetingPost",
         new ApiException(400, "Missing the required parameter 'introduce' when calling demandMeetingPost"));
    }
    

    // create path and map variables
    String path = "/demand/meeting".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();


    headerParams.put("Authorization", ApiInvoker.parameterToString(authorization));

    String[] contentTypes = {
      "multipart/form-data","application/x-www-form-urlencoded"
    };
    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
      
      if (publisherId != null) {
        localVarBuilder.addTextBody("publisher_id", ApiInvoker.parameterToString(publisherId), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      
      if (title != null) {
        localVarBuilder.addTextBody("title", ApiInvoker.parameterToString(title), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      
      if (introduce != null) {
        localVarBuilder.addTextBody("introduce", ApiInvoker.parameterToString(introduce), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
    } else {
      // normal form params
      formParams.put("publisher_id", ApiInvoker.parameterToString(publisherId));
formParams.put("title", ApiInvoker.parameterToString(title));
formParams.put("introduce", ApiInvoker.parameterToString(introduce));
    }

      String[] authNames = new String[] {  };

    try {
      apiInvoker.invokeAPI(basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType, authNames,
        new Response.Listener<String>() {
          @Override
          public void onResponse(String localVarResponse) {
            try {
              responseListener.onResponse((InlineResponse2013) ApiInvoker.deserialize(localVarResponse,  "", InlineResponse2013.class));
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
  * 퍼블리셔 요청하기
  * 원하는 퍼블리셔가 없을 경우 퍼블리셔와 관련된 정보들을 작성해 오피셜 페이지 생성해주세요 요청하는 기능
   * @param profilePhoto &#x60;업로드 기능&#x60;을 사용해서 보낼 이미지 파일
   * @param fullName 원하는 사람 이름 (e.g. &#x60;김수현&#x60;)
   * @param job 직업 (e.g. &#x60;연예인&#x60;)
   * @param description 설명 (e.g. &#x60;잘생김, ㄹㅇ 잘생김&#x60;)
   * @param referenceLink 참고할만한 링크 (e.g. &#x60;https://ko.wikipedia.org/wiki/김수현&#x60;)
   * @return InlineResponse2014
  */
  public InlineResponse2014 demandPersonPost (File profilePhoto, String fullName, String job, String description, String referenceLink) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  

  // create path and map variables
  String path = "/demand/person".replaceAll("\\{format\\}","json");

  // query params
  List<Pair> queryParams = new ArrayList<Pair>();
      // header params
      Map<String, String> headerParams = new HashMap<String, String>();
      // form params
      Map<String, String> formParams = new HashMap<String, String>();



      String[] contentTypes = {
  "multipart/form-data","application/x-www-form-urlencoded"
      };
      String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

      if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
  
          if (profilePhoto != null) {
          localVarBuilder.addBinaryBody("profile_photo", profilePhoto);
          }
  
          if (fullName != null) {
          localVarBuilder.addTextBody("full_name", ApiInvoker.parameterToString(fullName), ApiInvoker.TEXT_PLAIN_UTF8);
          }
  
          if (job != null) {
          localVarBuilder.addTextBody("job", ApiInvoker.parameterToString(job), ApiInvoker.TEXT_PLAIN_UTF8);
          }
  
          if (description != null) {
          localVarBuilder.addTextBody("description", ApiInvoker.parameterToString(description), ApiInvoker.TEXT_PLAIN_UTF8);
          }
  
          if (referenceLink != null) {
          localVarBuilder.addTextBody("reference_link", ApiInvoker.parameterToString(referenceLink), ApiInvoker.TEXT_PLAIN_UTF8);
          }
  

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
      } else {
      // normal form params
  
formParams.put("full_name", ApiInvoker.parameterToString(fullName));
formParams.put("job", ApiInvoker.parameterToString(job));
formParams.put("description", ApiInvoker.parameterToString(description));
formParams.put("reference_link", ApiInvoker.parameterToString(referenceLink));
      }

      String[] authNames = new String[] {  };

      try {
        String localVarResponse = apiInvoker.invokeAPI (basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType, authNames);
        if(localVarResponse != null){
           return (InlineResponse2014) ApiInvoker.deserialize(localVarResponse, "", InlineResponse2014.class);
        } else {
           return null;
        }
      } catch (ApiException ex) {
         throw ex;
      } catch (InterruptedException ex) {
         throw ex;
      } catch (ExecutionException ex) {
         if(ex.getCause() instanceof VolleyError) {
	    VolleyError volleyError = (VolleyError)ex.getCause();
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
   * 퍼블리셔 요청하기
   * 원하는 퍼블리셔가 없을 경우 퍼블리셔와 관련된 정보들을 작성해 오피셜 페이지 생성해주세요 요청하는 기능
   * @param profilePhoto &#x60;업로드 기능&#x60;을 사용해서 보낼 이미지 파일   * @param fullName 원하는 사람 이름 (e.g. &#x60;김수현&#x60;)   * @param job 직업 (e.g. &#x60;연예인&#x60;)   * @param description 설명 (e.g. &#x60;잘생김, ㄹㅇ 잘생김&#x60;)   * @param referenceLink 참고할만한 링크 (e.g. &#x60;https://ko.wikipedia.org/wiki/김수현&#x60;)
  */
  public void demandPersonPost (File profilePhoto, String fullName, String job, String description, String referenceLink, final Response.Listener<InlineResponse2014> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  

    // create path and map variables
    String path = "/demand/person".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();



    String[] contentTypes = {
      "multipart/form-data","application/x-www-form-urlencoded"
    };
    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
      
      if (profilePhoto != null) {
        localVarBuilder.addBinaryBody("profile_photo", profilePhoto);
      }
      
      if (fullName != null) {
        localVarBuilder.addTextBody("full_name", ApiInvoker.parameterToString(fullName), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      
      if (job != null) {
        localVarBuilder.addTextBody("job", ApiInvoker.parameterToString(job), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      
      if (description != null) {
        localVarBuilder.addTextBody("description", ApiInvoker.parameterToString(description), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      
      if (referenceLink != null) {
        localVarBuilder.addTextBody("reference_link", ApiInvoker.parameterToString(referenceLink), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
    } else {
      // normal form params
      
formParams.put("full_name", ApiInvoker.parameterToString(fullName));
formParams.put("job", ApiInvoker.parameterToString(job));
formParams.put("description", ApiInvoker.parameterToString(description));
formParams.put("reference_link", ApiInvoker.parameterToString(referenceLink));
    }

      String[] authNames = new String[] {  };

    try {
      apiInvoker.invokeAPI(basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType, authNames,
        new Response.Listener<String>() {
          @Override
          public void onResponse(String localVarResponse) {
            try {
              responseListener.onResponse((InlineResponse2014) ApiInvoker.deserialize(localVarResponse,  "", InlineResponse2014.class));
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
}
