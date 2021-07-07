/**
 * stream.com.xh.listener.TestEListeners 测试
 *
 * @TransactionalEventListener 事务提交后才会发送事件，才会被监听到
 * @EventListener : 无需事务
 * 以及 异步 @Async : 可用 但是记住要 @EnableAsync
 * 以及 condition 条件, (condition = "#event.biz == 'biz1-a'") 可用。   #event 取入参  SPEL 表达式
 */
package stream.com.xh.listener;