package com.app.server.businessservice.aspect;
import com.spartan.pluggable.logger.alarms.AppAlarm;
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.spartan.pluggable.logger.event.RequestHeaderBean;
import org.aspectj.lang.ProceedingJoinPoint;

public final class BusinessException {

    private LogManager Log = LogManagerFactory.getInstance(AppLoggerConstant.LOGGER_ID);

    public void getException(String boundedContext, String domain, Exception e, RequestHeaderBean requestHeaderBean, ProceedingJoinPoint joinPoint) throws Exception {
        if (e instanceof com.spartan.pluggable.exception.layers.ds.BatchProcessNotFoundException) {
            AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.ds.BatchProcessNotFoundException");
            Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getMessage(), e);
            throw new com.spartan.pluggable.exception.layers.ds.BatchProcessNotFoundException(appAlarm.getAlarmID(), e.getCause());
        } else if (e instanceof com.spartan.pluggable.exception.layers.ds.BatchProcessFailedException) {
            AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.ds.BatchProcessFailedException");
            Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getMessage(), e);
            throw new com.spartan.pluggable.exception.layers.ds.BatchProcessFailedException(appAlarm.getAlarmID(), e.getCause());
        } else if (e instanceof com.spartan.pluggable.exception.layers.ds.BusinessRulePreConditionException) {
            AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.ds.BusinessRulePreConditionException");
            Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getMessage(), e);
            throw new com.spartan.pluggable.exception.layers.ds.BusinessRulePreConditionException(appAlarm.getAlarmID(), e.getCause());
        } else if (e instanceof com.spartan.pluggable.exception.layers.ds.BusinessRuleFailedException) {
            AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.ds.BusinessRuleFailedException");
            Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getMessage(), e);
            throw new com.spartan.pluggable.exception.layers.ds.BusinessRuleFailedException(appAlarm.getAlarmID(), e.getCause());
        } else if (e instanceof com.spartan.pluggable.exception.layers.ds.SessionDataNotFoundException) {
            AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.ds.SessionDataNotFoundException");
            Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getMessage(), e);
            throw new com.spartan.pluggable.exception.layers.ds.SessionDataNotFoundException(appAlarm.getAlarmID(), e.getCause());
        } else if (e instanceof com.spartan.pluggable.exception.layers.ds.BusinessRuleNotFoundException) {
            AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.ds.BusinessRuleNotFoundException");
            Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getMessage(), e);
            throw new com.spartan.pluggable.exception.layers.ds.BusinessRuleNotFoundException(appAlarm.getAlarmID(), e.getCause());
        } else if (e instanceof com.spartan.pluggable.exception.layers.ds.BatchProcessInterruptedException) {
            AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.ds.BatchProcessInterruptedException");
            Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getMessage(), e);
            throw new com.spartan.pluggable.exception.layers.ds.BatchProcessInterruptedException(appAlarm.getAlarmID(), e.getCause());
        } else if (e instanceof com.spartan.pluggable.exception.layers.ds.BusinessRuleInternalError) {
            AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.ds.BusinessRuleInternalError");
            Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getMessage(), e);
            throw new com.spartan.pluggable.exception.layers.ds.BusinessRuleInternalError(appAlarm.getAlarmID(), e.getCause());
        } else if (e instanceof com.spartan.pluggable.exception.layers.ds.BusinessAspectFailedException) {
            AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.ds.BusinessAspectFailedException");
            Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getMessage(), e);
            throw new com.spartan.pluggable.exception.layers.ds.BusinessAspectFailedException(appAlarm.getAlarmID(), e.getCause());
        } else if (e instanceof com.spartan.pluggable.exception.layers.ds.NotificationConnectionException) {
            AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.ds.NotificationConnectionException");
            Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getMessage(), e);
            throw new com.spartan.pluggable.exception.layers.ds.NotificationConnectionException(appAlarm.getAlarmID(), e.getCause());
        } else if (e instanceof com.spartan.pluggable.exception.layers.ds.BusinessRuleInterruptedException) {
            AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.ds.BusinessRuleInterruptedException");
            Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getMessage(), e);
            throw new com.spartan.pluggable.exception.layers.ds.BusinessRuleInterruptedException(appAlarm.getAlarmID(), e.getCause());
        } else if (e instanceof com.spartan.pluggable.exception.layers.ds.NotificationNotFoundException) {
            AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.ds.NotificationNotFoundException");
            Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getMessage(), e);
            throw new com.spartan.pluggable.exception.layers.ds.NotificationNotFoundException(appAlarm.getAlarmID(), e.getCause());
        } else if (e instanceof com.spartan.pluggable.exception.layers.ds.NotificationTemplateException) {
            AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.ds.NotificationTemplateException");
            Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getMessage(), e);
            throw new com.spartan.pluggable.exception.layers.ds.NotificationTemplateException(appAlarm.getAlarmID(), e.getCause());
        } else if (e instanceof com.spartan.pluggable.exception.layers.ds.NotificationFailedException) {
            AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.ds.NotificationFailedException");
            Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getMessage(), e);
            throw new com.spartan.pluggable.exception.layers.ds.NotificationFailedException(appAlarm.getAlarmID(), e.getCause());
        } else {
            Log.out.println(boundedContext + domain + "257101500", requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getCause(), e);
            throw new Exception(boundedContext + domain + "257101500");
        }
    }
}
