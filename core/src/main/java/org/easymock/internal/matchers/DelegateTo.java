/*
 * Copyright 2001-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.easymock.internal.matchers;

import org.easymock.IArgumentMatcher;

import java.util.function.Consumer;

/**
 * Specialized argument matcher used to delegate the validation replay to a
 * given consumer.
 *
 * @author Patrick Reinhart
 */
public class DelegateTo<T> implements IArgumentMatcher {
  private final Consumer<T> consumer;

  public DelegateTo(Consumer<T> consumer) {
    this.consumer = consumer;
  }

  @Override
  @SuppressWarnings("unchecked")
  public boolean matches(Object argument) {
    consumer.accept((T)argument);
    return true;
  }

  @Override
  public void appendTo(StringBuffer buffer) {
    buffer.append("delegate(").append(consumer).append(")");
  }
}
