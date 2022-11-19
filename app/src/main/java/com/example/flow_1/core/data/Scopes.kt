package com.example.flow_1.core.data
import javax.inject.Scope

/*

@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class MainScope

@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class FeatureScope

@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class DomainScope

@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class FeatureDataScope

@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class BaseScope


@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class CommonUiScope
*/

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class MainWithNetworkScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class NetworkScope