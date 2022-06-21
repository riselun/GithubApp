package io.github.aaron.github.ui.login

import android.app.ProgressDialog
import android.graphics.Bitmap
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.lifecycle.Observer
import io.github.aaron.github.BuildConfig
import io.github.aaron.github.R
import io.github.aaron.github.api.NetworkState
import io.github.aaron.github.base.BaseActivity
import io.github.aaron.github.ui.search.SearchViewModel
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * 登陆activity
 **/

class LoginActivity: BaseActivity() {

    private val viewModel: LoginViewModel by viewModel()

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun init() {
        initWeb()
        initObserver()
    }

    private fun initObserver() {
        var dialog: ProgressDialog ? = null
        viewModel.networkState.observe(this, Observer {
          when(it){
              NetworkState.RUNNING -> {
                  dialog = ProgressDialog.show(this, "正在登陆", "")
              }
              NetworkState.SUCCESS->{
                  Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show()
                  dialog?.dismiss()
                  finish()
              }
              NetworkState.FAILED->{
                  Toast.makeText(this, "登陆失败，请重试", Toast.LENGTH_SHORT).show()
                  dialog?.dismiss()
              }
          }
        })
    }

    private fun initWeb() {
        val settings = oauth_webview.settings
        settings.javaScriptEnabled = true
        settings.loadWithOverviewMode = true
        settings.builtInZoomControls = false
        settings.displayZoomControls = false
        settings.domStorageEnabled = true
        settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.NARROW_COLUMNS
        settings.setAppCacheEnabled(true)

        val webViewClient: WebViewClient = object : WebViewClient() {

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                oauth_webview_loadingBar.visibility = View.GONE
            }

            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                if (request != null && request.url != null &&
                    request.url.toString().startsWith("aarongithubapp://authed")) {
                    val code = request.url.getQueryParameter("code")
                    if (code != null) {
                        viewModel.oauth(code)
                    }
                    return true
                }
                return false
            }
        }


        oauth_webview.webViewClient = webViewClient


        val url = "https://github.com/login/oauth/authorize?" +
                "client_id=${BuildConfig.CLIENT_ID}&" +
                "state=app&redirect_uri=aarongithubapp://authed";

        oauth_webview.loadUrl(url)
    }

}