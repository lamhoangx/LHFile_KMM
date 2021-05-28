package me.lamhoangx

import platform.Foundation.*

class NSExtension {
}

@Suppress("CAST_NEVER_SUCCEEDS")
fun String.toNSData(): NSData? {
    return (this as NSString).dataUsingEncoding(NSUTF8StringEncoding)
}

fun NSData.string(): String? {
    if(this.length == 0uL) return null
    this.bytes()
    val strBuilder = StringBuilder()
    val dataToString = NSString.create(this, NSUTF8StringEncoding)
    if(dataToString == null) {
//        LHTimber.d("ENRICH DATA FAILED: $this")
    } else {
//        LHTimber.d("ENRICH DATA: $dataToString")
        strBuilder.append(dataToString)
    }
    return if(strBuilder.isEmpty()) null else strBuilder.toString()
}