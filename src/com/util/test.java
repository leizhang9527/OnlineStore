package com.util;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Decadence
 * @Email: leizhang9527@163.com
 * @Date: 2020/3/20 20:05
 * @Version 1.0
 */
public class test {

    public static void main(String[] args) throws Exception {

        System.out.println("--start--");
        //创建一个创世区块
        BlockChain blockChain = BlockChain.getInstance();

        // 一个区块中可以不包含任何交易记录，第二个区块
        Map<String, Object> block = blockChain.newBlock(300, null);

        // 一个区块中可以包含一笔交易记录，第三个区块
        blockChain.newTransactions("123", "222", 33);
        Map<String, Object> block1 = blockChain.newBlock(500, null);

        // 一个区块中可以包含多笔交易记录，第四个区块
        blockChain.newTransactions( "321", "555", 133);
        blockChain.newTransactions("000", "111", 10);
        blockChain.newTransactions("789", "369", 65);
        Map<String, Object> block2 = blockChain.newBlock(600, null);

        // 查看整个区块链
        Map<String, Object> chain = new HashMap<String, Object>();
        chain.put("chain", blockChain.getChain());
        chain.put("length", blockChain.getChain().size());
        System.out.println(new JSONObject(chain));

        System.out.println("--end--");
    }
}
