package ru.sandroisu.vk_agent.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.github.rahatarmanahmed.cpv.CircularProgressView
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import ru.sandroisu.vk_agent.R
import ru.sandroisu.vk_agent.presenters.LoginPresenter
import ru.sandroisu.vk_agent.views.LoginView

class LoginActivity : MvpAppCompatActivity(), LoginView {
    private lateinit var mTxtLoginHello: TextView
    private lateinit var mBtnEnter: Button
    private lateinit var mCpvWait: CircularProgressView

    @InjectPresenter
    lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTxtLoginHello = findViewById(R.id.txt_login_hello)
        mBtnEnter = findViewById(R.id.btn_login)
        mCpvWait = findViewById(R.id.cpv_login)
        mBtnEnter.setOnClickListener { loginPresenter.login(isSuccess = true) }

    }


    override fun startLoading() {
        mBtnEnter.visibility = View.GONE
        mCpvWait.visibility = View.VISIBLE
    }

    override fun openFriends() {
       startActivity(Intent(applicationContext, FriendsActivity::class.java))
    }

    override fun endLoading() {
        mBtnEnter.visibility = View.VISIBLE
        mCpvWait.visibility = View.GONE
    }

    override fun showError(text: String) {
        Toast.makeText(applicationContext, text, Toast.LENGTH_LONG).show()
    }
}