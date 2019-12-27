package com.book.domain.vo.request;
 
 
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.hibernate.validator.constraints.NotBlank;
import io.swagger.annotations.ApiModelProperty;


/**
*  查询单个请求
* @author roya  2019-12-27
*/ 
public class BookGetVo implements Serializable { 
	
	private static final long serialVersionUID = 1L;
	@ApiModelProperty("") 
	@NotBlank(message="不能为空")
	private String id; 
	@ApiModelProperty("") 
	private String title; 
	@ApiModelProperty("") 
	private String language; 
	@ApiModelProperty("") 
	private String author; 
	@ApiModelProperty("") 
	private String bookImageUrl; 
	@ApiModelProperty("") 
	private BigDecimal price;
	@ApiModelProperty("") 
	private Date publishTime;
	@ApiModelProperty("") 
	private String introduction; 



	/**
	 * 
	 */
	public void setId(String id){
		this.id=id;
	}
 
	/**
	 * 
	 */
	public String getId(){
		return this.id;
	}
	
	/**
	 * 
	 */
	public void setTitle(String title){
		this.title=title;
	}
 
	/**
	 * 
	 */
	public String getTitle(){
		return this.title;
	}
	
	/**
	 * 
	 */
	public void setLanguage(String language){
		this.language=language;
	}
 
	/**
	 * 
	 */
	public String getLanguage(){
		return this.language;
	}
	
	/**
	 * 
	 */
	public void setAuthor(String author){
		this.author=author;
	}
 
	/**
	 * 
	 */
	public String getAuthor(){
		return this.author;
	}
	
	/**
	 * 
	 */
	public void setBookImageUrl(String bookImageUrl){
		this.bookImageUrl=bookImageUrl;
	}
 
	/**
	 * 
	 */
	public String getBookImageUrl(){
		return this.bookImageUrl;
	}
	
	/**
	 * 
	 */
	public void setPrice(BigDecimal price){
		this.price=price;
	}
 
	/**
	 * 
	 */
	public BigDecimal getPrice(){
		return this.price;
	}
	
	/**
	 * 
	 */
	public void setPublishTime(Date publishTime){
		this.publishTime=publishTime;
	}
 
	/**
	 * 
	 */
	public Date getPublishTime(){
		return this.publishTime;
	}
	
	/**
	 * 
	 */
	public void setIntroduction(String introduction){
		this.introduction=introduction;
	}
 
	/**
	 * 
	 */
	public String getIntroduction(){
		return this.introduction;
	}
	
	 
}



