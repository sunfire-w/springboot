package platform.facade;

/**
 * @author roya
 * 2019-1-21
 */
public class Request implements  BaseRequest{
     int serverPort = -1;
     int remotePort;
     int localPort;

    @Override
    public void doRequest() {
        String doRequest="begin do request";
    }
}
