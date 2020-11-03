package com.effectivejava.items.utils.components.impl.holder;


import com.effectivejava.items.utils.components.holder.MessagesProperties;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class MessagesPropertiesImpl implements MessagesProperties {

    @Value("${login.attempt.exceed}")
    private String attemptCountExceed;


}
