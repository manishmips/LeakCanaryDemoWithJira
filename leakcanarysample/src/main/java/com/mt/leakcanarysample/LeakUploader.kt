package com.mt.leakcanarysample

import leakcanary.DefaultOnHeapAnalyzedListener
import leakcanary.OnHeapAnalyzedListener
import shark.HeapAnalysis

class LeakUploader : OnHeapAnalyzedListener {

    private val defaultListener = DefaultOnHeapAnalyzedListener.create()

    override fun onHeapAnalyzed(heapAnalysis: HeapAnalysis) {
        if (defaultListener != null) {
            defaultListener.onHeapAnalyzed(heapAnalysis)
        }
    }
}