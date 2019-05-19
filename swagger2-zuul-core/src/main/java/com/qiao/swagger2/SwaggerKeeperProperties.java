package com.qiao.swagger2;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description:
 * @Created by ql on 2019/5/18/018 15:44
 * @Version: v1.0
 */
@ConfigurationProperties(("swagger.keeper"))
public class SwaggerKeeperProperties {
    /**
     * 配置静态文档地址
     */
    private Map<String, SwaggerResourceProperties> resources = new HashMap<>();

    /**
     * 不显示没有实例的服务
     */
    private Boolean notShowNoInstanceService = true;

    /**
     * Swagger返回JSON文档的接口路径（全局配置）
     */
    private String apiDocsPath = "/v2/api-docs";

    /**
     * Swagger文档版本（全局配置）
     */
    private String swaggerVersion = "2.0";

    /**
     * 为Zuul中的Routes自动生成API文档
     */
    private Boolean autoGenerateFromZuulRoutes = false;

    /**
     * 不自动生成文档的路由名称，设置了ignoreRoutes之后，generateRoutes不生效（需要autoGenerateFromZuulRoutes=true）
     */
    private Set<String> ignoreRoutes = new HashSet<>();

    /**
     * 自动生成文档的路由名称，设置了generateRoutes之后，ignoreRoutes不生效（需要autoGenerateFromZuulRoutes=true）
     */
    private Set<String> generateRoutes = new HashSet<>();

    public boolean needIgnore(String route) {
        if(generateRoutes.size() > 0 && ignoreRoutes.size() > 0) {
            throw new RuntimeException("generateRoutes和ignoreRoutes只能设置一个");
        }

        // generateRoutes和ignoreRoutes都不配置的话，会根据route生成所有的
        if(generateRoutes.size() == 0 && ignoreRoutes.size() == 0 ) {
            return false;
        }

        if(generateRoutes.size() == 0 && ignoreRoutes.contains(route)) {
            return true;
        }

        if(ignoreRoutes.size() == 0 && generateRoutes.contains(route) == false) {
            return true;
        }

        return false;
    }

    public Map<String, SwaggerResourceProperties> getResources() {
        return resources;
    }

    public void setResources(Map<String, SwaggerResourceProperties> resources) {
        this.resources = resources;
    }

    public Boolean getNotShowNoInstanceService() {
        return notShowNoInstanceService;
    }

    public void setNotShowNoInstanceService(Boolean notShowNoInstanceService) {
        this.notShowNoInstanceService = notShowNoInstanceService;
    }

    public String getApiDocsPath() {
        return apiDocsPath;
    }

    public void setApiDocsPath(String apiDocsPath) {
        this.apiDocsPath = apiDocsPath;
    }

    public String getSwaggerVersion() {
        return swaggerVersion;
    }

    public void setSwaggerVersion(String swaggerVersion) {
        this.swaggerVersion = swaggerVersion;
    }

    public Boolean getAutoGenerateFromZuulRoutes() {
        return autoGenerateFromZuulRoutes;
    }

    public void setAutoGenerateFromZuulRoutes(Boolean autoGenerateFromZuulRoutes) {
        this.autoGenerateFromZuulRoutes = autoGenerateFromZuulRoutes;
    }

    public Set<String> getIgnoreRoutes() {
        return ignoreRoutes;
    }

    public void setIgnoreRoutes(Set<String> ignoreRoutes) {
        this.ignoreRoutes = ignoreRoutes;
    }

    public Set<String> getGenerateRoutes() {
        return generateRoutes;
    }

    public void setGenerateRoutes(Set<String> generateRoutes) {
        this.generateRoutes = generateRoutes;
    }
}
