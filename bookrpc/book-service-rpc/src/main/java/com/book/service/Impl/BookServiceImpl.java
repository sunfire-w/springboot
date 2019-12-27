package com.book.service.Impl;
 
import java.util.List;   
import java.util.ArrayList;
import javax.annotation.Resource;

import com.book.common.base.Exception.BusinessException;
import com.book.common.base.constant.ResponseCode;
import com.book.rpc.dao.entity.Book;
import com.book.rpc.dao.mapper.BookMapper;
import com.book.rpc.dao.mapper.ext.BookMapperExt;
import com.book.util.MapperUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.book.service.IBookService;   
import com.book.thrift.inout.common.BoolResponse;
import com.book.thrift.inout.common.BaseResponse;  
import com.book.thrift.inout.common.BookSaveRequest;
import com.book.thrift.inout.common.BookSaveListRequest;
import com.book.thrift.inout.common.BookUpdateRequest;
import com.book.thrift.inout.common.BookGetListRequest;
import com.book.thrift.inout.common.BookListResponse;
import com.book.thrift.inout.common.BookGetRequest;
import com.book.thrift.inout.common.BookResponse;
import com.book.thrift.inout.common.BookEntity;
import com.book.thrift.inout.common.BookRemoveRequest;
import tk.mybatis.mapper.entity.Example;

/**
 * 接口实现
 * @author roya 2019-12-24
 */
@Service
public class BookServiceImpl implements IBookService {
	
 	@Resource
	private BookMapper bookMapper;
	@Resource
	private BookMapperExt bookMapperExt;
	@Resource
	MapperUtils mapperUtils;

