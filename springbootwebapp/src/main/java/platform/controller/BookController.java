package platform.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import platform.domain.Book;
import org.springframework.web.bind.annotation.*;
import platform.entity.BaseResponse;
import platform.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import platform.service.IAccessLimitService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * Book 控制层
 */
@Api(value = "apis/v1.0", tags = "Book书籍信息")
@RestController
@RequestMapping(value = "apis/v1.0")
public class BookController {

    @Autowired
    BookService bookService;
    /**
     * 获取 Book 列表
     * 处理 "/book" 的 GET 请求，用来获取 Book 列表
     */
    @ApiOperation(value = "getBookList")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "sid", dataType = "String", required = true, value = "sessionId"),
            @ApiImplicitParam(paramType = "header", name = "source", dataType = "String", required = true, value = "android/ios/h5/weixin/customer/tmc/platform"),
            @ApiImplicitParam(paramType = "header", name = "version", dataType = "String", required = false, value = "版本号")
    })
    @RequestMapping(value = "/getBookList",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Book> getBookList(HttpServletRequest request) {
        return bookService.findAll();
    }

    /**
     * 获取 Book
     * 处理 "/book/{id}" 的 GET 请求，用来获取 Book 信息
     * @PathVariable(value="bookId") 使用占位符解决
     * 对应页面看到请求的URL参数，如：http://localhost:8081/v1.0/getBook/1
     * @RequestParam(value="bookId") 则不需要占位符  @RequestMapping(value = "/getBook")
     * 对应页面看到请求的URL参数，如：http://localhost:8081/v1.0/getBook?bookId=1
     */
    @ApiOperation(value = "getBook通过编号")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "sid", dataType = "String", required = true, value = "sessionId"),
            @ApiImplicitParam(paramType = "header", name = "source", dataType = "String", required = true, value = "android/ios/h5/weixin/customer/tmc/platform"),
            @ApiImplicitParam(paramType = "header", name = "version", dataType = "String", required = false, value = "版本号")
    })
    @RequestMapping(value = "/getBook/{bookId}", method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public BaseResponse<Book> getBook(@PathVariable(value="bookId") Long bookId, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        String sessionId=session.getId();
        return bookService.findById(bookId);
    }

    /**
     * 创建 Book
     * 处理 "/book/create" 的 POST 请求，用来新建 Book 信息
     * 通过 @RequestBody 绑定实体参数，也通过 @RequestParam 传递参数
     */
    @ApiOperation(value = "添加书籍")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "sid", dataType = "String", required = true, value = "sessionId"),
            @ApiImplicitParam(paramType = "header", name = "source", dataType = "String", required = true, value = "android/ios/h5/weixin/customer/tmc/platform"),
            @ApiImplicitParam(paramType = "header", name = "version", dataType = "String", required = false, value = "版本号")
    })
    @RequestMapping(value = "/postBook", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public Book postBook(@RequestBody Book book,HttpServletRequest request) {
        return bookService.insertByBook(book);
    }

    /**
     * 更新 Book
     * 处理 "/update" 的 PUT 请求，用来更新 Book 信息
     */
    @ApiOperation(value = "更新Book")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "sid", dataType = "String", required = true, value = "sessionId"),
            @ApiImplicitParam(paramType = "header", name = "source", dataType = "String", required = true, value = "android/ios/h5/weixin/customer/tmc/platform"),
            @ApiImplicitParam(paramType = "header", name = "version", dataType = "String", required = false, value = "版本号")
    })
    @RequestMapping(value = "/putBook", method = RequestMethod.PUT,produces = "application/json;charset=utf-8")
    @ResponseBody
    public Book putBook(@RequestBody Book book,HttpServletRequest request) {
        return bookService.update(book);
    }

    /**
     * 删除 Book
     * 处理 "/book/{id}" 的 GET 请求，用来删除 Book 信息
     * PathVariable 使用占位符解决
     * 对应页面看到请求的URL参数，如：http://localhost:8081/v1.0/deleteBook/1
     * 如使用 RequestParam 则不是要占位符  @RequestMapping(value = "/deleteBook")
     * 对应页面看到请求的URL参数，如：http://localhost:8081/v1.0/deleteBook?bookId=1
     */
    @ApiOperation(value = "deleteBook通过编号删除数据")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "sid", dataType = "String", required = true, value = "sessionId"),
            @ApiImplicitParam(paramType = "header", name = "source", dataType = "String", required = true, value = "android/ios/h5/weixin/customer/tmc/platform"),
            @ApiImplicitParam(paramType = "header", name = "version", dataType = "String", required = false, value = "版本号")
    })
    @RequestMapping(value = "/deleteBook/{bookId}", method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    @ResponseBody
    public Book deleteBook(@PathVariable(value="bookId") Long bookId,HttpServletRequest request) {
        return bookService.delete(bookId);
    }

}
