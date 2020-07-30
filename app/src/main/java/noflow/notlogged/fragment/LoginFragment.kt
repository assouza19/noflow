package noflow.notlogged.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.br.noflow.R
import kotlinx.android.synthetic.main.fragment_login.*
import noflow.notlogged.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private val viewModel by viewModel<MainViewModel>()

    private val controller by lazy {
        findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btnConfirm.setOnClickListener {
//            if(viewModel.verifyRegister()) {
                controller.navigate(R.id.action_loginFragment_to_mainLoggedActivity)
//            }
        }

        btnWithoutRegister.setOnClickListener {
            controller.navigate(R.id.action_loginFragment_to_mainLoggedActivity)
        }
    }
}