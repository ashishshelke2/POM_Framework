package util;

import base.BasicTest;

public class Property extends BasicTest {
    public static String USERNAME = props.getProperty("username");
    public static String PASSWORD = props.getProperty("password");
    public static String URL = props.getProperty("url");
}
