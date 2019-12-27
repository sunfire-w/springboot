package com.book.api;

import javax.annotation.Resource;

import com.book.common.base.Exception.BusinessException;
import com.book.common.base.constant.ResponseCode;
import com.book.service.IBookService;
import com.book.thrift.inout.common.*;
import com.book.thrift.service.IBookService.Iface;
import com.book.util.MapperUtils;
import org.apache.thrift.TException;
/**
 *   API
 * @author roya 2019-12-24
 */
public class BookApi implements Iface {
	 
//		private Logger log = LogManager.getRootLogger();
//
		@Resource
		private IBookService bookService;
		 
		@Resource
		MapperUtils mapperUtils;
	 
	    //begin  Book
		public BoolResponse saveBook(BookSaveRequest req)throws TException
		{  
 			BoolResponse boolResponse = null;
			try {  
				//新增 
				boolResponse = bookService.saveBook(req);
				
			} catch (BusinessException b) {
				b.printStackTrace();
//				log.error("{}|{}|{}", "", "Book新增异常", b.getStackTrace());
//				log.error("{}|{}|{}", "", "Book新增异常", b.fillInStackTrace());b
				BaseResponse baseResponse = new BaseResponse();
				baseResponse.setRespCode(ResponseCode.SYSTEM_EXCEPTION.getCode());
				baseResponse.setRespDesc(ResponseCode.SYSTEM_EXCEPTION.getDesc());
				return new BoolResponse().setBaseResp(baseResponse);
			} catch (Exception ex) {
				ex.printStackTrace();
//				log.error("{}|{}|{}", "", "Book新增异常", ex.getStackTrace());
//				log.error("{}|{}|{}","", "Book新增异常", ex.fillInStackTrace());fillInStackTrace
				BaseResponse baseResponse = new BaseResponse();
				baseResponse.setRespCode(ResponseCode.SYSTEM_EXCEPTION.getCode());
				baseResponse.setRespDesc(ResponseCode.SYSTEM_EXCEPTION.getDesc());
				return new BoolResponse().setBaseResp(baseResponse);
			} finally {
				if (boolResponse == null) {
					boolResponse = new BoolResponse();
					BaseResponse baseResponse = new BaseResponse();
					baseResponse.setRespCode(ResponseCode.SYSTEM_EXCEPTION.getCode());
					baseResponse.setRespDesc(ResponseCode.SYSTEM_EXCEPTION.getDesc());
					boolResponse.setBaseResp(baseResponse);
				}
		    } 
			return boolResponse;  
		}  

