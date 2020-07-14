package com.example.mpp_android_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import sample.hello
import Accounts.AccountsResponse
import Accounts.GetAccountsTask
import Accounts.TestAccountsResponse
import Accounts.TestGetAccountsTask
import android.provider.Settings
import android.widget.Toast
import kotlinx.coroutines.*

abstract class MainActivity : AppCompatActivity(), CoroutineScope {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            val getAccountsTask = TestGetAccountsTask()
            val job = Job()
            val coroutineScope: CoroutineScope = CoroutineScope(job + Dispatchers.IO)

            coroutineScope.launch {
                val result = withContext(Dispatchers.IO) { getAccountsTask.callGetAccountsService() }
                when ((result as TestAccountsResponse).result) {
                    "OK" -> {
                        val response = result;
                        textView2.setText(response.data[0].accountId.toString())
                    }
                }
            }
        } catch (e: Exception) {
            Toast.makeText(this, "$e.message", Toast.LENGTH_SHORT).show()
        }

    }
}