package com.book.rpc.dao;

import com.book.rpc.dao.entity.Book;

/**
 * 操作相关
 * @author roya  2019-12-24
 */
public interface BookDao {
	/**
	 * 保存新增的
	 * @param book 要保存的对象
	 */
	void saveBook(Book book);
	
	/**
	 * 修改
	 * @param book 要保存的对象
	 */
	void updateBook(Book book);

	/**
	 * 删除
	 * @param book 要删除的对象，只需传入主键ID即可
	 */
	void deleteBook(Book book);
	
	/**
	 * 根据编号查询细信息
	 * @param id 编号
	 * @return
	 */
	Book findById(String id);
}