	@Override
	//@CacheDelete({@CacheDeleteKey(value="book")})
	public BoolResponse saveBook(BookSaveRequest req) {
		//参数验证
    	validSave(req);
		BoolResponse response = null;
		try {
		    Book model = mapperUtils.map(req.getBookModel(),Book.class);
		    //新增
		    int result = bookMapper.insert(model);
			//转换返回实体
			response = getBoolResponse(result);

		}catch (Exception e) {
			BaseResponse baseResponse = new BaseResponse();
			baseResponse.setRespCode(ResponseCode.BUSINESS_EXCEPTION.getCode());
			baseResponse.setRespDesc(ResponseCode.BUSINESS_EXCEPTION.getDesc());
			response.setBaseResp(baseResponse);
		}
		return response;
	}
	@Override
	//@CacheDelete({@CacheDeleteKey(value="book")})
	public BoolResponse saveBookList(BookSaveListRequest req) {	   
		//参数验证
    	validSaveList(req);  
		BoolResponse response = null;
		try {		
			List<Book> newlists = new ArrayList();
			for(BookEntity ordResult : req.getBookList())
			{
				newlists.add(mapperUtils.map(ordResult, Book.class));
			} 
		    //批量保存  
		    int result = bookMapperExt.batchSaveBook(newlists);  
			//转换返回实体
			response = getBoolResponse(result);
			
		}catch (Exception e) {
			BaseResponse baseResponse = new BaseResponse();
			baseResponse.setRespCode(ResponseCode.BUSINESS_EXCEPTION.getCode());
			baseResponse.setRespDesc(ResponseCode.BUSINESS_EXCEPTION.getDesc());
			response.setBaseResp(baseResponse);
		}
		return response;
	}
	@Override
	//@CacheDelete({@CacheDeleteKey(value="book")})
	public BoolResponse updateBookByPrimaryKey(BookUpdateRequest req){
		//参数验证
		validUpdate(req);
		BoolResponse response = null;
		try {
		    Book model = mapperUtils.map(req.getBookModel(),Book.class);
			//修改
			int result = bookMapper.updateByPrimaryKey(model);
			//转换返回实体
			response = getBoolResponse(result);

		}catch (Exception e) {
			BaseResponse baseResponse = new BaseResponse();
			baseResponse.setRespCode(ResponseCode.BUSINESS_EXCEPTION.getCode());
			baseResponse.setRespDesc(ResponseCode.BUSINESS_EXCEPTION.getDesc());
			response.setBaseResp(baseResponse);
		}
		return response;
	}
	@Override
	//@CacheDelete({@CacheDeleteKey(value="book")})
	public BoolResponse updateBookByExample(BookUpdateRequest req){
		//参数验证
		validUpdate(req);
		BoolResponse response = null;
		try {			
			//更新内容
			 Book model = mapperUtils.map(req.getBookModel(),Book.class);
		    //查询条件
			Example example = new Example(Book.class);
			Example.Criteria criteria = example.createCriteria();
			if (model.getId() != null && StringUtils.isEmpty(model.getId()) == false){
		       criteria.andEqualTo("id", model.getId()); 
			}
			
			//修改	   
			int result = bookMapper.updateByExample(model, example);
			//转换返回实体
			response = getBoolResponse(result);
			
		}catch (Exception e) {
			BaseResponse baseResponse = new BaseResponse();
			baseResponse.setRespCode(ResponseCode.BUSINESS_EXCEPTION.getCode());
			baseResponse.setRespDesc(ResponseCode.BUSINESS_EXCEPTION.getDesc());
			response.setBaseResp(baseResponse);
		}
		return response;
	}
	@Override
	//@CacheDelete({@CacheDeleteKey(value="book", hfield="#args[0].id")})
	public BoolResponse removeBook(BookRemoveRequest req) 
	{		
		//参数验证
		validRemove(req); 
		BoolResponse response = null;
		try {
		    //删除条件	
			Book model = mapperUtils.map(req.getBookModel(),Book.class);			
			Example example = new Example(Book.class);
			Example.Criteria criteria = example.createCriteria();
			if (model.getId() != null && StringUtils.isEmpty(model.getId()) == false){
		       criteria.andEqualTo("id", model.getId()); 
			}
			//删除		
			int result =bookMapper.deleteByExample(example);
			//转换返回实体
			response = getBoolResponse(result);
			
		}catch (Exception e) {
			BaseResponse baseResponse = new BaseResponse();
			baseResponse.setRespCode(ResponseCode.BUSINESS_EXCEPTION.getCode());
			baseResponse.setRespDesc(ResponseCode.BUSINESS_EXCEPTION.getDesc());
			response.setBaseResp(baseResponse);
		}
		return response;
	}
	@Override
	//@Cache(key="book", expire=36000, autoload=true)
	public BookResponse getBookByExample(BookGetRequest req)
	{
		//参数验证
		validGet(req); 
		BookResponse response = new BookResponse(); 
		try {
			//查询条件	
			Book model = mapperUtils.map(req.getBookModel(),Book.class);	
			Example example = new Example(Book.class);
			Example.Criteria criteria = example.createCriteria();
			if (model.getId() != null && StringUtils.isEmpty(model.getId()) == false){
		       criteria.andEqualTo("id", model.getId()); 
			}
			// 查询
			List<Book> lists = bookMapper.selectByExample(example); 
			//转换返回实体
			if (lists.size() > 0)
			{			 
				BaseResponse baseResponse = new BaseResponse();
				baseResponse.setRespCode(ResponseCode.OK.getCode());
				baseResponse.setRespDesc(ResponseCode.OK.getDesc());
				response.setBaseResp(baseResponse);
				response.setBookModel(mapperUtils.map(lists.get(0), BookEntity.class)); 
			}
			else
			{  
				BaseResponse baseResponse = new BaseResponse();
				baseResponse.setRespCode(ResponseCode.BUSINESS_EXCEPTION.getCode());
				baseResponse.setRespDesc(ResponseCode.BUSINESS_EXCEPTION.getDesc());
				response.setBaseResp(baseResponse);
				response.setBookModel(new BookEntity());
			} 
		}catch (Exception e) {
			BaseResponse baseResponse = new BaseResponse();
			baseResponse.setRespCode(ResponseCode.BUSINESS_EXCEPTION.getCode());
			baseResponse.setRespDesc(ResponseCode.BUSINESS_EXCEPTION.getDesc());
			response.setBaseResp(baseResponse);
		}
		return response;  		 
	}

