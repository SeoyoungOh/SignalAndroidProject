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
public class InlineResponse2002 {
  
  @SerializedName("...")
  private String ___ = null;

  /**
   **/
  @ApiModelProperty(value = "")
  public String get_() {
    return ___;
  }
  public void set_(String ___) {
    this.___ = ___;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse2002 inlineResponse2002 = (InlineResponse2002) o;
    return (this.___ == null ? inlineResponse2002.___ == null : this.___.equals(inlineResponse2002.___));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.___ == null ? 0: this.___.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2002 {\n");
    
    sb.append("  ___: ").append(___).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}