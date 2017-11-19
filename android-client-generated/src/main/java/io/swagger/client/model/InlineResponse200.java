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

package io.swagger.client.model;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

@ApiModel(description = "")
public class InlineResponse200 {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("token")
  private String token = null;
  @SerializedName("username")
  private String username = null;
  @SerializedName("type")
  private String type = null;
  @SerializedName("full_name")
  private String fullName = null;
  @SerializedName("job")
  private String job = null;
  @SerializedName("phone_number")
  private String phoneNumber = null;
  @SerializedName("profile_photo_path")
  private String profilePhotoPath = null;

  /**
   **/
  @ApiModelProperty(value = "")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getToken() {
    return token;
  }
  public void setToken(String token) {
    this.token = token;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getFullName() {
    return fullName;
  }
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getJob() {
    return job;
  }
  public void setJob(String job) {
    this.job = job;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getPhoneNumber() {
    return phoneNumber;
  }
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getProfilePhotoPath() {
    return profilePhotoPath;
  }
  public void setProfilePhotoPath(String profilePhotoPath) {
    this.profilePhotoPath = profilePhotoPath;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse200 inlineResponse200 = (InlineResponse200) o;
    return (this.id == null ? inlineResponse200.id == null : this.id.equals(inlineResponse200.id)) &&
        (this.token == null ? inlineResponse200.token == null : this.token.equals(inlineResponse200.token)) &&
        (this.username == null ? inlineResponse200.username == null : this.username.equals(inlineResponse200.username)) &&
        (this.type == null ? inlineResponse200.type == null : this.type.equals(inlineResponse200.type)) &&
        (this.fullName == null ? inlineResponse200.fullName == null : this.fullName.equals(inlineResponse200.fullName)) &&
        (this.job == null ? inlineResponse200.job == null : this.job.equals(inlineResponse200.job)) &&
        (this.phoneNumber == null ? inlineResponse200.phoneNumber == null : this.phoneNumber.equals(inlineResponse200.phoneNumber)) &&
        (this.profilePhotoPath == null ? inlineResponse200.profilePhotoPath == null : this.profilePhotoPath.equals(inlineResponse200.profilePhotoPath));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.token == null ? 0: this.token.hashCode());
    result = 31 * result + (this.username == null ? 0: this.username.hashCode());
    result = 31 * result + (this.type == null ? 0: this.type.hashCode());
    result = 31 * result + (this.fullName == null ? 0: this.fullName.hashCode());
    result = 31 * result + (this.job == null ? 0: this.job.hashCode());
    result = 31 * result + (this.phoneNumber == null ? 0: this.phoneNumber.hashCode());
    result = 31 * result + (this.profilePhotoPath == null ? 0: this.profilePhotoPath.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200 {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  token: ").append(token).append("\n");
    sb.append("  username: ").append(username).append("\n");
    sb.append("  type: ").append(type).append("\n");
    sb.append("  fullName: ").append(fullName).append("\n");
    sb.append("  job: ").append(job).append("\n");
    sb.append("  phoneNumber: ").append(phoneNumber).append("\n");
    sb.append("  profilePhotoPath: ").append(profilePhotoPath).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}