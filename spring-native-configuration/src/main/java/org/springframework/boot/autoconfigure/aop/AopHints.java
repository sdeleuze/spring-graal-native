/*
 * Copyright 2019-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.autoconfigure.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.weaver.reflect.Java15AnnotationFinder;
import org.aspectj.weaver.reflect.Java15GenericSignatureInformationProvider;
import org.aspectj.weaver.reflect.Java15ReflectionBasedReferenceTypeDelegate;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.aspectj.autoproxy.AspectJAwareAdvisorAutoProxyCreator;
import org.springframework.aop.framework.AbstractAdvisingBeanPostProcessor;
import org.springframework.aop.framework.ProxyConfig;
import org.springframework.aop.framework.ProxyProcessorSupport;
import org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.InfrastructureAdvisorAutoProxyCreator;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.nativex.type.NativeConfiguration;
import org.springframework.nativex.hint.NativeHint;
import org.springframework.nativex.hint.TypeHint;
import org.springframework.nativex.hint.AccessBits;

@NativeHint(trigger = AopAutoConfiguration.class,
	types = {
		@TypeHint(types= {
				ProxyProcessorSupport.class,
				ProxyConfig.class,
				InfrastructureAdvisorAutoProxyCreator.class,
				AbstractAdvisingBeanPostProcessor.class,
				AbstractAutoProxyCreator.class,
				AbstractAdvisorAutoProxyCreator.class,
				AnnotationAwareAspectJAutoProxyCreator.class,
				AspectJAwareAdvisorAutoProxyCreator.class,
				EnableAspectJAutoProxy.class,
				Aspect.class,
				Pointcut.class,
				Before.class,
				AfterReturning.class,
				After.class,
				Around.class},
				access = AccessBits.CLASS | AccessBits.DECLARED_CONSTRUCTORS | AccessBits.PUBLIC_METHODS),
		@TypeHint(types = {
				Java15AnnotationFinder.class, 
				Java15GenericSignatureInformationProvider.class,
				Java15ReflectionBasedReferenceTypeDelegate.class},
			access=AccessBits.CLASS|AccessBits.DECLARED_CONSTRUCTORS)
})
public class AopHints implements NativeConfiguration { }