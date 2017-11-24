package org.androidtown.signalapplication.Server;

public class NetDefine {
    public static final String PATH = "52.79.36.12";
    public static final int PORT = 7504;

    public static String getBasicPath() {
        return "http://"+PATH+":"+PORT;
    }
}
