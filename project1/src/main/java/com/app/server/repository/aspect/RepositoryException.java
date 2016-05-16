package com.app.server.repository.aspect;
import com.spartan.pluggable.logger.alarms.AppAlarm;
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.spartan.pluggable.logger.event.RequestHeaderBean;
import org.aspectj.lang.ProceedingJoinPoint;

public final class RepositoryException {

    private LogManager Log = LogManagerFactory.getInstance(AppLoggerConstant.LOGGER_ID);

    public void getException(String boundedContext, String domain, Exception e, RequestHeaderBean requestHeaderBean, ProceedingJoinPoint joinPoint) throws Exception {
        if (e instanceof com.spartan.pluggable.exception.layers.db.RepositoryDeleteFailedException) {
            AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.db.RepositoryDeleteFailedException");
            Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getMessage(), e);
            throw new com.spartan.pluggable.exception.layers.db.RepositoryDeleteFailedException(appAlarm.getAlarmID(), e.getCause());
        } else if (e instanceof com.spartan.pluggable.exception.layers.db.RepositoryDataValidationFailedException) {
            AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.db.RepositoryDataValidationFailedException");
            Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getMessage(), e);
            throw new com.spartan.pluggable.exception.layers.db.RepositoryDataValidationFailedException(appAlarm.getAlarmID(), e.getCause());
        } else if (e instanceof javax.persistence.NoResultException) {
            AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.db.NoResultException");
            Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getMessage(), e);
            throw new com.spartan.pluggable.exception.layers.db.NoResultException(appAlarm.getAlarmID(), e.getCause());
        } else if (e instanceof javax.persistence.TransactionRequiredException) {
            AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.db.TransactionRequiredException");
            Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getMessage(), e);
            throw new com.spartan.pluggable.exception.layers.db.TransactionRequiredException(appAlarm.getAlarmID(), e.getCause());
        } else if (e instanceof javax.persistence.EntityExistsException) {
            AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.db.EntityExistsException");
            Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getMessage(), e);
            throw new com.spartan.pluggable.exception.layers.db.EntityExistsException(appAlarm.getAlarmID(), e.getCause());
        } else if (e instanceof javax.persistence.OptimisticLockException) {
            AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.db.OptimisticLockException");
            Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getMessage(), e);
            throw new com.spartan.pluggable.exception.layers.db.OptimisticLockException(appAlarm.getAlarmID(), e.getCause());
        } else if (e instanceof javax.persistence.QueryTimeoutException) {
            AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.db.QueryTimeoutException");
            Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getMessage(), e);
            throw new com.spartan.pluggable.exception.layers.db.QueryTimeoutException(appAlarm.getAlarmID(), e.getCause());
        } else if (e instanceof com.spartan.pluggable.exception.layers.db.RepositoryDataSourceConnectionException) {
            AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.db.RepositoryDataSourceConnectionException");
            Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getMessage(), e);
            throw new com.spartan.pluggable.exception.layers.db.RepositoryDataSourceConnectionException(appAlarm.getAlarmID(), e.getCause());
        } else if (e instanceof javax.persistence.LockTimeoutException) {
            AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.db.LockTimeoutException");
            Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getMessage(), e);
            throw new com.spartan.pluggable.exception.layers.db.LockTimeoutException(appAlarm.getAlarmID(), e.getCause());
        } else if (e instanceof javax.persistence.RollbackException) {
            AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.db.RollbackException");
            Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getMessage(), e);
            throw new com.spartan.pluggable.exception.layers.db.RollbackException(appAlarm.getAlarmID(), e.getCause());
        } else if (e instanceof javax.persistence.EntityNotFoundException) {
            AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.db.EntityNotFoundException");
            Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getMessage(), e);
            throw new com.spartan.pluggable.exception.layers.db.EntityNotFoundException(appAlarm.getAlarmID(), e.getCause());
        } else if (e instanceof com.spartan.pluggable.exception.layers.db.RepositoryWriteFailedException) {
            AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.db.RepositoryWriteFailedException");
            Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getMessage(), e);
            throw new com.spartan.pluggable.exception.layers.db.RepositoryWriteFailedException(appAlarm.getAlarmID(), e.getCause());
        } else if (e instanceof javax.persistence.NonUniqueResultException) {
            AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.db.NonUniqueResultException");
            Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getMessage(), e);
            throw new com.spartan.pluggable.exception.layers.db.NonUniqueResultException(appAlarm.getAlarmID(), e.getCause());
        } else if (e instanceof com.spartan.pluggable.exception.layers.db.RepositoryUpdateFailedException) {
            AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.db.RepositoryUpdateFailedException");
            Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getMessage(), e);
            throw new com.spartan.pluggable.exception.layers.db.RepositoryUpdateFailedException(appAlarm.getAlarmID(), e.getCause());
        } else if (e instanceof javax.persistence.PessimisticLockException) {
            AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.db.PessismisticLockException");
            Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getMessage(), e);
            throw new com.spartan.pluggable.exception.layers.db.PessismisticLockException(appAlarm.getAlarmID(), e.getCause());
        } else {
            Log.out.println(boundedContext + domain + "352151500", requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getCause(), e);
            throw new Exception(boundedContext + domain + "352151500");
        }
    }
}
