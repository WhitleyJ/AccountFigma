package com.account.accountfigma.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.account.accountfigma.domain.model.User
import com.account.accountfigma.domain.repository.UserRepository
import com.github.javafaker.Faker
import javax.inject.Inject
import kotlin.random.Random

class UserListRepositoryImpl @Inject constructor(listImages: ListImage) : UserRepository {

    private val userListLD = MutableLiveData<List<User>>()
    private val usersList = sortedSetOf<User>({ o1, o2 -> o1.id compareTo (o2.id) })
    private var autoIncrementId = 0

    init {
        val faker = Faker.instance()
        for (i in 0 until 40) {
            listImages.imagesList.shuffle()
            val user =
                User(name = faker.name().name().trimEnd(),
                    image = listImages.imagesList[i % listImages.imagesList.size],
                    subscribed = Random.nextBoolean())
            addUser(user)
        }
    }

    override fun getUserList(): LiveData<List<User>> {
        return userListLD
    }

    override fun getUser(userId: Int): User {
        return (usersList.find { it.id == userId }
            ?: throw RuntimeException("Element with id $userId not found"))
    }


    override fun editUser(user: User) {
        val oldElement = getUser(user.id)
        usersList.remove(oldElement)
        usersList.add(user)
        updateList()
    }

    private fun addUser(user: User) {
        if (user.id == User.UNDEFINED_ID) {
            user.id = autoIncrementId++
        }
        usersList.add(user)
        updateList()
    }

    private fun updateList() {
        userListLD.value = usersList.toList()
    }
}