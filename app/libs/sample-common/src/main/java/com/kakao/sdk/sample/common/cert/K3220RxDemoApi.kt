/*
  Copyright 2024 Kakao Corp.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
 */
package com.kakao.sdk.sample.common.cert

import com.kakao.sdk.sample.common.cert.model.CertDemoResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface K3220RxDemoApi {
    @POST("v1/k3220/sign")
    fun sign(
        @Body param: Map<String, String>,
    ): Single<CertDemoResponse>

    @POST("v1/k3220/verify")
    fun verify(
        @Body params: HashMap<String, Any>,
    ): Single<CertDemoResponse>

    @POST("v1/k3220/reduction-sign")
    fun reducedSign(
        @Body params: Map<String, String>,
    ): Single<CertDemoResponse>
}
