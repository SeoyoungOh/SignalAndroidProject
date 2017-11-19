# UtilApi

All URIs are relative to *http://13.124.38.242:7504/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**accountPublisherSearchGet**](UtilApi.md#accountPublisherSearchGet) | **GET** /account/publisher/search | 이름으로 퍼블리셔 검색
[**accountRecommendPublisherGet**](UtilApi.md#accountRecommendPublisherGet) | **GET** /account/recommend_publisher | 추천 퍼블리셔 정보 가져오기
[**mediaPhotoPathGet**](UtilApi.md#mediaPhotoPathGet) | **GET** /media/{photo_path} | 사진 파일 가져오기


<a name="accountPublisherSearchGet"></a>
# **accountPublisherSearchGet**
> List&lt;InlineResponse2002&gt; accountPublisherSearchGet(name)

이름으로 퍼블리셔 검색

&#x60;김&#x60;, &#x60;김수&#x60;, &#x60;김수현&#x60;처럼 쿼리문으로 검색된 퍼블리셔의 정보를 반환함 (e.g. &#x60;http://server:port/account/publisher/search?name&#x3D;김&#x60;) 만약 &#x60;name&#x60; 쿼리가 없다면 모든 퍼블리셔의 정보 반환

### Example
```java
// Import classes:
//import io.swagger.client.api.UtilApi;

UtilApi apiInstance = new UtilApi();
String name = "name_example"; // String | 검색할 이름, 값이 비어있을 경우 모든 퍼블리셔 정보를 반환함
try {
    List<InlineResponse2002> result = apiInstance.accountPublisherSearchGet(name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UtilApi#accountPublisherSearchGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| 검색할 이름, 값이 비어있을 경우 모든 퍼블리셔 정보를 반환함 | [optional]

### Return type

[**List&lt;InlineResponse2002&gt;**](InlineResponse2002.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="accountRecommendPublisherGet"></a>
# **accountRecommendPublisherGet**
> List&lt;InlineResponse2002&gt; accountRecommendPublisherGet()

추천 퍼블리셔 정보 가져오기

임의로 추천된 5명의 퍼블리셔 정보를 반환함

### Example
```java
// Import classes:
//import io.swagger.client.api.UtilApi;

UtilApi apiInstance = new UtilApi();
try {
    List<InlineResponse2002> result = apiInstance.accountRecommendPublisherGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UtilApi#accountRecommendPublisherGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;InlineResponse2002&gt;**](InlineResponse2002.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="mediaPhotoPathGet"></a>
# **mediaPhotoPathGet**
> mediaPhotoPathGet(photoPath)

사진 파일 가져오기

response에 있던 &#x60;photo_path&#x60;를 url로 조회

### Example
```java
// Import classes:
//import io.swagger.client.api.UtilApi;

UtilApi apiInstance = new UtilApi();
String photoPath = "photoPath_example"; // String | 가져오고 싶은 사진의 path (e.g. `user_profile/image01.jpg`)
try {
    apiInstance.mediaPhotoPathGet(photoPath);
} catch (ApiException e) {
    System.err.println("Exception when calling UtilApi#mediaPhotoPathGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **photoPath** | **String**| 가져오고 싶은 사진의 path (e.g. &#x60;user_profile/image01.jpg&#x60;) |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: image/jpg

