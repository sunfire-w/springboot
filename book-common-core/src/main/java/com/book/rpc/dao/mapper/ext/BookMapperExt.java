package com.book.rpc.dao.mapper.ext;

import java.util.List;

import com.book.rpc.dao.entity.Book;
import org.apache.ibatis.annotations.Param;


/**
 *  
 * @author roya 2019-12-24
 */
public interface BookMapperExt{

	/**
	 * 批量保存
	 * @param books 保存对象
	 * @return int 返回结果
	 */
	int batchSaveBook(@Param("books") List<Book> books);
	
} 
