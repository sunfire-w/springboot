package com.main;

import com.service.impl.elasticsearchserviceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Administrator on 2019/10/23 0023.
 */
public class main {
    public static void main(String[] args) {
        elasticsearchserviceImpl elastic=new elasticsearchserviceImpl();
        String result=elastic.testEsConnection();
        System.out.println(result);
        // TODO Auto-generated method stub
//        int i=0;
//
//        while(true){
//            i++;
//            long t2 = System.currentTimeMillis();
//            System.out.println(t2+":qq:"+i);
//
//            int res =   TrafficShaper.enter("aaa", "qq");
//            System.out.println((System.currentTimeMillis()-t2)+":qq:"+i);
//            if(res ==99)
//            {
//                i=0;
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        executorService.execute(new Runnable() {
//            public void run() {
//                System.out.println("Asynchronous task");
//            }
//        });
//
//        executorService.shutdown();

//        Future future = executorService.submit(new Runnable() {
//            public void run() {
//                System.out.println("Asynchronous task");
//            }
//        });
//        try {
////如果任务结束执行则返回 null
//            System.out.println("future.get()=" + future.get());
//        }catch (Exception ex){
//
//        }
//        Set<Callable<String>> callables = new HashSet<Callable<String>>();
//
//        callables.add(new Callable<String>() {
//            public String call() throws Exception {
//                return "Task 1";
//            }
//        });
//        callables.add(new Callable<String>() {
//            public String call() throws Exception {
//                return "Task 2";
//            }
//        });
//        callables.add(new Callable<String>() {
//            public String call() throws Exception {
//                return "Task 3";
//            }
//        });
//
//        try {
//            List<Future<String>> listFuture = executorService.invokeAll(callables);
//            if(listFuture!=null) {
//                for (Future<String> v:listFuture) {
//                    System.out.println("result = " + v.get());
//                }
//            }
//
//            executorService.shutdown();
//        }
//        catch (Exception ex){
//
//        }
    }
}
