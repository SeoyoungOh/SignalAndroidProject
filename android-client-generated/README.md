# swagger-android-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-android-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-android-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-android-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.swagger.client.api.AccountApi;

public class AccountApiExample {

    public static void main(String[] args) {
        AccountApi apiInstance = new AccountApi();
        String authorization = "authorization_example"; // String | 로그인할 때 반환 받은 `유저 토큰` (e.g. `e6a16f6b26bf7ba14a3ca689aa1234e0f70cae45`)
        try {
            InlineResponse2001 result = apiInstance.accountDelete(authorization);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AccountApi#accountDelete");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *http://13.124.38.242:7504/*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AccountApi* | [**accountDelete**](docs/AccountApi.md#accountDelete) | **DELETE** /account/ | User delete
*AccountApi* | [**accountGet**](docs/AccountApi.md#accountGet) | **GET** /account/ | Get user info
*AccountApi* | [**accountLoginPost**](docs/AccountApi.md#accountLoginPost) | **POST** /account/login | User login
*AccountApi* | [**accountLogoutGet**](docs/AccountApi.md#accountLogoutGet) | **GET** /account/logout | User logout
*AccountApi* | [**accountPost**](docs/AccountApi.md#accountPost) | **POST** /account/ | User Register
*AccountApi* | [**accountPut**](docs/AccountApi.md#accountPut) | **PUT** /account/ | User update
*FollowApi* | [**accountFollowerGet**](docs/FollowApi.md#accountFollowerGet) | **GET** /account/follower | 퍼블리셔 본인의 팔로워 조회
*FollowApi* | [**accountFollowingGet**](docs/FollowApi.md#accountFollowingGet) | **GET** /account/following | 팔로잉 중인 퍼블리셔 조회
*FollowApi* | [**accountFollowingPost**](docs/FollowApi.md#accountFollowingPost) | **POST** /account/following | 팔로잉 생성
*FollowApi* | [**accountFollowingPublisherIdDelete**](docs/FollowApi.md#accountFollowingPublisherIdDelete) | **DELETE** /account/following/{publisher_id} | 팔로잉 중인 퍼블리셔 삭제
*MeetingApi* | [**meetingGet**](docs/MeetingApi.md#meetingGet) | **GET** /meeting/ | 서버에 있는 모든 만남 조회
*MeetingApi* | [**meetingParticipateGet**](docs/MeetingApi.md#meetingParticipateGet) | **GET** /meeting/participate | 내가 참여한 모든 만남 조회
*MeetingApi* | [**meetingParticipatePost**](docs/MeetingApi.md#meetingParticipatePost) | **POST** /meeting/participate | 만남 참여하기
*MeetingApi* | [**meetingPost**](docs/MeetingApi.md#meetingPost) | **POST** /meeting/ | 만남 생성
*MeetingApi* | [**meetingPublisherIdGet**](docs/MeetingApi.md#meetingPublisherIdGet) | **GET** /meeting/{publisher_id} | 특정 퍼블리셔가 만든 만남 조회
*SignalingApi* | [**demandMeetingGet**](docs/SignalingApi.md#demandMeetingGet) | **GET** /demand/meeting | 요청받은 만남 보기
*SignalingApi* | [**demandMeetingPost**](docs/SignalingApi.md#demandMeetingPost) | **POST** /demand/meeting | 만남 요청하기
*SignalingApi* | [**demandPersonPost**](docs/SignalingApi.md#demandPersonPost) | **POST** /demand/person | 퍼블리셔 요청하기
*UtilApi* | [**accountPublisherSearchGet**](docs/UtilApi.md#accountPublisherSearchGet) | **GET** /account/publisher/search | 이름으로 퍼블리셔 검색
*UtilApi* | [**accountRecommendPublisherGet**](docs/UtilApi.md#accountRecommendPublisherGet) | **GET** /account/recommend_publisher | 추천 퍼블리셔 정보 가져오기
*UtilApi* | [**mediaPhotoPathGet**](docs/UtilApi.md#mediaPhotoPathGet) | **GET** /media/{photo_path} | 사진 파일 가져오기


## Documentation for Models

 - [InlineResponse200](docs/InlineResponse200.md)
 - [InlineResponse2001](docs/InlineResponse2001.md)
 - [InlineResponse2002](docs/InlineResponse2002.md)
 - [InlineResponse201](docs/InlineResponse201.md)
 - [InlineResponse2011](docs/InlineResponse2011.md)
 - [InlineResponse2012](docs/InlineResponse2012.md)
 - [InlineResponse2013](docs/InlineResponse2013.md)
 - [InlineResponse2014](docs/InlineResponse2014.md)
 - [InlineResponse400](docs/InlineResponse400.md)
 - [InlineResponse401](docs/InlineResponse401.md)
 - [InlineResponse4011](docs/InlineResponse4011.md)
 - [InlineResponse410](docs/InlineResponse410.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



