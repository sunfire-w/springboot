package com.book.util;

import org.dozer.DozerConverter;

import java.util.Date;

/**
 * 描述:转换Long和Date.
 *
 */
public class MapperDateConverter extends DozerConverter<Long, Date> {

    public MapperDateConverter() {
        super(Long.class, Date.class);
    }

    @Override
    public Date convertTo(Long source, Date destination) {
        if (source == 0) {
            return null;
        } else {
            return new Date(source);
        }
    }

    @Override
    public Long convertFrom(Date source, Long destination) {
        if (source != null) {
            return source.getTime();
        }
        return 0l;
    }

}
