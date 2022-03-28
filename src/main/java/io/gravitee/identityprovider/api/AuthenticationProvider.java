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
import io.reactivex.Maybe;

/**
 * @author Jeoffrey HAEYAERT (jeoffrey.haeyaert at graviteesource.com)
 * @author GraviteeSource Team
 */
public interface AuthenticationProvider<T, U> extends Service<AuthenticationProvider<T, U>> {
    /**
     * Get the source identifier of this authentication provider.
     * Gravitee components typically use "gravitee" when they use their own authentication provider.
     *
     * @return the source identifier of the authentication provider.
     */
    String getSource();

    /**
     * Performs authentication with the specified authentication request object.
     *
     * @param authentication the authentication request object.
     *
     * @return the fully authenticated user or empty if authentication does not succeeded.
     */
    Maybe<User> authenticate(Authentication<T, U> authentication);

    default AuthenticationProvider<T, U> start() throws Exception {
        return this;
    }

    default AuthenticationProvider<T, U> stop() throws Exception {
        return this;
    }
}
