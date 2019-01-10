//
// Created by bingin on 2019/1/10.
//

#include <jni.h>
#include <stdlib.h>
#include <string.h>

JNIEXPORT jstring JNICALL
Java_com_bingin_jnidemo_MainActivity_answerFromJni(JNIEnv *env, jobject instance, jstring question_) {
    const char *question = (*env)->GetStringUTFChars(env, question_, 0);

    char answer[20];
    char *note = "Answer form JNI is : ";
    const char *returnValue = malloc(strlen(question) + strlen(note) + 1);
    strcpy(returnValue, note);

    if (strcmp(question, "name") == 0) {
        strcpy(answer, "zhangsan");
        strcat(returnValue, answer);
    } else if (strcmp(question, "age") == 0) {
        strcpy(answer, "16");
        strcat(returnValue, answer);
    } else {
        strcpy(answer, "invalid para");
        strcat(returnValue, answer);
    }

    (*env)->ReleaseStringUTFChars(env, question_, question);

    return (*env)->NewStringUTF(env, returnValue);
}
