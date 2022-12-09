package com.martin.orderMenu.jsonConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
public class JacksonConfig {
  //反序列化和序列化(JSON->Object,Object->JSON)
  @Bean
  public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
	  ObjectMapper mapper = new ObjectMapper();
	  //反序列化
      mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
      //序列化
      mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
      MappingJackson2HttpMessageConverter converter =
              new MappingJackson2HttpMessageConverter(mapper);
      return converter;
  }
}
