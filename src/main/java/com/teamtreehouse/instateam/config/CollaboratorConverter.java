package com.teamtreehouse.instateam.config;

import com.teamtreehouse.instateam.dao.CollaboratorDao;
import com.teamtreehouse.instateam.model.Collaborator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CollaboratorConverter implements Converter<String, Collaborator> {

    @Autowired
    private CollaboratorDao collaboratorDao;

    @Override
    public Collaborator convert(String source) {
        return collaboratorDao.findById(Integer.parseInt(source));
    }

    @Bean
    public ConversionService getConversionService() {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        Set<Converter> converters = new HashSet<>();
        converters.add(new CollaboratorConverter());
        bean.setConverters(converters);
        return bean.getObject();
    }
}
