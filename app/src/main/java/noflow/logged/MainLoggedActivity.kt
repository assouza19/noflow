package noflow.logged

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.br.noflow.R
import kotlinx.android.synthetic.main.activity_main_logged.*

class MainLoggedActivity : AppCompatActivity() {

    private val controller by lazy {
        findNavController(R.id.nav_host_logged_fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_logged)
        setSupportActionBar(toolbar)

        bottom_navigation_view.setupWithNavController(controller)
    }
}