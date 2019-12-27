package com.book.domain.service.impl;

import javax.annotation.Resource;

import com.book.common.base.constant.ResponseCode;
import com.book.domain.service.IBookService;
import com.book.domain.utils.JsonResult;
import com.book.domain.utils.RequestUtils;
import com.book.domain.vo.request.BookRemoveVo;
import com.book.domain.vo.request.BookSaveVo;
import com.book.domain.vo.request.BookUpdateVo;
import com.book.domain.vo.response.BookRemoveRes;
import com.book.domain.vo.response.BookUpdateRes;
import com.book.rpc.client.IBookRpcClient;
import com.book.thrift.inout.common.*;
import com.book.util.MapperUtils;
import com.book.domain.vo.response.BookSaveRes;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  接口封装实现
 * @author roya  2019-12-27
 */
@Service 
public class BookServiceImpl implements IBookService {
	
 	@Resource
	MapperUtils mapperUtils;
	
	@Resource
	IBookRpcClient bookRpcClient;
	
    //begin  Book
	@Override 
	public JsonResult<BookSaveRes> saveBook(BookSaveVo request) {
		BookSaveRequest req = mapperUtils.map(request, BookSaveRequest.class);
		req.setBaseReq(RequestUtils.genBaseRequest(null,null,null,null));
		BoolResponse response = bookRpcClient.saveBook(req);

		/* 返回成功 */
		if(response != null && response.getBaseResp().getRespCode().equals(ResponseCode.OK.getCode())){
			BookSaveRes res = new BookSaveRes();
			res.setValue(response.isValue());//res.setProductId(response.getProductId());
			return new JsonResult<BookSaveRes>(ResponseCode.OK.getCode(), ResponseCode.OK.getDesc(), res);
			
		}else if (response != null && !response.getBaseResp().getRespCode().equals(ResponseCode.OK.getCode())){
			return new JsonResult<BookSaveRes>(response.getBaseResp().getRespCode(), response.getBaseResp().getRespDesc());
		}
		return new JsonResult<BookSaveRes>(ResponseCode.NOT_FOUND.getCode(), ResponseCode.NOT_FOUND.getDesc());
	}

	@Override
	public JsonResult<BookUpdateRes> updateBookByPrimaryKey(BookUpdateVo request)
	{
		BookUpdateRequest req = mapperUtils.map(request, BookUpdateRequest.class);
		req.setBaseReq(RequestUtils.genBaseRequest(null,null,null,null));
		BoolResponse response =  bookRpcClient.updateBookByPrimaryKey(req);

		/* 返回成功 */
		if(response != null && response.getBaseResp().getRespCode().equals(ResponseCode.OK.getCode())){	
			BookUpdateRes res = new BookUpdateRes();
			res.setValue(response.isValue());//res.setProductId(response.getProductId());
			return new JsonResult<BookUpdateRes>(ResponseCode.OK.getCode(), ResponseCode.OK.getDesc(), res);
			
		}else if (response != null && !response.getBaseResp().getRespCode().equals(ResponseCode.OK.getCode())){
			return new JsonResult<BookUpdateRes>(response.getBaseResp().getRespCode(), response.getBaseResp().getRespDesc());
		}
		return new JsonResult<BookUpdateRes>(ResponseCode.NOT_FOUND.getCode(), ResponseCode.NOT_FOUND.getDesc());
	}

	@Override
	public JsonResult<BookUpdateRes> updateBookByExample(BookUpdateVo request)
	{
		BookUpdateRequest req = mapperUtils.map(request, BookUpdateRequest.class);
		req.setBaseReq(RequestUtils.genBaseRequest(null,null,null,null));
		BoolResponse response =  bookRpcClient.updateBookByExample(req);

		/* 返回成功 */
		if(response != null && response.getBaseResp().getRespCode().equals(ResponseCode.OK.getCode())){	
			BookUpdateRes res = new BookUpdateRes();
			res.setValue(response.isValue());//res.setProductId(response.getProductId());
			return new JsonResult<BookUpdateRes>(ResponseCode.OK.getCode(), ResponseCode.OK.getDesc(), res);
			
		}else if (response != null && !response.getBaseResp().getRespCode().equals(ResponseCode.OK.getCode())){
			return new JsonResult<BookUpdateRes>(response.getBaseResp().getRespCode(), response.getBaseResp().getRespDesc());
		}
		return new JsonResult<BookUpdateRes>(ResponseCode.NOT_FOUND.getCode(), ResponseCode.NOT_FOUND.getDesc());
	}
	
	@Override
	public JsonResult<BookRemoveRes> removeBook(BookRemoveVo request)
	{
		BookRemoveRequest delRequest = new BookRemoveRequest();
		//这里要注意会有多个主键的情况，要手动修改 
		String id = request.getId();
		BookEntity book=new BookEntity();
		book.setId(id);
		delRequest.setBookModel(book);
		BoolResponse response = bookRpcClient.removeBook(delRequest);

		//返回成功 
		if(response != null && response.getBaseResp().getRespCode().equals(ResponseCode.OK.getCode())){	
			BookRemoveRes res = new BookRemoveRes();
			res.setValue(response.isValue());//res.setProductIds(request.getProductIds());
			return new JsonResult<BookRemoveRes>(ResponseCode.OK.getCode(), ResponseCode.OK.getDesc(), res);
			
		}else if (response != null && !response.getBaseResp().getRespCode().equals(ResponseCode.OK.getCode())){
			return new JsonResult<BookRemoveRes>(response.getBaseResp().getRespCode(), response.getBaseResp().getRespDesc());
		}
		return new JsonResult<BookRemoveRes>(ResponseCode.NOT_FOUND.getCode(), ResponseCode.NOT_FOUND.getDesc());
	}

	@Override
	public JsonResult<BookEntity> getBookByExample(BookGetRequest req) {
		BookGetRequest getRequest = mapperUtils.map(req, BookGetRequest.class);
		req.setBaseReq(RequestUtils.genBaseRequest(null,null,null,null));
		//这里要注意会有多个主键的情况，要手动修改
		String id = getRequest.getBookModel().getId();
		BookResponse response = bookRpcClient.getBookByExample(getRequest);

		/* 返回成功 */
		if(response != null){
			BookEntity res = new BookEntity();
			res=mapperUtils.map(response, BookEntity.class);
			return new JsonResult<BookEntity>(ResponseCode.OK.getCode(), ResponseCode.OK.getDesc(), res);

		}else if (response != null && !response.getBaseResp().getRespCode().equals(ResponseCode.OK.getCode())){
			return new JsonResult<BookEntity>(response.getBaseResp().getRespCode(), response.getBaseResp().getRespDesc());
		}
		return null;
	}

	@Override
	public JsonResult<List<BookEntity>> getBookList(BookGetListRequest req) {
		BookGetListRequest getRequest = mapperUtils.map(req, BookGetListRequest.class);
		getRequest.setBaseReq(RequestUtils.genBaseRequest(null,null,null,null));
		BookListResponse response = bookRpcClient.getBookList(getRequest);

		 /* 返回成功 */
		if(response != null){
			return new JsonResult<List<BookEntity>>(ResponseCode.OK.getCode(), ResponseCode.OK.getDesc(), response.getBookList());
		}else
			return null;
	}
}
