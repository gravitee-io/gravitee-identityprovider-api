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

/**
 * Holds the principal and credentials to use for an authentication request.
 *
 * @param <T> the type of the principal
 * @param <U> the type of the credentials
 *
 * @author Jeoffrey HAEYAERT (jeoffrey.haeyaert at graviteesource.com)
 * @author GraviteeSource Team
 * @see UsernamePasswordAuthentication
 * @see PasswordLessAuthentication
 */
public interface Authentication<T, U> {

    /**
     * The identity of the principal being authenticated. In the case of an authentication
     * request with username and password, this would be the username. Callers are
     * expected to populate the principal for an authentication request.
     *
     * @return the <code>Principal</code> being authenticated or the authenticated
     * principal after authentication.
     */
    T getPrincipal();

    /**
     * The credentials that prove the principal is correct. This is usually a password,
     * but could be anything relevant to the <code>AuthenticationManager</code>. Callers
     * are expected to populate the credentials.
     *
     * @return the credentials that prove the identity of the <code>Principal</code>
     */
    U getCredentials();

    /**
     * An optional context containing information about current authentication request.
     * For convenience, default implementation returns <code>null</code>.
     *
     * @return the context of the current authentication request or <code>null</code> if there is no context.
     */
    default AuthenticationContext getContext() {
        return null;
    }
}
