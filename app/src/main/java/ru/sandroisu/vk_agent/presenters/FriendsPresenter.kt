package ru.sandroisu.vk_agent.presenters

import moxy.InjectViewState
import moxy.MvpPresenter
import ru.sandroisu.vk_agent.models.FriendModel
import ru.sandroisu.vk_agent.providers.FriendsProvider
import ru.sandroisu.vk_agent.views.FriendsView

@InjectViewState
class FriendsPresenter:MvpPresenter<FriendsView>() {
    fun loadFriends() {
        viewState.startLoading()
        FriendsProvider(presenter = this).testLoadFriends(hasFriends = true)
    }
    fun friendsLoaded(friendsList:ArrayList<FriendModel>){
        viewState.stopLoading()
        if (friendsList.count() == 0){
            viewState.setupEmptyList()
            viewState.showError(text = "You have no friends")
        }else{
            viewState.setupFriendsList(friendsList)
        }
    }

}