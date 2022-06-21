package io.github.aaron.github.ui.search

import android.view.Menu
import android.widget.SearchView
import io.github.aaron.github.R
import io.github.aaron.github.base.BaseActivity

class SearchActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_search
    }

    override fun init() {
        configureFragment()
    }

    private fun configureFragment() {
        var fragment =
            supportFragmentManager.findFragmentById(R.id.activity_search_container) as SearchRepoFragment?
        if (fragment == null) {
             fragment = SearchRepoFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.activity_search_container, fragment)
                .commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return configureToolbar(menu)
    }



    private fun configureToolbar(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        val searchItem = menu?.findItem(R.id.action_search)
        val searchView = searchItem?.actionView as? SearchView
        return true
    }
}
