package me.lamhoangx.expect.wrapper

import platform.Foundation.NSURL

actual class LHURL actual constructor(url: String) {
    private val _url = NSURL(string = url)
    actual val host: String
        get() = _url.host ?: ""
    actual val path: String?
        get() = _url.path
    actual val query: String?
        get() = _url.query
}