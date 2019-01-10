#include <jni.h>
#include <string>

#include <android/log.h>

extern "C"

#define LOG_TAG "来自JNI"
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR, LOG_TAG, __VA_ARGS__)

JNIEXPORT jstring JNICALL
Java_com_bingin_jnidemo_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++ 1";

    #ifdef Debug
    LOGE("log测试");
    #endif

    return env->NewStringUTF(hello.c_str());
}
