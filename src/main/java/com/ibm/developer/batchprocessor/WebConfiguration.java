package com.ibm.developer.batchprocessor;

import javax.annotation.PostConstruct;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ConditionalOnExpression("${keep-running:false}")
@Configuration
@EnableWebMvc
public class WebConfiguration {

}
