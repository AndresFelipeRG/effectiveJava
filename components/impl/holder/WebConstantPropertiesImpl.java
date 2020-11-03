package com.effectivejava.items.utils.components.impl.holder;

import com.effectivejava.items.utils.components.holder.WebConstantProperties;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class WebConstantPropertiesImpl implements WebConstantProperties {

    @Value("${server.servlet.context.path}")
    private String basePath;

    @Value("${server.domain.name}")
    private String domainName;

    @Value("${server.port}")
    private Integer appPort;

    @Value("${server.cookie.same_site}")
    private String sameSite;
}
