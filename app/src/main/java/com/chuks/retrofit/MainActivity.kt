package com.chuks.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.chuks.retrofit.UI.MainViewModel
import com.chuks.retrofit.UI.UserAdapter
import com.chuks.retrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userAdapter: UserAdapter
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userAdapter = UserAdapter(listOf())
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.userRv.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        viewModel.run{
            getUsers()
            usersLiveData.observe(this@MainActivity, {users ->
                userAdapter.users = users
                userAdapter.notifyDataSetChanged()
            })
        }
    }
}