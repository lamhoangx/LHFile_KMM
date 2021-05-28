package me.lamhoangx.expect.wrapper

expect class LHURL(url: String) {
    val host: String
    val path: String?
    val query: String?
}