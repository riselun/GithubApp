package io.github.aaron.github.ui.search


import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import io.github.aaron.github.R
import io.github.aaron.github.api.NetworkState
import io.github.aaron.github.base.BaseFragment
import io.github.aaron.github.common.SimpleImageLoader
import io.github.aaron.github.extensions.onQueryTextChange
import io.github.aaron.github.ui.search.views.SearchAdapter
import io.github.aaron.github.ui.search.views.SearchNetworkStateViewHolder
import org.koin.android.viewmodel.ext.android.viewModel
import kotlinx.android.synthetic.main.fragment_search.fragment_search_user_empty_list_button as emptyListButton
import kotlinx.android.synthetic.main.fragment_search.fragment_search_user_empty_list_image as emptyListImage
import kotlinx.android.synthetic.main.fragment_search.fragment_search_empty_list_title as emptyListTitle
import kotlinx.android.synthetic.main.fragment_search.fragment_search_user_progress as progressBar
import kotlinx.android.synthetic.main.fragment_search.fragment_search_user_rv as recyclerView

/**
 * 搜索仓库fragment
 */
class SearchRepoFragment : BaseFragment(), SearchNetworkStateViewHolder.OnClickListener {

    private val viewModel: SearchViewModel by viewModel()
    private lateinit var adapter: SearchAdapter

    override fun getLayoutId(): Int = R.layout.fragment_search

    override fun init() {
        configureRecyclerView()
        configureObservables()
        configureOnClick()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        configureMenu(menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onClickRetry() {
        viewModel.retryFailedRequest()
    }

    override fun whenListIsUpdated(size: Int, networkState: NetworkState?) {
        updateUIWhenLoading(size, networkState)
        updateUIWhenEmptyList(size, networkState)
    }

    private fun configureOnClick() {
        emptyListButton.setOnClickListener { viewModel.refreshAllList() }
    }

    private fun configureMenu(menu: Menu) {
        val searchMenuItem = menu.findItem(R.id.action_search)
        val possibleExistingQuery = viewModel.getCurrentQuery()
        val searchView = searchMenuItem.actionView as SearchView
        if (possibleExistingQuery != null && !possibleExistingQuery.isEmpty()) {
            searchMenuItem.expandActionView()
            searchView.setQuery(possibleExistingQuery, false)
            searchView.clearFocus()
        }
        searchView.onQueryTextChange {
            viewModel.fetchRepoByName(it)
        }
    }

    private fun configureRecyclerView() {
        adapter = SearchAdapter(this)
        recyclerView.adapter = adapter
    }

    private fun configureObservables() {
        viewModel.networkState?.observe(this, Observer { adapter.updateNetworkState(it) })
        viewModel.repos.observe(this, Observer { adapter.submitList(it) })
    }

    private fun updateUIWhenEmptyList(size: Int, networkState: NetworkState?) {
        emptyListImage.visibility = View.GONE
        emptyListButton.visibility = View.GONE
        emptyListTitle.visibility = View.GONE
        if (size == 0) {
            when (networkState) {
                NetworkState.SUCCESS -> {
                    SimpleImageLoader.loadImage(R.drawable.ic_directions_run_black_24dp, emptyListImage)
                    emptyListTitle.text = getString(R.string.no_result_found)
                    emptyListImage.visibility = View.VISIBLE
                    emptyListTitle.visibility = View.VISIBLE
                    emptyListButton.visibility = View.GONE
                }
                NetworkState.FAILED -> {
                    SimpleImageLoader.loadImage(R.drawable.ic_healing_black_24dp, emptyListImage)
                    emptyListTitle.text = getString(R.string.empty_hint)
                    emptyListImage.visibility = View.VISIBLE
                    emptyListTitle.visibility = View.VISIBLE
                    emptyListButton.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun updateUIWhenLoading(size: Int, networkState: NetworkState?) {
        progressBar.visibility =
            if (size == 0 && networkState == NetworkState.RUNNING) View.VISIBLE else View.GONE
    }

}
