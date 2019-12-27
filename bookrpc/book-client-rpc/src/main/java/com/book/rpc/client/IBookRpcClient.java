package com.book.rpc.client;

import com.book.thrift.inout.common.*;

import java.util.List;
/**
 * 接口
 * @author roya  2019-12-24
 */
public interface IBookRpcClient {
	
   	 //begin  Book
	
	/**
	 * 新增 
	 * @param req 请求
	 * @return 
	 */
	BoolResponse saveBook(BookSaveRequest req);
	
	 /**
	 * 新增 列表  
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
	 * @param id 请求 
	 * @return
	 */
	 BoolResponse removeBook(BookRemoveRequest req);
	
     /**
	 * 查询单个 
	 * @param id 请求
	 * @return 返回，未查询到返回null
	 */
	 BookResponse getBookByExample(BookGetRequest req);
	 /**
	 * 查询列表  
	 * @param req  请求参数
     * @return 返回List，未查询到返回null
	 */
	 BookListResponse getBookList(BookGetListRequest req);
    //end
}
