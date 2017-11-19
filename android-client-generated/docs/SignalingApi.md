# SignalingApi

All URIs are relative to *http://13.124.38.242:7504/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**demandMeetingGet**](SignalingApi.md#demandMeetingGet) | **GET** /demand/meeting | 요청받은 만남 보기
[**demandMeetingPost**](SignalingApi.md#demandMeetingPost) | **POST** /demand/meeting | 만남 요청하기
[**demandPersonPost**](SignalingApi.md#demandPersonPost) | **POST** /demand/person | 퍼블리셔 요청하기


<a name="demandMeetingGet"></a>
# **demandMeetingGet**
> List&lt;InlineResponse2002&gt; demandMeetingGet(authorization)

요청받은 만남 보기

퍼블리셔용 API, 시그널러가 자신한테 보낸 &#x60;만남 요청&#x60;을 확인할 수 있음

### Example
```java
// Import classes:
//import io.swagger.client.api.SignalingApi;

SignalingApi apiInstance = new SignalingApi();
String authorization = "authorization_example"; // String | 유저 토큰
try {
    List<InlineResponse2002> result = apiInstance.demandMeetingGet(authorization);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SignalingApi#demandMeetingGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| 유저 토큰 |

### Return type

[**List&lt;InlineResponse2002&gt;**](InlineResponse2002.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="demandMeetingPost"></a>
# **demandMeetingPost**
> InlineResponse2013 demandMeetingPost(authorization, publisherId, title, introduce)

만남 요청하기

&#x60;multipart/form-data&#x60;으로 퍼블리셔에게 사연을 써서 만남을 요청

### Example
```java
// Import classes:
//import io.swagger.client.api.SignalingApi;

SignalingApi apiInstance = new SignalingApi();
String authorization = "authorization_example"; // String | 유저 토큰
String publisherId = "publisherId_example"; // String | 만남 요청(시그널)을 보낼 퍼블리셔의 `id`
String title = "title_example"; // String | 사연의 제목 (e.g. `바둑 배우고 싶어요`)
String introduce = "introduce_example"; // String | 사연의 내용 (e.g. `바둑 1년 째 실력이 전혀 안늘어요ㅠ 도와주세여. 고수님`)
try {
    InlineResponse2013 result = apiInstance.demandMeetingPost(authorization, publisherId, title, introduce);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SignalingApi#demandMeetingPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| 유저 토큰 |
 **publisherId** | **String**| 만남 요청(시그널)을 보낼 퍼블리셔의 &#x60;id&#x60; |
 **title** | **String**| 사연의 제목 (e.g. &#x60;바둑 배우고 싶어요&#x60;) |
 **introduce** | **String**| 사연의 내용 (e.g. &#x60;바둑 1년 째 실력이 전혀 안늘어요ㅠ 도와주세여. 고수님&#x60;) |

### Return type

[**InlineResponse2013**](InlineResponse2013.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data, application/x-www-form-urlencoded
 - **Accept**: application/json

<a name="demandPersonPost"></a>
# **demandPersonPost**
> InlineResponse2014 demandPersonPost(profilePhoto, fullName, job, description, referenceLink)

퍼블리셔 요청하기

원하는 퍼블리셔가 없을 경우 퍼블리셔와 관련된 정보들을 작성해 오피셜 페이지 생성해주세요 요청하는 기능

### Example
```java
// Import classes:
//import io.swagger.client.api.SignalingApi;

SignalingApi apiInstance = new SignalingApi();
File profilePhoto = new File("/path/to/file.txt"); // File | `업로드 기능`을 사용해서 보낼 이미지 파일
String fullName = "fullName_example"; // String | 원하는 사람 이름 (e.g. `김수현`)
String job = "job_example"; // String | 직업 (e.g. `연예인`)
String description = "description_example"; // String | 설명 (e.g. `잘생김, ㄹㅇ 잘생김`)
String referenceLink = "referenceLink_example"; // String | 참고할만한 링크 (e.g. `https://ko.wikipedia.org/wiki/김수현`)
try {
    InlineResponse2014 result = apiInstance.demandPersonPost(profilePhoto, fullName, job, description, referenceLink);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SignalingApi#demandPersonPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **profilePhoto** | **File**| &#x60;업로드 기능&#x60;을 사용해서 보낼 이미지 파일 | [optional]
 **fullName** | **String**| 원하는 사람 이름 (e.g. &#x60;김수현&#x60;) | [optional]
 **job** | **String**| 직업 (e.g. &#x60;연예인&#x60;) | [optional]
 **description** | **String**| 설명 (e.g. &#x60;잘생김, ㄹㅇ 잘생김&#x60;) | [optional]
 **referenceLink** | **String**| 참고할만한 링크 (e.g. &#x60;https://ko.wikipedia.org/wiki/김수현&#x60;) | [optional]

### Return type

[**InlineResponse2014**](InlineResponse2014.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data, application/x-www-form-urlencoded
 - **Accept**: application/json

