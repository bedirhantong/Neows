package com.bedirhan.neows.feature.listnews.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bedirhan.neows.databinding.FragmentHomeBinding
import com.bedirhan.neows.feature.listnews.presentation.adapter.NewsAdapter
import dagger.hilt.android.AndroidEntryPoint
import com.google.android.material.tabs.TabLayout

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()
    private val recyclerAdapter: NewsAdapter by lazy {
        NewsAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeNewsRecyclerView()
        configureCategoryTabs()
    }

    private fun initializeNewsRecyclerView() {
        binding.recyclerviewHome.adapter = recyclerAdapter
        applyChangesOnRecycleView()
        viewModel.getNewsByCategory("general")
    }

    private fun configureCategoryTabs() {
        binding.categoriesTabLayout.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    val category = tab.text.toString()
                    viewModel.getNewsByCategory(category)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.let {}
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    private fun applyChangesOnRecycleView() {
        viewModel.articlesLiveData.observe(viewLifecycleOwner) { articles ->
            recyclerAdapter.submitList(articles)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
