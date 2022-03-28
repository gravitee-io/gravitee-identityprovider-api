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

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author Jeoffrey HAEYAERT (jeoffrey.haeyaert at graviteesource.com)
 * @author GraviteeSource Team
 *
 * @see DefaultUser
 */
public interface User extends Serializable {
    /**
     * Returns the technical id used of the user
     *
     * @return the technical id
     */
    String getId();

    /**
     * Returns the username used to authenticate the user. Cannot return <code>null</code>.
     *
     * @return the username (never <code>null</code>)
     */
    String getUsername();

    /**
     * Returns the password of the user. (Useful for user management)
     *
     * @return the password
     */
    String getPassword();

    /**
     * Allows to set the password (Useful to encode the password).
     */
    void setPassword(String password);

    /**
     * Indicates whether the user's account has expired. An expired account cannot be authenticated.
     *
     * @return <code>true</code> if the user's account is valid (ie non-expired), <code>false</code> if no longer valid
     *         (ie expired)
     */
    boolean isAccountExpired();

    /**
     * Indicates whether the user is enabled or disabled. A disabled user cannot be authenticated.
     *
     * @return <code>true</code> if the user is enabled, <code>false</code> otherwise
     */
    boolean isEnabled();

    /**
     * Returns the user roles
     *
     * @return the user roles
     */
    default List<String> getRoles() {
        return Collections.emptyList();
    }

    /**
     * Returns the user additional information
     *
     * @return the user additional information
     */
    Map<String, Object> getAdditionalInformation();

    /**
     * Returns the user creation date
     *
     * @return the user creation date
     */
    ZonedDateTime getCreatedAt();

    /**
     * Returns the last time when user has been updated
     *
     * @return the last time when user has been updated
     */
    ZonedDateTime getUpdatedAt();
}
