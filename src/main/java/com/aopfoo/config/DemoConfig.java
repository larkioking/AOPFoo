package com.aopfoo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.aopfoo")
@EnableAspectJAutoProxy
public class DemoConfig {
}
