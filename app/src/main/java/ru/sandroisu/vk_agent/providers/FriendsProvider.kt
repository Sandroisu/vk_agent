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
                    null, R.drawable.lingerie_5286478_640, true)
                val friend2 = FriendModel("Egor", "Egorov",
                    null, "https://icdn.lenta.ru/images/2020/03/19/19/20200319193108072/pic_78f9bed8a525f230f91a6245f3c63fe8.jpg", true)
                val friend3 = FriendModel("Serega", "Pavlov",
                    null, "https://globalmsk.ru/usr/person/big-person-15661342871.jpg", false)
                friendList.add(friend1)
                friendList.add(friend2)
                friendList.add(friend3)
            }else{

            }
            presenter.friendsLoaded(friendsList = friendList)
        }, 2000)
    }
}