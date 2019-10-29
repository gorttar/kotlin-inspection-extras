package com.plugin.inspection

import com.intellij.codeInspection.InspectionToolProvider

class CustomInspectionProvider : InspectionToolProvider {
    override fun getInspectionClasses(): Array<Class<out Any>> = arrayOf(MethodCallResultIgnoredInspection::class.java)
}