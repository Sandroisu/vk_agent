package ru.sandroisu.vk_agent.providers

import android.os.Handler
import android.os.Looper
import ru.sandroisu.vk_agent.R
import ru.sandroisu.vk_agent.models.FriendModel
import ru.sandroisu.vk_agent.presenters.FriendsPresenter

class FriendsProvider(var presenter:FriendsPresenter) {

    fun testLoadFriends(hasFriends: Boolean){
        Handler(Looper.getMainLooper()).postDelayed({
            val friendList:ArrayList<FriendModel> = ArrayList()
            if (hasFriends){
                val friend1 = FriendModel("Ivan", "Petrov",
                    null, R.drawable.ic_baseline_supervised_user_circle_24, true)
                val friend2 = FriendModel("Egor", "Egorov",
                    null, R.drawable.ic_baseline_supervised_user_circle_24, true)
                val friend3 = FriendModel("Serega", "Pavlov",
                    null, R.drawable.ic_baseline_supervised_user_circle_24, false)
                friendList.add(friend1)
                friendList.add(friend2)
                friendList.add(friend3)
            }else{

            }
            presenter.friendsLoaded(friendsList = friendList)
        }, 2000)
    }
}