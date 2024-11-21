// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.


// This file is autogenerated by
//     third_party/jni_zero/jni_generator.py
// For
//     android/net/connectivity/org/chromium/url/IDNStringUtil

#ifndef android_net_connectivity_org_chromium_url_IDNStringUtil_JNI
#define android_net_connectivity_org_chromium_url_IDNStringUtil_JNI

#include <jni.h>

#include "third_party/jni_zero/jni_export.h"
#include "third_party/jni_zero/jni_zero_helper.h"


// Step 1: Forward declarations.

JNI_ZERO_COMPONENT_BUILD_EXPORT extern const char
    kClassPath_android_net_connectivity_org_chromium_url_IDNStringUtil[];
const char kClassPath_android_net_connectivity_org_chromium_url_IDNStringUtil[] =
    "android/net/connectivity/org/chromium/url/IDNStringUtil";
// Leaking this jclass as we cannot use LazyInstance from some threads.
JNI_ZERO_COMPONENT_BUILD_EXPORT std::atomic<jclass>
    g_android_net_connectivity_org_chromium_url_IDNStringUtil_clazz(nullptr);
#ifndef android_net_connectivity_org_chromium_url_IDNStringUtil_clazz_defined
#define android_net_connectivity_org_chromium_url_IDNStringUtil_clazz_defined
inline jclass android_net_connectivity_org_chromium_url_IDNStringUtil_clazz(JNIEnv* env) {
  return base::android::LazyGetClass(env,
      kClassPath_android_net_connectivity_org_chromium_url_IDNStringUtil,
      &g_android_net_connectivity_org_chromium_url_IDNStringUtil_clazz);
}
#endif


// Step 2: Constants (optional).


// Step 3: Method stubs.
namespace url {
namespace android {


static std::atomic<jmethodID>
    g_android_net_connectivity_org_chromium_url_IDNStringUtil_idnToASCII1(nullptr);
static base::android::ScopedJavaLocalRef<jstring> Java_IDNStringUtil_idnToASCII(JNIEnv* env, const
    base::android::JavaRef<jstring>& src) {
  jclass clazz = android_net_connectivity_org_chromium_url_IDNStringUtil_clazz(env);
  CHECK_CLAZZ(env, clazz,
      android_net_connectivity_org_chromium_url_IDNStringUtil_clazz(env), nullptr);

  jni_generator::JniJavaCallContextChecked call_context;
  call_context.Init<
      base::android::MethodID::TYPE_STATIC>(
          env,
          clazz,
          "idnToASCII",
          "(Ljava/lang/String;)Ljava/lang/String;",
          &g_android_net_connectivity_org_chromium_url_IDNStringUtil_idnToASCII1);

  jstring ret =
      static_cast<jstring>(env->CallStaticObjectMethod(clazz,
          call_context.base.method_id, src.obj()));
  return base::android::ScopedJavaLocalRef<jstring>(env, ret);
}

}  // namespace android
}  // namespace url

#endif  // android_net_connectivity_org_chromium_url_IDNStringUtil_JNI
