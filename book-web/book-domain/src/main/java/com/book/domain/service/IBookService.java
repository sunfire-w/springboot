package com.book.domain.service;

import com.book.domain.utils.JsonResult;
import com.book.domain.vo.request.*;
import com.book.domain.vo.response.*;
import com.book.thrift.inout.common.*;

import java.util.List;


/**
 * 接口封装 
 * @author roya 2019-12-27
 */
public interface IBookService{
	
    //begin  Book
	
	/**
	 * 新增 
	 * @param request 请求 
     * @return 返回JsonResult BookSaveRes
	 */
	JsonResult<BookSaveRes> saveBook(BookSaveVo request);
	
	/**
	 * 修改 按主键更新 
	 * @param request  请求
     * @return 返回JsonResult BookUpdateRes
	 */
	JsonResult<BookUpdateRes> updateBookByPrimaryKey(BookUpdateVo request);

    /**
	 * 修改 按指定参数更新 
	 * @param request 请求
     * @return 返回JsonResult BookUpdateRes
	 */
	public JsonResult<BookUpdateRes> updateBookByExample(BookUpdateVo request);

	/**
	 * 删除 一般情况下是修改记录的 状态为删除 
	 * @param request 请求 
     * @return 返回JsonResult BookRemoveRes
	 */
	JsonResult<BookRemoveRes> removeBook(BookRemoveVo request);

	/**
	 * 查询单个
	 * @param id 请求
	 * @return 返回，未查询到返回null
	 */
	JsonResult<BookEntity> getBookByExample(BookGetRequest req);
	/**
	 * 查询列表
	 * @param req  请求参数
	 * @return 返回List，未查询到返回null
	 */
	JsonResult<List<BookEntity>> getBookList(BookGetListRequest req);
	//end
}
