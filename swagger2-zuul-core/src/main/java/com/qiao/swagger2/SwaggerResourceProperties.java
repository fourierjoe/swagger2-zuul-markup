package com.qiao.swagger2;

/**
 * @Description:
 * @Created by ql on 2019/5/18/018 15:43
 * @Version: v1.0
 */
public class SwaggerResourceProperties {
    /**
     * 需要获取的文档名称，对应Zuul中的Route名称
     */
    private String name;

    /**
     * 配置swaggerVersion，不配置的话采用全局默认配置：2.0
     */
    private String swaggerVersion;

    /**
     * 配置api文档的获取路径，不配置的话采用全局默认配置：/v2/api-docs
     */
    private String apiDocsPath;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSwaggerVersion() {
        return swaggerVersion;
    }

    public void setSwaggerVersion(String swaggerVersion) {
        this.swaggerVersion = swaggerVersion;
    }

    public String getApiDocsPath() {
        return apiDocsPath;
    }

    public void setApiDocsPath(String apiDocsPath) {
        this.apiDocsPath = apiDocsPath;
    }
}
