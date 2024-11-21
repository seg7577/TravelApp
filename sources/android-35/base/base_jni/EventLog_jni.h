// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.


// This file is autogenerated by
//     third_party/jni_zero/jni_generator.py
// For
//     android/net/connectivity/org/chromium/base/EventLog

#ifndef android_net_connectivity_org_chromium_base_EventLog_JNI
#define android_net_connectivity_org_chromium_base_EventLog_JNI

#include <jni.h>

#include "third_party/jni_zero/jni_export.h"
#include "third_party/jni_zero/jni_zero_helper.h"


// Step 1: Forward declarations.

JNI_ZERO_COMPONENT_BUILD_EXPORT extern const char
    kClassPath_android_net_connectivity_org_chromium_base_EventLog[];
const char kClassPath_android_net_connectivity_org_chromium_base_EventLog[] =
    "android/net/connectivity/org/chromium/base/EventLog";
// Leaking this jclass as we cannot use LazyInstance from some threads.
JNI_ZERO_COMPONENT_BUILD_EXPORT std::atomic<jclass>
    g_android_net_connectivity_org_chromium_base_EventLog_clazz(nullptr);
#ifndef android_net_connectivity_org_chromium_base_EventLog_clazz_defined
#define android_net_connectivity_org_chromium_base_EventLog_clazz_defined
inline jclass android_net_connectivity_org_chromium_base_EventLog_clazz(JNIEnv* env) {
  return base::android::LazyGetClass(env,
      kClassPath_android_net_connectivity_org_chromium_base_EventLog,
      &g_android_net_connectivity_org_chromium_base_EventLog_clazz);
}
#endif


// Step 2: Constants (optional).


// Step 3: Method stubs.
namespace base {
namespace android {


static std::atomic<jmethodID>
    g_android_net_connectivity_org_chromium_base_EventLog_writeEvent2(nullptr);
static void Java_EventLog_writeEvent(JNIEnv* env, JniIntWrapper tag,
    JniIntWrapper value) {
  jclass clazz = android_net_connectivity_org_chromium_base_EventLog_clazz(env);
  CHECK_CLAZZ(env, clazz,
      android_net_connectivity_org_chromium_base_EventLog_clazz(env));

  jni_generator::JniJavaCallContextChecked call_context;
  call_context.Init<
      base::android::MethodID::TYPE_STATIC>(
          env,
          clazz,
          "writeEvent",
          "(II)V",
          &g_android_net_connectivity_org_chromium_base_EventLog_writeEvent2);

     env->CallStaticVoidMethod(clazz,
          call_context.base.method_id, as_jint(tag), as_jint(value));
}

}  // namespace android
}  // namespace base

#endif  // android_net_connectivity_org_chromium_base_EventLog_JNI
