package platform.cotoye;

import platform.facade.BaseRequest;
import platform.facade.Request;

/**
 * Created by Administrator on 2019/1/21 0021.
 */
public class RequestFacade implements BaseRequest {
    protected Request request = null;

    public RequestFacade(Request response) {
        this.request = request;
    }
    @Override
    public void doRequest() {
        //int localPort= request.localPort;
    }
}
