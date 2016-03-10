package com.example.tangxb.myapplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tangxb on 2016/3/9.
 */
public class DataProvider {
    private static List<String> mDataList = new ArrayList<>();

    static {
        mDataList.add("http://e.hiphotos.baidu.com/image/pic/item/314e251f95cad1c8037ed8c97b3e6709c83d5112.jpg");
        mDataList.add("http://e.hiphotos.baidu.com/image/pic/item/fcfaaf51f3deb48ff04f8630f41f3a292df5783d.jpg");
        mDataList.add("http://a.hiphotos.baidu.com/image/pic/item/f9dcd100baa1cd11daf25f19bc12c8fcc3ce2d46.jpg");
        mDataList.add("http://h.hiphotos.baidu.com/image/pic/item/472309f7905298220df4b72ed3ca7bcb0b46d41c.jpg");
        mDataList.add("http://f.hiphotos.baidu.com/image/pic/item/b17eca8065380cd70c5150cba444ad345982814d.jpg");
        mDataList.add("http://e.hiphotos.baidu.com/image/pic/item/cf1b9d16fdfaaf5137ad7399895494eef01f7a4e.jpg");
        mDataList.add("http://d.hiphotos.baidu.com/image/pic/item/cb8065380cd7912344a13298a9345982b3b7809d.jpg");
        mDataList.add("http://h.hiphotos.baidu.com/image/pic/item/b7fd5266d0160924ec4504f7d00735fae7cd34fd.jpg");
        mDataList.add("http://f.hiphotos.baidu.com/image/pic/item/242dd42a2834349b7eaf886ccdea15ce37d3beaa.jpg");
        mDataList.add("http://a.hiphotos.baidu.com/image/pic/item/7dd98d1001e9390191637f187eec54e736d196b7.jpg");
    }

    public static List<String> getDataList() {
        return mDataList;
    }
}
