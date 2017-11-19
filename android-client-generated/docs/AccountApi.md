# AccountApi

All URIs are relative to *http://13.124.38.242:7504/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**accountDelete**](AccountApi.md#accountDelete) | **DELETE** /account/ | User delete
[**accountGet**](AccountApi.md#accountGet) | **GET** /account/ | Get user info
[**accountLoginPost**](AccountApi.md#accountLoginPost) | **POST** /account/login | User login
[**accountLogoutGet**](AccountApi.md#accountLogoutGet) | **GET** /account/logout | User logout
[**accountPost**](AccountApi.md#accountPost) | **POST** /account/ | User Register
[**accountPut**](AccountApi.md#accountPut) | **PUT** /account/ | User update


<a name="accountDelete"></a>
# **accountDelete**
> InlineResponse2001 accountDelete(authorization)

User delete

유저 삭제

### Example
```java
// Import classes:
//import io.swagger.client.api.AccountApi;

AccountApi apiInstance = new AccountApi();
String authorization = "authorization_example"; // String | 로그인할 때 반환 받은 `유저 토큰` (e.g. `e6a16f6b26bf7ba14a3ca689aa1234e0f70cae45`)
try {
    InlineResponse2001 result = apiInstance.accountDelete(authorization);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountApi#accountDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| 로그인할 때 반환 받은 &#x60;유저 토큰&#x60; (e.g. &#x60;e6a16f6b26bf7ba14a3ca689aa1234e0f70cae45&#x60;) |

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="accountGet"></a>
# **accountGet**
> InlineResponse200 accountGet(authorization)

Get user info

유저 정보

### Example
```java
// Import classes:
//import io.swagger.client.api.AccountApi;

AccountApi apiInstance = new AccountApi();
String authorization = "authorization_example"; // String | 로그인할 때 반환 받은 `유저 토큰` (e.g. `e6a16f6b26bf7ba14a3ca689aa1234e0f70cae45`)
try {
    InlineResponse200 result = apiInstance.accountGet(authorization);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountApi#accountGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| 로그인할 때 반환 받은 &#x60;유저 토큰&#x60; (e.g. &#x60;e6a16f6b26bf7ba14a3ca689aa1234e0f70cae45&#x60;) |

### Return type

[**InlineResponse200**](InlineResponse200.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="accountLoginPost"></a>
# **accountLoginPost**
> InlineResponse200 accountLoginPost(username, password)

User login

&#x60;multipart/form-data&#x60;으로 &#x60;username&#x60;(ID에 해당)과 &#x60;password&#x60;를 전송

### Example
```java
// Import classes:
//import io.swagger.client.api.AccountApi;

AccountApi apiInstance = new AccountApi();
String username = "username_example"; // String | 유저 ID (e.g. `new_guest`)
String password = "password_example"; // String | 유저 비밀번호 (e.g. `asdf1234`)
try {
    InlineResponse200 result = apiInstance.accountLoginPost(username, password);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountApi#accountLoginPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| 유저 ID (e.g. &#x60;new_guest&#x60;) |
 **password** | **String**| 유저 비밀번호 (e.g. &#x60;asdf1234&#x60;) |

### Return type

[**InlineResponse200**](InlineResponse200.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

<a name="accountLogoutGet"></a>
# **accountLogoutGet**
> InlineResponse2001 accountLogoutGet(authorization)

User logout

&#x60;HTTP Request Header&#x60;에 &#x60;Authorization&#x60;를 추가해 전송해야 함. 값은 &#x60;유저 토큰&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.api.AccountApi;

AccountApi apiInstance = new AccountApi();
String authorization = "authorization_example"; // String | 로그인할 때 반환 받은 `유저 토큰` (e.g. `e6a16f6b26bf7ba14a3ca689aa1234e0f70cae45`)
try {
    InlineResponse2001 result = apiInstance.accountLogoutGet(authorization);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountApi#accountLogoutGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| 로그인할 때 반환 받은 &#x60;유저 토큰&#x60; (e.g. &#x60;e6a16f6b26bf7ba14a3ca689aa1234e0f70cae45&#x60;) |

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="accountPost"></a>
# **accountPost**
> InlineResponse200 accountPost(username, password, profilePhoto, fullName, job, phoneNumber)

User Register

&#x60;multipart/form-data&#x60;으로 유저 가입 정보를 전송

### Example
```java
// Import classes:
//import io.swagger.client.api.AccountApi;

AccountApi apiInstance = new AccountApi();
String username = "username_example"; // String | 유저 ID (e.g. `new_guest`)
String password = "password_example"; // String | 유저 비밀번호 (e.g. `asdf1234`)
File profilePhoto = new File("/path/to/file.txt"); // File | `업로드 기능`을 사용해서 보낼 이미지 파일
String fullName = "fullName_example"; // String | 유저 이름 (e.g. `정의사`)
String job = "job_example"; // String | 유저 직업 (e.g. `간호사`)
String phoneNumber = "phoneNumber_example"; // String | 유저 폰번호 (e.g. `01012345678`)
try {
    InlineResponse200 result = apiInstance.accountPost(username, password, profilePhoto, fullName, job, phoneNumber);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountApi#accountPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| 유저 ID (e.g. &#x60;new_guest&#x60;) |
 **password** | **String**| 유저 비밀번호 (e.g. &#x60;asdf1234&#x60;) |
 **profilePhoto** | **File**| &#x60;업로드 기능&#x60;을 사용해서 보낼 이미지 파일 | [optional]
 **fullName** | **String**| 유저 이름 (e.g. &#x60;정의사&#x60;) | [optional]
 **job** | **String**| 유저 직업 (e.g. &#x60;간호사&#x60;) | [optional]
 **phoneNumber** | **String**| 유저 폰번호 (e.g. &#x60;01012345678&#x60;) | [optional]

### Return type

[**InlineResponse200**](InlineResponse200.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

<a name="accountPut"></a>
# **accountPut**
> InlineResponse2001 accountPut(authorization, username, password)

User update

유저 업데이트

### Example
```java
// Import classes:
//import io.swagger.client.api.AccountApi;

AccountApi apiInstance = new AccountApi();
String authorization = "authorization_example"; // String | 유저 토큰
String username = "username_example"; // String | 유저 ID (e.g. `new_guest`)
String password = "password_example"; // String | 유저 비밀번호 (e.g. `asdf1234`)
try {
    InlineResponse2001 result = apiInstance.accountPut(authorization, username, password);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountApi#accountPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| 유저 토큰 |
 **username** | **String**| 유저 ID (e.g. &#x60;new_guest&#x60;) |
 **password** | **String**| 유저 비밀번호 (e.g. &#x60;asdf1234&#x60;) |

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

