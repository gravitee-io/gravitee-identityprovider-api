/**
 * Copyright (C) 2015 The Gravitee team (http://gravitee.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gravitee.identityprovider.api.oauth2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OAuth2IdentityProviderConfigurationTest {

    @Nested
    class Validate {

        @ParameterizedTest(name = "[{index}] clientId=\"{0}\" clientSecret=\"{1}\"")
        @DisplayName("returns false when empty")
        @CsvSource({ "clientId,''", "'',clientSecret", "'',''" })
        void validate_empty(String clientId, String clientSecret) {
            boolean isValid = new FakeConfiguration(clientId, clientSecret).validate();
            assertThat(isValid).isFalse();
        }

        @ParameterizedTest(name = "[{index}] clientId=\"{0}\" clientSecret=\"{1}\"")
        @DisplayName("returns false when null")
        @CsvSource({ "clientId,", ",clientSecret", "," })
        void validate_null(String clientId, String clientSecret) {
            boolean isValid = new FakeConfiguration(clientId, clientSecret).validate();
            assertThat(isValid).isFalse();
        }

        @Test
        @DisplayName("returns true when clientId & clientSecret are defined")
        void validate() {
            boolean isValid = new FakeConfiguration("clientId", "clientSecret").validate();
            assertThat(isValid).isTrue();
        }
    }

    class FakeConfiguration implements OAuth2IdentityProviderConfiguration {

        private final String clientId;
        private final String clientSecret;
        private String userAuthorizationUri;
        private String accessTokenUri;
        private String userProfileUri;
        private String redirectUri;
        private String codeParameter;
        private String responseType;
        private Set<String> scopes;

        public FakeConfiguration(String clientId, String clientSecret) {
            this.clientId = clientId;
            this.clientSecret = clientSecret;
        }

        @Override
        public String getClientId() {
            return clientId;
        }

        @Override
        public String getClientSecret() {
            return clientSecret;
        }

        @Override
        public String getRedirectUri() {
            return redirectUri;
        }

        @Override
        public Set<String> getScopes() {
            return scopes;
        }

        @Override
        public String getUserAuthorizationUri() {
            return userAuthorizationUri;
        }

        @Override
        public String getAccessTokenUri() {
            return accessTokenUri;
        }

        @Override
        public String getUserProfileUri() {
            return userProfileUri;
        }

        @Override
        public String getCodeParameter() {
            return codeParameter;
        }

        @Override
        public String getResponseType() {
            return responseType;
        }
    }
}
