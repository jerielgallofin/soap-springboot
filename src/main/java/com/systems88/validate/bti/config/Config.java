package com.systems88.validate.bti.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class Config extends WsConfigurerAdapter {

	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/service/*");
	}

	@Bean(name = "authSessionTokenWsdl")
	public DefaultWsdl11Definition btiWsdl11Definition(XsdSchema authSessionTokenSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("AuthSessionTokenPort");
		wsdl11Definition.setLocationUri("/service/auth-session-token");
		wsdl11Definition.setTargetNamespace("http://validate.systems88.com/bti/bean");
		wsdl11Definition.setSchema(authSessionTokenSchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema authSessionTokenSchema() {
		return new SimpleXsdSchema(new ClassPathResource("authenticatino-bti.xsd"));
	}

}
