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

import io.reactivex.Single;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * @author Jeoffrey HAEYAERT (jeoffrey.haeyaert at graviteesource.com)
 * @author GraviteeSource Team
 */
public interface UserManager {
    /**
     * Get the source identifier of this user manager.
     * Gravitee components typically use "gravitee" when they use their own user internal repository.
     *
     * @return the source identifier of the authentication provider.
     */
    String getSource();

    /**
     * Creates a user.
     *
     * @param user the user to create.
     *
     * @return the created user.
     */
    Single<User> create(User user);

    /**
     * Updates a user.
     *
     * @param user the user to update.
     *
     * @return the updated user.
     */
    Single<User> update(User user);

    /**
     * Change the user's password.
     *
     * @param user the user to update.
     * @param newPassword the password to change to.
     *
     * @return the updated user.
     */
    Single<User> changePassword(User user, String newPassword);
}
