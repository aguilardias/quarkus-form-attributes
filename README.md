
Unable to find contextual data of type: io.vertx.core.http.HttpServerRequest #9284
https://github.com/quarkusio/quarkus/issues/9284

Reproduce

1. `git clone https://github.com/aguilardias/quarkus-form-attributes.git`

2. Open a new terminal and execute the following curl command (update file path):  
`curl -X POST "http://localhost:8080/hello" -H "accept: text/plain" -H "Content-Type: multipart/form-data" -F "name=user name" -F "photo=@/path/to/file"`

3. Watch error
```
endHandler
org.jboss.resteasy.spi.LoggableFailure: RESTEASY003880: Unable to find contextual data of type: io.vertx.core.http.HttpServerRequest
        at org.jboss.resteasy.core.ContextParameterInjector$GenericDelegatingProxy.invoke(ContextParameterInjector.java:124)
        at com.sun.proxy.$Proxy41.formAttributes(Unknown Source)
        at org.acme.AuditFilter.lambda$filter$1(AuditFilter.java:25)
        at io.vertx.core.http.impl.HttpServerRequestImpl.onEnd(HttpServerRequestImpl.java:530)
        at io.vertx.core.http.impl.HttpServerRequestImpl.lambda$pendingQueue$1(HttpServerRequestImpl.java:118)
        at io.vertx.core.streams.impl.InboundBuffer.handleEvent(InboundBuffer.java:237)
        at io.vertx.core.streams.impl.InboundBuffer.drain(InboundBuffer.java:224)
        at io.vertx.core.streams.impl.InboundBuffer.lambda$fetch$0(InboundBuffer.java:277)
        at io.vertx.core.impl.ContextImpl.executeTask(ContextImpl.java:369)
        at io.vertx.core.impl.EventLoopContext.lambda$executeAsync$0(EventLoopContext.java:38)
        at io.netty.util.concurrent.AbstractEventExecutor.safeExecute(AbstractEventExecutor.java:164)
        at io.netty.util.concurrent.SingleThreadEventExecutor.runAllTasks(SingleThreadEventExecutor.java:472)
        at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:500)
        at io.netty.util.concurrent.SingleThreadEventExecutor$4.run(SingleThreadEventExecutor.java:989)
        at io.netty.util.internal.ThreadExecutorMap$2.run(ThreadExecutorMap.java:74)
        at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)
        at java.base/java.lang.Thread.run(Thread.java:834)
```