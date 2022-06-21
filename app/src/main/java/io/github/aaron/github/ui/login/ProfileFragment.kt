package io.github.aaron.github.ui.login

import android.content.Intent
import android.view.View
import androidx.lifecycle.Observer
import io.github.aaron.github.R
import io.github.aaron.github.base.BaseFragment
import io.github.aaron.github.common.SimpleImageLoader
import io.github.aaron.github.ui.search.SearchActivity
import kotlinx.android.synthetic.main.fragment_profile.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * 个人主页fragment
 **/

class ProfileFragment : BaseFragment() {

    private val viewModel: UserViewModel by viewModel()

    override fun getLayoutId(): Int {
        return R.layout.fragment_profile
    }


    override fun onResume() {
        super.onResume()
        initContent()
    }

    private fun initContent(){
        if(viewModel.isLogin()) {
            configureObservables()
            viewModel.getUser()
            empty_layout.visibility = View.GONE
            user_layout.visibility = View.VISIBLE
            logout_button.setOnClickListener {
                viewModel.logout()
                initContent()
            }
        } else {
            empty_layout.visibility = View.VISIBLE
            user_layout.visibility = View.GONE
            fragment_login_button.setOnClickListener {
                context?.startActivity(Intent(context, LoginActivity::class.java))

            }
        }
    }

    override fun init() {
        fab.setOnClickListener {
            context?.startActivity(Intent(context, SearchActivity::class.java))
        }
    }

    private fun configureObservables() {
        viewModel.user.observe(this, Observer {
            item_title.text = it.login
            it.avatar_url?.let { it1 -> SimpleImageLoader.loadImageCircle(it1, item_user_image_profile) }
            val html = "链接地址${it.html_url}"
            item_des_view.text = html
        })
    }
}