// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.


// This file is autogenerated by
//     third_party/jni_zero/jni_generator.py
// For
//     android/net/connectivity/org/chromium/net/HttpNegotiateAuthenticator

#ifndef android_net_connectivity_org_chromium_net_HttpNegotiateAuthenticator_JNI
#define android_net_connectivity_org_chromium_net_HttpNegotiateAuthenticator_JNI

#include <jni.h>

#include "third_party/jni_zero/jni_export.h"
#include "third_party/jni_zero/jni_zero_helper.h"


// Step 1: Forward declarations.

JNI_ZERO_COMPONENT_BUILD_EXPORT extern const char
    kClassPath_android_net_connectivity_org_chromium_net_HttpNegotiateAuthenticator[];
const char kClassPath_android_net_connectivity_org_chromium_net_HttpNegotiateAuthenticator[] =
    "android/net/connectivity/org/chromium/net/HttpNegotiateAuthenticator";
// Leaking this jclass as we cannot use LazyInstance from some threads.
JNI_ZERO_COMPONENT_BUILD_EXPORT std::atomic<jclass>
    g_android_net_connectivity_org_chromium_net_HttpNegotiateAuthenticator_clazz(nullptr);
#ifndef android_net_connectivity_org_chromium_net_HttpNegotiateAuthenticator_clazz_defined
#define android_net_connectivity_org_chromium_net_HttpNegotiateAuthenticator_clazz_defined
inline jclass android_net_connectivity_org_chromium_net_HttpNegotiateAuthenticator_clazz(JNIEnv*
    env) {
  return base::android::LazyGetClass(env,
      kClassPath_android_net_connectivity_org_chromium_net_HttpNegotiateAuthenticator,
      &g_android_net_connectivity_org_chromium_net_HttpNegotiateAuthenticator_clazz);
}
#endif


// Step 2: Constants (optional).


// Step 3: Method stubs.
namespace net {
namespace android {

JNI_BOUNDARY_EXPORT void Java_android_net_connectivity_J_N_MjziZhxX(
    JNIEnv* env,
    jclass jcaller,
    jlong nativeJavaNegotiateResultWrapper,
    jobject caller,
    jint status,
    jstring authToken) {
  JavaNegotiateResultWrapper* native =
      reinterpret_cast<JavaNegotiateResultWrapper*>(nativeJavaNegotiateResultWrapper);
  CHECK_NATIVE_PTR(env, jcaller, native, "SetResult");
  return native->SetResult(env, base::android::JavaParamRef<jobject>(env, caller), status,
      base::android::JavaParamRef<jstring>(env, authToken));
}


static std::atomic<jmethodID>
    g_android_net_connectivity_org_chromium_net_HttpNegotiateAuthenticator_create1(nullptr);
static base::android::ScopedJavaLocalRef<jobject> Java_HttpNegotiateAuthenticator_create(JNIEnv*
    env, const base::android::JavaRef<jstring>& accountType) {
  jclass clazz = android_net_connectivity_org_chromium_net_HttpNegotiateAuthenticator_clazz(env);
  CHECK_CLAZZ(env, clazz,
      android_net_connectivity_org_chromium_net_HttpNegotiateAuthenticator_clazz(env), nullptr);

  jni_generator::JniJavaCallContextChecked call_context;
  call_context.Init<
      base::android::MethodID::TYPE_STATIC>(
          env,
          clazz,
          "create",
"(Ljava/lang/String;)Landroid/net/connectivity/org/chromium/net/HttpNegotiateAuthenticator;",
          &g_android_net_connectivity_org_chromium_net_HttpNegotiateAuthenticator_create1);

  jobject ret =
      env->CallStaticObjectMethod(clazz,
          call_context.base.method_id, accountType.obj());
  return base::android::ScopedJavaLocalRef<jobject>(env, ret);
}

static std::atomic<jmethodID>
    g_android_net_connectivity_org_chromium_net_HttpNegotiateAuthenticator_getNextAuthToken4(nullptr);
static void Java_HttpNegotiateAuthenticator_getNextAuthToken(JNIEnv* env, const
    base::android::JavaRef<jobject>& obj, jlong nativeResultObject,
    const base::android::JavaRef<jstring>& principal,
    const base::android::JavaRef<jstring>& authToken,
    jboolean canDelegate) {
  jclass clazz = android_net_connectivity_org_chromium_net_HttpNegotiateAuthenticator_clazz(env);
  CHECK_CLAZZ(env, obj.obj(),
      android_net_connectivity_org_chromium_net_HttpNegotiateAuthenticator_clazz(env));

  jni_generator::JniJavaCallContextChecked call_context;
  call_context.Init<
      base::android::MethodID::TYPE_INSTANCE>(
          env,
          clazz,
          "getNextAuthToken",
          "(JLjava/lang/String;Ljava/lang/String;Z)V",
&g_android_net_connectivity_org_chromium_net_HttpNegotiateAuthenticator_getNextAuthToken4);

     env->CallVoidMethod(obj.obj(),
          call_context.base.method_id, nativeResultObject, principal.obj(), authToken.obj(),
              canDelegate);
}

}  // namespace android
}  // namespace net

#endif  // android_net_connectivity_org_chromium_net_HttpNegotiateAuthenticator_JNI
