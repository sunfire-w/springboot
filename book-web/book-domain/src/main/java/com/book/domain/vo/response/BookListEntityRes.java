package com.book.domain.vo.response;
 
 
import java.io.Serializable;
import java.util.List;
import org.hibernate.validator.constraints.NotBlank;
import io.swagger.annotations.ApiModelProperty;


/**
*  返回实体，如增加、修改、挂起、解挂、废弃
* @author roya  2019-12-27
*/ 
public class BookListEntityRes implements Serializable { 
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty("返回处理结果") 
	private boolean value;
	
	public boolean isValue ()
	{
		return value;
	}

	public void setValue (boolean value)
	{
		this.value = value;
	}

	
}



