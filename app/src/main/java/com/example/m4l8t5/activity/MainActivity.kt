package com.example.m4l8t5.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.m4l8t5.R
import com.example.m4l8t5.adapter.ViewPagerAdapter
import com.example.m4l8t5.fragment.ContactListFragment
import com.example.m4l8t5.fragment.PostListFragment
import com.example.m4l8t5.fragment.UserListFragment
import com.example.m4l8t5.model.Contact
import com.example.m4l8t5.model.Post
import com.example.m4l8t5.model.User
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var viewPagerAdapter: PagerAdapter
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {
        viewPager = findViewById(R.id.viewpager)
        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)


        (viewPagerAdapter as ViewPagerAdapter).add(ContactListFragment(), "Contacts")
        (viewPagerAdapter as ViewPagerAdapter).add(UserListFragment(), "Users")
        (viewPagerAdapter as ViewPagerAdapter).add(PostListFragment(), "Posts")


        viewPager.adapter = viewPagerAdapter

        tabLayout = findViewById(R.id.tab_layout)
        tabLayout.setupWithViewPager(viewPager)
    }

    fun call(number: String) {

    }

    fun prepareContactList(): List<Contact> {
        val contacts: ArrayList<Contact> = ArrayList()
        for (i in 0..25) contacts.add(Contact(R.drawable.ic_user, "Shodiyor Xurramov", "+998 99 266 79 67"))
        return contacts
    }

    fun prepareUserList(): List<User> {
        val users: ArrayList<User> = ArrayList()
        for (i in 0..25) users.add(User(R.drawable.ic_user, "Shodiyor Xurramov", "@shodiyor"))
        return users
    }

    fun preparePostList(): List<Post> {
        val posts: ArrayList<Post> = ArrayList()
        for (i in 0..25) posts.add(Post(R.drawable.anonim_image, "shodiyor", "MFaktor", R.drawable.anonim_image))
        return posts
    }

}