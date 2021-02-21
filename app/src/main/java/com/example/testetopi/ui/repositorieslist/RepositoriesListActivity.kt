package com.example.testetopi.ui.repositorieslist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testetopi.R
import com.example.testetopi.base.BaseListAdapterInterface
import com.example.testetopi.gone
import com.example.testetopi.models.enums.ViewStatus
import com.example.testetopi.visible
import java.util.ArrayList

class RepositoriesListActivity : AppCompatActivity() {

    private val repositoryListAdapter = RepositoryListAdapter()

    private lateinit var repositoriesListViewModel: RepositoriesListViewModel
    private lateinit var viewLoading: View

    //Parâmetros para chamada da lista de repositórios
    private val q = "language:Java"
    private val sort = "stars"
    private val page = "1"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.repositories_list_activity)

        repositoriesListViewModel = ViewModelProvider(this).get(RepositoriesListViewModel::class.java)

        changeStatusBarColor()
        setupRecyclerView()
        setupView()
        applyObserver()
        repositoriesListViewModel.repositoriesList(q = q, sort = sort, page = page)
    }

    private fun setupView() {
        viewLoading = findViewById(R.id.activity_repositories_list_loading)
    }

    private fun setupRecyclerView() {
        findViewById<RecyclerView>(R.id.activity_repositories_list_recyclerview)?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            layoutManager = layoutManager
            adapter = repositoryListAdapter
        }
    }

    private fun applyObserver() {
        repositoriesListViewModel.liveDataRepository.observe(this, Observer { viewData ->
            when (viewData.viewStatus) {
                ViewStatus.SUCCESS -> {
                    viewLoading.gone()
                    val list = viewData.data
                    if (!list.isNullOrEmpty()) repositoryListAdapter.submitList(list)
                }
                ViewStatus.LOADING -> {
                    viewLoading.visible()
                }
                ViewStatus.ERROR -> {
                    Toast.makeText(this, "Não foi possível estabelecer uma conexão.", Toast.LENGTH_LONG).show()
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
            window.statusBarColor = ContextCompat.getColor(this,
                R.color.dark_gray
            )
        }
    }
}