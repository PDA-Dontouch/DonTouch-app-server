package donTouch.user_server.oauth.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.security.oauth2.client.registration.naver")
public record NaverOauthConfig (
        String redirectUri,
        String clientId,
        String clientSecret,
        String[] scope,
        String state
) {
}
