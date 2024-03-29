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

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lorie Pisicchio (lorie.pisicchio at graviteesource.com)
 * @author GraviteeSource Team
 */
public class SimpleAuthenticationContext implements AuthenticationContext {

    private final Map<String, Object> attributes = new HashMap<>();

    public SimpleAuthenticationContext() {}

    @Override
    public AuthenticationContext set(String name, Object value) {
        attributes.put(name, value);
        return this;
    }

    @Override
    public AuthenticationContext remove(String name) {
        attributes.remove(name);
        return this;
    }

    @Override
    public Object get(String name) {
        return attributes.get(name);
    }

    @Override
    public Map<String, Object> attributes() {
        return attributes;
    }
}
