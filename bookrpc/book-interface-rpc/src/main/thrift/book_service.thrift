namespace java com.book.thrift.service


include "common.thrift"
include "book.thrift"

 
/**
*  接口
* @author roya  2019-12-24
*/
service IBookService{ 

	/**
	 * 新增 
	 */
	common.BoolResponse saveBook(1:book.BookSaveRequest req);

	/**
	 * 新增 列表
	 */
	common.BoolResponse saveBookList(1:book.BookSaveListRequest req);	

	/**
	 * 修改 
	 */
	common.BoolResponse updateBookByPrimaryKey(1:book.BookUpdateRequest req);

    /**
	 * 修改 
	 */
	common.BoolResponse updateBookByExample(1:book.BookUpdateRequest req);

	/**
	 * 删除 
	 */
	common.BoolResponse removeBook(1:book.BookRemoveRequest req);
	
	/**
	 * 查询单个 
	 */
	book.BookResponse getBookByExample(1:book.BookGetRequest req);
	
	/**
	 * 查询 列表 
	 */
	book.BookListResponse getBookList(1:book.BookGetListRequest req);

}
 
