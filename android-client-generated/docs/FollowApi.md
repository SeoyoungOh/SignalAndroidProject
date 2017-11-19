# FollowApi

All URIs are relative to *http://13.124.38.242:7504/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**accountFollowerGet**](FollowApi.md#accountFollowerGet) | **GET** /account/follower | 퍼블리셔 본인의 팔로워 조회
[**accountFollowingGet**](FollowApi.md#accountFollowingGet) | **GET** /account/following | 팔로잉 중인 퍼블리셔 조회
[**accountFollowingPost**](FollowApi.md#accountFollowingPost) | **POST** /account/following | 팔로잉 생성
[**accountFollowingPublisherIdDelete**](FollowApi.md#accountFollowingPublisherIdDelete) | **DELETE** /account/following/{publisher_id} | 팔로잉 중인 퍼블리셔 삭제


<a name="accountFollowerGet"></a>
# **accountFollowerGet**
> List&lt;InlineResponse2002&gt; accountFollowerGet(authorization)

퍼블리셔 본인의 팔로워 조회

퍼블리셔만 사용할 수 있는 API

### Example
```java
// Import classes:
//import io.swagger.client.api.FollowApi;

FollowApi apiInstance = new FollowApi();
String authorization = "authorization_example"; // String | 유저 토큰
try {
    List<InlineResponse2002> result = apiInstance.accountFollowerGet(authorization);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FollowApi#accountFollowerGet");
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

<a name="accountFollowingGet"></a>
# **accountFollowingGet**
> List&lt;InlineResponse2002&gt; accountFollowingGet(authorization)

팔로잉 중인 퍼블리셔 조회

팔로잉 중인 퍼블리셔 조회

### Example
```java
// Import classes:
//import io.swagger.client.api.FollowApi;

FollowApi apiInstance = new FollowApi();
String authorization = "authorization_example"; // String | 유저 토큰
try {
    List<InlineResponse2002> result = apiInstance.accountFollowingGet(authorization);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FollowApi#accountFollowingGet");
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

<a name="accountFollowingPost"></a>
# **accountFollowingPost**
> InlineResponse201 accountFollowingPost(authorization, followerId)

팔로잉 생성

팔로잉 생성

### Example
```java
// Import classes:
//import io.swagger.client.api.FollowApi;

FollowApi apiInstance = new FollowApi();
String authorization = "authorization_example"; // String | 유저 토큰
Integer followerId = 56; // Integer | 팔로잉하고 싶은 퍼블리셔의 user_id
try {
    InlineResponse201 result = apiInstance.accountFollowingPost(authorization, followerId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FollowApi#accountFollowingPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| 유저 토큰 |
 **followerId** | **Integer**| 팔로잉하고 싶은 퍼블리셔의 user_id |

### Return type

[**InlineResponse201**](InlineResponse201.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data, application/x-www-form-urlencoded
 - **Accept**: application/json

<a name="accountFollowingPublisherIdDelete"></a>
# **accountFollowingPublisherIdDelete**
> accountFollowingPublisherIdDelete(publisherId, authorization)

팔로잉 중인 퍼블리셔 삭제

팔로잉 중인 퍼블리셔 팔로잉 취소

### Example
```java
// Import classes:
//import io.swagger.client.api.FollowApi;

FollowApi apiInstance = new FollowApi();
Integer publisherId = 56; // Integer | 팔로잉삭제 하고 싶은 퍼블리셔의 user_id
String authorization = "authorization_example"; // String | 유저 토큰
try {
    apiInstance.accountFollowingPublisherIdDelete(publisherId, authorization);
} catch (ApiException e) {
    System.err.println("Exception when calling FollowApi#accountFollowingPublisherIdDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **publisherId** | **Integer**| 팔로잉삭제 하고 싶은 퍼블리셔의 user_id |
 **authorization** | **String**| 유저 토큰 |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

