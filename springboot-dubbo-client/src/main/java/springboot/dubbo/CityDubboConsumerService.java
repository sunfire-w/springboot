package springboot.dubbo;

import springboot.domain.City;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 城市 Dubbo 服务消费者
 *
 * Created by bysocket on 28/02/2017.
 */
@Component
public class CityDubboConsumerService implements  ICityService {
    @Resource()
    CityDubboService cityDubboService;
    public String findCityByName(String cityName) {
        String name="温岭";
        City city = cityDubboService.findCityByName(name);
        return city.getCityName();
    }
}
