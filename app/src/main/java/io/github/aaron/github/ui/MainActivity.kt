package io.github.aaron.github.ui

import android.Manifest
import android.widget.Toast
import com.yanzhenjie.permission.Action
import com.yanzhenjie.permission.AndPermission
import com.yanzhenjie.permission.runtime.Permission
import io.github.aaron.github.R
import io.github.aaron.github.base.BaseActivity
import io.github.aaron.github.ui.login.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun init() {
        AndPermission.with(this)
            .runtime()
            .permission(Permission.Group.STORAGE)
            .onGranted {
                Toast.makeText(this@MainActivity, "All permissions are granted", Toast.LENGTH_LONG)
                    .show()
            }
            .onDenied { permissions: List<String?>? ->
                Toast.makeText(
                    this@MainActivity,
                    "These permissions are denied: $permissions",
                    Toast.LENGTH_LONG
                ).show()

            }
            .start()

        configureView()
    }

    private fun configureView() {
        var fragment = ProfileFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.activity_main_container, fragment)
            .commit()


    }




}
