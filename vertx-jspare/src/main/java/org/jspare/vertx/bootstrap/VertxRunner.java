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
package org.jspare.vertx.bootstrap;

import static org.jspare.core.container.Environment.registryResource;

import org.jspare.core.bootstrap.Runner;
import org.jspare.vertx.builder.VertxBuilder;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;

public abstract class VertxRunner extends AbstractVerticle implements Runner {

	@Override
	public void run() {

		setup();

		mySupport();

		vertx().setHandler(res -> {
			
			if (res.succeeded()) {
				
				registryResource(new VertxHolder().vertx(vertx));
			}else{
				
				throw new RuntimeException("Failed to create Vert.x instance");
			}
		});
	}

	@Override
	public void setup() {

		EnvironmentUtils.register();
	}

	protected Future<Vertx> vertx() {

		return VertxBuilder.create().build().compose(vertx -> {
			
			vertx.deployVerticle(this);
		}, Future.succeededFuture());
	}
}