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
package io.gravitee.identityprovider.api;

import io.gravitee.common.service.Service;

/**
 * @author Jeoffrey HAEYAERT (jeoffrey.haeyaert at graviteesource.com)
 * @author GraviteeSource Team
 */
public interface IdentityProvider extends Service<IdentityProvider> {
    /**
     * Get the source identifier of this identity provider.
     * Gravitee components typically use "gravitee" when they use their own identity provider.
     *
     * @return the source identifier of the identity provider.
     */
    String getSource();

    /**
     * Get the {@link AuthenticationProvider} to use for this {@link IdentityProvider}.
     *
     * @param <T> the type of the authentication principal
     * @param <U> the type of the authentication credentials
     *
     * @return the authentication provider.
     */
    <T, U> AuthenticationProvider<T, U> getAuthenticationProvider();

    default IdentityProvider start() throws Exception {
        return this;
    }

    default IdentityProvider stop() throws Exception {
        return this;
    }

    /**
     * Get the {@link UserManager} to use for this {@link IdentityProvider}.
     * Note: not all {@link IdentityProvider}s provide {@link UserManager}, can be <code>null</code>.
     *
     * @return the {@link UserManager} or <code>null</code> if no {@link UserManager} can be used for this {@link IdentityProvider}.
     */
    default UserManager getUserManager() {
        // Cockpit doesn't need a UserManager as it manages users by itself.
        return null;
    }
}
