package io.github.aaron.github.utils

import android.webkit.CookieManager
import android.webkit.WebStorage


object NetUtil {
    /**
     * 清楚浏览器cookie
     */
    fun clearCookies() {
        val cookieManager = CookieManager.getInstance()
        cookieManager.setAcceptCookie(true)
        cookieManager.removeAllCookies(null)
        WebStorage.getInstance().deleteAllData()
        CookieManager.getInstance().flush()
    }
}