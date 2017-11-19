# MeetingApi

All URIs are relative to *http://13.124.38.242:7504/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**meetingGet**](MeetingApi.md#meetingGet) | **GET** /meeting/ | 서버에 있는 모든 만남 조회
[**meetingParticipateGet**](MeetingApi.md#meetingParticipateGet) | **GET** /meeting/participate | 내가 참여한 모든 만남 조회
[**meetingParticipatePost**](MeetingApi.md#meetingParticipatePost) | **POST** /meeting/participate | 만남 참여하기
[**meetingPost**](MeetingApi.md#meetingPost) | **POST** /meeting/ | 만남 생성
[**meetingPublisherIdGet**](MeetingApi.md#meetingPublisherIdGet) | **GET** /meeting/{publisher_id} | 특정 퍼블리셔가 만든 만남 조회


<a name="meetingGet"></a>
# **meetingGet**
> List&lt;InlineResponse2002&gt; meetingGet()

서버에 있는 모든 만남 조회

특정 퍼블리셔가 만든 만남을 조회 할 때는 밑에 있는 API를 이용해야함

### Example
```java
// Import classes:
//import io.swagger.client.api.MeetingApi;

MeetingApi apiInstance = new MeetingApi();
try {
    List<InlineResponse2002> result = apiInstance.meetingGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MeetingApi#meetingGet");
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

<a name="meetingParticipateGet"></a>
# **meetingParticipateGet**
> List&lt;InlineResponse2002&gt; meetingParticipateGet(authorization)

내가 참여한 모든 만남 조회

내가 참여한 모든 만남 조회

### Example
```java
// Import classes:
//import io.swagger.client.api.MeetingApi;

MeetingApi apiInstance = new MeetingApi();
String authorization = "authorization_example"; // String | 유저 토큰
try {
    List<InlineResponse2002> result = apiInstance.meetingParticipateGet(authorization);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MeetingApi#meetingParticipateGet");
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

<a name="meetingParticipatePost"></a>
# **meetingParticipatePost**
> InlineResponse2012 meetingParticipatePost(authorization, meetingId, shortOpinion)

만남 참여하기

&#x60;multipart/form-data&#x60;으로 만남 참여 정보를 전송

### Example
```java
// Import classes:
//import io.swagger.client.api.MeetingApi;

MeetingApi apiInstance = new MeetingApi();
String authorization = "authorization_example"; // String | 유저 토큰
File meetingId = new File("/path/to/file.txt"); // File | 참여할 만남의 `id`
File shortOpinion = new File("/path/to/file.txt"); // File | 참여할 만남에 적는 한마디 (e.g. `야호 신난다`)
try {
    InlineResponse2012 result = apiInstance.meetingParticipatePost(authorization, meetingId, shortOpinion);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MeetingApi#meetingParticipatePost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| 유저 토큰 |
 **meetingId** | **File**| 참여할 만남의 &#x60;id&#x60; |
 **shortOpinion** | **File**| 참여할 만남에 적는 한마디 (e.g. &#x60;야호 신난다&#x60;) |

### Return type

[**InlineResponse2012**](InlineResponse2012.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data, application/x-www-form-urlencoded
 - **Accept**: application/json

<a name="meetingPost"></a>
# **meetingPost**
> InlineResponse2011 meetingPost(authorization, title, content, meetingPhoto, maximumPeople, location, entryFeeType, entryFee, entryDueTime, startTime, endTime)

만남 생성

&#x60;multipart/form-data&#x60;으로 만남 정보를 전송

### Example
```java
// Import classes:
//import io.swagger.client.api.MeetingApi;

MeetingApi apiInstance = new MeetingApi();
String authorization = "authorization_example"; // String | 유저 토큰
String title = "title_example"; // String | 만남 제목 (e.g. `바둑 가르쳐 드립니다`)
String content = "content_example"; // String | 만남 본문 내용 (e.g. `저 바둑 고수입니다. 저한테서 배우고 싶으신 분들 10명만 오세요.`)
File meetingPhoto = new File("/path/to/file.txt"); // File | `업로드 기능`을 사용해서 보낼 만남 본문 이미지 파일
Integer maximumPeople = 56; // Integer | 최대 인원수 (e.g. `10`)
String location = "location_example"; // String | 위치 (e.g. `서울시`)
String entryFeeType = "entryFeeType_example"; // String | 참가비 유형 (e.g. `기타`)
Integer entryFee = 56; // Integer | 참가비 (e.g. `200000`)
String entryDueTime = "entryDueTime_example"; // String | 참가 신청 마감 시간 (e.g. `2017-10-18T07:55:01.611778+00:00`)
String startTime = "startTime_example"; // String | 만남 시작 시간 (e.g. `2017-10-18T07:55:01.611778+00:00`)
String endTime = "endTime_example"; // String | 만남 끝나는 시간 (e.g. `2017-10-18T07:55:01.611778+00:00`)
try {
    InlineResponse2011 result = apiInstance.meetingPost(authorization, title, content, meetingPhoto, maximumPeople, location, entryFeeType, entryFee, entryDueTime, startTime, endTime);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MeetingApi#meetingPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| 유저 토큰 |
 **title** | **String**| 만남 제목 (e.g. &#x60;바둑 가르쳐 드립니다&#x60;) |
 **content** | **String**| 만남 본문 내용 (e.g. &#x60;저 바둑 고수입니다. 저한테서 배우고 싶으신 분들 10명만 오세요.&#x60;) |
 **meetingPhoto** | **File**| &#x60;업로드 기능&#x60;을 사용해서 보낼 만남 본문 이미지 파일 | [optional]
 **maximumPeople** | **Integer**| 최대 인원수 (e.g. &#x60;10&#x60;) | [optional]
 **location** | **String**| 위치 (e.g. &#x60;서울시&#x60;) | [optional]
 **entryFeeType** | **String**| 참가비 유형 (e.g. &#x60;기타&#x60;) | [optional]
 **entryFee** | **Integer**| 참가비 (e.g. &#x60;200000&#x60;) | [optional]
 **entryDueTime** | **String**| 참가 신청 마감 시간 (e.g. &#x60;2017-10-18T07:55:01.611778+00:00&#x60;) | [optional]
 **startTime** | **String**| 만남 시작 시간 (e.g. &#x60;2017-10-18T07:55:01.611778+00:00&#x60;) | [optional]
 **endTime** | **String**| 만남 끝나는 시간 (e.g. &#x60;2017-10-18T07:55:01.611778+00:00&#x60;) | [optional]

### Return type

[**InlineResponse2011**](InlineResponse2011.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data, application/x-www-form-urlencoded
 - **Accept**: application/json

<a name="meetingPublisherIdGet"></a>
# **meetingPublisherIdGet**
> List&lt;InlineResponse2002&gt; meetingPublisherIdGet(publisherId)

특정 퍼블리셔가 만든 만남 조회

특정 퍼블리셔가 만든 만남 조회

### Example
```java
// Import classes:
//import io.swagger.client.api.MeetingApi;

MeetingApi apiInstance = new MeetingApi();
Integer publisherId = 56; // Integer | 만든 만남을 조회하고 싶은 퍼블리셔의 user_id
try {
    List<InlineResponse2002> result = apiInstance.meetingPublisherIdGet(publisherId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MeetingApi#meetingPublisherIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **publisherId** | **Integer**| 만든 만남을 조회하고 싶은 퍼블리셔의 user_id |

### Return type

[**List&lt;InlineResponse2002&gt;**](InlineResponse2002.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

