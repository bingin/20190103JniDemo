//
// Created by bingin on 2019/1/4.
//

#include <jni.h>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>

jstring
Java_com_bingin_jnidemo_JniFirstActivity_jniFistMothod(JNIEnv *env, jobject jobj, jstring jstr) {

    const char *para1 = (*env)->GetStringUTFChars(env, jstr, JNI_FALSE);

    char *retStr = "Return From jnifirst.c";
    char *data = (char *) malloc(strlen(para1) + strlen(retStr) + 1);

    strcpy(data, para1);
    strcat(data, " JNI Reply: ");
    strcat(data, retStr);

    return (*env)->NewStringUTF(env, data);
}
