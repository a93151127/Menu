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
	//序列化  
	@Bean
	    public Jackson2ObjectMapperBuilder jacksonBuilder() {
	        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
	        builder.featuresToEnable(SerializationFeature.WRAP_ROOT_VALUE); 
	        // enables wrapping for root elements
	        return builder;
	    }
	  //反序列化
	  @Bean
	  public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
	      ObjectMapper mapper = new ObjectMapper();
	      mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
	      MappingJackson2HttpMessageConverter converter =
	              new MappingJackson2HttpMessageConverter(mapper);
	      return converter;
	  }
}
