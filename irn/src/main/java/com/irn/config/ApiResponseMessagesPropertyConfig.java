package com.irn.config;

import javax.annotation.PostConstruct;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApiResponseMessagesPropertyConfig {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	private PropertiesConfiguration configuration;

	@Value(value = "${ApiResponseMessagesPropertyConfig.location}")
	private String filePath;

	@Value(value = "${ApiResponseMessagesPropertyConfig.fileRefreshInterval}")
	private Long fileRefreshInterval;

	@PostConstruct
	private void init() {
		try {
			LOGGER.info("Loading the properties file: " + filePath);
			configuration = new PropertiesConfiguration(filePath);
			FileChangedReloadingStrategy fileChangedReloadingStrategy = new FileChangedReloadingStrategy();
			fileChangedReloadingStrategy.setRefreshDelay(fileRefreshInterval);
			configuration.setReloadingStrategy(fileChangedReloadingStrategy);
		} catch (ConfigurationException e) {
			e.printStackTrace();
			LOGGER.error(ExceptionUtils.getFullStackTrace(e));
		}
	}

	public String getProperty(String key) {
		return (String) configuration.getProperty(key);
	}

	public void setProperty(String key, Object value) {
		configuration.setProperty(key, value);
	}

	public void save() {
		try {
			configuration.save();
		} catch (ConfigurationException e) {
			e.printStackTrace();
			LOGGER.error(ExceptionUtils.getFullStackTrace(e));
		}
	}
}