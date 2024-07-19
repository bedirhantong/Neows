package com.bedirhan.neows.feature.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bedirhan.neows.databinding.FragmentHomeBinding
import com.bedirhan.neows.feature.listnews.presentation.adapter.ArticleAdapter
import com.bedirhan.neows.feature.listnews.presentation.viewmodel.NewsListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: NewsListViewModel by viewModels()
    private val recyclerAdapter: ArticleAdapter by lazy {
        ArticleAdapter()
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
        setupRecyclerView()
        observeViewModel()
        viewModel.getTopHeadlines()
    }

    private fun setupRecyclerView() {
        binding.recyclerviewHome.apply {
            adapter = recyclerAdapter
        }
    }

    private fun observeViewModel() {
        viewModel.articlesLiveData.observe(viewLifecycleOwner) { articles ->
            recyclerAdapter.submitList(articles)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}