package platform.facade;

/**
 * Created by Administrator on 2019/1/21 0021.
 */
public class RequestFacade extends AbstractRequestFacade implements  BaseRequest {
    protected Request request = null;

    public RequestFacade(Request response) {
        this.request = request;
    }
    @Override
    public void doRequest() {
       int localPort= request.localPort;
    }
    protected void refresh() throws Exception {
       System.out.println("dfdsfsdfds");
    }
}
