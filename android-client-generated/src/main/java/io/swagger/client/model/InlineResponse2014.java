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

package io.swagger.client.model;

import io.swagger.annotations.*;

import com.google.gson.annotations.SerializedName;

@ApiModel(description = "")
public class InlineResponse2014 {

    @SerializedName("full_name")
    private String fullName = null;
    @SerializedName("description")
    private String description = null;
    @SerializedName("job")
    private String job = null;
    @SerializedName("profile_photo_path")
    private String profilePhotoPath = null;
    @SerializedName("reference_link")
    private String referenceLink = null;

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
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    public String getProfilePhotoPath() {
        return profilePhotoPath;
    }

    public void setProfilePhotoPath(String profilePhotoPath) {
        this.profilePhotoPath = profilePhotoPath;
    }

    /**
     **/
    @ApiModelProperty(value = "")
    public String getReferenceLink() {
        return referenceLink;
    }

    public void setReferenceLink(String referenceLink) {
        this.referenceLink = referenceLink;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InlineResponse2014 inlineResponse2014 = (InlineResponse2014) o;
        return (this.fullName == null ? inlineResponse2014.fullName == null : this.fullName.equals(inlineResponse2014.fullName)) &&
                (this.description == null ? inlineResponse2014.description == null : this.description.equals(inlineResponse2014.description)) &&
                (this.job == null ? inlineResponse2014.job == null : this.job.equals(inlineResponse2014.job)) &&
                (this.profilePhotoPath == null ? inlineResponse2014.profilePhotoPath == null : this.profilePhotoPath.equals(inlineResponse2014.profilePhotoPath)) &&
                (this.referenceLink == null ? inlineResponse2014.referenceLink == null : this.referenceLink.equals(inlineResponse2014.referenceLink));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (this.fullName == null ? 0 : this.fullName.hashCode());
        result = 31 * result + (this.description == null ? 0 : this.description.hashCode());
        result = 31 * result + (this.job == null ? 0 : this.job.hashCode());
        result = 31 * result + (this.profilePhotoPath == null ? 0 : this.profilePhotoPath.hashCode());
        result = 31 * result + (this.referenceLink == null ? 0 : this.referenceLink.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InlineResponse2014 {\n");

        sb.append("  fullName: ").append(fullName).append("\n");
        sb.append("  description: ").append(description).append("\n");
        sb.append("  job: ").append(job).append("\n");
        sb.append("  profilePhotoPath: ").append(profilePhotoPath).append("\n");
        sb.append("  referenceLink: ").append(referenceLink).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
