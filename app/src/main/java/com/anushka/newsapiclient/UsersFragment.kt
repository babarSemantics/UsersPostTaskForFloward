package com.anushka.newsapiclient

import android.R.attr.key
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import com.anushka.newsapiclient.data.util.Resource
import com.anushka.newsapiclient.databinding.FragmentUserBinding
import com.anushka.newsapiclient.presentation.adapter.UsersAdapter
import com.anushka.newsapiclient.presentation.viewmodel.UserViewModel


class UsersFragment : Fragment() {
    private  lateinit var viewModel: UserViewModel
    private lateinit var usersAdapter: UsersAdapter
    private lateinit var fragmentUserBinding: FragmentUserBinding
    private var isLoading = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentUserBinding = FragmentUserBinding.bind(view)
        viewModel= (activity as MainActivity).viewModel
        usersAdapter= (activity as MainActivity).usersAdapter
        val fragment = PostsFragment()
        val bundle = Bundle()
        usersAdapter.setOnItemClickListener {
            bundle.putString("user", it.url)
            bundle.putInt("userId", it.userId)
            fragment.arguments = bundle
            parentFragmentManager.commit {
                replace(R.id.container, fragment)
                addToBackStack(fragment::class.java.name)
            }
//            requireActivity().supportFragmentManager.beginTransaction().add(R.id.container, UsersFragment(),
//                bundle).commit()
        }
        initRecyclerView()
        getUsers()
        observers()
    }

    ///// hitting api call from view model
    private fun getUsers() {
        viewModel.getUsers()

    }

    private fun observers() {

        ///// get user observer////

        viewModel.usersLiveData.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {

                    hideProgressBar()
                    response.data?.let {
                        Log.i("MYTAG", "came here ${it.toList().size}")
                        usersAdapter.differ.submitList(it.toList())
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let {
                        Toast.makeText(activity, "An error occurred : $it", Toast.LENGTH_LONG)
                            .show()
                    }
                }

                is Resource.Loading -> {
                    showProgressBar()
                }

            }
        }
    }

    private fun initRecyclerView() {
        fragmentUserBinding.rvUser.apply {
            layoutManager = LinearLayoutManager(activity)
            fragmentUserBinding.rvUser.adapter = usersAdapter
        }

    }

    private fun showProgressBar(){
        isLoading = true
        fragmentUserBinding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar(){
        isLoading = false
        fragmentUserBinding.progressBar.visibility = View.INVISIBLE
    }
}
















