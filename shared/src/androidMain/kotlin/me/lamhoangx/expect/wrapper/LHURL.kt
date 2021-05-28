package me.lamhoangx.expect.wrapper

import java.net.URL

actual class LHURL actual constructor(url: String) {
    private var _url: URL? = null
    init {
        try {
            _url = URL(url)
        } catch (e: Throwable) {
        }
    }

    actual val host: String
        get() = _url?.host ?: ""
    actual val path: String?
        get() = _url?.path
    actual val query: String?
        get() = _url?.query
}