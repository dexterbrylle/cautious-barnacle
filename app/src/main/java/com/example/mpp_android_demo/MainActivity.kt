package com.example.mpp_android_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import sample.hello
import Accounts.AccountsResponse
import Accounts.GetAccountsTask
import Accounts.TestAccountsResponse
import Presenter.AccountState
import Presenter.AccountView
import android.provider.Settings
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*

abstract class MainActivity : AppCompatActivity(), CoroutineScope,  AccountView{
    private val accountsList: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.recycler_view_1)
    }

    override fun showState(state: AccountState) {}
}