		public BoolResponse saveBookList(BookSaveListRequest req)throws TException
		{   
		
			BoolResponse boolResponse = null;
			try { 
				//新增List
				boolResponse = bookService.saveBookList(req); 
	
			} catch (BusinessException b) {
				b.printStackTrace();
//				log.error("{}|{}|{}", "", "Book新增List异常", b.getStackTrace());
//				log.error("{}|{}|{}", "", "Book新增List异常", b.fillInStackTrace());
				BaseResponse baseResponse = new BaseResponse();
				baseResponse.setRespCode(ResponseCode.SYSTEM_EXCEPTION.getCode());
				baseResponse.setRespDesc(ResponseCode.SYSTEM_EXCEPTION.getDesc());
				return new BoolResponse().setBaseResp(baseResponse);
			} catch (Exception ex) {
				ex.printStackTrace();
//				log.error("{}|{}|{}", "", "Book新增List异常", ex.getStackTrace());
//				log.error("{}|{}|{}", "", "Book新增List异常", ex.fillInStackTrace());
				BaseResponse baseResponse = new BaseResponse();
				baseResponse.setRespCode(ResponseCode.SYSTEM_EXCEPTION.getCode());
				baseResponse.setRespDesc(ResponseCode.SYSTEM_EXCEPTION.getDesc());
				return new BoolResponse().setBaseResp(baseResponse);
			} finally {
				if (boolResponse == null) {
					BaseResponse baseResponse = new BaseResponse();
					baseResponse.setRespCode(ResponseCode.SYSTEM_EXCEPTION.getCode());
					baseResponse.setRespDesc(ResponseCode.SYSTEM_EXCEPTION.getDesc());
					boolResponse.setBaseResp(baseResponse);
				}
		    } 
			return boolResponse; 
		}
		public BoolResponse updateBookByPrimaryKey(BookUpdateRequest req)throws TException
		{   
			BoolResponse boolResponse = null;
			try { 
				//修改ByPrimaryKey
				boolResponse = bookService.updateBookByPrimaryKey(req); 
				 
			} catch (BusinessException b) {
				b.printStackTrace();
//				log.error("{}|{}|{}", "", "Book修改ByPrimaryKey异常", b.getStackTrace());
//				log.error("{}|{}|{}", "", "Book修改ByPrimaryKey异常", b.fillInStackTrace());
				BaseResponse baseResponse = new BaseResponse();
				baseResponse.setRespCode(ResponseCode.SYSTEM_EXCEPTION.getCode());
				baseResponse.setRespDesc(ResponseCode.SYSTEM_EXCEPTION.getDesc());
				return new BoolResponse().setBaseResp(baseResponse);
			} catch (Exception ex) {
				ex.printStackTrace();
//				log.error("{}|{}|{}","", "Book修改ByPrimaryKey异常", ex.getStackTrace());
//				log.error("{}|{}|{}", "", "Book修改ByPrimaryKey异常", ex.fillInStackTrace());

				BaseResponse baseResponse = new BaseResponse();
				baseResponse.setRespCode(ResponseCode.SYSTEM_EXCEPTION.getCode());
				baseResponse.setRespDesc(ResponseCode.SYSTEM_EXCEPTION.getDesc());

				return new BoolResponse().setBaseResp(baseResponse);
			} finally {
				if (boolResponse == null) {
					BaseResponse baseResponse = new BaseResponse();
					baseResponse.setRespCode(ResponseCode.SYSTEM_EXCEPTION.getCode());
					baseResponse.setRespDesc(ResponseCode.SYSTEM_EXCEPTION.getDesc());
					boolResponse.setBaseResp(baseResponse);
				}
		    } 
			return boolResponse; 
		}
		public BoolResponse updateBookByExample(BookUpdateRequest req)throws TException 
		{   
		    BoolResponse boolResponse = null;
			try { 
				//修改ByExample
				boolResponse = bookService.updateBookByExample(req);
				 
			} catch (BusinessException b) {
				b.printStackTrace();
//				log.error("{}|{}|{}","", "Book修改ByExample异常", b.getStackTrace());
//				log.error("{}|{}|{}", "", "Book修改ByExample异常", b.fillInStackTrace());
				BaseResponse baseResponse = new BaseResponse();
				baseResponse.setRespCode(ResponseCode.SYSTEM_EXCEPTION.getCode());
				baseResponse.setRespDesc(ResponseCode.SYSTEM_EXCEPTION.getDesc());
				return new BoolResponse().setBaseResp(baseResponse);
			} catch (Exception ex) {
				ex.printStackTrace();
//				log.error("{}|{}|{}", "", "Book修改ByExample异常", ex.getStackTrace());
//				log.error("{}|{}|{}", "", "Book修改ByExample异常", ex.fillInStackTrace());
				BaseResponse baseResponse = new BaseResponse();
				baseResponse.setRespCode(ResponseCode.SYSTEM_EXCEPTION.getCode());
				baseResponse.setRespDesc(ResponseCode.SYSTEM_EXCEPTION.getDesc());
				return new BoolResponse().setBaseResp(baseResponse);
			} finally {
				if (boolResponse == null) {
					BaseResponse baseResponse = new BaseResponse();
					baseResponse.setRespCode(ResponseCode.SYSTEM_EXCEPTION.getCode());
					baseResponse.setRespDesc(ResponseCode.SYSTEM_EXCEPTION.getDesc());
					boolResponse.setBaseResp(baseResponse);
				}
		    } 
			return boolResponse; 
		}
		public BoolResponse removeBook(BookRemoveRequest req)throws TException
		{   
		    BoolResponse boolResponse = null;
			try {  
				//删除
				boolResponse = bookService.removeBook(req);  
	
			} catch (BusinessException b) {
				b.printStackTrace();
//				log.error("{}|{}|{}", "", "Book删除异常", b.getStackTrace());
//				log.error("{}|{}|{}", "", "Book删除异常", b.fillInStackTrace());
				BaseResponse baseResponse = new BaseResponse();
				baseResponse.setRespCode(ResponseCode.SYSTEM_EXCEPTION.getCode());
				baseResponse.setRespDesc(ResponseCode.SYSTEM_EXCEPTION.getDesc());
				return new BoolResponse().setBaseResp(baseResponse);
			} catch (Exception ex) {
				ex.printStackTrace();
//				log.error("{}|{}|{}", "", "Book删除异常", ex.getStackTrace());
//				log.error("{}|{}|{}", "", "Book删除异常", ex.fillInStackTrace());
				BaseResponse baseResponse = new BaseResponse();
				baseResponse.setRespCode(ResponseCode.SYSTEM_EXCEPTION.getCode());
				baseResponse.setRespDesc(ResponseCode.SYSTEM_EXCEPTION.getDesc());
				return new BoolResponse().setBaseResp(baseResponse);
			} finally {
				if (boolResponse == null) {
					BaseResponse baseResponse = new BaseResponse();
					baseResponse.setRespCode(ResponseCode.SYSTEM_EXCEPTION.getCode());
					baseResponse.setRespDesc(ResponseCode.SYSTEM_EXCEPTION.getDesc());
					boolResponse.setBaseResp(baseResponse);
				}
		    } 
			return boolResponse; 
		}
		public BookResponse getBookByExample(BookGetRequest req)throws TException 
		{
			BookResponse response = null;
			try { 
		     	//查询 单个
				response = bookService.getBookByExample(req); 
				
			} catch (BusinessException b) {
				b.printStackTrace();
//				log.error("{}|{}|{}", "", "单个Book查询异常", b.getStackTrace());
//				log.error("{}|{}|{}", "", "单个Book查询异常", b.fillInStackTrace());
				BaseResponse baseResponse = new BaseResponse();
				baseResponse.setRespCode(ResponseCode.SYSTEM_EXCEPTION.getCode());
				baseResponse.setRespDesc(ResponseCode.SYSTEM_EXCEPTION.getDesc());
			    response.setBaseResp(baseResponse);
			} catch (Exception ex) {
				ex.printStackTrace();
//				log.error("{}|{}|{}", "", "单个Book查询异常", ex.getStackTrace());
//				log.error("{}|{}|{}","", "单个Book查询异常", ex.fillInStackTrace());
				BaseResponse baseResponse = new BaseResponse();
				baseResponse.setRespCode(ResponseCode.SYSTEM_EXCEPTION.getCode());
				baseResponse.setRespDesc(ResponseCode.SYSTEM_EXCEPTION.getDesc());
		   	    response.setBaseResp(baseResponse); 
			} finally {
				if (response == null) {
					BaseResponse baseResponse = new BaseResponse();
					baseResponse.setRespCode(ResponseCode.SYSTEM_EXCEPTION.getCode());
					baseResponse.setRespDesc(ResponseCode.SYSTEM_EXCEPTION.getDesc());
					response.setBaseResp(baseResponse);
				}
		    } 
			return response; 
		}
		public BookListResponse getBookList(BookGetListRequest req)throws TException
		{
			BookListResponse response = null;
			try { 
		    	//查询 List
				response = bookService.getBookList(req);
				 
			} catch (BusinessException b) {
				b.printStackTrace();
//				log.error("{}|{}|{}", b.getCode(), "BookList查询异常", b.getStackTrace());
//				log.error("{}|{}|{}",  b.getCode(), "BookList查询异常", b.fillInStackTrace());
				BaseResponse baseResponse = new BaseResponse();
				baseResponse.setRespCode(ResponseCode.SYSTEM_EXCEPTION.getCode());
				baseResponse.setRespDesc(ResponseCode.SYSTEM_EXCEPTION.getDesc());
			    response.setBaseResp(baseResponse);
			} catch (Exception ex) {
				ex.printStackTrace();
//				log.error("{}|{}|{}","", "BookList查询异常", ex.getStackTrace());
//				log.error("{}|{}|{}",  "", "BookList查询异常", ex.fillInStackTrace());
				BaseResponse baseResponse = new BaseResponse();
				baseResponse.setRespCode(ResponseCode.SYSTEM_EXCEPTION.getCode());
				baseResponse.setRespDesc(ResponseCode.SYSTEM_EXCEPTION.getDesc());
		   	    response.setBaseResp(baseResponse); 
			} finally {
				if (response == null) {
					BaseResponse baseResponse = new BaseResponse();
					baseResponse.setRespCode(ResponseCode.SYSTEM_EXCEPTION.getCode());
					baseResponse.setRespDesc(ResponseCode.SYSTEM_EXCEPTION.getDesc());
					response.setBaseResp(baseResponse);
				}
		    } 
			return response; 
		} 
	    //end
}
