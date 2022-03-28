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

import io.gravitee.common.service.AbstractService;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jeoffrey HAEYAERT (jeoffrey.haeyaert at graviteesource.com)
 * @author GraviteeSource Team
 */
public class DefaultIdentityProviderManager extends AbstractService<IdentityProviderManager> implements IdentityProviderManager {

    private final Map<String, IdentityProvider> identityProviders = new HashMap<>();

    public IdentityProvider get(String id) {
        return identityProviders.get(id);
    }

    public void put(String id, IdentityProvider identityProvider) {
        identityProviders.put(id, identityProvider);
    }

    @Override
    public Map<String, IdentityProvider> getAll() {
        return identityProviders;
    }
}
