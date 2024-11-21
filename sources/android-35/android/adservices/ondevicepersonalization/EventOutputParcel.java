/*
 * Copyright (C) 2023 The Android Open Source Project
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

import android.annotation.NonNull;
import android.annotation.Nullable;
import android.os.Parcelable;

import com.android.ondevicepersonalization.internal.util.DataClass;

/**
 * Parcelable version of {@link EventOutput}.
 * @hide
 */
@DataClass(genAidl = false, genBuilder = false)
public final class EventOutputParcel implements Parcelable {
    /**
     * An {@link EventLogRecord} to be written to the EVENTS table, if not null. Each
     * {@link EventLogRecord} is associated with a row in an existing {@link RequestLogRecord} that
     * has been written to the REQUESTS table.
     */
    @Nullable EventLogRecord mEventLogRecord = null;

    /** @hide */
    public EventOutputParcel(@NonNull EventOutput value) {
        this(value.getEventLogRecord());
    }



    // Code below generated by codegen v1.0.23.
    //
    // DO NOT MODIFY!
    // CHECKSTYLE:OFF Generated code
    //
    // To regenerate run:
    // $ codegen $ANDROID_BUILD_TOP/packages/modules/OnDevicePersonalization/framework/java/android/adservices/ondevicepersonalization/EventOutputParcel.java
    //
    // To exclude the generated code from IntelliJ auto-formatting enable (one-time):
    //   Settings > Editor > Code Style > Formatter Control
    //@formatter:off


    /**
     * Creates a new EventOutputParcel.
     *
     * @param eventLogRecord
     *   An {@link EventLogRecord} to be written to the EVENTS table, if not null. Each
     *   {@link EventLogRecord} is associated with a row in an existing {@link RequestLogRecord} that
     *   has been written to the REQUESTS table.
     */
    @DataClass.Generated.Member
    public EventOutputParcel(
            @Nullable EventLogRecord eventLogRecord) {
        this.mEventLogRecord = eventLogRecord;

        // onConstructed(); // You can define this method to get a callback
    }

    /**
     * An {@link EventLogRecord} to be written to the EVENTS table, if not null. Each
     * {@link EventLogRecord} is associated with a row in an existing {@link RequestLogRecord} that
     * has been written to the REQUESTS table.
     */
    @DataClass.Generated.Member
    public @Nullable EventLogRecord getEventLogRecord() {
        return mEventLogRecord;
    }

    @Override
    @DataClass.Generated.Member
    public void writeToParcel(@android.annotation.NonNull android.os.Parcel dest, int flags) {
        // You can override field parcelling by defining methods like:
        // void parcelFieldName(Parcel dest, int flags) { ... }

        byte flg = 0;
        if (mEventLogRecord != null) flg |= 0x1;
        dest.writeByte(flg);
        if (mEventLogRecord != null) dest.writeTypedObject(mEventLogRecord, flags);
    }

    @Override
    @DataClass.Generated.Member
    public int describeContents() { return 0; }

    /** @hide */
    @SuppressWarnings({"unchecked", "RedundantCast"})
    @DataClass.Generated.Member
    /* package-private */ EventOutputParcel(@android.annotation.NonNull android.os.Parcel in) {
        // You can override field unparcelling by defining methods like:
        // static FieldType unparcelFieldName(Parcel in) { ... }

        byte flg = in.readByte();
        EventLogRecord eventLogRecord = (flg & 0x1) == 0 ? null : (EventLogRecord) in.readTypedObject(EventLogRecord.CREATOR);

        this.mEventLogRecord = eventLogRecord;

        // onConstructed(); // You can define this method to get a callback
    }

    @DataClass.Generated.Member
    public static final @android.annotation.NonNull Parcelable.Creator<EventOutputParcel> CREATOR
            = new Parcelable.Creator<EventOutputParcel>() {
        @Override
        public EventOutputParcel[] newArray(int size) {
            return new EventOutputParcel[size];
        }

        @Override
        public EventOutputParcel createFromParcel(@android.annotation.NonNull android.os.Parcel in) {
            return new EventOutputParcel(in);
        }
    };

    @DataClass.Generated(
            time = 1698864082503L,
            codegenVersion = "1.0.23",
            sourceFile = "packages/modules/OnDevicePersonalization/framework/java/android/adservices/ondevicepersonalization/EventOutputParcel.java",
            inputSignatures = " @android.annotation.Nullable android.adservices.ondevicepersonalization.EventLogRecord mEventLogRecord\nclass EventOutputParcel extends java.lang.Object implements [android.os.Parcelable]\n@com.android.ondevicepersonalization.internal.util.DataClass(genAidl=false, genBuilder=false)")
    @Deprecated
    private void __metadata() {}


    //@formatter:on
    // End of generated code

}
