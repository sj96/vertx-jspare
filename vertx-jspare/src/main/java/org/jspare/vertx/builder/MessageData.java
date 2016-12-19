/*
 * Copyright 2016 JSpare.org.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.jspare.vertx.builder;

import java.lang.reflect.Method;

import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
@AllArgsConstructor
public class MessageData {

	private Object controller;

	private Method method;

	private String name;

	public <T> Handler<Message<T>> wrap() {

		return new Handler<Message<T>>() {

			@Override
			@SneakyThrows
			public void handle(Message<T> event) {

				if (method.getParameterCount() == 1) {

					method().invoke(controller, event);
				} else {

					method.invoke(controller);
				}
			}
		};
	}

}