	/**
	 * 获取书籍列表
	 * @param req  请求参数
	 * @return
	 */
	@Override
	public BookListResponse getBookList(BookGetListRequest req) 
	{
		//参数验证
		validGetList(req);
		BookListResponse response = new BookListResponse();
		try
		{ 
		    //查询条件
		    BookEntity reqModel= req.getBookModel(); 
			Example example = new Example(Book.class);
			Example.Criteria criteria = example.createCriteria();
			if (reqModel.getId() != null && StringUtils.isEmpty(reqModel.getId()) == false){
		       criteria.andEqualTo("id", reqModel.getId()); 
			}	
			//example.setOrderByClause(" id desc"); 
			
			 //查询 List<BookEntity>
			 List<Book> lists = bookMapper.selectByExample(example); 
			 if(lists != null && lists.size() > 0)
			 {
				List<BookEntity> newlists = new ArrayList();
				for(Book ordResult : lists)
				{
					newlists.add(mapperUtils.map(ordResult, BookEntity.class));
				} 
				BaseResponse baseResponse = new BaseResponse();
				baseResponse.setRespCode(ResponseCode.OK.getCode());
				baseResponse.setRespDesc(ResponseCode.OK.getDesc()); 
				response.setBaseResp(baseResponse);
				response.setBookList(newlists); 
			} else
			{
				BaseResponse baseResponse = new BaseResponse();
				baseResponse.setRespCode(ResponseCode.BUSINESS_EXCEPTION.getCode());
				baseResponse.setRespDesc(ResponseCode.BUSINESS_EXCEPTION.getDesc());
				response.setBaseResp(baseResponse);
				response.setBookList(new ArrayList());
			}
		} catch(Exception e)
		{
			BaseResponse baseResponse = new BaseResponse();
			baseResponse.setRespCode(ResponseCode.BUSINESS_EXCEPTION.getCode());
			baseResponse.setRespDesc(ResponseCode.BUSINESS_EXCEPTION.getDesc());
			response.setBaseResp(baseResponse);
			response.setBookList(new ArrayList());
		}
		return response;
	}
    /**
     * Save参数验证
     * @param req 请求参数
     */
    private void validSave(BookSaveRequest req) {
    	if (req == null)
		{
			throw new BusinessException("新增 Book请求参数不能为空！");
		}		 
	    if(req.getBookModel() == null)
		{
			throw new BusinessException("新增 Book请求实体参数不能为空！");
		}  
	}	
 
     /**
     * SaveList参数验证
     * @param req 请求参数
     */
    private void validSaveList(BookSaveListRequest req) {
        if(req == null)
		{	
			throw new BusinessException("批量保存Book请求参数错误！");
		} 
    	 if(req.getBookList() == null || req.getBookList().size() == 0)
		{
			throw new BusinessException("批量保存Book 请求参数不能为空！");
		} 
	} 
		
     /**
     * update参数验证
     * @param req 请求参数
     */
    private void validUpdate(BookUpdateRequest req) {
    	if(req == null)
		{	
			throw new BusinessException("更新Book请求参数错误！");
		} 
	    if(req.getBookModel() == null)
		{
			throw new BusinessException("更新Book请求实体参数不能为空！");
		}
	}	

    /**
     * Remove参数验证
     * @param req 请求参数
     */
    private void validRemove(BookRemoveRequest req) {
    	if(req == null)
		{	
			throw new BusinessException("删除Book请求参数错误！");
		} 
	    if(req.getBookModel() == null)
		{
			throw new BusinessException("删除Book请求实体参数不能为空！");
		}
	}	

    /**
     * Get参数验证
     * @param req 请求参数
     */
    private void validGet(BookGetRequest req) {
    	if(req == null)
		{	
			throw new BusinessException("查询Book请求参数错误！");
		} 
	    if(req.getBookModel() == null)
		{
			throw new BusinessException("查询Book请求实体参数不能为空！");
		} 
	}	
	
	 /**
     * GetList参数验证
     * @param req 请求参数
     */
    private void validGetList(BookGetListRequest req) {
    	if(req == null)
		{	
			throw new BusinessException("查询列表 Book 请求参数错误！");
		} 
	    if(req.getBookModel() == null)
		{
			throw new BusinessException("查询列表 Book 请求实体参数不能为空！");
		}
	}
			  
   	/**
	 * 转换返回实体 
	 * @param result 请求参数
	 */
	private BoolResponse getBoolResponse (int result)
	{
	    BoolResponse response = new BoolResponse();
		if(result > 0)
		{
			response.value = true;
			BaseResponse baseResponse = new BaseResponse();
			baseResponse.setRespCode(ResponseCode.OK.getCode());
			baseResponse.setRespDesc(ResponseCode.OK.getDesc());
			response.setBaseResp(baseResponse);
		} else
		{
			response.value = false;
			BaseResponse baseResponse = new BaseResponse();
			baseResponse.setRespCode(ResponseCode.BUSINESS_EXCEPTION.getCode());
			baseResponse.setRespDesc(ResponseCode.BUSINESS_EXCEPTION.getDesc());
			response.setBaseResp(baseResponse);
		}
		return response;
	}
    	
    	
}
