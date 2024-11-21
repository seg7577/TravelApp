/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.adservices.ondevicepersonalization;

import android.annotation.FlaggedApi;
import android.annotation.NonNull;
import android.net.Uri;

import com.android.adservices.ondevicepersonalization.flags.Flags;
import com.android.ondevicepersonalization.internal.util.AnnotationValidations;
import com.android.ondevicepersonalization.internal.util.DataClass;

/**
 * The input data for
 * {@link IsolatedWorker#onWebTrigger(WebTriggerInput, android.os.OutcomeReceiver)}.
 */
@FlaggedApi(Flags.FLAG_ON_DEVICE_PERSONALIZATION_APIS_ENABLED)
@DataClass(genBuilder = false, genHiddenConstructor = true, genEqualsHashCode = true)
public final class WebTriggerInput {
    /** The destination URL (landing page) where the trigger event occurred. */
    @NonNull private Uri mDestinationUrl;

    /** The app where the trigger event occurred */
    @NonNull private String mAppPackageName;

    /**
     * Additional data returned by the server as part of the web trigger registration
     * to be sent to the {@link IsolatedService}. This can be {@code null} if the server
     * does not need to send data to the service for processing web triggers.
     */
    @NonNull private byte[] mData;

    /** @hide */
    public WebTriggerInput(@NonNull WebTriggerInputParcel parcel) {
        this(parcel.getDestinationUrl(), parcel.getAppPackageName(), parcel.getData());
    }



    // Code below generated by codegen v1.0.23.
    //
    // DO NOT MODIFY!
    // CHECKSTYLE:OFF Generated code
    //
    // To regenerate run:
    // $ codegen $ANDROID_BUILD_TOP/packages/modules/OnDevicePersonalization/framework/java/android/adservices/ondevicepersonalization/WebTriggerInput.java
    //
    // To exclude the generated code from IntelliJ auto-formatting enable (one-time):
    //   Settings > Editor > Code Style > Formatter Control
    //@formatter:off


    /**
     * Creates a new WebTriggerInput.
     *
     * @param destinationUrl
     *   The destination URL (landing page) where the trigger event occurred.
     * @param appPackageName
     *   The app where the trigger event occurred
     * @param data
     *   Additional data returned by the server as part of the web trigger registration
     *   to be sent to the {@link IsolatedService}. This can be {@code null} if the server
     *   does not need to send data to the service for processing web triggers.
     * @hide
     */
    @DataClass.Generated.Member
    public WebTriggerInput(
            @NonNull Uri destinationUrl,
            @NonNull String appPackageName,
            @NonNull byte[] data) {
        this.mDestinationUrl = destinationUrl;
        AnnotationValidations.validate(
                NonNull.class, null, mDestinationUrl);
        this.mAppPackageName = appPackageName;
        AnnotationValidations.validate(
                NonNull.class, null, mAppPackageName);
        this.mData = data;
        AnnotationValidations.validate(
                NonNull.class, null, mData);

        // onConstructed(); // You can define this method to get a callback
    }

    /**
     * The destination URL (landing page) where the trigger event occurred.
     */
    @DataClass.Generated.Member
    public @NonNull Uri getDestinationUrl() {
        return mDestinationUrl;
    }

    /**
     * The app where the trigger event occurred
     */
    @DataClass.Generated.Member
    public @NonNull String getAppPackageName() {
        return mAppPackageName;
    }

    /**
     * Additional data returned by the server as part of the web trigger registration
     * to be sent to the {@link IsolatedService}. This can be {@code null} if the server
     * does not need to send data to the service for processing web triggers.
     */
    @DataClass.Generated.Member
    public @NonNull byte[] getData() {
        return mData;
    }

    @Override
    @DataClass.Generated.Member
    public boolean equals(@android.annotation.Nullable Object o) {
        // You can override field equality logic by defining either of the methods like:
        // boolean fieldNameEquals(WebTriggerInput other) { ... }
        // boolean fieldNameEquals(FieldType otherValue) { ... }

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        @SuppressWarnings("unchecked")
        WebTriggerInput that = (WebTriggerInput) o;
        //noinspection PointlessBooleanExpression
        return true
                && java.util.Objects.equals(mDestinationUrl, that.mDestinationUrl)
                && java.util.Objects.equals(mAppPackageName, that.mAppPackageName)
                && java.util.Arrays.equals(mData, that.mData);
    }

    @Override
    @DataClass.Generated.Member
    public int hashCode() {
        // You can override field hashCode logic by defining methods like:
        // int fieldNameHashCode() { ... }

        int _hash = 1;
        _hash = 31 * _hash + java.util.Objects.hashCode(mDestinationUrl);
        _hash = 31 * _hash + java.util.Objects.hashCode(mAppPackageName);
        _hash = 31 * _hash + java.util.Arrays.hashCode(mData);
        return _hash;
    }

    @DataClass.Generated(
            time = 1707513068642L,
            codegenVersion = "1.0.23",
            sourceFile = "packages/modules/OnDevicePersonalization/framework/java/android/adservices/ondevicepersonalization/WebTriggerInput.java",
            inputSignatures = "private @android.annotation.NonNull android.net.Uri mDestinationUrl\nprivate @android.annotation.NonNull java.lang.String mAppPackageName\nprivate @android.annotation.NonNull byte[] mData\nclass WebTriggerInput extends java.lang.Object implements []\n@com.android.ondevicepersonalization.internal.util.DataClass(genBuilder=false, genHiddenConstructor=true, genEqualsHashCode=true)")
    @Deprecated
    private void __metadata() {}


    //@formatter:on
    // End of generated code

}