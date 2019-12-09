package platform.service.impl;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Service;
import platform.service.IAccessLimitService;

/**
 * Created by Administrator on 2019/11/28 0028.
 */
@Service
public class AccessLimitServiceImpl implements IAccessLimitService {
    //每秒只发出5个令牌
    RateLimiter rateLimiter = RateLimiter.create(5.0);
    @Override
    public boolean tryAcquire() {
        return rateLimiter.tryAcquire();
    }
}
