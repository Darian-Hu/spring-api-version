package com.spring.api.version;

import lombok.Getter;
import lombok.NonNull;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;

@Getter
public class ApiVersionRequestCondition implements RequestCondition<ApiVersionRequestCondition> {

    private static final String HEADER = "X-API-VERSION";

    private final String apiVersion;

    public ApiVersionRequestCondition(@NonNull String apiVersion) {
        this.apiVersion = apiVersion.trim();
    }

    @Override
    public ApiVersionRequestCondition combine(ApiVersionRequestCondition other) {
        return new ApiVersionRequestCondition(other.getApiVersion());
    }

    @Override
    public int compareTo(ApiVersionRequestCondition other, HttpServletRequest request) {
        return other.getApiVersion().compareTo(getApiVersion());
    }

    @Override
    public ApiVersionRequestCondition getMatchingCondition(HttpServletRequest request) {
        String version = request.getHeader(HEADER);
        boolean match = version != null && version.length() > 0 && version.trim().equals(apiVersion);
        if (match) {
            return this;
        }
        return null;
    }

    @Override
    public String toString() {
        return "@ApiVersion(" + apiVersion + ")";
    }
}
