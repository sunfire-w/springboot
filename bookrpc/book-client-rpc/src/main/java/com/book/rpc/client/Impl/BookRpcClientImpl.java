package com.book.rpc.client.Impl;
 
   
import java.util.List;   
import java.util.ArrayList;
import javax.annotation.Resource;

import com.book.common.base.constant.ResponseCode;
import com.book.rpc.client.IBookRpcClient;
import com.book.thrift.inout.common.*;
import com.book.thrift.service.IBookService;
import org.springframework.stereotype.Service;

/**
 * 接口实现
 * @author roya  2019-12-24
 */
@Service
public class BookRpcClientImpl implements IBookRpcClient {
	
 	@Resource
	private IBookService.Iface  bookService;
	
  	//begin  Book
	public BoolResponse saveBook(BookSaveRequest req) {
		BoolResponse response = null; 
		try{
		    //新增
			response = bookService.saveBook(req);
			if(response == null)
				throw new RuntimeException("接口异常!");
		} catch (RuntimeException ex) {
			response = new BoolResponse();
		 	response.setBaseResp(new BaseResponse().setRespCode(ResponseCode.BUSINESS_EXCEPTION.getCode())
				.setRespDesc(ex.getMessage()));
			ex.printStackTrace();
		}catch(Exception ex){
			response = new BoolResponse();
			response.setBaseResp(new BaseResponse().setRespCode(ResponseCode.BUSINESS_EXCEPTION.getCode()).setRespDesc("业务异常!"));
			ex.printStackTrace();
		} 
		return response;  
	}

	public BoolResponse saveBookList(BookSaveListRequest req)	{
		BoolResponse response = null; 
		try{
		    //新增 列表
			response = bookService.saveBookList(req);
			if(response == null)
				throw new RuntimeException("接口异常!");
		} catch (RuntimeException ex) {
			response = new BoolResponse();
		 	response.setBaseResp(new BaseResponse().setRespCode(ResponseCode.BUSINESS_EXCEPTION.getCode())
				.setRespDesc(ex.getMessage()));
			ex.printStackTrace();
		}catch(Exception ex){
			response = new BoolResponse();
			response.setBaseResp(new BaseResponse().setRespCode(ResponseCode.BUSINESS_EXCEPTION.getCode()).setRespDesc("业务异常!"));
			ex.printStackTrace();
		} 
		return response; 
	}

	public BoolResponse updateBookByPrimaryKey(BookUpdateRequest req)
	{   
		BoolResponse response = null; 
		try{
		    //修改
			response = bookService.updateBookByPrimaryKey(req);
			if(response == null)
				throw new RuntimeException("接口异常!");
		} catch (RuntimeException ex) {
			response = new BoolResponse();
		 	response.setBaseResp(new BaseResponse().setRespCode(ResponseCode.BUSINESS_EXCEPTION.getCode())
				.setRespDesc(ex.getMessage()));
			ex.printStackTrace();
		}catch(Exception ex){
			response = new BoolResponse();
			response.setBaseResp(new BaseResponse().setRespCode(ResponseCode.BUSINESS_EXCEPTION.getCode()).setRespDesc("业务异常!"));
			ex.printStackTrace();
		} 
		return response;    
	}

	public BoolResponse updateBookByExample(BookUpdateRequest req)
	{  
		BoolResponse response = null; 
		try{
		    //修改
			response = bookService.updateBookByExample(req);
			if(response == null)
				throw new RuntimeException("接口异常!");
		} catch (RuntimeException ex) {
			response = new BoolResponse();
		 	response.setBaseResp(new BaseResponse().setRespCode(ResponseCode.BUSINESS_EXCEPTION.getCode())
				.setRespDesc(ex.getMessage()));
			ex.printStackTrace();
		}catch(Exception ex){
			response = new BoolResponse();
			response.setBaseResp(new BaseResponse().setRespCode(ResponseCode.BUSINESS_EXCEPTION.getCode()).setRespDesc("业务异常!"));
			ex.printStackTrace();
		} 
		return response;     
	}

	public BoolResponse removeBook(BookRemoveRequest req)
	{	 
		BoolResponse response = null; 
		try{
		    //删除 
			response = bookService.removeBook(req);
			if(response == null)
				throw new RuntimeException("接口异常!");
		} catch (RuntimeException ex) {
			response = new BoolResponse();
		 	response.setBaseResp(new BaseResponse().setRespCode(ResponseCode.BUSINESS_EXCEPTION.getCode())
				.setRespDesc(ex.getMessage()));
			ex.printStackTrace();
		}catch(Exception ex){
			response = new BoolResponse();
			response.setBaseResp(new BaseResponse().setRespCode(ResponseCode.BUSINESS_EXCEPTION.getCode()).setRespDesc("业务异常!"));
			ex.printStackTrace();
		} 
		return response;      
	}
	
	public BookResponse getBookByExample(BookGetRequest req) 
	{ 
		BookResponse response = null; 
		try{
		    //查询单个
			response = bookService.getBookByExample(req);
			if(response == null)
				throw new RuntimeException("接口异常!");
		} catch (RuntimeException ex) {
			response = new BookResponse();
		 	response.setBaseResp(new BaseResponse().setRespCode(ResponseCode.BUSINESS_EXCEPTION.getCode())
				.setRespDesc(ex.getMessage()));
			ex.printStackTrace();
		}catch(Exception ex){
			response = new BookResponse();
			response.setBaseResp(new BaseResponse().setRespCode(ResponseCode.BUSINESS_EXCEPTION.getCode()).setRespDesc("业务异常!"));
			ex.printStackTrace();
		} 
		return response;      
	}

	public BookListResponse getBookList(BookGetListRequest req)
	{ 
	   BookListResponse response = null; 
		try{
		    //查询列表
			response = bookService.getBookList(req);
			if(response == null)
				throw new RuntimeException("接口异常!");
		} catch (RuntimeException ex) {
			response = new BookListResponse();
		 	response.setBaseResp(new BaseResponse().setRespCode(ResponseCode.BUSINESS_EXCEPTION.getCode())
				.setRespDesc(ex.getMessage()));
			ex.printStackTrace();
		}catch(Exception ex){
			response = new BookListResponse();
			response.setBaseResp(new BaseResponse().setRespCode(ResponseCode.BUSINESS_EXCEPTION.getCode()).setRespDesc("业务异常!"));
			ex.printStackTrace();
		} 
		return response; 
	}
	 //end 
}
