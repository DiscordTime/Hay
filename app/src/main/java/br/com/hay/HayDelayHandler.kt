package br.com.hay

import android.os.Handler

class HayDelayHandler() : IDelayHandler {

    private var mDelayHandler: Handler? = null
    private var mRunnable: Runnable? = null

    override fun start(count: Long, runnable: Runnable) {
        mDelayHandler = Handler()
        mRunnable = runnable
        mDelayHandler?.postDelayed(runnable, count)
    }

    override fun destroy(){
        mDelayHandler?.removeCallbacks(mRunnable)
        mRunnable = null
    }
}