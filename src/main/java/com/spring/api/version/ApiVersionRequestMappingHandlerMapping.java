package com.spring.api.version;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

@Slf4j
@AllArgsConstructor
public class ApiVersionRequestMappingHandlerMapping extends RequestMappingHandlerMapping {

    @Override
    protected RequestCondition<?> getCustomTypeCondition(Class<?> handlerType) {
        return createRequestCondition(handlerType);
    }

    @Override
    protected RequestCondition<?> getCustomMethodCondition(Method method) {
        return createRequestCondition(method);
    }

    private RequestCondition<ApiVersionRequestCondition> createRequestCondition(AnnotatedElement target) {
        ApiVersion apiVersion = AnnotationUtils.findAnnotation(target, ApiVersion.class);
        if (apiVersion == null) {
            return null;
        }
        String version = apiVersion.value().trim();
        InnerUtils.checkVersionNumber(version, target);
        return new ApiVersionRequestCondition(version);
    }

}
