package com.example.m4l8t5.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.m4l8t5.R
import com.example.m4l8t5.activity.MainActivity
import com.example.m4l8t5.adapter.UserAdapter


class UserListFragment : Fragment() {

    private val mainActivity: MainActivity = MainActivity()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_user_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.rv_user)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = UserAdapter(mainActivity.prepareUserList())
        }

    }

}