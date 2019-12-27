package com.book.service;

import java.util.List;
import com.book.thrift.inout.common.BookSaveRequest;
import com.book.thrift.inout.common.BookSaveListRequest;
import com.book.thrift.inout.common.BookUpdateRequest;
import com.book.thrift.inout.common.BookGetListRequest;
import com.book.thrift.inout.common.BookListResponse;
import com.book.thrift.inout.common.BookGetRequest;
import com.book.thrift.inout.common.BookResponse;
import com.book.thrift.inout.common.BookEntity;
import com.book.thrift.inout.common.BookRemoveRequest;
import com.book.thrift.inout.common.BoolResponse; 

/**
 * 接口
 * @author roya  2019-12-24
 */
public interface IBookService {
	
    //begin  Book
	/**
	 * 新增 
	 * @param req 请求
	 * @return 
	 */
	BoolResponse saveBook(BookSaveRequest req);
	
	/**
	 * 批量保存 
	 * @param req 请求List  
	 * @return
	 */
	BoolResponse saveBookList(BookSaveListRequest req);
	
	/**
	 * 修改 按主键更新 
	 * @param req  请求 
	 * @return	 
	 */
	BoolResponse updateBookByPrimaryKey(BookUpdateRequest req);

    /**
	 * 修改 按指定参数更新 
	 * @param req 请求 
	 * @return
	 */
	BoolResponse updateBookByExample(BookUpdateRequest req);

	/**
	 * 删除 一般情况下是修改记录的 状态为删除 
	 * @param req 请求
	 * @return	  
	 */
	BoolResponse removeBook(BookRemoveRequest req);
	
	/**
	 * 查询单个 
	 * @param req 请求
	 * @return 返回单个
	 */
	BookResponse getBookByExample(BookGetRequest req);
	
	/**
	 * 查询列表  
	 * @param req  请求参数
     * @return 返回List
	 */
	BookListResponse getBookList(BookGetListRequest req);
    //end
}
