package ru.sandroisu.vk_agent.activities

import android.os.Bundle
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
    private lateinit var etSearch:EditText;
    private lateinit var rvFriendsList:RecyclerView;
    private lateinit var tvError:TextView;
    private lateinit var progress:CircularProgressView;

    @InjectPresenter
    lateinit var friendsPresenter: FriendsPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends)
        etSearch = findViewById(R.id.friends_search)
        rvFriendsList = findViewById(R.id.friends_list)
        tvError = findViewById(R.id.friends_no_items)
        progress = findViewById(R.id.friends_loader)
        friendsPresenter.loadFriends()
    }

    override fun showError(text: String) {
        tvError.visibility = View.VISIBLE
        tvError.text = text
    }

    override fun setupEmptyList() {
        rvFriendsList.visibility = View.GONE
        tvError.visibility = View.VISIBLE
    }

    override fun startLoading() {
        rvFriendsList.visibility = View.GONE
        tvError.visibility = View.GONE
        progress.visibility = View.VISIBLE
    }

    override fun stopLoading() {
        progress.visibility = View.GONE
    }

    override fun setupFriendsList(friendsList: ArrayList<FriendModel>) {
        rvFriendsList.visibility = View.VISIBLE
        rvFriendsList.layoutManager = LinearLayoutManager(applicationContext)
        rvFriendsList.adapter = FriendsAdapter(friendsList)
        tvError.visibility = View.GONE
    }

}