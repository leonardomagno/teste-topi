package com.example.testetopi.ui.repositorieslist

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testetopi.R
import com.example.testetopi.base.BaseListAdapterInterface
import com.example.testetopi.gone
import com.example.testetopi.models.RepositoryVO
import com.example.testetopi.models.enums.ViewStatus
import com.example.testetopi.viewmodels.ViewModelFactory
import com.example.testetopi.visible
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class RepositoriesListActivity : DaggerAppCompatActivity(),
    BaseListAdapterInterface.OnItemClickListener {

    //View Model
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    val repositoriesListViewModel by viewModels <RepositoriesListViewModel>{ viewModelFactory }

    //views
    private lateinit var viewLoading: View

    //RecyclerView
    private lateinit var recyclerView: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager
    private var repositoryListAdapter: RepositoryListAdapter? = null

    //Parâmetros para chamada da lista de repositórios
    private val q = "language:Java"
    private val sort = "stars"
    private var currentPage = 1
    private var dataList = ArrayList<RepositoryVO>()
    private var isRecyclerLoading = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.repositories_list_activity)

        repositoryListAdapter = RepositoryListAdapter()

        changeStatusBarColor()
        setupRecyclerView()
        setupView()
        applyObserver()
        repositoriesListViewModel.repositoriesList(
            q = q,
            sort = sort,
            page = currentPage.toString()
        )
    }

    private fun setupView() {
        viewLoading = findViewById(R.id.activity_repositories_list_loading)

        repositoryListAdapter?.itemClickListener = this
    }

    private fun setupRecyclerView() {
        recyclerView = findViewById(R.id.activity_repositories_list_recyclerview)
        linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = repositoryListAdapter
        }
        addscrolllistener()
    }

    private fun applyObserver() {
        repositoriesListViewModel.liveDataRepository.observe(this, Observer { viewData ->
            when (viewData.viewStatus) {
                ViewStatus.SUCCESS -> {
                    isRecyclerLoading = false
                    viewLoading.gone()
                    dataList.addAll(viewData.data ?: emptyList())
                    if (!dataList.isNullOrEmpty()) {
                        repositoryListAdapter?.submitList(dataList)
                        repositoryListAdapter?.notifyDataSetChanged()
                    }
                    Log.d("Teste", "${repositoryListAdapter?.currentList}")
                }
                ViewStatus.LOADING -> {
                    viewLoading.visible()
                }
                ViewStatus.ERROR -> {
                    isRecyclerLoading = false
                    Toast.makeText(
                        this,
                        "Não foi possível estabelecer uma conexão.",
                        Toast.LENGTH_LONG
                    ).show()
                    viewLoading.gone()
                }
            }
        })
    }

    fun changeStatusBarColor() {
        val window: Window = this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(
                this,
                R.color.dark_gray
            )
        }
    }

    private fun addscrolllistener() {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (!isRecyclerLoading
                    && linearLayoutManager.findLastCompletelyVisibleItemPosition() == repositoryListAdapter?.currentList?.size!! - 2
                ) {
                    isRecyclerLoading = true
                    currentPage++
                    repositoriesListViewModel.repositoriesList(
                        q = q,
                        sort = sort,
                        page = currentPage.toString()
                    )
                }
            }
        })

    }

    override fun onItemClick(position: Int, view: View) {
        Toast.makeText(this, "Item Clicado", Toast.LENGTH_LONG).show()
    }
}
