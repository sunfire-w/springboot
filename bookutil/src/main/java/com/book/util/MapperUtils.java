package com.book.util;
import java.util.*;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2019/12/24 0024.
 */
public class MapperUtils {

    @Autowired
    private Mapper mapper;

    public <T> T map(Object source, Class<T> destinationClass) {
        if (source == null) {
            return null;
        }
        return mapper.map(source, destinationClass);
    }

    public <T> List<T> map(List source, Class<T> clz) {
        List target = new LinkedList();
        for (Object o : source) {
            Object to = mapper.map(o, clz);
            target.add(to);
        }
        return target;
    }

    public <T, V> Map<T, V> map(Map map, Class<T> keyClz, Class<V> valueClz) {
        Map<T, V> target = new HashMap<T, V>();
        Set<Map.Entry> entrySet = map.entrySet();
        for (Map.Entry entry : entrySet) {
            T key = mapper.map(entry.getKey(), keyClz);
            V value = mapper.map(entry.getValue(), valueClz);
            target.put(key, value);
        }
        return target;
    }

}
