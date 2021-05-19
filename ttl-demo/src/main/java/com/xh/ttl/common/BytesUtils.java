package com.xh.ttl.common;

/**
 * author  Xiao Hong
 * date  2021/5/19 20:21
 * description
 */
public class BytesUtils {

    public static byte[] longToByte(long res) {
        byte[] buffer = new byte[8];
        for (int i = 0; i < 8; i++) {
            int offset = 64 - (i + 1) * 8;
            buffer[i] = (byte) ((res >> offset) & 0xff);
        }
        return buffer;
    }

    public static long bytesToLong(byte[] bytes) {
        long val = 0;
        for (int i = 0; i < 8; i++) {
            val <<= 8;
            val |= (bytes[i] & 0xff);
        }
        return val;
    }

}
