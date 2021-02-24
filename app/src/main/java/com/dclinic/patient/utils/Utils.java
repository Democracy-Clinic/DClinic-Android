package com.dclinic.patient.utils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Utils {
    public static String getJson(Context context, String file) {
        String jsonData;
        try {
            InputStream stream = context.getAssets().open(file);
            int size = stream.available();
            byte[] strBuffer = new byte[size];
            stream.read(strBuffer);
            stream.close();
            jsonData = new String(strBuffer, StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return jsonData;
    }
}