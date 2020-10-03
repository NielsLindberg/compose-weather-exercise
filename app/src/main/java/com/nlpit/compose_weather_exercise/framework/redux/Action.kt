package com.nlpit.compose_weather_exercise.framework.redux

open class Action(val payload: Any? = null) {

    override fun toString(): String {
        payload?.let {
            return this.javaClass.superclass?.simpleName + "." + this.javaClass.simpleName + " {$it}"
        } ?: return this.javaClass.superclass?.simpleName + "." + this.javaClass.simpleName

    }
}