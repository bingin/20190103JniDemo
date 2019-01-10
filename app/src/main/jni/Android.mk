LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE := jni_first
LOCAL_SRC_FILES := jni_first.c

#LOCAL_C_INCLUDES += $(LOCAL_PATH)
#LOCAL_LDLIBS := -llog

include $(BUILD_SHARED_LIBRARY)