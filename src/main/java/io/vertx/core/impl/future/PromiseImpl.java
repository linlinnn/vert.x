/*
 * Copyright (c) 2011-2019 Contributors to the Eclipse Foundation
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0, or the Apache License, Version 2.0
 * which is available at https://www.apache.org/licenses/LICENSE-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0 OR Apache-2.0
 */

package io.vertx.core.impl.future;

import io.netty.util.concurrent.Future;
import io.vertx.core.impl.ContextInternal;

public class PromiseImpl<T> extends FutureImpl<T> implements PromiseInternal<T> {

  /**
   * Create a promise that hasn't completed yet
   */
  public PromiseImpl() {
    super();
  }

  /**
   * Create a promise that hasn't completed yet
   */
  public PromiseImpl(ContextInternal context) {
    super(context);
  }

  @Override
  public void operationComplete(Future<T> future) throws Exception {
    if (future.isSuccess()) {
      complete(future.getNow());
    } else {
      fail(future.cause());
    }
  }

  @Override
  public io.vertx.core.Future<T> future() {
    return this;
  }
}
