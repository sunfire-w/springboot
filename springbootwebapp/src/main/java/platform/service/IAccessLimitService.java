package platform.service;

/**
 * Created by Administrator on 2019/11/28 0028.
 */
public interface IAccessLimitService {
    boolean tryAcquire();
}
