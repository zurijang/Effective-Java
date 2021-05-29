package ej.study.practice.common.interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.session.ResultHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Statement;

@Component
@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class}),
        @Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class})
})
public class MybatisInterceptor implements Interceptor {
    Logger logger = LoggerFactory.getLogger(MybatisInterceptor.class);
    @Autowired
    private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
    private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
    private static final ReflectorFactory DEFAULT_REFLECTOR_FACTORY = new DefaultReflectorFactory();

    private Field getField(Class<? extends Object> fieldClass, String fieldName) {
        try {
            Field field = fieldClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException e) {
            //nothing...
            return null;
        }
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaStatementHandler = MetaObject.forObject(statementHandler, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY, DEFAULT_REFLECTOR_FACTORY);
        String originalSql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");
        String id = (String) metaStatementHandler.getValue("delegate.mappedStatement.id");

        Object params = statementHandler.getParameterHandler().getParameterObject();
        Object proceed;

        if(params != null) {
            try {
                Class<? extends Object> paramClass = params.getClass();
                if("prepare".equals(invocation.getMethod().getName())) {
                    Field current_page = getField(paramClass,"current_page");
                    Field per_page = getField(paramClass,"per_page");
                    Field is_paging = getField(paramClass,"is_paging");
                    Field recordstart = getField(paramClass,"recordstart");

                    if(params != null && current_page != null && per_page != null && recordstart != null && (boolean)is_paging.get(params) == true) {
                        originalSql = "SELECT SQL_CALC_FOUND_ROWS O.* FROM (SELECT @RNUM:= @RNUM + 1 AS RNUM, I.* FROM (" + originalSql;
                        originalSql = originalSql + " LIMIT 184467440737095516 ) I, (SELECT @RNUM := 0) R ) O ";

                        StringBuffer sb = new StringBuffer();
                        sb.append(" /* " + id + " */\n");
                        sb.append(originalSql);
                        sb.append(" limit ");
                        sb.append(recordstart.get(params).toString());
                        sb.append(", ");
                        sb.append(per_page.get(params).toString());
                        String outputSql = sb.toString();
                        logger.debug(id);
                        logger.debug("--------------------------");
                        logger.debug(outputSql);
                        metaStatementHandler.setValue("delegate.boundSql.sql", outputSql);
                    }
                    proceed = invocation.proceed();
                } else {
                    proceed = invocation.proceed();
                }
            } catch (Exception e) {
                e.printStackTrace();
                //nothing
                proceed = invocation.proceed();
            }

        }else {
            proceed = invocation.proceed();
        }

        return proceed;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }
}
