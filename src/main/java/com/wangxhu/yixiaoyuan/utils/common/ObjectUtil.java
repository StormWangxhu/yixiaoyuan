package com.wangxhu.yixiaoyuan.utils.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ObjectUtil {

    /**
     * 判断任意对象是否为空
     *
     * @param object
     * @return
     */
    public static boolean isEmpty(Object object) {
        return object == null;
    }

    /**
     * 判断字符串是否为空
     *
     * @param string
     * @return
     */
    public static boolean isStringEmpty(String string) {
        if (string == null || string.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 对字符串进行过滤
     * @param oldString
     * @return
     */
    public static String getStringFilter(String oldString){
        //1.设置指定的非法字符
        Pattern pattern = Pattern.compile("[@# $%^&*()_+=,.;?/`~]");
        Matcher matcher =pattern.matcher(oldString);
        StringBuffer buffer = new StringBuffer();
        //如果找到非法字符
        while (matcher.find()){
            //若包含非法字符,则除去,并把非法字符前面的字符放到缓冲区
            matcher.appendReplacement(buffer,"");
        }
        //将剩余合法部分添加到缓冲区
        matcher.appendTail(buffer);
        return buffer.toString();
    }
}
