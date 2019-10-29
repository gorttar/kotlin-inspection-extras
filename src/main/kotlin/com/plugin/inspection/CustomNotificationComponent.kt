package com.plugin.inspection

import com.intellij.notification.NotificationDisplayType
import com.intellij.notification.NotificationGroup
import com.intellij.notification.NotificationType
import com.intellij.notification.Notifications
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.ProjectComponent
import com.intellij.openapi.util.NotNullLazyValue

class CustomNotificationComponent : ProjectComponent {
    override fun initComponent() {
        ApplicationManager.getApplication()
                .invokeLater {
                    Notifications.Bus.notify(
                            object : NotNullLazyValue<NotificationGroup>() {
                                override fun compute(): NotificationGroup {
                                    return NotificationGroup(
                                            "Motivational message",
                                            NotificationDisplayType.STICKY_BALLOON,
                                            true)
                                }
                            }.value
                                    .createNotification(
                                            "Testing Personal Plugin",
                                            "Check for Kotlin non CamelCase usage",
                                            NotificationType.INFORMATION,
                                            null
                                    )
                    )
                }
    }
}