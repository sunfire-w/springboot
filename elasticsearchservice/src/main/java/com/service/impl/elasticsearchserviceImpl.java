package com.service.impl;

import com.alibaba.dubbo.common.json.JSONObject;
import org.apache.http.HttpHost;
import org.apache.logging.log4j.core.Logger;
import  org.elasticsearch.*;
import org.elasticsearch.action.*;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Administrator on 2019/10/23 0023.
 */
public class elasticsearchserviceImpl {
    public static TransportClient client=null;
    public final static String HOST = "es.test.com"; //服务器部署
    public final static Integer PORT = 9300; //端口
    public String testEsConnection() {
        if (client == null) {
            System.setProperty("es.set.netty.runtime.available.processors", "false");
            try {
                //设置集群名称
                Settings settings = Settings.builder().put("cluster.name", "st-es").put("client.transport.sniff", true).build();
                //创建client
                client = new PreBuiltTransportClient(settings).addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(HOST), PORT));

                //参数：索引名，类型（type） id
//                GetResponse response = client.prepareGet("books", "IT", "2")
//                        .setOperationThreaded(false)    // 线程安全
//                        .get();
//                return response.getSourceAsString();//将json字符串转换为json对象

                SearchResponse searchResponse=null;
                String name="j";
//连接elasticsearch
                searchResponse = client.prepareSearch()
                    .setIndices("books")
                    .setTypes("IT")
                    .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                    .setScroll(TimeValue.timeValueMinutes(30)) //游标维持时间
                    .setSize(2 * 5)//实际返回的数量为10*index的主分片数
                    .setQuery(QueryBuilders.wildcardQuery("language", ("*"+name+"*").toLowerCase()))  //查询的字段名及值
                    .execute()
                    .actionGet();

                SearchHits searchHits= searchResponse.getHits();
                if(searchHits!=null){
                    SearchHit[] searchHitsArray=searchHits.getHits();
                    for (SearchHit hit:searchHitsArray){
                        Map<String, Object> result= hit.getSource();
                        System.out.print(result.toString());
                    }
                }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
            return client.nodeName();
        }
        return "";
    }
}

