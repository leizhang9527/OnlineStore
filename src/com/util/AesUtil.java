package com.util;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.Sign;
import cn.hutool.crypto.asymmetric.SignAlgorithm;
import cn.hutool.crypto.digest.HMac;
import cn.hutool.crypto.digest.HmacAlgorithm;
import cn.hutool.crypto.digest.MD5;

import java.security.KeyPair;

/**
 * @Author: Decadence
 * @Email: leizhang9527@163.com
 * @Date: 2020/3/12 19:45
 * @Version 1.0
 */
public class AesUtil {

    public  static String generateKey (String testStr){
        byte[] key = "password".getBytes();
        HMac mac = new HMac(HmacAlgorithm.HmacMD5, key);
        String macHex1 = mac.digestHex(testStr);
        return macHex1;
    }


    public static void main(String[] args) {
        byte[] data = "我是一段测试字符串".getBytes();
        Sign sign = SecureUtil.sign(SignAlgorithm.MD5withRSA);
        //签名
        byte[] signed = sign.sign(data);
        //验证签名
        boolean verify = sign.verify(data, signed);
        System.out.println(verify);
    }
}
