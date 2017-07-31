package com.react_native_socket;

import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * Created by mytream on 17/7/31.
 */

public class HelloModule extends ReactContextBaseJavaModule {
    private static final String DURATION_SHORT_KEY = "SHORT";
    private static final String DURATION_LONG_KEY = "LONG";

    public HelloModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    /**
     * 必须要实现，在JavaScript中使用该Native模块的名称
     * @return
     */
    @Override
    public String getName() {
        return "HelloAndroid";
    }


    /**
     * 暴露给JavaScript的常量
     * @return
     */
    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> consts = new HashMap<>();
        consts.put(DURATION_LONG_KEY, Toast.LENGTH_LONG);
        consts.put(DURATION_SHORT_KEY, Toast.LENGTH_SHORT);

        return consts;
    }

    /**
     * 展示Toast信息，使用@ReactMethod注解来标识
     * @param message 信息内容
     * @param duration 持续时间，使用常量
     */
    public void show(String message, int duration) {
        Toast.makeText(getReactApplicationContext(), message, duration).show();
    }
}
