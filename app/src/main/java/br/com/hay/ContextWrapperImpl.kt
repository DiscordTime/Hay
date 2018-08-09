package br.com.hay

import android.content.Intent

class ContextWrapperImpl(var activity: ActivityWrapper) : ContextWrapper {
    override fun goNext(className: Class<out ActivityWrapper>) {
        var context = activity.getActivityContext()
        val intent = Intent(context, className)
        context.startActivity(intent)
    }
}