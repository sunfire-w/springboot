package platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import platform.domain.Book;
import platform.entity.BaseResponse;
import platform.service.BookService;
import org.springframework.stereotype.Service;
import platform.service.IAccessLimitService;
import springboot.dubbo.CityDubboConsumerService;
import springboot.dubbo.ICityService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Book 业务层实现
 *
 * Created by bysocket on 27/09/2017.
 */
@Service
public class BookServiceImpl implements BookService {
    @Resource
    private ICityService cityService;
    @Autowired
    IAccessLimitService AccessLimitService;
    // 模拟数据库，存储 Book 信息
    // 第五章《﻿数据存储》会替换成 MySQL 存储
    private static Map<Long, Book> BOOK_DB = new HashMap<>();

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(BOOK_DB.values());
    }

    @Override
    public Book insertByBook(Book book) {
        book.setId(BOOK_DB.size() + 1L);
        BOOK_DB.put(book.getId(), book);
        return book;
    }

    @Override
    public Book update(Book book) {
        BOOK_DB.put(book.getId(), book);
        return book;
    }

    @Override
    public Book delete(Long id) {
        return BOOK_DB.remove(id);
    }

    @Override
    public BaseResponse<Book> findById(Long id) {
       BaseResponse<Book> response = new BaseResponse<Book>();
//        //尝试获取令牌
//        if(AccessLimitService.tryAcquire()){
//            //模拟业务执行500毫秒
////            try {
////                Thread.sleep(500);
////            }catch (InterruptedException e){
////                e.printStackTrace();
////            }
//            response.setSuccess(0);
//            response.setMessage("找到数据");
//            Book book= new Book();
//            book.setId(6L);
//            book.setIntroduction("测试频率");
//            book.setName("测试频率");
//            book.setWriter("华哥");
//            response.setData(book);
//            return response;
//        }else {
//            response.setSuccess(1);
//            response.setMessage("limit access");
//            response.setData(null);
//            return response;
//        }
        Book book=BOOK_DB.get(id);
    String cityname=cityService.findCityByName("");
        book.setName(cityname);
        if(book!=null)
    {
        response.setSuccess(0);
        response.setMessage("请求成功");
        response.setData(book);
    }
        else{
        response.setSuccess(1);
        response.setMessage("未找到书籍信息");
        response.setData(null);
    }
        return response;
}
}
