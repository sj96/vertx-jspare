/*
 * Copyright 2016 Jspare.org.
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
package org.jspare.vertx.web.annotation.subrouter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.jspare.vertx.web.handler.APIHandler;

import io.vertx.ext.web.Router;

/**
 * The Namespace Annotation.
 *
 * <p>
 * The namespace module is used for mapping one namespace of one
 * {@link APIHandler}. When one type are annotated with this module and
 * registered on {@link Router} when your HttpServer will be started your
 * mappings will be registered with prefix defined on value field, if your field
 * are empty the convention that follow will be used:
 *
 * <br>
 * [Prefix]Controller: [prefix]/[your mapping] <b>e.g: UsersController:
 * users/</b>
 * </p>
 *
 * @author <a href="https://pflima92.github.io/">Paulo Lima</a>
 * @since 30/03/2016
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface SubRouter {

  /**
   * Value.
   *
   * @return the string
   */
  String value();
}
