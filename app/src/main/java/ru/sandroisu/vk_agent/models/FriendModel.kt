package ru.sandroisu.vk_agent.models


class FriendModel(
    var name: String,
    var surname: String,
    var city: String?,
    var avatar: Any?,
    var isOnline: Boolean
)