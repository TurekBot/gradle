/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.api.internal.provider;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import org.gradle.api.Action;
import org.gradle.api.provider.CollectionPropertyConfigurer;
import org.gradle.api.provider.ListProperty;
import org.gradle.api.provider.Provider;
import org.gradle.internal.Cast;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

import static org.gradle.internal.Cast.uncheckedNonnullCast;

public class DefaultListProperty<T> extends AbstractCollectionProperty<T, List<T>> implements ListProperty<T> {
    private static final Supplier<ImmutableCollection.Builder<Object>> FACTORY = new Supplier<ImmutableCollection.Builder<Object>>() {
        @Override
        public ImmutableCollection.Builder<Object> get() {
            return ImmutableList.builder();
        }
    };
    public DefaultListProperty(PropertyHost host, Class<T> elementType) {
        super(host, List.class, elementType, Cast.uncheckedNonnullCast(FACTORY));
    }

    @Override
    public Class<?> publicType() {
        return ListProperty.class;
    }

    @Override
    public int getFactoryId() {
        return ManagedFactories.ListPropertyManagedFactory.FACTORY_ID;
    }

    @Override
    protected ImmutableList<T> emptyCollection() {
        return ImmutableList.of();
    }

    @Override
    public ListProperty<T> empty() {
        super.empty();
        return this;
    }

    @Override
    public ListProperty<T> value(@Nullable Iterable<? extends T> elements) {
        super.value(elements);
        return this;
    }

    @Override
    public ListProperty<T> value(Provider<? extends Iterable<? extends T>> provider) {
        super.value(provider);
        return this;
    }

    @Override
    public ListProperty<T> convention(@Nullable Iterable<? extends T> elements) {
        super.convention(elements);
        return this;
    }

    @Override
    public ListProperty<T> convention(Provider<? extends Iterable<? extends T>> provider) {
        super.convention(provider);
        return this;
    }

    @Override
    public ListProperty<T> withActualValue(Action<CollectionPropertyConfigurer<T>> action) {
        return uncheckedNonnullCast(super.withActualValue(action));
    }

    @Override
    public ListProperty<T> unset() {
        return uncheckedNonnullCast(super.unset());
    }

    @Override
    public ListProperty<T> unsetConvention() {
        return uncheckedNonnullCast(super.unsetConvention());
    }
}
