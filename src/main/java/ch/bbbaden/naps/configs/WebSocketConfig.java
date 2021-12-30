package ch.bbbaden.naps.configs;

import ch.bbbaden.naps.websocket.handlers.ServerWebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
	
	public static final String PATH_PREFIX = "/ws";
	
	@Override
	public void registerWebSocketHandlers (WebSocketHandlerRegistry registry) {
		registry.addHandler(webSocketHandler(), PATH_PREFIX + "/hello");
	}
	
	@Bean
	public WebSocketHandler webSocketHandler () {
		return new ServerWebSocketHandler();
	}
}
