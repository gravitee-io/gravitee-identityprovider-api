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

import io.gravitee.identityprovider.api.Authentication;
import io.gravitee.identityprovider.api.AuthenticationContext;

public class OAuth2Authentication implements Authentication<String, String> {

    private final String principal;
    private final String credentials;
    private final AuthenticationContext authenticationContext;

    public OAuth2Authentication(String principal, String credentials, AuthenticationContext authenticationContext) {
        this.principal = principal;
        this.credentials = credentials;
        this.authenticationContext = authenticationContext;
    }

    @Override
    public String getCredentials() {
        return credentials;
    }

    @Override
    public String getPrincipal() {
        return principal;
    }

    @Override
    public String toString() {
        return principal.toString();
    }

    @Override
    public AuthenticationContext getContext() {
        return authenticationContext;
    }
}
