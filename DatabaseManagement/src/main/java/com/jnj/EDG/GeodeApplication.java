package com.jnj.EDG;

import com.jnj.EDG.model.Book;
import com.jnj.EDG.repository.BookRepository;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.config.annotation.EnablePdx;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;


import java.util.Collections;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ClientCacheApplication(name = "geodeDemo", logLevel = "debug",locators = {@ClientCacheApplication.Locator()})
@EnableGemfireRepositories(basePackages = "com.jnj.EDG.repository")
@EnableEntityDefinedRegions(basePackageClasses = Book.class, clientRegionShortcut = ClientRegionShortcut.PROXY)
@EnablePdx
public class GeodeApplication {

	public static void main(String[] args) {

		SpringApplication app =new SpringApplication(GeodeApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", 8080));
		app.run(args);
	}
}
