package com.wangshibiao.spring.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Created by Wang Shibiao on 2016/8/12.
 */

/**
 * 用于对字符串进行压缩和解压缩
 */
public class GzipUtil {
    /**
     * 对字符串压缩
     * @param str
     * @return
     * @throws IOException
     */
    public static String compress(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return "";
        }

        byte[] tArray;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(out);
        try {
            gzip.write(str.getBytes("UTF-8"));
            gzip.flush();
        } finally {
            gzip.close();
        }

        tArray = out.toByteArray();
        out.close();

        BASE64Encoder tBase64Encoder = new BASE64Encoder();
        return tBase64Encoder.encode(tArray);
    }

    /**
     * 对字符串解压缩
     * @param str
     * @return
     * @throws IOException
     */
    public static String uncompress(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return "";
        }

        BASE64Decoder tBase64Decoder = new BASE64Decoder();
        byte[] t = tBase64Decoder.decodeBuffer(str);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(t);
        GZIPInputStream gunzip = new GZIPInputStream(in);
        try {
            byte[] buffer = new byte[256];
            int n;
            while ((n = gunzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
        }finally{
            gunzip.close();
        }
        in.close();
        out.close();

        return out.toString("UTF-8");
    }

    public static void main(String[] args) throws IOException {
        String src = "{\"success\":true,\"message\":\"课件列表查询成功!\",\"error\":\"\",\"payload\":{\"total\":5105,\"rows\":[{\"courseName\":\"演讲与口才\",\"hours\":0.0,\"orgName\":\"演示院校01\",\"createTime\":\"2016-08-11 16:45:08\",\"appName\":\"资源管理平台\",\"enable\":true,\"coursewareNameEnable\":true,\"name\":\"新课程\",\"appkey\":\"c2f8dfa6038b4e12b327c8893e76cc29\",\"id\":\"9b06e640-f215-4334-a84a-cd86fd1c6adf\",\"status\":1.0},{\"hours\":33.0,\"orgName\":\"奥鹏教育\",\"createTime\":\"2016-08-10 13:54:03\",\"appName\":\"mooc中国\",\"enable\":false,\"coursewareNameEnable\":false,\"name\":\"走进性科学\",\"appkey\":\"5da97a028134420c84123474e7e59e93\",\"id\":\"a8d60e27-95f3-450d-b50e-07e68208e86f\",\"status\":1.0},{\"courseName\":\"文化制度108\",\"hours\":77.0,\"orgName\":\"奥鹏教育\",\"createTime\":\"2016-08-10 11:10:35\",\"appName\":\"资源管理平台\",\"enable\":true,\"coursewareNameEnable\":true,\"name\":\"测试000004\",\"appkey\":\"c2f8dfa6038b4e12b327c8893e76cc29\",\"id\":\"4bbaa94b-5543-487e-8869-f0ce063e296f\",\"status\":1.0},{\"courseName\":\"测试与传感技术\",\"hours\":0.0,\"orgName\":\"教学院校自用\",\"createTime\":\"2016-08-08 15:14:40\",\"appName\":\"资源管理平台\",\"enable\":true,\"coursewareNameEnable\":true,\"name\":\"新课程\",\"appkey\":\"c2f8dfa6038b4e12b327c8893e76cc29\",\"id\":\"d3ca8821-236b-4fbe-9e1d-2d836433282f\",\"status\":1.0},{\"courseName\":\"测试08082\",\"hours\":123.0,\"orgName\":\"北京工商大学\",\"createTime\":\"2016-08-08 10:25:03\",\"appName\":\"资源管理平台\",\"enable\":true,\"coursewareNameEnable\":true,\"name\":\"0808测试\",\"appkey\":\"c2f8dfa6038b4e12b327c8893e76cc29\",\"id\":\"81e57c5c-0f49-488c-8ccd-2b70302c262b\",\"status\":0.0},{\"courseName\":\"表演669\",\"hours\":12.0,\"orgName\":\"奥鹏教育\",\"createTime\":\"2016-08-08 10:19:58\",\"appName\":\"资源管理平台\",\"enable\":true,\"coursewareNameEnable\":true,\"name\":\"课件1012\",\"appkey\":\"c2f8dfa6038b4e12b327c8893e76cc29\",\"id\":\"90f83e8c-9954-4295-85f7-abbe11268eed\",\"status\":1.0},{\"courseName\":\"表演669\",\"hours\":1.0,\"orgName\":\"奥鹏教育\",\"createTime\":\"2016-08-08 10:18:52\",\"appName\":\"资源管理平台\",\"enable\":true,\"coursewareNameEnable\":true,\"name\":\"wee\",\"appkey\":\"c2f8dfa6038b4e12b327c8893e76cc29\",\"id\":\"47b6d437-792a-444b-b7e0-6888b19aa146\",\"status\":1.0},{\"courseName\":\"全面预算管理\",\"hours\":0.0,\"orgName\":\"奥鹏教育\",\"createTime\":\"2016-08-08 10:11:36\",\"appName\":\"资源管理平台\",\"enable\":true,\"coursewareNameEnable\":true,\"name\":\"金融预算\",\"appkey\":\"c2f8dfa6038b4e12b327c8893e76cc29\",\"id\":\"3205ffc7-e563-4bdf-bcb2-b43b265f086f\",\"status\":1.0},{\"courseName\":\"表演669\",\"hours\":65.0,\"orgName\":\"奥鹏教育\",\"createTime\":\"2016-08-08 09:24:13\",\"appName\":\"资源管理平台\",\"enable\":true,\"coursewareNameEnable\":true,\"name\":\"测试201\",\"appkey\":\"c2f8dfa6038b4e12b327c8893e76cc29\",\"id\":\"074f2c80-d180-47a5-8641-ddbce1dfe8aa\",\"status\":1.0},{\"courseName\":\"文化制度108\",\"hours\":78.0,\"orgName\":\"奥鹏教育\",\"createTime\":\"2016-08-05 16:24:49\",\"appName\":\"资源管理平台\",\"enable\":true,\"coursewareNameEnable\":true,\"name\":\"测试101\",\"appkey\":\"c2f8dfa6038b4e12b327c8893e76cc29\",\"id\":\"07270155-797d-4760-a9dd-c165e60f1fb6\",\"status\":1.0}]}}";
        String compress = compress(src);
        String uncompress = uncompress(compress);
        System.out.println(compress.length()+":"+compress);
        System.out.println(uncompress.length()+":"+uncompress);
    }
}
