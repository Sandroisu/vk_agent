package ru.sandroisu.vk_agent.activities

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.rahatarmanahmed.cpv.CircularProgressView
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import ru.sandroisu.vk_agent.R
import ru.sandroisu.vk_agent.adapters.FriendsAdapter
import ru.sandroisu.vk_agent.models.FriendModel
import ru.sandroisu.vk_agent.presenters.FriendsPresenter
import ru.sandroisu.vk_agent.views.FriendsView

class FriendsActivity : MvpAppCompatActivity(), FriendsView {
    private lateinit var etSearch: EditText
    private lateinit var mRvFriends: RecyclerView
    private lateinit var mTxtNoItems: TextView
    private lateinit var mCpvWait: CircularProgressView

    @InjectPresenter
    lateinit var friendsPresenter: FriendsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends)
        etSearch = findViewById(R.id.friends_search)
        etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (mRvFriends.adapter is FriendsAdapter) {
                    (mRvFriends.adapter as FriendsAdapter).filter(s.toString())
                }
            }

        })
        mRvFriends = findViewById(R.id.friends_list)
        mTxtNoItems = findViewById(R.id.friends_no_items)
        mCpvWait = findViewById(R.id.friends_loader)
        friendsPresenter.loadFriends()
    }

    override fun showError(text: String) {
        mTxtNoItems.visibility = View.VISIBLE
        mTxtNoItems.text = text
    }

    override fun setupEmptyList() {
        mRvFriends.visibility = View.GONE
        mTxtNoItems.visibility = View.VISIBLE
    }

    override fun startLoading() {
        mRvFriends.visibility = View.GONE
        mTxtNoItems.visibility = View.GONE
        mCpvWait.visibility = View.VISIBLE
    }

    override fun stopLoading() {
        mCpvWait.visibility = View.GONE
    }

    override fun setupFriendsList(friendsList: ArrayList<FriendModel>) {
        mRvFriends.visibility = View.VISIBLE
        mRvFriends.layoutManager = LinearLayoutManager(applicationContext)
        mRvFriends.setHasFixedSize(true)
        val adapter = FriendsAdapter()
        adapter.setFriendList(friendsList)
        mRvFriends.adapter = adapter
        mTxtNoItems.visibility = View.GONE
    }

}