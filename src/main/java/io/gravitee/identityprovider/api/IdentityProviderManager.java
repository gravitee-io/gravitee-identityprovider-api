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
import java.util.Collection;
import java.util.Map;

/**
 * Allows to manage multiple {@link IdentityProvider}s.
 *
 * @author Jeoffrey HAEYAERT (jeoffrey.haeyaert at graviteesource.com)
 * @author GraviteeSource Team
 *
 * @see DefaultIdentityProviderManager
 */
public interface IdentityProviderManager extends Service<IdentityProviderManager> {
    /**
     * Get the {@link IdentityProvider} corresponding to the specified <code>source</code>
     *
     * @param source the source of the identity provider to get.
     *
     * @return the corresponding {@link IdentityProvider} found, <code>null</code> if no corresponding {@link IdentityProvider} has been found.
     */
    IdentityProvider get(String source);

    /**
     * Put the {@link IdentityProvider} for the specified <code>source</code>.
     *
     * @param source the source of the {@link IdentityProvider}.
     * @param identityProvider the {@link IdentityProvider}
     */
    void put(String source, IdentityProvider identityProvider);

    /**
     * Get all available {@link IdentityProvider}
     *
     * @return the list of {@link IdentityProvider} available.
     */
    Map<String, IdentityProvider> getAll();

    default AuthenticationProvider<?, ?> getAuthenticationProvider(String source) {
        IdentityProvider identityProvider = get(source);

        if (identityProvider != null) {
            return identityProvider.getAuthenticationProvider();
        }

        return null;
    }

    default UserManager getUserManager(String source) {
        IdentityProvider identityProvider = get(source);

        if (identityProvider != null) {
            return identityProvider.getUserManager();
        }

        return null;
    }

    default IdentityProviderManager start() throws Exception {
        return null;
    }

    default IdentityProviderManager stop() throws Exception {
        return this;
    }
}
