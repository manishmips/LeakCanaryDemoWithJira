package com.mt.leakcanarysample
import leakcanary.LeakCanary

object LeakCanaryUploaderInit {
    fun initLeakCanary(){
        LeakCanary.config = LeakCanary.config.copy(onHeapAnalyzedListener = LeakUploader(),dumpHeapWhenDebugging=true,dumpHeap = true)
    }
}