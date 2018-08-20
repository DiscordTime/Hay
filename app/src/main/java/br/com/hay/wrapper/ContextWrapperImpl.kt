package br.com.hay.wrapper

import android.app.Activity
import android.content.Intent

class ContextWrapperImpl(val activity: ActivityWrapper) : ContextWrapper {
    override fun goNext(className: Class<out ActivityWrapper>, shouldClearStack: Boolean) {
        val context = activity.getActivityContext() as Activity
        val intent = Intent(context, className)
        if (shouldClearStack) intent.flags = (Intent.FLAG_ACTIVITY_NEW_TASK
                or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        context.startActivity(intent)
    }
}