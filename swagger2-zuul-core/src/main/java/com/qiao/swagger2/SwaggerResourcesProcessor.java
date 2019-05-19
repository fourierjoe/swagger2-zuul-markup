package com.qiao.swagger2;

import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Created by ql on 2019/5/18/018 15:41
 * @Version: v1.0
 */
public class SwaggerResourcesProcessor implements SwaggerResourcesProvider {

    @Resource
    private RouteLocator routeLocator;

    @Resource
    private SwaggerKeeperProperties swaggerKeeperConfig;

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();

        List<Route> routes = routeLocator.getRoutes();
        for (Route route : routes) {
            String routeName = route.getId();

            SwaggerResourceProperties resourceProperties = swaggerKeeperConfig.getResources().get(routeName);

            // 不用根据zuul的路由自动生成，并且当前route信息没有配置resource则不生成文档
            if (swaggerKeeperConfig.getAutoGenerateFromZuulRoutes() == false && resourceProperties == null) {
                continue;
            }

            // 需要根据zuul的路由自动生成，但是当前路由名在忽略清单中（ignoreRoutes）或者不在生成清单中（generateRoutes）则不生成文档
            if (swaggerKeeperConfig.getAutoGenerateFromZuulRoutes() == true && swaggerKeeperConfig.needIgnore(routeName)) {
                continue;
            }

            // 处理swagger文档的名称
            String name = routeName;
            if (resourceProperties != null && resourceProperties.getName() != null) {
                name = resourceProperties.getName();
            }

            // 处理获取swagger文档的路径
            String swaggerPath = swaggerKeeperConfig.getApiDocsPath();
            if (resourceProperties != null && resourceProperties.getApiDocsPath() != null) {
                swaggerPath = resourceProperties.getApiDocsPath();
            }
            String location = route.getFullPath().replace("**", swaggerPath);

            // 处理swagger的版本设置
            String swaggerVersion = swaggerKeeperConfig.getSwaggerVersion();
            if (resourceProperties != null && resourceProperties.getSwaggerVersion() != null) {
                swaggerVersion = resourceProperties.getSwaggerVersion();
            }

            resources.add(swaggerResource(name, location, swaggerVersion));

        }

        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }

}
