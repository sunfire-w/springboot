package com.book.util;

import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jiao on 2016/4/6.
 */
public class MapperStringToDateConverter extends DozerConverter<String, Date> {

    public MapperStringToDateConverter() {
        super(String.class, Date.class);
    }

    @Override
    public Date convertTo(String source, Date destination) {
        if (StringUtils.isBlank(source)) {
            return null;
        }
        if (StringUtils.isNumeric(source)) {
            return new Date(Long.parseLong(source));
        }

        SimpleDateFormat sdf = null;
        if (source.indexOf(":") > 0) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        } else {
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        }
        try {
            return sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String convertFrom(Date source, String destination) {
        if (source == null) {
            return null;
        }
        String result = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(source);
        return result;
    }
}