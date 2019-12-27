namespace java com.book.thrift.inout.common


include "common.thrift"
 
/**
* 关联实体
* @author roya  2019-12-24
*/
struct BookEntity{
	/**
	 * 
	 */
	1:string id;  
	/**
	 * 
	 */
	2:string title;  
	/**
	 * 
	 */
	3:string language;  
	/**
	 * 
	 */
	4:string author;  
	/**
	 * 
	 */
	5:string bookImageUrl;  
	/**
	 * 
	 */
	6:double price;  
	/**
	 * 
	 */
	7:i64 publishTime;  
	/**
	 * 
	 */
	8:string introduction;  
}

/*  添加 请求参数 */
struct BookSaveRequest{
    /**
	* 基础请求参数
	*/
	1:common.BaseRequest baseReq,
	/**
	* 
	*/
	2:BookEntity BookModel,
} 

/*  添加List 请求参数 */
struct BookSaveListRequest{
	/**
	* 基础返回参数
	*/
	1:common.BaseRequest baseReq, 
	/**
	* 列表
	*/
	2:list<BookEntity> BookList     
} 

/*  修改 请求参数 */
struct BookUpdateRequest{
    /**
	* 基础请求参数
	*/
	1:common.BaseRequest baseReq,
	/**
	* 
	*/
	2:BookEntity BookModel,
}
 
/*  删除 请求参数 */
struct BookRemoveRequest{
	/**
	* 基础返回参数
	*/
	1:common.BaseRequest baseReq, 
	/**
	* 
	*/
	2:BookEntity BookModel,
} 

/*  查询 请求参数 */
struct BookGetRequest{
	/**
	* 基础返回参数
	*/
	1:common.BaseRequest baseReq, 
	/**
	* 
	*/
	2:BookEntity BookModel,
}  

/*  查询列表 请求参数 */
struct BookGetListRequest{
	/**
	* 基础返回参数
	*/
	1:common.BaseRequest baseReq, 
	/**
	* 
	*/
	2:BookEntity BookModel,
} 





/*  查询单个实体  返回参数 */
struct BookResponse{
	/**
	* 基础返回参数
	*/
	1:common.BaseResponse baseResp,
	/**
	* 返回实体
	*/
	2:BookEntity BookModel,
}

/*  查询列表 返回参数 */
struct BookListResponse{
	/**
	* 基础返回参数
	*/
	1:common.BaseResponse baseResp,
	/**
	* 总记录数
	*/
	2:i64 total,
	/**
	* 列表
	*/
	3:list<BookEntity> BookList     
}


