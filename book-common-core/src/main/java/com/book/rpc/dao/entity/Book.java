package com.book.rpc.dao.entity;
 
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
* 
* @author roya  2019-12-24
*/
@Entity
@Table(name="book")
public class Book { 
	
	/**
	 * 
	 */
    @Id  
	@Column(name="id",nullable=false,length=30)  
	private String id;
	
	/**
	 * 
	 */
	@Column(name="title") 
	private String title;
	
	/**
	 * 
	 */
	@Column(name="language") 
	private String language;
	
	/**
	 * 
	 */
	@Column(name="author") 
	private String author;
	
	/**
	 * 
	 */
	@Column(name="book_image_url") 
	private String bookImageUrl;
	
	/**
	 * 
	 */
	@Column(name="price") 
	private BigDecimal price;
	
	/**
	 * 
	 */
	@Column(name="publish_time") 
	private Date publishTime;
	
	/**
	 * 
	 */
	@Column(name="introduction") 
	private String introduction;
	


	/**
	 * 设置
	 * @param id 
	 */
	public void setId(String id){
		this.id=id;
	}
	
	/**
	 * 获取
	 * @return id - 
	 */ 
	public String getId(){
		return this.id;
	}
	
	/**
	 * 设置
	 * @param title 
	 */
	public void setTitle(String title){
		this.title=title;
	}
	
	/**
	 * 获取
	 * @return title - 
	 */ 
	public String getTitle(){
		return this.title;
	}
	
	/**
	 * 设置
	 * @param language 
	 */
	public void setLanguage(String language){
		this.language=language;
	}
	
	/**
	 * 获取
	 * @return language - 
	 */ 
	public String getLanguage(){
		return this.language;
	}
	
	/**
	 * 设置
	 * @param author 
	 */
	public void setAuthor(String author){
		this.author=author;
	}
	
	/**
	 * 获取
	 * @return author - 
	 */ 
	public String getAuthor(){
		return this.author;
	}
	
	/**
	 * 设置
	 * @param bookImageUrl 
	 */
	public void setBookImageUrl(String bookImageUrl){
		this.bookImageUrl=bookImageUrl;
	}
	
	/**
	 * 获取
	 * @return book_image_url - 
	 */ 
	public String getBookImageUrl(){
		return this.bookImageUrl;
	}
	
	/**
	 * 设置
	 * @param price 
	 */
	public void setPrice(BigDecimal price){
		this.price=price;
	}
	
	/**
	 * 获取
	 * @return price - 
	 */ 
	public BigDecimal getPrice(){
		return this.price;
	}
	
	/**
	 * 设置
	 * @param publishTime 
	 */
	public void setPublishTime(Date publishTime){
		this.publishTime=publishTime;
	}
	
	/**
	 * 获取
	 * @return publish_time - 
	 */ 
	public Date getPublishTime(){
		return this.publishTime;
	}
	
	/**
	 * 设置
	 * @param introduction 
	 */
	public void setIntroduction(String introduction){
		this.introduction=introduction;
	}
	
	/**
	 * 获取
	 * @return introduction - 
	 */ 
	public String getIntroduction(){
		return this.introduction;
	}
	

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Book[");
		sb.append("id=");
		sb.append(id);
		sb.append(",title=");
		sb.append(title);
		sb.append(",language=");
		sb.append(language);
		sb.append(",author=");
		sb.append(author);
		sb.append(",bookImageUrl=");
		sb.append(bookImageUrl);
		sb.append(",price=");
		sb.append(price);
		sb.append(",publishTime=");
		sb.append(publishTime);
		sb.append(",introduction=");
		sb.append(introduction);
		sb.append("]");
		return sb.toString();
	}
}
