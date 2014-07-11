package com.jivesoftware.sdk.spring;

import javax.servlet.ServletContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ServletContextAware;

import com.jivesoftware.sdk.api.entity.AddOnConfigProvider;
import com.jivesoftware.sdk.api.entity.AddOnConfigProviderFactory;
import com.jivesoftware.sdk.api.entity.HealthStatusProvider;
import com.jivesoftware.sdk.api.entity.HealthStatusProviderFactory;
import com.jivesoftware.sdk.api.entity.JiveInstanceProvider;
import com.jivesoftware.sdk.api.entity.JiveInstanceProviderFactory;
import com.jivesoftware.sdk.api.entity.StorageInstanceProvider;
import com.jivesoftware.sdk.api.entity.StorageInstanceProviderFactory;
import com.jivesoftware.sdk.api.entity.TileInstanceProvider;
import com.jivesoftware.sdk.api.entity.TileInstanceProviderFactory;
import com.jivesoftware.sdk.api.entity.impl.memory.MemoryAddOnConfigProvider;
import com.jivesoftware.sdk.api.entity.impl.memory.MemoryHealthStatusProvider;
import com.jivesoftware.sdk.api.entity.impl.memory.MemoryJiveInstanceProvider;
import com.jivesoftware.sdk.api.entity.impl.memory.MemoryStorageInstanceProvider;
import com.jivesoftware.sdk.api.entity.impl.memory.MemoryTileInstanceProvider;
import com.jivesoftware.sdk.client.JiveAPIClient;
import com.jivesoftware.sdk.client.JiveAnalyticsClient;
import com.jivesoftware.sdk.client.JiveTileClient;
import com.jivesoftware.sdk.client.oauth.JiveOAuthClient;
import com.jivesoftware.sdk.client.oauth.JiveOAuthEventListener;
import com.jivesoftware.sdk.service.filter.JiveAuthorizationValidationRequestFilter;
import com.jivesoftware.sdk.service.filter.JiveAuthorizationValidator;
import com.jivesoftware.sdk.service.filter.JiveSignatureValidationRequestFilter;
import com.jivesoftware.sdk.service.filter.JiveSignatureValidator;
import com.jivesoftware.sdk.service.filter.JiveSignedFetchValidationRequestFilter;
import com.jivesoftware.sdk.service.filter.JiveSignedFetchValidator;
import com.jivesoftware.sdk.service.health.HealthService;
import com.jivesoftware.sdk.service.instance.InstanceService;
import com.jivesoftware.sdk.service.oauth.JiveOAuth2Service;
import com.jivesoftware.sdk.service.storage.StorageService;
import com.jivesoftware.sdk.service.tile.TileService;

@Configuration
public class SpringAppConfig implements ServletContextAware {
	
	private static String applicationFolderPath;

	@Override
	public void setServletContext(ServletContext servletContext) {
		applicationFolderPath = servletContext.getRealPath("");	
	}
	
	public static String getApplicationFolderPath() {
		return applicationFolderPath;
	}
	
	@Bean
	public AddOnConfigProviderFactory addOnConfigProviderFactory(){
		return new AddOnConfigProviderFactory();
	}

	@Bean
	public HealthStatusProviderFactory healthStatusProviderFactory(){
		return new HealthStatusProviderFactory();
	}
	
	@Bean
	public JiveInstanceProviderFactory jiveInstanceProviderFactory(){
		return new JiveInstanceProviderFactory();
	}
	
	@Bean
	public StorageInstanceProviderFactory storageInstanceProviderFactory(){
		return new StorageInstanceProviderFactory();
	}
	
	@Bean
	public TileInstanceProviderFactory tileInstanceProviderFactory(){
		return new TileInstanceProviderFactory();
	}
	
	@Bean
	public JiveOAuthEventListener jiveOAuthEventListener(){
		return new JiveOAuthEventListener();
	}
	
	@Bean
	public JiveOAuthClient jiveOAuthClient(){
		return new JiveOAuthClient();
	}
	
	@Bean
	public JiveTileClient jiveTileClient(){
		return new JiveTileClient();
	}
	
	@Bean
	public JiveAPIClient jiveAPIClient(){
		return new JiveAPIClient();
	}
	
	@Bean
	public JiveAnalyticsClient jiveAnalyticsClient(){
		return new JiveAnalyticsClient();
	}
	
	@Bean
	public InstanceService instanceService(){
		return new InstanceService();
	}
	
	@Bean
	public TileService tileService(){
		return new TileService();
	}
	
	@Bean
	public JiveOAuth2Service jiveOAuth2Service(){
		return new JiveOAuth2Service();
	}
	
	@Bean
	public StorageService storageService(){
		return new StorageService();
	}
	
	@Bean
	public HealthService healthService(){
		return new HealthService();
	}
	
	@Bean
	public JiveSignedFetchValidationRequestFilter jiveSignedFetchValidationRequestFilter(){
		return new JiveSignedFetchValidationRequestFilter();
	}
	
	@Bean
	public JiveSignedFetchValidator jiveSignedFetchValidator(){
		return new JiveSignedFetchValidator();
	}
	
	@Bean
	public JiveAuthorizationValidationRequestFilter jiveAuthorizationValidationRequestFilter(){
		return new JiveAuthorizationValidationRequestFilter();
	}
	
	@Bean
	public JiveAuthorizationValidator jiveAuthorizationValidator(){
		return new JiveAuthorizationValidator();
	}
	
	@Bean
	public JiveSignatureValidationRequestFilter jiveSignatureValidationRequestFilter(){
		return new JiveSignatureValidationRequestFilter();
	}
	
	@Bean
	public JiveSignatureValidator jiveSignatureValidator(){
		return JiveSignatureValidator.getInstance();
	}
	
	@Bean
	public AddOnConfigProvider addOnConfigProvider(){
		return MemoryAddOnConfigProvider.getInstance();
	}
	
	@Bean
	public HealthStatusProvider healthStatusProvider(){
		return MemoryHealthStatusProvider.getInstance();
	}
	
	@Bean
	public JiveInstanceProvider jiveInstanceProvider(){
		return MemoryJiveInstanceProvider.getInstance();
	}
	
	@Bean
	public StorageInstanceProvider storageInstanceProvider(){
		return MemoryStorageInstanceProvider.getInstance();
	}
	
	@Bean
	public TileInstanceProvider tileInstanceProvider(){
		return MemoryTileInstanceProvider.getInstance();
	}
}