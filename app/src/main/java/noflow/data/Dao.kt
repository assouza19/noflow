package noflow.data

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class Dao {

    private val database = Firebase.getDatabase()

    fun getUsers(callback: (Users?) -> Unit) {
        database.addValueEventListener(object: ValueEventListener {
            override fun onCancelled(error: DatabaseError) {}

            override fun onDataChange(snapshot: DataSnapshot) {
                for(data in snapshot.children) {
                    val users = data.getValue(Users::class.java)
                    callback(users)
                }
            }

        })
    }

    fun saveUsers(users: Users) {
        database.child("users").setValue(users)
    }
}